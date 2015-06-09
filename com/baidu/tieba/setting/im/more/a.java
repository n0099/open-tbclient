package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private int aio;
    private int cdI;
    private int cdJ;
    private boolean cdK;

    public boolean aia() {
        com.baidu.tbadk.core.sharedPref.b sl = com.baidu.tbadk.core.sharedPref.b.sl();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cdI = sl.getInt("post" + currentAccount, 0);
        this.cdJ = sl.getInt("like" + currentAccount, 0);
        this.aio = sl.getInt("group" + currentAccount, 0);
        this.cdK = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cdI == 0 && this.cdJ == 0 && this.aio == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cdI = aVar.cdI;
        this.cdJ = aVar.cdJ;
        this.aio = aVar.aio;
        this.cdK = aVar.cdK;
    }

    public int aib() {
        return this.cdI;
    }

    public void R(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.sl().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aic() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b sl = com.baidu.tbadk.core.sharedPref.b.sl();
        sl.putInt("post" + currentAccount, this.cdI);
        sl.putInt("like" + currentAccount, this.cdJ);
        sl.putInt("group" + currentAccount, this.aio);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cdK);
    }

    public void iq(int i) {
        if (i <= 3 && i >= 1) {
            this.cdI = i;
        }
    }

    public int aid() {
        return this.cdJ;
    }

    public void ir(int i) {
        if (i <= 3 && i >= 1) {
            this.cdJ = i;
        }
    }

    public int yS() {
        return this.aio;
    }

    public void is(int i) {
        if (i <= 3 && i >= 1) {
            this.aio = i;
        }
    }

    public boolean aie() {
        return this.cdK;
    }

    public void it(int i) {
        switch (i) {
            case 1:
                this.cdK = true;
                return;
            default:
                this.cdK = false;
                return;
        }
    }
}
