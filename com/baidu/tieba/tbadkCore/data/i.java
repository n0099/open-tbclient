package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class i extends j implements g {
    private int Pr;
    public String aPL;
    private a csb;
    public boolean csc = false;
    public String csd;
    public long threadId;

    public void b(App app) {
        this.csb = new a(app);
    }

    public a aor() {
        return this.csb;
    }

    public String aos() {
        return this.csb == null ? "" : this.csb.id;
    }

    public int aot() {
        return this.Pr;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public void iJ(int i) {
        this.Pr = i;
    }

    public boolean qu() {
        if (this.csb == null) {
            return false;
        }
        return this.csb.qu();
    }

    public boolean aou() {
        if (this.csb == null) {
            return false;
        }
        return this.csb.qv();
    }

    public boolean aov() {
        if (this.csb == null) {
            return false;
        }
        return this.csb.qw();
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getPkgName() {
        if (this.csb == null) {
            return null;
        }
        return this.csb.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getDownloadUrl() {
        if (this.csb == null) {
            return null;
        }
        return this.csb.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getAppName() {
        return this.csb == null ? "" : this.csb.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aom() {
        if (this.csb == null || this.csb.crU == null) {
            return null;
        }
        return this.csb.crU.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aon() {
        if (this.csb == null || this.csb.crU == null) {
            return null;
        }
        return this.csb.crU.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aoo() {
        if (this.csb == null || this.csb.crU == null) {
            return null;
        }
        return this.csb.crU.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aop() {
        if (this.csb == null || this.csb.crU == null) {
            return null;
        }
        return this.csb.crU.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public long aoq() {
        if (this.csb == null) {
            return 0L;
        }
        return this.csb.crS * 1000;
    }

    public int getShowType() {
        if (this.csb == null || this.csb.crU == null) {
            return -1;
        }
        return this.csb.crU.crV;
    }

    public int getPosition() {
        int i = this.csb != null ? com.baidu.adp.lib.g.c.toInt(this.csb.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String aow() {
        if (this.csb == null || this.csb.crU == null) {
            return null;
        }
        return this.csb.crU.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c aox() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.csb != null) {
            cVar.Ps = this.csb.id;
            cVar.Pt = this.csb.name;
            cVar.Pu = this.csb.crQ;
            cVar.Pv = this.csb.url;
            cVar.Pw = this.csb.apk_url;
            cVar.Px = this.csb.apk_name;
            try {
                cVar.Py = Integer.parseInt(this.csb.pos_name.trim());
            } catch (Exception e) {
                cVar.Py = -1;
            }
            cVar.Pz = this.csb.first_name;
            cVar.PA = this.csb.second_name;
            cVar.PC = this.csb.PC;
            cVar.abtest = this.csb.abtest;
            cVar.PD = this.csb.crR;
            cVar.userId = this.csb.user_id;
            cVar.PE = this.csb.verify;
            cVar.price = this.csb.price;
            cVar.PF = this.csb.ext_info;
            cVar.PG = this.csb.crS * 1000;
            if (this.csb.crU != null) {
                cVar.PH.PN = this.csb.crU.pop_window_text;
                cVar.PH.PK = this.csb.crU.id;
                cVar.PH.PM = this.csb.crU.thread_pic;
                cVar.PH.PO = this.csb.crU.crV;
                cVar.PH.PL = this.csb.crU.thread_title;
                cVar.PH.userName = this.csb.crU.user_name;
                cVar.PH.userPortrait = this.csb.crU.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.j, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return getShowType() == 2 ? com.baidu.tbadk.core.data.c.Pn : com.baidu.tbadk.core.data.c.Pm;
    }
}
