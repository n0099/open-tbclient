package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String dmE;
    public String dmF;
    public String forumId;
    public String hqr;
    public boolean jBg;
    private AppData kSo;
    public boolean kSp = false;
    public boolean kSq = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kSo = new AppData(app);
    }

    public void KN(String str) {
        this.kSo = new AppData(str);
    }

    public AppData cWc() {
        return this.kSo;
    }

    public AdvertAppInfo.ILegoAdvert cWd() {
        if (this.kSo == null) {
            return null;
        }
        return this.kSo.legoCard;
    }

    public String getAdId() {
        return this.kSo == null ? "" : this.kSo.id;
    }

    public boolean isValidate() {
        return this.kSo != null && this.kSo.aID() == 0;
    }

    public boolean isApp() {
        if (this.kSo == null) {
            return false;
        }
        return this.kSo.aIE();
    }

    public int cWe() {
        if (this.kSo == null || this.kSo.goods == null) {
            return -1;
        }
        return this.kSo.goods.goods_style;
    }

    public int getPosition() {
        if (this.kSo == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kSo.pos_name, 0);
    }

    public String cWf() {
        if (this.kSp) {
            return "PB_BANNER";
        }
        if (this.jBg) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo po() {
        List<String> tL;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kSo != null) {
            advertAppInfo.dmI = this.kSo;
            advertAppInfo.dms = this.kSo.id;
            advertAppInfo.dmt = this.kSo.name;
            advertAppInfo.XT = this.kSo.url_type;
            advertAppInfo.dmu = this.kSo.url;
            advertAppInfo.deepUrl = this.kSo.deepUrl;
            advertAppInfo.apkUrl = this.kSo.apk_url;
            advertAppInfo.dmv = this.kSo.apk_name;
            advertAppInfo.adPosition = this.kSo.pos_name.trim();
            advertAppInfo.bKg = this.kSo.first_name;
            advertAppInfo.dmx = this.kSo.second_name;
            advertAppInfo.cpid = this.kSo.cpid;
            advertAppInfo.abtest = this.kSo.abtest;
            advertAppInfo.dmy = this.kSo.plan_id;
            advertAppInfo.userId = this.kSo.user_id;
            advertAppInfo.dmz = this.kSo.verify;
            advertAppInfo.price = this.kSo.price;
            advertAppInfo.extensionInfo = this.kSo.ext_info;
            advertAppInfo.dmA = this.kSo.app_time * 1000;
            advertAppInfo.legoCard = this.kSo.legoCard;
            if (this.kSo.goods != null) {
                advertAppInfo.dmB.dmN = this.kSo.goods.pop_window_text;
                advertAppInfo.dmB.dmJ = this.kSo.goods.id;
                advertAppInfo.dmB.dmM = this.kSo.goods.thread_pic;
                advertAppInfo.dmB.dmO = this.kSo.goods.goods_style;
                advertAppInfo.dmB.dmK = this.kSo.goods.thread_title;
                advertAppInfo.dmB.dmL = this.kSo.goods.thread_content;
                advertAppInfo.dmB.userName = this.kSo.goods.user_name;
                advertAppInfo.dmB.userPortrait = this.kSo.goods.user_portrait;
                advertAppInfo.dmB.buttonText = this.kSo.goods.button_text;
                advertAppInfo.dmB.dmR = this.kSo.goods.button_url;
                if (this.kSo.goods.thread_pic_list != null && advertAppInfo.dmB.dmS != null) {
                    advertAppInfo.dmB.dmS.addAll(this.kSo.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.dmB.dmS) && (tL = AdvertAppInfo.a.tL(this.kSo.goods.lego_card)) != null && advertAppInfo.dmB.dmS != null) {
                    advertAppInfo.dmB.dmS.addAll(tL);
                }
                advertAppInfo.dmB.dmT = this.kSo.goods.video_info;
                advertAppInfo.dmB.tagName = this.kSo.goods.tag_name;
                advertAppInfo.dmB.adSource = this.kSo.goods.ad_source;
                advertAppInfo.dmB.dmU = this.kSo.goods.tag_name_url;
                advertAppInfo.dmB.tagRatio = this.kSo.goods.tagRatio;
                advertAppInfo.dmB.lego_card = this.kSo.goods.lego_card;
                advertAppInfo.dmB.adCloseInfo = this.kSo.goods.adCloseInfo;
            }
            advertAppInfo.page = cWf();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.aIc().isShowImages() && this.kSo != null && this.kSo.legoCard != null && !this.kSo.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dmg;
        }
        if (cWe() == 1001 || cWe() == -1001) {
            return AdvertAppInfo.dmg;
        }
        if (cWd() != null) {
            return AdvertAppInfo.dmk;
        }
        return null;
    }
}
