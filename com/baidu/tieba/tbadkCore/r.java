package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class r {
    private String menu_name;
    private boolean nky;

    public boolean dOx() {
        return this.nky;
    }

    public String dOy() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.nky = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
