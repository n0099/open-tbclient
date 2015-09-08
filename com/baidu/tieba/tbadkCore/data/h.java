package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class h extends i implements f {
    private int Uh;
    public String aZY;
    private a cRc;
    public boolean cRd = false;
    public String cRe;
    public long threadId;

    public void b(App app) {
        this.cRc = new a(app);
    }

    public a atZ() {
        return this.cRc;
    }

    public String aua() {
        return this.cRc == null ? "" : this.cRc.id;
    }

    public int aub() {
        return this.Uh;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void kp(int i) {
        this.Uh = i;
    }

    public boolean ru() {
        if (this.cRc == null) {
            return false;
        }
        return this.cRc.ru();
    }

    public boolean isApp() {
        if (this.cRc == null) {
            return false;
        }
        return this.cRc.rv();
    }

    public boolean auc() {
        if (this.cRc == null) {
            return false;
        }
        return this.cRc.rw();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.cRc == null) {
            return null;
        }
        return this.cRc.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getDownloadUrl() {
        if (this.cRc == null) {
            return null;
        }
        return this.cRc.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.cRc == null ? "" : this.cRc.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String atU() {
        if (this.cRc == null || this.cRc.cQV == null) {
            return null;
        }
        return this.cRc.cQV.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String atV() {
        if (this.cRc == null || this.cRc.cQV == null) {
            return null;
        }
        return this.cRc.cQV.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String atW() {
        if (this.cRc == null || this.cRc.cQV == null) {
            return null;
        }
        return this.cRc.cQV.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String atX() {
        if (this.cRc == null || this.cRc.cQV == null) {
            return null;
        }
        return this.cRc.cQV.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public long atY() {
        if (this.cRc == null) {
            return 0L;
        }
        return this.cRc.cQT * 1000;
    }

    public int aud() {
        if (this.cRc == null || this.cRc.cQV == null) {
            return -1;
        }
        return this.cRc.cQV.cQW;
    }

    public int getPosition() {
        int g = this.cRc != null ? com.baidu.adp.lib.g.b.g(this.cRc.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c aue() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.cRc != null) {
            cVar.Ui = this.cRc.id;
            cVar.Uj = this.cRc.name;
            cVar.Uk = this.cRc.cQR;
            cVar.Ul = this.cRc.url;
            cVar.Um = this.cRc.apk_url;
            cVar.Un = this.cRc.apk_name;
            try {
                cVar.Uo = Integer.parseInt(this.cRc.pos_name.trim());
            } catch (Exception e) {
                cVar.Uo = -1;
            }
            cVar.Up = this.cRc.first_name;
            cVar.Uq = this.cRc.second_name;
            cVar.Ur = this.cRc.Ur;
            cVar.abtest = this.cRc.abtest;
            cVar.Us = this.cRc.cQS;
            cVar.userId = this.cRc.user_id;
            cVar.Ut = this.cRc.verify;
            cVar.price = this.cRc.price;
            cVar.Uu = this.cRc.ext_info;
            cVar.Uv = this.cRc.cQT * 1000;
            if (this.cRc.cQV != null) {
                cVar.Uw.UB = this.cRc.cQV.pop_window_text;
                cVar.Uw.Uy = this.cRc.cQV.id;
                cVar.Uw.UA = this.cRc.cQV.thread_pic;
                cVar.Uw.UC = this.cRc.cQV.cQW;
                cVar.Uw.Uz = this.cRc.cQV.thread_title;
                cVar.Uw.userName = this.cRc.cQV.user_name;
                cVar.Uw.userPortrait = this.cRc.cQV.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aud() == 2 ? com.baidu.tbadk.core.data.c.Ud : com.baidu.tbadk.core.data.c.Uc;
    }
}
