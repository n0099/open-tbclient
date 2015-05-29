package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int aio;
    private int cdH;
    private int cdI;
    private boolean cdJ;

    public boolean ahZ() {
        com.baidu.tbadk.core.sharedPref.b sl = com.baidu.tbadk.core.sharedPref.b.sl();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cdH = sl.getInt("post" + currentAccount, 0);
        this.cdI = sl.getInt("like" + currentAccount, 0);
        this.aio = sl.getInt("group" + currentAccount, 0);
        this.cdJ = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cdH == 0 && this.cdI == 0 && this.aio == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cdH = aVar.cdH;
        this.cdI = aVar.cdI;
        this.aio = aVar.aio;
        this.cdJ = aVar.cdJ;
    }

    public int aia() {
        return this.cdH;
    }

    public void R(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.sl().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aib() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b sl = com.baidu.tbadk.core.sharedPref.b.sl();
        sl.putInt("post" + currentAccount, this.cdH);
        sl.putInt("like" + currentAccount, this.cdI);
        sl.putInt("group" + currentAccount, this.aio);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cdJ);
    }

    public void iq(int i) {
        if (i <= 3 && i >= 1) {
            this.cdH = i;
        }
    }

    public int aic() {
        return this.cdI;
    }

    public void ir(int i) {
        if (i <= 3 && i >= 1) {
            this.cdI = i;
        }
    }

    public int yR() {
        return this.aio;
    }

    public void is(int i) {
        if (i <= 3 && i >= 1) {
            this.aio = i;
        }
    }

    public boolean aid() {
        return this.cdJ;
    }

    public void it(int i) {
        switch (i) {
            case 1:
                this.cdJ = true;
                return;
            default:
                this.cdJ = false;
                return;
        }
    }
}
