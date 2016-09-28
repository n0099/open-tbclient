package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class p extends q {
    public String bZM;
    public String btz;
    private e fvd;
    public boolean fve = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fvd = new e(app);
    }

    public e bjD() {
        return this.fvd;
    }

    public ICardInfo bjE() {
        if (this.fvd == null) {
            return null;
        }
        return this.fvd.Pp;
    }

    public String bjF() {
        return this.fvd == null ? "" : this.fvd.id;
    }

    public boolean isApp() {
        if (this.fvd == null) {
            return false;
        }
        return this.fvd.pi();
    }

    public int bjG() {
        if (this.fvd == null || this.fvd.fuA == null) {
            return -1;
        }
        return this.fvd.fuA.fuB;
    }

    public int getPosition() {
        int g = this.fvd != null ? com.baidu.adp.lib.h.b.g(this.fvd.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b bjH() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.fvd != null) {
            bVar.OZ = this.fvd.id;
            bVar.Pa = this.fvd.name;
            bVar.Pc = this.fvd.fuw;
            bVar.Pd = this.fvd.url;
            bVar.Pf = this.fvd.Pf;
            bVar.Pe = this.fvd.apk_url;
            bVar.Pg = this.fvd.apk_name;
            bVar.adPosition = this.fvd.pos_name.trim();
            bVar.Ph = this.fvd.first_name;
            bVar.Pi = this.fvd.second_name;
            bVar.Pj = this.fvd.Pj;
            bVar.abtest = this.fvd.abtest;
            bVar.Pk = this.fvd.fux;
            bVar.userId = this.fvd.user_id;
            bVar.Pl = this.fvd.verify;
            bVar.price = this.fvd.price;
            bVar.extensionInfo = this.fvd.ext_info;
            bVar.Pm = this.fvd.fuy * 1000;
            bVar.Pp = this.fvd.Pp;
            if (this.fvd.fuA != null) {
                bVar.Pn.Pu = this.fvd.fuA.pop_window_text;
                bVar.Pn.Pq = this.fvd.fuA.id;
                bVar.Pn.Pt = this.fvd.fuA.thread_pic;
                bVar.Pn.Pv = this.fvd.fuA.fuB;
                bVar.Pn.Pr = this.fvd.fuA.thread_title;
                bVar.Pn.Ps = this.fvd.fuA.threadContent;
                bVar.Pn.userName = this.fvd.fuA.user_name;
                bVar.Pn.userPortrait = this.fvd.fuA.user_portrait;
                bVar.Pn.buttonText = this.fvd.fuA.buttonText;
                bVar.Pn.Py = this.fvd.fuA.Py;
                if (this.fvd.fuA.fuC != null) {
                    bVar.Pn.Pz = new ArrayList();
                    bVar.Pn.Pz.addAll(this.fvd.fuA.fuC);
                }
                bVar.Pn.PA = this.fvd.fuA.fuD;
                bVar.Pn.PC = this.fvd.fuA.PC;
                bVar.Pn.adSource = this.fvd.fuA.adSource;
                bVar.Pn.PD = this.fvd.fuA.PD;
                bVar.Pn.PE = this.fvd.fuA.PE;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bjE() != null) {
            return com.baidu.tbadk.core.data.b.OX;
        }
        if (bjG() == 2) {
            return com.baidu.tbadk.core.data.b.OS;
        }
        if (bjG() == 6) {
            return com.baidu.tbadk.core.data.b.OT;
        }
        if (bjG() == 7) {
            return com.baidu.tbadk.core.data.b.OU;
        }
        return null;
    }
}
