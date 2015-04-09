package com.baidu.tieba.tbadkCore.c;

import com.baidu.adp.BdUniqueId;
import tbclient.App;
/* loaded from: classes.dex */
public class i extends j implements g {
    private int OX;
    public String aNz;
    private a cod;
    public boolean coe = false;
    public String cof;
    public long threadId;

    public void b(App app) {
        this.cod = new a(app);
    }

    public a amF() {
        return this.cod;
    }

    public String amG() {
        return this.cod == null ? "" : this.cod.id;
    }

    public int amH() {
        return this.OX;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public void in(int i) {
        this.OX = i;
    }

    public boolean pO() {
        if (this.cod == null) {
            return false;
        }
        return this.cod.pO();
    }

    public boolean amI() {
        if (this.cod == null) {
            return false;
        }
        return this.cod.pP();
    }

    public boolean amJ() {
        if (this.cod == null) {
            return false;
        }
        return this.cod.pQ();
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getPkgName() {
        if (this.cod == null) {
            return null;
        }
        return this.cod.apk_name;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getDownloadUrl() {
        if (this.cod == null) {
            return null;
        }
        return this.cod.apk_url;
    }

    @Override // com.baidu.tieba.tbadkCore.y
    public String getAppName() {
        return this.cod == null ? "" : this.cod.name;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amA() {
        if (this.cod == null || this.cod.cnW == null) {
            return null;
        }
        return this.cod.cnW.user_name;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amB() {
        if (this.cod == null || this.cod.cnW == null) {
            return null;
        }
        return this.cod.cnW.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amC() {
        if (this.cod == null || this.cod.cnW == null) {
            return null;
        }
        return this.cod.cnW.thread_title;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public String amD() {
        if (this.cod == null || this.cod.cnW == null) {
            return null;
        }
        return this.cod.cnW.thread_pic;
    }

    @Override // com.baidu.tieba.tbadkCore.c.h
    public long amE() {
        if (this.cod == null) {
            return 0L;
        }
        return this.cod.cnU * 1000;
    }

    public int getShowType() {
        if (this.cod == null || this.cod.cnW == null) {
            return -1;
        }
        return this.cod.cnW.cnX;
    }

    public int getPosition() {
        int i = this.cod != null ? com.baidu.adp.lib.g.c.toInt(this.cod.pos_name, 0) : 0;
        if (i < 2 || i > 30) {
            return 7;
        }
        return i;
    }

    public String amK() {
        if (this.cod == null || this.cod.cnW == null) {
            return null;
        }
        return this.cod.cnW.pop_window_text;
    }

    public com.baidu.tbadk.core.data.c amL() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.cod != null) {
            cVar.OY = this.cod.id;
            cVar.OZ = this.cod.name;
            cVar.Pa = this.cod.cnS;
            cVar.Pb = this.cod.url;
            cVar.Pc = this.cod.apk_url;
            cVar.Pd = this.cod.apk_name;
            try {
                cVar.Pe = Integer.parseInt(this.cod.pos_name.trim());
            } catch (Exception e) {
                cVar.Pe = -1;
            }
            cVar.Pf = this.cod.first_name;
            cVar.Pg = this.cod.second_name;
            cVar.Ph = this.cod.Ph;
            cVar.abtest = this.cod.abtest;
            cVar.Pi = this.cod.cnT;
            cVar.userId = this.cod.user_id;
            cVar.Pj = this.cod.verify;
            cVar.price = this.cod.price;
            cVar.Pk = this.cod.ext_info;
            cVar.Pl = this.cod.cnU * 1000;
            if (this.cod.cnW != null) {
                cVar.Pm.Pr = this.cod.cnW.pop_window_text;
                cVar.Pm.Po = this.cod.cnW.id;
                cVar.Pm.Pq = this.cod.cnW.thread_pic;
                cVar.Pm.Ps = this.cod.cnW.cnX;
                cVar.Pm.Pp = this.cod.cnW.thread_title;
                cVar.Pm.userName = this.cod.cnW.user_name;
                cVar.Pm.userPortrait = this.cod.cnW.user_portrait;
            }
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.c.j, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return getShowType() == 2 ? com.baidu.tbadk.core.data.c.OS : com.baidu.tbadk.core.data.c.OR;
    }
}
