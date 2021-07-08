package com.baidu.wallet.paysdk.precashier;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* loaded from: classes5.dex */
public class PrecashierModifyPayTypeDefaultData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1641263196639015824L;
    public transient /* synthetic */ FieldHolder $fh;
    public String balance_amount;
    public Card card;
    public String defaultType;
    public int updated;

    /* loaded from: classes5.dex */
    public static class Card implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String account_no;
        public String bank_name;
        public String bank_url;
        public String day_limit;
        public String month_limit;
        public String single_limit;
        public String single_quota;

        public Card() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public PrecashierModifyPayTypeDefaultData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String getBalance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.balance_amount : (String) invokeV.objValue;
    }

    public Card getCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.card : (Card) invokeV.objValue;
    }

    public PrecashierModifyPayTypeDefaultData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this : (PrecashierModifyPayTypeDefaultData) invokeV.objValue;
    }

    public String getDefaultType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.defaultType : (String) invokeV.objValue;
    }

    public String getOriginalHttpResponse() {
        InterceptResult invokeV;
        PrecashierModifyPayTypeResponse precashierModifyPayTypeResponse;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
                                int i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                                        if (optJSONObject != null && this.card.account_no.equals(optJSONObject.get("account_no"))) {
                                            jSONObject3 = optJSONObject;
                                            break;
                                        }
                                        i2++;
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
        return (String) invokeV.objValue;
    }

    public boolean isNeedUpdate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.updated == 1 : invokeV.booleanValue;
    }

    public void setBalance(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.balance_amount = str;
        }
    }

    public void setDatas(String str, String str2, Card card) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, card) == null) {
            this.defaultType = str;
            this.balance_amount = str2;
            this.card = card;
        }
    }
}
