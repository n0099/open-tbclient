package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dvk;
    private int dvn;
    private int jQE;
    private int jQF;
    private boolean jQG;
    private int jQH;
    private SimpleUser jQI;
    private int jQJ;

    public boolean cEM() {
        com.baidu.tbadk.core.sharedPref.b aFD = com.baidu.tbadk.core.sharedPref.b.aFD();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jQE = aFD.getInt("post" + currentAccount, 0);
        this.jQF = aFD.getInt("like" + currentAccount, 0);
        this.dvk = aFD.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dvn = aFD.getInt("live" + currentAccount, 0);
        this.jQH = aFD.getInt("reply" + currentAccount, 1);
        this.jQG = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jQE == 0 && this.jQF == 0 && this.dvk == 0 && this.dvn == 0 && this.jQH == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jQE = aVar.jQE;
            this.jQF = aVar.jQF;
            this.dvk = aVar.dvk;
            this.jQG = aVar.jQG;
            this.dvn = aVar.dvn;
            this.jQJ = aVar.jQJ;
            this.jQH = aVar.jQH;
        }
    }

    public int cEN() {
        return this.jQE;
    }

    public void bq(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aFD().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cEO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aFD = com.baidu.tbadk.core.sharedPref.b.aFD();
        aFD.putInt("post" + currentAccount, this.jQE);
        aFD.putInt("like" + currentAccount, this.jQF);
        aFD.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dvk);
        aFD.putInt("live" + currentAccount, this.dvn);
        aFD.putInt("reply" + currentAccount, this.jQH);
        TbadkCoreApplication.getInst().setLocationShared(this.jQG);
    }

    public void Bs(int i) {
        this.jQE = i;
    }

    public int cEP() {
        return this.jQF;
    }

    public void Bt(int i) {
        if (i <= 3 && i >= 1) {
            this.jQF = i;
        }
    }

    public int cEQ() {
        return this.dvn;
    }

    public void Bu(int i) {
        if (i <= 3 && i >= 1) {
            this.dvn = i;
        }
    }

    public int cER() {
        return this.dvk;
    }

    public void Bv(int i) {
        if (i <= 3 && i >= 1) {
            this.dvk = i;
        }
    }

    public boolean cES() {
        return this.jQG;
    }

    public void Bw(int i) {
        switch (i) {
            case 1:
                this.jQG = true;
                return;
            default:
                this.jQG = false;
                return;
        }
    }

    public SimpleUser aXX() {
        return this.jQI;
    }

    public void b(SimpleUser simpleUser) {
        this.jQI = simpleUser;
    }

    public void Bx(int i) {
        this.jQJ = i;
    }

    public void By(int i) {
        if (i == 0) {
            this.jQH = 1;
        } else {
            this.jQH = i;
        }
    }

    public int cET() {
        return this.jQH;
    }
}
