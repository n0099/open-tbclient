package com.baidu.wallet.paysdk.datamodel;

import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class O2OPayStyleInfo implements NoProguard, Serializable {
    public static final long serialVersionUID = 7048827355672739424L;
    public BalanceInfo balance;
    public O2OBankInfo[] easypay;

    /* loaded from: classes5.dex */
    public static class BalanceInfo implements NoProguard, Serializable {
        public static final long serialVersionUID = -5872649191586338196L;
        public String can_amount;
        public String display_name;
        public String enabled;
        public String selected;
    }
}
