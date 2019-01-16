package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aqg;
    public String aqh;
    public String ecq;
    public String forumId;
    public boolean hpA = false;
    public boolean hpB = false;
    private AppData hpz;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hpz = new AppData(app);
    }

    public void vV(String str) {
        this.hpz = new AppData(str);
    }

    public AppData bEG() {
        return this.hpz;
    }

    public AdvertAppInfo.ILegoAdvert bEH() {
        if (this.hpz == null) {
            return null;
        }
        return this.hpz.legoCard;
    }

    public String getAdId() {
        return this.hpz == null ? "" : this.hpz.id;
    }

    public boolean Xu() {
        return this.hpz != null && this.hpz.yp() == 0;
    }

    public boolean isApp() {
        if (this.hpz == null) {
            return false;
        }
        return this.hpz.yq();
    }

    public int bEI() {
        if (this.hpz == null || this.hpz.goods == null) {
            return -1;
        }
        return this.hpz.goods.goods_style;
    }

    public int getPosition() {
        if (this.hpz == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hpz.pos_name, 0);
    }

    public String bEJ() {
        return this.hpA ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo py() {
        List<String> eo;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hpz != null) {
            advertAppInfo.aqk = this.hpz;
            advertAppInfo.apS = this.hpz.id;
            advertAppInfo.apT = this.hpz.name;
            advertAppInfo.apU = this.hpz.url_type;
            advertAppInfo.apV = this.hpz.url;
            advertAppInfo.deepUrl = this.hpz.deepUrl;
            advertAppInfo.apW = this.hpz.apk_url;
            advertAppInfo.apX = this.hpz.apk_name;
            advertAppInfo.adPosition = this.hpz.pos_name.trim();
            advertAppInfo.firstName = this.hpz.first_name;
            advertAppInfo.apZ = this.hpz.second_name;
            advertAppInfo.cpid = this.hpz.cpid;
            advertAppInfo.abtest = this.hpz.abtest;
            advertAppInfo.aqa = this.hpz.plan_id;
            advertAppInfo.userId = this.hpz.user_id;
            advertAppInfo.aqb = this.hpz.verify;
            advertAppInfo.price = this.hpz.price;
            advertAppInfo.extensionInfo = this.hpz.ext_info;
            advertAppInfo.aqc = this.hpz.app_time * 1000;
            advertAppInfo.legoCard = this.hpz.legoCard;
            if (this.hpz.goods != null) {
                advertAppInfo.aqd.aqp = this.hpz.goods.pop_window_text;
                advertAppInfo.aqd.aql = this.hpz.goods.id;
                advertAppInfo.aqd.aqo = this.hpz.goods.thread_pic;
                advertAppInfo.aqd.aqq = this.hpz.goods.goods_style;
                advertAppInfo.aqd.aqm = this.hpz.goods.thread_title;
                advertAppInfo.aqd.aqn = this.hpz.goods.thread_content;
                advertAppInfo.aqd.userName = this.hpz.goods.user_name;
                advertAppInfo.aqd.userPortrait = this.hpz.goods.user_portrait;
                advertAppInfo.aqd.buttonText = this.hpz.goods.button_text;
                advertAppInfo.aqd.aqt = this.hpz.goods.button_url;
                if (this.hpz.goods.thread_pic_list != null && advertAppInfo.aqd.aqu != null) {
                    advertAppInfo.aqd.aqu.addAll(this.hpz.goods.thread_pic_list);
                }
                if (v.I(advertAppInfo.aqd.aqu) && (eo = advertAppInfo.aqd.eo(this.hpz.goods.lego_card)) != null && advertAppInfo.aqd.aqu != null) {
                    advertAppInfo.aqd.aqu.addAll(eo);
                }
                advertAppInfo.aqd.aqv = this.hpz.goods.video_info;
                advertAppInfo.aqd.tagName = this.hpz.goods.tag_name;
                advertAppInfo.aqd.adSource = this.hpz.goods.ad_source;
                advertAppInfo.aqd.aqw = this.hpz.goods.tag_name_url;
                advertAppInfo.aqd.tagRatio = this.hpz.goods.tagRatio;
                advertAppInfo.aqd.lego_card = this.hpz.goods.lego_card;
                advertAppInfo.aqd.adCloseInfo = this.hpz.goods.adCloseInfo;
            }
            advertAppInfo.page = bEJ();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xR().xV() && this.hpz != null && this.hpz.legoCard != null && !this.hpz.legoCard.isNoPicAd()) {
            return AdvertAppInfo.apG;
        }
        if (bEI() == 1001 || bEI() == -1001) {
            return AdvertAppInfo.apG;
        }
        if (bEH() != null) {
            return AdvertAppInfo.apK;
        }
        return null;
    }
}
