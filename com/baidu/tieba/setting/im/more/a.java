package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fmd;
    private int fmg;
    private int mEQ;
    private int mER;
    private boolean mES;
    private int mET;
    private SimpleUser mEU;
    private int mEV;

    public boolean dCX() {
        com.baidu.tbadk.core.sharedPref.b bqh = com.baidu.tbadk.core.sharedPref.b.bqh();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mEQ = bqh.getInt("post" + currentAccount, 0);
        this.mER = bqh.getInt("like" + currentAccount, 0);
        this.fmd = bqh.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fmg = bqh.getInt("live" + currentAccount, 0);
        this.mET = bqh.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bqh.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bqh.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mES = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mEQ == 0 && this.mER == 0 && this.fmd == 0 && this.fmg == 0 && this.mET == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mEQ = aVar.mEQ;
            this.mER = aVar.mER;
            this.fmd = aVar.fmd;
            this.mES = aVar.mES;
            this.fmg = aVar.fmg;
            this.mEV = aVar.mEV;
            this.mET = aVar.mET;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dCY() {
        return this.mEQ;
    }

    public void bH(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bqh().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dCZ() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bqh = com.baidu.tbadk.core.sharedPref.b.bqh();
        bqh.putInt("post" + currentAccount, this.mEQ);
        bqh.putInt("like" + currentAccount, this.mER);
        bqh.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fmd);
        bqh.putInt("live" + currentAccount, this.fmg);
        bqh.putInt("reply" + currentAccount, this.mET);
        bqh.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bqh.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mES);
    }

    public void Iu(int i) {
        this.mEQ = i;
    }

    public int dDa() {
        return this.mER;
    }

    public void Iv(int i) {
        if (i <= 3 && i >= 1) {
            this.mER = i;
        }
    }

    public int dDb() {
        return this.fmg;
    }

    public void Iw(int i) {
        if (i <= 3 && i >= 1) {
            this.fmg = i;
        }
    }

    public int dDc() {
        return this.fmd;
    }

    public void Ix(int i) {
        if (i <= 3 && i >= 1) {
            this.fmd = i;
        }
    }

    public boolean dDd() {
        return this.mES;
    }

    public void Iy(int i) {
        switch (i) {
            case 1:
                this.mES = true;
                return;
            default:
                this.mES = false;
                return;
        }
    }

    public SimpleUser bJi() {
        return this.mEU;
    }

    public void b(SimpleUser simpleUser) {
        this.mEU = simpleUser;
    }

    public void Iz(int i) {
        this.mEV = i;
    }

    public void IA(int i) {
        if (i == 0) {
            this.mET = 1;
        } else {
            this.mET = i;
        }
    }

    public int dDe() {
        return this.mET;
    }

    public void IB(int i) {
        this.bazhuShowInside = i;
    }

    public void IC(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
