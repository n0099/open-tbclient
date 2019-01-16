package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aXQ;
    private int aXT;
    private int gYE;
    private int gYF;
    private boolean gYG;
    private int gYH;
    private SimpleUser gYI;
    private int gYJ;

    public boolean bxB() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gYE = bVar.getInt("post" + currentAccount, 0);
        this.gYF = bVar.getInt("like" + currentAccount, 0);
        this.aXQ = bVar.getInt("group" + currentAccount, 0);
        this.aXT = bVar.getInt("live" + currentAccount, 0);
        this.gYH = bVar.getInt("reply" + currentAccount, 1);
        this.gYG = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gYE == 0 && this.gYF == 0 && this.aXQ == 0 && this.aXT == 0 && this.gYH == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gYE = aVar.gYE;
            this.gYF = aVar.gYF;
            this.aXQ = aVar.aXQ;
            this.gYG = aVar.gYG;
            this.aXT = aVar.aXT;
            this.gYJ = aVar.gYJ;
            this.gYH = aVar.gYH;
        }
    }

    public int bxC() {
        return this.gYE;
    }

    public void aR(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bxD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gYE);
        bVar.putInt("like" + currentAccount, this.gYF);
        bVar.putInt("group" + currentAccount, this.aXQ);
        bVar.putInt("live" + currentAccount, this.aXT);
        bVar.putInt("reply" + currentAccount, this.gYH);
        TbadkCoreApplication.getInst().setLocationShared(this.gYG);
    }

    public void uz(int i) {
        this.gYE = i;
    }

    public int bxE() {
        return this.gYF;
    }

    public void uA(int i) {
        if (i <= 3 && i >= 1) {
            this.gYF = i;
        }
    }

    public int LR() {
        return this.aXT;
    }

    public void uB(int i) {
        if (i <= 3 && i >= 1) {
            this.aXT = i;
        }
    }

    public int bxF() {
        return this.aXQ;
    }

    public void uC(int i) {
        if (i <= 3 && i >= 1) {
            this.aXQ = i;
        }
    }

    public boolean bxG() {
        return this.gYG;
    }

    public void uD(int i) {
        switch (i) {
            case 1:
                this.gYG = true;
                return;
            default:
                this.gYG = false;
                return;
        }
    }

    public SimpleUser WC() {
        return this.gYI;
    }

    public void b(SimpleUser simpleUser) {
        this.gYI = simpleUser;
    }

    public void uE(int i) {
        this.gYJ = i;
    }

    public void uF(int i) {
        if (i == 0) {
            this.gYH = 1;
        } else {
            this.gYH = i;
        }
    }

    public int bxH() {
        return this.gYH;
    }
}
