package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes2.dex */
public class a {
    private int eJv;
    private int eJy;
    private int lNt;
    private int lNu;
    private boolean lNv;
    private int lNw;
    private SimpleUser lNx;
    private int lNy;

    public boolean dpM() {
        com.baidu.tbadk.core.sharedPref.b bik = com.baidu.tbadk.core.sharedPref.b.bik();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lNt = bik.getInt("post" + currentAccount, 0);
        this.lNu = bik.getInt("like" + currentAccount, 0);
        this.eJv = bik.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.eJy = bik.getInt("live" + currentAccount, 0);
        this.lNw = bik.getInt("reply" + currentAccount, 1);
        this.lNv = TbadkCoreApplication.getInst().getLocationShared();
        return (this.lNt == 0 && this.lNu == 0 && this.eJv == 0 && this.eJy == 0 && this.lNw == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.lNt = aVar.lNt;
            this.lNu = aVar.lNu;
            this.eJv = aVar.eJv;
            this.lNv = aVar.lNv;
            this.eJy = aVar.eJy;
            this.lNy = aVar.lNy;
            this.lNw = aVar.lNw;
        }
    }

    public int dpN() {
        return this.lNt;
    }

    public void bD(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.bik().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dpO() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bik = com.baidu.tbadk.core.sharedPref.b.bik();
        bik.putInt("post" + currentAccount, this.lNt);
        bik.putInt("like" + currentAccount, this.lNu);
        bik.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.eJv);
        bik.putInt("live" + currentAccount, this.eJy);
        bik.putInt("reply" + currentAccount, this.lNw);
        TbadkCoreApplication.getInst().setLocationShared(this.lNv);
    }

    public void GH(int i) {
        this.lNt = i;
    }

    public int dpP() {
        return this.lNu;
    }

    public void GI(int i) {
        if (i <= 3 && i >= 1) {
            this.lNu = i;
        }
    }

    public int dpQ() {
        return this.eJy;
    }

    public void GJ(int i) {
        if (i <= 3 && i >= 1) {
            this.eJy = i;
        }
    }

    public int dpR() {
        return this.eJv;
    }

    public void GK(int i) {
        if (i <= 3 && i >= 1) {
            this.eJv = i;
        }
    }

    public boolean dpS() {
        return this.lNv;
    }

    public void GL(int i) {
        switch (i) {
            case 1:
                this.lNv = true;
                return;
            default:
                this.lNv = false;
                return;
        }
    }

    public SimpleUser bAR() {
        return this.lNx;
    }

    public void b(SimpleUser simpleUser) {
        this.lNx = simpleUser;
    }

    public void GM(int i) {
        this.lNy = i;
    }

    public void GN(int i) {
        if (i == 0) {
            this.lNw = 1;
        } else {
            this.lNw = i;
        }
    }

    public int dpT() {
        return this.lNw;
    }
}
