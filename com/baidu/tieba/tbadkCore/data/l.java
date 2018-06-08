package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aea;
    public String aeb;
    public String dwC;
    public String forumId;
    private AppData gIS;
    public boolean gIT = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gIS = new AppData(app);
    }

    public void tM(String str) {
        this.gIS = new AppData(str);
    }

    public AppData bwP() {
        return this.gIS;
    }

    public AdvertAppInfo.ILegoAdvert bwQ() {
        if (this.gIS == null) {
            return null;
        }
        return this.gIS.legoCard;
    }

    public String getAdId() {
        return this.gIS == null ? "" : this.gIS.id;
    }

    public boolean isApp() {
        if (this.gIS == null) {
            return false;
        }
        return this.gIS.tO();
    }

    public int bwR() {
        if (this.gIS == null || this.gIS.goods == null) {
            return -1;
        }
        return this.gIS.goods.goods_style;
    }

    public int getPosition() {
        if (this.gIS == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gIS.pos_name, 0);
    }

    public AdvertAppInfo ok() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gIS != null) {
            advertAppInfo.aee = this.gIS;
            advertAppInfo.adL = this.gIS.id;
            advertAppInfo.adM = this.gIS.name;
            advertAppInfo.adN = this.gIS.url_type;
            advertAppInfo.adO = this.gIS.url;
            advertAppInfo.deepUrl = this.gIS.deepUrl;
            advertAppInfo.adP = this.gIS.apk_url;
            advertAppInfo.adQ = this.gIS.apk_name;
            advertAppInfo.adPosition = this.gIS.pos_name.trim();
            advertAppInfo.adS = this.gIS.first_name;
            advertAppInfo.adT = this.gIS.second_name;
            advertAppInfo.cpid = this.gIS.cpid;
            advertAppInfo.abtest = this.gIS.abtest;
            advertAppInfo.adU = this.gIS.plan_id;
            advertAppInfo.userId = this.gIS.user_id;
            advertAppInfo.adV = this.gIS.verify;
            advertAppInfo.price = this.gIS.price;
            advertAppInfo.extensionInfo = this.gIS.ext_info;
            advertAppInfo.adW = this.gIS.app_time * 1000;
            advertAppInfo.legoCard = this.gIS.legoCard;
            if (this.gIS.goods != null) {
                advertAppInfo.adX.aej = this.gIS.goods.pop_window_text;
                advertAppInfo.adX.aef = this.gIS.goods.id;
                advertAppInfo.adX.aei = this.gIS.goods.thread_pic;
                advertAppInfo.adX.aek = this.gIS.goods.goods_style;
                advertAppInfo.adX.aeg = this.gIS.goods.thread_title;
                advertAppInfo.adX.aeh = this.gIS.goods.thread_content;
                advertAppInfo.adX.userName = this.gIS.goods.user_name;
                advertAppInfo.adX.userPortrait = this.gIS.goods.user_portrait;
                advertAppInfo.adX.buttonText = this.gIS.goods.button_text;
                advertAppInfo.adX.aen = this.gIS.goods.button_url;
                if (this.gIS.goods.thread_pic_list != null) {
                    advertAppInfo.adX.aeo = new ArrayList();
                    advertAppInfo.adX.aeo.addAll(this.gIS.goods.thread_pic_list);
                }
                advertAppInfo.adX.aep = this.gIS.goods.video_info;
                advertAppInfo.adX.tagName = this.gIS.goods.tag_name;
                advertAppInfo.adX.adSource = this.gIS.goods.ad_source;
                advertAppInfo.adX.aeq = this.gIS.goods.tag_name_url;
                advertAppInfo.adX.tagRatio = this.gIS.goods.tagRatio;
                advertAppInfo.adX.lego_card = this.gIS.goods.lego_card;
            }
            advertAppInfo.adp = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.tt().tz() && this.gIS != null && this.gIS.legoCard != null && !this.gIS.legoCard.isNoPicAd()) {
            return AdvertAppInfo.adz;
        }
        if (bwR() == 1001 || bwR() == -1001) {
            return AdvertAppInfo.adz;
        }
        if (bwQ() != null) {
            return AdvertAppInfo.adD;
        }
        return null;
    }
}
