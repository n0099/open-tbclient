package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aSS;
    private int aSV;
    private int gMp;
    private int gMq;
    private boolean gMr;
    private int gMs;
    private SimpleUser gMt;
    private int gMu;

    public boolean buQ() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gMp = bVar.getInt("post" + currentAccount, 0);
        this.gMq = bVar.getInt("like" + currentAccount, 0);
        this.aSS = bVar.getInt("group" + currentAccount, 0);
        this.aSV = bVar.getInt("live" + currentAccount, 0);
        this.gMs = bVar.getInt("reply" + currentAccount, 1);
        this.gMr = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gMp == 0 && this.gMq == 0 && this.aSS == 0 && this.aSV == 0 && this.gMs == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gMp = aVar.gMp;
            this.gMq = aVar.gMq;
            this.aSS = aVar.aSS;
            this.gMr = aVar.gMr;
            this.aSV = aVar.aSV;
            this.gMu = aVar.gMu;
            this.gMs = aVar.gMs;
        }
    }

    public int buR() {
        return this.gMp;
    }

    public void aP(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void buS() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gMp);
        bVar.putInt("like" + currentAccount, this.gMq);
        bVar.putInt("group" + currentAccount, this.aSS);
        bVar.putInt("live" + currentAccount, this.aSV);
        bVar.putInt("reply" + currentAccount, this.gMs);
        TbadkCoreApplication.getInst().setLocationShared(this.gMr);
    }

    public void tw(int i) {
        this.gMp = i;
    }

    public int buT() {
        return this.gMq;
    }

    public void tx(int i) {
        if (i <= 3 && i >= 1) {
            this.gMq = i;
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
        return this.gMr;
    }

    public void tA(int i) {
        switch (i) {
            case 1:
                this.gMr = true;
                return;
            default:
                this.gMr = false;
                return;
        }
    }

    public SimpleUser UP() {
        return this.gMt;
    }

    public void b(SimpleUser simpleUser) {
        this.gMt = simpleUser;
    }

    public void tB(int i) {
        this.gMu = i;
    }

    public void tC(int i) {
        if (i == 0) {
            this.gMs = 1;
        } else {
            this.gMs = i;
        }
    }

    public int buW() {
        return this.gMs;
    }
}
