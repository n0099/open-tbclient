package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int drb;
    private int dre;
    private int jPC;
    private int jPD;
    private boolean jPE;
    private int jPF;
    private SimpleUser jPG;
    private int jPH;

    public boolean cDh() {
        com.baidu.tbadk.core.sharedPref.b aDr = com.baidu.tbadk.core.sharedPref.b.aDr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jPC = aDr.getInt("post" + currentAccount, 0);
        this.jPD = aDr.getInt("like" + currentAccount, 0);
        this.drb = aDr.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dre = aDr.getInt("live" + currentAccount, 0);
        this.jPF = aDr.getInt("reply" + currentAccount, 1);
        this.jPE = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jPC == 0 && this.jPD == 0 && this.drb == 0 && this.dre == 0 && this.jPF == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jPC = aVar.jPC;
            this.jPD = aVar.jPD;
            this.drb = aVar.drb;
            this.jPE = aVar.jPE;
            this.dre = aVar.dre;
            this.jPH = aVar.jPH;
            this.jPF = aVar.jPF;
        }
    }

    public int cDi() {
        return this.jPC;
    }

    public void br(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cDj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aDr = com.baidu.tbadk.core.sharedPref.b.aDr();
        aDr.putInt("post" + currentAccount, this.jPC);
        aDr.putInt("like" + currentAccount, this.jPD);
        aDr.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.drb);
        aDr.putInt("live" + currentAccount, this.dre);
        aDr.putInt("reply" + currentAccount, this.jPF);
        TbadkCoreApplication.getInst().setLocationShared(this.jPE);
    }

    public void Bj(int i) {
        this.jPC = i;
    }

    public int cDk() {
        return this.jPD;
    }

    public void Bk(int i) {
        if (i <= 3 && i >= 1) {
            this.jPD = i;
        }
    }

    public int cDl() {
        return this.dre;
    }

    public void Bl(int i) {
        if (i <= 3 && i >= 1) {
            this.dre = i;
        }
    }

    public int cDm() {
        return this.drb;
    }

    public void Bm(int i) {
        if (i <= 3 && i >= 1) {
            this.drb = i;
        }
    }

    public boolean cDn() {
        return this.jPE;
    }

    public void Bn(int i) {
        switch (i) {
            case 1:
                this.jPE = true;
                return;
            default:
                this.jPE = false;
                return;
        }
    }

    public SimpleUser aVG() {
        return this.jPG;
    }

    public void b(SimpleUser simpleUser) {
        this.jPG = simpleUser;
    }

    public void Bo(int i) {
        this.jPH = i;
    }

    public void Bp(int i) {
        if (i == 0) {
            this.jPF = 1;
        } else {
            this.jPF = i;
        }
    }

    public int cDo() {
        return this.jPF;
    }
}
