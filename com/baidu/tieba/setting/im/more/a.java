package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dqQ;
    private int dqT;
    private int jLZ;
    private int jMa;
    private boolean jMb;
    private int jMc;
    private SimpleUser jMd;
    private int jMe;

    public boolean cCd() {
        com.baidu.tbadk.core.sharedPref.b aCY = com.baidu.tbadk.core.sharedPref.b.aCY();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jLZ = aCY.getInt("post" + currentAccount, 0);
        this.jMa = aCY.getInt("like" + currentAccount, 0);
        this.dqQ = aCY.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dqT = aCY.getInt("live" + currentAccount, 0);
        this.jMc = aCY.getInt("reply" + currentAccount, 1);
        this.jMb = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jLZ == 0 && this.jMa == 0 && this.dqQ == 0 && this.dqT == 0 && this.jMc == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jLZ = aVar.jLZ;
            this.jMa = aVar.jMa;
            this.dqQ = aVar.dqQ;
            this.jMb = aVar.jMb;
            this.dqT = aVar.dqT;
            this.jMe = aVar.jMe;
            this.jMc = aVar.jMc;
        }
    }

    public int cCe() {
        return this.jLZ;
    }

    public void bq(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aCY().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cCf() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aCY = com.baidu.tbadk.core.sharedPref.b.aCY();
        aCY.putInt("post" + currentAccount, this.jLZ);
        aCY.putInt("like" + currentAccount, this.jMa);
        aCY.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dqQ);
        aCY.putInt("live" + currentAccount, this.dqT);
        aCY.putInt("reply" + currentAccount, this.jMc);
        TbadkCoreApplication.getInst().setLocationShared(this.jMb);
    }

    public void Be(int i) {
        this.jLZ = i;
    }

    public int cCg() {
        return this.jMa;
    }

    public void Bf(int i) {
        if (i <= 3 && i >= 1) {
            this.jMa = i;
        }
    }

    public int cCh() {
        return this.dqT;
    }

    public void Bg(int i) {
        if (i <= 3 && i >= 1) {
            this.dqT = i;
        }
    }

    public int cCi() {
        return this.dqQ;
    }

    public void Bh(int i) {
        if (i <= 3 && i >= 1) {
            this.dqQ = i;
        }
    }

    public boolean cCj() {
        return this.jMb;
    }

    public void Bi(int i) {
        switch (i) {
            case 1:
                this.jMb = true;
                return;
            default:
                this.jMb = false;
                return;
        }
    }

    public SimpleUser aVn() {
        return this.jMd;
    }

    public void b(SimpleUser simpleUser) {
        this.jMd = simpleUser;
    }

    public void Bj(int i) {
        this.jMe = i;
    }

    public void Bk(int i) {
        if (i == 0) {
            this.jMc = 1;
        } else {
            this.jMc = i;
        }
    }

    public int cCk() {
        return this.jMc;
    }
}
