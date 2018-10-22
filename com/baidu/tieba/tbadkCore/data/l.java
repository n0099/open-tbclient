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
    public String dRl;
    public String forumId;
    private AppData hcS;
    public boolean hcT = false;
    public boolean hcU = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hcS = new AppData(app);
    }

    public void uW(String str) {
        this.hcS = new AppData(str);
    }

    public AppData bBP() {
        return this.hcS;
    }

    public AdvertAppInfo.ILegoAdvert bBQ() {
        if (this.hcS == null) {
            return null;
        }
        return this.hcS.legoCard;
    }

    public String getAdId() {
        return this.hcS == null ? "" : this.hcS.id;
    }

    public boolean isApp() {
        if (this.hcS == null) {
            return false;
        }
        return this.hcS.wR();
    }

    public int bBR() {
        if (this.hcS == null || this.hcS.goods == null) {
            return -1;
        }
        return this.hcS.goods.goods_style;
    }

    public int getPosition() {
        if (this.hcS == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hcS.pos_name, 0);
    }

    public String bBS() {
        return this.hcT ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo px() {
        List<String> dN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hcS != null) {
            advertAppInfo.alu = this.hcS;
            advertAppInfo.alb = this.hcS.id;
            advertAppInfo.alc = this.hcS.name;
            advertAppInfo.ald = this.hcS.url_type;
            advertAppInfo.ale = this.hcS.url;
            advertAppInfo.deepUrl = this.hcS.deepUrl;
            advertAppInfo.alf = this.hcS.apk_url;
            advertAppInfo.alg = this.hcS.apk_name;
            advertAppInfo.adPosition = this.hcS.pos_name.trim();
            advertAppInfo.firstName = this.hcS.first_name;
            advertAppInfo.ali = this.hcS.second_name;
            advertAppInfo.cpid = this.hcS.cpid;
            advertAppInfo.abtest = this.hcS.abtest;
            advertAppInfo.alj = this.hcS.plan_id;
            advertAppInfo.userId = this.hcS.user_id;
            advertAppInfo.alk = this.hcS.verify;
            advertAppInfo.price = this.hcS.price;
            advertAppInfo.extensionInfo = this.hcS.ext_info;
            advertAppInfo.alm = this.hcS.app_time * 1000;
            advertAppInfo.legoCard = this.hcS.legoCard;
            if (this.hcS.goods != null) {
                advertAppInfo.aln.alz = this.hcS.goods.pop_window_text;
                advertAppInfo.aln.alv = this.hcS.goods.id;
                advertAppInfo.aln.aly = this.hcS.goods.thread_pic;
                advertAppInfo.aln.alA = this.hcS.goods.goods_style;
                advertAppInfo.aln.alw = this.hcS.goods.thread_title;
                advertAppInfo.aln.alx = this.hcS.goods.thread_content;
                advertAppInfo.aln.userName = this.hcS.goods.user_name;
                advertAppInfo.aln.userPortrait = this.hcS.goods.user_portrait;
                advertAppInfo.aln.buttonText = this.hcS.goods.button_text;
                advertAppInfo.aln.alD = this.hcS.goods.button_url;
                if (this.hcS.goods.thread_pic_list != null && advertAppInfo.aln.alE != null) {
                    advertAppInfo.aln.alE.addAll(this.hcS.goods.thread_pic_list);
                }
                if (v.J(advertAppInfo.aln.alE) && (dN = advertAppInfo.aln.dN(this.hcS.goods.lego_card)) != null && advertAppInfo.aln.alE != null) {
                    advertAppInfo.aln.alE.addAll(dN);
                }
                advertAppInfo.aln.alF = this.hcS.goods.video_info;
                advertAppInfo.aln.tagName = this.hcS.goods.tag_name;
                advertAppInfo.aln.adSource = this.hcS.goods.ad_source;
                advertAppInfo.aln.alG = this.hcS.goods.tag_name_url;
                advertAppInfo.aln.tagRatio = this.hcS.goods.tagRatio;
                advertAppInfo.aln.lego_card = this.hcS.goods.lego_card;
                advertAppInfo.aln.adCloseInfo = this.hcS.goods.adCloseInfo;
            }
            advertAppInfo.page = bBS();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.ws().ww() && this.hcS != null && this.hcS.legoCard != null && !this.hcS.legoCard.isNoPicAd()) {
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
