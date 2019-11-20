package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cDe;
    private int cDh;
    private int iRF;
    private int iRG;
    private boolean iRH;
    private int iRI;
    private SimpleUser iRJ;
    private int iRK;

    public boolean cib() {
        com.baidu.tbadk.core.sharedPref.b alP = com.baidu.tbadk.core.sharedPref.b.alP();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iRF = alP.getInt("post" + currentAccount, 0);
        this.iRG = alP.getInt("like" + currentAccount, 0);
        this.cDe = alP.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.cDh = alP.getInt("live" + currentAccount, 0);
        this.iRI = alP.getInt("reply" + currentAccount, 1);
        this.iRH = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iRF == 0 && this.iRG == 0 && this.cDe == 0 && this.cDh == 0 && this.iRI == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iRF = aVar.iRF;
            this.iRG = aVar.iRG;
            this.cDe = aVar.cDe;
            this.iRH = aVar.iRH;
            this.cDh = aVar.cDh;
            this.iRK = aVar.iRK;
            this.iRI = aVar.iRI;
        }
    }

    public int cic() {
        return this.iRF;
    }

    public void bh(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.alP().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cid() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b alP = com.baidu.tbadk.core.sharedPref.b.alP();
        alP.putInt("post" + currentAccount, this.iRF);
        alP.putInt("like" + currentAccount, this.iRG);
        alP.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.cDe);
        alP.putInt("live" + currentAccount, this.cDh);
        alP.putInt("reply" + currentAccount, this.iRI);
        TbadkCoreApplication.getInst().setLocationShared(this.iRH);
    }

    public void yJ(int i) {
        this.iRF = i;
    }

    public int cie() {
        return this.iRG;
    }

    public void yK(int i) {
        if (i <= 3 && i >= 1) {
            this.iRG = i;
        }
    }

    public int atx() {
        return this.cDh;
    }

    public void yL(int i) {
        if (i <= 3 && i >= 1) {
            this.cDh = i;
        }
    }

    public int cif() {
        return this.cDe;
    }

    public void yM(int i) {
        if (i <= 3 && i >= 1) {
            this.cDe = i;
        }
    }

    public boolean cig() {
        return this.iRH;
    }

    public void yN(int i) {
        switch (i) {
            case 1:
                this.iRH = true;
                return;
            default:
                this.iRH = false;
                return;
        }
    }

    public SimpleUser aDu() {
        return this.iRJ;
    }

    public void b(SimpleUser simpleUser) {
        this.iRJ = simpleUser;
    }

    public void yO(int i) {
        this.iRK = i;
    }

    public void yP(int i) {
        if (i == 0) {
            this.iRI = 1;
        } else {
            this.iRI = i;
        }
    }

    public int cih() {
        return this.iRI;
    }
}
