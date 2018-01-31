package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aJA;
    public String aJB;
    public String dPd;
    public String forumId;
    private AppData gYx;
    public boolean gYy = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gYx = new AppData(app);
    }

    public void sD(String str) {
        this.gYx = new AppData(str);
    }

    public AppData bvx() {
        return this.gYx;
    }

    public AdvertAppInfo.ILegoAdvert bvy() {
        if (this.gYx == null) {
            return null;
        }
        return this.gYx.legoCard;
    }

    public String getAdId() {
        return this.gYx == null ? "" : this.gYx.id;
    }

    public boolean isApp() {
        if (this.gYx == null) {
            return false;
        }
        return this.gYx.xa();
    }

    public int bvz() {
        if (this.gYx == null || this.gYx.goods == null) {
            return -1;
        }
        return this.gYx.goods.goods_style;
    }

    public int getPosition() {
        if (this.gYx == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.h(this.gYx.pos_name, 0);
    }

    public AdvertAppInfo bvA() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gYx != null) {
            advertAppInfo.aJE = this.gYx;
            advertAppInfo.aJm = this.gYx.id;
            advertAppInfo.aJn = this.gYx.name;
            advertAppInfo.aJo = this.gYx.url_type;
            advertAppInfo.aJp = this.gYx.url;
            advertAppInfo.deepUrl = this.gYx.deepUrl;
            advertAppInfo.aJq = this.gYx.apk_url;
            advertAppInfo.aJr = this.gYx.apk_name;
            advertAppInfo.adPosition = this.gYx.pos_name.trim();
            advertAppInfo.aJt = this.gYx.first_name;
            advertAppInfo.aJu = this.gYx.second_name;
            advertAppInfo.cpid = this.gYx.cpid;
            advertAppInfo.abtest = this.gYx.abtest;
            advertAppInfo.aJv = this.gYx.plan_id;
            advertAppInfo.userId = this.gYx.user_id;
            advertAppInfo.aJw = this.gYx.verify;
            advertAppInfo.price = this.gYx.price;
            advertAppInfo.extensionInfo = this.gYx.ext_info;
            advertAppInfo.aJx = this.gYx.app_time * 1000;
            advertAppInfo.legoCard = this.gYx.legoCard;
            if (this.gYx.goods != null) {
                advertAppInfo.aJy.aJJ = this.gYx.goods.pop_window_text;
                advertAppInfo.aJy.aJF = this.gYx.goods.id;
                advertAppInfo.aJy.aJI = this.gYx.goods.thread_pic;
                advertAppInfo.aJy.aJK = this.gYx.goods.goods_style;
                advertAppInfo.aJy.aJG = this.gYx.goods.thread_title;
                advertAppInfo.aJy.aJH = this.gYx.goods.thread_content;
                advertAppInfo.aJy.userName = this.gYx.goods.user_name;
                advertAppInfo.aJy.userPortrait = this.gYx.goods.user_portrait;
                advertAppInfo.aJy.buttonText = this.gYx.goods.button_text;
                advertAppInfo.aJy.aJN = this.gYx.goods.button_url;
                if (this.gYx.goods.thread_pic_list != null) {
                    advertAppInfo.aJy.aJO = new ArrayList();
                    advertAppInfo.aJy.aJO.addAll(this.gYx.goods.thread_pic_list);
                }
                advertAppInfo.aJy.aJP = this.gYx.goods.video_info;
                advertAppInfo.aJy.tagName = this.gYx.goods.tag_name;
                advertAppInfo.aJy.adSource = this.gYx.goods.ad_source;
                advertAppInfo.aJy.aJQ = this.gYx.goods.tag_name_url;
                advertAppInfo.aJy.tagRatio = this.gYx.goods.tagRatio;
                advertAppInfo.aJy.lego_card = this.gYx.goods.lego_card;
            }
            advertAppInfo.aIP = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.wB().wH() && this.gYx != null && this.gYx.legoCard != null && !this.gYx.legoCard.isNoPicAd()) {
            return AdvertAppInfo.aJa;
        }
        if (bvz() == 1001 || bvz() == -1001) {
            return AdvertAppInfo.aJa;
        }
        if (bvy() != null) {
            return AdvertAppInfo.aJe;
        }
        return null;
    }
}
