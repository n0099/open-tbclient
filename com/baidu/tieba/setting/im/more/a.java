package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int crL;
    private int crO;
    private int iSL;
    private int iSM;
    private boolean iSN;
    private int iSO;
    private SimpleUser iSP;
    private int iSQ;

    public boolean ckr() {
        com.baidu.tbadk.core.sharedPref.b ahU = com.baidu.tbadk.core.sharedPref.b.ahU();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iSL = ahU.getInt("post" + currentAccount, 0);
        this.iSM = ahU.getInt("like" + currentAccount, 0);
        this.crL = ahU.getInt("group" + currentAccount, 0);
        this.crO = ahU.getInt("live" + currentAccount, 0);
        this.iSO = ahU.getInt("reply" + currentAccount, 1);
        this.iSN = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iSL == 0 && this.iSM == 0 && this.crL == 0 && this.crO == 0 && this.iSO == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iSL = aVar.iSL;
            this.iSM = aVar.iSM;
            this.crL = aVar.crL;
            this.iSN = aVar.iSN;
            this.crO = aVar.crO;
            this.iSQ = aVar.iSQ;
            this.iSO = aVar.iSO;
        }
    }

    public int cks() {
        return this.iSL;
    }

    public void bm(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.ahU().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void ckt() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b ahU = com.baidu.tbadk.core.sharedPref.b.ahU();
        ahU.putInt("post" + currentAccount, this.iSL);
        ahU.putInt("like" + currentAccount, this.iSM);
        ahU.putInt("group" + currentAccount, this.crL);
        ahU.putInt("live" + currentAccount, this.crO);
        ahU.putInt("reply" + currentAccount, this.iSO);
        TbadkCoreApplication.getInst().setLocationShared(this.iSN);
    }

    public void Ac(int i) {
        this.iSL = i;
    }

    public int cku() {
        return this.iSM;
    }

    public void Ad(int i) {
        if (i <= 3 && i >= 1) {
            this.iSM = i;
        }
    }

    public int arL() {
        return this.crO;
    }

    public void Ae(int i) {
        if (i <= 3 && i >= 1) {
            this.crO = i;
        }
    }

    public int ckv() {
        return this.crL;
    }

    public void Af(int i) {
        if (i <= 3 && i >= 1) {
            this.crL = i;
        }
    }

    public boolean ckw() {
        return this.iSN;
    }

    public void Ag(int i) {
        switch (i) {
            case 1:
                this.iSN = true;
                return;
            default:
                this.iSN = false;
                return;
        }
    }

    public SimpleUser aDn() {
        return this.iSP;
    }

    public void b(SimpleUser simpleUser) {
        this.iSP = simpleUser;
    }

    public void Ah(int i) {
        this.iSQ = i;
    }

    public void Ai(int i) {
        if (i == 0) {
            this.iSO = 1;
        } else {
            this.iSO = i;
        }
    }

    public int ckx() {
        return this.iSO;
    }
}
