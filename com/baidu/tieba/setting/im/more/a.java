package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int chl;
    private int cho;
    private int iqo;
    private int iqp;
    private boolean iqq;
    private int iqr;
    private SimpleUser iqs;
    private int iqt;

    public boolean bYs() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iqo = bVar.getInt("post" + currentAccount, 0);
        this.iqp = bVar.getInt("like" + currentAccount, 0);
        this.chl = bVar.getInt("group" + currentAccount, 0);
        this.cho = bVar.getInt("live" + currentAccount, 0);
        this.iqr = bVar.getInt("reply" + currentAccount, 1);
        this.iqq = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iqo == 0 && this.iqp == 0 && this.chl == 0 && this.cho == 0 && this.iqr == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iqo = aVar.iqo;
            this.iqp = aVar.iqp;
            this.chl = aVar.chl;
            this.iqq = aVar.iqq;
            this.cho = aVar.cho;
            this.iqt = aVar.iqt;
            this.iqr = aVar.iqr;
        }
    }

    public int bYt() {
        return this.iqo;
    }

    public void bn(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bYu() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.iqo);
        bVar.putInt("like" + currentAccount, this.iqp);
        bVar.putInt("group" + currentAccount, this.chl);
        bVar.putInt("live" + currentAccount, this.cho);
        bVar.putInt("reply" + currentAccount, this.iqr);
        TbadkCoreApplication.getInst().setLocationShared(this.iqq);
    }

    public void yo(int i) {
        this.iqo = i;
    }

    public int bYv() {
        return this.iqp;
    }

    public void yp(int i) {
        if (i <= 3 && i >= 1) {
            this.iqp = i;
        }
    }

    public int als() {
        return this.cho;
    }

    public void yq(int i) {
        if (i <= 3 && i >= 1) {
            this.cho = i;
        }
    }

    public int bYw() {
        return this.chl;
    }

    public void yr(int i) {
        if (i <= 3 && i >= 1) {
            this.chl = i;
        }
    }

    public boolean bYx() {
        return this.iqq;
    }

    public void ys(int i) {
        switch (i) {
            case 1:
                this.iqq = true;
                return;
            default:
                this.iqq = false;
                return;
        }
    }

    public SimpleUser awC() {
        return this.iqs;
    }

    public void b(SimpleUser simpleUser) {
        this.iqs = simpleUser;
    }

    public void yt(int i) {
        this.iqt = i;
    }

    public void yu(int i) {
        if (i == 0) {
            this.iqr = 1;
        } else {
            this.iqr = i;
        }
    }

    public int bYy() {
        return this.iqr;
    }
}
