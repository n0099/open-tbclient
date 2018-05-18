package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aBF;
    private int aBI;
    private int ghe;
    private int ghf;
    private boolean ghg;
    private int ghh;
    private SimpleUser ghi;
    private int ghj;

    public boolean bkR() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ghe = bVar.getInt("post" + currentAccount, 0);
        this.ghf = bVar.getInt("like" + currentAccount, 0);
        this.aBF = bVar.getInt("group" + currentAccount, 0);
        this.aBI = bVar.getInt("live" + currentAccount, 0);
        this.ghh = bVar.getInt("reply" + currentAccount, 1);
        this.ghg = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ghe == 0 && this.ghf == 0 && this.aBF == 0 && this.aBI == 0 && this.ghh == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ghe = aVar.ghe;
            this.ghf = aVar.ghf;
            this.aBF = aVar.aBF;
            this.ghg = aVar.ghg;
            this.aBI = aVar.aBI;
            this.ghj = aVar.ghj;
            this.ghh = aVar.ghh;
        }
    }

    public int bkS() {
        return this.ghe;
    }

    public void aG(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bkT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.ghe);
        bVar.putInt("like" + currentAccount, this.ghf);
        bVar.putInt("group" + currentAccount, this.aBF);
        bVar.putInt("live" + currentAccount, this.aBI);
        bVar.putInt("reply" + currentAccount, this.ghh);
        TbadkCoreApplication.getInst().setLocationShared(this.ghg);
    }

    public void sh(int i) {
        this.ghe = i;
    }

    public int bkU() {
        return this.ghf;
    }

    public void si(int i) {
        if (i <= 3 && i >= 1) {
            this.ghf = i;
        }
    }

    public int Df() {
        return this.aBI;
    }

    public void sj(int i) {
        if (i <= 3 && i >= 1) {
            this.aBI = i;
        }
    }

    public int bkV() {
        return this.aBF;
    }

    public void sk(int i) {
        if (i <= 3 && i >= 1) {
            this.aBF = i;
        }
    }

    public boolean bkW() {
        return this.ghg;
    }

    public void sl(int i) {
        switch (i) {
            case 1:
                this.ghg = true;
                return;
            default:
                this.ghg = false;
                return;
        }
    }

    public SimpleUser MX() {
        return this.ghi;
    }

    public void b(SimpleUser simpleUser) {
        this.ghi = simpleUser;
    }

    public void sm(int i) {
        this.ghj = i;
    }

    public void sn(int i) {
        if (i == 0) {
            this.ghh = 1;
        } else {
            this.ghh = i;
        }
    }

    public int bkX() {
        return this.ghh;
    }
}
