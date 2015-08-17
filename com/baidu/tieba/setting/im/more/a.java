package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int ant;
    private int cvj;
    private int cvk;
    private boolean cvl;
    private SimpleUser cvm;

    public boolean ako() {
        com.baidu.tbadk.core.sharedPref.b ts = com.baidu.tbadk.core.sharedPref.b.ts();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cvj = ts.getInt("post" + currentAccount, 0);
        this.cvk = ts.getInt("like" + currentAccount, 0);
        this.ant = ts.getInt("group" + currentAccount, 0);
        this.cvl = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cvj == 0 && this.cvk == 0 && this.ant == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cvj = aVar.cvj;
        this.cvk = aVar.cvk;
        this.ant = aVar.ant;
        this.cvl = aVar.cvl;
    }

    public int akp() {
        return this.cvj;
    }

    public void W(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.ts().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void akq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b ts = com.baidu.tbadk.core.sharedPref.b.ts();
        ts.putInt("post" + currentAccount, this.cvj);
        ts.putInt("like" + currentAccount, this.cvk);
        ts.putInt("group" + currentAccount, this.ant);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cvl);
    }

    public void jj(int i) {
        if (i <= 3 && i >= 1) {
            this.cvj = i;
        }
    }

    public int akr() {
        return this.cvk;
    }

    public void jk(int i) {
        if (i <= 3 && i >= 1) {
            this.cvk = i;
        }
    }

    public int Ac() {
        return this.ant;
    }

    public void jl(int i) {
        if (i <= 3 && i >= 1) {
            this.ant = i;
        }
    }

    public boolean aks() {
        return this.cvl;
    }

    public void jm(int i) {
        switch (i) {
            case 1:
                this.cvl = true;
                return;
            default:
                this.cvl = false;
                return;
        }
    }

    public SimpleUser akt() {
        return this.cvm;
    }

    public void a(SimpleUser simpleUser) {
        this.cvm = simpleUser;
    }
}
