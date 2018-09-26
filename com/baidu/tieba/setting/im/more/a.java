package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aOq;
    private int aOt;
    private int gER;
    private int gES;
    private boolean gET;
    private int gEU;
    private SimpleUser gEV;
    private int gEW;

    public boolean brB() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gER = bVar.getInt("post" + currentAccount, 0);
        this.gES = bVar.getInt("like" + currentAccount, 0);
        this.aOq = bVar.getInt("group" + currentAccount, 0);
        this.aOt = bVar.getInt("live" + currentAccount, 0);
        this.gEU = bVar.getInt("reply" + currentAccount, 1);
        this.gET = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gER == 0 && this.gES == 0 && this.aOq == 0 && this.aOt == 0 && this.gEU == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gER = aVar.gER;
            this.gES = aVar.gES;
            this.aOq = aVar.aOq;
            this.gET = aVar.gET;
            this.aOt = aVar.aOt;
            this.gEW = aVar.gEW;
            this.gEU = aVar.gEU;
        }
    }

    public int brC() {
        return this.gER;
    }

    public void aL(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void brD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gER);
        bVar.putInt("like" + currentAccount, this.gES);
        bVar.putInt("group" + currentAccount, this.aOq);
        bVar.putInt("live" + currentAccount, this.aOt);
        bVar.putInt("reply" + currentAccount, this.gEU);
        TbadkCoreApplication.getInst().setLocationShared(this.gET);
    }

    public void sZ(int i) {
        this.gER = i;
    }

    public int brE() {
        return this.gES;
    }

    public void ta(int i) {
        if (i <= 3 && i >= 1) {
            this.gES = i;
        }
    }

    public int Im() {
        return this.aOt;
    }

    public void tb(int i) {
        if (i <= 3 && i >= 1) {
            this.aOt = i;
        }
    }

    public int brF() {
        return this.aOq;
    }

    public void tc(int i) {
        if (i <= 3 && i >= 1) {
            this.aOq = i;
        }
    }

    public boolean brG() {
        return this.gET;
    }

    public void td(int i) {
        switch (i) {
            case 1:
                this.gET = true;
                return;
            default:
                this.gET = false;
                return;
        }
    }

    public SimpleUser ST() {
        return this.gEV;
    }

    public void b(SimpleUser simpleUser) {
        this.gEV = simpleUser;
    }

    public void te(int i) {
        this.gEW = i;
    }

    public void tf(int i) {
        if (i == 0) {
            this.gEU = 1;
        } else {
            this.gEU = i;
        }
    }

    public int brH() {
        return this.gEU;
    }
}
