package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import tbclient.SimpleUser;
/* loaded from: classes.dex */
public class a {
    private int cho;
    private int chr;
    private int ipZ;
    private int iqa;
    private boolean iqb;
    private int iqc;
    private SimpleUser iqd;
    private int iqe;

    public boolean bYo() {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.ipZ = bVar.getInt("post" + currentAccount, 0);
        this.iqa = bVar.getInt("like" + currentAccount, 0);
        this.cho = bVar.getInt("group" + currentAccount, 0);
        this.chr = bVar.getInt("live" + currentAccount, 0);
        this.iqc = bVar.getInt("reply" + currentAccount, 1);
        this.iqb = TbadkCoreApplication.getInst().getLocationShared();
        return (this.ipZ == 0 && this.iqa == 0 && this.cho == 0 && this.chr == 0 && this.iqc == 1) ? false : true;
    }

    public void b(a aVar) {
        if (aVar != null) {
            this.ipZ = aVar.ipZ;
            this.iqa = aVar.iqa;
            this.cho = aVar.cho;
            this.iqb = aVar.iqb;
            this.chr = aVar.chr;
            this.iqe = aVar.iqe;
            this.iqc = aVar.iqc;
        }
    }

    public int bYp() {
        return this.ipZ;
    }

    public void bn(String str, int i) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt(str + TbadkCoreApplication.getCurrentAccount(), i);
    }

    public void bYq() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        bVar.putInt("post" + currentAccount, this.ipZ);
        bVar.putInt("like" + currentAccount, this.iqa);
        bVar.putInt("group" + currentAccount, this.cho);
        bVar.putInt("live" + currentAccount, this.chr);
        bVar.putInt("reply" + currentAccount, this.iqc);
        TbadkCoreApplication.getInst().setLocationShared(this.iqb);
    }

    public void yk(int i) {
        this.ipZ = i;
    }

    public int bYr() {
        return this.iqa;
    }

    public void yl(int i) {
        if (i <= 3 && i >= 1) {
            this.iqa = i;
        }
    }

    public int alp() {
        return this.chr;
    }

    public void ym(int i) {
        if (i <= 3 && i >= 1) {
            this.chr = i;
        }
    }

    public int bYs() {
        return this.cho;
    }

    public void yn(int i) {
        if (i <= 3 && i >= 1) {
            this.cho = i;
        }
    }

    public boolean bYt() {
        return this.iqb;
    }

    public void yo(int i) {
        switch (i) {
            case 1:
                this.iqb = true;
                return;
            default:
                this.iqb = false;
                return;
        }
    }

    public SimpleUser awz() {
        return this.iqd;
    }

    public void b(SimpleUser simpleUser) {
        this.iqd = simpleUser;
    }

    public void yp(int i) {
        this.iqe = i;
    }

    public void yq(int i) {
        if (i == 0) {
            this.iqc = 1;
        } else {
            this.iqc = i;
        }
    }

    public int bYu() {
        return this.iqc;
    }
}
