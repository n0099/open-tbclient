package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String alq;
    public String alr;
    public String dRk;
    public String forumId;
    private AppData hcR;
    public boolean hcS = false;
    public boolean hcT = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hcR = new AppData(app);
    }

    public void uW(String str) {
        this.hcR = new AppData(str);
    }

    public AppData bBP() {
        return this.hcR;
    }

    public AdvertAppInfo.ILegoAdvert bBQ() {
        if (this.hcR == null) {
            return null;
        }
        return this.hcR.legoCard;
    }

    public String getAdId() {
        return this.hcR == null ? "" : this.hcR.id;
    }

    public boolean isApp() {
        if (this.hcR == null) {
            return false;
        }
        return this.hcR.wR();
    }

    public int bBR() {
        if (this.hcR == null || this.hcR.goods == null) {
            return -1;
        }
        return this.hcR.goods.goods_style;
    }

    public int getPosition() {
        if (this.hcR == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hcR.pos_name, 0);
    }

    public String bBS() {
        return this.hcS ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo px() {
        List<String> dN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hcR != null) {
            advertAppInfo.alu = this.hcR;
            advertAppInfo.alb = this.hcR.id;
            advertAppInfo.alc = this.hcR.name;
            advertAppInfo.ald = this.hcR.url_type;
            advertAppInfo.ale = this.hcR.url;
            advertAppInfo.deepUrl = this.hcR.deepUrl;
            advertAppInfo.alf = this.hcR.apk_url;
            advertAppInfo.alg = this.hcR.apk_name;
            advertAppInfo.adPosition = this.hcR.pos_name.trim();
            advertAppInfo.firstName = this.hcR.first_name;
            advertAppInfo.ali = this.hcR.second_name;
            advertAppInfo.cpid = this.hcR.cpid;
            advertAppInfo.abtest = this.hcR.abtest;
            advertAppInfo.alj = this.hcR.plan_id;
            advertAppInfo.userId = this.hcR.user_id;
            advertAppInfo.alk = this.hcR.verify;
            advertAppInfo.price = this.hcR.price;
            advertAppInfo.extensionInfo = this.hcR.ext_info;
            advertAppInfo.alm = this.hcR.app_time * 1000;
            advertAppInfo.legoCard = this.hcR.legoCard;
            if (this.hcR.goods != null) {
                advertAppInfo.aln.alz = this.hcR.goods.pop_window_text;
                advertAppInfo.aln.alv = this.hcR.goods.id;
                advertAppInfo.aln.aly = this.hcR.goods.thread_pic;
                advertAppInfo.aln.alA = this.hcR.goods.goods_style;
                advertAppInfo.aln.alw = this.hcR.goods.thread_title;
                advertAppInfo.aln.alx = this.hcR.goods.thread_content;
                advertAppInfo.aln.userName = this.hcR.goods.user_name;
                advertAppInfo.aln.userPortrait = this.hcR.goods.user_portrait;
                advertAppInfo.aln.buttonText = this.hcR.goods.button_text;
                advertAppInfo.aln.alD = this.hcR.goods.button_url;
                if (this.hcR.goods.thread_pic_list != null && advertAppInfo.aln.alE != null) {
                    advertAppInfo.aln.alE.addAll(this.hcR.goods.thread_pic_list);
                }
                if (v.J(advertAppInfo.aln.alE) && (dN = advertAppInfo.aln.dN(this.hcR.goods.lego_card)) != null && advertAppInfo.aln.alE != null) {
                    advertAppInfo.aln.alE.addAll(dN);
                }
                advertAppInfo.aln.alF = this.hcR.goods.video_info;
                advertAppInfo.aln.tagName = this.hcR.goods.tag_name;
                advertAppInfo.aln.adSource = this.hcR.goods.ad_source;
                advertAppInfo.aln.alG = this.hcR.goods.tag_name_url;
                advertAppInfo.aln.tagRatio = this.hcR.goods.tagRatio;
                advertAppInfo.aln.lego_card = this.hcR.goods.lego_card;
                advertAppInfo.aln.adCloseInfo = this.hcR.goods.adCloseInfo;
            }
            advertAppInfo.page = bBS();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.ws().ww() && this.hcR != null && this.hcR.legoCard != null && !this.hcR.legoCard.isNoPicAd()) {
            return AdvertAppInfo.akP;
        }
        if (bBR() == 1001 || bBR() == -1001) {
            return AdvertAppInfo.akP;
        }
        if (bBQ() != null) {
            return AdvertAppInfo.akT;
        }
        return null;
    }
}
