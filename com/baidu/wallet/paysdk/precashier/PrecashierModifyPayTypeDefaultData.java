package com.baidu.wallet.paysdk.precashier;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes5.dex */
public class PrecashierModifyPayTypeDefaultData implements Serializable {
    public static final long serialVersionUID = 1641263196639015824L;
    public String balance_amount;
    public Card card;
    public String defaultType;
    public int updated;

    /* loaded from: classes5.dex */
    public static class Card implements Serializable {
        public String account_no;
        public String bank_name;
        public String bank_url;
        public String day_limit;
        public String month_limit;
        public String single_limit;
        public String single_quota;
    }

    public String getBalance() {
        return this.balance_amount;
    }

    public Card getCard() {
        return this.card;
    }

    public PrecashierModifyPayTypeDefaultData getData() {
        return this;
    }

    public String getDefaultType() {
        return this.defaultType;
    }

    public String getOriginalHttpResponse() {
        PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse;
        JSONArray jSONArray;
        if (!"balance".equals(this.defaultType) && !"easypay".equals(this.defaultType)) {
            if (1 == this.updated) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("updated", "1");
                    if (this.card != null && !TextUtils.isEmpty(this.card.account_no)) {
                        jSONObject.put("account_no", this.card.account_no);
                    }
                    return jSONObject.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return "";
                }
            }
            return "";
        } else if (!PayDataCache.getInstance().isFromPreCashier() || (precashierModifyPayTypeResponse = PrecashierModifyPayTypeResponse.getInstance()) == null) {
            return "";
        } else {
            String originHttpResponse = precashierModifyPayTypeResponse.getOriginHttpResponse();
            if (TextUtils.isEmpty(originHttpResponse)) {
                return "";
            }
            try {
                JSONObject jSONObject2 = ((JSONObject) new JSONTokener(originHttpResponse).nextValue()).getJSONObject("pay");
                if (jSONObject2 != null) {
                    JSONObject jSONObject3 = null;
                    if ("balance".equals(this.defaultType)) {
                        jSONObject3 = jSONObject2.getJSONObject("balance");
                    } else {
                        JSONObject jSONObject4 = jSONObject2.getJSONObject("easypay");
                        if (jSONObject4 != null && (jSONArray = jSONObject4.getJSONArray("bind_card_arr")) != null) {
                            int length = jSONArray.length();
                            int i = 0;
                            while (true) {
                                if (i < length) {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                    if (optJSONObject != null && this.card.account_no.equals(optJSONObject.get("account_no"))) {
                                        jSONObject3 = optJSONObject;
                                        break;
                                    }
                                    i++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    if (jSONObject3 != null) {
                        jSONObject3.put("pay_type", this.defaultType);
                        jSONObject3.put("balance_amount", this.balance_amount);
                        jSONObject3.put("updated", Integer.toString(this.updated));
                        return jSONObject3.toString();
                    }
                    return "";
                }
                return "";
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
    }

    public boolean isNeedUpdate() {
        return this.updated == 1;
    }

    public void setBalance(String str) {
        this.balance_amount = str;
    }

    public void setDatas(String str, String str2, Card card) {
        this.defaultType = str;
        this.balance_amount = str2;
        this.card = card;
    }
}
