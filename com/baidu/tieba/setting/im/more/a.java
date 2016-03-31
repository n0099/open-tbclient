package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int asq;
    private boolean eaA;
    private SimpleUser eaB;
    private int eay;
    private int eaz;

    public boolean aMR() {
        com.baidu.tbadk.core.sharedPref.b vk = com.baidu.tbadk.core.sharedPref.b.vk();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.eay = vk.getInt("post" + currentAccount, 0);
        this.eaz = vk.getInt("like" + currentAccount, 0);
        this.asq = vk.getInt("group" + currentAccount, 0);
        this.eaA = TbadkCoreApplication.m411getInst().getLocationShared();
        return (this.eay == 0 && this.eaz == 0 && this.asq == 0) ? false : true;
    }

    public void a(a aVar) {
        this.eay = aVar.eay;
        this.eaz = aVar.eaz;
        this.asq = aVar.asq;
        this.eaA = aVar.eaA;
    }

    public int aMS() {
        return this.eay;
    }

    public void aq(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.vk().putInt(String.valueOf(str) + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void aMT() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b vk = com.baidu.tbadk.core.sharedPref.b.vk();
        vk.putInt("post" + currentAccount, this.eay);
        vk.putInt("like" + currentAccount, this.eaz);
        vk.putInt("group" + currentAccount, this.asq);
        TbadkCoreApplication.m411getInst().setLocationShared(this.eaA);
    }

    public void oI(int i) {
        if (i <= 3 && i >= 1) {
            this.eay = i;
        }
    }

    public int aMU() {
        return this.eaz;
    }

    public void oJ(int i) {
        if (i <= 3 && i >= 1) {
            this.eaz = i;
        }
    }

    public int CI() {
        return this.asq;
    }

    public void oK(int i) {
        if (i <= 3 && i >= 1) {
            this.asq = i;
        }
    }

    public boolean aMV() {
        return this.eaA;
    }

    public void oL(int i) {
        switch (i) {
            case 1:
                this.eaA = true;
                return;
            default:
                this.eaA = false;
                return;
        }
    }

    public SimpleUser aMW() {
        return this.eaB;
    }

    public void a(SimpleUser simpleUser) {
        this.eaB = simpleUser;
    }
}
