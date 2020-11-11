package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.GconAccount;
/* loaded from: classes.dex */
public class q {
    private boolean mVF;
    private String menu_name;

    public boolean dJo() {
        return this.mVF;
    }

    public String dJp() {
        return this.menu_name;
    }

    public void a(GconAccount gconAccount) {
        if (gconAccount != null) {
            this.mVF = gconAccount.has_account.intValue() == 1;
            this.menu_name = gconAccount.menu_name;
        }
    }
}
