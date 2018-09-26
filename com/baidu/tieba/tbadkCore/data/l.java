package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String agu;
    public String agv;
    public String dJn;
    public String forumId;
    private AppData gVw;
    public boolean gVx = false;
    public boolean gVy = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gVw = new AppData(app);
    }

    public void uu(String str) {
        this.gVw = new AppData(str);
    }

    public AppData byA() {
        return this.gVw;
    }

    public AdvertAppInfo.ILegoAdvert byB() {
        if (this.gVw == null) {
            return null;
        }
        return this.gVw.legoCard;
    }

    public String getAdId() {
        return this.gVw == null ? "" : this.gVw.id;
    }

    public boolean isApp() {
        if (this.gVw == null) {
            return false;
        }
        return this.gVw.uI();
    }

    public int byC() {
        if (this.gVw == null || this.gVw.goods == null) {
            return -1;
        }
        return this.gVw.goods.goods_style;
    }

    public int getPosition() {
        if (this.gVw == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.gVw.pos_name, 0);
    }

    public String byD() {
        return this.gVx ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pp() {
        List<String> dx;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gVw != null) {
            advertAppInfo.agy = this.gVw;
            advertAppInfo.agf = this.gVw.id;
            advertAppInfo.agg = this.gVw.name;
            advertAppInfo.agh = this.gVw.url_type;
            advertAppInfo.agi = this.gVw.url;
            advertAppInfo.deepUrl = this.gVw.deepUrl;
            advertAppInfo.agj = this.gVw.apk_url;
            advertAppInfo.agk = this.gVw.apk_name;
            advertAppInfo.adPosition = this.gVw.pos_name.trim();
            advertAppInfo.agm = this.gVw.first_name;
            advertAppInfo.agn = this.gVw.second_name;
            advertAppInfo.cpid = this.gVw.cpid;
            advertAppInfo.abtest = this.gVw.abtest;
            advertAppInfo.ago = this.gVw.plan_id;
            advertAppInfo.userId = this.gVw.user_id;
            advertAppInfo.agp = this.gVw.verify;
            advertAppInfo.price = this.gVw.price;
            advertAppInfo.extensionInfo = this.gVw.ext_info;
            advertAppInfo.agq = this.gVw.app_time * 1000;
            advertAppInfo.legoCard = this.gVw.legoCard;
            if (this.gVw.goods != null) {
                advertAppInfo.agr.agD = this.gVw.goods.pop_window_text;
                advertAppInfo.agr.agz = this.gVw.goods.id;
                advertAppInfo.agr.agC = this.gVw.goods.thread_pic;
                advertAppInfo.agr.agE = this.gVw.goods.goods_style;
                advertAppInfo.agr.agA = this.gVw.goods.thread_title;
                advertAppInfo.agr.agB = this.gVw.goods.thread_content;
                advertAppInfo.agr.userName = this.gVw.goods.user_name;
                advertAppInfo.agr.userPortrait = this.gVw.goods.user_portrait;
                advertAppInfo.agr.buttonText = this.gVw.goods.button_text;
                advertAppInfo.agr.agH = this.gVw.goods.button_url;
                if (this.gVw.goods.thread_pic_list != null && advertAppInfo.agr.agI != null) {
                    advertAppInfo.agr.agI.addAll(this.gVw.goods.thread_pic_list);
                }
                if (v.z(advertAppInfo.agr.agI) && (dx = advertAppInfo.agr.dx(this.gVw.goods.lego_card)) != null && advertAppInfo.agr.agI != null) {
                    advertAppInfo.agr.agI.addAll(dx);
                }
                advertAppInfo.agr.agJ = this.gVw.goods.video_info;
                advertAppInfo.agr.tagName = this.gVw.goods.tag_name;
                advertAppInfo.agr.adSource = this.gVw.goods.ad_source;
                advertAppInfo.agr.agK = this.gVw.goods.tag_name_url;
                advertAppInfo.agr.tagRatio = this.gVw.goods.tagRatio;
                advertAppInfo.agr.lego_card = this.gVw.goods.lego_card;
                advertAppInfo.agr.adCloseInfo = this.gVw.goods.adCloseInfo;
            }
            advertAppInfo.page = byD();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.uj().un() && this.gVw != null && this.gVw.legoCard != null && !this.gVw.legoCard.isNoPicAd()) {
            return AdvertAppInfo.afS;
        }
        if (byC() == 1001 || byC() == -1001) {
            return AdvertAppInfo.afS;
        }
        if (byB() != null) {
            return AdvertAppInfo.afW;
        }
        return null;
    }
}
