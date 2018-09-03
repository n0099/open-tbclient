package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aLa;
    private int aLd;
    private int gxA;
    private int gxB;
    private boolean gxC;
    private int gxD;
    private SimpleUser gxE;
    private int gxF;

    public boolean boU() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gxA = bVar.getInt("post" + currentAccount, 0);
        this.gxB = bVar.getInt("like" + currentAccount, 0);
        this.aLa = bVar.getInt("group" + currentAccount, 0);
        this.aLd = bVar.getInt("live" + currentAccount, 0);
        this.gxD = bVar.getInt("reply" + currentAccount, 1);
        this.gxC = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gxA == 0 && this.gxB == 0 && this.aLa == 0 && this.aLd == 0 && this.gxD == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gxA = aVar.gxA;
            this.gxB = aVar.gxB;
            this.aLa = aVar.aLa;
            this.gxC = aVar.gxC;
            this.aLd = aVar.aLd;
            this.gxF = aVar.gxF;
            this.gxD = aVar.gxD;
        }
    }

    public int boV() {
        return this.gxA;
    }

    public void aG(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void boW() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gxA);
        bVar.putInt("like" + currentAccount, this.gxB);
        bVar.putInt("group" + currentAccount, this.aLa);
        bVar.putInt("live" + currentAccount, this.aLd);
        bVar.putInt("reply" + currentAccount, this.gxD);
        TbadkCoreApplication.getInst().setLocationShared(this.gxC);
    }

    public void sB(int i) {
        this.gxA = i;
    }

    public int boX() {
        return this.gxB;
    }

    public void sC(int i) {
        if (i <= 3 && i >= 1) {
            this.gxB = i;
        }
    }

    public int GW() {
        return this.aLd;
    }

    public void sD(int i) {
        if (i <= 3 && i >= 1) {
            this.aLd = i;
        }
    }

    public int boY() {
        return this.aLa;
    }

    public void sE(int i) {
        if (i <= 3 && i >= 1) {
            this.aLa = i;
        }
    }

    public boolean boZ() {
        return this.gxC;
    }

    public void sF(int i) {
        switch (i) {
            case 1:
                this.gxC = true;
                return;
            default:
                this.gxC = false;
                return;
        }
    }

    public SimpleUser Rf() {
        return this.gxE;
    }

    public void b(SimpleUser simpleUser) {
        this.gxE = simpleUser;
    }

    public void sG(int i) {
        this.gxF = i;
    }

    public void sH(int i) {
        if (i == 0) {
            this.gxD = 1;
        } else {
            this.gxD = i;
        }
    }

    public int bpa() {
        return this.gxD;
    }
}
