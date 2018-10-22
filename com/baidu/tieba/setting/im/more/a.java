package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aSS;
    private int aSV;
    private int gMq;
    private int gMr;
    private boolean gMs;
    private int gMt;
    private SimpleUser gMu;
    private int gMv;

    public boolean buQ() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gMq = bVar.getInt("post" + currentAccount, 0);
        this.gMr = bVar.getInt("like" + currentAccount, 0);
        this.aSS = bVar.getInt("group" + currentAccount, 0);
        this.aSV = bVar.getInt("live" + currentAccount, 0);
        this.gMt = bVar.getInt("reply" + currentAccount, 1);
        this.gMs = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gMq == 0 && this.gMr == 0 && this.aSS == 0 && this.aSV == 0 && this.gMt == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gMq = aVar.gMq;
            this.gMr = aVar.gMr;
            this.aSS = aVar.aSS;
            this.gMs = aVar.gMs;
            this.aSV = aVar.aSV;
            this.gMv = aVar.gMv;
            this.gMt = aVar.gMt;
        }
    }

    public int buR() {
        return this.gMq;
    }

    public void aP(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void buS() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gMq);
        bVar.putInt("like" + currentAccount, this.gMr);
        bVar.putInt("group" + currentAccount, this.aSS);
        bVar.putInt("live" + currentAccount, this.aSV);
        bVar.putInt("reply" + currentAccount, this.gMt);
        TbadkCoreApplication.getInst().setLocationShared(this.gMs);
    }

    public void tw(int i) {
        this.gMq = i;
    }

    public int buT() {
        return this.gMr;
    }

    public void tx(int i) {
        if (i <= 3 && i >= 1) {
            this.gMr = i;
        }
    }

    public int Kl() {
        return this.aSV;
    }

    public void ty(int i) {
        if (i <= 3 && i >= 1) {
            this.aSV = i;
        }
    }

    public int buU() {
        return this.aSS;
    }

    public void tz(int i) {
        if (i <= 3 && i >= 1) {
            this.aSS = i;
        }
    }

    public boolean buV() {
        return this.gMs;
    }

    public void tA(int i) {
        switch (i) {
            case 1:
                this.gMs = true;
                return;
            default:
                this.gMs = false;
                return;
        }
    }

    public SimpleUser UP() {
        return this.gMu;
    }

    public void b(SimpleUser simpleUser) {
        this.gMu = simpleUser;
    }

    public void tB(int i) {
        this.gMv = i;
    }

    public void tC(int i) {
        if (i == 0) {
            this.gMt = 1;
        } else {
            this.gMt = i;
        }
    }

    public int buW() {
        return this.gMt;
    }
}
