package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int anL;
    private int cMB;
    private int cMC;
    private boolean cMD;
    private SimpleUser cME;

    public boolean arv() {
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cMB = tu.getInt("post" + currentAccount, 0);
        this.cMC = tu.getInt("like" + currentAccount, 0);
        this.anL = tu.getInt("group" + currentAccount, 0);
        this.cMD = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cMB == 0 && this.cMC == 0 && this.anL == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cMB = aVar.cMB;
        this.cMC = aVar.cMC;
        this.anL = aVar.anL;
        this.cMD = aVar.cMD;
    }

    public int arw() {
        return this.cMB;
    }

    public void aa(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void arx() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        tu.putInt("post" + currentAccount, this.cMB);
        tu.putInt("like" + currentAccount, this.cMC);
        tu.putInt("group" + currentAccount, this.anL);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cMD);
    }

    public void kI(int i) {
        if (i <= 3 && i >= 1) {
            this.cMB = i;
        }
    }

    public int ary() {
        return this.cMC;
    }

    public void kJ(int i) {
        if (i <= 3 && i >= 1) {
            this.cMC = i;
        }
    }

    public int Ac() {
        return this.anL;
    }

    public void kK(int i) {
        if (i <= 3 && i >= 1) {
            this.anL = i;
        }
    }

    public boolean arz() {
        return this.cMD;
    }

    public void kL(int i) {
        switch (i) {
            case 1:
                this.cMD = true;
                return;
            default:
                this.cMD = false;
                return;
        }
    }

    public SimpleUser arA() {
        return this.cME;
    }

    public void a(SimpleUser simpleUser) {
        this.cME = simpleUser;
    }
}
