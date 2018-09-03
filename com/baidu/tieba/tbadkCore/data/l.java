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
    public String dCx;
    public String forumId;
    private AppData gNS;
    public boolean gNT = false;
    public boolean gNU = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gNS = new AppData(app);
    }

    public void tN(String str) {
        this.gNS = new AppData(str);
    }

    public AppData bvU() {
        return this.gNS;
    }

    public AdvertAppInfo.ILegoAdvert bvV() {
        if (this.gNS == null) {
            return null;
        }
        return this.gNS.legoCard;
    }

    public String getAdId() {
        return this.gNS == null ? "" : this.gNS.id;
    }

    public boolean isApp() {
        if (this.gNS == null) {
            return false;
        }
        return this.gNS.tF();
    }

    public int bvW() {
        if (this.gNS == null || this.gNS.goods == null) {
            return -1;
        }
        return this.gNS.goods.goods_style;
    }

    public int getPosition() {
        if (this.gNS == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gNS.pos_name, 0);
    }

    public String bvX() {
        return this.gNT ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo oj() {
        List<String> df;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gNS != null) {
            advertAppInfo.adX = this.gNS;
            advertAppInfo.adE = this.gNS.id;
            advertAppInfo.adF = this.gNS.name;
            advertAppInfo.adG = this.gNS.url_type;
            advertAppInfo.adH = this.gNS.url;
            advertAppInfo.deepUrl = this.gNS.deepUrl;
            advertAppInfo.adI = this.gNS.apk_url;
            advertAppInfo.adJ = this.gNS.apk_name;
            advertAppInfo.adPosition = this.gNS.pos_name.trim();
            advertAppInfo.adL = this.gNS.first_name;
            advertAppInfo.adM = this.gNS.second_name;
            advertAppInfo.cpid = this.gNS.cpid;
            advertAppInfo.abtest = this.gNS.abtest;
            advertAppInfo.adN = this.gNS.plan_id;
            advertAppInfo.userId = this.gNS.user_id;
            advertAppInfo.adO = this.gNS.verify;
            advertAppInfo.price = this.gNS.price;
            advertAppInfo.extensionInfo = this.gNS.ext_info;
            advertAppInfo.adP = this.gNS.app_time * 1000;
            advertAppInfo.legoCard = this.gNS.legoCard;
            if (this.gNS.goods != null) {
                advertAppInfo.adQ.aec = this.gNS.goods.pop_window_text;
                advertAppInfo.adQ.adY = this.gNS.goods.id;
                advertAppInfo.adQ.aeb = this.gNS.goods.thread_pic;
                advertAppInfo.adQ.aed = this.gNS.goods.goods_style;
                advertAppInfo.adQ.adZ = this.gNS.goods.thread_title;
                advertAppInfo.adQ.aea = this.gNS.goods.thread_content;
                advertAppInfo.adQ.userName = this.gNS.goods.user_name;
                advertAppInfo.adQ.userPortrait = this.gNS.goods.user_portrait;
                advertAppInfo.adQ.buttonText = this.gNS.goods.button_text;
                advertAppInfo.adQ.aeg = this.gNS.goods.button_url;
                if (this.gNS.goods.thread_pic_list != null && advertAppInfo.adQ.aeh != null) {
                    advertAppInfo.adQ.aeh.addAll(this.gNS.goods.thread_pic_list);
                }
                if (w.z(advertAppInfo.adQ.aeh) && (df = advertAppInfo.adQ.df(this.gNS.goods.lego_card)) != null && advertAppInfo.adQ.aeh != null) {
                    advertAppInfo.adQ.aeh.addAll(df);
                }
                advertAppInfo.adQ.aei = this.gNS.goods.video_info;
                advertAppInfo.adQ.tagName = this.gNS.goods.tag_name;
                advertAppInfo.adQ.adSource = this.gNS.goods.ad_source;
                advertAppInfo.adQ.aej = this.gNS.goods.tag_name_url;
                advertAppInfo.adQ.tagRatio = this.gNS.goods.tagRatio;
                advertAppInfo.adQ.lego_card = this.gNS.goods.lego_card;
                advertAppInfo.adQ.adCloseInfo = this.gNS.goods.adCloseInfo;
            }
            advertAppInfo.page = bvX();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.td().tj() && this.gNS != null && this.gNS.legoCard != null && !this.gNS.legoCard.isNoPicAd()) {
            return AdvertAppInfo.ads;
        }
        if (bvW() == 1001 || bvW() == -1001) {
            return AdvertAppInfo.ads;
        }
        if (bvV() != null) {
            return AdvertAppInfo.adw;
        }
        return null;
    }
}
