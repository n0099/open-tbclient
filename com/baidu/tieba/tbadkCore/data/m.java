package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String aKJ;
    public String aKK;
    public String dRZ;
    public String forumId;
    private AppData haW;
    public boolean haX = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.haW = new AppData(app);
    }

    public void sL(String str) {
        this.haW = new AppData(str);
    }

    public AppData bwN() {
        return this.haW;
    }

    public AdvertAppInfo.ILegoAdvert bwO() {
        if (this.haW == null) {
            return null;
        }
        return this.haW.legoCard;
    }

    public String getAdId() {
        return this.haW == null ? "" : this.haW.id;
    }

    public boolean isApp() {
        if (this.haW == null) {
            return false;
        }
        return this.haW.xK();
    }

    public int bwP() {
        if (this.haW == null || this.haW.goods == null) {
            return -1;
        }
        return this.haW.goods.goods_style;
    }

    public int getPosition() {
        if (this.haW == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.h(this.haW.pos_name, 0);
    }

    public AdvertAppInfo bwQ() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.haW != null) {
            advertAppInfo.aKN = this.haW;
            advertAppInfo.aKv = this.haW.id;
            advertAppInfo.aKw = this.haW.name;
            advertAppInfo.aKx = this.haW.url_type;
            advertAppInfo.aKy = this.haW.url;
            advertAppInfo.deepUrl = this.haW.deepUrl;
            advertAppInfo.aKz = this.haW.apk_url;
            advertAppInfo.aKA = this.haW.apk_name;
            advertAppInfo.adPosition = this.haW.pos_name.trim();
            advertAppInfo.aKC = this.haW.first_name;
            advertAppInfo.aKD = this.haW.second_name;
            advertAppInfo.cpid = this.haW.cpid;
            advertAppInfo.abtest = this.haW.abtest;
            advertAppInfo.aKE = this.haW.plan_id;
            advertAppInfo.userId = this.haW.user_id;
            advertAppInfo.aKF = this.haW.verify;
            advertAppInfo.price = this.haW.price;
            advertAppInfo.extensionInfo = this.haW.ext_info;
            advertAppInfo.aKG = this.haW.app_time * 1000;
            advertAppInfo.legoCard = this.haW.legoCard;
            if (this.haW.goods != null) {
                advertAppInfo.aKH.aKS = this.haW.goods.pop_window_text;
                advertAppInfo.aKH.aKO = this.haW.goods.id;
                advertAppInfo.aKH.aKR = this.haW.goods.thread_pic;
                advertAppInfo.aKH.aKT = this.haW.goods.goods_style;
                advertAppInfo.aKH.aKP = this.haW.goods.thread_title;
                advertAppInfo.aKH.aKQ = this.haW.goods.thread_content;
                advertAppInfo.aKH.userName = this.haW.goods.user_name;
                advertAppInfo.aKH.userPortrait = this.haW.goods.user_portrait;
                advertAppInfo.aKH.buttonText = this.haW.goods.button_text;
                advertAppInfo.aKH.aKW = this.haW.goods.button_url;
                if (this.haW.goods.thread_pic_list != null) {
                    advertAppInfo.aKH.aKX = new ArrayList();
                    advertAppInfo.aKH.aKX.addAll(this.haW.goods.thread_pic_list);
                }
                advertAppInfo.aKH.aKY = this.haW.goods.video_info;
                advertAppInfo.aKH.tagName = this.haW.goods.tag_name;
                advertAppInfo.aKH.adSource = this.haW.goods.ad_source;
                advertAppInfo.aKH.aKZ = this.haW.goods.tag_name_url;
                advertAppInfo.aKH.tagRatio = this.haW.goods.tagRatio;
                advertAppInfo.aKH.lego_card = this.haW.goods.lego_card;
            }
            advertAppInfo.aJY = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xo().xu() && this.haW != null && this.haW.legoCard != null && !this.haW.legoCard.isNoPicAd()) {
            return AdvertAppInfo.aKj;
        }
        if (bwP() == 1001 || bwP() == -1001) {
            return AdvertAppInfo.aKj;
        }
        if (bwO() != null) {
            return AdvertAppInfo.aKn;
        }
        return null;
    }
}
