package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int arW;
    private int dIe;
    private int dIf;
    private boolean dIg;
    private SimpleUser dIh;

    public boolean aGh() {
        com.baidu.tbadk.core.sharedPref.b uO = com.baidu.tbadk.core.sharedPref.b.uO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.dIe = uO.getInt("post" + currentAccount, 0);
        this.dIf = uO.getInt("like" + currentAccount, 0);
        this.arW = uO.getInt("group" + currentAccount, 0);
        this.dIg = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.dIe == 0 && this.dIf == 0 && this.arW == 0) ? false : true;
    }

    public void a(a aVar) {
        this.dIe = aVar.dIe;
        this.dIf = aVar.dIf;
        this.arW = aVar.arW;
        this.dIg = aVar.dIg;
    }

    public int aGi() {
        return this.dIe;
    }

    public void ai(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.uO().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aGj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b uO = com.baidu.tbadk.core.sharedPref.b.uO();
        uO.putInt("post" + currentAccount, this.dIe);
        uO.putInt("like" + currentAccount, this.dIf);
        uO.putInt("group" + currentAccount, this.arW);
        TbadkCoreApplication.m411getInst().setLocationShared(this.dIg);
    }

    public void nD(int i) {
        if (i <= 3 && i >= 1) {
            this.dIe = i;
        }
    }

    public int aGk() {
        return this.dIf;
    }

    public void nE(int i) {
        if (i <= 3 && i >= 1) {
            this.dIf = i;
        }
    }

    public int Cd() {
        return this.arW;
    }

    public void nF(int i) {
        if (i <= 3 && i >= 1) {
            this.arW = i;
        }
    }

    public boolean aGl() {
        return this.dIg;
    }

    public void nG(int i) {
        switch (i) {
            case 1:
                this.dIg = true;
                return;
            default:
                this.dIg = false;
                return;
        }
    }

    public SimpleUser aGm() {
        return this.dIh;
    }

    public void a(SimpleUser simpleUser) {
        this.dIh = simpleUser;
    }
}
