package com.baidu.wallet.paysdk.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class O2OBankInfo implements NoProguard, Serializable {
    public static final long serialVersionUID = -7835206922733736126L;
    public String bank_name;
    public String bank_url;
    public String card_no;
    public String card_type;
    public String display_name;
    public String enabled;
    public boolean isBankCard = true;
    public String pay_type = "2";
    public String selected;
}
