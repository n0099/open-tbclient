package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int apf;
    private int cDF;
    private int cDG;
    private boolean cDH;
    private SimpleUser cDI;

    public boolean aov() {
        com.baidu.tbadk.core.sharedPref.b tx = com.baidu.tbadk.core.sharedPref.b.tx();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cDF = tx.getInt("post" + currentAccount, 0);
        this.cDG = tx.getInt("like" + currentAccount, 0);
        this.apf = tx.getInt("group" + currentAccount, 0);
        this.cDH = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cDF == 0 && this.cDG == 0 && this.apf == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cDF = aVar.cDF;
        this.cDG = aVar.cDG;
        this.apf = aVar.apf;
        this.cDH = aVar.cDH;
    }

    public int aow() {
        return this.cDF;
    }

    public void Y(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tx().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aox() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tx = com.baidu.tbadk.core.sharedPref.b.tx();
        tx.putInt("post" + currentAccount, this.cDF);
        tx.putInt("like" + currentAccount, this.cDG);
        tx.putInt("group" + currentAccount, this.apf);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cDH);
    }

    public void jT(int i) {
        if (i <= 3 && i >= 1) {
            this.cDF = i;
        }
    }

    public int aoy() {
        return this.cDG;
    }

    public void jU(int i) {
        if (i <= 3 && i >= 1) {
            this.cDG = i;
        }
    }

    public int Ap() {
        return this.apf;
    }

    public void jV(int i) {
        if (i <= 3 && i >= 1) {
            this.apf = i;
        }
    }

    public boolean aoz() {
        return this.cDH;
    }

    public void jW(int i) {
        switch (i) {
            case 1:
                this.cDH = true;
                return;
            default:
                this.cDH = false;
                return;
        }
    }

    public SimpleUser aoA() {
        return this.cDI;
    }

    public void a(SimpleUser simpleUser) {
        this.cDI = simpleUser;
    }
}
