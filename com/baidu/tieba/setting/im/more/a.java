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
    private int ner;
    private int nes;
    private boolean neu;
    private int nev;

    /* renamed from: new  reason: not valid java name */
    private SimpleUser f5new;
    private int nex;

    public boolean dGe() {
        com.baidu.tbadk.core.sharedPref.b brQ = com.baidu.tbadk.core.sharedPref.b.brQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ner = brQ.getInt("post" + currentAccount, 0);
        this.nes = brQ.getInt("like" + currentAccount, 0);
        this.fAb = brQ.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fAe = brQ.getInt("live" + currentAccount, 0);
        this.nev = brQ.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = brQ.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = brQ.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.neu = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ner == 0 && this.nes == 0 && this.fAb == 0 && this.fAe == 0 && this.nev == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ner = aVar.ner;
            this.nes = aVar.nes;
            this.fAb = aVar.fAb;
            this.neu = aVar.neu;
            this.fAe = aVar.fAe;
            this.nex = aVar.nex;
            this.nev = aVar.nev;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dGf() {
        return this.ner;
    }

    public void bR(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.brQ().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dGg() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b brQ = com.baidu.tbadk.core.sharedPref.b.brQ();
        brQ.putInt("post" + currentAccount, this.ner);
        brQ.putInt("like" + currentAccount, this.nes);
        brQ.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fAb);
        brQ.putInt("live" + currentAccount, this.fAe);
        brQ.putInt("reply" + currentAccount, this.nev);
        brQ.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        brQ.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.neu);
    }

    public void It(int i) {
        this.ner = i;
    }

    public int dGh() {
        return this.nes;
    }

    public void Iu(int i) {
        if (i <= 3 && i >= 1) {
            this.nes = i;
        }
    }

    public int dGi() {
        return this.fAe;
    }

    public void Iv(int i) {
        if (i <= 3 && i >= 1) {
            this.fAe = i;
        }
    }

    public int dGj() {
        return this.fAb;
    }

    public void Iw(int i) {
        if (i <= 3 && i >= 1) {
            this.fAb = i;
        }
    }

    public boolean dGk() {
        return this.neu;
    }

    public void Ix(int i) {
        switch (i) {
            case 1:
                this.neu = true;
                return;
            default:
                this.neu = false;
                return;
        }
    }

    public SimpleUser bLl() {
        return this.f5new;
    }

    public void b(SimpleUser simpleUser) {
        this.f5new = simpleUser;
    }

    public void Iy(int i) {
        this.nex = i;
    }

    public void Iz(int i) {
        if (i == 0) {
            this.nev = 1;
        } else {
            this.nev = i;
        }
    }

    public int dGl() {
        return this.nev;
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
