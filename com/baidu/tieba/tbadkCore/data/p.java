package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class p extends q {
    public String PE;
    public String PF;
    public String cdj;
    private e fCp;
    public boolean fCq = false;
    public String forumId;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fCp = new e(app);
    }

    public e blZ() {
        return this.fCp;
    }

    public ICardInfo bma() {
        if (this.fCp == null) {
            return null;
        }
        return this.fCp.PC;
    }

    public String bmb() {
        return this.fCp == null ? "" : this.fCp.id;
    }

    public boolean isApp() {
        if (this.fCp == null) {
            return false;
        }
        return this.fCp.pk();
    }

    public int bmc() {
        if (this.fCp == null || this.fCp.fBN == null) {
            return -1;
        }
        return this.fCp.fBN.fBO;
    }

    public int getPosition() {
        int g = this.fCp != null ? com.baidu.adp.lib.h.b.g(this.fCp.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c bmd() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.fCp != null) {
            cVar.PI = this.fCp;
            cVar.Pm = this.fCp.id;
            cVar.Pn = this.fCp.name;
            cVar.Po = this.fCp.fBJ;
            cVar.Pp = this.fCp.url;
            cVar.Pr = this.fCp.Pr;
            cVar.Pq = this.fCp.apk_url;
            cVar.Ps = this.fCp.apk_name;
            cVar.adPosition = this.fCp.pos_name.trim();
            cVar.Pt = this.fCp.first_name;
            cVar.Pu = this.fCp.second_name;
            cVar.Pv = this.fCp.Pv;
            cVar.abtest = this.fCp.abtest;
            cVar.Pw = this.fCp.fBK;
            cVar.userId = this.fCp.user_id;
            cVar.Px = this.fCp.verify;
            cVar.price = this.fCp.price;
            cVar.extensionInfo = this.fCp.ext_info;
            cVar.Py = this.fCp.fBL * 1000;
            cVar.PC = this.fCp.PC;
            if (this.fCp.fBN != null) {
                cVar.Pz.PO = this.fCp.fBN.pop_window_text;
                cVar.Pz.PJ = this.fCp.fBN.id;
                cVar.Pz.PN = this.fCp.fBN.thread_pic;
                cVar.Pz.PP = this.fCp.fBN.fBO;
                cVar.Pz.PK = this.fCp.fBN.thread_title;
                cVar.Pz.PM = this.fCp.fBN.thread_content;
                cVar.Pz.userName = this.fCp.fBN.user_name;
                cVar.Pz.userPortrait = this.fCp.fBN.user_portrait;
                cVar.Pz.buttonText = this.fCp.fBN.button_text;
                cVar.Pz.PT = this.fCp.fBN.button_url;
                if (this.fCp.fBN.fBP != null) {
                    cVar.Pz.PU = new ArrayList();
                    cVar.Pz.PU.addAll(this.fCp.fBN.fBP);
                }
                cVar.Pz.PV = this.fCp.fBN.video_info;
                cVar.Pz.PW = this.fCp.fBN.tag_name;
                cVar.Pz.adSource = this.fCp.fBN.ad_source;
                cVar.Pz.PX = this.fCp.fBN.tag_name_url;
                cVar.Pz.PY = this.fCp.fBN.PY;
            }
            cVar.OS = "PB";
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bma() != null) {
            return com.baidu.tbadk.core.data.c.Pk;
        }
        if (bmc() == 1001) {
            return com.baidu.tbadk.core.data.c.Pd;
        }
        if (bmc() == 2) {
            return com.baidu.tbadk.core.data.c.Pe;
        }
        if (bmc() == 6) {
            return com.baidu.tbadk.core.data.c.Pf;
        }
        if (bmc() == 7) {
            return com.baidu.tbadk.core.data.c.Pg;
        }
        return null;
    }
}
