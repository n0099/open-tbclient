package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultCashbackDetail;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class QueryPayResponse implements IBeanResponse, Serializable {
    public AuthorizeInfo authorize_info;
    public Business business;
    public String cash_amount;
    public PayResultCashbackDetail cashback_dialog_detail;
    public Compliance compliance;
    public String coupon_find_prompt;
    public String coupon_msg;
    public PayResultContent.CrossMarket cross_market;
    public String discount_amount;
    public String[][] discount_info;
    public String discount_prefix;
    public String display_msg;
    public FeedbackInfo feedback_info;
    public String fp_open_or_update_msg;
    public String notify;
    public String order_prefix;
    public String pay_detail_info;
    public String paytype_desc;
    public String[][] paytype_info;
    public String redirect_sp_succpage_remain_time;
    public String score;
    public String score_tip;
    public String title_url;
    public String total_amount;
    public String trans_no;
    public String trans_state;

    /* loaded from: classes5.dex */
    public static class Business implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public String expected_time;
        public String stream_recharge_msg;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return !TextUtils.isEmpty(this.trans_state);
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
