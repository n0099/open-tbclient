package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int drb;
    private int dre;
    private int jPH;
    private int jPI;
    private boolean jPJ;
    private int jPK;
    private SimpleUser jPL;
    private int jPM;

    public boolean cDj() {
        com.baidu.tbadk.core.sharedPref.b aDr = com.baidu.tbadk.core.sharedPref.b.aDr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.jPH = aDr.getInt("post" + currentAccount, 0);
        this.jPI = aDr.getInt("like" + currentAccount, 0);
        this.drb = aDr.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.dre = aDr.getInt("live" + currentAccount, 0);
        this.jPK = aDr.getInt("reply" + currentAccount, 1);
        this.jPJ = TbadkCoreApplication.getInst().getLocationShared();
        return (this.jPH == 0 && this.jPI == 0 && this.drb == 0 && this.dre == 0 && this.jPK == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.jPH = aVar.jPH;
            this.jPI = aVar.jPI;
            this.drb = aVar.drb;
            this.jPJ = aVar.jPJ;
            this.dre = aVar.dre;
            this.jPM = aVar.jPM;
            this.jPK = aVar.jPK;
        }
    }

    public int cDk() {
        return this.jPH;
    }

    public void br(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aDr().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cDl() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aDr = com.baidu.tbadk.core.sharedPref.b.aDr();
        aDr.putInt("post" + currentAccount, this.jPH);
        aDr.putInt("like" + currentAccount, this.jPI);
        aDr.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.drb);
        aDr.putInt("live" + currentAccount, this.dre);
        aDr.putInt("reply" + currentAccount, this.jPK);
        TbadkCoreApplication.getInst().setLocationShared(this.jPJ);
    }

    public void Bj(int i) {
        this.jPH = i;
    }

    public int cDm() {
        return this.jPI;
    }

    public void Bk(int i) {
        if (i <= 3 && i >= 1) {
            this.jPI = i;
        }
    }

    public int cDn() {
        return this.dre;
    }

    public void Bl(int i) {
        if (i <= 3 && i >= 1) {
            this.dre = i;
        }
    }

    public int cDo() {
        return this.drb;
    }

    public void Bm(int i) {
        if (i <= 3 && i >= 1) {
            this.drb = i;
        }
    }

    public boolean cDp() {
        return this.jPJ;
    }

    public void Bn(int i) {
        switch (i) {
            case 1:
                this.jPJ = true;
                return;
            default:
                this.jPJ = false;
                return;
        }
    }

    public SimpleUser aVG() {
        return this.jPL;
    }

    public void b(SimpleUser simpleUser) {
        this.jPL = simpleUser;
    }

    public void Bo(int i) {
        this.jPM = i;
    }

    public void Bp(int i) {
        if (i == 0) {
            this.jPK = 1;
        } else {
            this.jPK = i;
        }
    }

    public int cDq() {
        return this.jPK;
    }
}
