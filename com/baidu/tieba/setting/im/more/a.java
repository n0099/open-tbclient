package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fBA;
    private int fBD;
    private SimpleUser ngA;
    private int ngB;
    private int ngw;
    private int ngx;
    private boolean ngy;
    private int ngz;

    public boolean dGm() {
        com.baidu.tbadk.core.sharedPref.b brR = com.baidu.tbadk.core.sharedPref.b.brR();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ngw = brR.getInt("post" + currentAccount, 0);
        this.ngx = brR.getInt("like" + currentAccount, 0);
        this.fBA = brR.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fBD = brR.getInt("live" + currentAccount, 0);
        this.ngz = brR.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = brR.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = brR.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.ngy = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ngw == 0 && this.ngx == 0 && this.fBA == 0 && this.fBD == 0 && this.ngz == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ngw = aVar.ngw;
            this.ngx = aVar.ngx;
            this.fBA = aVar.fBA;
            this.ngy = aVar.ngy;
            this.fBD = aVar.fBD;
            this.ngB = aVar.ngB;
            this.ngz = aVar.ngz;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dGn() {
        return this.ngw;
    }

    public void bR(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dGo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b brR = com.baidu.tbadk.core.sharedPref.b.brR();
        brR.putInt("post" + currentAccount, this.ngw);
        brR.putInt("like" + currentAccount, this.ngx);
        brR.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fBA);
        brR.putInt("live" + currentAccount, this.fBD);
        brR.putInt("reply" + currentAccount, this.ngz);
        brR.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        brR.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.ngy);
    }

    public void Ix(int i) {
        this.ngw = i;
    }

    public int dGp() {
        return this.ngx;
    }

    public void Iy(int i) {
        if (i <= 3 && i >= 1) {
            this.ngx = i;
        }
    }

    public int dGq() {
        return this.fBD;
    }

    public void Iz(int i) {
        if (i <= 3 && i >= 1) {
            this.fBD = i;
        }
    }

    public int dGr() {
        return this.fBA;
    }

    public void IA(int i) {
        if (i <= 3 && i >= 1) {
            this.fBA = i;
        }
    }

    public boolean dGs() {
        return this.ngy;
    }

    public void IB(int i) {
        switch (i) {
            case 1:
                this.ngy = true;
                return;
            default:
                this.ngy = false;
                return;
        }
    }

    public SimpleUser bLp() {
        return this.ngA;
    }

    public void b(SimpleUser simpleUser) {
        this.ngA = simpleUser;
    }

    public void IC(int i) {
        this.ngB = i;
    }

    public void ID(int i) {
        if (i == 0) {
            this.ngz = 1;
        } else {
            this.ngz = i;
        }
    }

    public int dGt() {
        return this.ngz;
    }

    public void IE(int i) {
        this.bazhuShowInside = i;
    }

    public void IF(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
