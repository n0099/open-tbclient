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
    private int mYP;
    private int mYQ;
    private boolean mYR;
    private int mYS;
    private SimpleUser mYT;
    private int mYU;

    public boolean dHE() {
        com.baidu.tbadk.core.sharedPref.b bvr = com.baidu.tbadk.core.sharedPref.b.bvr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.mYP = bvr.getInt("post" + currentAccount, 0);
        this.mYQ = bvr.getInt("like" + currentAccount, 0);
        this.fCt = bvr.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.fCw = bvr.getInt("live" + currentAccount, 0);
        this.mYS = bvr.getInt("reply" + currentAccount, 1);
        this.bazhuShowInside = bvr.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.bazhuShowOutside = bvr.getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.mYR = TbadkCoreApplication.getInst().getLocationShared();
        return (this.mYP == 0 && this.mYQ == 0 && this.fCt == 0 && this.fCw == 0 && this.mYS == 1 && this.bazhuShowInside == 0 && this.bazhuShowOutside == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.mYP = aVar.mYP;
            this.mYQ = aVar.mYQ;
            this.fCt = aVar.fCt;
            this.mYR = aVar.mYR;
            this.fCw = aVar.fCw;
            this.mYU = aVar.mYU;
            this.mYS = aVar.mYS;
            this.bazhuShowOutside = aVar.bazhuShowOutside;
            this.bazhuShowInside = aVar.bazhuShowInside;
        }
    }

    public int dHF() {
        return this.mYP;
    }

    public void bQ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bvr().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dHG() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bvr = com.baidu.tbadk.core.sharedPref.b.bvr();
        bvr.putInt("post" + currentAccount, this.mYP);
        bvr.putInt("like" + currentAccount, this.mYQ);
        bvr.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.fCt);
        bvr.putInt("live" + currentAccount, this.fCw);
        bvr.putInt("reply" + currentAccount, this.mYS);
        bvr.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.bazhuShowInside);
        bvr.putInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.bazhuShowOutside);
        TbadkCoreApplication.getInst().setLocationShared(this.mYR);
    }

    public void JG(int i) {
        this.mYP = i;
    }

    public int dHH() {
        return this.mYQ;
    }

    public void JH(int i) {
        if (i <= 3 && i >= 1) {
            this.mYQ = i;
        }
    }

    public int dHI() {
        return this.fCw;
    }

    public void JI(int i) {
        if (i <= 3 && i >= 1) {
            this.fCw = i;
        }
    }

    public int dHJ() {
        return this.fCt;
    }

    public void JJ(int i) {
        if (i <= 3 && i >= 1) {
            this.fCt = i;
        }
    }

    public boolean dHK() {
        return this.mYR;
    }

    public void JK(int i) {
        switch (i) {
            case 1:
                this.mYR = true;
                return;
            default:
                this.mYR = false;
                return;
        }
    }

    public SimpleUser bOE() {
        return this.mYT;
    }

    public void b(SimpleUser simpleUser) {
        this.mYT = simpleUser;
    }

    public void JL(int i) {
        this.mYU = i;
    }

    public void JM(int i) {
        if (i == 0) {
            this.mYS = 1;
        } else {
            this.mYS = i;
        }
    }

    public int dHL() {
        return this.mYS;
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
