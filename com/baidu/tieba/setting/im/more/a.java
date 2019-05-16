package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cpw;
    private int cpz;
    private int iIN;
    private int iIO;
    private boolean iIP;
    private int iIQ;
    private SimpleUser iIR;
    private int iIS;

    public boolean cgt() {
        com.baidu.tbadk.core.sharedPref.b agM = com.baidu.tbadk.core.sharedPref.b.agM();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iIN = agM.getInt("post" + currentAccount, 0);
        this.iIO = agM.getInt("like" + currentAccount, 0);
        this.cpw = agM.getInt("group" + currentAccount, 0);
        this.cpz = agM.getInt("live" + currentAccount, 0);
        this.iIQ = agM.getInt("reply" + currentAccount, 1);
        this.iIP = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iIN == 0 && this.iIO == 0 && this.cpw == 0 && this.cpz == 0 && this.iIQ == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iIN = aVar.iIN;
            this.iIO = aVar.iIO;
            this.cpw = aVar.cpw;
            this.iIP = aVar.iIP;
            this.cpz = aVar.cpz;
            this.iIS = aVar.iIS;
            this.iIQ = aVar.iIQ;
        }
    }

    public int cgu() {
        return this.iIN;
    }

    public void bj(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cgv() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b agM = com.baidu.tbadk.core.sharedPref.b.agM();
        agM.putInt("post" + currentAccount, this.iIN);
        agM.putInt("like" + currentAccount, this.iIO);
        agM.putInt("group" + currentAccount, this.cpw);
        agM.putInt("live" + currentAccount, this.cpz);
        agM.putInt("reply" + currentAccount, this.iIQ);
        TbadkCoreApplication.getInst().setLocationShared(this.iIP);
    }

    public void zr(int i) {
        this.iIN = i;
    }

    public int cgw() {
        return this.iIO;
    }

    public void zs(int i) {
        if (i <= 3 && i >= 1) {
            this.iIO = i;
        }
    }

    public int aqs() {
        return this.cpz;
    }

    public void zt(int i) {
        if (i <= 3 && i >= 1) {
            this.cpz = i;
        }
    }

    public int cgx() {
        return this.cpw;
    }

    public void zu(int i) {
        if (i <= 3 && i >= 1) {
            this.cpw = i;
        }
    }

    public boolean cgy() {
        return this.iIP;
    }

    public void zv(int i) {
        switch (i) {
            case 1:
                this.iIP = true;
                return;
            default:
                this.iIP = false;
                return;
        }
    }

    public SimpleUser aBF() {
        return this.iIR;
    }

    public void b(SimpleUser simpleUser) {
        this.iIR = simpleUser;
    }

    public void zw(int i) {
        this.iIS = i;
    }

    public void zx(int i) {
        if (i == 0) {
            this.iIQ = 1;
        } else {
            this.iIQ = i;
        }
    }

    public int cgz() {
        return this.iIQ;
    }
}
