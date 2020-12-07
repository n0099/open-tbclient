package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fsO;
    private int fsR;
    private int mTq;
    private int mTr;
    private boolean mTs;
    private int mTt;
    private SimpleUser mTu;
    private int mTv;

    public boolean dHM() {
        com.baidu.tbadk.core.sharedPref.b bsO = com.baidu.tbadk.core.sharedPref.b.bsO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mTq = bsO.getInt("post" + currentAccount, 0);
        this.mTr = bsO.getInt("like" + currentAccount, 0);
        this.fsO = bsO.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fsR = bsO.getInt("live" + currentAccount, 0);
        this.mTt = bsO.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bsO.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bsO.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mTs = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mTq == 0 && this.mTr == 0 && this.fsO == 0 && this.fsR == 0 && this.mTt == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mTq = aVar.mTq;
            this.mTr = aVar.mTr;
            this.fsO = aVar.fsO;
            this.mTs = aVar.mTs;
            this.fsR = aVar.fsR;
            this.mTv = aVar.mTv;
            this.mTt = aVar.mTt;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dHN() {
        return this.mTq;
    }

    public void bJ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dHO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bsO = com.baidu.tbadk.core.sharedPref.b.bsO();
        bsO.putInt("post" + currentAccount, this.mTq);
        bsO.putInt("like" + currentAccount, this.mTr);
        bsO.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fsO);
        bsO.putInt("live" + currentAccount, this.fsR);
        bsO.putInt("reply" + currentAccount, this.mTt);
        bsO.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bsO.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mTs);
    }

    public void JM(int i) {
        this.mTq = i;
    }

    public int dHP() {
        return this.mTr;
    }

    public void JN(int i) {
        if (i <= 3 && i >= 1) {
            this.mTr = i;
        }
    }

    public int dHQ() {
        return this.fsR;
    }

    public void JO(int i) {
        if (i <= 3 && i >= 1) {
            this.fsR = i;
        }
    }

    public int dHR() {
        return this.fsO;
    }

    public void JP(int i) {
        if (i <= 3 && i >= 1) {
            this.fsO = i;
        }
    }

    public boolean dHS() {
        return this.mTs;
    }

    public void JQ(int i) {
        switch (i) {
            case 1:
                this.mTs = true;
                return;
            default:
                this.mTs = false;
                return;
        }
    }

    public SimpleUser bMk() {
        return this.mTu;
    }

    public void b(SimpleUser simpleUser) {
        this.mTu = simpleUser;
    }

    public void JR(int i) {
        this.mTv = i;
    }

    public void JS(int i) {
        if (i == 0) {
            this.mTt = 1;
        } else {
            this.mTt = i;
        }
    }

    public int dHT() {
        return this.mTt;
    }

    public void JT(int i) {
        this.bazhuShowInside = i;
    }

    public void JU(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
