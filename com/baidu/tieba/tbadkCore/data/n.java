package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends o implements l {
    private int TV;
    public String baw;
    public int cJj;
    private d daJ;
    public boolean daK = false;
    public String daL;
    public long threadId;

    public void b(App app) {
        this.daJ = new d(app);
    }

    public d axg() {
        return this.daJ;
    }

    public String axh() {
        return this.daJ == null ? "" : this.daJ.id;
    }

    public int axi() {
        return this.TV;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public void ig(int i) {
        this.TV = i;
    }

    public boolean rn() {
        if (this.daJ == null) {
            return false;
        }
        return this.daJ.rn();
    }

    public boolean isApp() {
        if (this.daJ == null) {
            return false;
        }
        return this.daJ.ro();
    }

    public boolean axj() {
        if (this.daJ == null) {
            return false;
        }
        return this.daJ.rp();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.daJ == null) {
            return null;
        }
        return this.daJ.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getDownloadUrl() {
        if (this.daJ == null) {
            return null;
        }
        return this.daJ.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getAppName() {
        return this.daJ == null ? "" : this.daJ.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public String axc() {
        if (this.daJ == null || this.daJ.dap == null) {
            return null;
        }
        return this.daJ.dap.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public String axd() {
        if (this.daJ == null || this.daJ.dap == null) {
            return null;
        }
        return this.daJ.dap.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public String axe() {
        if (this.daJ == null || this.daJ.dap == null) {
            return null;
        }
        return this.daJ.dap.thread_title;
    }

    public String axk() {
        if (this.daJ == null || this.daJ.dap == null) {
            return null;
        }
        return this.daJ.dap.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public long axf() {
        if (this.daJ == null) {
            return 0L;
        }
        return this.daJ.dan * 1000;
    }

    public int axl() {
        if (this.daJ == null || this.daJ.dap == null) {
            return -1;
        }
        return this.daJ.dap.dar;
    }

    public int getPosition() {
        int g = this.daJ != null ? com.baidu.adp.lib.g.b.g(this.daJ.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public String axm() {
        if (this.daJ == null || this.daJ.dap == null) {
            return null;
        }
        return this.daJ.dap.pop_window_text;
    }

    public com.baidu.tbadk.core.data.b axn() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.daJ != null) {
            bVar.TW = this.daJ.id;
            bVar.TX = this.daJ.name;
            bVar.TY = this.daJ.dal;
            bVar.TZ = this.daJ.url;
            bVar.Ua = this.daJ.apk_url;
            bVar.Ub = this.daJ.apk_name;
            bVar.Uc = this.daJ.pos_name.trim();
            bVar.Ud = this.daJ.first_name;
            bVar.Ue = this.daJ.second_name;
            bVar.Uf = this.daJ.Uf;
            bVar.abtest = this.daJ.abtest;
            bVar.Ug = this.daJ.dam;
            bVar.userId = this.daJ.user_id;
            bVar.Uh = this.daJ.verify;
            bVar.price = this.daJ.price;
            bVar.Ui = this.daJ.ext_info;
            bVar.Uj = this.daJ.dan * 1000;
            if (this.daJ.dap != null) {
                bVar.Uk.Uq = this.daJ.dap.pop_window_text;
                bVar.Uk.Um = this.daJ.dap.id;
                bVar.Uk.Up = this.daJ.dap.thread_pic;
                bVar.Uk.Ur = this.daJ.dap.dar;
                bVar.Uk.Un = this.daJ.dap.thread_title;
                bVar.Uk.userName = this.daJ.dap.user_name;
                bVar.Uk.userPortrait = this.daJ.dap.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.o, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (axl() == 2) {
            return com.baidu.tbadk.core.data.b.TQ;
        }
        if (axl() == 6) {
            return com.baidu.tbadk.core.data.b.TR;
        }
        return com.baidu.tbadk.core.data.b.TP;
    }
}
