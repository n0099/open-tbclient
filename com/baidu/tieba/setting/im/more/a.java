package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int bazhuShowInside;
    private int bazhuShowOutside;
    private int fCt;
    private int fCw;
    private int mYQ;
    private int mYR;
    private boolean mYS;
    private int mYT;
    private SimpleUser mYU;
    private int mYV;

    public boolean dHD() {
        com.baidu.tbadk.core.sharedPref.b bvq = com.baidu.tbadk.core.sharedPref.b.bvq();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mYQ = bvq.getInt("post" + currentAccount, 0);
        this.mYR = bvq.getInt("like" + currentAccount, 0);
        this.fCt = bvq.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fCw = bvq.getInt("live" + currentAccount, 0);
        this.mYT = bvq.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bvq.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bvq.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mYS = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mYQ == 0 && this.mYR == 0 && this.fCt == 0 && this.fCw == 0 && this.mYT == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mYQ = aVar.mYQ;
            this.mYR = aVar.mYR;
            this.fCt = aVar.fCt;
            this.mYS = aVar.mYS;
            this.fCw = aVar.fCw;
            this.mYV = aVar.mYV;
            this.mYT = aVar.mYT;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dHE() {
        return this.mYQ;
    }

    public void bQ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bvq().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dHF() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bvq = com.baidu.tbadk.core.sharedPref.b.bvq();
        bvq.putInt("post" + currentAccount, this.mYQ);
        bvq.putInt("like" + currentAccount, this.mYR);
        bvq.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fCt);
        bvq.putInt("live" + currentAccount, this.fCw);
        bvq.putInt("reply" + currentAccount, this.mYT);
        bvq.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bvq.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mYS);
    }

    public void JG(int i) {
        this.mYQ = i;
    }

    public int dHG() {
        return this.mYR;
    }

    public void JH(int i) {
        if (i <= 3 && i >= 1) {
            this.mYR = i;
        }
    }

    public int dHH() {
        return this.fCw;
    }

    public void JI(int i) {
        if (i <= 3 && i >= 1) {
            this.fCw = i;
        }
    }

    public int dHI() {
        return this.fCt;
    }

    public void JJ(int i) {
        if (i <= 3 && i >= 1) {
            this.fCt = i;
        }
    }

    public boolean dHJ() {
        return this.mYS;
    }

    public void JK(int i) {
        switch (i) {
            case 1:
                this.mYS = true;
                return;
            default:
                this.mYS = false;
                return;
        }
    }

    public SimpleUser bOD() {
        return this.mYU;
    }

    public void b(SimpleUser simpleUser) {
        this.mYU = simpleUser;
    }

    public void JL(int i) {
        this.mYV = i;
    }

    public void JM(int i) {
        if (i == 0) {
            this.mYT = 1;
        } else {
            this.mYT = i;
        }
    }

    public int dHK() {
        return this.mYT;
    }

    public void JN(int i) {
        this.bazhuShowInside = i;
    }

    public void JO(int i) {
        this.bazhuShowOutside = i;
    }

    public int getBazhuShowOutside() {
        return this.bazhuShowOutside;
    }

    public int getBazhuShowInside() {
        return this.bazhuShowInside;
    }
}
