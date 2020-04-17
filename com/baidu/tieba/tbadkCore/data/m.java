package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String dmA;
    public String dmB;
    public String forumId;
    public String hql;
    public boolean jBc;
    private AppData kSk;
    public boolean kSl = false;
    public boolean kSm = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kSk = new AppData(app);
    }

    public void KK(String str) {
        this.kSk = new AppData(str);
    }

    public AppData cWf() {
        return this.kSk;
    }

    public AdvertAppInfo.ILegoAdvert cWg() {
        if (this.kSk == null) {
            return null;
        }
        return this.kSk.legoCard;
    }

    public String getAdId() {
        return this.kSk == null ? "" : this.kSk.id;
    }

    public boolean isValidate() {
        return this.kSk != null && this.kSk.aIF() == 0;
    }

    public boolean isApp() {
        if (this.kSk == null) {
            return false;
        }
        return this.kSk.aIG();
    }

    public int cWh() {
        if (this.kSk == null || this.kSk.goods == null) {
            return -1;
        }
        return this.kSk.goods.goods_style;
    }

    public int getPosition() {
        if (this.kSk == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kSk.pos_name, 0);
    }

    public String cWi() {
        if (this.kSl) {
            return "PB_BANNER";
        }
        if (this.jBc) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo po() {
        List<String> tI;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kSk != null) {
            advertAppInfo.dmE = this.kSk;
            advertAppInfo.dmo = this.kSk.id;
            advertAppInfo.dmp = this.kSk.name;
            advertAppInfo.XQ = this.kSk.url_type;
            advertAppInfo.dmq = this.kSk.url;
            advertAppInfo.deepUrl = this.kSk.deepUrl;
            advertAppInfo.apkUrl = this.kSk.apk_url;
            advertAppInfo.dmr = this.kSk.apk_name;
            advertAppInfo.adPosition = this.kSk.pos_name.trim();
            advertAppInfo.bKb = this.kSk.first_name;
            advertAppInfo.dmt = this.kSk.second_name;
            advertAppInfo.cpid = this.kSk.cpid;
            advertAppInfo.abtest = this.kSk.abtest;
            advertAppInfo.dmu = this.kSk.plan_id;
            advertAppInfo.userId = this.kSk.user_id;
            advertAppInfo.dmv = this.kSk.verify;
            advertAppInfo.price = this.kSk.price;
            advertAppInfo.extensionInfo = this.kSk.ext_info;
            advertAppInfo.dmw = this.kSk.app_time * 1000;
            advertAppInfo.legoCard = this.kSk.legoCard;
            if (this.kSk.goods != null) {
                advertAppInfo.dmx.dmJ = this.kSk.goods.pop_window_text;
                advertAppInfo.dmx.dmF = this.kSk.goods.id;
                advertAppInfo.dmx.dmI = this.kSk.goods.thread_pic;
                advertAppInfo.dmx.dmK = this.kSk.goods.goods_style;
                advertAppInfo.dmx.dmG = this.kSk.goods.thread_title;
                advertAppInfo.dmx.dmH = this.kSk.goods.thread_content;
                advertAppInfo.dmx.userName = this.kSk.goods.user_name;
                advertAppInfo.dmx.userPortrait = this.kSk.goods.user_portrait;
                advertAppInfo.dmx.buttonText = this.kSk.goods.button_text;
                advertAppInfo.dmx.dmN = this.kSk.goods.button_url;
                if (this.kSk.goods.thread_pic_list != null && advertAppInfo.dmx.dmO != null) {
                    advertAppInfo.dmx.dmO.addAll(this.kSk.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.dmx.dmO) && (tI = AdvertAppInfo.a.tI(this.kSk.goods.lego_card)) != null && advertAppInfo.dmx.dmO != null) {
                    advertAppInfo.dmx.dmO.addAll(tI);
                }
                advertAppInfo.dmx.dmP = this.kSk.goods.video_info;
                advertAppInfo.dmx.tagName = this.kSk.goods.tag_name;
                advertAppInfo.dmx.adSource = this.kSk.goods.ad_source;
                advertAppInfo.dmx.dmQ = this.kSk.goods.tag_name_url;
                advertAppInfo.dmx.tagRatio = this.kSk.goods.tagRatio;
                advertAppInfo.dmx.lego_card = this.kSk.goods.lego_card;
                advertAppInfo.dmx.adCloseInfo = this.kSk.goods.adCloseInfo;
            }
            advertAppInfo.page = cWi();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.aIe().isShowImages() && this.kSk != null && this.kSk.legoCard != null && !this.kSk.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dmc;
        }
        if (cWh() == 1001 || cWh() == -1001) {
            return AdvertAppInfo.dmc;
        }
        if (cWg() != null) {
            return AdvertAppInfo.dmg;
        }
        return null;
    }
}
