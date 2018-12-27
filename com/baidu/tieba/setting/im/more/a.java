package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aXi;
    private int aXl;
    private int gXA;
    private boolean gXB;
    private int gXC;
    private SimpleUser gXD;
    private int gXE;
    private int gXz;

    public boolean bwS() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gXz = bVar.getInt("post" + currentAccount, 0);
        this.gXA = bVar.getInt("like" + currentAccount, 0);
        this.aXi = bVar.getInt("group" + currentAccount, 0);
        this.aXl = bVar.getInt("live" + currentAccount, 0);
        this.gXC = bVar.getInt("reply" + currentAccount, 1);
        this.gXB = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gXz == 0 && this.gXA == 0 && this.aXi == 0 && this.aXl == 0 && this.gXC == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gXz = aVar.gXz;
            this.gXA = aVar.gXA;
            this.aXi = aVar.aXi;
            this.gXB = aVar.gXB;
            this.aXl = aVar.aXl;
            this.gXE = aVar.gXE;
            this.gXC = aVar.gXC;
        }
    }

    public int bwT() {
        return this.gXz;
    }

    public void aR(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bwU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gXz);
        bVar.putInt("like" + currentAccount, this.gXA);
        bVar.putInt("group" + currentAccount, this.aXi);
        bVar.putInt("live" + currentAccount, this.aXl);
        bVar.putInt("reply" + currentAccount, this.gXC);
        TbadkCoreApplication.getInst().setLocationShared(this.gXB);
    }

    public void uw(int i) {
        this.gXz = i;
    }

    public int bwV() {
        return this.gXA;
    }

    public void ux(int i) {
        if (i <= 3 && i >= 1) {
            this.gXA = i;
        }
    }

    public int LC() {
        return this.aXl;
    }

    public void uy(int i) {
        if (i <= 3 && i >= 1) {
            this.aXl = i;
        }
    }

    public int bwW() {
        return this.aXi;
    }

    public void uz(int i) {
        if (i <= 3 && i >= 1) {
            this.aXi = i;
        }
    }

    public boolean bwX() {
        return this.gXB;
    }

    public void uA(int i) {
        switch (i) {
            case 1:
                this.gXB = true;
                return;
            default:
                this.gXB = false;
                return;
        }
    }

    public SimpleUser Wg() {
        return this.gXD;
    }

    public void b(SimpleUser simpleUser) {
        this.gXD = simpleUser;
    }

    public void uB(int i) {
        this.gXE = i;
    }

    public void uC(int i) {
        if (i == 0) {
            this.gXC = 1;
        } else {
            this.gXC = i;
        }
    }

    public int bwY() {
        return this.gXC;
    }
}
