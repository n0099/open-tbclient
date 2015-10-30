package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class j extends k implements h {
    private int TU;
    public String bac;
    public int cHN;
    private a cZc;
    public boolean cZd = false;
    public String cZe;
    public long threadId;

    public void b(App app) {
        this.cZc = new a(app);
    }

    public a aws() {
        return this.cZc;
    }

    public String awt() {
        return this.cZc == null ? "" : this.cZc.id;
    }

    public int awu() {
        return this.TU;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void hS(int i) {
        this.TU = i;
    }

    public boolean rm() {
        if (this.cZc == null) {
            return false;
        }
        return this.cZc.rm();
    }

    public boolean isApp() {
        if (this.cZc == null) {
            return false;
        }
        return this.cZc.rn();
    }

    public boolean awv() {
        if (this.cZc == null) {
            return false;
        }
        return this.cZc.ro();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.cZc == null) {
            return null;
        }
        return this.cZc.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getDownloadUrl() {
        if (this.cZc == null) {
            return null;
        }
        return this.cZc.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.cZc == null ? "" : this.cZc.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public String awo() {
        if (this.cZc == null || this.cZc.cYM == null) {
            return null;
        }
        return this.cZc.cYM.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public String awp() {
        if (this.cZc == null || this.cZc.cYM == null) {
            return null;
        }
        return this.cZc.cYM.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public String awq() {
        if (this.cZc == null || this.cZc.cYM == null) {
            return null;
        }
        return this.cZc.cYM.thread_title;
    }

    public String aww() {
        if (this.cZc == null || this.cZc.cYM == null) {
            return null;
        }
        return this.cZc.cYM.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i
    public long awr() {
        if (this.cZc == null) {
            return 0L;
        }
        return this.cZc.cYK * 1000;
    }

    public int awx() {
        if (this.cZc == null || this.cZc.cYM == null) {
            return -1;
        }
        return this.cZc.cYM.cYO;
    }

    public int getPosition() {
        int g = this.cZc != null ? com.baidu.adp.lib.g.b.g(this.cZc.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public String awy() {
        if (this.cZc == null || this.cZc.cYM == null) {
            return null;
        }
        return this.cZc.cYM.pop_window_text;
    }

    public com.baidu.tbadk.core.data.b awz() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.cZc != null) {
            bVar.TV = this.cZc.id;
            bVar.TW = this.cZc.name;
            bVar.TX = this.cZc.cYI;
            bVar.TY = this.cZc.url;
            bVar.TZ = this.cZc.apk_url;
            bVar.Ua = this.cZc.apk_name;
            bVar.Ub = this.cZc.pos_name.trim();
            bVar.Uc = this.cZc.first_name;
            bVar.Ud = this.cZc.second_name;
            bVar.Ue = this.cZc.Ue;
            bVar.abtest = this.cZc.abtest;
            bVar.Uf = this.cZc.cYJ;
            bVar.userId = this.cZc.user_id;
            bVar.Ug = this.cZc.verify;
            bVar.price = this.cZc.price;
            bVar.Uh = this.cZc.ext_info;
            bVar.Ui = this.cZc.cYK * 1000;
            if (this.cZc.cYM != null) {
                bVar.Uj.Up = this.cZc.cYM.pop_window_text;
                bVar.Uj.Ul = this.cZc.cYM.id;
                bVar.Uj.Uo = this.cZc.cYM.thread_pic;
                bVar.Uj.Uq = this.cZc.cYM.cYO;
                bVar.Uj.Um = this.cZc.cYM.thread_title;
                bVar.Uj.userName = this.cZc.cYM.user_name;
                bVar.Uj.userPortrait = this.cZc.cYM.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.k, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (awx() == 2) {
            return com.baidu.tbadk.core.data.b.TP;
        }
        if (awx() == 6) {
            return com.baidu.tbadk.core.data.b.TQ;
        }
        return com.baidu.tbadk.core.data.b.TO;
    }
}
