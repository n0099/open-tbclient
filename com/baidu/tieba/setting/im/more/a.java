package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int brp;
    private int brs;
    private int gLa;
    private int gLb;
    private boolean gLc;
    private SimpleUser gLd;
    private int gLe;

    public boolean bpL() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gLa = bVar.getInt("post" + currentAccount, 0);
        this.gLb = bVar.getInt("like" + currentAccount, 0);
        this.brp = bVar.getInt("group" + currentAccount, 0);
        this.brs = bVar.getInt("live" + currentAccount, 0);
        this.gLc = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gLa == 0 && this.gLb == 0 && this.brp == 0 && this.brs == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gLa = aVar.gLa;
            this.gLb = aVar.gLb;
            this.brp = aVar.brp;
            this.gLc = aVar.gLc;
            this.brs = aVar.brs;
            this.gLe = aVar.gLe;
        }
    }

    public int bpM() {
        return this.gLa;
    }

    public void aF(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bpN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gLa);
        bVar.putInt("like" + currentAccount, this.gLb);
        bVar.putInt("group" + currentAccount, this.brp);
        bVar.putInt("live" + currentAccount, this.brs);
        TbadkCoreApplication.getInst().setLocationShared(this.gLc);
    }

    public void uH(int i) {
        this.gLa = i;
    }

    public int bpO() {
        return this.gLb;
    }

    public void uI(int i) {
        if (i <= 3 && i >= 1) {
            this.gLb = i;
        }
    }

    public int KB() {
        return this.brs;
    }

    public void uJ(int i) {
        if (i <= 3 && i >= 1) {
            this.brs = i;
        }
    }

    public int bpP() {
        return this.brp;
    }

    public void uK(int i) {
        if (i <= 3 && i >= 1) {
            this.brp = i;
        }
    }

    public boolean bpQ() {
        return this.gLc;
    }

    public void uL(int i) {
        switch (i) {
            case 1:
                this.gLc = true;
                return;
            default:
                this.gLc = false;
                return;
        }
    }

    public SimpleUser Uy() {
        return this.gLd;
    }

    public void b(SimpleUser simpleUser) {
        this.gLd = simpleUser;
    }

    public void uM(int i) {
        this.gLe = i;
    }
}
