package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dvj;
    private int dvm;
    private int jQC;
    private int jQD;
    private boolean jQE;
    private int jQF;
    private SimpleUser jQG;
    private int jQH;

    public boolean cEK() {
        com.baidu.tbadk.core.sharedPref.b aFB = com.baidu.tbadk.core.sharedPref.b.aFB();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jQC = aFB.getInt("post" + currentAccount, 0);
        this.jQD = aFB.getInt("like" + currentAccount, 0);
        this.dvj = aFB.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dvm = aFB.getInt("live" + currentAccount, 0);
        this.jQF = aFB.getInt("reply" + currentAccount, 1);
        this.jQE = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jQC == 0 && this.jQD == 0 && this.dvj == 0 && this.dvm == 0 && this.jQF == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jQC = aVar.jQC;
            this.jQD = aVar.jQD;
            this.dvj = aVar.dvj;
            this.jQE = aVar.jQE;
            this.dvm = aVar.dvm;
            this.jQH = aVar.jQH;
            this.jQF = aVar.jQF;
        }
    }

    public int cEL() {
        return this.jQC;
    }

    public void bq(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aFB().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cEM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aFB = com.baidu.tbadk.core.sharedPref.b.aFB();
        aFB.putInt("post" + currentAccount, this.jQC);
        aFB.putInt("like" + currentAccount, this.jQD);
        aFB.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dvj);
        aFB.putInt("live" + currentAccount, this.dvm);
        aFB.putInt("reply" + currentAccount, this.jQF);
        TbadkCoreApplication.getInst().setLocationShared(this.jQE);
    }

    public void Bs(int i) {
        this.jQC = i;
    }

    public int cEN() {
        return this.jQD;
    }

    public void Bt(int i) {
        if (i <= 3 && i >= 1) {
            this.jQD = i;
        }
    }

    public int cEO() {
        return this.dvm;
    }

    public void Bu(int i) {
        if (i <= 3 && i >= 1) {
            this.dvm = i;
        }
    }

    public int cEP() {
        return this.dvj;
    }

    public void Bv(int i) {
        if (i <= 3 && i >= 1) {
            this.dvj = i;
        }
    }

    public boolean cEQ() {
        return this.jQE;
    }

    public void Bw(int i) {
        switch (i) {
            case 1:
                this.jQE = true;
                return;
            default:
                this.jQE = false;
                return;
        }
    }

    public SimpleUser aXV() {
        return this.jQG;
    }

    public void b(SimpleUser simpleUser) {
        this.jQG = simpleUser;
    }

    public void Bx(int i) {
        this.jQH = i;
    }

    public void By(int i) {
        if (i == 0) {
            this.jQF = 1;
        } else {
            this.jQF = i;
        }
    }

    public int cER() {
        return this.jQF;
    }
}
