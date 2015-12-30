package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class q extends r implements o {
    private int UL;
    public String bkF;
    private d dGY;
    public boolean dGZ = false;
    public String dHa;
    public int pageNumber;
    public long threadId;

    public void b(App app) {
        this.dGY = new d(app);
    }

    public d aFf() {
        return this.dGY;
    }

    public String aFg() {
        return this.dGY == null ? "" : this.dGY.id;
    }

    public void mW(int i) {
        this.UL = i;
    }

    public boolean rk() {
        if (this.dGY == null) {
            return false;
        }
        return this.dGY.rk();
    }

    public boolean isApp() {
        if (this.dGY == null) {
            return false;
        }
        return this.dGY.rl();
    }

    public boolean aFh() {
        if (this.dGY == null) {
            return false;
        }
        return this.dGY.rm();
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String getPkgName() {
        if (this.dGY == null) {
            return null;
        }
        return this.dGY.apk_name;
    }

    public String getDownloadUrl() {
        if (this.dGY == null) {
            return null;
        }
        return this.dGY.apk_url;
    }

    public String getAppName() {
        return this.dGY == null ? "" : StringUtils.isNull(this.dGY.name) ? this.dGY.dGx.user_name : this.dGY.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aFb() {
        String str = (this.dGY == null || this.dGY.dGx == null) ? null : this.dGY.dGx.user_name;
        return StringUtils.isNull(str) ? "" : str;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aFc() {
        if (this.dGY == null || this.dGY.dGx == null) {
            return null;
        }
        return this.dGY.dGx.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aFd() {
        if (this.dGY == null || this.dGY.dGx == null) {
            return null;
        }
        return this.dGY.dGx.thread_title;
    }

    public String aFi() {
        if (this.dGY == null || this.dGY.dGx == null) {
            return null;
        }
        return this.dGY.dGx.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public long aFe() {
        if (this.dGY == null) {
            return 0L;
        }
        return this.dGY.dGv * 1000;
    }

    public int aFj() {
        if (this.dGY == null || this.dGY.dGx == null) {
            return -1;
        }
        return this.dGY.dGx.dGz;
    }

    public int getPosition() {
        int g = this.dGY != null ? com.baidu.adp.lib.h.b.g(this.dGY.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b aFk() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.dGY != null) {
            bVar.UM = this.dGY.id;
            bVar.UN = this.dGY.name;
            bVar.UO = this.dGY.dGt;
            bVar.UQ = this.dGY.url;
            bVar.UR = this.dGY.apk_url;
            bVar.US = this.dGY.apk_name;
            bVar.UT = this.dGY.pos_name.trim();
            bVar.UU = this.dGY.first_name;
            bVar.UV = this.dGY.second_name;
            bVar.UW = this.dGY.UW;
            bVar.abtest = this.dGY.abtest;
            bVar.UX = this.dGY.dGu;
            bVar.userId = this.dGY.user_id;
            bVar.UY = this.dGY.verify;
            bVar.price = this.dGY.price;
            bVar.UZ = this.dGY.ext_info;
            bVar.Va = this.dGY.dGv * 1000;
            if (this.dGY.dGx != null) {
                bVar.Vb.Vh = this.dGY.dGx.pop_window_text;
                bVar.Vb.Vd = this.dGY.dGx.id;
                bVar.Vb.Vg = this.dGY.dGx.thread_pic;
                bVar.Vb.Vi = this.dGY.dGx.dGz;
                bVar.Vb.Ve = this.dGY.dGx.thread_title;
                bVar.Vb.userName = this.dGY.dGx.user_name;
                bVar.Vb.userPortrait = this.dGY.dGx.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.r, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (aFj() == 2) {
            return com.baidu.tbadk.core.data.b.UG;
        }
        if (aFj() == 6) {
            return com.baidu.tbadk.core.data.b.UH;
        }
        return com.baidu.tbadk.core.data.b.UF;
    }
}
