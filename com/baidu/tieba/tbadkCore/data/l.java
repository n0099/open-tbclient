package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aKT;
    public String aKU;
    public String dSg;
    public String forumId;
    private AppData haN;
    public boolean haO = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.haN = new AppData(app);
    }

    public void sL(String str) {
        this.haN = new AppData(str);
    }

    public AppData bwJ() {
        return this.haN;
    }

    public AdvertAppInfo.ILegoAdvert bwK() {
        if (this.haN == null) {
            return null;
        }
        return this.haN.legoCard;
    }

    public String getAdId() {
        return this.haN == null ? "" : this.haN.id;
    }

    public boolean isApp() {
        if (this.haN == null) {
            return false;
        }
        return this.haN.xK();
    }

    public int bwL() {
        if (this.haN == null || this.haN.goods == null) {
            return -1;
        }
        return this.haN.goods.goods_style;
    }

    public int getPosition() {
        if (this.haN == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.h(this.haN.pos_name, 0);
    }

    public AdvertAppInfo bwM() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.haN != null) {
            advertAppInfo.aKX = this.haN;
            advertAppInfo.aKF = this.haN.id;
            advertAppInfo.aKG = this.haN.name;
            advertAppInfo.aKH = this.haN.url_type;
            advertAppInfo.aKI = this.haN.url;
            advertAppInfo.deepUrl = this.haN.deepUrl;
            advertAppInfo.aKJ = this.haN.apk_url;
            advertAppInfo.aKK = this.haN.apk_name;
            advertAppInfo.adPosition = this.haN.pos_name.trim();
            advertAppInfo.aKM = this.haN.first_name;
            advertAppInfo.aKN = this.haN.second_name;
            advertAppInfo.cpid = this.haN.cpid;
            advertAppInfo.abtest = this.haN.abtest;
            advertAppInfo.aKO = this.haN.plan_id;
            advertAppInfo.userId = this.haN.user_id;
            advertAppInfo.aKP = this.haN.verify;
            advertAppInfo.price = this.haN.price;
            advertAppInfo.extensionInfo = this.haN.ext_info;
            advertAppInfo.aKQ = this.haN.app_time * 1000;
            advertAppInfo.legoCard = this.haN.legoCard;
            if (this.haN.goods != null) {
                advertAppInfo.aKR.aLc = this.haN.goods.pop_window_text;
                advertAppInfo.aKR.aKY = this.haN.goods.id;
                advertAppInfo.aKR.aLb = this.haN.goods.thread_pic;
                advertAppInfo.aKR.aLd = this.haN.goods.goods_style;
                advertAppInfo.aKR.aKZ = this.haN.goods.thread_title;
                advertAppInfo.aKR.aLa = this.haN.goods.thread_content;
                advertAppInfo.aKR.userName = this.haN.goods.user_name;
                advertAppInfo.aKR.userPortrait = this.haN.goods.user_portrait;
                advertAppInfo.aKR.buttonText = this.haN.goods.button_text;
                advertAppInfo.aKR.aLg = this.haN.goods.button_url;
                if (this.haN.goods.thread_pic_list != null) {
                    advertAppInfo.aKR.aLh = new ArrayList();
                    advertAppInfo.aKR.aLh.addAll(this.haN.goods.thread_pic_list);
                }
                advertAppInfo.aKR.aLi = this.haN.goods.video_info;
                advertAppInfo.aKR.tagName = this.haN.goods.tag_name;
                advertAppInfo.aKR.adSource = this.haN.goods.ad_source;
                advertAppInfo.aKR.aLj = this.haN.goods.tag_name_url;
                advertAppInfo.aKR.tagRatio = this.haN.goods.tagRatio;
                advertAppInfo.aKR.lego_card = this.haN.goods.lego_card;
            }
            advertAppInfo.aKi = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xo().xu() && this.haN != null && this.haN.legoCard != null && !this.haN.legoCard.isNoPicAd()) {
            return AdvertAppInfo.aKt;
        }
        if (bwL() == 1001 || bwL() == -1001) {
            return AdvertAppInfo.aKt;
        }
        if (bwK() != null) {
            return AdvertAppInfo.aKx;
        }
        return null;
    }
}
