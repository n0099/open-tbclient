package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class r extends s implements p {
    private int MD;
    public String bOx;
    public String bhU;
    private e fkE;
    public boolean fkF = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fkE = new e(app);
    }

    public e bfq() {
        return this.fkE;
    }

    public String bfr() {
        return this.fkE == null ? "" : this.fkE.id;
    }

    public void qW(int i) {
        this.MD = i;
    }

    public boolean ok() {
        if (this.fkE == null) {
            return false;
        }
        return this.fkE.ok();
    }

    public boolean isApp() {
        if (this.fkE == null) {
            return false;
        }
        return this.fkE.ol();
    }

    public boolean bfs() {
        if (this.fkE == null) {
            return false;
        }
        return this.fkE.om();
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String io() {
        if (this.fkE == null) {
            return null;
        }
        return this.fkE.apk_name;
    }

    public String getDownloadUrl() {
        if (this.fkE == null) {
            return null;
        }
        return this.fkE.apk_url;
    }

    public String getAppName() {
        return this.fkE == null ? "" : StringUtils.isNull(this.fkE.name) ? this.fkE.fka.user_name : this.fkE.name;
    }

    public String getUrl() {
        if (this.fkE == null) {
            return null;
        }
        return this.fkE.url;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String bfn() {
        String str = (this.fkE == null || this.fkE.fka == null) ? null : this.fkE.fka.user_name;
        return StringUtils.isNull(str) ? "" : str;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String bfo() {
        if (this.fkE == null || this.fkE.fka == null) {
            return null;
        }
        return this.fkE.fka.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String bfp() {
        if (this.fkE == null || this.fkE.fka == null) {
            return null;
        }
        return this.fkE.fka.thread_title;
    }

    public String bft() {
        if (this.fkE == null || this.fkE.fka == null) {
            return null;
        }
        return this.fkE.fka.thread_pic;
    }

    public int bfu() {
        if (this.fkE == null || this.fkE.fka == null) {
            return -1;
        }
        return this.fkE.fka.fkc;
    }

    public int getPosition() {
        int g = this.fkE != null ? com.baidu.adp.lib.h.b.g(this.fkE.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b bfv() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.fkE != null) {
            bVar.ME = this.fkE.id;
            bVar.MF = this.fkE.name;
            bVar.MG = this.fkE.fjW;
            bVar.MH = this.fkE.url;
            bVar.MI = this.fkE.apk_url;
            bVar.MK = this.fkE.apk_name;
            bVar.MM = this.fkE.pos_name.trim();
            bVar.MN = this.fkE.first_name;
            bVar.MO = this.fkE.second_name;
            bVar.MP = this.fkE.MP;
            bVar.abtest = this.fkE.abtest;
            bVar.MQ = this.fkE.fjX;
            bVar.userId = this.fkE.user_id;
            bVar.MR = this.fkE.verify;
            bVar.price = this.fkE.price;
            bVar.MS = this.fkE.ext_info;
            bVar.MT = this.fkE.fjY * 1000;
            if (this.fkE.fka != null) {
                bVar.MU.Nf = this.fkE.fka.pop_window_text;
                bVar.MU.Nb = this.fkE.fka.id;
                bVar.MU.Ne = this.fkE.fka.thread_pic;
                bVar.MU.Ng = this.fkE.fka.fkc;
                bVar.MU.Nc = this.fkE.fka.thread_title;
                bVar.MU.userName = this.fkE.fka.user_name;
                bVar.MU.userPortrait = this.fkE.fka.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bfu() == 2) {
            return com.baidu.tbadk.core.data.b.Mx;
        }
        if (bfu() == 6) {
            return com.baidu.tbadk.core.data.b.My;
        }
        return com.baidu.tbadk.core.data.b.Mw;
    }
}
