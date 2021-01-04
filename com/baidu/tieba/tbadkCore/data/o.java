package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String eOf;
    public String eOg;
    public String forumId;
    public String jCL;
    public boolean lVQ;
    private AppData nrr;
    public boolean nrs = false;
    public boolean nrt = false;
    public int pageNumber;
    public long threadId;

    public void e(App app) {
        this.nrr = new AppData(app);
    }

    public void To(String str) {
        this.nrr = new AppData(str);
    }

    public AppData dOR() {
        return this.nrr;
    }

    public AdvertAppInfo.ILegoAdvert dOS() {
        if (this.nrr == null) {
            return null;
        }
        return this.nrr.legoCard;
    }

    public String getAdId() {
        return this.nrr == null ? "" : this.nrr.id;
    }

    public boolean bPM() {
        return this.nrr != null && this.nrr.bpe() == 0;
    }

    public boolean isApp() {
        if (this.nrr == null) {
            return false;
        }
        return this.nrr.bpf();
    }

    public int dOT() {
        if (this.nrr == null || this.nrr.goods == null) {
            return -1;
        }
        return this.nrr.goods.goods_style;
    }

    public int getPosition() {
        if (this.nrr == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nrr.pos_name, 0);
    }

    public String dOU() {
        if (this.nrs) {
            return "PB_BANNER";
        }
        if (this.lVQ) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo qU() {
        List<String> AN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nrr != null) {
            advertAppInfo.eOj = this.nrr;
            advertAppInfo.eNT = this.nrr.id;
            advertAppInfo.eNU = this.nrr.name;
            advertAppInfo.abG = this.nrr.url_type;
            advertAppInfo.eNV = this.nrr.url;
            advertAppInfo.deepUrl = this.nrr.deepUrl;
            advertAppInfo.apkUrl = this.nrr.apk_url;
            advertAppInfo.eNW = this.nrr.apk_name;
            advertAppInfo.adPosition = this.nrr.pos_name.trim();
            advertAppInfo.cRo = this.nrr.first_name;
            advertAppInfo.eNY = this.nrr.second_name;
            advertAppInfo.cpid = this.nrr.cpid;
            advertAppInfo.abtest = this.nrr.abtest;
            advertAppInfo.eNZ = this.nrr.plan_id;
            advertAppInfo.userId = this.nrr.user_id;
            advertAppInfo.eOa = this.nrr.verify;
            advertAppInfo.price = this.nrr.price;
            advertAppInfo.extensionInfo = this.nrr.ext_info;
            advertAppInfo.eOb = this.nrr.app_time * 1000;
            advertAppInfo.legoCard = this.nrr.legoCard;
            if (this.nrr.goods != null) {
                advertAppInfo.eOc.eOp = this.nrr.goods.pop_window_text;
                advertAppInfo.eOc.eOl = this.nrr.goods.id;
                advertAppInfo.eOc.eOo = this.nrr.goods.thread_pic;
                advertAppInfo.eOc.eOq = this.nrr.goods.goods_style;
                advertAppInfo.eOc.eOm = this.nrr.goods.thread_title;
                advertAppInfo.eOc.eOn = this.nrr.goods.thread_content;
                advertAppInfo.eOc.userName = this.nrr.goods.user_name;
                advertAppInfo.eOc.userPortrait = this.nrr.goods.user_portrait;
                advertAppInfo.eOc.buttonText = this.nrr.goods.button_text;
                advertAppInfo.eOc.eOt = this.nrr.goods.button_url;
                if (this.nrr.goods.thread_pic_list != null && advertAppInfo.eOc.eOu != null) {
                    advertAppInfo.eOc.eOu.addAll(this.nrr.goods.thread_pic_list);
                }
                if (x.isEmpty(advertAppInfo.eOc.eOu) && (AN = AdvertAppInfo.a.AN(this.nrr.goods.lego_card)) != null && advertAppInfo.eOc.eOu != null) {
                    advertAppInfo.eOc.eOu.addAll(AN);
                }
                advertAppInfo.eOc.eOv = this.nrr.goods.video_info;
                advertAppInfo.eOc.tagName = this.nrr.goods.tag_name;
                advertAppInfo.eOc.adSource = this.nrr.goods.ad_source;
                advertAppInfo.eOc.eOw = this.nrr.goods.tag_name_url;
                advertAppInfo.eOc.tagRatio = this.nrr.goods.tagRatio;
                advertAppInfo.eOc.lego_card = this.nrr.goods.lego_card;
                advertAppInfo.eOc.adCloseInfo = this.nrr.goods.adCloseInfo;
            }
            advertAppInfo.page = dOU();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bou().isShowImages() && this.nrr != null && this.nrr.legoCard != null && !this.nrr.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eNE;
        }
        if (com.baidu.tbadk.a.d.bmB()) {
            return AdvertAppInfo.eNE;
        }
        if (dOT() == 1001 || dOT() == -1001) {
            return AdvertAppInfo.eNE;
        }
        if (dOS() != null) {
            return AdvertAppInfo.eNI;
        }
        return null;
    }
}
