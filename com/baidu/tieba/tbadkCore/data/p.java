package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class p extends q {
    public String PA;
    public String PC;
    public String bIQ;
    private e fgu;
    public boolean fgv = false;
    public String forumId;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fgu = new e(app);
    }

    public e bfO() {
        return this.fgu;
    }

    public ICardInfo bfP() {
        if (this.fgu == null) {
            return null;
        }
        return this.fgu.Py;
    }

    public String bfQ() {
        return this.fgu == null ? "" : this.fgu.id;
    }

    public boolean isApp() {
        if (this.fgu == null) {
            return false;
        }
        return this.fgu.pk();
    }

    public int bfR() {
        if (this.fgu == null || this.fgu.ffS == null) {
            return -1;
        }
        return this.fgu.ffS.ffT;
    }

    public int getPosition() {
        int g = this.fgu != null ? com.baidu.adp.lib.h.b.g(this.fgu.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c bfS() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.fgu != null) {
            cVar.PF = this.fgu;
            cVar.Pj = this.fgu.id;
            cVar.Pk = this.fgu.name;
            cVar.Pl = this.fgu.ffO;
            cVar.Pm = this.fgu.url;
            cVar.Po = this.fgu.Po;
            cVar.Pn = this.fgu.apk_url;
            cVar.Pp = this.fgu.apk_name;
            cVar.adPosition = this.fgu.pos_name.trim();
            cVar.Pq = this.fgu.first_name;
            cVar.Pr = this.fgu.second_name;
            cVar.Ps = this.fgu.Ps;
            cVar.abtest = this.fgu.abtest;
            cVar.Pt = this.fgu.ffP;
            cVar.userId = this.fgu.user_id;
            cVar.Pu = this.fgu.verify;
            cVar.price = this.fgu.price;
            cVar.extensionInfo = this.fgu.ext_info;
            cVar.Pv = this.fgu.ffQ * 1000;
            cVar.Py = this.fgu.Py;
            if (this.fgu.ffS != null) {
                cVar.Pw.PK = this.fgu.ffS.pop_window_text;
                cVar.Pw.PG = this.fgu.ffS.id;
                cVar.Pw.PJ = this.fgu.ffS.thread_pic;
                cVar.Pw.PL = this.fgu.ffS.ffT;
                cVar.Pw.PH = this.fgu.ffS.thread_title;
                cVar.Pw.PI = this.fgu.ffS.thread_content;
                cVar.Pw.userName = this.fgu.ffS.user_name;
                cVar.Pw.userPortrait = this.fgu.ffS.user_portrait;
                cVar.Pw.buttonText = this.fgu.ffS.button_text;
                cVar.Pw.PO = this.fgu.ffS.button_url;
                if (this.fgu.ffS.ffU != null) {
                    cVar.Pw.PP = new ArrayList();
                    cVar.Pw.PP.addAll(this.fgu.ffS.ffU);
                }
                cVar.Pw.PQ = this.fgu.ffS.video_info;
                cVar.Pw.PR = this.fgu.ffS.tag_name;
                cVar.Pw.adSource = this.fgu.ffS.ad_source;
                cVar.Pw.PS = this.fgu.ffS.tag_name_url;
                cVar.Pw.PT = this.fgu.ffS.PT;
            }
            cVar.OO = "PB";
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bfP() != null) {
            return com.baidu.tbadk.core.data.c.Ph;
        }
        if (bfR() == 1001) {
            return com.baidu.tbadk.core.data.c.OZ;
        }
        if (bfR() == 2) {
            return com.baidu.tbadk.core.data.c.Pa;
        }
        if (bfR() == 6) {
            return com.baidu.tbadk.core.data.c.Pc;
        }
        if (bfR() == 7) {
            return com.baidu.tbadk.core.data.c.Pd;
        }
        return null;
    }
}
