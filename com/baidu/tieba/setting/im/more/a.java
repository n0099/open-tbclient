package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int apA;
    private int dkS;
    private int dkT;
    private boolean dkU;
    private SimpleUser dkV;

    public boolean awT() {
        com.baidu.tbadk.core.sharedPref.b tZ = com.baidu.tbadk.core.sharedPref.b.tZ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.dkS = tZ.getInt("post" + currentAccount, 0);
        this.dkT = tZ.getInt("like" + currentAccount, 0);
        this.apA = tZ.getInt("group" + currentAccount, 0);
        this.dkU = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.dkS == 0 && this.dkT == 0 && this.apA == 0) ? false : true;
    }

    public void a(a aVar) {
        this.dkS = aVar.dkS;
        this.dkT = aVar.dkT;
        this.apA = aVar.apA;
        this.dkU = aVar.dkU;
    }

    public int awU() {
        return this.dkS;
    }

    public void af(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void awV() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b tZ = com.baidu.tbadk.core.sharedPref.b.tZ();
        tZ.putInt("post" + currentAccount, this.dkS);
        tZ.putInt("like" + currentAccount, this.dkT);
        tZ.putInt("group" + currentAccount, this.apA);
        TbadkCoreApplication.m411getInst().setLocationShared(this.dkU);
    }

    public void lQ(int i) {
        if (i <= 3 && i >= 1) {
            this.dkS = i;
        }
    }

    public int awW() {
        return this.dkT;
    }

    public void lR(int i) {
        if (i <= 3 && i >= 1) {
            this.dkT = i;
        }
    }

    public int AX() {
        return this.apA;
    }

    public void lS(int i) {
        if (i <= 3 && i >= 1) {
            this.apA = i;
        }
    }

    public boolean awX() {
        return this.dkU;
    }

    public void lT(int i) {
        switch (i) {
            case 1:
                this.dkU = true;
                return;
            default:
                this.dkU = false;
                return;
        }
    }

    public SimpleUser awY() {
        return this.dkV;
    }

    public void a(SimpleUser simpleUser) {
        this.dkV = simpleUser;
    }
}
