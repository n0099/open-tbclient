package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String cNw;
    public String cNx;
    public String forumId;
    public String gGS;
    public boolean iQT;
    private AppData kie;
    public boolean kif = false;
    public boolean kig = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kie = new AppData(app);
    }

    public void Ja(String str) {
        this.kie = new AppData(str);
    }

    public AppData cLj() {
        return this.kie;
    }

    public AdvertAppInfo.ILegoAdvert cLk() {
        if (this.kie == null) {
            return null;
        }
        return this.kie.legoCard;
    }

    public String getAdId() {
        return this.kie == null ? "" : this.kie.id;
    }

    public boolean isValidate() {
        return this.kie != null && this.kie.aAs() == 0;
    }

    public boolean isApp() {
        if (this.kie == null) {
            return false;
        }
        return this.kie.aAt();
    }

    public int cLl() {
        if (this.kie == null || this.kie.goods == null) {
            return -1;
        }
        return this.kie.goods.goods_style;
    }

    public int getPosition() {
        if (this.kie == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kie.pos_name, 0);
    }

    public String cLm() {
        if (this.kif) {
            return "PB_BANNER";
        }
        if (this.iQT) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo kK() {
        List<String> su;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kie != null) {
            advertAppInfo.cNA = this.kie;
            advertAppInfo.cNk = this.kie.id;
            advertAppInfo.cNl = this.kie.name;
            advertAppInfo.Ez = this.kie.url_type;
            advertAppInfo.cNm = this.kie.url;
            advertAppInfo.deepUrl = this.kie.deepUrl;
            advertAppInfo.apkUrl = this.kie.apk_url;
            advertAppInfo.cNn = this.kie.apk_name;
            advertAppInfo.adPosition = this.kie.pos_name.trim();
            advertAppInfo.blT = this.kie.first_name;
            advertAppInfo.cNp = this.kie.second_name;
            advertAppInfo.cpid = this.kie.cpid;
            advertAppInfo.abtest = this.kie.abtest;
            advertAppInfo.cNq = this.kie.plan_id;
            advertAppInfo.userId = this.kie.user_id;
            advertAppInfo.cNr = this.kie.verify;
            advertAppInfo.price = this.kie.price;
            advertAppInfo.extensionInfo = this.kie.ext_info;
            advertAppInfo.cNs = this.kie.app_time * 1000;
            advertAppInfo.legoCard = this.kie.legoCard;
            if (this.kie.goods != null) {
                advertAppInfo.cNt.cNF = this.kie.goods.pop_window_text;
                advertAppInfo.cNt.cNB = this.kie.goods.id;
                advertAppInfo.cNt.cNE = this.kie.goods.thread_pic;
                advertAppInfo.cNt.cNG = this.kie.goods.goods_style;
                advertAppInfo.cNt.cNC = this.kie.goods.thread_title;
                advertAppInfo.cNt.cND = this.kie.goods.thread_content;
                advertAppInfo.cNt.userName = this.kie.goods.user_name;
                advertAppInfo.cNt.userPortrait = this.kie.goods.user_portrait;
                advertAppInfo.cNt.buttonText = this.kie.goods.button_text;
                advertAppInfo.cNt.cNJ = this.kie.goods.button_url;
                if (this.kie.goods.thread_pic_list != null && advertAppInfo.cNt.cNK != null) {
                    advertAppInfo.cNt.cNK.addAll(this.kie.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cNt.cNK) && (su = AdvertAppInfo.a.su(this.kie.goods.lego_card)) != null && advertAppInfo.cNt.cNK != null) {
                    advertAppInfo.cNt.cNK.addAll(su);
                }
                advertAppInfo.cNt.cNL = this.kie.goods.video_info;
                advertAppInfo.cNt.tagName = this.kie.goods.tag_name;
                advertAppInfo.cNt.adSource = this.kie.goods.ad_source;
                advertAppInfo.cNt.cNM = this.kie.goods.tag_name_url;
                advertAppInfo.cNt.tagRatio = this.kie.goods.tagRatio;
                advertAppInfo.cNt.lego_card = this.kie.goods.lego_card;
                advertAppInfo.cNt.adCloseInfo = this.kie.goods.adCloseInfo;
            }
            advertAppInfo.page = cLm();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.azR().isShowImages() && this.kie != null && this.kie.legoCard != null && !this.kie.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cMW;
        }
        if (cLl() == 1001 || cLl() == -1001) {
            return AdvertAppInfo.cMW;
        }
        if (cLk() != null) {
            return AdvertAppInfo.cNa;
        }
        return null;
    }
}
