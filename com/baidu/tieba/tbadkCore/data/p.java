package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class p extends q {
    public String bZP;
    public String btl;
    private e fsx;
    public boolean fsy = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fsx = new e(app);
    }

    public e biS() {
        return this.fsx;
    }

    public String biT() {
        return this.fsx == null ? "" : this.fsx.id;
    }

    public boolean isApp() {
        if (this.fsx == null) {
            return false;
        }
        return this.fsx.ph();
    }

    public int biU() {
        if (this.fsx == null || this.fsx.frT == null) {
            return -1;
        }
        return this.fsx.frT.frV;
    }

    public int getPosition() {
        int g = this.fsx != null ? com.baidu.adp.lib.h.b.g(this.fsx.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b biV() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.fsx != null) {
            bVar.OY = this.fsx.id;
            bVar.OZ = this.fsx.name;
            bVar.Pa = this.fsx.frP;
            bVar.adUrl = this.fsx.url;
            bVar.Pd = this.fsx.Pd;
            bVar.Pc = this.fsx.apk_url;
            bVar.Pe = this.fsx.apk_name;
            bVar.Pf = this.fsx.pos_name.trim();
            bVar.Pg = this.fsx.first_name;
            bVar.Ph = this.fsx.second_name;
            bVar.Pi = this.fsx.Pi;
            bVar.abtest = this.fsx.abtest;
            bVar.Pj = this.fsx.frQ;
            bVar.userId = this.fsx.user_id;
            bVar.Pk = this.fsx.verify;
            bVar.price = this.fsx.price;
            bVar.Pl = this.fsx.ext_info;
            bVar.Pm = this.fsx.frR * 1000;
            if (this.fsx.frT != null) {
                bVar.Pn.Pv = this.fsx.frT.pop_window_text;
                bVar.Pn.Pq = this.fsx.frT.id;
                bVar.Pn.Pu = this.fsx.frT.thread_pic;
                bVar.Pn.Pw = this.fsx.frT.frV;
                bVar.Pn.Ps = this.fsx.frT.thread_title;
                bVar.Pn.userName = this.fsx.frT.user_name;
                bVar.Pn.Pr = this.fsx.frT.user_portrait;
                bVar.Pn.HT = this.fsx.frT.HT;
                bVar.Pn.Pz = this.fsx.frT.Pz;
                if (this.fsx.frT.frW != null) {
                    bVar.Pn.PA = new ArrayList();
                    bVar.Pn.PA.addAll(this.fsx.frT.frW);
                }
                bVar.Pn.PD = this.fsx.frT.frX;
                bVar.Pn.PE = this.fsx.frT.PE;
                bVar.Pn.PF = this.fsx.frT.PF;
                bVar.Pn.PG = this.fsx.frT.PG;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (biU() == 2) {
            return com.baidu.tbadk.core.data.b.OR;
        }
        if (biU() == 6) {
            return com.baidu.tbadk.core.data.b.OS;
        }
        if (biU() == 7) {
            return com.baidu.tbadk.core.data.b.OT;
        }
        return null;
    }
}
