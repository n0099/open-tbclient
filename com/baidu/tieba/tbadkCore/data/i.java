package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class i extends j implements g {
    private int Pr;
    public String aPM;
    private a csc;
    public boolean csd = false;
    public String cse;
    public long threadId;

    public void b(App app) {
        this.csc = new a(app);
    }

    public a aos() {
        return this.csc;
    }

    public String aot() {
        return this.csc == null ? "" : this.csc.id;
    }

    public int aou() {
        return this.Pr;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public void iJ(int i) {
        this.Pr = i;
    }

    public boolean qu() {
        if (this.csc == null) {
            return false;
        }
        return this.csc.qu();
    }

    public boolean aov() {
        if (this.csc == null) {
            return false;
        }
        return this.csc.qv();
    }

    public boolean aow() {
        if (this.csc == null) {
            return false;
        }
        return this.csc.qw();
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getPkgName() {
        if (this.csc == null) {
            return null;
        }
        return this.csc.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getDownloadUrl() {
        if (this.csc == null) {
            return null;
        }
        return this.csc.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getAppName() {
        return this.csc == null ? "" : this.csc.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aon() {
        if (this.csc == null || this.csc.crV == null) {
            return null;
        }
        return this.csc.crV.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aoo() {
        if (this.csc == null || this.csc.crV == null) {
            return null;
        }
        return this.csc.crV.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aop() {
        if (this.csc == null || this.csc.crV == null) {
            return null;
        }
        return this.csc.crV.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public String aoq() {
        if (this.csc == null || this.csc.crV == null) {
            return null;
        }
        return this.csc.crV.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.data.h
    public long aor() {
        if (this.csc == null) {
            return 0L;
        }
        return this.csc.crT * 1000;
    }

    public int getShowType() {
        if (this.csc == null || this.csc.crV == null) {
            return -1;
        }
        return this.csc.crV.crW;
    }

    public int getPosition() {
        int i = this.csc != null ? com.baidu.adp.lib.g.c.toInt(this.csc.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String aox() {
        if (this.csc == null || this.csc.crV == null) {
            return null;
        }
        return this.csc.crV.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c aoy() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.csc != null) {
            cVar.Ps = this.csc.id;
            cVar.Pt = this.csc.name;
            cVar.Pu = this.csc.crR;
            cVar.Pv = this.csc.url;
            cVar.Pw = this.csc.apk_url;
            cVar.Px = this.csc.apk_name;
            try {
                cVar.Py = Integer.parseInt(this.csc.pos_name.trim());
            } catch (Exception e) {
                cVar.Py = -1;
            }
            cVar.Pz = this.csc.first_name;
            cVar.PA = this.csc.second_name;
            cVar.PC = this.csc.PC;
            cVar.abtest = this.csc.abtest;
            cVar.PD = this.csc.crS;
            cVar.userId = this.csc.user_id;
            cVar.PE = this.csc.verify;
            cVar.price = this.csc.price;
            cVar.PF = this.csc.ext_info;
            cVar.PG = this.csc.crT * 1000;
            if (this.csc.crV != null) {
                cVar.PH.PN = this.csc.crV.pop_window_text;
                cVar.PH.PK = this.csc.crV.id;
                cVar.PH.PM = this.csc.crV.thread_pic;
                cVar.PH.PO = this.csc.crV.crW;
                cVar.PH.PL = this.csc.crV.thread_title;
                cVar.PH.userName = this.csc.crV.user_name;
                cVar.PH.userPortrait = this.csc.crV.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.j, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return getShowType() == 2 ? com.baidu.tbadk.core.data.c.Pn : com.baidu.tbadk.core.data.c.Pm;
    }
}
