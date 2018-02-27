package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int brc;
    private int brf;
    private int gKL;
    private int gKM;
    private boolean gKN;
    private SimpleUser gKO;
    private int gKP;

    public boolean bpK() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gKL = bVar.getInt("post" + currentAccount, 0);
        this.gKM = bVar.getInt("like" + currentAccount, 0);
        this.brc = bVar.getInt("group" + currentAccount, 0);
        this.brf = bVar.getInt("live" + currentAccount, 0);
        this.gKN = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gKL == 0 && this.gKM == 0 && this.brc == 0 && this.brf == 0) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gKL = aVar.gKL;
            this.gKM = aVar.gKM;
            this.brc = aVar.brc;
            this.gKN = aVar.gKN;
            this.brf = aVar.brf;
            this.gKP = aVar.gKP;
        }
    }

    public int bpL() {
        return this.gKL;
    }

    public void aF(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bpM() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gKL);
        bVar.putInt("like" + currentAccount, this.gKM);
        bVar.putInt("group" + currentAccount, this.brc);
        bVar.putInt("live" + currentAccount, this.brf);
        TbadkCoreApplication.getInst().setLocationShared(this.gKN);
    }

    public void uI(int i) {
        this.gKL = i;
    }

    public int bpN() {
        return this.gKM;
    }

    public void uJ(int i) {
        if (i <= 3 && i >= 1) {
            this.gKM = i;
        }
    }

    public int KA() {
        return this.brf;
    }

    public void uK(int i) {
        if (i <= 3 && i >= 1) {
            this.brf = i;
        }
    }

    public int bpO() {
        return this.brc;
    }

    public void uL(int i) {
        if (i <= 3 && i >= 1) {
            this.brc = i;
        }
    }

    public boolean bpP() {
        return this.gKN;
    }

    public void uM(int i) {
        switch (i) {
            case 1:
                this.gKN = true;
                return;
            default:
                this.gKN = false;
                return;
        }
    }

    public SimpleUser Ux() {
        return this.gKO;
    }

    public void b(SimpleUser simpleUser) {
        this.gKO = simpleUser;
    }

    public void uN(int i) {
        this.gKP = i;
    }
}
