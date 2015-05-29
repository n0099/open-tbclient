package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class x {
    private boolean cpH;
    private String menu_name;

    public boolean amM() {
        return this.cpH;
    }

    public String amN() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.cpH = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
