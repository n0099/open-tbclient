package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fAb;
    private int fAe;
    private int ndR;
    private int ndS;
    private boolean ndT;
    private int ndU;
    private SimpleUser ndV;
    private int ndW;

    public boolean dFW() {
        com.baidu.tbadk.core.sharedPref.b brQ = com.baidu.tbadk.core.sharedPref.b.brQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ndR = brQ.getInt("post" + currentAccount, 0);
        this.ndS = brQ.getInt("like" + currentAccount, 0);
        this.fAb = brQ.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fAe = brQ.getInt("live" + currentAccount, 0);
        this.ndU = brQ.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = brQ.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = brQ.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.ndT = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ndR == 0 && this.ndS == 0 && this.fAb == 0 && this.fAe == 0 && this.ndU == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ndR = aVar.ndR;
            this.ndS = aVar.ndS;
            this.fAb = aVar.fAb;
            this.ndT = aVar.ndT;
            this.fAe = aVar.fAe;
            this.ndW = aVar.ndW;
            this.ndU = aVar.ndU;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dFX() {
        return this.ndR;
    }

    public void bR(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dFY() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b brQ = com.baidu.tbadk.core.sharedPref.b.brQ();
        brQ.putInt("post" + currentAccount, this.ndR);
        brQ.putInt("like" + currentAccount, this.ndS);
        brQ.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fAb);
        brQ.putInt("live" + currentAccount, this.fAe);
        brQ.putInt("reply" + currentAccount, this.ndU);
        brQ.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        brQ.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.ndT);
    }

    public void It(int i) {
        this.ndR = i;
    }

    public int dFZ() {
        return this.ndS;
    }

    public void Iu(int i) {
        if (i <= 3 && i >= 1) {
            this.ndS = i;
        }
    }

    public int dGa() {
        return this.fAe;
    }

    public void Iv(int i) {
        if (i <= 3 && i >= 1) {
            this.fAe = i;
        }
    }

    public int dGb() {
        return this.fAb;
    }

    public void Iw(int i) {
        if (i <= 3 && i >= 1) {
            this.fAb = i;
        }
    }

    public boolean dGc() {
        return this.ndT;
    }

    public void Ix(int i) {
        switch (i) {
            case 1:
                this.ndT = true;
                return;
            default:
                this.ndT = false;
                return;
        }
    }

    public SimpleUser bLg() {
        return this.ndV;
    }

    public void b(SimpleUser simpleUser) {
        this.ndV = simpleUser;
    }

    public void Iy(int i) {
        this.ndW = i;
    }

    public void Iz(int i) {
        if (i == 0) {
            this.ndU = 1;
        } else {
            this.ndU = i;
        }
    }

    public int dGd() {
        return this.ndU;
    }

    public void IA(int i) {
        this.bazhuShowInside = i;
    }

    public void IB(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
