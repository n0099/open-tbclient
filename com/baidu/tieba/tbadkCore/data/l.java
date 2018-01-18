package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aJx;
    public String aJy;
    public String dOI;
    public String forumId;
    private AppData gYd;
    public boolean gYe = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gYd = new AppData(app);
    }

    public void sw(String str) {
        this.gYd = new AppData(str);
    }

    public AppData bvv() {
        return this.gYd;
    }

    public AdvertAppInfo.ILegoAdvert bvw() {
        if (this.gYd == null) {
            return null;
        }
        return this.gYd.legoCard;
    }

    public String getAdId() {
        return this.gYd == null ? "" : this.gYd.id;
    }

    public boolean isApp() {
        if (this.gYd == null) {
            return false;
        }
        return this.gYd.wZ();
    }

    public int bvx() {
        if (this.gYd == null || this.gYd.goods == null) {
            return -1;
        }
        return this.gYd.goods.goods_style;
    }

    public int getPosition() {
        if (this.gYd == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.h(this.gYd.pos_name, 0);
    }

    public AdvertAppInfo bvy() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gYd != null) {
            advertAppInfo.aJB = this.gYd;
            advertAppInfo.aJj = this.gYd.id;
            advertAppInfo.aJk = this.gYd.name;
            advertAppInfo.aJl = this.gYd.url_type;
            advertAppInfo.aJm = this.gYd.url;
            advertAppInfo.deepUrl = this.gYd.deepUrl;
            advertAppInfo.aJn = this.gYd.apk_url;
            advertAppInfo.aJo = this.gYd.apk_name;
            advertAppInfo.adPosition = this.gYd.pos_name.trim();
            advertAppInfo.aJq = this.gYd.first_name;
            advertAppInfo.aJr = this.gYd.second_name;
            advertAppInfo.cpid = this.gYd.cpid;
            advertAppInfo.abtest = this.gYd.abtest;
            advertAppInfo.aJs = this.gYd.plan_id;
            advertAppInfo.userId = this.gYd.user_id;
            advertAppInfo.aJt = this.gYd.verify;
            advertAppInfo.price = this.gYd.price;
            advertAppInfo.extensionInfo = this.gYd.ext_info;
            advertAppInfo.aJu = this.gYd.app_time * 1000;
            advertAppInfo.legoCard = this.gYd.legoCard;
            if (this.gYd.goods != null) {
                advertAppInfo.aJv.aJG = this.gYd.goods.pop_window_text;
                advertAppInfo.aJv.aJC = this.gYd.goods.id;
                advertAppInfo.aJv.aJF = this.gYd.goods.thread_pic;
                advertAppInfo.aJv.aJH = this.gYd.goods.goods_style;
                advertAppInfo.aJv.aJD = this.gYd.goods.thread_title;
                advertAppInfo.aJv.aJE = this.gYd.goods.thread_content;
                advertAppInfo.aJv.userName = this.gYd.goods.user_name;
                advertAppInfo.aJv.userPortrait = this.gYd.goods.user_portrait;
                advertAppInfo.aJv.buttonText = this.gYd.goods.button_text;
                advertAppInfo.aJv.aJK = this.gYd.goods.button_url;
                if (this.gYd.goods.thread_pic_list != null) {
                    advertAppInfo.aJv.aJL = new ArrayList();
                    advertAppInfo.aJv.aJL.addAll(this.gYd.goods.thread_pic_list);
                }
                advertAppInfo.aJv.aJM = this.gYd.goods.video_info;
                advertAppInfo.aJv.tagName = this.gYd.goods.tag_name;
                advertAppInfo.aJv.adSource = this.gYd.goods.ad_source;
                advertAppInfo.aJv.aJN = this.gYd.goods.tag_name_url;
                advertAppInfo.aJv.tagRatio = this.gYd.goods.tagRatio;
                advertAppInfo.aJv.lego_card = this.gYd.goods.lego_card;
            }
            advertAppInfo.aIM = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.wA().wG() && this.gYd != null && this.gYd.legoCard != null && !this.gYd.legoCard.isNoPicAd()) {
            return AdvertAppInfo.aIX;
        }
        if (bvx() == 1001 || bvx() == -1001) {
            return AdvertAppInfo.aIX;
        }
        if (bvw() != null) {
            return AdvertAppInfo.aJb;
        }
        return null;
    }
}
