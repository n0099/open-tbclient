package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cqJ;
    private int cqM;
    private int iPl;
    private int iPm;
    private boolean iPn;
    private int iPo;
    private SimpleUser iPp;
    private int iPq;

    public boolean cjn() {
        com.baidu.tbadk.core.sharedPref.b ahO = com.baidu.tbadk.core.sharedPref.b.ahO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.iPl = ahO.getInt("post" + currentAccount, 0);
        this.iPm = ahO.getInt("like" + currentAccount, 0);
        this.cqJ = ahO.getInt("group" + currentAccount, 0);
        this.cqM = ahO.getInt("live" + currentAccount, 0);
        this.iPo = ahO.getInt("reply" + currentAccount, 1);
        this.iPn = TbadkCoreApplication.getInst().getLocationShared();
        return (this.iPl == 0 && this.iPm == 0 && this.cqJ == 0 && this.cqM == 0 && this.iPo == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.iPl = aVar.iPl;
            this.iPm = aVar.iPm;
            this.cqJ = aVar.cqJ;
            this.iPn = aVar.iPn;
            this.cqM = aVar.cqM;
            this.iPq = aVar.iPq;
            this.iPo = aVar.iPo;
        }
    }

    public int cjo() {
        return this.iPl;
    }

    public void bk(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.ahO().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void cjp() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b ahO = com.baidu.tbadk.core.sharedPref.b.ahO();
        ahO.putInt("post" + currentAccount, this.iPl);
        ahO.putInt("like" + currentAccount, this.iPm);
        ahO.putInt("group" + currentAccount, this.cqJ);
        ahO.putInt("live" + currentAccount, this.cqM);
        ahO.putInt("reply" + currentAccount, this.iPo);
        TbadkCoreApplication.getInst().setLocationShared(this.iPn);
    }

    public void zX(int i) {
        this.iPl = i;
    }

    public int cjq() {
        return this.iPm;
    }

    public void zY(int i) {
        if (i <= 3 && i >= 1) {
            this.iPm = i;
        }
    }

    public int arx() {
        return this.cqM;
    }

    public void zZ(int i) {
        if (i <= 3 && i >= 1) {
            this.cqM = i;
        }
    }

    public int cjr() {
        return this.cqJ;
    }

    public void Aa(int i) {
        if (i <= 3 && i >= 1) {
            this.cqJ = i;
        }
    }

    public boolean cjs() {
        return this.iPn;
    }

    public void Ab(int i) {
        switch (i) {
            case 1:
                this.iPn = true;
                return;
            default:
                this.iPn = false;
                return;
        }
    }

    public SimpleUser aCX() {
        return this.iPp;
    }

    public void b(SimpleUser simpleUser) {
        this.iPp = simpleUser;
    }

    public void Ac(int i) {
        this.iPq = i;
    }

    public void Ad(int i) {
        if (i == 0) {
            this.iPo = 1;
        } else {
            this.iPo = i;
        }
    }

    public int cjt() {
        return this.iPo;
    }
}
