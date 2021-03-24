package com.baidu.wallet.qrcodescanner.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class QRCodeShortUrlResponse implements IBeanResponse {
    public JSONObject err;
    public String link_addr;
    public JSONObject params;
    public String type;

    /* loaded from: classes5.dex */
    public static class OrderParam implements NoProguard, Serializable {
        public static final long serialVersionUID = -2948463218627097301L;
        public String bank_no;
        public String currency;
        public String expire_time;
        public String extra;
        public String goods_desc;
        public String goods_name;
        public String goods_url;
        public String input_charset;
        public String order_create_time;
        public String order_no;
        public String pay_type;
        public String profit_solution;
        public String return_url;
        public String service_code;
        public String sign;
        public String sign_method;
        public String sp_name;
        public String sp_no;
        public String sp_pass_through;
        public String sp_rcs;
        public String sp_uno;
        public String total_amount;
        public String transport_amount;
        public String unit_amount;
        public String unit_count;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
