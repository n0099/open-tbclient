package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class j extends k implements h {
    private int TT;
    public String aZR;
    private a cYC;
    public boolean cYD = false;
    public String cYE;
    public long threadId;

    public void b(App app) {
        this.cYC = new a(app);
    }

    public a awn() {
        return this.cYC;
    }

    public String awo() {
        return this.cYC == null ? "" : this.cYC.id;
    }

    public int awp() {
        return this.TT;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void hS(int i) {
        this.TT = i;
    }

    public boolean rp() {
        if (this.cYC == null) {
            return false;
        }
        return this.cYC.rp();
    }

    public boolean isApp() {
        if (this.cYC == null) {
            return false;
        }
        return this.cYC.rq();
    }

    public boolean awq() {
        if (this.cYC == null) {
            return false;
        }
        return this.cYC.rr();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.cYC == null) {
            return null;
        }
        return this.cYC.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getDownloadUrl() {
        if (this.cYC == null) {
            return null;
        }
        return this.cYC.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.cYC == null ? "" : this.cYC.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public String awj() {
        if (this.cYC == null || this.cYC.cYm == null) {
            return null;
        }
        return this.cYC.cYm.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public String awk() {
        if (this.cYC == null || this.cYC.cYm == null) {
            return null;
        }
        return this.cYC.cYm.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public String awl() {
        if (this.cYC == null || this.cYC.cYm == null) {
            return null;
        }
        return this.cYC.cYm.thread_title;
    }

    public String awr() {
        if (this.cYC == null || this.cYC.cYm == null) {
            return null;
        }
        return this.cYC.cYm.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public long awm() {
        if (this.cYC == null) {
            return 0L;
        }
        return this.cYC.cYk * 1000;
    }

    public int aws() {
        if (this.cYC == null || this.cYC.cYm == null) {
            return -1;
        }
        return this.cYC.cYm.cYo;
    }

    public int getPosition() {
        int g = this.cYC != null ? com.baidu.adp.lib.g.b.g(this.cYC.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b awt() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.cYC != null) {
            bVar.TU = this.cYC.id;
            bVar.TV = this.cYC.name;
            bVar.TW = this.cYC.cYi;
            bVar.TX = this.cYC.url;
            bVar.TY = this.cYC.apk_url;
            bVar.TZ = this.cYC.apk_name;
            bVar.Ua = this.cYC.pos_name.trim();
            bVar.Ub = this.cYC.first_name;
            bVar.Uc = this.cYC.second_name;
            bVar.Ud = this.cYC.Ud;
            bVar.abtest = this.cYC.abtest;
            bVar.Ue = this.cYC.cYj;
            bVar.userId = this.cYC.user_id;
            bVar.Uf = this.cYC.verify;
            bVar.price = this.cYC.price;
            bVar.Ug = this.cYC.ext_info;
            bVar.Uh = this.cYC.cYk * 1000;
            if (this.cYC.cYm != null) {
                bVar.Ui.Uo = this.cYC.cYm.pop_window_text;
                bVar.Ui.Uk = this.cYC.cYm.id;
                bVar.Ui.Un = this.cYC.cYm.thread_pic;
                bVar.Ui.Up = this.cYC.cYm.cYo;
                bVar.Ui.Ul = this.cYC.cYm.thread_title;
                bVar.Ui.userName = this.cYC.cYm.user_name;
                bVar.Ui.userPortrait = this.cYC.cYm.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.k, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (aws() == 2) {
            return com.baidu.tbadk.core.data.b.TO;
        }
        if (aws() == 6) {
            return com.baidu.tbadk.core.data.b.TP;
        }
        return com.baidu.tbadk.core.data.b.TM;
    }
}
