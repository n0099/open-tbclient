package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class r extends s implements p {
    private int RY;
    public String bsz;
    private e epD;
    public boolean epE = false;
    public String epF;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.epD = new e(app);
    }

    public e aTh() {
        return this.epD;
    }

    public String aTi() {
        return this.epD == null ? "" : this.epD.id;
    }

    public void pq(int i) {
        this.RY = i;
    }

    public boolean rk() {
        if (this.epD == null) {
            return false;
        }
        return this.epD.rk();
    }

    public boolean isApp() {
        if (this.epD == null) {
            return false;
        }
        return this.epD.rl();
    }

    public boolean aTj() {
        if (this.epD == null) {
            return false;
        }
        return this.epD.rm();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.epD == null) {
            return null;
        }
        return this.epD.apk_name;
    }

    public String getDownloadUrl() {
        if (this.epD == null) {
            return null;
        }
        return this.epD.apk_url;
    }

    public String getAppName() {
        return this.epD == null ? "" : StringUtils.isNull(this.epD.name) ? this.epD.epa.user_name : this.epD.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aTd() {
        String str = (this.epD == null || this.epD.epa == null) ? null : this.epD.epa.user_name;
        return StringUtils.isNull(str) ? "" : str;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aTe() {
        if (this.epD == null || this.epD.epa == null) {
            return null;
        }
        return this.epD.epa.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aTf() {
        if (this.epD == null || this.epD.epa == null) {
            return null;
        }
        return this.epD.epa.thread_title;
    }

    public String aTk() {
        if (this.epD == null || this.epD.epa == null) {
            return null;
        }
        return this.epD.epa.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public long aTg() {
        if (this.epD == null) {
            return 0L;
        }
        return this.epD.eoY * 1000;
    }

    public int aTl() {
        if (this.epD == null || this.epD.epa == null) {
            return -1;
        }
        return this.epD.epa.epc;
    }

    public int getPosition() {
        int g = this.epD != null ? com.baidu.adp.lib.h.b.g(this.epD.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c aTm() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.epD != null) {
            cVar.RZ = this.epD.id;
            cVar.Sa = this.epD.name;
            cVar.Sb = this.epD.eoW;
            cVar.Sc = this.epD.url;
            cVar.Sd = this.epD.apk_url;
            cVar.Se = this.epD.apk_name;
            cVar.Sf = this.epD.pos_name.trim();
            cVar.Sg = this.epD.first_name;
            cVar.Sh = this.epD.second_name;
            cVar.Si = this.epD.Si;
            cVar.abtest = this.epD.abtest;
            cVar.Sj = this.epD.eoX;
            cVar.userId = this.epD.user_id;
            cVar.Sk = this.epD.verify;
            cVar.price = this.epD.price;
            cVar.Sl = this.epD.ext_info;
            cVar.Sm = this.epD.eoY * 1000;
            if (this.epD.epa != null) {
                cVar.Sn.Sx = this.epD.epa.pop_window_text;
                cVar.Sn.St = this.epD.epa.id;
                cVar.Sn.Sw = this.epD.epa.thread_pic;
                cVar.Sn.Sy = this.epD.epa.epc;
                cVar.Sn.Su = this.epD.epa.thread_title;
                cVar.Sn.userName = this.epD.epa.user_name;
                cVar.Sn.userPortrait = this.epD.epa.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (aTl() == 2) {
            return com.baidu.tbadk.core.data.c.RT;
        }
        if (aTl() == 6) {
            return com.baidu.tbadk.core.data.c.RU;
        }
        return com.baidu.tbadk.core.data.c.RS;
    }
}
