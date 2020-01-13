package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String cJe;
    public String cJf;
    public String forumId;
    public String gDH;
    private AppData kfi;
    public boolean kfj = false;
    public boolean kfk = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kfi = new AppData(app);
    }

    public void IM(String str) {
        this.kfi = new AppData(str);
    }

    public AppData cJl() {
        return this.kfi;
    }

    public AdvertAppInfo.ILegoAdvert cJm() {
        if (this.kfi == null) {
            return null;
        }
        return this.kfi.legoCard;
    }

    public String getAdId() {
        return this.kfi == null ? "" : this.kfi.id;
    }

    public boolean isValidate() {
        return this.kfi != null && this.kfi.axZ() == 0;
    }

    public boolean isApp() {
        if (this.kfi == null) {
            return false;
        }
        return this.kfi.aya();
    }

    public int cJn() {
        if (this.kfi == null || this.kfi.goods == null) {
            return -1;
        }
        return this.kfi.goods.goods_style;
    }

    public int getPosition() {
        if (this.kfi == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kfi.pos_name, 0);
    }

    public String cJo() {
        return this.kfj ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo kv() {
        List<String> se;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kfi != null) {
            advertAppInfo.cJi = this.kfi;
            advertAppInfo.cIS = this.kfi.id;
            advertAppInfo.cIT = this.kfi.name;
            advertAppInfo.Eg = this.kfi.url_type;
            advertAppInfo.cIU = this.kfi.url;
            advertAppInfo.deepUrl = this.kfi.deepUrl;
            advertAppInfo.apkUrl = this.kfi.apk_url;
            advertAppInfo.cIV = this.kfi.apk_name;
            advertAppInfo.adPosition = this.kfi.pos_name.trim();
            advertAppInfo.bhs = this.kfi.first_name;
            advertAppInfo.cIX = this.kfi.second_name;
            advertAppInfo.cpid = this.kfi.cpid;
            advertAppInfo.abtest = this.kfi.abtest;
            advertAppInfo.cIY = this.kfi.plan_id;
            advertAppInfo.userId = this.kfi.user_id;
            advertAppInfo.cIZ = this.kfi.verify;
            advertAppInfo.price = this.kfi.price;
            advertAppInfo.extensionInfo = this.kfi.ext_info;
            advertAppInfo.cJa = this.kfi.app_time * 1000;
            advertAppInfo.legoCard = this.kfi.legoCard;
            if (this.kfi.goods != null) {
                advertAppInfo.cJb.cJn = this.kfi.goods.pop_window_text;
                advertAppInfo.cJb.cJj = this.kfi.goods.id;
                advertAppInfo.cJb.cJm = this.kfi.goods.thread_pic;
                advertAppInfo.cJb.cJo = this.kfi.goods.goods_style;
                advertAppInfo.cJb.cJk = this.kfi.goods.thread_title;
                advertAppInfo.cJb.cJl = this.kfi.goods.thread_content;
                advertAppInfo.cJb.userName = this.kfi.goods.user_name;
                advertAppInfo.cJb.userPortrait = this.kfi.goods.user_portrait;
                advertAppInfo.cJb.buttonText = this.kfi.goods.button_text;
                advertAppInfo.cJb.cJr = this.kfi.goods.button_url;
                if (this.kfi.goods.thread_pic_list != null && advertAppInfo.cJb.cJs != null) {
                    advertAppInfo.cJb.cJs.addAll(this.kfi.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cJb.cJs) && (se = AdvertAppInfo.a.se(this.kfi.goods.lego_card)) != null && advertAppInfo.cJb.cJs != null) {
                    advertAppInfo.cJb.cJs.addAll(se);
                }
                advertAppInfo.cJb.cJt = this.kfi.goods.video_info;
                advertAppInfo.cJb.tagName = this.kfi.goods.tag_name;
                advertAppInfo.cJb.adSource = this.kfi.goods.ad_source;
                advertAppInfo.cJb.cJu = this.kfi.goods.tag_name_url;
                advertAppInfo.cJb.tagRatio = this.kfi.goods.tagRatio;
                advertAppInfo.cJb.lego_card = this.kfi.goods.lego_card;
                advertAppInfo.cJb.adCloseInfo = this.kfi.goods.adCloseInfo;
            }
            advertAppInfo.page = cJo();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.axy().isShowImages() && this.kfi != null && this.kfi.legoCard != null && !this.kfi.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cIG;
        }
        if (cJn() == 1001 || cJn() == -1001) {
            return AdvertAppInfo.cIG;
        }
        if (cJm() != null) {
            return AdvertAppInfo.cIK;
        }
        return null;
    }
}
