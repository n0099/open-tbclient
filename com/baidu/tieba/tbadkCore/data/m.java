package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bFh;
    public String bFi;
    public String fLT;
    public String forumId;
    private AppData jga;
    public boolean jgb = false;
    public boolean jgc = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.jga = new AppData(app);
    }

    public void EJ(String str) {
        this.jga = new AppData(str);
    }

    public AppData cpz() {
        return this.jga;
    }

    public AdvertAppInfo.ILegoAdvert cpA() {
        if (this.jga == null) {
            return null;
        }
        return this.jga.legoCard;
    }

    public String getAdId() {
        return this.jga == null ? "" : this.jga.id;
    }

    public boolean aDS() {
        return this.jga != null && this.jga.acH() == 0;
    }

    public boolean isApp() {
        if (this.jga == null) {
            return false;
        }
        return this.jga.acI();
    }

    public int cpB() {
        if (this.jga == null || this.jga.goods == null) {
            return -1;
        }
        return this.jga.goods.goods_style;
    }

    public int getPosition() {
        if (this.jga == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.f(this.jga.pos_name, 0);
    }

    public String cpC() {
        return this.jgb ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo ph() {
        List<String> mo;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.jga != null) {
            advertAppInfo.bFl = this.jga;
            advertAppInfo.bEU = this.jga.id;
            advertAppInfo.bEV = this.jga.name;
            advertAppInfo.SB = this.jga.url_type;
            advertAppInfo.bEW = this.jga.url;
            advertAppInfo.deepUrl = this.jga.deepUrl;
            advertAppInfo.bEX = this.jga.apk_url;
            advertAppInfo.bEY = this.jga.apk_name;
            advertAppInfo.adPosition = this.jga.pos_name.trim();
            advertAppInfo.aow = this.jga.first_name;
            advertAppInfo.bFa = this.jga.second_name;
            advertAppInfo.cpid = this.jga.cpid;
            advertAppInfo.abtest = this.jga.abtest;
            advertAppInfo.bFb = this.jga.plan_id;
            advertAppInfo.userId = this.jga.user_id;
            advertAppInfo.bFc = this.jga.verify;
            advertAppInfo.price = this.jga.price;
            advertAppInfo.extensionInfo = this.jga.ext_info;
            advertAppInfo.bFd = this.jga.app_time * 1000;
            advertAppInfo.legoCard = this.jga.legoCard;
            if (this.jga.goods != null) {
                advertAppInfo.bFe.bFq = this.jga.goods.pop_window_text;
                advertAppInfo.bFe.bFm = this.jga.goods.id;
                advertAppInfo.bFe.bFp = this.jga.goods.thread_pic;
                advertAppInfo.bFe.bFr = this.jga.goods.goods_style;
                advertAppInfo.bFe.bFn = this.jga.goods.thread_title;
                advertAppInfo.bFe.bFo = this.jga.goods.thread_content;
                advertAppInfo.bFe.userName = this.jga.goods.user_name;
                advertAppInfo.bFe.userPortrait = this.jga.goods.user_portrait;
                advertAppInfo.bFe.buttonText = this.jga.goods.button_text;
                advertAppInfo.bFe.bFu = this.jga.goods.button_url;
                if (this.jga.goods.thread_pic_list != null && advertAppInfo.bFe.bFv != null) {
                    advertAppInfo.bFe.bFv.addAll(this.jga.goods.thread_pic_list);
                }
                if (v.aa(advertAppInfo.bFe.bFv) && (mo = AdvertAppInfo.a.mo(this.jga.goods.lego_card)) != null && advertAppInfo.bFe.bFv != null) {
                    advertAppInfo.bFe.bFv.addAll(mo);
                }
                advertAppInfo.bFe.bFw = this.jga.goods.video_info;
                advertAppInfo.bFe.tagName = this.jga.goods.tag_name;
                advertAppInfo.bFe.adSource = this.jga.goods.ad_source;
                advertAppInfo.bFe.bFx = this.jga.goods.tag_name_url;
                advertAppInfo.bFe.tagRatio = this.jga.goods.tagRatio;
                advertAppInfo.bFe.lego_card = this.jga.goods.lego_card;
                advertAppInfo.bFe.adCloseInfo = this.jga.goods.adCloseInfo;
            }
            advertAppInfo.page = cpC();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.aca().ace() && this.jga != null && this.jga.legoCard != null && !this.jga.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bEI;
        }
        if (cpB() == 1001 || cpB() == -1001) {
            return AdvertAppInfo.bEI;
        }
        if (cpA() != null) {
            return AdvertAppInfo.bEM;
        }
        return null;
    }
}
