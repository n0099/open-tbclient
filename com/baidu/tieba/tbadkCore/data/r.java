package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class r extends s implements p {
    private int MM;
    public String brg;
    private e esN;
    public boolean esO = false;
    public String esP;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.esN = new e(app);
    }

    public e aTN() {
        return this.esN;
    }

    public String aTO() {
        return this.esN == null ? "" : this.esN.id;
    }

    public void pl(int i) {
        this.MM = i;
    }

    public boolean oF() {
        if (this.esN == null) {
            return false;
        }
        return this.esN.oF();
    }

    public boolean isApp() {
        if (this.esN == null) {
            return false;
        }
        return this.esN.oG();
    }

    public boolean aTP() {
        if (this.esN == null) {
            return false;
        }
        return this.esN.oH();
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public String getPkgName() {
        if (this.esN == null) {
            return null;
        }
        return this.esN.apk_name;
    }

    public String getDownloadUrl() {
        if (this.esN == null) {
            return null;
        }
        return this.esN.apk_url;
    }

    public String getAppName() {
        return this.esN == null ? "" : StringUtils.isNull(this.esN.name) ? this.esN.esk.user_name : this.esN.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aTK() {
        String str = (this.esN == null || this.esN.esk == null) ? null : this.esN.esk.user_name;
        return StringUtils.isNull(str) ? "" : str;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aTL() {
        if (this.esN == null || this.esN.esk == null) {
            return null;
        }
        return this.esN.esk.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String aTM() {
        if (this.esN == null || this.esN.esk == null) {
            return null;
        }
        return this.esN.esk.thread_title;
    }

    public String aTQ() {
        if (this.esN == null || this.esN.esk == null) {
            return null;
        }
        return this.esN.esk.thread_pic;
    }

    public int aTR() {
        if (this.esN == null || this.esN.esk == null) {
            return -1;
        }
        return this.esN.esk.esm;
    }

    public int getPosition() {
        int g = this.esN != null ? com.baidu.adp.lib.h.b.g(this.esN.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c aTS() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.esN != null) {
            cVar.MN = this.esN.id;
            cVar.MO = this.esN.name;
            cVar.MP = this.esN.esg;
            cVar.MQ = this.esN.url;
            cVar.MR = this.esN.apk_url;
            cVar.MS = this.esN.apk_name;
            cVar.MT = this.esN.pos_name.trim();
            cVar.MU = this.esN.first_name;
            cVar.MV = this.esN.second_name;
            cVar.MW = this.esN.MW;
            cVar.abtest = this.esN.abtest;
            cVar.MX = this.esN.esh;
            cVar.userId = this.esN.user_id;
            cVar.MY = this.esN.verify;
            cVar.price = this.esN.price;
            cVar.MZ = this.esN.ext_info;
            cVar.Na = this.esN.esi * 1000;
            if (this.esN.esk != null) {
                cVar.Nb.Nl = this.esN.esk.pop_window_text;
                cVar.Nb.Nh = this.esN.esk.id;
                cVar.Nb.Nk = this.esN.esk.thread_pic;
                cVar.Nb.Nm = this.esN.esk.esm;
                cVar.Nb.Ni = this.esN.esk.thread_title;
                cVar.Nb.userName = this.esN.esk.user_name;
                cVar.Nb.userPortrait = this.esN.esk.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (aTR() == 2) {
            return com.baidu.tbadk.core.data.c.MH;
        }
        if (aTR() == 6) {
            return com.baidu.tbadk.core.data.c.MI;
        }
        return com.baidu.tbadk.core.data.c.MG;
    }
}
