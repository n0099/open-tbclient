package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
/* loaded from: classes.dex */
public class r extends s implements p {
    private int MF;
    public String bMN;
    public String bgH;
    private e eXC;
    public boolean eXD = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.eXC = new e(app);
    }

    public e bcb() {
        return this.eXC;
    }

    public String bcc() {
        return this.eXC == null ? "" : this.eXC.id;
    }

    public void qB(int i) {
        this.MF = i;
    }

    public boolean ov() {
        if (this.eXC == null) {
            return false;
        }
        return this.eXC.ov();
    }

    public boolean isApp() {
        if (this.eXC == null) {
            return false;
        }
        return this.eXC.ow();
    }

    public boolean bcd() {
        if (this.eXC == null) {
            return false;
        }
        return this.eXC.ox();
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public String ip() {
        if (this.eXC == null) {
            return null;
        }
        return this.eXC.apk_name;
    }

    public String getDownloadUrl() {
        if (this.eXC == null) {
            return null;
        }
        return this.eXC.apk_url;
    }

    public String getAppName() {
        return this.eXC == null ? "" : StringUtils.isNull(this.eXC.name) ? this.eXC.eWY.user_name : this.eXC.name;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String bbY() {
        String str = (this.eXC == null || this.eXC.eWY == null) ? null : this.eXC.eWY.user_name;
        return StringUtils.isNull(str) ? "" : str;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String bbZ() {
        if (this.eXC == null || this.eXC.eWY == null) {
            return null;
        }
        return this.eXC.eWY.user_portrait;
    }

    @Override // com.baidu.tieba.tbadkCore.data.q
    public String bca() {
        if (this.eXC == null || this.eXC.eWY == null) {
            return null;
        }
        return this.eXC.eWY.thread_title;
    }

    public String bce() {
        if (this.eXC == null || this.eXC.eWY == null) {
            return null;
        }
        return this.eXC.eWY.thread_pic;
    }

    public int bcf() {
        if (this.eXC == null || this.eXC.eWY == null) {
            return -1;
        }
        return this.eXC.eWY.eXa;
    }

    public int getPosition() {
        int g = this.eXC != null ? com.baidu.adp.lib.h.b.g(this.eXC.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.b bcg() {
        com.baidu.tbadk.core.data.b bVar = new com.baidu.tbadk.core.data.b();
        if (this.eXC != null) {
            bVar.MG = this.eXC.id;
            bVar.MH = this.eXC.name;
            bVar.MI = this.eXC.eWU;
            bVar.MJ = this.eXC.url;
            bVar.MK = this.eXC.apk_url;
            bVar.MN = this.eXC.apk_name;
            bVar.MO = this.eXC.pos_name.trim();
            bVar.MP = this.eXC.first_name;
            bVar.MQ = this.eXC.second_name;
            bVar.MR = this.eXC.MR;
            bVar.abtest = this.eXC.abtest;
            bVar.MS = this.eXC.eWV;
            bVar.userId = this.eXC.user_id;
            bVar.MT = this.eXC.verify;
            bVar.price = this.eXC.price;
            bVar.MU = this.eXC.ext_info;
            bVar.MV = this.eXC.eWW * 1000;
            if (this.eXC.eWY != null) {
                bVar.MW.Nh = this.eXC.eWY.pop_window_text;
                bVar.MW.Nd = this.eXC.eWY.id;
                bVar.MW.Ng = this.eXC.eWY.thread_pic;
                bVar.MW.Ni = this.eXC.eWY.eXa;
                bVar.MW.Ne = this.eXC.eWY.thread_title;
                bVar.MW.userName = this.eXC.eWY.user_name;
                bVar.MW.userPortrait = this.eXC.eWY.user_portrait;
            }
        }
        return bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.s, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bcf() == 2) {
            return com.baidu.tbadk.core.data.b.Mz;
        }
        if (bcf() == 6) {
            return com.baidu.tbadk.core.data.b.MA;
        }
        return com.baidu.tbadk.core.data.b.My;
    }
}
