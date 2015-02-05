package com.baidu.tieba.tbadkCore.b;

import tbclient.App;
/* loaded from: classes.dex */
public class j extends k implements g {
    private int Dj;
    public String aCT;
    private a bYD;
    public boolean bYE = false;
    public String bYF;
    public long threadId;

    public void b(App app) {
        this.bYD = new a(app);
    }

    public a ahj() {
        return this.bYD;
    }

    public String ahk() {
        return this.bYD == null ? "" : this.bYD.id;
    }

    public int ahl() {
        return this.Dj;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public void hJ(int i) {
        this.Dj = i;
    }

    public boolean mn() {
        if (this.bYD == null) {
            return false;
        }
        return this.bYD.mn();
    }

    public boolean ahm() {
        if (this.bYD == null) {
            return false;
        }
        return this.bYD.mo();
    }

    public boolean ahn() {
        if (this.bYD == null) {
            return false;
        }
        return this.bYD.mp();
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getPkgName() {
        if (this.bYD == null) {
            return null;
        }
        return this.bYD.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getDownloadUrl() {
        if (this.bYD == null) {
            return null;
        }
        return this.bYD.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getAppName() {
        return this.bYD == null ? "" : this.bYD.name;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String agY() {
        if (this.bYD == null || this.bYD.bYp == null) {
            return null;
        }
        return this.bYD.bYp.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String agZ() {
        if (this.bYD == null || this.bYD.bYp == null) {
            return null;
        }
        return this.bYD.bYp.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String aha() {
        if (this.bYD == null || this.bYD.bYp == null) {
            return null;
        }
        return this.bYD.bYp.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String ahb() {
        if (this.bYD == null || this.bYD.bYp == null) {
            return null;
        }
        return this.bYD.bYp.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public long ahc() {
        if (this.bYD == null) {
            return 0L;
        }
        return this.bYD.bYn * 1000;
    }

    public int getShowType() {
        if (this.bYD == null || this.bYD.bYp == null) {
            return -1;
        }
        return this.bYD.bYp.bYq;
    }

    public int getPosition() {
        int i = this.bYD != null ? com.baidu.adp.lib.g.c.toInt(this.bYD.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String aho() {
        if (this.bYD == null || this.bYD.bYp == null) {
            return null;
        }
        return this.bYD.bYp.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c ahp() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.bYD != null) {
            cVar.Dk = this.bYD.id;
            cVar.Dl = this.bYD.name;
            cVar.Dm = this.bYD.bYl;
            cVar.Dn = this.bYD.url;
            cVar.Do = this.bYD.apk_url;
            cVar.Dp = this.bYD.apk_name;
            try {
                cVar.Dq = Integer.parseInt(this.bYD.pos_name.trim());
            } catch (Exception e) {
                cVar.Dq = -1;
            }
            cVar.Dr = this.bYD.first_name;
            cVar.Ds = this.bYD.second_name;
            cVar.Dt = this.bYD.Dt;
            cVar.abtest = this.bYD.abtest;
            cVar.Du = this.bYD.bYm;
            cVar.userId = this.bYD.user_id;
            cVar.Dv = this.bYD.verify;
            cVar.price = this.bYD.price;
            cVar.Dw = this.bYD.ext_info;
            cVar.Dx = this.bYD.bYn * 1000;
            if (this.bYD.bYp != null) {
                cVar.Dy.DE = this.bYD.bYp.pop_window_text;
                cVar.Dy.DA = this.bYD.bYp.id;
                cVar.Dy.DD = this.bYD.bYp.thread_pic;
                cVar.Dy.DF = this.bYD.bYp.bYq;
                cVar.Dy.DB = this.bYD.bYp.thread_title;
                cVar.Dy.userName = this.bYD.bYp.user_name;
                cVar.Dy.userPortrait = this.bYD.bYp.user_portrait;
            }
        }
        return cVar;
    }
}
