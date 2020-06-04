package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int ejS;
    private int ejV;
    private int kUP;
    private int kUQ;
    private boolean kUR;
    private int kUS;
    private SimpleUser kUT;
    private int kUU;

    public boolean cWW() {
        com.baidu.tbadk.core.sharedPref.b aTX = com.baidu.tbadk.core.sharedPref.b.aTX();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kUP = aTX.getInt("post" + currentAccount, 0);
        this.kUQ = aTX.getInt("like" + currentAccount, 0);
        this.ejS = aTX.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.ejV = aTX.getInt("live" + currentAccount, 0);
        this.kUS = aTX.getInt("reply" + currentAccount, 1);
        this.kUR = TbadkCoreApplication.getInst().getLocationShared();
        return (this.kUP == 0 && this.kUQ == 0 && this.ejS == 0 && this.ejV == 0 && this.kUS == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.kUP = aVar.kUP;
            this.kUQ = aVar.kUQ;
            this.ejS = aVar.ejS;
            this.kUR = aVar.kUR;
            this.ejV = aVar.ejV;
            this.kUU = aVar.kUU;
            this.kUS = aVar.kUS;
        }
    }

    public int cWX() {
        return this.kUP;
    }

    public void bB(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aTX().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cWY() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aTX = com.baidu.tbadk.core.sharedPref.b.aTX();
        aTX.putInt("post" + currentAccount, this.kUP);
        aTX.putInt("like" + currentAccount, this.kUQ);
        aTX.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.ejS);
        aTX.putInt("live" + currentAccount, this.ejV);
        aTX.putInt("reply" + currentAccount, this.kUS);
        TbadkCoreApplication.getInst().setLocationShared(this.kUR);
    }

    public void CM(int i) {
        this.kUP = i;
    }

    public int cWZ() {
        return this.kUQ;
    }

    public void CN(int i) {
        if (i <= 3 && i >= 1) {
            this.kUQ = i;
        }
    }

    public int cXa() {
        return this.ejV;
    }

    public void CO(int i) {
        if (i <= 3 && i >= 1) {
            this.ejV = i;
        }
    }

    public int cXb() {
        return this.ejS;
    }

    public void CP(int i) {
        if (i <= 3 && i >= 1) {
            this.ejS = i;
        }
    }

    public boolean cXc() {
        return this.kUR;
    }

    public void CQ(int i) {
        switch (i) {
            case 1:
                this.kUR = true;
                return;
            default:
                this.kUR = false;
                return;
        }
    }

    public SimpleUser bms() {
        return this.kUT;
    }

    public void b(SimpleUser simpleUser) {
        this.kUT = simpleUser;
    }

    public void CR(int i) {
        this.kUU = i;
    }

    public void CS(int i) {
        if (i == 0) {
            this.kUS = 1;
        } else {
            this.kUS = i;
        }
    }

    public int cXd() {
        return this.kUS;
    }
}
