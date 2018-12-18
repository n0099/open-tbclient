package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int aXf;
    private int aXi;
    private int gUF;
    private int gUG;
    private boolean gUH;
    private int gUI;
    private SimpleUser gUJ;
    private int gUK;

    public boolean bwe() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.gUF = bVar.getInt("post" + currentAccount, 0);
        this.gUG = bVar.getInt("like" + currentAccount, 0);
        this.aXf = bVar.getInt("group" + currentAccount, 0);
        this.aXi = bVar.getInt("live" + currentAccount, 0);
        this.gUI = bVar.getInt("reply" + currentAccount, 1);
        this.gUH = TbadkCoreApplication.getInst().getLocationShared();
        return (this.gUF == 0 && this.gUG == 0 && this.aXf == 0 && this.aXi == 0 && this.gUI == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.gUF = aVar.gUF;
            this.gUG = aVar.gUG;
            this.aXf = aVar.aXf;
            this.gUH = aVar.gUH;
            this.aXi = aVar.aXi;
            this.gUK = aVar.gUK;
            this.gUI = aVar.gUI;
        }
    }

    public int bwf() {
        return this.gUF;
    }

    public void aQ(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bwg() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.gUF);
        bVar.putInt("like" + currentAccount, this.gUG);
        bVar.putInt("group" + currentAccount, this.aXf);
        bVar.putInt("live" + currentAccount, this.aXi);
        bVar.putInt("reply" + currentAccount, this.gUI);
        TbadkCoreApplication.getInst().setLocationShared(this.gUH);
    }

    public void uj(int i) {
        this.gUF = i;
    }

    public int bwh() {
        return this.gUG;
    }

    public void uk(int i) {
        if (i <= 3 && i >= 1) {
            this.gUG = i;
        }
    }

    public int LB() {
        return this.aXi;
    }

    public void ul(int i) {
        if (i <= 3 && i >= 1) {
            this.aXi = i;
        }
    }

    public int bwi() {
        return this.aXf;
    }

    public void um(int i) {
        if (i <= 3 && i >= 1) {
            this.aXf = i;
        }
    }

    public boolean bwj() {
        return this.gUH;
    }

    public void un(int i) {
        switch (i) {
            case 1:
                this.gUH = true;
                return;
            default:
                this.gUH = false;
                return;
        }
    }

    public SimpleUser We() {
        return this.gUJ;
    }

    public void b(SimpleUser simpleUser) {
        this.gUJ = simpleUser;
    }

    public void uo(int i) {
        this.gUK = i;
    }

    public void up(int i) {
        if (i == 0) {
            this.gUI = 1;
        } else {
            this.gUI = i;
        }
    }

    public int bwk() {
        return this.gUI;
    }
}
