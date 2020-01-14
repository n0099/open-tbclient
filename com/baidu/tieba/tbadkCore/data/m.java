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
    private AppData kfn;
    public boolean kfo = false;
    public boolean kfp = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kfn = new AppData(app);
    }

    public void IM(String str) {
        this.kfn = new AppData(str);
    }

    public AppData cJn() {
        return this.kfn;
    }

    public AdvertAppInfo.ILegoAdvert cJo() {
        if (this.kfn == null) {
            return null;
        }
        return this.kfn.legoCard;
    }

    public String getAdId() {
        return this.kfn == null ? "" : this.kfn.id;
    }

    public boolean isValidate() {
        return this.kfn != null && this.kfn.axZ() == 0;
    }

    public boolean isApp() {
        if (this.kfn == null) {
            return false;
        }
        return this.kfn.aya();
    }

    public int cJp() {
        if (this.kfn == null || this.kfn.goods == null) {
            return -1;
        }
        return this.kfn.goods.goods_style;
    }

    public int getPosition() {
        if (this.kfn == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kfn.pos_name, 0);
    }

    public String cJq() {
        return this.kfo ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo kv() {
        List<String> se;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kfn != null) {
            advertAppInfo.cJi = this.kfn;
            advertAppInfo.cIS = this.kfn.id;
            advertAppInfo.cIT = this.kfn.name;
            advertAppInfo.Eg = this.kfn.url_type;
            advertAppInfo.cIU = this.kfn.url;
            advertAppInfo.deepUrl = this.kfn.deepUrl;
            advertAppInfo.apkUrl = this.kfn.apk_url;
            advertAppInfo.cIV = this.kfn.apk_name;
            advertAppInfo.adPosition = this.kfn.pos_name.trim();
            advertAppInfo.bhs = this.kfn.first_name;
            advertAppInfo.cIX = this.kfn.second_name;
            advertAppInfo.cpid = this.kfn.cpid;
            advertAppInfo.abtest = this.kfn.abtest;
            advertAppInfo.cIY = this.kfn.plan_id;
            advertAppInfo.userId = this.kfn.user_id;
            advertAppInfo.cIZ = this.kfn.verify;
            advertAppInfo.price = this.kfn.price;
            advertAppInfo.extensionInfo = this.kfn.ext_info;
            advertAppInfo.cJa = this.kfn.app_time * 1000;
            advertAppInfo.legoCard = this.kfn.legoCard;
            if (this.kfn.goods != null) {
                advertAppInfo.cJb.cJn = this.kfn.goods.pop_window_text;
                advertAppInfo.cJb.cJj = this.kfn.goods.id;
                advertAppInfo.cJb.cJm = this.kfn.goods.thread_pic;
                advertAppInfo.cJb.cJo = this.kfn.goods.goods_style;
                advertAppInfo.cJb.cJk = this.kfn.goods.thread_title;
                advertAppInfo.cJb.cJl = this.kfn.goods.thread_content;
                advertAppInfo.cJb.userName = this.kfn.goods.user_name;
                advertAppInfo.cJb.userPortrait = this.kfn.goods.user_portrait;
                advertAppInfo.cJb.buttonText = this.kfn.goods.button_text;
                advertAppInfo.cJb.cJr = this.kfn.goods.button_url;
                if (this.kfn.goods.thread_pic_list != null && advertAppInfo.cJb.cJs != null) {
                    advertAppInfo.cJb.cJs.addAll(this.kfn.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cJb.cJs) && (se = AdvertAppInfo.a.se(this.kfn.goods.lego_card)) != null && advertAppInfo.cJb.cJs != null) {
                    advertAppInfo.cJb.cJs.addAll(se);
                }
                advertAppInfo.cJb.cJt = this.kfn.goods.video_info;
                advertAppInfo.cJb.tagName = this.kfn.goods.tag_name;
                advertAppInfo.cJb.adSource = this.kfn.goods.ad_source;
                advertAppInfo.cJb.cJu = this.kfn.goods.tag_name_url;
                advertAppInfo.cJb.tagRatio = this.kfn.goods.tagRatio;
                advertAppInfo.cJb.lego_card = this.kfn.goods.lego_card;
                advertAppInfo.cJb.adCloseInfo = this.kfn.goods.adCloseInfo;
            }
            advertAppInfo.page = cJq();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.axy().isShowImages() && this.kfn != null && this.kfn.legoCard != null && !this.kfn.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cIG;
        }
        if (cJp() == 1001 || cJp() == -1001) {
            return AdvertAppInfo.cIG;
        }
        if (cJo() != null) {
            return AdvertAppInfo.cIK;
        }
        return null;
    }
}
