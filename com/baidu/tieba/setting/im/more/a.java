package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int ahf;
    private int bZg;
    private int bZh;
    private boolean bZi;

    public boolean afV() {
        com.baidu.tbadk.core.sharedPref.b rB = com.baidu.tbadk.core.sharedPref.b.rB();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.bZg = rB.getInt("post" + currentAccount, 0);
        this.bZh = rB.getInt("like" + currentAccount, 0);
        this.ahf = rB.getInt("group" + currentAccount, 0);
        this.bZi = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.bZg == 0 && this.bZh == 0 && this.ahf == 0) ? false : true;
    }

    public void a(a aVar) {
        this.bZg = aVar.bZg;
        this.bZh = aVar.bZh;
        this.ahf = aVar.ahf;
        this.bZi = aVar.bZi;
    }

    public int afW() {
        return this.bZg;
    }

    public void Q(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.rB().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void afX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b rB = com.baidu.tbadk.core.sharedPref.b.rB();
        rB.putInt("post" + currentAccount, this.bZg);
        rB.putInt("like" + currentAccount, this.bZh);
        rB.putInt("group" + currentAccount, this.ahf);
        TbadkCoreApplication.m411getInst().setLocationShared(this.bZi);
    }

    public void hP(int i) {
        if (i <= 3 && i >= 1) {
            this.bZg = i;
        }
    }

    public int afY() {
        return this.bZh;
    }

    public void hQ(int i) {
        if (i <= 3 && i >= 1) {
            this.bZh = i;
        }
    }

    public int xY() {
        return this.ahf;
    }

    public void hR(int i) {
        if (i <= 3 && i >= 1) {
            this.ahf = i;
        }
    }

    public boolean afZ() {
        return this.bZi;
    }

    public void hS(int i) {
        switch (i) {
            case 1:
                this.bZi = true;
                return;
            default:
                this.bZi = false;
                return;
        }
    }
}
