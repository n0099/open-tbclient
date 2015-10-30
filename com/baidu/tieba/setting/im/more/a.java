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

    public boolean aqP() {
        com.baidu.tbadk.core.sharedPref.b tr = com.baidu.tbadk.core.sharedPref.b.tr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.cLf = tr.getInt("post" + currentAccount, 0);
        this.cLg = tr.getInt("like" + currentAccount, 0);
        this.anG = tr.getInt("group" + currentAccount, 0);
        this.cLh = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.cLf == 0 && this.cLg == 0 && this.anG == 0) ? false : true;
    }

    public void a(a aVar) {
        this.cLf = aVar.cLf;
        this.cLg = aVar.cLg;
        this.anG = aVar.anG;
        this.cLh = aVar.cLh;
    }

    public int aqQ() {
        return this.cLf;
    }

    public void aa(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tr().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aqR() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tr = com.baidu.tbadk.core.sharedPref.b.tr();
        tr.putInt("post" + currentAccount, this.cLf);
        tr.putInt("like" + currentAccount, this.cLg);
        tr.putInt("group" + currentAccount, this.anG);
        TbadkCoreApplication.m411getInst().setLocationShared(this.cLh);
    }

    public void ku(int i) {
        if (i <= 3 && i >= 1) {
            this.cLf = i;
        }
    }

    public int aqS() {
        return this.cLg;
    }

    public void kv(int i) {
        if (i <= 3 && i >= 1) {
            this.cLg = i;
        }
    }

    public int zX() {
        return this.anG;
    }

    public void kw(int i) {
        if (i <= 3 && i >= 1) {
            this.anG = i;
        }
    }

    public boolean aqT() {
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

    public SimpleUser aqU() {
        return this.cLi;
    }

    public void a(SimpleUser simpleUser) {
        this.cLi = simpleUser;
    }
}
