package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aLd;
    private int aLg;
    private int gxA;
    private SimpleUser gxB;
    private int gxC;
    private int gxx;
    private int gxy;
    private boolean gxz;

    public boolean boT() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gxx = bVar.getInt("post" + currentAccount, 0);
        this.gxy = bVar.getInt("like" + currentAccount, 0);
        this.aLd = bVar.getInt("group" + currentAccount, 0);
        this.aLg = bVar.getInt("live" + currentAccount, 0);
        this.gxA = bVar.getInt("reply" + currentAccount, 1);
        this.gxz = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gxx == 0 && this.gxy == 0 && this.aLd == 0 && this.aLg == 0 && this.gxA == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gxx = aVar.gxx;
            this.gxy = aVar.gxy;
            this.aLd = aVar.aLd;
            this.gxz = aVar.gxz;
            this.aLg = aVar.aLg;
            this.gxC = aVar.gxC;
            this.gxA = aVar.gxA;
        }
    }

    public int boU() {
        return this.gxx;
    }

    public void aG(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void boV() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gxx);
        bVar.putInt("like" + currentAccount, this.gxy);
        bVar.putInt("group" + currentAccount, this.aLd);
        bVar.putInt("live" + currentAccount, this.aLg);
        bVar.putInt("reply" + currentAccount, this.gxA);
        TbadkCoreApplication.getInst().setLocationShared(this.gxz);
    }

    public void sB(int i) {
        this.gxx = i;
    }

    public int boW() {
        return this.gxy;
    }

    public void sC(int i) {
        if (i <= 3 && i >= 1) {
            this.gxy = i;
        }
    }

    public int GW() {
        return this.aLg;
    }

    public void sD(int i) {
        if (i <= 3 && i >= 1) {
            this.aLg = i;
        }
    }

    public int boX() {
        return this.aLd;
    }

    public void sE(int i) {
        if (i <= 3 && i >= 1) {
            this.aLd = i;
        }
    }

    public boolean boY() {
        return this.gxz;
    }

    public void sF(int i) {
        switch (i) {
            case 1:
                this.gxz = true;
                return;
            default:
                this.gxz = false;
                return;
        }
    }

    public SimpleUser Ra() {
        return this.gxB;
    }

    public void b(SimpleUser simpleUser) {
        this.gxB = simpleUser;
    }

    public void sG(int i) {
        this.gxC = i;
    }

    public void sH(int i) {
        if (i == 0) {
            this.gxA = 1;
        } else {
            this.gxA = i;
        }
    }

    public int boZ() {
        return this.gxA;
    }
}
