package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String dAG;
    public String dAH;
    public String forumId;
    public String hFS;
    public boolean jTI;
    private AppData llO;
    public boolean llP = false;
    public boolean llQ = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.llO = new AppData(app);
    }

    public void MB(String str) {
        this.llO = new AppData(str);
    }

    public AppData ddx() {
        return this.llO;
    }

    public AdvertAppInfo.ILegoAdvert ddy() {
        if (this.llO == null) {
            return null;
        }
        return this.llO.legoCard;
    }

    public String getAdId() {
        return this.llO == null ? "" : this.llO.id;
    }

    public boolean isValidate() {
        return this.llO != null && this.llO.aOy() == 0;
    }

    public boolean isApp() {
        if (this.llO == null) {
            return false;
        }
        return this.llO.aOz();
    }

    public int ddz() {
        if (this.llO == null || this.llO.goods == null) {
            return -1;
        }
        return this.llO.goods.goods_style;
    }

    public int getPosition() {
        if (this.llO == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.llO.pos_name, 0);
    }

    public String ddA() {
        if (this.llP) {
            return "PB_BANNER";
        }
        if (this.jTI) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo pu() {
        List<String> vr;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.llO != null) {
            advertAppInfo.dAK = this.llO;
            advertAppInfo.dAu = this.llO.id;
            advertAppInfo.dAv = this.llO.name;
            advertAppInfo.Yj = this.llO.url_type;
            advertAppInfo.dAw = this.llO.url;
            advertAppInfo.deepUrl = this.llO.deepUrl;
            advertAppInfo.apkUrl = this.llO.apk_url;
            advertAppInfo.dAx = this.llO.apk_name;
            advertAppInfo.adPosition = this.llO.pos_name.trim();
            advertAppInfo.bTd = this.llO.first_name;
            advertAppInfo.dAz = this.llO.second_name;
            advertAppInfo.cpid = this.llO.cpid;
            advertAppInfo.abtest = this.llO.abtest;
            advertAppInfo.dAA = this.llO.plan_id;
            advertAppInfo.userId = this.llO.user_id;
            advertAppInfo.dAB = this.llO.verify;
            advertAppInfo.price = this.llO.price;
            advertAppInfo.extensionInfo = this.llO.ext_info;
            advertAppInfo.dAC = this.llO.app_time * 1000;
            advertAppInfo.legoCard = this.llO.legoCard;
            if (this.llO.goods != null) {
                advertAppInfo.dAD.dAP = this.llO.goods.pop_window_text;
                advertAppInfo.dAD.dAL = this.llO.goods.id;
                advertAppInfo.dAD.dAO = this.llO.goods.thread_pic;
                advertAppInfo.dAD.dAQ = this.llO.goods.goods_style;
                advertAppInfo.dAD.dAM = this.llO.goods.thread_title;
                advertAppInfo.dAD.dAN = this.llO.goods.thread_content;
                advertAppInfo.dAD.userName = this.llO.goods.user_name;
                advertAppInfo.dAD.userPortrait = this.llO.goods.user_portrait;
                advertAppInfo.dAD.buttonText = this.llO.goods.button_text;
                advertAppInfo.dAD.dAT = this.llO.goods.button_url;
                if (this.llO.goods.thread_pic_list != null && advertAppInfo.dAD.dAU != null) {
                    advertAppInfo.dAD.dAU.addAll(this.llO.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.dAD.dAU) && (vr = AdvertAppInfo.a.vr(this.llO.goods.lego_card)) != null && advertAppInfo.dAD.dAU != null) {
                    advertAppInfo.dAD.dAU.addAll(vr);
                }
                advertAppInfo.dAD.dAV = this.llO.goods.video_info;
                advertAppInfo.dAD.tagName = this.llO.goods.tag_name;
                advertAppInfo.dAD.adSource = this.llO.goods.ad_source;
                advertAppInfo.dAD.dAW = this.llO.goods.tag_name_url;
                advertAppInfo.dAD.tagRatio = this.llO.goods.tagRatio;
                advertAppInfo.dAD.lego_card = this.llO.goods.lego_card;
                advertAppInfo.dAD.adCloseInfo = this.llO.goods.adCloseInfo;
            }
            advertAppInfo.page = ddA();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.aNQ().isShowImages() && this.llO != null && this.llO.legoCard != null && !this.llO.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dAi;
        }
        if (ddz() == 1001 || ddz() == -1001) {
            return AdvertAppInfo.dAi;
        }
        if (ddy() != null) {
            return AdvertAppInfo.dAm;
        }
        return null;
    }
}
