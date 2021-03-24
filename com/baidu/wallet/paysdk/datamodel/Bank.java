package com.baidu.wallet.paysdk.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class Bank implements NoProguard, Serializable {
    public static final String HOT_BANK_LETTER = "#";
    public static final long serialVersionUID = 1;
    public String is_hot;
    public String logo_url;
    public String display_name = "";
    public String display_letter = "#";
    public String bank_code = "";
}
