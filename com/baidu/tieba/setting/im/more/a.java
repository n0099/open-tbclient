package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dVJ;
    private int dVM;
    private int kBE;
    private int kBF;
    private boolean kBG;
    private int kBH;
    private SimpleUser kBI;
    private int kBJ;

    public boolean cPC() {
        com.baidu.tbadk.core.sharedPref.b aNT = com.baidu.tbadk.core.sharedPref.b.aNT();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kBE = aNT.getInt("post" + currentAccount, 0);
        this.kBF = aNT.getInt("like" + currentAccount, 0);
        this.dVJ = aNT.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dVM = aNT.getInt("live" + currentAccount, 0);
        this.kBH = aNT.getInt("reply" + currentAccount, 1);
        this.kBG = TbadkCoreApplication.getInst().getLocationShared();
        return (this.kBE == 0 && this.kBF == 0 && this.dVJ == 0 && this.dVM == 0 && this.kBH == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.kBE = aVar.kBE;
            this.kBF = aVar.kBF;
            this.dVJ = aVar.dVJ;
            this.kBG = aVar.kBG;
            this.dVM = aVar.dVM;
            this.kBJ = aVar.kBJ;
            this.kBH = aVar.kBH;
        }
    }

    public int cPD() {
        return this.kBE;
    }

    public void bA(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aNT().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cPE() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aNT = com.baidu.tbadk.core.sharedPref.b.aNT();
        aNT.putInt("post" + currentAccount, this.kBE);
        aNT.putInt("like" + currentAccount, this.kBF);
        aNT.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dVJ);
        aNT.putInt("live" + currentAccount, this.dVM);
        aNT.putInt("reply" + currentAccount, this.kBH);
        TbadkCoreApplication.getInst().setLocationShared(this.kBG);
    }

    public void Ca(int i) {
        this.kBE = i;
    }

    public int cPF() {
        return this.kBF;
    }

    public void Cb(int i) {
        if (i <= 3 && i >= 1) {
            this.kBF = i;
        }
    }

    public int cPG() {
        return this.dVM;
    }

    public void Cc(int i) {
        if (i <= 3 && i >= 1) {
            this.dVM = i;
        }
    }

    public int cPH() {
        return this.dVJ;
    }

    public void Cd(int i) {
        if (i <= 3 && i >= 1) {
            this.dVJ = i;
        }
    }

    public boolean cPI() {
        return this.kBG;
    }

    public void Ce(int i) {
        switch (i) {
            case 1:
                this.kBG = true;
                return;
            default:
                this.kBG = false;
                return;
        }
    }

    public SimpleUser bgf() {
        return this.kBI;
    }

    public void b(SimpleUser simpleUser) {
        this.kBI = simpleUser;
    }

    public void Cf(int i) {
        this.kBJ = i;
    }

    public void Cg(int i) {
        if (i == 0) {
            this.kBH = 1;
        } else {
            this.kBH = i;
        }
    }

    public int cPJ() {
        return this.kBH;
    }
}
