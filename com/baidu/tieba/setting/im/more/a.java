package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aBE;
    private int aBH;
    private int ggb;
    private int ggc;
    private boolean ggd;
    private int gge;
    private SimpleUser ggf;
    private int ggg;

    public boolean bkS() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ggb = bVar.getInt("post" + currentAccount, 0);
        this.ggc = bVar.getInt("like" + currentAccount, 0);
        this.aBE = bVar.getInt("group" + currentAccount, 0);
        this.aBH = bVar.getInt("live" + currentAccount, 0);
        this.gge = bVar.getInt("reply" + currentAccount, 1);
        this.ggd = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ggb == 0 && this.ggc == 0 && this.aBE == 0 && this.aBH == 0 && this.gge == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ggb = aVar.ggb;
            this.ggc = aVar.ggc;
            this.aBE = aVar.aBE;
            this.ggd = aVar.ggd;
            this.aBH = aVar.aBH;
            this.ggg = aVar.ggg;
            this.gge = aVar.gge;
        }
    }

    public int bkT() {
        return this.ggb;
    }

    public void aG(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bkU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.ggb);
        bVar.putInt("like" + currentAccount, this.ggc);
        bVar.putInt("group" + currentAccount, this.aBE);
        bVar.putInt("live" + currentAccount, this.aBH);
        bVar.putInt("reply" + currentAccount, this.gge);
        TbadkCoreApplication.getInst().setLocationShared(this.ggd);
    }

    public void sj(int i) {
        this.ggb = i;
    }

    public int bkV() {
        return this.ggc;
    }

    public void sk(int i) {
        if (i <= 3 && i >= 1) {
            this.ggc = i;
        }
    }

    public int Dh() {
        return this.aBH;
    }

    public void sl(int i) {
        if (i <= 3 && i >= 1) {
            this.aBH = i;
        }
    }

    public int bkW() {
        return this.aBE;
    }

    public void sm(int i) {
        if (i <= 3 && i >= 1) {
            this.aBE = i;
        }
    }

    public boolean bkX() {
        return this.ggd;
    }

    public void sn(int i) {
        switch (i) {
            case 1:
                this.ggd = true;
                return;
            default:
                this.ggd = false;
                return;
        }
    }

    public SimpleUser MZ() {
        return this.ggf;
    }

    public void b(SimpleUser simpleUser) {
        this.ggf = simpleUser;
    }

    public void so(int i) {
        this.ggg = i;
    }

    public void sp(int i) {
        if (i == 0) {
            this.gge = 1;
        } else {
            this.gge = i;
        }
    }

    public int bkY() {
        return this.gge;
    }
}
