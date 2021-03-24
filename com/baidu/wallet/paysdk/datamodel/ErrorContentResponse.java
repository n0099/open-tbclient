package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.q;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class ErrorContentResponse implements Serializable {
    public static final String NEED_UPDATE = "1";
    public static final String PAY_BY_SMS_DISABLE = "0";
    public static final String PAY_BY_SMS_ENABLE = "1";
    public static final long serialVersionUID = 1572006194091664237L;
    public GetCardInfoResponse.CardItemRequired card_item_required;
    public GetCardInfoResponse.CertificateTypeInfo[] certificate_type_info;
    public Guidance guidance;
    public String hint_sms;
    public MktSolution mkt_solution;
    public String need_cvv2;
    public String need_identity_code;
    public String need_identity_type;
    public String need_other_pay_method = "0";
    public String need_phone_num;
    public String need_send_sms;
    public String need_valid_date;
    public String order_amount;
    public String use_vcode_to_pay;
    public Verify verify;

    /* loaded from: classes5.dex */
    public static class CardInfoCheck implements Serializable {
        public String card_no;
        public String certicicate_code;
        public String verify_code;
    }

    /* loaded from: classes5.dex */
    public static class Guidance implements Serializable {
        public Operations[] operations;
        public String prompt_body;
        public String prompt_head;

        public boolean isGuidanceAvilable() {
            Operations[] operationsArr;
            boolean z = (TextUtils.isEmpty(this.prompt_body) || (operationsArr = this.operations) == null || operationsArr.length <= 0) ? false : true;
            if (z) {
                for (Operations operations : this.operations) {
                    z = operations.isOperationAvilable();
                    if (!z) {
                        break;
                    }
                }
                return z;
            }
            return z;
        }
    }

    /* loaded from: classes5.dex */
    public static class MktSolution implements Serializable {
        public static final long serialVersionUID = 1;
        public PayData.Discount[] activity_list;
        public String balance_amount;
        public PayData.Coupon[] coupon_list;
        public String easypay_amount;

        public String toString() {
            return "& easypay_amount = " + this.easypay_amount;
        }
    }

    /* loaded from: classes5.dex */
    public static class Operations implements Serializable {
        public static final String BIND_OTHER_CARDS = "bind_other_cards";
        public static final String CALL_UP = "call_up";
        public static final String CASHDESK_CLOSE = "cashdesk_close";
        public static final String CHANGE_PAYTYPE = "change_paytype";
        public static final String FIND_PWD = "find_pwd";
        public static final String HELP_CENTER = "help_center";
        public static final String LIVING_AGAIN = "living_again";
        public static final String NOTICE = "notice";
        public static final String RETRY_PAY = "retry_pay";
        public static final String SEND_SMS = "send_sms";
        public transient Map<String, q> handlers = new HashMap();
        public String hint;
        public String jump_uri;
        public String mobile;
        public String need_close;
        public String type;

        public boolean equals(Object obj) {
            return (obj instanceof Operations) && TextUtils.equals(((Operations) obj).type, this.type);
        }

        public q getAction() {
            if (NOTICE.equals(this.type)) {
                return new q<Operations, Context>() { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.wallet.paysdk.beans.q
                    public void a(Operations operations, Context context) {
                    }
                };
            }
            if (CALL_UP.equals(this.type)) {
                return new q<Operations, Context>() { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.wallet.paysdk.beans.q
                    public void a(Operations operations, Context context) {
                        try {
                            String str = operations.mobile;
                            context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                };
            }
            if (CASHDESK_CLOSE.equals(this.type)) {
                return new q<Operations, Context>() { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.wallet.paysdk.beans.q
                    public void a(Operations operations, Context context) {
                        PayCallBackManager.callBackClientPaying(context);
                    }
                };
            }
            if (HELP_CENTER.equals(this.type)) {
                return new q<Operations, Context>() { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.wallet.paysdk.beans.q
                    public void a(Operations operations, final Context context) {
                        if (context == null || operations == null || TextUtils.isEmpty(operations.jump_uri)) {
                            return;
                        }
                        BaiduWalletDelegate.getInstance().openH5Module(context, Operations.this.jump_uri, false);
                        if ("1".equals(Operations.this.need_close)) {
                            PayStatisticsUtil.onEvent(StatServiceEvent.EVENT_PAY_TIMEOUT_GUIDANCE_TO_ORDER_DETAIL, PayDataCache.getInstance().getInsideTransOrder());
                            new Handler().postDelayed(new Runnable() { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    PayCallBackManager.callBackClientPaying(context);
                                }
                            }, 20L);
                        }
                    }
                };
            }
            if (FIND_PWD.equals(this.type)) {
                return new q<Operations, Context>() { // from class: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Operations.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.wallet.paysdk.beans.q
                    public void a(Operations operations, Context context) {
                        if (context instanceof PwdPayActivity) {
                            ((PwdPayActivity) context).forgetPassword();
                        } else if (context instanceof PwdCheckActivity) {
                            ((PwdCheckActivity) context).forgetPasswd(PayRequestCache.BindCategory.Other.name());
                        }
                    }
                };
            }
            return this.handlers.get(this.type);
        }

        public String getActionName() {
            return this.hint;
        }

        public boolean isOperationAvilable() {
            return (TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.hint)) ? false : true;
        }

        public void registerActionHandler(String str, q qVar) {
            this.handlers.put(str, qVar);
        }
    }

    /* loaded from: classes5.dex */
    public static class Verify implements Serializable {
        public static final String VERIFY_CARD_NO = "card_no";
        public static final String VERIFY_CETIFICATE_CODE = "certificate_code";
        public static final String VERIFY_CVV2 = "verify_code";
        public static final long serialVersionUID = 1747811045878020816L;
        public String[] card_item_required;
        public String card_item_required_msg;
        public String mobile_ec;
        public String sms_length;
        public String sms_pattern;
        public String sms_type;
        public String type;
        public String voice_msg;

        public String getVerifyMobile() {
            return this.mobile_ec;
        }

        public String getVerifyType() {
            return this.type;
        }

        public String getVoiceMsg() {
            return this.voice_msg;
        }
    }

    public boolean isNeedId() {
        return needUpdate(this.need_identity_code);
    }

    public boolean isNeedPhoneNum() {
        return needUpdate(this.need_phone_num);
    }

    public boolean isNeedSendSms() {
        return needUpdate(this.need_send_sms);
    }

    public boolean isNeedType() {
        return needUpdate(this.need_identity_type);
    }

    public boolean isNeedValidCode() {
        return needUpdate(this.need_cvv2);
    }

    public boolean isNeedValidDate() {
        return needUpdate(this.need_valid_date);
    }

    public boolean needUpdate(String str) {
        return !TextUtils.isEmpty(str) && "1".equals(str);
    }
}
