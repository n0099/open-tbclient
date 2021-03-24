package com.baidu.wallet.qrcodescanner.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class QRCodeCollectionCodeDataParams implements NoProguard, Serializable {
    public PayeeParams payee_params;
    public PrecheckResult pre_check_result;

    /* loaded from: classes5.dex */
    public static class PayeeInfo implements NoProguard, Serializable {
        public String can_recv;
        public String notify_payee_mobile;
        public String notify_payee_mobile_back;
        public String payee_account_display;
        public String payee_can_check;
        public String payee_is_authod;
        public String payee_mobile;
        public String payee_recv_type;
        public String payee_true_name;
        public String payee_username;
        public String portrait_sign;
    }

    /* loaded from: classes5.dex */
    public static class PayeeParams implements NoProguard, Serializable {
        public String channelno;
        public String order_ext;
        public String rcv_remark;
        public String recv_amount;
    }

    /* loaded from: classes5.dex */
    public static class PrecheckResult implements NoProguard, Serializable {
        public TransferArriveInfo arrive_info;
        public PayeeInfo payee_info;
    }

    /* loaded from: classes5.dex */
    public static class TransferArriveInfo implements NoProguard, Serializable {
        public String arrive_explain;
        public TransferArriveType[] arrive_type;
        public String default_type_value;
        public String maintain_explain;

        /* loaded from: classes5.dex */
        public static class TransferArriveType implements NoProguard, Serializable {
            public String type_arrive_msg;
            public String type_arrive_msg_hl;
            public String type_name;
            public String type_value;
        }
    }
}
