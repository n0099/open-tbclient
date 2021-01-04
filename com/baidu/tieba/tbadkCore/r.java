package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class r {
    private String menu_name;
    private boolean nqg;

    public boolean dOp() {
        return this.nqg;
    }

    public String dOq() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.nqg = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
