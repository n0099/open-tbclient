package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cpA;
    private int cpx;
    private int iIT;
    private int iIU;
    private boolean iIV;
    private int iIW;
    private SimpleUser iIX;
    private int iIY;

    public boolean cgw() {
        com.baidu.tbadk.core.sharedPref.b agM = com.baidu.tbadk.core.sharedPref.b.agM();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iIT = agM.getInt("post" + currentAccount, 0);
        this.iIU = agM.getInt("like" + currentAccount, 0);
        this.cpx = agM.getInt("group" + currentAccount, 0);
        this.cpA = agM.getInt("live" + currentAccount, 0);
        this.iIW = agM.getInt("reply" + currentAccount, 1);
        this.iIV = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iIT == 0 && this.iIU == 0 && this.cpx == 0 && this.cpA == 0 && this.iIW == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iIT = aVar.iIT;
            this.iIU = aVar.iIU;
            this.cpx = aVar.cpx;
            this.iIV = aVar.iIV;
            this.cpA = aVar.cpA;
            this.iIY = aVar.iIY;
            this.iIW = aVar.iIW;
        }
    }

    public int cgx() {
        return this.iIT;
    }

    public void bj(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cgy() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b agM = com.baidu.tbadk.core.sharedPref.b.agM();
        agM.putInt("post" + currentAccount, this.iIT);
        agM.putInt("like" + currentAccount, this.iIU);
        agM.putInt("group" + currentAccount, this.cpx);
        agM.putInt("live" + currentAccount, this.cpA);
        agM.putInt("reply" + currentAccount, this.iIW);
        TbadkCoreApplication.getInst().setLocationShared(this.iIV);
    }

    public void zr(int i) {
        this.iIT = i;
    }

    public int cgz() {
        return this.iIU;
    }

    public void zs(int i) {
        if (i <= 3 && i >= 1) {
            this.iIU = i;
        }
    }

    public int aqs() {
        return this.cpA;
    }

    public void zt(int i) {
        if (i <= 3 && i >= 1) {
            this.cpA = i;
        }
    }

    public int cgA() {
        return this.cpx;
    }

    public void zu(int i) {
        if (i <= 3 && i >= 1) {
            this.cpx = i;
        }
    }

    public boolean cgB() {
        return this.iIV;
    }

    public void zv(int i) {
        switch (i) {
            case 1:
                this.iIV = true;
                return;
            default:
                this.iIV = false;
                return;
        }
    }

    public SimpleUser aBI() {
        return this.iIX;
    }

    public void b(SimpleUser simpleUser) {
        this.iIX = simpleUser;
    }

    public void zw(int i) {
        this.iIY = i;
    }

    public void zx(int i) {
        if (i == 0) {
            this.iIW = 1;
        } else {
            this.iIW = i;
        }
    }

    public int cgC() {
        return this.iIW;
    }
}
