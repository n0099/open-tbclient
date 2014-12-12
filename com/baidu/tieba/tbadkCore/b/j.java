package com.baidu.tieba.tbadkCore.b;

import tbclient.App;
/* loaded from: classes.dex */
public class j extends k implements g {
    private int Dk;
    public String Gb;
    public String aBV;
    private a bWM;
    public boolean bWN = false;
    public long threadId;

    public void b(App app) {
        this.bWM = new a(app);
    }

    public a agJ() {
        return this.bWM;
    }

    public String agK() {
        return this.bWM == null ? "" : this.bWM.id;
    }

    public int agL() {
        return this.Dk;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public void hA(int i) {
        this.Dk = i;
    }

    public boolean mu() {
        if (this.bWM == null) {
            return false;
        }
        return this.bWM.mu();
    }

    public boolean agM() {
        if (this.bWM == null) {
            return false;
        }
        return this.bWM.mv();
    }

    public boolean agN() {
        if (this.bWM == null) {
            return false;
        }
        return this.bWM.mw();
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getPkgName() {
        if (this.bWM == null) {
            return null;
        }
        return this.bWM.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getDownloadUrl() {
        if (this.bWM == null) {
            return null;
        }
        return this.bWM.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.v
    public String getAppName() {
        return this.bWM == null ? "" : this.bWM.name;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String agy() {
        if (this.bWM == null || this.bWM.bWy == null) {
            return null;
        }
        return this.bWM.bWy.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String agz() {
        if (this.bWM == null || this.bWM.bWy == null) {
            return null;
        }
        return this.bWM.bWy.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String agA() {
        if (this.bWM == null || this.bWM.bWy == null) {
            return null;
        }
        return this.bWM.bWy.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public String agB() {
        if (this.bWM == null || this.bWM.bWy == null) {
            return null;
        }
        return this.bWM.bWy.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.b.h
    public long agC() {
        if (this.bWM == null) {
            return 0L;
        }
        return this.bWM.bWw * 1000;
    }

    public int getShowType() {
        if (this.bWM == null || this.bWM.bWy == null) {
            return -1;
        }
        return this.bWM.bWy.bWz;
    }

    public int getPosition() {
        int i = this.bWM != null ? com.baidu.adp.lib.g.c.toInt(this.bWM.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String agO() {
        if (this.bWM == null || this.bWM.bWy == null) {
            return null;
        }
        return this.bWM.bWy.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c agP() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.bWM != null) {
            cVar.Dl = this.bWM.id;
            cVar.Dm = this.bWM.name;
            cVar.Dn = this.bWM.bWu;
            cVar.Do = this.bWM.url;
            cVar.Dp = this.bWM.apk_url;
            cVar.Dq = this.bWM.apk_name;
            try {
                cVar.Dr = Integer.parseInt(this.bWM.pos_name.trim());
            } catch (Exception e) {
                cVar.Dr = -1;
            }
            cVar.Ds = this.bWM.first_name;
            cVar.Dt = this.bWM.second_name;
            cVar.Du = this.bWM.Du;
            cVar.abtest = this.bWM.abtest;
            cVar.Dv = this.bWM.bWv;
            cVar.userId = this.bWM.user_id;
            cVar.Dw = this.bWM.verify;
            cVar.price = this.bWM.price;
            cVar.Dx = this.bWM.ext_info;
            cVar.Dy = this.bWM.bWw * 1000;
            if (this.bWM.bWy != null) {
                cVar.Dz.DF = this.bWM.bWy.pop_window_text;
                cVar.Dz.DB = this.bWM.bWy.id;
                cVar.Dz.DE = this.bWM.bWy.thread_pic;
                cVar.Dz.DG = this.bWM.bWy.bWz;
                cVar.Dz.DD = this.bWM.bWy.thread_title;
                cVar.Dz.userName = this.bWM.bWy.user_name;
                cVar.Dz.userPortrait = this.bWM.bWy.user_portrait;
            }
        }
        return cVar;
    }
}
