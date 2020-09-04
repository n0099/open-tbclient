package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int eJC;
    private int eJz;
    private int lNG;
    private int lNH;
    private boolean lNI;
    private int lNJ;
    private SimpleUser lNK;
    private int lNL;

    public boolean dpP() {
        com.baidu.tbadk.core.sharedPref.b bik = com.baidu.tbadk.core.sharedPref.b.bik();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lNG = bik.getInt("post" + currentAccount, 0);
        this.lNH = bik.getInt("like" + currentAccount, 0);
        this.eJz = bik.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.eJC = bik.getInt("live" + currentAccount, 0);
        this.lNJ = bik.getInt("reply" + currentAccount, 1);
        this.lNI = TbadkCoreApplication.getInst().getLocationShared();
        return (this.lNG == 0 && this.lNH == 0 && this.eJz == 0 && this.eJC == 0 && this.lNJ == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.lNG = aVar.lNG;
            this.lNH = aVar.lNH;
            this.eJz = aVar.eJz;
            this.lNI = aVar.lNI;
            this.eJC = aVar.eJC;
            this.lNL = aVar.lNL;
            this.lNJ = aVar.lNJ;
        }
    }

    public int dpQ() {
        return this.lNG;
    }

    public void bD(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dpR() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bik = com.baidu.tbadk.core.sharedPref.b.bik();
        bik.putInt("post" + currentAccount, this.lNG);
        bik.putInt("like" + currentAccount, this.lNH);
        bik.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.eJz);
        bik.putInt("live" + currentAccount, this.eJC);
        bik.putInt("reply" + currentAccount, this.lNJ);
        TbadkCoreApplication.getInst().setLocationShared(this.lNI);
    }

    public void GH(int i) {
        this.lNG = i;
    }

    public int dpS() {
        return this.lNH;
    }

    public void GI(int i) {
        if (i <= 3 && i >= 1) {
            this.lNH = i;
        }
    }

    public int dpT() {
        return this.eJC;
    }

    public void GJ(int i) {
        if (i <= 3 && i >= 1) {
            this.eJC = i;
        }
    }

    public int dpU() {
        return this.eJz;
    }

    public void GK(int i) {
        if (i <= 3 && i >= 1) {
            this.eJz = i;
        }
    }

    public boolean dpV() {
        return this.lNI;
    }

    public void GL(int i) {
        switch (i) {
            case 1:
                this.lNI = true;
                return;
            default:
                this.lNI = false;
                return;
        }
    }

    public SimpleUser bAS() {
        return this.lNK;
    }

    public void b(SimpleUser simpleUser) {
        this.lNK = simpleUser;
    }

    public void GM(int i) {
        this.lNL = i;
    }

    public void GN(int i) {
        if (i == 0) {
            this.lNJ = 1;
        } else {
            this.lNJ = i;
        }
    }

    public int dpW() {
        return this.lNJ;
    }
}
