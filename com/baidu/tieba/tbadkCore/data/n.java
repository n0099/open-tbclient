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
    public String hFf;
    public boolean jSC;
    private AppData lkF;
    public boolean lkG = false;
    public boolean lkH = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.lkF = new AppData(app);
    }

    public void MA(String str) {
        this.lkF = new AppData(str);
    }

    public AppData ddi() {
        return this.lkF;
    }

    public AdvertAppInfo.ILegoAdvert ddj() {
        if (this.lkF == null) {
            return null;
        }
        return this.lkF.legoCard;
    }

    public String getAdId() {
        return this.lkF == null ? "" : this.lkF.id;
    }

    public boolean isValidate() {
        return this.lkF != null && this.lkF.aOy() == 0;
    }

    public boolean isApp() {
        if (this.lkF == null) {
            return false;
        }
        return this.lkF.aOz();
    }

    public int ddk() {
        if (this.lkF == null || this.lkF.goods == null) {
            return -1;
        }
        return this.lkF.goods.goods_style;
    }

    public int getPosition() {
        if (this.lkF == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.lkF.pos_name, 0);
    }

    public String ddl() {
        if (this.lkG) {
            return "PB_BANNER";
        }
        if (this.jSC) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo pu() {
        List<String> vr;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.lkF != null) {
            advertAppInfo.dAK = this.lkF;
            advertAppInfo.dAu = this.lkF.id;
            advertAppInfo.dAv = this.lkF.name;
            advertAppInfo.Yj = this.lkF.url_type;
            advertAppInfo.dAw = this.lkF.url;
            advertAppInfo.deepUrl = this.lkF.deepUrl;
            advertAppInfo.apkUrl = this.lkF.apk_url;
            advertAppInfo.dAx = this.lkF.apk_name;
            advertAppInfo.adPosition = this.lkF.pos_name.trim();
            advertAppInfo.bTd = this.lkF.first_name;
            advertAppInfo.dAz = this.lkF.second_name;
            advertAppInfo.cpid = this.lkF.cpid;
            advertAppInfo.abtest = this.lkF.abtest;
            advertAppInfo.dAA = this.lkF.plan_id;
            advertAppInfo.userId = this.lkF.user_id;
            advertAppInfo.dAB = this.lkF.verify;
            advertAppInfo.price = this.lkF.price;
            advertAppInfo.extensionInfo = this.lkF.ext_info;
            advertAppInfo.dAC = this.lkF.app_time * 1000;
            advertAppInfo.legoCard = this.lkF.legoCard;
            if (this.lkF.goods != null) {
                advertAppInfo.dAD.dAP = this.lkF.goods.pop_window_text;
                advertAppInfo.dAD.dAL = this.lkF.goods.id;
                advertAppInfo.dAD.dAO = this.lkF.goods.thread_pic;
                advertAppInfo.dAD.dAQ = this.lkF.goods.goods_style;
                advertAppInfo.dAD.dAM = this.lkF.goods.thread_title;
                advertAppInfo.dAD.dAN = this.lkF.goods.thread_content;
                advertAppInfo.dAD.userName = this.lkF.goods.user_name;
                advertAppInfo.dAD.userPortrait = this.lkF.goods.user_portrait;
                advertAppInfo.dAD.buttonText = this.lkF.goods.button_text;
                advertAppInfo.dAD.dAT = this.lkF.goods.button_url;
                if (this.lkF.goods.thread_pic_list != null && advertAppInfo.dAD.dAU != null) {
                    advertAppInfo.dAD.dAU.addAll(this.lkF.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.dAD.dAU) && (vr = AdvertAppInfo.a.vr(this.lkF.goods.lego_card)) != null && advertAppInfo.dAD.dAU != null) {
                    advertAppInfo.dAD.dAU.addAll(vr);
                }
                advertAppInfo.dAD.dAV = this.lkF.goods.video_info;
                advertAppInfo.dAD.tagName = this.lkF.goods.tag_name;
                advertAppInfo.dAD.adSource = this.lkF.goods.ad_source;
                advertAppInfo.dAD.dAW = this.lkF.goods.tag_name_url;
                advertAppInfo.dAD.tagRatio = this.lkF.goods.tagRatio;
                advertAppInfo.dAD.lego_card = this.lkF.goods.lego_card;
                advertAppInfo.dAD.adCloseInfo = this.lkF.goods.adCloseInfo;
            }
            advertAppInfo.page = ddl();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.aNQ().isShowImages() && this.lkF != null && this.lkF.legoCard != null && !this.lkF.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dAi;
        }
        if (ddk() == 1001 || ddk() == -1001) {
            return AdvertAppInfo.dAi;
        }
        if (ddj() != null) {
            return AdvertAppInfo.dAm;
        }
        return null;
    }
}
