package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
/* loaded from: classes5.dex */
public class PayResponse implements IBeanResponse {
    public String[][] account_bank_card;
    public AuthorizeInfo authorize_info;
    public String bank_no;
    public String order_no;
    public String pay_result_params;
    public String pay_result_url;
    public String[][] paytype_info;
    public String redirect_sp_succpage_remain_time;
    public String show_h5_result;
    public String sign_success_tips;
    public String title_url;
    public String update_mobile_desc;

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return !TextUtils.isEmpty(this.order_no) || (com.baidu.wallet.paysdk.a.b.a() && !TextUtils.isEmpty(this.sign_success_tips));
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public boolean toShowH5ResultPage() {
        return H5ResultParams.toShowH5ResultPage(this.redirect_sp_succpage_remain_time, this.pay_result_url, this.show_h5_result);
    }

    public String toString() {
        return "FastPayResult [order_no=" + this.order_no + PreferencesUtil.RIGHT_MOUNT;
    }
}
