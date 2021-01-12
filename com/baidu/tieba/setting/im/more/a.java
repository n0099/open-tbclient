package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fxL;
    private int fxO;
    private int mUi;
    private int mUj;
    private boolean mUl;
    private int mUm;
    private SimpleUser mUn;
    private int mUo;

    public boolean dDM() {
        com.baidu.tbadk.core.sharedPref.b brx = com.baidu.tbadk.core.sharedPref.b.brx();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mUi = brx.getInt("post" + currentAccount, 0);
        this.mUj = brx.getInt("like" + currentAccount, 0);
        this.fxL = brx.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fxO = brx.getInt("live" + currentAccount, 0);
        this.mUm = brx.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = brx.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = brx.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mUl = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mUi == 0 && this.mUj == 0 && this.fxL == 0 && this.fxO == 0 && this.mUm == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mUi = aVar.mUi;
            this.mUj = aVar.mUj;
            this.fxL = aVar.fxL;
            this.mUl = aVar.mUl;
            this.fxO = aVar.fxO;
            this.mUo = aVar.mUo;
            this.mUm = aVar.mUm;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dDN() {
        return this.mUi;
    }

    public void bQ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dDO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b brx = com.baidu.tbadk.core.sharedPref.b.brx();
        brx.putInt("post" + currentAccount, this.mUi);
        brx.putInt("like" + currentAccount, this.mUj);
        brx.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fxL);
        brx.putInt("live" + currentAccount, this.fxO);
        brx.putInt("reply" + currentAccount, this.mUm);
        brx.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        brx.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mUl);
    }

    public void HZ(int i) {
        this.mUi = i;
    }

    public int dDP() {
        return this.mUj;
    }

    public void Ia(int i) {
        if (i <= 3 && i >= 1) {
            this.mUj = i;
        }
    }

    public int dDQ() {
        return this.fxO;
    }

    public void Ib(int i) {
        if (i <= 3 && i >= 1) {
            this.fxO = i;
        }
    }

    public int dDR() {
        return this.fxL;
    }

    public void Ic(int i) {
        if (i <= 3 && i >= 1) {
            this.fxL = i;
        }
    }

    public boolean dDS() {
        return this.mUl;
    }

    public void Id(int i) {
        switch (i) {
            case 1:
                this.mUl = true;
                return;
            default:
                this.mUl = false;
                return;
        }
    }

    public SimpleUser bKM() {
        return this.mUn;
    }

    public void b(SimpleUser simpleUser) {
        this.mUn = simpleUser;
    }

    public void Ie(int i) {
        this.mUo = i;
    }

    public void If(int i) {
        if (i == 0) {
            this.mUm = 1;
        } else {
            this.mUm = i;
        }
    }

    public int dDT() {
        return this.mUm;
    }

    public void Ig(int i) {
        this.bazhuShowInside = i;
    }

    public void Ih(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
