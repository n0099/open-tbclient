package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int eyX;
    private int eza;
    private int lwf;
    private int lwg;
    private boolean lwh;
    private int lwi;
    private SimpleUser lwj;
    private int lwk;

    public boolean det() {
        com.baidu.tbadk.core.sharedPref.b aZP = com.baidu.tbadk.core.sharedPref.b.aZP();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lwf = aZP.getInt("post" + currentAccount, 0);
        this.lwg = aZP.getInt("like" + currentAccount, 0);
        this.eyX = aZP.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.eza = aZP.getInt("live" + currentAccount, 0);
        this.lwi = aZP.getInt("reply" + currentAccount, 1);
        this.lwh = TbadkCoreApplication.getInst().getLocationShared();
        return (this.lwf == 0 && this.lwg == 0 && this.eyX == 0 && this.eza == 0 && this.lwi == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.lwf = aVar.lwf;
            this.lwg = aVar.lwg;
            this.eyX = aVar.eyX;
            this.lwh = aVar.lwh;
            this.eza = aVar.eza;
            this.lwk = aVar.lwk;
            this.lwi = aVar.lwi;
        }
    }

    public int deu() {
        return this.lwf;
    }

    public void by(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dev() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aZP = com.baidu.tbadk.core.sharedPref.b.aZP();
        aZP.putInt("post" + currentAccount, this.lwf);
        aZP.putInt("like" + currentAccount, this.lwg);
        aZP.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.eyX);
        aZP.putInt("live" + currentAccount, this.eza);
        aZP.putInt("reply" + currentAccount, this.lwi);
        TbadkCoreApplication.getInst().setLocationShared(this.lwh);
    }

    public void Ek(int i) {
        this.lwf = i;
    }

    public int dew() {
        return this.lwg;
    }

    public void El(int i) {
        if (i <= 3 && i >= 1) {
            this.lwg = i;
        }
    }

    public int dex() {
        return this.eza;
    }

    public void Em(int i) {
        if (i <= 3 && i >= 1) {
            this.eza = i;
        }
    }

    public int dey() {
        return this.eyX;
    }

    public void En(int i) {
        if (i <= 3 && i >= 1) {
            this.eyX = i;
        }
    }

    public boolean dez() {
        return this.lwh;
    }

    public void Eo(int i) {
        switch (i) {
            case 1:
                this.lwh = true;
                return;
            default:
                this.lwh = false;
                return;
        }
    }

    public SimpleUser brU() {
        return this.lwj;
    }

    public void b(SimpleUser simpleUser) {
        this.lwj = simpleUser;
    }

    public void Ep(int i) {
        this.lwk = i;
    }

    public void Eq(int i) {
        if (i == 0) {
            this.lwi = 1;
        } else {
            this.lwi = i;
        }
    }

    public int deA() {
        return this.lwi;
    }
}
