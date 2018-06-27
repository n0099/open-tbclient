package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.w;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aep;
    public String aeq;
    public String dzO;
    public String forumId;
    private AppData gMS;
    public boolean gMT = false;
    public boolean gMU = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gMS = new AppData(app);
    }

    public void tL(String str) {
        this.gMS = new AppData(str);
    }

    public AppData bxq() {
        return this.gMS;
    }

    public AdvertAppInfo.ILegoAdvert bxr() {
        if (this.gMS == null) {
            return null;
        }
        return this.gMS.legoCard;
    }

    public String getAdId() {
        return this.gMS == null ? "" : this.gMS.id;
    }

    public boolean isApp() {
        if (this.gMS == null) {
            return false;
        }
        return this.gMS.tU();
    }

    public int bxs() {
        if (this.gMS == null || this.gMS.goods == null) {
            return -1;
        }
        return this.gMS.goods.goods_style;
    }

    public int getPosition() {
        if (this.gMS == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gMS.pos_name, 0);
    }

    public String bxt() {
        return this.gMT ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo ok() {
        List<String> dh;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gMS != null) {
            advertAppInfo.aet = this.gMS;
            advertAppInfo.aea = this.gMS.id;
            advertAppInfo.aeb = this.gMS.name;
            advertAppInfo.aec = this.gMS.url_type;
            advertAppInfo.aed = this.gMS.url;
            advertAppInfo.deepUrl = this.gMS.deepUrl;
            advertAppInfo.aee = this.gMS.apk_url;
            advertAppInfo.aef = this.gMS.apk_name;
            advertAppInfo.adPosition = this.gMS.pos_name.trim();
            advertAppInfo.aeh = this.gMS.first_name;
            advertAppInfo.aei = this.gMS.second_name;
            advertAppInfo.cpid = this.gMS.cpid;
            advertAppInfo.abtest = this.gMS.abtest;
            advertAppInfo.aej = this.gMS.plan_id;
            advertAppInfo.userId = this.gMS.user_id;
            advertAppInfo.aek = this.gMS.verify;
            advertAppInfo.price = this.gMS.price;
            advertAppInfo.extensionInfo = this.gMS.ext_info;
            advertAppInfo.ael = this.gMS.app_time * 1000;
            advertAppInfo.legoCard = this.gMS.legoCard;
            if (this.gMS.goods != null) {
                advertAppInfo.aem.aey = this.gMS.goods.pop_window_text;
                advertAppInfo.aem.aeu = this.gMS.goods.id;
                advertAppInfo.aem.aex = this.gMS.goods.thread_pic;
                advertAppInfo.aem.aez = this.gMS.goods.goods_style;
                advertAppInfo.aem.aev = this.gMS.goods.thread_title;
                advertAppInfo.aem.aew = this.gMS.goods.thread_content;
                advertAppInfo.aem.userName = this.gMS.goods.user_name;
                advertAppInfo.aem.userPortrait = this.gMS.goods.user_portrait;
                advertAppInfo.aem.buttonText = this.gMS.goods.button_text;
                advertAppInfo.aem.aeC = this.gMS.goods.button_url;
                if (this.gMS.goods.thread_pic_list != null && advertAppInfo.aem.aeD != null) {
                    advertAppInfo.aem.aeD.addAll(this.gMS.goods.thread_pic_list);
                }
                if (w.A(advertAppInfo.aem.aeD) && (dh = advertAppInfo.aem.dh(this.gMS.goods.lego_card)) != null && advertAppInfo.aem.aeD != null) {
                    advertAppInfo.aem.aeD.addAll(dh);
                }
                advertAppInfo.aem.aeE = this.gMS.goods.video_info;
                advertAppInfo.aem.tagName = this.gMS.goods.tag_name;
                advertAppInfo.aem.adSource = this.gMS.goods.ad_source;
                advertAppInfo.aem.aeF = this.gMS.goods.tag_name_url;
                advertAppInfo.aem.tagRatio = this.gMS.goods.tagRatio;
                advertAppInfo.aem.lego_card = this.gMS.goods.lego_card;
            }
            advertAppInfo.adE = bxt();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.tt().tz() && this.gMS != null && this.gMS.legoCard != null && !this.gMS.legoCard.isNoPicAd()) {
            return AdvertAppInfo.adO;
        }
        if (bxs() == 1001 || bxs() == -1001) {
            return AdvertAppInfo.adO;
        }
        if (bxr() != null) {
            return AdvertAppInfo.adS;
        }
        return null;
    }
}
