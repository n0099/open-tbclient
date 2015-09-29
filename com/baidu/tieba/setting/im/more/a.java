package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int anF;
    private int cKG;
    private int cKH;
    private boolean cKI;
    private SimpleUser cKJ;

    public boolean aqN() {
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cKG = tu.getInt("post" + currentAccount, 0);
        this.cKH = tu.getInt("like" + currentAccount, 0);
        this.anF = tu.getInt("group" + currentAccount, 0);
        this.cKI = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cKG == 0 && this.cKH == 0 && this.anF == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cKG = aVar.cKG;
        this.cKH = aVar.cKH;
        this.anF = aVar.anF;
        this.cKI = aVar.cKI;
    }

    public int aqO() {
        return this.cKG;
    }

    public void aa(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aqP() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        tu.putInt("post" + currentAccount, this.cKG);
        tu.putInt("like" + currentAccount, this.cKH);
        tu.putInt("group" + currentAccount, this.anF);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cKI);
    }

    public void ks(int i) {
        if (i <= 3 && i >= 1) {
            this.cKG = i;
        }
    }

    public int aqQ() {
        return this.cKH;
    }

    public void kt(int i) {
        if (i <= 3 && i >= 1) {
            this.cKH = i;
        }
    }

    public int Aa() {
        return this.anF;
    }

    public void ku(int i) {
        if (i <= 3 && i >= 1) {
            this.anF = i;
        }
    }

    public boolean aqR() {
        return this.cKI;
    }

    public void kv(int i) {
        switch (i) {
            case 1:
                this.cKI = true;
                return;
            default:
                this.cKI = false;
                return;
        }
    }

    public SimpleUser aqS() {
        return this.cKJ;
    }

    public void a(SimpleUser simpleUser) {
        this.cKJ = simpleUser;
    }
}
