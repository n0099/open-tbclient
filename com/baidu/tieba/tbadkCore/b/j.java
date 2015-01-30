package com.baidu.tieba.tbadkCore.b;

import tbclient.App;
/* loaded from: classes.dex */
public class j extends k implements g {
    private int Dm;
    public String aCW;
    private a bYE;
    public boolean bYF = false;
    public String bYG;
    public long threadId;

    public void b(App app) {
        this.bYE = new a(app);
    }

    public a aho() {
        return this.bYE;
    }

    public String ahp() {
        return this.bYE == null ? "" : this.bYE.id;
    }

    public int ahq() {
        return this.Dm;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public void hJ(int i) {
        this.Dm = i;
    }

    public boolean mu() {
        if (this.bYE == null) {
            return false;
        }
        return this.bYE.mu();
    }

    public boolean ahr() {
        if (this.bYE == null) {
            return false;
        }
        return this.bYE.mv();
    }

    public boolean ahs() {
        if (this.bYE == null) {
            return false;
        }
        return this.bYE.mw();
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getPkgName() {
        if (this.bYE == null) {
            return null;
        }
        return this.bYE.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getDownloadUrl() {
        if (this.bYE == null) {
            return null;
        }
        return this.bYE.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getAppName() {
        return this.bYE == null ? "" : this.bYE.name;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String ahd() {
        if (this.bYE == null || this.bYE.bYq == null) {
            return null;
        }
        return this.bYE.bYq.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String ahe() {
        if (this.bYE == null || this.bYE.bYq == null) {
            return null;
        }
        return this.bYE.bYq.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String ahf() {
        if (this.bYE == null || this.bYE.bYq == null) {
            return null;
        }
        return this.bYE.bYq.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String ahg() {
        if (this.bYE == null || this.bYE.bYq == null) {
            return null;
        }
        return this.bYE.bYq.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public long ahh() {
        if (this.bYE == null) {
            return 0L;
        }
        return this.bYE.bYo * 1000;
    }

    public int getShowType() {
        if (this.bYE == null || this.bYE.bYq == null) {
            return -1;
        }
        return this.bYE.bYq.bYr;
    }

    public int getPosition() {
        int i = this.bYE != null ? com.baidu.adp.lib.g.c.toInt(this.bYE.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String aht() {
        if (this.bYE == null || this.bYE.bYq == null) {
            return null;
        }
        return this.bYE.bYq.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c ahu() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.bYE != null) {
            cVar.Dn = this.bYE.id;
            cVar.Do = this.bYE.name;
            cVar.Dp = this.bYE.bYm;
            cVar.Dq = this.bYE.url;
            cVar.Dr = this.bYE.apk_url;
            cVar.Ds = this.bYE.apk_name;
            try {
                cVar.Dt = Integer.parseInt(this.bYE.pos_name.trim());
            } catch (Exception e) {
                cVar.Dt = -1;
            }
            cVar.Du = this.bYE.first_name;
            cVar.Dv = this.bYE.second_name;
            cVar.Dw = this.bYE.Dw;
            cVar.abtest = this.bYE.abtest;
            cVar.Dx = this.bYE.bYn;
            cVar.userId = this.bYE.user_id;
            cVar.Dy = this.bYE.verify;
            cVar.price = this.bYE.price;
            cVar.Dz = this.bYE.ext_info;
            cVar.DA = this.bYE.bYo * 1000;
            if (this.bYE.bYq != null) {
                cVar.DB.DH = this.bYE.bYq.pop_window_text;
                cVar.DB.DE = this.bYE.bYq.id;
                cVar.DB.DG = this.bYE.bYq.thread_pic;
                cVar.DB.DI = this.bYE.bYq.bYr;
                cVar.DB.DF = this.bYE.bYq.thread_title;
                cVar.DB.userName = this.bYE.bYq.user_name;
                cVar.DB.userPortrait = this.bYE.bYq.user_portrait;
            }
        }
        return cVar;
    }
}
