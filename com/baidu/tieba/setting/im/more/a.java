package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int brf;
    private int bri;
    private int gLb;
    private int gLc;
    private boolean gLd;
    private SimpleUser gLe;
    private int gLf;

    public boolean bpL() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gLb = bVar.getInt("post" + currentAccount, 0);
        this.gLc = bVar.getInt("like" + currentAccount, 0);
        this.brf = bVar.getInt("group" + currentAccount, 0);
        this.bri = bVar.getInt("live" + currentAccount, 0);
        this.gLd = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gLb == 0 && this.gLc == 0 && this.brf == 0 && this.bri == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gLb = aVar.gLb;
            this.gLc = aVar.gLc;
            this.brf = aVar.brf;
            this.gLd = aVar.gLd;
            this.bri = aVar.bri;
            this.gLf = aVar.gLf;
        }
    }

    public int bpM() {
        return this.gLb;
    }

    public void aF(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bpN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gLb);
        bVar.putInt("like" + currentAccount, this.gLc);
        bVar.putInt("group" + currentAccount, this.brf);
        bVar.putInt("live" + currentAccount, this.bri);
        TbadkCoreApplication.getInst().setLocationShared(this.gLd);
    }

    public void uI(int i) {
        this.gLb = i;
    }

    public int bpO() {
        return this.gLc;
    }

    public void uJ(int i) {
        if (i <= 3 && i >= 1) {
            this.gLc = i;
        }
    }

    public int KB() {
        return this.bri;
    }

    public void uK(int i) {
        if (i <= 3 && i >= 1) {
            this.bri = i;
        }
    }

    public int bpP() {
        return this.brf;
    }

    public void uL(int i) {
        if (i <= 3 && i >= 1) {
            this.brf = i;
        }
    }

    public boolean bpQ() {
        return this.gLd;
    }

    public void uM(int i) {
        switch (i) {
            case 1:
                this.gLd = true;
                return;
            default:
                this.gLd = false;
                return;
        }
    }

    public SimpleUser Uy() {
        return this.gLe;
    }

    public void b(SimpleUser simpleUser) {
        this.gLe = simpleUser;
    }

    public void uN(int i) {
        this.gLf = i;
    }
}
