package com.baidu.wallet.paysdk.payresult.datamodel;

import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.paysdk.datamodel.Compliance;
import com.baidu.wallet.paysdk.datamodel.FeedbackInfo;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class PayResultContent implements Serializable {
    public static final String NOT_ENTER_PAYRESULT_PAGE = "0";
    public static final long serialVersionUID = 1;
    public String authorize_msg;
    public String cash_amount;
    public Compliance compliance;
    public String coupon_find_prompt;
    public String coupon_msg;
    public String create_time;
    public CrossMarket cross_market;
    public String discount_amount;
    public String[][] discount_info;
    public String discount_prefix;
    public String expected_time;
    public FeedbackInfo feedback_info;
    public String fp_open_or_update_msg;
    public boolean isPaySuccess;
    public String mErrorMsg;
    public String notify;
    public String order_no;
    public String order_prefix;
    public PayResultCashbackDetail payResultCashbackDetail;
    public String pay_detail_info;
    public String paytype_desc;
    public String[][] paytype_info;
    public String redirect_sp_succpage_remain_time;
    public String score;
    public String score_tip;
    public String seller_company;
    public String stream_recharge_msg;
    public String subtitle_msg;
    public String title_url;
    public String total_amount;
    public String trans_no;

    /* loaded from: classes5.dex */
    public static class CrossMarket implements NoProguard, Serializable {
        public String jump_url;
        public String pic_url;
    }
}
