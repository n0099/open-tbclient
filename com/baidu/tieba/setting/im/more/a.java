package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int ahn;
    private int bZv;
    private int bZw;
    private boolean bZx;

    public boolean agk() {
        com.baidu.tbadk.core.sharedPref.b rB = com.baidu.tbadk.core.sharedPref.b.rB();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.bZv = rB.getInt("post" + currentAccount, 0);
        this.bZw = rB.getInt("like" + currentAccount, 0);
        this.ahn = rB.getInt("group" + currentAccount, 0);
        this.bZx = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.bZv == 0 && this.bZw == 0 && this.ahn == 0) ? false : true;
    }

    public void a(a aVar) {
        this.bZv = aVar.bZv;
        this.bZw = aVar.bZw;
        this.ahn = aVar.ahn;
        this.bZx = aVar.bZx;
    }

    public int agl() {
        return this.bZv;
    }

    public void Q(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.rB().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void agm() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b rB = com.baidu.tbadk.core.sharedPref.b.rB();
        rB.putInt("post" + currentAccount, this.bZv);
        rB.putInt("like" + currentAccount, this.bZw);
        rB.putInt("group" + currentAccount, this.ahn);
        TbadkCoreApplication.m411getInst().setLocationShared(this.bZx);
    }

    public void hS(int i) {
        if (i <= 3 && i >= 1) {
            this.bZv = i;
        }
    }

    public int agn() {
        return this.bZw;
    }

    public void hT(int i) {
        if (i <= 3 && i >= 1) {
            this.bZw = i;
        }
    }

    public int ye() {
        return this.ahn;
    }

    public void hU(int i) {
        if (i <= 3 && i >= 1) {
            this.ahn = i;
        }
    }

    public boolean ago() {
        return this.bZx;
    }

    public void hV(int i) {
        switch (i) {
            case 1:
                this.bZx = true;
                return;
            default:
                this.bZx = false;
                return;
        }
    }
}
