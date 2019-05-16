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
    public String fGf;
    public String forumId;
    private AppData iYw;
    public boolean iYx = false;
    public boolean iYy = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iYw = new AppData(app);
    }

    public void DT(String str) {
        this.iYw = new AppData(str);
    }

    public AppData cmi() {
        return this.iYw;
    }

    public AdvertAppInfo.ILegoAdvert cmj() {
        if (this.iYw == null) {
            return null;
        }
        return this.iYw.legoCard;
    }

    public String getAdId() {
        return this.iYw == null ? "" : this.iYw.id;
    }

    public boolean aCx() {
        return this.iYw != null && this.iYw.abE() == 0;
    }

    public boolean isApp() {
        if (this.iYw == null) {
            return false;
        }
        return this.iYw.abF();
    }

    public int cmk() {
        if (this.iYw == null || this.iYw.goods == null) {
            return -1;
        }
        return this.iYw.goods.goods_style;
    }

    public int getPosition() {
        if (this.iYw == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.f(this.iYw.pos_name, 0);
    }

    public String cml() {
        return this.iYx ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo oM() {
        List<String> me;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iYw != null) {
            advertAppInfo.bEj = this.iYw;
            advertAppInfo.bDS = this.iYw.id;
            advertAppInfo.bDT = this.iYw.name;
            advertAppInfo.Sk = this.iYw.url_type;
            advertAppInfo.bDU = this.iYw.url;
            advertAppInfo.deepUrl = this.iYw.deepUrl;
            advertAppInfo.bDV = this.iYw.apk_url;
            advertAppInfo.bDW = this.iYw.apk_name;
            advertAppInfo.adPosition = this.iYw.pos_name.trim();
            advertAppInfo.anT = this.iYw.first_name;
            advertAppInfo.bDY = this.iYw.second_name;
            advertAppInfo.cpid = this.iYw.cpid;
            advertAppInfo.abtest = this.iYw.abtest;
            advertAppInfo.bDZ = this.iYw.plan_id;
            advertAppInfo.userId = this.iYw.user_id;
            advertAppInfo.bEa = this.iYw.verify;
            advertAppInfo.price = this.iYw.price;
            advertAppInfo.extensionInfo = this.iYw.ext_info;
            advertAppInfo.bEb = this.iYw.app_time * 1000;
            advertAppInfo.legoCard = this.iYw.legoCard;
            if (this.iYw.goods != null) {
                advertAppInfo.bEc.bEo = this.iYw.goods.pop_window_text;
                advertAppInfo.bEc.bEk = this.iYw.goods.id;
                advertAppInfo.bEc.bEn = this.iYw.goods.thread_pic;
                advertAppInfo.bEc.bEp = this.iYw.goods.goods_style;
                advertAppInfo.bEc.bEl = this.iYw.goods.thread_title;
                advertAppInfo.bEc.bEm = this.iYw.goods.thread_content;
                advertAppInfo.bEc.userName = this.iYw.goods.user_name;
                advertAppInfo.bEc.userPortrait = this.iYw.goods.user_portrait;
                advertAppInfo.bEc.buttonText = this.iYw.goods.button_text;
                advertAppInfo.bEc.bEs = this.iYw.goods.button_url;
                if (this.iYw.goods.thread_pic_list != null && advertAppInfo.bEc.bEt != null) {
                    advertAppInfo.bEc.bEt.addAll(this.iYw.goods.thread_pic_list);
                }
                if (v.aa(advertAppInfo.bEc.bEt) && (me = AdvertAppInfo.a.me(this.iYw.goods.lego_card)) != null && advertAppInfo.bEc.bEt != null) {
                    advertAppInfo.bEc.bEt.addAll(me);
                }
                advertAppInfo.bEc.bEu = this.iYw.goods.video_info;
                advertAppInfo.bEc.tagName = this.iYw.goods.tag_name;
                advertAppInfo.bEc.adSource = this.iYw.goods.ad_source;
                advertAppInfo.bEc.bEv = this.iYw.goods.tag_name_url;
                advertAppInfo.bEc.tagRatio = this.iYw.goods.tagRatio;
                advertAppInfo.bEc.lego_card = this.iYw.goods.lego_card;
                advertAppInfo.bEc.adCloseInfo = this.iYw.goods.adCloseInfo;
            }
            advertAppInfo.page = cml();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.abb().abf() && this.iYw != null && this.iYw.legoCard != null && !this.iYw.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bDG;
        }
        if (cmk() == 1001 || cmk() == -1001) {
            return AdvertAppInfo.bDG;
        }
        if (cmj() != null) {
            return AdvertAppInfo.bDK;
        }
        return null;
    }
}
