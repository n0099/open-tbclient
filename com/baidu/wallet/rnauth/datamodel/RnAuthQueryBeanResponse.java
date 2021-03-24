package com.baidu.wallet.rnauth.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class RnAuthQueryBeanResponse implements IBeanResponse, Serializable {
    public int auth_state_v2;
    public String button_msg;
    public String certificate_code;
    public String certificate_type;
    public String display_msg;
    public String idcard_auth_state;
    public String need_reauth_idcard;
    public ResultMsg result_msg;
    public String true_name;

    /* loaded from: classes5.dex */
    public static class ResultMsg implements Serializable {
        public String result_subTitle;
        public String result_title;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
