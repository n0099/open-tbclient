package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bWG;
    public String bWH;
    public String fMk;
    public String forumId;
    private AppData jhs;
    public boolean jht = false;
    public boolean jhu = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.jhs = new AppData(app);
    }

    public void DN(String str) {
        this.jhs = new AppData(str);
    }

    public AppData cob() {
        return this.jhs;
    }

    public AdvertAppInfo.ILegoAdvert coc() {
        if (this.jhs == null) {
            return null;
        }
        return this.jhs.legoCard;
    }

    public String getAdId() {
        return this.jhs == null ? "" : this.jhs.id;
    }

    public boolean aEE() {
        return this.jhs != null && this.jhs.agP() == 0;
    }

    public boolean isApp() {
        if (this.jhs == null) {
            return false;
        }
        return this.jhs.agQ();
    }

    public int cod() {
        if (this.jhs == null || this.jhs.goods == null) {
            return -1;
        }
        return this.jhs.goods.goods_style;
    }

    public int getPosition() {
        if (this.jhs == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.toInt(this.jhs.pos_name, 0);
    }

    public String coe() {
        return this.jht ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo kd() {
        List<String> mN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.jhs != null) {
            advertAppInfo.bWK = this.jhs;
            advertAppInfo.bWt = this.jhs.id;
            advertAppInfo.bWu = this.jhs.name;
            advertAppInfo.Bv = this.jhs.url_type;
            advertAppInfo.bWv = this.jhs.url;
            advertAppInfo.deepUrl = this.jhs.deepUrl;
            advertAppInfo.bWw = this.jhs.apk_url;
            advertAppInfo.bWx = this.jhs.apk_name;
            advertAppInfo.adPosition = this.jhs.pos_name.trim();
            advertAppInfo.aHT = this.jhs.first_name;
            advertAppInfo.bWz = this.jhs.second_name;
            advertAppInfo.cpid = this.jhs.cpid;
            advertAppInfo.abtest = this.jhs.abtest;
            advertAppInfo.bWA = this.jhs.plan_id;
            advertAppInfo.userId = this.jhs.user_id;
            advertAppInfo.bWB = this.jhs.verify;
            advertAppInfo.price = this.jhs.price;
            advertAppInfo.extensionInfo = this.jhs.ext_info;
            advertAppInfo.bWC = this.jhs.app_time * 1000;
            advertAppInfo.legoCard = this.jhs.legoCard;
            if (this.jhs.goods != null) {
                advertAppInfo.bWD.bWP = this.jhs.goods.pop_window_text;
                advertAppInfo.bWD.bWL = this.jhs.goods.id;
                advertAppInfo.bWD.bWO = this.jhs.goods.thread_pic;
                advertAppInfo.bWD.bWQ = this.jhs.goods.goods_style;
                advertAppInfo.bWD.bWM = this.jhs.goods.thread_title;
                advertAppInfo.bWD.bWN = this.jhs.goods.thread_content;
                advertAppInfo.bWD.userName = this.jhs.goods.user_name;
                advertAppInfo.bWD.userPortrait = this.jhs.goods.user_portrait;
                advertAppInfo.bWD.buttonText = this.jhs.goods.button_text;
                advertAppInfo.bWD.bWT = this.jhs.goods.button_url;
                if (this.jhs.goods.thread_pic_list != null && advertAppInfo.bWD.bWU != null) {
                    advertAppInfo.bWD.bWU.addAll(this.jhs.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.bWD.bWU) && (mN = AdvertAppInfo.a.mN(this.jhs.goods.lego_card)) != null && advertAppInfo.bWD.bWU != null) {
                    advertAppInfo.bWD.bWU.addAll(mN);
                }
                advertAppInfo.bWD.bWV = this.jhs.goods.video_info;
                advertAppInfo.bWD.tagName = this.jhs.goods.tag_name;
                advertAppInfo.bWD.adSource = this.jhs.goods.ad_source;
                advertAppInfo.bWD.bWW = this.jhs.goods.tag_name_url;
                advertAppInfo.bWD.tagRatio = this.jhs.goods.tagRatio;
                advertAppInfo.bWD.lego_card = this.jhs.goods.lego_card;
                advertAppInfo.bWD.adCloseInfo = this.jhs.goods.adCloseInfo;
            }
            advertAppInfo.page = coe();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.ago().isShowImages() && this.jhs != null && this.jhs.legoCard != null && !this.jhs.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bWh;
        }
        if (cod() == 1001 || cod() == -1001) {
            return AdvertAppInfo.bWh;
        }
        if (coc() != null) {
            return AdvertAppInfo.bWl;
        }
        return null;
    }
}
