package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String ekH;
    public String ekI;
    public String forumId;
    public String iJE;
    public boolean ljW;
    private AppData mEd;
    public boolean mEe = false;
    public boolean mEf = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.mEd = new AppData(app);
    }

    public void Sa(String str) {
        this.mEd = new AppData(str);
    }

    public AppData dEd() {
        return this.mEd;
    }

    public AdvertAppInfo.ILegoAdvert dEe() {
        if (this.mEd == null) {
            return null;
        }
        return this.mEd.legoCard;
    }

    public String getAdId() {
        return this.mEd == null ? "" : this.mEd.id;
    }

    public boolean isValidate() {
        return this.mEd != null && this.mEd.bfY() == 0;
    }

    public boolean isApp() {
        if (this.mEd == null) {
            return false;
        }
        return this.mEd.bfZ();
    }

    public int dEf() {
        if (this.mEd == null || this.mEd.goods == null) {
            return -1;
        }
        return this.mEd.goods.goods_style;
    }

    public int getPosition() {
        if (this.mEd == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.mEd.pos_name, 0);
    }

    public String dEg() {
        if (this.mEe) {
            return "PB_BANNER";
        }
        if (this.ljW) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rq() {
        List<String> Ag;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.mEd != null) {
            advertAppInfo.ekL = this.mEd;
            advertAppInfo.ekv = this.mEd.id;
            advertAppInfo.ekw = this.mEd.name;
            advertAppInfo.ZT = this.mEd.url_type;
            advertAppInfo.ekx = this.mEd.url;
            advertAppInfo.deepUrl = this.mEd.deepUrl;
            advertAppInfo.apkUrl = this.mEd.apk_url;
            advertAppInfo.eky = this.mEd.apk_name;
            advertAppInfo.adPosition = this.mEd.pos_name.trim();
            advertAppInfo.csQ = this.mEd.first_name;
            advertAppInfo.ekA = this.mEd.second_name;
            advertAppInfo.cpid = this.mEd.cpid;
            advertAppInfo.abtest = this.mEd.abtest;
            advertAppInfo.ekB = this.mEd.plan_id;
            advertAppInfo.userId = this.mEd.user_id;
            advertAppInfo.ekC = this.mEd.verify;
            advertAppInfo.price = this.mEd.price;
            advertAppInfo.extensionInfo = this.mEd.ext_info;
            advertAppInfo.ekD = this.mEd.app_time * 1000;
            advertAppInfo.legoCard = this.mEd.legoCard;
            if (this.mEd.goods != null) {
                advertAppInfo.ekE.ekQ = this.mEd.goods.pop_window_text;
                advertAppInfo.ekE.ekM = this.mEd.goods.id;
                advertAppInfo.ekE.ekP = this.mEd.goods.thread_pic;
                advertAppInfo.ekE.ekR = this.mEd.goods.goods_style;
                advertAppInfo.ekE.ekN = this.mEd.goods.thread_title;
                advertAppInfo.ekE.ekO = this.mEd.goods.thread_content;
                advertAppInfo.ekE.userName = this.mEd.goods.user_name;
                advertAppInfo.ekE.userPortrait = this.mEd.goods.user_portrait;
                advertAppInfo.ekE.buttonText = this.mEd.goods.button_text;
                advertAppInfo.ekE.ekU = this.mEd.goods.button_url;
                if (this.mEd.goods.thread_pic_list != null && advertAppInfo.ekE.ekV != null) {
                    advertAppInfo.ekE.ekV.addAll(this.mEd.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.ekE.ekV) && (Ag = AdvertAppInfo.a.Ag(this.mEd.goods.lego_card)) != null && advertAppInfo.ekE.ekV != null) {
                    advertAppInfo.ekE.ekV.addAll(Ag);
                }
                advertAppInfo.ekE.ekW = this.mEd.goods.video_info;
                advertAppInfo.ekE.tagName = this.mEd.goods.tag_name;
                advertAppInfo.ekE.adSource = this.mEd.goods.ad_source;
                advertAppInfo.ekE.ekX = this.mEd.goods.tag_name_url;
                advertAppInfo.ekE.tagRatio = this.mEd.goods.tagRatio;
                advertAppInfo.ekE.lego_card = this.mEd.goods.lego_card;
                advertAppInfo.ekE.adCloseInfo = this.mEd.goods.adCloseInfo;
            }
            advertAppInfo.page = dEg();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bfo().isShowImages() && this.mEd != null && this.mEd.legoCard != null && !this.mEd.legoCard.isNoPicAd()) {
            return AdvertAppInfo.ekj;
        }
        if (dEf() == 1001 || dEf() == -1001) {
            return AdvertAppInfo.ekj;
        }
        if (dEe() != null) {
            return AdvertAppInfo.ekn;
        }
        return null;
    }
}
