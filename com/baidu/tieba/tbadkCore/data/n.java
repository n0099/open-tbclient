package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends o implements l {
    private int Ul;
    public String bgO;
    private d dzv;
    public boolean dzw = false;
    public String dzx;
    public int pageNumber;
    public long threadId;

    public void b(App app) {
        this.dzv = new d(app);
    }

    public d aCS() {
        return this.dzv;
    }

    public String aCT() {
        return this.dzv == null ? "" : this.dzv.id;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public void ja(int i) {
        this.Ul = i;
    }

    public boolean rB() {
        if (this.dzv == null) {
            return false;
        }
        return this.dzv.rB();
    }

    public boolean isApp() {
        if (this.dzv == null) {
            return false;
        }
        return this.dzv.rC();
    }

    public boolean aCU() {
        if (this.dzv == null) {
            return false;
        }
        return this.dzv.rD();
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getPkgName() {
        if (this.dzv == null) {
            return null;
        }
        return this.dzv.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getDownloadUrl() {
        if (this.dzv == null) {
            return null;
        }
        return this.dzv.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getAppName() {
        return this.dzv == null ? "" : StringUtils.isNull(this.dzv.name) ? this.dzv.dzd.user_name : this.dzv.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public String aCO() {
        if (this.dzv == null || this.dzv.dzd == null) {
            return null;
        }
        return this.dzv.dzd.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public String aCP() {
        if (this.dzv == null || this.dzv.dzd == null) {
            return null;
        }
        return this.dzv.dzd.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public String aCQ() {
        if (this.dzv == null || this.dzv.dzd == null) {
            return null;
        }
        return this.dzv.dzd.thread_title;
    }

    public String aCV() {
        if (this.dzv == null || this.dzv.dzd == null) {
            return null;
        }
        return this.dzv.dzd.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.m
    public long aCR() {
        if (this.dzv == null) {
            return 0L;
        }
        return this.dzv.dzb * 1000;
    }

    public int aCW() {
        if (this.dzv == null || this.dzv.dzd == null) {
            return -1;
        }
        return this.dzv.dzd.dzf;
    }

    public int getPosition() {
        int g = this.dzv != null ? com.baidu.adp.lib.h.b.g(this.dzv.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b aCX() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.dzv != null) {
            bVar.Um = this.dzv.id;
            bVar.Un = this.dzv.name;
            bVar.Uo = this.dzv.dyZ;
            bVar.Up = this.dzv.url;
            bVar.Uq = this.dzv.apk_url;
            bVar.Ur = this.dzv.apk_name;
            bVar.Us = this.dzv.pos_name.trim();
            bVar.Ut = this.dzv.first_name;
            bVar.Uu = this.dzv.second_name;
            bVar.Uv = this.dzv.Uv;
            bVar.abtest = this.dzv.abtest;
            bVar.Uw = this.dzv.dza;
            bVar.userId = this.dzv.user_id;
            bVar.Ux = this.dzv.verify;
            bVar.price = this.dzv.price;
            bVar.Uy = this.dzv.ext_info;
            bVar.Uz = this.dzv.dzb * 1000;
            if (this.dzv.dzd != null) {
                bVar.UA.UG = this.dzv.dzd.pop_window_text;
                bVar.UA.UC = this.dzv.dzd.id;
                bVar.UA.UF = this.dzv.dzd.thread_pic;
                bVar.UA.UH = this.dzv.dzd.dzf;
                bVar.UA.UD = this.dzv.dzd.thread_title;
                bVar.UA.userName = this.dzv.dzd.user_name;
                bVar.UA.userPortrait = this.dzv.dzd.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.o, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (aCW() == 2) {
            return com.baidu.tbadk.core.data.b.Ug;
        }
        if (aCW() == 6) {
            return com.baidu.tbadk.core.data.b.Uh;
        }
        return com.baidu.tbadk.core.data.b.Uf;
    }
}
