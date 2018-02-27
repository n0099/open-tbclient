package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aKI;
    public String aKJ;
    public String dRU;
    public String forumId;
    private AppData hay;
    public boolean haz = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hay = new AppData(app);
    }

    public void sL(String str) {
        this.hay = new AppData(str);
    }

    public AppData bwI() {
        return this.hay;
    }

    public AdvertAppInfo.ILegoAdvert bwJ() {
        if (this.hay == null) {
            return null;
        }
        return this.hay.legoCard;
    }

    public String getAdId() {
        return this.hay == null ? "" : this.hay.id;
    }

    public boolean isApp() {
        if (this.hay == null) {
            return false;
        }
        return this.hay.xK();
    }

    public int bwK() {
        if (this.hay == null || this.hay.goods == null) {
            return -1;
        }
        return this.hay.goods.goods_style;
    }

    public int getPosition() {
        if (this.hay == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.h(this.hay.pos_name, 0);
    }

    public AdvertAppInfo bwL() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hay != null) {
            advertAppInfo.aKM = this.hay;
            advertAppInfo.aKu = this.hay.id;
            advertAppInfo.aKv = this.hay.name;
            advertAppInfo.aKw = this.hay.url_type;
            advertAppInfo.aKx = this.hay.url;
            advertAppInfo.deepUrl = this.hay.deepUrl;
            advertAppInfo.aKy = this.hay.apk_url;
            advertAppInfo.aKz = this.hay.apk_name;
            advertAppInfo.adPosition = this.hay.pos_name.trim();
            advertAppInfo.aKB = this.hay.first_name;
            advertAppInfo.aKC = this.hay.second_name;
            advertAppInfo.cpid = this.hay.cpid;
            advertAppInfo.abtest = this.hay.abtest;
            advertAppInfo.aKD = this.hay.plan_id;
            advertAppInfo.userId = this.hay.user_id;
            advertAppInfo.aKE = this.hay.verify;
            advertAppInfo.price = this.hay.price;
            advertAppInfo.extensionInfo = this.hay.ext_info;
            advertAppInfo.aKF = this.hay.app_time * 1000;
            advertAppInfo.legoCard = this.hay.legoCard;
            if (this.hay.goods != null) {
                advertAppInfo.aKG.aKR = this.hay.goods.pop_window_text;
                advertAppInfo.aKG.aKN = this.hay.goods.id;
                advertAppInfo.aKG.aKQ = this.hay.goods.thread_pic;
                advertAppInfo.aKG.aKS = this.hay.goods.goods_style;
                advertAppInfo.aKG.aKO = this.hay.goods.thread_title;
                advertAppInfo.aKG.aKP = this.hay.goods.thread_content;
                advertAppInfo.aKG.userName = this.hay.goods.user_name;
                advertAppInfo.aKG.userPortrait = this.hay.goods.user_portrait;
                advertAppInfo.aKG.buttonText = this.hay.goods.button_text;
                advertAppInfo.aKG.aKV = this.hay.goods.button_url;
                if (this.hay.goods.thread_pic_list != null) {
                    advertAppInfo.aKG.aKW = new ArrayList();
                    advertAppInfo.aKG.aKW.addAll(this.hay.goods.thread_pic_list);
                }
                advertAppInfo.aKG.aKX = this.hay.goods.video_info;
                advertAppInfo.aKG.tagName = this.hay.goods.tag_name;
                advertAppInfo.aKG.adSource = this.hay.goods.ad_source;
                advertAppInfo.aKG.aKY = this.hay.goods.tag_name_url;
                advertAppInfo.aKG.tagRatio = this.hay.goods.tagRatio;
                advertAppInfo.aKG.lego_card = this.hay.goods.lego_card;
            }
            advertAppInfo.aJX = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xo().xu() && this.hay != null && this.hay.legoCard != null && !this.hay.legoCard.isNoPicAd()) {
            return AdvertAppInfo.aKi;
        }
        if (bwK() == 1001 || bwK() == -1001) {
            return AdvertAppInfo.aKi;
        }
        if (bwJ() != null) {
            return AdvertAppInfo.aKm;
        }
        return null;
    }
}
