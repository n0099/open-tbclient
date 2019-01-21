package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aqh;
    public String aqi;
    public String ecr;
    public String forumId;
    private AppData hpA;
    public boolean hpB = false;
    public boolean hpC = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hpA = new AppData(app);
    }

    public void vV(String str) {
        this.hpA = new AppData(str);
    }

    public AppData bEG() {
        return this.hpA;
    }

    public AdvertAppInfo.ILegoAdvert bEH() {
        if (this.hpA == null) {
            return null;
        }
        return this.hpA.legoCard;
    }

    public String getAdId() {
        return this.hpA == null ? "" : this.hpA.id;
    }

    public boolean Xu() {
        return this.hpA != null && this.hpA.yp() == 0;
    }

    public boolean isApp() {
        if (this.hpA == null) {
            return false;
        }
        return this.hpA.yq();
    }

    public int bEI() {
        if (this.hpA == null || this.hpA.goods == null) {
            return -1;
        }
        return this.hpA.goods.goods_style;
    }

    public int getPosition() {
        if (this.hpA == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hpA.pos_name, 0);
    }

    public String bEJ() {
        return this.hpB ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo py() {
        List<String> eo;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hpA != null) {
            advertAppInfo.aql = this.hpA;
            advertAppInfo.apT = this.hpA.id;
            advertAppInfo.apU = this.hpA.name;
            advertAppInfo.apV = this.hpA.url_type;
            advertAppInfo.apW = this.hpA.url;
            advertAppInfo.deepUrl = this.hpA.deepUrl;
            advertAppInfo.apX = this.hpA.apk_url;
            advertAppInfo.apY = this.hpA.apk_name;
            advertAppInfo.adPosition = this.hpA.pos_name.trim();
            advertAppInfo.firstName = this.hpA.first_name;
            advertAppInfo.aqa = this.hpA.second_name;
            advertAppInfo.cpid = this.hpA.cpid;
            advertAppInfo.abtest = this.hpA.abtest;
            advertAppInfo.aqb = this.hpA.plan_id;
            advertAppInfo.userId = this.hpA.user_id;
            advertAppInfo.aqc = this.hpA.verify;
            advertAppInfo.price = this.hpA.price;
            advertAppInfo.extensionInfo = this.hpA.ext_info;
            advertAppInfo.aqd = this.hpA.app_time * 1000;
            advertAppInfo.legoCard = this.hpA.legoCard;
            if (this.hpA.goods != null) {
                advertAppInfo.aqe.aqq = this.hpA.goods.pop_window_text;
                advertAppInfo.aqe.aqm = this.hpA.goods.id;
                advertAppInfo.aqe.aqp = this.hpA.goods.thread_pic;
                advertAppInfo.aqe.aqr = this.hpA.goods.goods_style;
                advertAppInfo.aqe.aqn = this.hpA.goods.thread_title;
                advertAppInfo.aqe.aqo = this.hpA.goods.thread_content;
                advertAppInfo.aqe.userName = this.hpA.goods.user_name;
                advertAppInfo.aqe.userPortrait = this.hpA.goods.user_portrait;
                advertAppInfo.aqe.buttonText = this.hpA.goods.button_text;
                advertAppInfo.aqe.aqu = this.hpA.goods.button_url;
                if (this.hpA.goods.thread_pic_list != null && advertAppInfo.aqe.aqv != null) {
                    advertAppInfo.aqe.aqv.addAll(this.hpA.goods.thread_pic_list);
                }
                if (v.I(advertAppInfo.aqe.aqv) && (eo = advertAppInfo.aqe.eo(this.hpA.goods.lego_card)) != null && advertAppInfo.aqe.aqv != null) {
                    advertAppInfo.aqe.aqv.addAll(eo);
                }
                advertAppInfo.aqe.aqw = this.hpA.goods.video_info;
                advertAppInfo.aqe.tagName = this.hpA.goods.tag_name;
                advertAppInfo.aqe.adSource = this.hpA.goods.ad_source;
                advertAppInfo.aqe.aqx = this.hpA.goods.tag_name_url;
                advertAppInfo.aqe.tagRatio = this.hpA.goods.tagRatio;
                advertAppInfo.aqe.lego_card = this.hpA.goods.lego_card;
                advertAppInfo.aqe.adCloseInfo = this.hpA.goods.adCloseInfo;
            }
            advertAppInfo.page = bEJ();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xR().xV() && this.hpA != null && this.hpA.legoCard != null && !this.hpA.legoCard.isNoPicAd()) {
            return AdvertAppInfo.apH;
        }
        if (bEI() == 1001 || bEI() == -1001) {
            return AdvertAppInfo.apH;
        }
        if (bEH() != null) {
            return AdvertAppInfo.apL;
        }
        return null;
    }
}
