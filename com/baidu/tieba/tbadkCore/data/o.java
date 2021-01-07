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
    public boolean lVP;
    private AppData nrq;
    public boolean nrr = false;
    public boolean nrs = false;
    public int pageNumber;
    public long threadId;

    public void e(App app) {
        this.nrq = new AppData(app);
    }

    public void Tn(String str) {
        this.nrq = new AppData(str);
    }

    public AppData dOS() {
        return this.nrq;
    }

    public AdvertAppInfo.ILegoAdvert dOT() {
        if (this.nrq == null) {
            return null;
        }
        return this.nrq.legoCard;
    }

    public String getAdId() {
        return this.nrq == null ? "" : this.nrq.id;
    }

    public boolean bPN() {
        return this.nrq != null && this.nrq.bpf() == 0;
    }

    public boolean isApp() {
        if (this.nrq == null) {
            return false;
        }
        return this.nrq.bpg();
    }

    public int dOU() {
        if (this.nrq == null || this.nrq.goods == null) {
            return -1;
        }
        return this.nrq.goods.goods_style;
    }

    public int getPosition() {
        if (this.nrq == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nrq.pos_name, 0);
    }

    public String dOV() {
        if (this.nrr) {
            return "PB_BANNER";
        }
        if (this.lVP) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo qU() {
        List<String> AM;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nrq != null) {
            advertAppInfo.eOj = this.nrq;
            advertAppInfo.eNT = this.nrq.id;
            advertAppInfo.eNU = this.nrq.name;
            advertAppInfo.abG = this.nrq.url_type;
            advertAppInfo.eNV = this.nrq.url;
            advertAppInfo.deepUrl = this.nrq.deepUrl;
            advertAppInfo.apkUrl = this.nrq.apk_url;
            advertAppInfo.eNW = this.nrq.apk_name;
            advertAppInfo.adPosition = this.nrq.pos_name.trim();
            advertAppInfo.cRo = this.nrq.first_name;
            advertAppInfo.eNY = this.nrq.second_name;
            advertAppInfo.cpid = this.nrq.cpid;
            advertAppInfo.abtest = this.nrq.abtest;
            advertAppInfo.eNZ = this.nrq.plan_id;
            advertAppInfo.userId = this.nrq.user_id;
            advertAppInfo.eOa = this.nrq.verify;
            advertAppInfo.price = this.nrq.price;
            advertAppInfo.extensionInfo = this.nrq.ext_info;
            advertAppInfo.eOb = this.nrq.app_time * 1000;
            advertAppInfo.legoCard = this.nrq.legoCard;
            if (this.nrq.goods != null) {
                advertAppInfo.eOc.eOp = this.nrq.goods.pop_window_text;
                advertAppInfo.eOc.eOl = this.nrq.goods.id;
                advertAppInfo.eOc.eOo = this.nrq.goods.thread_pic;
                advertAppInfo.eOc.eOq = this.nrq.goods.goods_style;
                advertAppInfo.eOc.eOm = this.nrq.goods.thread_title;
                advertAppInfo.eOc.eOn = this.nrq.goods.thread_content;
                advertAppInfo.eOc.userName = this.nrq.goods.user_name;
                advertAppInfo.eOc.userPortrait = this.nrq.goods.user_portrait;
                advertAppInfo.eOc.buttonText = this.nrq.goods.button_text;
                advertAppInfo.eOc.eOt = this.nrq.goods.button_url;
                if (this.nrq.goods.thread_pic_list != null && advertAppInfo.eOc.eOu != null) {
                    advertAppInfo.eOc.eOu.addAll(this.nrq.goods.thread_pic_list);
                }
                if (x.isEmpty(advertAppInfo.eOc.eOu) && (AM = AdvertAppInfo.a.AM(this.nrq.goods.lego_card)) != null && advertAppInfo.eOc.eOu != null) {
                    advertAppInfo.eOc.eOu.addAll(AM);
                }
                advertAppInfo.eOc.eOv = this.nrq.goods.video_info;
                advertAppInfo.eOc.tagName = this.nrq.goods.tag_name;
                advertAppInfo.eOc.adSource = this.nrq.goods.ad_source;
                advertAppInfo.eOc.eOw = this.nrq.goods.tag_name_url;
                advertAppInfo.eOc.tagRatio = this.nrq.goods.tagRatio;
                advertAppInfo.eOc.lego_card = this.nrq.goods.lego_card;
                advertAppInfo.eOc.adCloseInfo = this.nrq.goods.adCloseInfo;
            }
            advertAppInfo.page = dOV();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bov().isShowImages() && this.nrq != null && this.nrq.legoCard != null && !this.nrq.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eNE;
        }
        if (com.baidu.tbadk.a.d.bmC()) {
            return AdvertAppInfo.eNE;
        }
        if (dOU() == 1001 || dOU() == -1001) {
            return AdvertAppInfo.eNE;
        }
        if (dOT() != null) {
            return AdvertAppInfo.eNI;
        }
        return null;
    }
}
