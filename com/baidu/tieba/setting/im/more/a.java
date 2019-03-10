package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int chl;
    private int cho;
    private int iqA;
    private int iqv;
    private int iqw;
    private boolean iqx;
    private int iqy;
    private SimpleUser iqz;

    public boolean bYq() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iqv = bVar.getInt("post" + currentAccount, 0);
        this.iqw = bVar.getInt("like" + currentAccount, 0);
        this.chl = bVar.getInt("group" + currentAccount, 0);
        this.cho = bVar.getInt("live" + currentAccount, 0);
        this.iqy = bVar.getInt("reply" + currentAccount, 1);
        this.iqx = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iqv == 0 && this.iqw == 0 && this.chl == 0 && this.cho == 0 && this.iqy == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iqv = aVar.iqv;
            this.iqw = aVar.iqw;
            this.chl = aVar.chl;
            this.iqx = aVar.iqx;
            this.cho = aVar.cho;
            this.iqA = aVar.iqA;
            this.iqy = aVar.iqy;
        }
    }

    public int bYr() {
        return this.iqv;
    }

    public void bn(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bYs() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.iqv);
        bVar.putInt("like" + currentAccount, this.iqw);
        bVar.putInt("group" + currentAccount, this.chl);
        bVar.putInt("live" + currentAccount, this.cho);
        bVar.putInt("reply" + currentAccount, this.iqy);
        TbadkCoreApplication.getInst().setLocationShared(this.iqx);
    }

    public void yo(int i) {
        this.iqv = i;
    }

    public int bYt() {
        return this.iqw;
    }

    public void yp(int i) {
        if (i <= 3 && i >= 1) {
            this.iqw = i;
        }
    }

    public int alt() {
        return this.cho;
    }

    public void yq(int i) {
        if (i <= 3 && i >= 1) {
            this.cho = i;
        }
    }

    public int bYu() {
        return this.chl;
    }

    public void yr(int i) {
        if (i <= 3 && i >= 1) {
            this.chl = i;
        }
    }

    public boolean bYv() {
        return this.iqx;
    }

    public void ys(int i) {
        switch (i) {
            case 1:
                this.iqx = true;
                return;
            default:
                this.iqx = false;
                return;
        }
    }

    public SimpleUser awD() {
        return this.iqz;
    }

    public void b(SimpleUser simpleUser) {
        this.iqz = simpleUser;
    }

    public void yt(int i) {
        this.iqA = i;
    }

    public void yu(int i) {
        if (i == 0) {
            this.iqy = 1;
        } else {
            this.iqy = i;
        }
    }

    public int bYw() {
        return this.iqy;
    }
}
