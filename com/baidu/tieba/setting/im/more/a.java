package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aKX;
    private int aLa;
    private int gwp;
    private int gwq;
    private boolean gwr;
    private int gws;
    private SimpleUser gwt;
    private int gwu;

    public boolean bqq() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gwp = bVar.getInt("post" + currentAccount, 0);
        this.gwq = bVar.getInt("like" + currentAccount, 0);
        this.aKX = bVar.getInt("group" + currentAccount, 0);
        this.aLa = bVar.getInt("live" + currentAccount, 0);
        this.gws = bVar.getInt("reply" + currentAccount, 1);
        this.gwr = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gwp == 0 && this.gwq == 0 && this.aKX == 0 && this.aLa == 0 && this.gws == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gwp = aVar.gwp;
            this.gwq = aVar.gwq;
            this.aKX = aVar.aKX;
            this.gwr = aVar.gwr;
            this.aLa = aVar.aLa;
            this.gwu = aVar.gwu;
            this.gws = aVar.gws;
        }
    }

    public int bqr() {
        return this.gwp;
    }

    public void aK(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bqs() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gwp);
        bVar.putInt("like" + currentAccount, this.gwq);
        bVar.putInt("group" + currentAccount, this.aKX);
        bVar.putInt("live" + currentAccount, this.aLa);
        bVar.putInt("reply" + currentAccount, this.gws);
        TbadkCoreApplication.getInst().setLocationShared(this.gwr);
    }

    public void sD(int i) {
        this.gwp = i;
    }

    public int bqt() {
        return this.gwq;
    }

    public void sE(int i) {
        if (i <= 3 && i >= 1) {
            this.gwq = i;
        }
    }

    public int Ha() {
        return this.aLa;
    }

    public void sF(int i) {
        if (i <= 3 && i >= 1) {
            this.aLa = i;
        }
    }

    public int bqu() {
        return this.aKX;
    }

    public void sG(int i) {
        if (i <= 3 && i >= 1) {
            this.aKX = i;
        }
    }

    public boolean bqv() {
        return this.gwr;
    }

    public void sH(int i) {
        switch (i) {
            case 1:
                this.gwr = true;
                return;
            default:
                this.gwr = false;
                return;
        }
    }

    public SimpleUser QT() {
        return this.gwt;
    }

    public void b(SimpleUser simpleUser) {
        this.gwt = simpleUser;
    }

    public void sI(int i) {
        this.gwu = i;
    }

    public void sJ(int i) {
        if (i == 0) {
            this.gws = 1;
        } else {
            this.gws = i;
        }
    }

    public int bqw() {
        return this.gws;
    }
}
