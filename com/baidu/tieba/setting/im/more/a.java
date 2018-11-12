package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aTI;
    private int aTL;
    private int gNP;
    private int gNQ;
    private boolean gNR;
    private int gNS;
    private SimpleUser gNT;
    private int gNU;

    public boolean bum() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gNP = bVar.getInt("post" + currentAccount, 0);
        this.gNQ = bVar.getInt("like" + currentAccount, 0);
        this.aTI = bVar.getInt("group" + currentAccount, 0);
        this.aTL = bVar.getInt("live" + currentAccount, 0);
        this.gNS = bVar.getInt("reply" + currentAccount, 1);
        this.gNR = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gNP == 0 && this.gNQ == 0 && this.aTI == 0 && this.aTL == 0 && this.gNS == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gNP = aVar.gNP;
            this.gNQ = aVar.gNQ;
            this.aTI = aVar.aTI;
            this.gNR = aVar.gNR;
            this.aTL = aVar.aTL;
            this.gNU = aVar.gNU;
            this.gNS = aVar.gNS;
        }
    }

    public int bun() {
        return this.gNP;
    }

    public void aP(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void buo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gNP);
        bVar.putInt("like" + currentAccount, this.gNQ);
        bVar.putInt("group" + currentAccount, this.aTI);
        bVar.putInt("live" + currentAccount, this.aTL);
        bVar.putInt("reply" + currentAccount, this.gNS);
        TbadkCoreApplication.getInst().setLocationShared(this.gNR);
    }

    public void tP(int i) {
        this.gNP = i;
    }

    public int bup() {
        return this.gNQ;
    }

    public void tQ(int i) {
        if (i <= 3 && i >= 1) {
            this.gNQ = i;
        }
    }

    public int Kx() {
        return this.aTL;
    }

    public void tR(int i) {
        if (i <= 3 && i >= 1) {
            this.aTL = i;
        }
    }

    public int buq() {
        return this.aTI;
    }

    public void tS(int i) {
        if (i <= 3 && i >= 1) {
            this.aTI = i;
        }
    }

    public boolean bur() {
        return this.gNR;
    }

    public void tT(int i) {
        switch (i) {
            case 1:
                this.gNR = true;
                return;
            default:
                this.gNR = false;
                return;
        }
    }

    public SimpleUser UY() {
        return this.gNT;
    }

    public void b(SimpleUser simpleUser) {
        this.gNT = simpleUser;
    }

    public void tU(int i) {
        this.gNU = i;
    }

    public void tV(int i) {
        if (i == 0) {
            this.gNS = 1;
        } else {
            this.gNS = i;
        }
    }

    public int bus() {
        return this.gNS;
    }
}
