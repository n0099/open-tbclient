package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int anG;
    private int cLf;
    private int cLg;
    private boolean cLh;
    private SimpleUser cLi;

    public boolean aqT() {
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cLf = tu.getInt("post" + currentAccount, 0);
        this.cLg = tu.getInt("like" + currentAccount, 0);
        this.anG = tu.getInt("group" + currentAccount, 0);
        this.cLh = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cLf == 0 && this.cLg == 0 && this.anG == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cLf = aVar.cLf;
        this.cLg = aVar.cLg;
        this.anG = aVar.anG;
        this.cLh = aVar.cLh;
    }

    public int aqU() {
        return this.cLf;
    }

    public void aa(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tu().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aqV() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tu = com.baidu.tbadk.core.sharedPref.b.tu();
        tu.putInt("post" + currentAccount, this.cLf);
        tu.putInt("like" + currentAccount, this.cLg);
        tu.putInt("group" + currentAccount, this.anG);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cLh);
    }

    public void ku(int i) {
        if (i <= 3 && i >= 1) {
            this.cLf = i;
        }
    }

    public int aqW() {
        return this.cLg;
    }

    public void kv(int i) {
        if (i <= 3 && i >= 1) {
            this.cLg = i;
        }
    }

    public int Aa() {
        return this.anG;
    }

    public void kw(int i) {
        if (i <= 3 && i >= 1) {
            this.anG = i;
        }
    }

    public boolean aqX() {
        return this.cLh;
    }

    public void kx(int i) {
        switch (i) {
            case 1:
                this.cLh = true;
                return;
            default:
                this.cLh = false;
                return;
        }
    }

    public SimpleUser aqY() {
        return this.cLi;
    }

    public void a(SimpleUser simpleUser) {
        this.cLi = simpleUser;
    }
}
