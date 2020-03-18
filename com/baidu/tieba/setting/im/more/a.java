package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int dvK;
    private int dvN;
    private int jSs;
    private int jSt;
    private boolean jSu;
    private int jSv;
    private SimpleUser jSw;
    private int jSx;

    public boolean cFh() {
        com.baidu.tbadk.core.sharedPref.b aFH = com.baidu.tbadk.core.sharedPref.b.aFH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jSs = aFH.getInt("post" + currentAccount, 0);
        this.jSt = aFH.getInt("like" + currentAccount, 0);
        this.dvK = aFH.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dvN = aFH.getInt("live" + currentAccount, 0);
        this.jSv = aFH.getInt("reply" + currentAccount, 1);
        this.jSu = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jSs == 0 && this.jSt == 0 && this.dvK == 0 && this.dvN == 0 && this.jSv == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jSs = aVar.jSs;
            this.jSt = aVar.jSt;
            this.dvK = aVar.dvK;
            this.jSu = aVar.jSu;
            this.dvN = aVar.dvN;
            this.jSx = aVar.jSx;
            this.jSv = aVar.jSv;
        }
    }

    public int cFi() {
        return this.jSs;
    }

    public void bq(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aFH().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cFj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aFH = com.baidu.tbadk.core.sharedPref.b.aFH();
        aFH.putInt("post" + currentAccount, this.jSs);
        aFH.putInt("like" + currentAccount, this.jSt);
        aFH.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.dvK);
        aFH.putInt("live" + currentAccount, this.dvN);
        aFH.putInt("reply" + currentAccount, this.jSv);
        TbadkCoreApplication.getInst().setLocationShared(this.jSu);
    }

    public void BA(int i) {
        this.jSs = i;
    }

    public int cFk() {
        return this.jSt;
    }

    public void BB(int i) {
        if (i <= 3 && i >= 1) {
            this.jSt = i;
        }
    }

    public int cFl() {
        return this.dvN;
    }

    public void BC(int i) {
        if (i <= 3 && i >= 1) {
            this.dvN = i;
        }
    }

    public int cFm() {
        return this.dvK;
    }

    public void BD(int i) {
        if (i <= 3 && i >= 1) {
            this.dvK = i;
        }
    }

    public boolean cFn() {
        return this.jSu;
    }

    public void BE(int i) {
        switch (i) {
            case 1:
                this.jSu = true;
                return;
            default:
                this.jSu = false;
                return;
        }
    }

    public SimpleUser aYc() {
        return this.jSw;
    }

    public void b(SimpleUser simpleUser) {
        this.jSw = simpleUser;
    }

    public void BF(int i) {
        this.jSx = i;
    }

    public void BG(int i) {
        if (i == 0) {
            this.jSv = 1;
        } else {
            this.jSv = i;
        }
    }

    public int cFo() {
        return this.jSv;
    }
}
