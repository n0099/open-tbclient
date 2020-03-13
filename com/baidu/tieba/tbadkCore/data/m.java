package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String cNj;
    public String cNk;
    public String forumId;
    public String gFU;
    public boolean iPs;
    private AppData kgB;
    public boolean kgC = false;
    public boolean kgD = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kgB = new AppData(app);
    }

    public void Jb(String str) {
        this.kgB = new AppData(str);
    }

    public AppData cKP() {
        return this.kgB;
    }

    public AdvertAppInfo.ILegoAdvert cKQ() {
        if (this.kgB == null) {
            return null;
        }
        return this.kgB.legoCard;
    }

    public String getAdId() {
        return this.kgB == null ? "" : this.kgB.id;
    }

    public boolean isValidate() {
        return this.kgB != null && this.kgB.aAp() == 0;
    }

    public boolean isApp() {
        if (this.kgB == null) {
            return false;
        }
        return this.kgB.aAq();
    }

    public int cKR() {
        if (this.kgB == null || this.kgB.goods == null) {
            return -1;
        }
        return this.kgB.goods.goods_style;
    }

    public int getPosition() {
        if (this.kgB == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kgB.pos_name, 0);
    }

    public String cKS() {
        if (this.kgC) {
            return "PB_BANNER";
        }
        if (this.iPs) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo kK() {
        List<String> sv;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kgB != null) {
            advertAppInfo.cNn = this.kgB;
            advertAppInfo.cMX = this.kgB.id;
            advertAppInfo.cMY = this.kgB.name;
            advertAppInfo.Ez = this.kgB.url_type;
            advertAppInfo.cMZ = this.kgB.url;
            advertAppInfo.deepUrl = this.kgB.deepUrl;
            advertAppInfo.apkUrl = this.kgB.apk_url;
            advertAppInfo.cNa = this.kgB.apk_name;
            advertAppInfo.adPosition = this.kgB.pos_name.trim();
            advertAppInfo.blG = this.kgB.first_name;
            advertAppInfo.cNc = this.kgB.second_name;
            advertAppInfo.cpid = this.kgB.cpid;
            advertAppInfo.abtest = this.kgB.abtest;
            advertAppInfo.cNd = this.kgB.plan_id;
            advertAppInfo.userId = this.kgB.user_id;
            advertAppInfo.cNe = this.kgB.verify;
            advertAppInfo.price = this.kgB.price;
            advertAppInfo.extensionInfo = this.kgB.ext_info;
            advertAppInfo.cNf = this.kgB.app_time * 1000;
            advertAppInfo.legoCard = this.kgB.legoCard;
            if (this.kgB.goods != null) {
                advertAppInfo.cNg.cNs = this.kgB.goods.pop_window_text;
                advertAppInfo.cNg.cNo = this.kgB.goods.id;
                advertAppInfo.cNg.cNr = this.kgB.goods.thread_pic;
                advertAppInfo.cNg.cNt = this.kgB.goods.goods_style;
                advertAppInfo.cNg.cNp = this.kgB.goods.thread_title;
                advertAppInfo.cNg.cNq = this.kgB.goods.thread_content;
                advertAppInfo.cNg.userName = this.kgB.goods.user_name;
                advertAppInfo.cNg.userPortrait = this.kgB.goods.user_portrait;
                advertAppInfo.cNg.buttonText = this.kgB.goods.button_text;
                advertAppInfo.cNg.cNw = this.kgB.goods.button_url;
                if (this.kgB.goods.thread_pic_list != null && advertAppInfo.cNg.cNx != null) {
                    advertAppInfo.cNg.cNx.addAll(this.kgB.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cNg.cNx) && (sv = AdvertAppInfo.a.sv(this.kgB.goods.lego_card)) != null && advertAppInfo.cNg.cNx != null) {
                    advertAppInfo.cNg.cNx.addAll(sv);
                }
                advertAppInfo.cNg.cNy = this.kgB.goods.video_info;
                advertAppInfo.cNg.tagName = this.kgB.goods.tag_name;
                advertAppInfo.cNg.adSource = this.kgB.goods.ad_source;
                advertAppInfo.cNg.cNz = this.kgB.goods.tag_name_url;
                advertAppInfo.cNg.tagRatio = this.kgB.goods.tagRatio;
                advertAppInfo.cNg.lego_card = this.kgB.goods.lego_card;
                advertAppInfo.cNg.adCloseInfo = this.kgB.goods.adCloseInfo;
            }
            advertAppInfo.page = cKS();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.azO().isShowImages() && this.kgB != null && this.kgB.legoCard != null && !this.kgB.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cML;
        }
        if (cKR() == 1001 || cKR() == -1001) {
            return AdvertAppInfo.cML;
        }
        if (cKQ() != null) {
            return AdvertAppInfo.cMP;
        }
        return null;
    }
}
