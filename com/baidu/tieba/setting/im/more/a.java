package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int ard;
    private int dsa;
    private int dsb;
    private boolean dsc;
    private SimpleUser dsd;

    public boolean aza() {
        com.baidu.tbadk.core.sharedPref.b tJ = com.baidu.tbadk.core.sharedPref.b.tJ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.dsa = tJ.getInt("post" + currentAccount, 0);
        this.dsb = tJ.getInt("like" + currentAccount, 0);
        this.ard = tJ.getInt("group" + currentAccount, 0);
        this.dsc = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.dsa == 0 && this.dsb == 0 && this.ard == 0) ? false : true;
    }

    public void a(a aVar) {
        this.dsa = aVar.dsa;
        this.dsb = aVar.dsb;
        this.ard = aVar.ard;
        this.dsc = aVar.dsc;
    }

    public int azb() {
        return this.dsa;
    }

    public void ag(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void azc() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tJ = com.baidu.tbadk.core.sharedPref.b.tJ();
        tJ.putInt("post" + currentAccount, this.dsa);
        tJ.putInt("like" + currentAccount, this.dsb);
        tJ.putInt("group" + currentAccount, this.ard);
        TbadkCoreApplication.m411getInst().setLocationShared(this.dsc);
    }

    public void mr(int i) {
        if (i <= 3 && i >= 1) {
            this.dsa = i;
        }
    }

    public int azd() {
        return this.dsb;
    }

    public void ms(int i) {
        if (i <= 3 && i >= 1) {
            this.dsb = i;
        }
    }

    public int AN() {
        return this.ard;
    }

    public void mt(int i) {
        if (i <= 3 && i >= 1) {
            this.ard = i;
        }
    }

    public boolean aze() {
        return this.dsc;
    }

    public void mu(int i) {
        switch (i) {
            case 1:
                this.dsc = true;
                return;
            default:
                this.dsc = false;
                return;
        }
    }

    public SimpleUser azf() {
        return this.dsd;
    }

    public void a(SimpleUser simpleUser) {
        this.dsd = simpleUser;
    }
}
