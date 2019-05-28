package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cpw;
    private int cpz;
    private int iIP;
    private int iIQ;
    private boolean iIR;
    private int iIS;
    private SimpleUser iIT;
    private int iIU;

    public boolean cgv() {
        com.baidu.tbadk.core.sharedPref.b agM = com.baidu.tbadk.core.sharedPref.b.agM();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iIP = agM.getInt("post" + currentAccount, 0);
        this.iIQ = agM.getInt("like" + currentAccount, 0);
        this.cpw = agM.getInt("group" + currentAccount, 0);
        this.cpz = agM.getInt("live" + currentAccount, 0);
        this.iIS = agM.getInt("reply" + currentAccount, 1);
        this.iIR = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iIP == 0 && this.iIQ == 0 && this.cpw == 0 && this.cpz == 0 && this.iIS == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iIP = aVar.iIP;
            this.iIQ = aVar.iIQ;
            this.cpw = aVar.cpw;
            this.iIR = aVar.iIR;
            this.cpz = aVar.cpz;
            this.iIU = aVar.iIU;
            this.iIS = aVar.iIS;
        }
    }

    public int cgw() {
        return this.iIP;
    }

    public void bj(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.agM().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cgx() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b agM = com.baidu.tbadk.core.sharedPref.b.agM();
        agM.putInt("post" + currentAccount, this.iIP);
        agM.putInt("like" + currentAccount, this.iIQ);
        agM.putInt("group" + currentAccount, this.cpw);
        agM.putInt("live" + currentAccount, this.cpz);
        agM.putInt("reply" + currentAccount, this.iIS);
        TbadkCoreApplication.getInst().setLocationShared(this.iIR);
    }

    public void zr(int i) {
        this.iIP = i;
    }

    public int cgy() {
        return this.iIQ;
    }

    public void zs(int i) {
        if (i <= 3 && i >= 1) {
            this.iIQ = i;
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

    public int cgz() {
        return this.cpw;
    }

    public void zu(int i) {
        if (i <= 3 && i >= 1) {
            this.cpw = i;
        }
    }

    public boolean cgA() {
        return this.iIR;
    }

    public void zv(int i) {
        switch (i) {
            case 1:
                this.iIR = true;
                return;
            default:
                this.iIR = false;
                return;
        }
    }

    public SimpleUser aBI() {
        return this.iIT;
    }

    public void b(SimpleUser simpleUser) {
        this.iIT = simpleUser;
    }

    public void zw(int i) {
        this.iIU = i;
    }

    public void zx(int i) {
        if (i == 0) {
            this.iIS = 1;
        } else {
            this.iIS = i;
        }
    }

    public int cgB() {
        return this.iIS;
    }
}
