package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aXR;
    private int aXU;
    private int gYF;
    private int gYG;
    private boolean gYH;
    private int gYI;
    private SimpleUser gYJ;
    private int gYK;

    public boolean bxB() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gYF = bVar.getInt("post" + currentAccount, 0);
        this.gYG = bVar.getInt("like" + currentAccount, 0);
        this.aXR = bVar.getInt("group" + currentAccount, 0);
        this.aXU = bVar.getInt("live" + currentAccount, 0);
        this.gYI = bVar.getInt("reply" + currentAccount, 1);
        this.gYH = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gYF == 0 && this.gYG == 0 && this.aXR == 0 && this.aXU == 0 && this.gYI == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gYF = aVar.gYF;
            this.gYG = aVar.gYG;
            this.aXR = aVar.aXR;
            this.gYH = aVar.gYH;
            this.aXU = aVar.aXU;
            this.gYK = aVar.gYK;
            this.gYI = aVar.gYI;
        }
    }

    public int bxC() {
        return this.gYF;
    }

    public void aR(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bxD() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gYF);
        bVar.putInt("like" + currentAccount, this.gYG);
        bVar.putInt("group" + currentAccount, this.aXR);
        bVar.putInt("live" + currentAccount, this.aXU);
        bVar.putInt("reply" + currentAccount, this.gYI);
        TbadkCoreApplication.getInst().setLocationShared(this.gYH);
    }

    public void uz(int i) {
        this.gYF = i;
    }

    public int bxE() {
        return this.gYG;
    }

    public void uA(int i) {
        if (i <= 3 && i >= 1) {
            this.gYG = i;
        }
    }

    public int LR() {
        return this.aXU;
    }

    public void uB(int i) {
        if (i <= 3 && i >= 1) {
            this.aXU = i;
        }
    }

    public int bxF() {
        return this.aXR;
    }

    public void uC(int i) {
        if (i <= 3 && i >= 1) {
            this.aXR = i;
        }
    }

    public boolean bxG() {
        return this.gYH;
    }

    public void uD(int i) {
        switch (i) {
            case 1:
                this.gYH = true;
                return;
            default:
                this.gYH = false;
                return;
        }
    }

    public SimpleUser WC() {
        return this.gYJ;
    }

    public void b(SimpleUser simpleUser) {
        this.gYJ = simpleUser;
    }

    public void uE(int i) {
        this.gYK = i;
    }

    public void uF(int i) {
        if (i == 0) {
            this.gYI = 1;
        } else {
            this.gYI = i;
        }
    }

    public int bxH() {
        return this.gYI;
    }
}
