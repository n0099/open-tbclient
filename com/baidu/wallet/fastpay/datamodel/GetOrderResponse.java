package com.baidu.wallet.fastpay.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
/* loaded from: classes5.dex */
public class GetOrderResponse implements IBeanResponse {
    public String mCreateTime;
    public String order_no;
    public String pay_desc = "";
    public String redirect_sp_succpage_remain_time = "1";
    public String url;

    private void a() {
        String[] split;
        if (TextUtils.isEmpty(this.url) || (split = this.url.split("&")) == null) {
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
        return (TextUtils.isEmpty(this.order_no) || TextUtils.isEmpty(this.url)) ? false : true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
