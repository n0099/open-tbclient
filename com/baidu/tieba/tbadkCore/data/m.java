package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bEf;
    public String bEg;
    public String fGg;
    public String forumId;
    private AppData iYy;
    public int pageNumber;
    public long threadId;
    public boolean iYz = false;
    public boolean iYA = false;

    public void d(App app) {
        this.iYy = new AppData(app);
    }

    public void DT(String str) {
        this.iYy = new AppData(str);
    }

    public AppData cmk() {
        return this.iYy;
    }

    public AdvertAppInfo.ILegoAdvert cml() {
        if (this.iYy == null) {
            return null;
        }
        return this.iYy.legoCard;
    }

    public String getAdId() {
        return this.iYy == null ? "" : this.iYy.id;
    }

    public boolean aCA() {
        return this.iYy != null && this.iYy.abE() == 0;
    }

    public boolean isApp() {
        if (this.iYy == null) {
            return false;
        }
        return this.iYy.abF();
    }

    public int cmm() {
        if (this.iYy == null || this.iYy.goods == null) {
            return -1;
        }
        return this.iYy.goods.goods_style;
    }

    public int getPosition() {
        if (this.iYy == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.f(this.iYy.pos_name, 0);
    }

    public String cmn() {
        return this.iYz ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo oM() {
        List<String> me;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iYy != null) {
            advertAppInfo.bEj = this.iYy;
            advertAppInfo.bDS = this.iYy.id;
            advertAppInfo.bDT = this.iYy.name;
            advertAppInfo.Sk = this.iYy.url_type;
            advertAppInfo.bDU = this.iYy.url;
            advertAppInfo.deepUrl = this.iYy.deepUrl;
            advertAppInfo.bDV = this.iYy.apk_url;
            advertAppInfo.bDW = this.iYy.apk_name;
            advertAppInfo.adPosition = this.iYy.pos_name.trim();
            advertAppInfo.anT = this.iYy.first_name;
            advertAppInfo.bDY = this.iYy.second_name;
            advertAppInfo.cpid = this.iYy.cpid;
            advertAppInfo.abtest = this.iYy.abtest;
            advertAppInfo.bDZ = this.iYy.plan_id;
            advertAppInfo.userId = this.iYy.user_id;
            advertAppInfo.bEa = this.iYy.verify;
            advertAppInfo.price = this.iYy.price;
            advertAppInfo.extensionInfo = this.iYy.ext_info;
            advertAppInfo.bEb = this.iYy.app_time * 1000;
            advertAppInfo.legoCard = this.iYy.legoCard;
            if (this.iYy.goods != null) {
                advertAppInfo.bEc.bEo = this.iYy.goods.pop_window_text;
                advertAppInfo.bEc.bEk = this.iYy.goods.id;
                advertAppInfo.bEc.bEn = this.iYy.goods.thread_pic;
                advertAppInfo.bEc.bEp = this.iYy.goods.goods_style;
                advertAppInfo.bEc.bEl = this.iYy.goods.thread_title;
                advertAppInfo.bEc.bEm = this.iYy.goods.thread_content;
                advertAppInfo.bEc.userName = this.iYy.goods.user_name;
                advertAppInfo.bEc.userPortrait = this.iYy.goods.user_portrait;
                advertAppInfo.bEc.buttonText = this.iYy.goods.button_text;
                advertAppInfo.bEc.bEs = this.iYy.goods.button_url;
                if (this.iYy.goods.thread_pic_list != null && advertAppInfo.bEc.bEt != null) {
                    advertAppInfo.bEc.bEt.addAll(this.iYy.goods.thread_pic_list);
                }
                if (v.aa(advertAppInfo.bEc.bEt) && (me = AdvertAppInfo.a.me(this.iYy.goods.lego_card)) != null && advertAppInfo.bEc.bEt != null) {
                    advertAppInfo.bEc.bEt.addAll(me);
                }
                advertAppInfo.bEc.bEu = this.iYy.goods.video_info;
                advertAppInfo.bEc.tagName = this.iYy.goods.tag_name;
                advertAppInfo.bEc.adSource = this.iYy.goods.ad_source;
                advertAppInfo.bEc.bEv = this.iYy.goods.tag_name_url;
                advertAppInfo.bEc.tagRatio = this.iYy.goods.tagRatio;
                advertAppInfo.bEc.lego_card = this.iYy.goods.lego_card;
                advertAppInfo.bEc.adCloseInfo = this.iYy.goods.adCloseInfo;
            }
            advertAppInfo.page = cmn();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.abb().abf() && this.iYy != null && this.iYy.legoCard != null && !this.iYy.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bDG;
        }
        if (cmm() == 1001 || cmm() == -1001) {
            return AdvertAppInfo.bDG;
        }
        if (cml() != null) {
            return AdvertAppInfo.bDK;
        }
        return null;
    }
}
