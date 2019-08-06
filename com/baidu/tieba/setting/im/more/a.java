package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cqQ;
    private int cqT;
    private int iQp;
    private int iQq;
    private boolean iQr;
    private int iQs;
    private SimpleUser iQt;
    private int iQu;

    public boolean cjF() {
        com.baidu.tbadk.core.sharedPref.b ahQ = com.baidu.tbadk.core.sharedPref.b.ahQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iQp = ahQ.getInt("post" + currentAccount, 0);
        this.iQq = ahQ.getInt("like" + currentAccount, 0);
        this.cqQ = ahQ.getInt("group" + currentAccount, 0);
        this.cqT = ahQ.getInt("live" + currentAccount, 0);
        this.iQs = ahQ.getInt("reply" + currentAccount, 1);
        this.iQr = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iQp == 0 && this.iQq == 0 && this.cqQ == 0 && this.cqT == 0 && this.iQs == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iQp = aVar.iQp;
            this.iQq = aVar.iQq;
            this.cqQ = aVar.cqQ;
            this.iQr = aVar.iQr;
            this.cqT = aVar.cqT;
            this.iQu = aVar.iQu;
            this.iQs = aVar.iQs;
        }
    }

    public int cjG() {
        return this.iQp;
    }

    public void bk(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.ahQ().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cjH() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b ahQ = com.baidu.tbadk.core.sharedPref.b.ahQ();
        ahQ.putInt("post" + currentAccount, this.iQp);
        ahQ.putInt("like" + currentAccount, this.iQq);
        ahQ.putInt("group" + currentAccount, this.cqQ);
        ahQ.putInt("live" + currentAccount, this.cqT);
        ahQ.putInt("reply" + currentAccount, this.iQs);
        TbadkCoreApplication.getInst().setLocationShared(this.iQr);
    }

    public void zZ(int i) {
        this.iQp = i;
    }

    public int cjI() {
        return this.iQq;
    }

    public void Aa(int i) {
        if (i <= 3 && i >= 1) {
            this.iQq = i;
        }
    }

    public int arz() {
        return this.cqT;
    }

    public void Ab(int i) {
        if (i <= 3 && i >= 1) {
            this.cqT = i;
        }
    }

    public int cjJ() {
        return this.cqQ;
    }

    public void Ac(int i) {
        if (i <= 3 && i >= 1) {
            this.cqQ = i;
        }
    }

    public boolean cjK() {
        return this.iQr;
    }

    public void Ad(int i) {
        switch (i) {
            case 1:
                this.iQr = true;
                return;
            default:
                this.iQr = false;
                return;
        }
    }

    public SimpleUser aCZ() {
        return this.iQt;
    }

    public void b(SimpleUser simpleUser) {
        this.iQt = simpleUser;
    }

    public void Ae(int i) {
        this.iQu = i;
    }

    public void Af(int i) {
        if (i == 0) {
            this.iQs = 1;
        } else {
            this.iQs = i;
        }
    }

    public int cjL() {
        return this.iQs;
    }
}
