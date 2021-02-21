package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class r {
    private String menu_name;
    private boolean nvH;

    public boolean dMR() {
        return this.nvH;
    }

    public String dMS() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.nvH = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
