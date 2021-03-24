package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class GetTrafficOrderResponse implements IBeanResponse {
    public String cashierUrl;
    public String mCreateTime;
    public String orderNo;
    public Params params;

    /* loaded from: classes5.dex */
    public static class Params implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public String pay_desc;
        public String redirect_sp_succpage_remain_time;
    }

    private void a() {
        String[] split;
        if (TextUtils.isEmpty(this.cashierUrl) || (split = this.cashierUrl.split("&")) == null) {
            return;
        }
        for (String str : split) {
            if (str.contains("order_create_time")) {
                this.mCreateTime = str.substring(18);
            }
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        a();
        return (TextUtils.isEmpty(this.cashierUrl) || TextUtils.isEmpty(this.orderNo)) ? false : true;
    }

    public boolean isGotoResultActivity() {
        Params params = this.params;
        return params == null || TextUtils.isEmpty(params.redirect_sp_succpage_remain_time) || !this.params.redirect_sp_succpage_remain_time.equals("0");
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
