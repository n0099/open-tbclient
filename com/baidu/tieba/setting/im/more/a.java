package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int esD;
    private int esG;
    private int loM;
    private int loN;
    private boolean loO;
    private int loP;
    private SimpleUser loQ;
    private int loR;

    public boolean dbm() {
        com.baidu.tbadk.core.sharedPref.b aVP = com.baidu.tbadk.core.sharedPref.b.aVP();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.loM = aVP.getInt("post" + currentAccount, 0);
        this.loN = aVP.getInt("like" + currentAccount, 0);
        this.esD = aVP.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.esG = aVP.getInt("live" + currentAccount, 0);
        this.loP = aVP.getInt("reply" + currentAccount, 1);
        this.loO = TbadkCoreApplication.getInst().getLocationShared();
        return (this.loM == 0 && this.loN == 0 && this.esD == 0 && this.esG == 0 && this.loP == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.loM = aVar.loM;
            this.loN = aVar.loN;
            this.esD = aVar.esD;
            this.loO = aVar.loO;
            this.esG = aVar.esG;
            this.loR = aVar.loR;
            this.loP = aVar.loP;
        }
    }

    public int dbn() {
        return this.loM;
    }

    public void bA(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aVP().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dbo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aVP = com.baidu.tbadk.core.sharedPref.b.aVP();
        aVP.putInt("post" + currentAccount, this.loM);
        aVP.putInt("like" + currentAccount, this.loN);
        aVP.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.esD);
        aVP.putInt("live" + currentAccount, this.esG);
        aVP.putInt("reply" + currentAccount, this.loP);
        TbadkCoreApplication.getInst().setLocationShared(this.loO);
    }

    public void DO(int i) {
        this.loM = i;
    }

    public int dbp() {
        return this.loN;
    }

    public void DP(int i) {
        if (i <= 3 && i >= 1) {
            this.loN = i;
        }
    }

    public int dbq() {
        return this.esG;
    }

    public void DQ(int i) {
        if (i <= 3 && i >= 1) {
            this.esG = i;
        }
    }

    public int dbr() {
        return this.esD;
    }

    public void DR(int i) {
        if (i <= 3 && i >= 1) {
            this.esD = i;
        }
    }

    public boolean dbs() {
        return this.loO;
    }

    public void DS(int i) {
        switch (i) {
            case 1:
                this.loO = true;
                return;
            default:
                this.loO = false;
                return;
        }
    }

    public SimpleUser boS() {
        return this.loQ;
    }

    public void b(SimpleUser simpleUser) {
        this.loQ = simpleUser;
    }

    public void DT(int i) {
        this.loR = i;
    }

    public void DU(int i) {
        if (i == 0) {
            this.loP = 1;
        } else {
            this.loP = i;
        }
    }

    public int dbt() {
        return this.loP;
    }
}
