package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String dYF;
    public String dYG;
    public String forumId;
    public String iuL;
    public boolean kUJ;
    private AppData mox;
    public boolean moy = false;
    public boolean moz = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.mox = new AppData(app);
    }

    public void Rm(String str) {
        this.mox = new AppData(str);
    }

    public AppData dAr() {
        return this.mox;
    }

    public AdvertAppInfo.ILegoAdvert dAs() {
        if (this.mox == null) {
            return null;
        }
        return this.mox.legoCard;
    }

    public String getAdId() {
        return this.mox == null ? "" : this.mox.id;
    }

    public boolean isValidate() {
        return this.mox != null && this.mox.bdp() == 0;
    }

    public boolean isApp() {
        if (this.mox == null) {
            return false;
        }
        return this.mox.bdq();
    }

    public int dAt() {
        if (this.mox == null || this.mox.goods == null) {
            return -1;
        }
        return this.mox.goods.goods_style;
    }

    public int getPosition() {
        if (this.mox == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.mox.pos_name, 0);
    }

    public String dAu() {
        if (this.moy) {
            return "PB_BANNER";
        }
        if (this.kUJ) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rq() {
        List<String> zu;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.mox != null) {
            advertAppInfo.dYJ = this.mox;
            advertAppInfo.dYt = this.mox.id;
            advertAppInfo.dYu = this.mox.name;
            advertAppInfo.ZD = this.mox.url_type;
            advertAppInfo.dYv = this.mox.url;
            advertAppInfo.deepUrl = this.mox.deepUrl;
            advertAppInfo.apkUrl = this.mox.apk_url;
            advertAppInfo.dYw = this.mox.apk_name;
            advertAppInfo.adPosition = this.mox.pos_name.trim();
            advertAppInfo.cgz = this.mox.first_name;
            advertAppInfo.dYy = this.mox.second_name;
            advertAppInfo.cpid = this.mox.cpid;
            advertAppInfo.abtest = this.mox.abtest;
            advertAppInfo.dYz = this.mox.plan_id;
            advertAppInfo.userId = this.mox.user_id;
            advertAppInfo.dYA = this.mox.verify;
            advertAppInfo.price = this.mox.price;
            advertAppInfo.extensionInfo = this.mox.ext_info;
            advertAppInfo.dYB = this.mox.app_time * 1000;
            advertAppInfo.legoCard = this.mox.legoCard;
            if (this.mox.goods != null) {
                advertAppInfo.dYC.dYO = this.mox.goods.pop_window_text;
                advertAppInfo.dYC.dYK = this.mox.goods.id;
                advertAppInfo.dYC.dYN = this.mox.goods.thread_pic;
                advertAppInfo.dYC.dYP = this.mox.goods.goods_style;
                advertAppInfo.dYC.dYL = this.mox.goods.thread_title;
                advertAppInfo.dYC.dYM = this.mox.goods.thread_content;
                advertAppInfo.dYC.userName = this.mox.goods.user_name;
                advertAppInfo.dYC.userPortrait = this.mox.goods.user_portrait;
                advertAppInfo.dYC.buttonText = this.mox.goods.button_text;
                advertAppInfo.dYC.dYS = this.mox.goods.button_url;
                if (this.mox.goods.thread_pic_list != null && advertAppInfo.dYC.dYT != null) {
                    advertAppInfo.dYC.dYT.addAll(this.mox.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.dYC.dYT) && (zu = AdvertAppInfo.a.zu(this.mox.goods.lego_card)) != null && advertAppInfo.dYC.dYT != null) {
                    advertAppInfo.dYC.dYT.addAll(zu);
                }
                advertAppInfo.dYC.dYU = this.mox.goods.video_info;
                advertAppInfo.dYC.tagName = this.mox.goods.tag_name;
                advertAppInfo.dYC.adSource = this.mox.goods.ad_source;
                advertAppInfo.dYC.dYV = this.mox.goods.tag_name_url;
                advertAppInfo.dYC.tagRatio = this.mox.goods.tagRatio;
                advertAppInfo.dYC.lego_card = this.mox.goods.lego_card;
                advertAppInfo.dYC.adCloseInfo = this.mox.goods.adCloseInfo;
            }
            advertAppInfo.page = dAu();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bcG().isShowImages() && this.mox != null && this.mox.legoCard != null && !this.mox.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dYh;
        }
        if (dAt() == 1001 || dAt() == -1001) {
            return AdvertAppInfo.dYh;
        }
        if (dAs() != null) {
            return AdvertAppInfo.dYl;
        }
        return null;
    }
}
