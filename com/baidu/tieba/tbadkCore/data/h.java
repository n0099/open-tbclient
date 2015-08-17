package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class h extends i implements f {
    private int Ug;
    public String aZG;
    private a cIC;
    public boolean cID = false;
    public String cIE;
    public long threadId;

    public void b(App app) {
        this.cIC = new a(app);
    }

    public a apM() {
        return this.cIC;
    }

    public String apN() {
        return this.cIC == null ? "" : this.cIC.id;
    }

    public int apO() {
        return this.Ug;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public void jE(int i) {
        this.Ug = i;
    }

    public boolean rv() {
        if (this.cIC == null) {
            return false;
        }
        return this.cIC.rv();
    }

    public boolean isApp() {
        if (this.cIC == null) {
            return false;
        }
        return this.cIC.rw();
    }

    public boolean apP() {
        if (this.cIC == null) {
            return false;
        }
        return this.cIC.rx();
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public String getPkgName() {
        if (this.cIC == null) {
            return null;
        }
        return this.cIC.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public String getDownloadUrl() {
        if (this.cIC == null) {
            return null;
        }
        return this.cIC.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.p
    public String getAppName() {
        return this.cIC == null ? "" : this.cIC.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String apH() {
        if (this.cIC == null || this.cIC.cIv == null) {
            return null;
        }
        return this.cIC.cIv.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String apI() {
        if (this.cIC == null || this.cIC.cIv == null) {
            return null;
        }
        return this.cIC.cIv.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String apJ() {
        if (this.cIC == null || this.cIC.cIv == null) {
            return null;
        }
        return this.cIC.cIv.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public String apK() {
        if (this.cIC == null || this.cIC.cIv == null) {
            return null;
        }
        return this.cIC.cIv.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.g
    public long apL() {
        if (this.cIC == null) {
            return 0L;
        }
        return this.cIC.cIt * 1000;
    }

    public int apQ() {
        if (this.cIC == null || this.cIC.cIv == null) {
            return -1;
        }
        return this.cIC.cIv.cIw;
    }

    public int getPosition() {
        int g = this.cIC != null ? com.baidu.adp.lib.g.b.g(this.cIC.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c apR() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.cIC != null) {
            cVar.Uh = this.cIC.id;
            cVar.Ui = this.cIC.name;
            cVar.Uj = this.cIC.cIr;
            cVar.Uk = this.cIC.url;
            cVar.Ul = this.cIC.apk_url;
            cVar.Um = this.cIC.apk_name;
            try {
                cVar.Un = Integer.parseInt(this.cIC.pos_name.trim());
            } catch (Exception e) {
                cVar.Un = -1;
            }
            cVar.Uo = this.cIC.first_name;
            cVar.Up = this.cIC.second_name;
            cVar.Uq = this.cIC.Uq;
            cVar.abtest = this.cIC.abtest;
            cVar.Ur = this.cIC.cIs;
            cVar.userId = this.cIC.user_id;
            cVar.Us = this.cIC.verify;
            cVar.price = this.cIC.price;
            cVar.Ut = this.cIC.ext_info;
            cVar.Uu = this.cIC.cIt * 1000;
            if (this.cIC.cIv != null) {
                cVar.Uv.UA = this.cIC.cIv.pop_window_text;
                cVar.Uv.Ux = this.cIC.cIv.id;
                cVar.Uv.Uz = this.cIC.cIv.thread_pic;
                cVar.Uv.UB = this.cIC.cIv.cIw;
                cVar.Uv.Uy = this.cIC.cIv.thread_title;
                cVar.Uv.userName = this.cIC.cIv.user_name;
                cVar.Uv.userPortrait = this.cIC.cIv.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.i, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return apQ() == 2 ? com.baidu.tbadk.core.data.c.Uc : com.baidu.tbadk.core.data.c.Ub;
    }
}
