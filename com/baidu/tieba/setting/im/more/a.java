package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int ejS;
    private int ejV;
    private int kTG;
    private int kTH;
    private boolean kTI;
    private int kTJ;
    private SimpleUser kTK;
    private int kTL;

    public boolean cWG() {
        com.baidu.tbadk.core.sharedPref.b aTX = com.baidu.tbadk.core.sharedPref.b.aTX();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kTG = aTX.getInt("post" + currentAccount, 0);
        this.kTH = aTX.getInt("like" + currentAccount, 0);
        this.ejS = aTX.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.ejV = aTX.getInt("live" + currentAccount, 0);
        this.kTJ = aTX.getInt("reply" + currentAccount, 1);
        this.kTI = TbadkCoreApplication.getInst().getLocationShared();
        return (this.kTG == 0 && this.kTH == 0 && this.ejS == 0 && this.ejV == 0 && this.kTJ == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.kTG = aVar.kTG;
            this.kTH = aVar.kTH;
            this.ejS = aVar.ejS;
            this.kTI = aVar.kTI;
            this.ejV = aVar.ejV;
            this.kTL = aVar.kTL;
            this.kTJ = aVar.kTJ;
        }
    }

    public int cWH() {
        return this.kTG;
    }

    public void bB(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cWI() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aTX = com.baidu.tbadk.core.sharedPref.b.aTX();
        aTX.putInt("post" + currentAccount, this.kTG);
        aTX.putInt("like" + currentAccount, this.kTH);
        aTX.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.ejS);
        aTX.putInt("live" + currentAccount, this.ejV);
        aTX.putInt("reply" + currentAccount, this.kTJ);
        TbadkCoreApplication.getInst().setLocationShared(this.kTI);
    }

    public void CK(int i) {
        this.kTG = i;
    }

    public int cWJ() {
        return this.kTH;
    }

    public void CL(int i) {
        if (i <= 3 && i >= 1) {
            this.kTH = i;
        }
    }

    public int cWK() {
        return this.ejV;
    }

    public void CM(int i) {
        if (i <= 3 && i >= 1) {
            this.ejV = i;
        }
    }

    public int cWL() {
        return this.ejS;
    }

    public void CN(int i) {
        if (i <= 3 && i >= 1) {
            this.ejS = i;
        }
    }

    public boolean cWM() {
        return this.kTI;
    }

    public void CO(int i) {
        switch (i) {
            case 1:
                this.kTI = true;
                return;
            default:
                this.kTI = false;
                return;
        }
    }

    public SimpleUser bmq() {
        return this.kTK;
    }

    public void b(SimpleUser simpleUser) {
        this.kTK = simpleUser;
    }

    public void CP(int i) {
        this.kTL = i;
    }

    public void CQ(int i) {
        if (i == 0) {
            this.kTJ = 1;
        } else {
            this.kTJ = i;
        }
    }

    public int cWN() {
        return this.kTJ;
    }
}
