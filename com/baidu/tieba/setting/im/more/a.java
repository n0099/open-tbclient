package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aKa;
    private int aKd;
    private boolean gsA;
    private int gsB;
    private SimpleUser gsC;
    private int gsD;
    private int gsy;
    private int gsz;

    public boolean bpP() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gsy = bVar.getInt("post" + currentAccount, 0);
        this.gsz = bVar.getInt("like" + currentAccount, 0);
        this.aKa = bVar.getInt("group" + currentAccount, 0);
        this.aKd = bVar.getInt("live" + currentAccount, 0);
        this.gsB = bVar.getInt("reply" + currentAccount, 1);
        this.gsA = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gsy == 0 && this.gsz == 0 && this.aKa == 0 && this.aKd == 0 && this.gsB == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gsy = aVar.gsy;
            this.gsz = aVar.gsz;
            this.aKa = aVar.aKa;
            this.gsA = aVar.gsA;
            this.aKd = aVar.aKd;
            this.gsD = aVar.gsD;
            this.gsB = aVar.gsB;
        }
    }

    public int bpQ() {
        return this.gsy;
    }

    public void aJ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bpR() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gsy);
        bVar.putInt("like" + currentAccount, this.gsz);
        bVar.putInt("group" + currentAccount, this.aKa);
        bVar.putInt("live" + currentAccount, this.aKd);
        bVar.putInt("reply" + currentAccount, this.gsB);
        TbadkCoreApplication.getInst().setLocationShared(this.gsA);
    }

    public void st(int i) {
        this.gsy = i;
    }

    public int bpS() {
        return this.gsz;
    }

    public void su(int i) {
        if (i <= 3 && i >= 1) {
            this.gsz = i;
        }
    }

    public int GI() {
        return this.aKd;
    }

    public void sv(int i) {
        if (i <= 3 && i >= 1) {
            this.aKd = i;
        }
    }

    public int bpT() {
        return this.aKa;
    }

    public void sw(int i) {
        if (i <= 3 && i >= 1) {
            this.aKa = i;
        }
    }

    public boolean bpU() {
        return this.gsA;
    }

    public void sx(int i) {
        switch (i) {
            case 1:
                this.gsA = true;
                return;
            default:
                this.gsA = false;
                return;
        }
    }

    public SimpleUser Qw() {
        return this.gsC;
    }

    public void b(SimpleUser simpleUser) {
        this.gsC = simpleUser;
    }

    public void sy(int i) {
        this.gsD = i;
    }

    public void sz(int i) {
        if (i == 0) {
            this.gsB = 1;
        } else {
            this.gsB = i;
        }
    }

    public int bpV() {
        return this.gsB;
    }
}
