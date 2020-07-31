package com.baidu.tieba.setting.im.more;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int eyX;
    private int eza;
    private int lwd;
    private int lwe;
    private boolean lwf;
    private int lwg;
    private SimpleUser lwh;
    private int lwi;

    public boolean det() {
        com.baidu.tbadk.core.sharedPref.b aZP = com.baidu.tbadk.core.sharedPref.b.aZP();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.lwd = aZP.getInt("post" + currentAccount, 0);
        this.lwe = aZP.getInt("like" + currentAccount, 0);
        this.eyX = aZP.getInt(TbEnum.ParamKey.GROUP + currentAccount, 0);
        this.eza = aZP.getInt("live" + currentAccount, 0);
        this.lwg = aZP.getInt("reply" + currentAccount, 1);
        this.lwf = TbadkCoreApplication.getInst().getLocationShared();
        return (this.lwd == 0 && this.lwe == 0 && this.eyX == 0 && this.eza == 0 && this.lwg == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.lwd = aVar.lwd;
            this.lwe = aVar.lwe;
            this.eyX = aVar.eyX;
            this.lwf = aVar.lwf;
            this.eza = aVar.eza;
            this.lwi = aVar.lwi;
            this.lwg = aVar.lwg;
        }
    }

    public int deu() {
        return this.lwd;
    }

    public void by(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.aZP().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void dev() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b aZP = com.baidu.tbadk.core.sharedPref.b.aZP();
        aZP.putInt("post" + currentAccount, this.lwd);
        aZP.putInt("like" + currentAccount, this.lwe);
        aZP.putInt(TbEnum.ParamKey.GROUP + currentAccount, this.eyX);
        aZP.putInt("live" + currentAccount, this.eza);
        aZP.putInt("reply" + currentAccount, this.lwg);
        TbadkCoreApplication.getInst().setLocationShared(this.lwf);
    }

    public void Ek(int i) {
        this.lwd = i;
    }

    public int dew() {
        return this.lwe;
    }

    public void El(int i) {
        if (i <= 3 && i >= 1) {
            this.lwe = i;
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
        return this.lwf;
    }

    public void Eo(int i) {
        switch (i) {
            case 1:
                this.lwf = true;
                return;
            default:
                this.lwf = false;
                return;
        }
    }

    public SimpleUser brU() {
        return this.lwh;
    }

    public void b(SimpleUser simpleUser) {
        this.lwh = simpleUser;
    }

    public void Ep(int i) {
        this.lwi = i;
    }

    public void Eq(int i) {
        if (i == 0) {
            this.lwg = 1;
        } else {
            this.lwg = i;
        }
    }

    public int deA() {
        return this.lwg;
    }
}
