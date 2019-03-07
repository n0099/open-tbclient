package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int chl;
    private int cho;
    private int iqu;
    private int iqv;
    private boolean iqw;
    private int iqx;
    private SimpleUser iqy;
    private int iqz;

    public boolean bYp() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iqu = bVar.getInt("post" + currentAccount, 0);
        this.iqv = bVar.getInt("like" + currentAccount, 0);
        this.chl = bVar.getInt("group" + currentAccount, 0);
        this.cho = bVar.getInt("live" + currentAccount, 0);
        this.iqx = bVar.getInt("reply" + currentAccount, 1);
        this.iqw = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iqu == 0 && this.iqv == 0 && this.chl == 0 && this.cho == 0 && this.iqx == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iqu = aVar.iqu;
            this.iqv = aVar.iqv;
            this.chl = aVar.chl;
            this.iqw = aVar.iqw;
            this.cho = aVar.cho;
            this.iqz = aVar.iqz;
            this.iqx = aVar.iqx;
        }
    }

    public int bYq() {
        return this.iqu;
    }

    public void bn(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bYr() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.iqu);
        bVar.putInt("like" + currentAccount, this.iqv);
        bVar.putInt("group" + currentAccount, this.chl);
        bVar.putInt("live" + currentAccount, this.cho);
        bVar.putInt("reply" + currentAccount, this.iqx);
        TbadkCoreApplication.getInst().setLocationShared(this.iqw);
    }

    public void yo(int i) {
        this.iqu = i;
    }

    public int bYs() {
        return this.iqv;
    }

    public void yp(int i) {
        if (i <= 3 && i >= 1) {
            this.iqv = i;
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

    public int bYt() {
        return this.chl;
    }

    public void yr(int i) {
        if (i <= 3 && i >= 1) {
            this.chl = i;
        }
    }

    public boolean bYu() {
        return this.iqw;
    }

    public void ys(int i) {
        switch (i) {
            case 1:
                this.iqw = true;
                return;
            default:
                this.iqw = false;
                return;
        }
    }

    public SimpleUser awC() {
        return this.iqy;
    }

    public void b(SimpleUser simpleUser) {
        this.iqy = simpleUser;
    }

    public void yt(int i) {
        this.iqz = i;
    }

    public void yu(int i) {
        if (i == 0) {
            this.iqx = 1;
        } else {
            this.iqx = i;
        }
    }

    public int bYv() {
        return this.iqx;
    }
}
