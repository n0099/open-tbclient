package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dvA;
    private int dvx;
    private int jQQ;
    private int jQR;
    private boolean jQS;
    private int jQT;
    private SimpleUser jQU;
    private int jQV;

    public boolean cEN() {
        com.baidu.tbadk.core.sharedPref.b aFD = com.baidu.tbadk.core.sharedPref.b.aFD();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jQQ = aFD.getInt("post" + currentAccount, 0);
        this.jQR = aFD.getInt("like" + currentAccount, 0);
        this.dvx = aFD.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dvA = aFD.getInt("live" + currentAccount, 0);
        this.jQT = aFD.getInt("reply" + currentAccount, 1);
        this.jQS = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jQQ == 0 && this.jQR == 0 && this.dvx == 0 && this.dvA == 0 && this.jQT == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jQQ = aVar.jQQ;
            this.jQR = aVar.jQR;
            this.dvx = aVar.dvx;
            this.jQS = aVar.jQS;
            this.dvA = aVar.dvA;
            this.jQV = aVar.jQV;
            this.jQT = aVar.jQT;
        }
    }

    public int cEO() {
        return this.jQQ;
    }

    public void bq(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cEP() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aFD = com.baidu.tbadk.core.sharedPref.b.aFD();
        aFD.putInt("post" + currentAccount, this.jQQ);
        aFD.putInt("like" + currentAccount, this.jQR);
        aFD.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dvx);
        aFD.putInt("live" + currentAccount, this.dvA);
        aFD.putInt("reply" + currentAccount, this.jQT);
        TbadkCoreApplication.getInst().setLocationShared(this.jQS);
    }

    public void Bs(int i) {
        this.jQQ = i;
    }

    public int cEQ() {
        return this.jQR;
    }

    public void Bt(int i) {
        if (i <= 3 && i >= 1) {
            this.jQR = i;
        }
    }

    public int cER() {
        return this.dvA;
    }

    public void Bu(int i) {
        if (i <= 3 && i >= 1) {
            this.dvA = i;
        }
    }

    public int cES() {
        return this.dvx;
    }

    public void Bv(int i) {
        if (i <= 3 && i >= 1) {
            this.dvx = i;
        }
    }

    public boolean cET() {
        return this.jQS;
    }

    public void Bw(int i) {
        switch (i) {
            case 1:
                this.jQS = true;
                return;
            default:
                this.jQS = false;
                return;
        }
    }

    public SimpleUser aXY() {
        return this.jQU;
    }

    public void b(SimpleUser simpleUser) {
        this.jQU = simpleUser;
    }

    public void Bx(int i) {
        this.jQV = i;
    }

    public void By(int i) {
        if (i == 0) {
            this.jQT = 1;
        } else {
            this.jQT = i;
        }
    }

    public int cEU() {
        return this.jQT;
    }
}
