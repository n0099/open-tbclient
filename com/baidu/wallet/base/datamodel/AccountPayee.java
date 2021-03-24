package com.baidu.wallet.base.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class AccountPayee implements NoProguard, Serializable {
    public static final String PAYEE_TYPE_BAIFUBAO = "1";
    public static final String PAYEE_TYPE_NONE_OF_BAIFUBAO_AND_PASSID = "3";
    public static final String PAYEE_TYPE_PASSID = "2";
    public static final long serialVersionUID = 4652827659433616918L;
    public String notify_payee_mobile;
    public String notify_payee_mobile_back;
    public String payee_email;
    public String payee_err_info;
    public String payee_head_image;
    public String payee_mobile;
    public String payee_recv_type;
    public String payee_true_name;
    public String payee_username;
}
