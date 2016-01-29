package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class q extends r implements o {
    private int Us;
    public String bnC;
    private d dWU;
    public boolean dWV = false;
    public String dWW;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.dWU = new d(app);
    }

    public d aMl() {
        return this.dWU;
    }

    public String aMm() {
        return this.dWU == null ? "" : this.dWU.id;
    }

    public void oh(int i) {
        this.Us = i;
    }

    public boolean rM() {
        if (this.dWU == null) {
            return false;
        }
        return this.dWU.rM();
    }

    public boolean isApp() {
        if (this.dWU == null) {
            return false;
        }
        return this.dWU.rN();
    }

    public boolean aMn() {
        if (this.dWU == null) {
            return false;
        }
        return this.dWU.rO();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.dWU == null) {
            return null;
        }
        return this.dWU.apk_name;
    }

    public String getDownloadUrl() {
        if (this.dWU == null) {
            return null;
        }
        return this.dWU.apk_url;
    }

    public String getAppName() {
        return this.dWU == null ? "" : StringUtils.isNull(this.dWU.name) ? this.dWU.dWs.user_name : this.dWU.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aMh() {
        String str = (this.dWU == null || this.dWU.dWs == null) ? null : this.dWU.dWs.user_name;
        return StringUtils.isNull(str) ? "" : str;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aMi() {
        if (this.dWU == null || this.dWU.dWs == null) {
            return null;
        }
        return this.dWU.dWs.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public String aMj() {
        if (this.dWU == null || this.dWU.dWs == null) {
            return null;
        }
        return this.dWU.dWs.thread_title;
    }

    public String aMo() {
        if (this.dWU == null || this.dWU.dWs == null) {
            return null;
        }
        return this.dWU.dWs.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p
    public long aMk() {
        if (this.dWU == null) {
            return 0L;
        }
        return this.dWU.dWq * 1000;
    }

    public int aMp() {
        if (this.dWU == null || this.dWU.dWs == null) {
            return -1;
        }
        return this.dWU.dWs.dWu;
    }

    public int getPosition() {
        int g = this.dWU != null ? com.baidu.adp.lib.h.b.g(this.dWU.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c aMq() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.dWU != null) {
            cVar.Ut = this.dWU.id;
            cVar.Uu = this.dWU.name;
            cVar.Uv = this.dWU.dWo;
            cVar.Uw = this.dWU.url;
            cVar.Ux = this.dWU.apk_url;
            cVar.Uy = this.dWU.apk_name;
            cVar.Uz = this.dWU.pos_name.trim();
            cVar.UB = this.dWU.first_name;
            cVar.UC = this.dWU.second_name;
            cVar.UD = this.dWU.UD;
            cVar.abtest = this.dWU.abtest;
            cVar.UE = this.dWU.dWp;
            cVar.userId = this.dWU.user_id;
            cVar.UF = this.dWU.verify;
            cVar.price = this.dWU.price;
            cVar.UG = this.dWU.ext_info;
            cVar.UH = this.dWU.dWq * 1000;
            if (this.dWU.dWs != null) {
                cVar.UI.UT = this.dWU.dWs.pop_window_text;
                cVar.UI.UO = this.dWU.dWs.id;
                cVar.UI.US = this.dWU.dWs.thread_pic;
                cVar.UI.UU = this.dWU.dWs.dWu;
                cVar.UI.UQ = this.dWU.dWs.thread_title;
                cVar.UI.userName = this.dWU.dWs.user_name;
                cVar.UI.userPortrait = this.dWU.dWs.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.r, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        if (aMp() == 2) {
            return com.baidu.tbadk.core.data.c.Un;
        }
        if (aMp() == 6) {
            return com.baidu.tbadk.core.data.c.Uo;
        }
        return com.baidu.tbadk.core.data.c.Um;
    }
}
