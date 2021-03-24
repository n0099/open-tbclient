package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class AuthStateResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = 1;
    public AccountInfo account_info;
    public Auth auth;
    public String online_kefu;
    public SignPay sign_pay;
    public UserInfo user_info;

    /* loaded from: classes5.dex */
    public static class AccountInfo implements NoProguard, Serializable {
        public String link_addr;
    }

    /* loaded from: classes5.dex */
    public static class Auth implements NoProguard, Serializable {
        public static final long serialVersionUID = -3571683889059744265L;
        public String auth_state;
        public String auth_state_desc;
    }

    /* loaded from: classes5.dex */
    public static class SignPay implements NoProguard, Serializable {
        public static final long serialVersionUID = -4172817358569160671L;
        public String sign_pay_url;
    }

    /* loaded from: classes5.dex */
    public static class UserInfo implements NoProguard, Serializable {
        public static final long serialVersionUID = -89954795900468223L;
        public int has_mobile_pwd;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }
}
