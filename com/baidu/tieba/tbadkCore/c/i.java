package com.baidu.tieba.tbadkCore.c;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class i extends j implements g {
    private int OV;
    public String aNi;
    private a cnN;
    public boolean cnO = false;
    public String cnP;
    public long threadId;

    public void b(App app) {
        this.cnN = new a(app);
    }

    public a amq() {
        return this.cnN;
    }

    public String amr() {
        return this.cnN == null ? "" : this.cnN.id;
    }

    public int ams() {
        return this.OV;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public void ik(int i) {
        this.OV = i;
    }

    public boolean pO() {
        if (this.cnN == null) {
            return false;
        }
        return this.cnN.pO();
    }

    public boolean amt() {
        if (this.cnN == null) {
            return false;
        }
        return this.cnN.pP();
    }

    public boolean amu() {
        if (this.cnN == null) {
            return false;
        }
        return this.cnN.pQ();
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getPkgName() {
        if (this.cnN == null) {
            return null;
        }
        return this.cnN.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getDownloadUrl() {
        if (this.cnN == null) {
            return null;
        }
        return this.cnN.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getAppName() {
        return this.cnN == null ? "" : this.cnN.name;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String aml() {
        if (this.cnN == null || this.cnN.cnG == null) {
            return null;
        }
        return this.cnN.cnG.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amm() {
        if (this.cnN == null || this.cnN.cnG == null) {
            return null;
        }
        return this.cnN.cnG.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amn() {
        if (this.cnN == null || this.cnN.cnG == null) {
            return null;
        }
        return this.cnN.cnG.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amo() {
        if (this.cnN == null || this.cnN.cnG == null) {
            return null;
        }
        return this.cnN.cnG.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public long amp() {
        if (this.cnN == null) {
            return 0L;
        }
        return this.cnN.cnE * 1000;
    }

    public int getShowType() {
        if (this.cnN == null || this.cnN.cnG == null) {
            return -1;
        }
        return this.cnN.cnG.cnH;
    }

    public int getPosition() {
        int i = this.cnN != null ? com.baidu.adp.lib.g.c.toInt(this.cnN.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String amv() {
        if (this.cnN == null || this.cnN.cnG == null) {
            return null;
        }
        return this.cnN.cnG.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c amw() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.cnN != null) {
            cVar.OW = this.cnN.id;
            cVar.OX = this.cnN.name;
            cVar.OY = this.cnN.cnC;
            cVar.OZ = this.cnN.url;
            cVar.Pa = this.cnN.apk_url;
            cVar.Pb = this.cnN.apk_name;
            try {
                cVar.Pc = Integer.parseInt(this.cnN.pos_name.trim());
            } catch (Exception e) {
                cVar.Pc = -1;
            }
            cVar.Pd = this.cnN.first_name;
            cVar.Pe = this.cnN.second_name;
            cVar.Pf = this.cnN.Pf;
            cVar.abtest = this.cnN.abtest;
            cVar.Pg = this.cnN.cnD;
            cVar.userId = this.cnN.user_id;
            cVar.Ph = this.cnN.verify;
            cVar.price = this.cnN.price;
            cVar.Pi = this.cnN.ext_info;
            cVar.Pj = this.cnN.cnE * 1000;
            if (this.cnN.cnG != null) {
                cVar.Pk.Pp = this.cnN.cnG.pop_window_text;
                cVar.Pk.Pm = this.cnN.cnG.id;
                cVar.Pk.Po = this.cnN.cnG.thread_pic;
                cVar.Pk.Pq = this.cnN.cnG.cnH;
                cVar.Pk.Pn = this.cnN.cnG.thread_title;
                cVar.Pk.userName = this.cnN.cnG.user_name;
                cVar.Pk.userPortrait = this.cnN.cnG.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c.j, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return getShowType() == 2 ? com.baidu.tbadk.core.data.c.OQ : com.baidu.tbadk.core.data.c.OP;
    }
}
