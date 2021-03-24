package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class QueryResponse implements IBeanResponse, Serializable {
    public String agreement_trans_id;
    public String dialog_hint;
    public Options[] dialog_options;
    public String dialog_title;
    public String form_data;
    public String form_url;
    public String sign_card_no;
    public int sign_state;
    public String toast_msg;
    public String webview_title;

    /* loaded from: classes5.dex */
    public static class Options implements Serializable {
        public static final String BIND_CARD = "bind_card";
        public static final String CANCEL = "cancel";
        public static final String CHANGE_PAYTYPE = "change_paytype";
        public static final String JUMP_RESIGN = "jump_resign";
        public static final String PAY = "pay";
        public String msg;
        public String type;

        public boolean isOperationAvilable() {
            return (TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.msg)) ? false : true;
        }
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    public boolean isGuidanceAvilable() {
        Options[] optionsArr = this.dialog_options;
        if (optionsArr == null || optionsArr.length != 3) {
            return false;
        }
        boolean z = false;
        for (Options options : optionsArr) {
            z = options.isOperationAvilable();
            if (!z) {
                break;
            }
        }
        return z;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
