package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String apE;
    public String apF;
    public String dYT;
    public String forumId;
    private AppData hlj;
    public boolean hlk = false;
    public boolean hll = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hlj = new AppData(app);
    }

    public void vC(String str) {
        this.hlj = new AppData(str);
    }

    public AppData bDf() {
        return this.hlj;
    }

    public AdvertAppInfo.ILegoAdvert bDg() {
        if (this.hlj == null) {
            return null;
        }
        return this.hlj.legoCard;
    }

    public String getAdId() {
        return this.hlj == null ? "" : this.hlj.id;
    }

    public boolean isApp() {
        if (this.hlj == null) {
            return false;
        }
        return this.hlj.yd();
    }

    public int bDh() {
        if (this.hlj == null || this.hlj.goods == null) {
            return -1;
        }
        return this.hlj.goods.goods_style;
    }

    public int getPosition() {
        if (this.hlj == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hlj.pos_name, 0);
    }

    public String bDi() {
        return this.hlk ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pu() {
        List<String> ef;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hlj != null) {
            advertAppInfo.apI = this.hlj;
            advertAppInfo.apq = this.hlj.id;
            advertAppInfo.apr = this.hlj.name;
            advertAppInfo.aps = this.hlj.url_type;
            advertAppInfo.apt = this.hlj.url;
            advertAppInfo.deepUrl = this.hlj.deepUrl;
            advertAppInfo.apu = this.hlj.apk_url;
            advertAppInfo.apv = this.hlj.apk_name;
            advertAppInfo.adPosition = this.hlj.pos_name.trim();
            advertAppInfo.firstName = this.hlj.first_name;
            advertAppInfo.apx = this.hlj.second_name;
            advertAppInfo.cpid = this.hlj.cpid;
            advertAppInfo.abtest = this.hlj.abtest;
            advertAppInfo.apy = this.hlj.plan_id;
            advertAppInfo.userId = this.hlj.user_id;
            advertAppInfo.apz = this.hlj.verify;
            advertAppInfo.price = this.hlj.price;
            advertAppInfo.extensionInfo = this.hlj.ext_info;
            advertAppInfo.apA = this.hlj.app_time * 1000;
            advertAppInfo.legoCard = this.hlj.legoCard;
            if (this.hlj.goods != null) {
                advertAppInfo.apB.apN = this.hlj.goods.pop_window_text;
                advertAppInfo.apB.apJ = this.hlj.goods.id;
                advertAppInfo.apB.apM = this.hlj.goods.thread_pic;
                advertAppInfo.apB.apO = this.hlj.goods.goods_style;
                advertAppInfo.apB.apK = this.hlj.goods.thread_title;
                advertAppInfo.apB.apL = this.hlj.goods.thread_content;
                advertAppInfo.apB.userName = this.hlj.goods.user_name;
                advertAppInfo.apB.userPortrait = this.hlj.goods.user_portrait;
                advertAppInfo.apB.buttonText = this.hlj.goods.button_text;
                advertAppInfo.apB.apR = this.hlj.goods.button_url;
                if (this.hlj.goods.thread_pic_list != null && advertAppInfo.apB.apS != null) {
                    advertAppInfo.apB.apS.addAll(this.hlj.goods.thread_pic_list);
                }
                if (v.I(advertAppInfo.apB.apS) && (ef = advertAppInfo.apB.ef(this.hlj.goods.lego_card)) != null && advertAppInfo.apB.apS != null) {
                    advertAppInfo.apB.apS.addAll(ef);
                }
                advertAppInfo.apB.apT = this.hlj.goods.video_info;
                advertAppInfo.apB.tagName = this.hlj.goods.tag_name;
                advertAppInfo.apB.adSource = this.hlj.goods.ad_source;
                advertAppInfo.apB.apU = this.hlj.goods.tag_name_url;
                advertAppInfo.apB.tagRatio = this.hlj.goods.tagRatio;
                advertAppInfo.apB.lego_card = this.hlj.goods.lego_card;
                advertAppInfo.apB.adCloseInfo = this.hlj.goods.adCloseInfo;
            }
            advertAppInfo.page = bDi();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xE().xI() && this.hlj != null && this.hlj.legoCard != null && !this.hlj.legoCard.isNoPicAd()) {
            return AdvertAppInfo.apd;
        }
        if (bDh() == 1001 || bDh() == -1001) {
            return AdvertAppInfo.apd;
        }
        if (bDg() != null) {
            return AdvertAppInfo.aph;
        }
        return null;
    }
}
