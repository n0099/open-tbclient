package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dVE;
    private int dVH;
    private int kBA;
    private int kBB;
    private boolean kBC;
    private int kBD;
    private SimpleUser kBE;
    private int kBF;

    public boolean cPF() {
        com.baidu.tbadk.core.sharedPref.b aNV = com.baidu.tbadk.core.sharedPref.b.aNV();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.kBA = aNV.getInt("post" + currentAccount, 0);
        this.kBB = aNV.getInt("like" + currentAccount, 0);
        this.dVE = aNV.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dVH = aNV.getInt("live" + currentAccount, 0);
        this.kBD = aNV.getInt("reply" + currentAccount, 1);
        this.kBC = TbadkCoreApplication.getInst().getLocationShared();
        return (this.kBA == 0 && this.kBB == 0 && this.dVE == 0 && this.dVH == 0 && this.kBD == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.kBA = aVar.kBA;
            this.kBB = aVar.kBB;
            this.dVE = aVar.dVE;
            this.kBC = aVar.kBC;
            this.dVH = aVar.dVH;
            this.kBF = aVar.kBF;
            this.kBD = aVar.kBD;
        }
    }

    public int cPG() {
        return this.kBA;
    }

    public void bA(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aNV().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cPH() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aNV = com.baidu.tbadk.core.sharedPref.b.aNV();
        aNV.putInt("post" + currentAccount, this.kBA);
        aNV.putInt("like" + currentAccount, this.kBB);
        aNV.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dVE);
        aNV.putInt("live" + currentAccount, this.dVH);
        aNV.putInt("reply" + currentAccount, this.kBD);
        TbadkCoreApplication.getInst().setLocationShared(this.kBC);
    }

    public void Ca(int i) {
        this.kBA = i;
    }

    public int cPI() {
        return this.kBB;
    }

    public void Cb(int i) {
        if (i <= 3 && i >= 1) {
            this.kBB = i;
        }
    }

    public int cPJ() {
        return this.dVH;
    }

    public void Cc(int i) {
        if (i <= 3 && i >= 1) {
            this.dVH = i;
        }
    }

    public int cPK() {
        return this.dVE;
    }

    public void Cd(int i) {
        if (i <= 3 && i >= 1) {
            this.dVE = i;
        }
    }

    public boolean cPL() {
        return this.kBC;
    }

    public void Ce(int i) {
        switch (i) {
            case 1:
                this.kBC = true;
                return;
            default:
                this.kBC = false;
                return;
        }
    }

    public SimpleUser bgh() {
        return this.kBE;
    }

    public void b(SimpleUser simpleUser) {
        this.kBE = simpleUser;
    }

    public void Cf(int i) {
        this.kBF = i;
    }

    public void Cg(int i) {
        if (i == 0) {
            this.kBD = 1;
        } else {
            this.kBD = i;
        }
    }

    public int cPM() {
        return this.kBD;
    }
}
