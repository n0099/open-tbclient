package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cDV;
    private int cDY;
    private SimpleUser iSA;
    private int iSB;
    private int iSw;
    private int iSx;
    private boolean iSy;
    private int iSz;

    public boolean cid() {
        com.baidu.tbadk.core.sharedPref.b alR = com.baidu.tbadk.core.sharedPref.b.alR();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iSw = alR.getInt("post" + currentAccount, 0);
        this.iSx = alR.getInt("like" + currentAccount, 0);
        this.cDV = alR.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.cDY = alR.getInt("live" + currentAccount, 0);
        this.iSz = alR.getInt("reply" + currentAccount, 1);
        this.iSy = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iSw == 0 && this.iSx == 0 && this.cDV == 0 && this.cDY == 0 && this.iSz == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iSw = aVar.iSw;
            this.iSx = aVar.iSx;
            this.cDV = aVar.cDV;
            this.iSy = aVar.iSy;
            this.cDY = aVar.cDY;
            this.iSB = aVar.iSB;
            this.iSz = aVar.iSz;
        }
    }

    public int cie() {
        return this.iSw;
    }

    public void bh(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.alR().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cif() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b alR = com.baidu.tbadk.core.sharedPref.b.alR();
        alR.putInt("post" + currentAccount, this.iSw);
        alR.putInt("like" + currentAccount, this.iSx);
        alR.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.cDV);
        alR.putInt("live" + currentAccount, this.cDY);
        alR.putInt("reply" + currentAccount, this.iSz);
        TbadkCoreApplication.getInst().setLocationShared(this.iSy);
    }

    public void yK(int i) {
        this.iSw = i;
    }

    public int cig() {
        return this.iSx;
    }

    public void yL(int i) {
        if (i <= 3 && i >= 1) {
            this.iSx = i;
        }
    }

    public int atz() {
        return this.cDY;
    }

    public void yM(int i) {
        if (i <= 3 && i >= 1) {
            this.cDY = i;
        }
    }

    public int cih() {
        return this.cDV;
    }

    public void yN(int i) {
        if (i <= 3 && i >= 1) {
            this.cDV = i;
        }
    }

    public boolean cii() {
        return this.iSy;
    }

    public void yO(int i) {
        switch (i) {
            case 1:
                this.iSy = true;
                return;
            default:
                this.iSy = false;
                return;
        }
    }

    public SimpleUser aDw() {
        return this.iSA;
    }

    public void b(SimpleUser simpleUser) {
        this.iSA = simpleUser;
    }

    public void yP(int i) {
        this.iSB = i;
    }

    public void yQ(int i) {
        if (i == 0) {
            this.iSz = 1;
        } else {
            this.iSz = i;
        }
    }

    public int cij() {
        return this.iSz;
    }
}
