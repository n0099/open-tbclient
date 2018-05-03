package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aBE;
    private int aBH;
    private int gfY;
    private int gfZ;
    private boolean gga;
    private int ggb;
    private SimpleUser ggc;
    private int ggd;

    public boolean bkS() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gfY = bVar.getInt("post" + currentAccount, 0);
        this.gfZ = bVar.getInt("like" + currentAccount, 0);
        this.aBE = bVar.getInt("group" + currentAccount, 0);
        this.aBH = bVar.getInt("live" + currentAccount, 0);
        this.ggb = bVar.getInt("reply" + currentAccount, 1);
        this.gga = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gfY == 0 && this.gfZ == 0 && this.aBE == 0 && this.aBH == 0 && this.ggb == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gfY = aVar.gfY;
            this.gfZ = aVar.gfZ;
            this.aBE = aVar.aBE;
            this.gga = aVar.gga;
            this.aBH = aVar.aBH;
            this.ggd = aVar.ggd;
            this.ggb = aVar.ggb;
        }
    }

    public int bkT() {
        return this.gfY;
    }

    public void aG(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bkU() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gfY);
        bVar.putInt("like" + currentAccount, this.gfZ);
        bVar.putInt("group" + currentAccount, this.aBE);
        bVar.putInt("live" + currentAccount, this.aBH);
        bVar.putInt("reply" + currentAccount, this.ggb);
        TbadkCoreApplication.getInst().setLocationShared(this.gga);
    }

    public void si(int i) {
        this.gfY = i;
    }

    public int bkV() {
        return this.gfZ;
    }

    public void sj(int i) {
        if (i <= 3 && i >= 1) {
            this.gfZ = i;
        }
    }

    public int Dh() {
        return this.aBH;
    }

    public void sk(int i) {
        if (i <= 3 && i >= 1) {
            this.aBH = i;
        }
    }

    public int bkW() {
        return this.aBE;
    }

    public void sl(int i) {
        if (i <= 3 && i >= 1) {
            this.aBE = i;
        }
    }

    public boolean bkX() {
        return this.gga;
    }

    public void sm(int i) {
        switch (i) {
            case 1:
                this.gga = true;
                return;
            default:
                this.gga = false;
                return;
        }
    }

    public SimpleUser MZ() {
        return this.ggc;
    }

    public void b(SimpleUser simpleUser) {
        this.ggc = simpleUser;
    }

    public void sn(int i) {
        this.ggd = i;
    }

    public void so(int i) {
        if (i == 0) {
            this.ggb = 1;
        } else {
            this.ggb = i;
        }
    }

    public int bkY() {
        return this.ggb;
    }
}
