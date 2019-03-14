package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bwQ;
    public String bwR;
    public String forumId;
    public String fpX;
    private AppData iFY;
    public boolean iFZ = false;
    public boolean iGa = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iFY = new AppData(app);
    }

    public void Cy(String str) {
        this.iFY = new AppData(str);
    }

    public AppData ceh() {
        return this.iFY;
    }

    public AdvertAppInfo.ILegoAdvert cei() {
        if (this.iFY == null) {
            return null;
        }
        return this.iFY.legoCard;
    }

    public String getAdId() {
        return this.iFY == null ? "" : this.iFY.id;
    }

    public boolean axu() {
        return this.iFY != null && this.iFY.Xa() == 0;
    }

    public boolean isApp() {
        if (this.iFY == null) {
            return false;
        }
        return this.iFY.Xb();
    }

    public int cej() {
        if (this.iFY == null || this.iFY.goods == null) {
            return -1;
        }
        return this.iFY.goods.goods_style;
    }

    public int getPosition() {
        if (this.iFY == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.iFY.pos_name, 0);
    }

    public String cek() {
        return this.iFZ ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pR() {
        List<String> kY;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iFY != null) {
            advertAppInfo.bwU = this.iFY;
            advertAppInfo.bwD = this.iFY.id;
            advertAppInfo.bwE = this.iFY.name;
            advertAppInfo.Ux = this.iFY.url_type;
            advertAppInfo.bwF = this.iFY.url;
            advertAppInfo.deepUrl = this.iFY.deepUrl;
            advertAppInfo.bwG = this.iFY.apk_url;
            advertAppInfo.bwH = this.iFY.apk_name;
            advertAppInfo.adPosition = this.iFY.pos_name.trim();
            advertAppInfo.anC = this.iFY.first_name;
            advertAppInfo.bwJ = this.iFY.second_name;
            advertAppInfo.cpid = this.iFY.cpid;
            advertAppInfo.abtest = this.iFY.abtest;
            advertAppInfo.bwK = this.iFY.plan_id;
            advertAppInfo.userId = this.iFY.user_id;
            advertAppInfo.bwL = this.iFY.verify;
            advertAppInfo.price = this.iFY.price;
            advertAppInfo.extensionInfo = this.iFY.ext_info;
            advertAppInfo.bwM = this.iFY.app_time * 1000;
            advertAppInfo.legoCard = this.iFY.legoCard;
            if (this.iFY.goods != null) {
                advertAppInfo.bwN.bwZ = this.iFY.goods.pop_window_text;
                advertAppInfo.bwN.bwV = this.iFY.goods.id;
                advertAppInfo.bwN.bwY = this.iFY.goods.thread_pic;
                advertAppInfo.bwN.bxa = this.iFY.goods.goods_style;
                advertAppInfo.bwN.bwW = this.iFY.goods.thread_title;
                advertAppInfo.bwN.bwX = this.iFY.goods.thread_content;
                advertAppInfo.bwN.userName = this.iFY.goods.user_name;
                advertAppInfo.bwN.userPortrait = this.iFY.goods.user_portrait;
                advertAppInfo.bwN.buttonText = this.iFY.goods.button_text;
                advertAppInfo.bwN.bxd = this.iFY.goods.button_url;
                if (this.iFY.goods.thread_pic_list != null && advertAppInfo.bwN.bxe != null) {
                    advertAppInfo.bwN.bxe.addAll(this.iFY.goods.thread_pic_list);
                }
                if (v.T(advertAppInfo.bwN.bxe) && (kY = AdvertAppInfo.a.kY(this.iFY.goods.lego_card)) != null && advertAppInfo.bwN.bxe != null) {
                    advertAppInfo.bwN.bxe.addAll(kY);
                }
                advertAppInfo.bwN.bxf = this.iFY.goods.video_info;
                advertAppInfo.bwN.tagName = this.iFY.goods.tag_name;
                advertAppInfo.bwN.adSource = this.iFY.goods.ad_source;
                advertAppInfo.bwN.bxg = this.iFY.goods.tag_name_url;
                advertAppInfo.bwN.tagRatio = this.iFY.goods.tagRatio;
                advertAppInfo.bwN.lego_card = this.iFY.goods.lego_card;
                advertAppInfo.bwN.adCloseInfo = this.iFY.goods.adCloseInfo;
            }
            advertAppInfo.page = cek();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.Wy().WC() && this.iFY != null && this.iFY.legoCard != null && !this.iFY.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bwr;
        }
        if (cej() == 1001 || cej() == -1001) {
            return AdvertAppInfo.bwr;
        }
        if (cei() != null) {
            return AdvertAppInfo.bwv;
        }
        return null;
    }
}
