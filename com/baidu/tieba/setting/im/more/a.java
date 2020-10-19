package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int eXO;
    private int eXR;
    private int mmo;
    private int mmp;
    private boolean mmq;
    private int mmr;
    private SimpleUser mms;
    private int mmt;

    public boolean dxn() {
        com.baidu.tbadk.core.sharedPref.b blO = com.baidu.tbadk.core.sharedPref.b.blO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mmo = blO.getInt("post" + currentAccount, 0);
        this.mmp = blO.getInt("like" + currentAccount, 0);
        this.eXO = blO.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.eXR = blO.getInt("live" + currentAccount, 0);
        this.mmr = blO.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = blO.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = blO.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mmq = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mmo == 0 && this.mmp == 0 && this.eXO == 0 && this.eXR == 0 && this.mmr == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mmo = aVar.mmo;
            this.mmp = aVar.mmp;
            this.eXO = aVar.eXO;
            this.mmq = aVar.mmq;
            this.eXR = aVar.eXR;
            this.mmt = aVar.mmt;
            this.mmr = aVar.mmr;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dxo() {
        return this.mmo;
    }

    public void bE(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.blO().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dxp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b blO = com.baidu.tbadk.core.sharedPref.b.blO();
        blO.putInt("post" + currentAccount, this.mmo);
        blO.putInt("like" + currentAccount, this.mmp);
        blO.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.eXO);
        blO.putInt("live" + currentAccount, this.eXR);
        blO.putInt("reply" + currentAccount, this.mmr);
        blO.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        blO.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mmq);
    }

    public void HO(int i) {
        this.mmo = i;
    }

    public int dxq() {
        return this.mmp;
    }

    public void HP(int i) {
        if (i <= 3 && i >= 1) {
            this.mmp = i;
        }
    }

    public int dxr() {
        return this.eXR;
    }

    public void HQ(int i) {
        if (i <= 3 && i >= 1) {
            this.eXR = i;
        }
    }

    public int dxs() {
        return this.eXO;
    }

    public void HR(int i) {
        if (i <= 3 && i >= 1) {
            this.eXO = i;
        }
    }

    public boolean dxt() {
        return this.mmq;
    }

    public void HS(int i) {
        switch (i) {
            case 1:
                this.mmq = true;
                return;
            default:
                this.mmq = false;
                return;
        }
    }

    public SimpleUser bEQ() {
        return this.mms;
    }

    public void b(SimpleUser simpleUser) {
        this.mms = simpleUser;
    }

    public void HT(int i) {
        this.mmt = i;
    }

    public void HU(int i) {
        if (i == 0) {
            this.mmr = 1;
        } else {
            this.mmr = i;
        }
    }

    public int dxu() {
        return this.mmr;
    }

    public void HV(int i) {
        this.bazhuShowInside = i;
    }

    public void HW(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
