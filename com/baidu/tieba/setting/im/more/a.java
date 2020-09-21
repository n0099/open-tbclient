package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int eLH;
    private int eLK;
    private int lWI;
    private int lWJ;
    private boolean lWK;
    private int lWL;
    private SimpleUser lWM;
    private int lWN;

    public boolean dtC() {
        com.baidu.tbadk.core.sharedPref.b bjf = com.baidu.tbadk.core.sharedPref.b.bjf();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lWI = bjf.getInt("post" + currentAccount, 0);
        this.lWJ = bjf.getInt("like" + currentAccount, 0);
        this.eLH = bjf.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.eLK = bjf.getInt("live" + currentAccount, 0);
        this.lWL = bjf.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bjf.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bjf.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.lWK = TbadkCoreApplication.getInst().getLocationShared();
        return (this.lWI == 0 && this.lWJ == 0 && this.eLH == 0 && this.eLK == 0 && this.lWL == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.lWI = aVar.lWI;
            this.lWJ = aVar.lWJ;
            this.eLH = aVar.eLH;
            this.lWK = aVar.lWK;
            this.eLK = aVar.eLK;
            this.lWN = aVar.lWN;
            this.lWL = aVar.lWL;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dtD() {
        return this.lWI;
    }

    public void bD(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dtE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bjf = com.baidu.tbadk.core.sharedPref.b.bjf();
        bjf.putInt("post" + currentAccount, this.lWI);
        bjf.putInt("like" + currentAccount, this.lWJ);
        bjf.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.eLH);
        bjf.putInt("live" + currentAccount, this.eLK);
        bjf.putInt("reply" + currentAccount, this.lWL);
        bjf.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bjf.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.lWK);
    }

    public void Hi(int i) {
        this.lWI = i;
    }

    public int dtF() {
        return this.lWJ;
    }

    public void Hj(int i) {
        if (i <= 3 && i >= 1) {
            this.lWJ = i;
        }
    }

    public int dtG() {
        return this.eLK;
    }

    public void Hk(int i) {
        if (i <= 3 && i >= 1) {
            this.eLK = i;
        }
    }

    public int dtH() {
        return this.eLH;
    }

    public void Hl(int i) {
        if (i <= 3 && i >= 1) {
            this.eLH = i;
        }
    }

    public boolean dtI() {
        return this.lWK;
    }

    public void Hm(int i) {
        switch (i) {
            case 1:
                this.lWK = true;
                return;
            default:
                this.lWK = false;
                return;
        }
    }

    public SimpleUser bCe() {
        return this.lWM;
    }

    public void b(SimpleUser simpleUser) {
        this.lWM = simpleUser;
    }

    public void Hn(int i) {
        this.lWN = i;
    }

    public void Ho(int i) {
        if (i == 0) {
            this.lWL = 1;
        } else {
            this.lWL = i;
        }
    }

    public int dtJ() {
        return this.lWL;
    }

    public void Hp(int i) {
        this.bazhuShowInside = i;
    }

    public void Hq(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
