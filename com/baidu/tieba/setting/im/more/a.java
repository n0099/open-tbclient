package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fgk;
    private int fgn;
    private int myP;
    private int myQ;
    private boolean myR;
    private int myS;
    private SimpleUser myT;
    private int myU;

    public boolean dAv() {
        com.baidu.tbadk.core.sharedPref.b bnH = com.baidu.tbadk.core.sharedPref.b.bnH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.myP = bnH.getInt("post" + currentAccount, 0);
        this.myQ = bnH.getInt("like" + currentAccount, 0);
        this.fgk = bnH.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fgn = bnH.getInt("live" + currentAccount, 0);
        this.myS = bnH.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bnH.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bnH.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.myR = TbadkCoreApplication.getInst().getLocationShared();
        return (this.myP == 0 && this.myQ == 0 && this.fgk == 0 && this.fgn == 0 && this.myS == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.myP = aVar.myP;
            this.myQ = aVar.myQ;
            this.fgk = aVar.fgk;
            this.myR = aVar.myR;
            this.fgn = aVar.fgn;
            this.myU = aVar.myU;
            this.myS = aVar.myS;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dAw() {
        return this.myP;
    }

    public void bF(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bnH().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dAx() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bnH = com.baidu.tbadk.core.sharedPref.b.bnH();
        bnH.putInt("post" + currentAccount, this.myP);
        bnH.putInt("like" + currentAccount, this.myQ);
        bnH.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fgk);
        bnH.putInt("live" + currentAccount, this.fgn);
        bnH.putInt("reply" + currentAccount, this.myS);
        bnH.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bnH.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.myR);
    }

    public void Ih(int i) {
        this.myP = i;
    }

    public int dAy() {
        return this.myQ;
    }

    public void Ii(int i) {
        if (i <= 3 && i >= 1) {
            this.myQ = i;
        }
    }

    public int dAz() {
        return this.fgn;
    }

    public void Ij(int i) {
        if (i <= 3 && i >= 1) {
            this.fgn = i;
        }
    }

    public int dAA() {
        return this.fgk;
    }

    public void Ik(int i) {
        if (i <= 3 && i >= 1) {
            this.fgk = i;
        }
    }

    public boolean dAB() {
        return this.myR;
    }

    public void Il(int i) {
        switch (i) {
            case 1:
                this.myR = true;
                return;
            default:
                this.myR = false;
                return;
        }
    }

    public SimpleUser bGJ() {
        return this.myT;
    }

    public void b(SimpleUser simpleUser) {
        this.myT = simpleUser;
    }

    public void Im(int i) {
        this.myU = i;
    }

    public void In(int i) {
        if (i == 0) {
            this.myS = 1;
        } else {
            this.myS = i;
        }
    }

    public int dAC() {
        return this.myS;
    }

    public void Io(int i) {
        this.bazhuShowInside = i;
    }

    public void Ip(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
