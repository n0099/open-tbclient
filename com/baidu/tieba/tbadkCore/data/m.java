package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bEg;
    public String bEh;
    public String fGh;
    public String forumId;
    private AppData iYC;
    public boolean iYD = false;
    public boolean iYE = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iYC = new AppData(app);
    }

    public void DV(String str) {
        this.iYC = new AppData(str);
    }

    public AppData cml() {
        return this.iYC;
    }

    public AdvertAppInfo.ILegoAdvert cmm() {
        if (this.iYC == null) {
            return null;
        }
        return this.iYC.legoCard;
    }

    public String getAdId() {
        return this.iYC == null ? "" : this.iYC.id;
    }

    public boolean aCA() {
        return this.iYC != null && this.iYC.abE() == 0;
    }

    public boolean isApp() {
        if (this.iYC == null) {
            return false;
        }
        return this.iYC.abF();
    }

    public int cmn() {
        if (this.iYC == null || this.iYC.goods == null) {
            return -1;
        }
        return this.iYC.goods.goods_style;
    }

    public int getPosition() {
        if (this.iYC == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.f(this.iYC.pos_name, 0);
    }

    public String cmo() {
        return this.iYD ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo oM() {
        List<String> md;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iYC != null) {
            advertAppInfo.bEk = this.iYC;
            advertAppInfo.bDT = this.iYC.id;
            advertAppInfo.bDU = this.iYC.name;
            advertAppInfo.Sj = this.iYC.url_type;
            advertAppInfo.bDV = this.iYC.url;
            advertAppInfo.deepUrl = this.iYC.deepUrl;
            advertAppInfo.bDW = this.iYC.apk_url;
            advertAppInfo.bDX = this.iYC.apk_name;
            advertAppInfo.adPosition = this.iYC.pos_name.trim();
            advertAppInfo.anT = this.iYC.first_name;
            advertAppInfo.bDZ = this.iYC.second_name;
            advertAppInfo.cpid = this.iYC.cpid;
            advertAppInfo.abtest = this.iYC.abtest;
            advertAppInfo.bEa = this.iYC.plan_id;
            advertAppInfo.userId = this.iYC.user_id;
            advertAppInfo.bEb = this.iYC.verify;
            advertAppInfo.price = this.iYC.price;
            advertAppInfo.extensionInfo = this.iYC.ext_info;
            advertAppInfo.bEc = this.iYC.app_time * 1000;
            advertAppInfo.legoCard = this.iYC.legoCard;
            if (this.iYC.goods != null) {
                advertAppInfo.bEd.bEp = this.iYC.goods.pop_window_text;
                advertAppInfo.bEd.bEl = this.iYC.goods.id;
                advertAppInfo.bEd.bEo = this.iYC.goods.thread_pic;
                advertAppInfo.bEd.bEq = this.iYC.goods.goods_style;
                advertAppInfo.bEd.bEm = this.iYC.goods.thread_title;
                advertAppInfo.bEd.bEn = this.iYC.goods.thread_content;
                advertAppInfo.bEd.userName = this.iYC.goods.user_name;
                advertAppInfo.bEd.userPortrait = this.iYC.goods.user_portrait;
                advertAppInfo.bEd.buttonText = this.iYC.goods.button_text;
                advertAppInfo.bEd.bEt = this.iYC.goods.button_url;
                if (this.iYC.goods.thread_pic_list != null && advertAppInfo.bEd.bEu != null) {
                    advertAppInfo.bEd.bEu.addAll(this.iYC.goods.thread_pic_list);
                }
                if (v.aa(advertAppInfo.bEd.bEu) && (md = AdvertAppInfo.a.md(this.iYC.goods.lego_card)) != null && advertAppInfo.bEd.bEu != null) {
                    advertAppInfo.bEd.bEu.addAll(md);
                }
                advertAppInfo.bEd.bEv = this.iYC.goods.video_info;
                advertAppInfo.bEd.tagName = this.iYC.goods.tag_name;
                advertAppInfo.bEd.adSource = this.iYC.goods.ad_source;
                advertAppInfo.bEd.bEw = this.iYC.goods.tag_name_url;
                advertAppInfo.bEd.tagRatio = this.iYC.goods.tagRatio;
                advertAppInfo.bEd.lego_card = this.iYC.goods.lego_card;
                advertAppInfo.bEd.adCloseInfo = this.iYC.goods.adCloseInfo;
            }
            advertAppInfo.page = cmo();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.abb().abf() && this.iYC != null && this.iYC.legoCard != null && !this.iYC.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bDH;
        }
        if (cmn() == 1001 || cmn() == -1001) {
            return AdvertAppInfo.bDH;
        }
        if (cmm() != null) {
            return AdvertAppInfo.bDL;
        }
        return null;
    }
}
