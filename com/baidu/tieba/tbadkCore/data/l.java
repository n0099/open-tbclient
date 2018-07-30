package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.w;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String adT;
    public String adU;
    public String dCA;
    public String forumId;
    private AppData gNQ;
    public boolean gNR = false;
    public boolean gNS = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gNQ = new AppData(app);
    }

    public void tJ(String str) {
        this.gNQ = new AppData(str);
    }

    public AppData bvT() {
        return this.gNQ;
    }

    public AdvertAppInfo.ILegoAdvert bvU() {
        if (this.gNQ == null) {
            return null;
        }
        return this.gNQ.legoCard;
    }

    public String getAdId() {
        return this.gNQ == null ? "" : this.gNQ.id;
    }

    public boolean isApp() {
        if (this.gNQ == null) {
            return false;
        }
        return this.gNQ.tG();
    }

    public int bvV() {
        if (this.gNQ == null || this.gNQ.goods == null) {
            return -1;
        }
        return this.gNQ.goods.goods_style;
    }

    public int getPosition() {
        if (this.gNQ == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gNQ.pos_name, 0);
    }

    public String bvW() {
        return this.gNR ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo om() {
        List<String> de;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gNQ != null) {
            advertAppInfo.adX = this.gNQ;
            advertAppInfo.adE = this.gNQ.id;
            advertAppInfo.adF = this.gNQ.name;
            advertAppInfo.adG = this.gNQ.url_type;
            advertAppInfo.adH = this.gNQ.url;
            advertAppInfo.deepUrl = this.gNQ.deepUrl;
            advertAppInfo.adI = this.gNQ.apk_url;
            advertAppInfo.adJ = this.gNQ.apk_name;
            advertAppInfo.adPosition = this.gNQ.pos_name.trim();
            advertAppInfo.adL = this.gNQ.first_name;
            advertAppInfo.adM = this.gNQ.second_name;
            advertAppInfo.cpid = this.gNQ.cpid;
            advertAppInfo.abtest = this.gNQ.abtest;
            advertAppInfo.adN = this.gNQ.plan_id;
            advertAppInfo.userId = this.gNQ.user_id;
            advertAppInfo.adO = this.gNQ.verify;
            advertAppInfo.price = this.gNQ.price;
            advertAppInfo.extensionInfo = this.gNQ.ext_info;
            advertAppInfo.adP = this.gNQ.app_time * 1000;
            advertAppInfo.legoCard = this.gNQ.legoCard;
            if (this.gNQ.goods != null) {
                advertAppInfo.adQ.aec = this.gNQ.goods.pop_window_text;
                advertAppInfo.adQ.adY = this.gNQ.goods.id;
                advertAppInfo.adQ.aeb = this.gNQ.goods.thread_pic;
                advertAppInfo.adQ.aed = this.gNQ.goods.goods_style;
                advertAppInfo.adQ.adZ = this.gNQ.goods.thread_title;
                advertAppInfo.adQ.aea = this.gNQ.goods.thread_content;
                advertAppInfo.adQ.userName = this.gNQ.goods.user_name;
                advertAppInfo.adQ.userPortrait = this.gNQ.goods.user_portrait;
                advertAppInfo.adQ.buttonText = this.gNQ.goods.button_text;
                advertAppInfo.adQ.aeg = this.gNQ.goods.button_url;
                if (this.gNQ.goods.thread_pic_list != null && advertAppInfo.adQ.aeh != null) {
                    advertAppInfo.adQ.aeh.addAll(this.gNQ.goods.thread_pic_list);
                }
                if (w.z(advertAppInfo.adQ.aeh) && (de = advertAppInfo.adQ.de(this.gNQ.goods.lego_card)) != null && advertAppInfo.adQ.aeh != null) {
                    advertAppInfo.adQ.aeh.addAll(de);
                }
                advertAppInfo.adQ.aei = this.gNQ.goods.video_info;
                advertAppInfo.adQ.tagName = this.gNQ.goods.tag_name;
                advertAppInfo.adQ.adSource = this.gNQ.goods.ad_source;
                advertAppInfo.adQ.aej = this.gNQ.goods.tag_name_url;
                advertAppInfo.adQ.tagRatio = this.gNQ.goods.tagRatio;
                advertAppInfo.adQ.lego_card = this.gNQ.goods.lego_card;
                advertAppInfo.adQ.adCloseInfo = this.gNQ.goods.adCloseInfo;
            }
            advertAppInfo.adi = bvW();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.te().tk() && this.gNQ != null && this.gNQ.legoCard != null && !this.gNQ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.ads;
        }
        if (bvV() == 1001 || bvV() == -1001) {
            return AdvertAppInfo.ads;
        }
        if (bvU() != null) {
            return AdvertAppInfo.adw;
        }
        return null;
    }
}
