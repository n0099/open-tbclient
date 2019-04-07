package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int chn;
    private int chq;
    private int ipY;
    private int ipZ;
    private boolean iqa;
    private int iqb;
    private SimpleUser iqc;
    private int iqd;

    public boolean bYo() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ipY = bVar.getInt("post" + currentAccount, 0);
        this.ipZ = bVar.getInt("like" + currentAccount, 0);
        this.chn = bVar.getInt("group" + currentAccount, 0);
        this.chq = bVar.getInt("live" + currentAccount, 0);
        this.iqb = bVar.getInt("reply" + currentAccount, 1);
        this.iqa = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ipY == 0 && this.ipZ == 0 && this.chn == 0 && this.chq == 0 && this.iqb == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ipY = aVar.ipY;
            this.ipZ = aVar.ipZ;
            this.chn = aVar.chn;
            this.iqa = aVar.iqa;
            this.chq = aVar.chq;
            this.iqd = aVar.iqd;
            this.iqb = aVar.iqb;
        }
    }

    public int bYp() {
        return this.ipY;
    }

    public void bn(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bYq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.ipY);
        bVar.putInt("like" + currentAccount, this.ipZ);
        bVar.putInt("group" + currentAccount, this.chn);
        bVar.putInt("live" + currentAccount, this.chq);
        bVar.putInt("reply" + currentAccount, this.iqb);
        TbadkCoreApplication.getInst().setLocationShared(this.iqa);
    }

    public void yk(int i) {
        this.ipY = i;
    }

    public int bYr() {
        return this.ipZ;
    }

    public void yl(int i) {
        if (i <= 3 && i >= 1) {
            this.ipZ = i;
        }
    }

    public int alp() {
        return this.chq;
    }

    public void ym(int i) {
        if (i <= 3 && i >= 1) {
            this.chq = i;
        }
    }

    public int bYs() {
        return this.chn;
    }

    public void yn(int i) {
        if (i <= 3 && i >= 1) {
            this.chn = i;
        }
    }

    public boolean bYt() {
        return this.iqa;
    }

    public void yo(int i) {
        switch (i) {
            case 1:
                this.iqa = true;
                return;
            default:
                this.iqa = false;
                return;
        }
    }

    public SimpleUser awz() {
        return this.iqc;
    }

    public void b(SimpleUser simpleUser) {
        this.iqc = simpleUser;
    }

    public void yp(int i) {
        this.iqd = i;
    }

    public void yq(int i) {
        if (i == 0) {
            this.iqb = 1;
        } else {
            this.iqb = i;
        }
    }

    public int bYu() {
        return this.iqb;
    }
}
