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
    private int mTs;
    private int mTt;
    private boolean mTu;
    private int mTv;
    private SimpleUser mTw;
    private int mTx;

    public boolean dHN() {
        com.baidu.tbadk.core.sharedPref.b bsO = com.baidu.tbadk.core.sharedPref.b.bsO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mTs = bsO.getInt("post" + currentAccount, 0);
        this.mTt = bsO.getInt("like" + currentAccount, 0);
        this.fsO = bsO.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fsR = bsO.getInt("live" + currentAccount, 0);
        this.mTv = bsO.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bsO.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bsO.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mTu = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mTs == 0 && this.mTt == 0 && this.fsO == 0 && this.fsR == 0 && this.mTv == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mTs = aVar.mTs;
            this.mTt = aVar.mTt;
            this.fsO = aVar.fsO;
            this.mTu = aVar.mTu;
            this.fsR = aVar.fsR;
            this.mTx = aVar.mTx;
            this.mTv = aVar.mTv;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dHO() {
        return this.mTs;
    }

    public void bJ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bsO().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dHP() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bsO = com.baidu.tbadk.core.sharedPref.b.bsO();
        bsO.putInt("post" + currentAccount, this.mTs);
        bsO.putInt("like" + currentAccount, this.mTt);
        bsO.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fsO);
        bsO.putInt("live" + currentAccount, this.fsR);
        bsO.putInt("reply" + currentAccount, this.mTv);
        bsO.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bsO.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mTu);
    }

    public void JM(int i) {
        this.mTs = i;
    }

    public int dHQ() {
        return this.mTt;
    }

    public void JN(int i) {
        if (i <= 3 && i >= 1) {
            this.mTt = i;
        }
    }

    public int dHR() {
        return this.fsR;
    }

    public void JO(int i) {
        if (i <= 3 && i >= 1) {
            this.fsR = i;
        }
    }

    public int dHS() {
        return this.fsO;
    }

    public void JP(int i) {
        if (i <= 3 && i >= 1) {
            this.fsO = i;
        }
    }

    public boolean dHT() {
        return this.mTu;
    }

    public void JQ(int i) {
        switch (i) {
            case 1:
                this.mTu = true;
                return;
            default:
                this.mTu = false;
                return;
        }
    }

    public SimpleUser bMl() {
        return this.mTw;
    }

    public void b(SimpleUser simpleUser) {
        this.mTw = simpleUser;
    }

    public void JR(int i) {
        this.mTx = i;
    }

    public void JS(int i) {
        if (i == 0) {
            this.mTv = 1;
        } else {
            this.mTv = i;
        }
    }

    public int dHU() {
        return this.mTv;
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
