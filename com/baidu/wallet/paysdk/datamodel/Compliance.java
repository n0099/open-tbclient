package com.baidu.wallet.paysdk.datamodel;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class Compliance implements Serializable {
    public AntiMoneyLaundering anti_money_laundering;

    /* loaded from: classes5.dex */
    public static class AntiMoneyLaundering implements Serializable {
        public int after_pay_identity;
        public String auth_msg;
    }
}
