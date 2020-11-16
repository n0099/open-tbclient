package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fll;
    private int flo;
    private int mFo;
    private int mFp;
    private boolean mFq;
    private int mFr;
    private SimpleUser mFs;
    private int mFt;

    public boolean dCB() {
        com.baidu.tbadk.core.sharedPref.b bpu = com.baidu.tbadk.core.sharedPref.b.bpu();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mFo = bpu.getInt("post" + currentAccount, 0);
        this.mFp = bpu.getInt("like" + currentAccount, 0);
        this.fll = bpu.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.flo = bpu.getInt("live" + currentAccount, 0);
        this.mFr = bpu.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bpu.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bpu.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mFq = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mFo == 0 && this.mFp == 0 && this.fll == 0 && this.flo == 0 && this.mFr == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mFo = aVar.mFo;
            this.mFp = aVar.mFp;
            this.fll = aVar.fll;
            this.mFq = aVar.mFq;
            this.flo = aVar.flo;
            this.mFt = aVar.mFt;
            this.mFr = aVar.mFr;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dCC() {
        return this.mFo;
    }

    public void bG(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bpu().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dCD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bpu = com.baidu.tbadk.core.sharedPref.b.bpu();
        bpu.putInt("post" + currentAccount, this.mFo);
        bpu.putInt("like" + currentAccount, this.mFp);
        bpu.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fll);
        bpu.putInt("live" + currentAccount, this.flo);
        bpu.putInt("reply" + currentAccount, this.mFr);
        bpu.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bpu.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mFq);
    }

    public void IV(int i) {
        this.mFo = i;
    }

    public int dCE() {
        return this.mFp;
    }

    public void IW(int i) {
        if (i <= 3 && i >= 1) {
            this.mFp = i;
        }
    }

    public int dCF() {
        return this.flo;
    }

    public void IX(int i) {
        if (i <= 3 && i >= 1) {
            this.flo = i;
        }
    }

    public int dCG() {
        return this.fll;
    }

    public void IY(int i) {
        if (i <= 3 && i >= 1) {
            this.fll = i;
        }
    }

    public boolean dCH() {
        return this.mFq;
    }

    public void IZ(int i) {
        switch (i) {
            case 1:
                this.mFq = true;
                return;
            default:
                this.mFq = false;
                return;
        }
    }

    public SimpleUser bIC() {
        return this.mFs;
    }

    public void b(SimpleUser simpleUser) {
        this.mFs = simpleUser;
    }

    public void Ja(int i) {
        this.mFt = i;
    }

    public void Jb(int i) {
        if (i == 0) {
            this.mFr = 1;
        } else {
            this.mFr = i;
        }
    }

    public int dCI() {
        return this.mFr;
    }

    public void Jc(int i) {
        this.bazhuShowInside = i;
    }

    public void Jd(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
