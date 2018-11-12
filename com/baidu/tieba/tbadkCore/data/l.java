package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String amd;
    public String ame;
    public String dSr;
    public String forumId;
    private AppData hep;
    public boolean heq = false;
    public boolean her = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hep = new AppData(app);
    }

    public void vb(String str) {
        this.hep = new AppData(str);
    }

    public AppData bBl() {
        return this.hep;
    }

    public AdvertAppInfo.ILegoAdvert bBm() {
        if (this.hep == null) {
            return null;
        }
        return this.hep.legoCard;
    }

    public String getAdId() {
        return this.hep == null ? "" : this.hep.id;
    }

    public boolean isApp() {
        if (this.hep == null) {
            return false;
        }
        return this.hep.wZ();
    }

    public int bBn() {
        if (this.hep == null || this.hep.goods == null) {
            return -1;
        }
        return this.hep.goods.goods_style;
    }

    public int getPosition() {
        if (this.hep == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hep.pos_name, 0);
    }

    public String bBo() {
        return this.heq ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pv() {
        List<String> dN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hep != null) {
            advertAppInfo.amh = this.hep;
            advertAppInfo.alP = this.hep.id;
            advertAppInfo.alQ = this.hep.name;
            advertAppInfo.alR = this.hep.url_type;
            advertAppInfo.alS = this.hep.url;
            advertAppInfo.deepUrl = this.hep.deepUrl;
            advertAppInfo.alT = this.hep.apk_url;
            advertAppInfo.alU = this.hep.apk_name;
            advertAppInfo.adPosition = this.hep.pos_name.trim();
            advertAppInfo.firstName = this.hep.first_name;
            advertAppInfo.alW = this.hep.second_name;
            advertAppInfo.cpid = this.hep.cpid;
            advertAppInfo.abtest = this.hep.abtest;
            advertAppInfo.alX = this.hep.plan_id;
            advertAppInfo.userId = this.hep.user_id;
            advertAppInfo.alY = this.hep.verify;
            advertAppInfo.price = this.hep.price;
            advertAppInfo.extensionInfo = this.hep.ext_info;
            advertAppInfo.alZ = this.hep.app_time * 1000;
            advertAppInfo.legoCard = this.hep.legoCard;
            if (this.hep.goods != null) {
                advertAppInfo.ama.amm = this.hep.goods.pop_window_text;
                advertAppInfo.ama.ami = this.hep.goods.id;
                advertAppInfo.ama.aml = this.hep.goods.thread_pic;
                advertAppInfo.ama.amn = this.hep.goods.goods_style;
                advertAppInfo.ama.amj = this.hep.goods.thread_title;
                advertAppInfo.ama.amk = this.hep.goods.thread_content;
                advertAppInfo.ama.userName = this.hep.goods.user_name;
                advertAppInfo.ama.userPortrait = this.hep.goods.user_portrait;
                advertAppInfo.ama.buttonText = this.hep.goods.button_text;
                advertAppInfo.ama.amq = this.hep.goods.button_url;
                if (this.hep.goods.thread_pic_list != null && advertAppInfo.ama.amr != null) {
                    advertAppInfo.ama.amr.addAll(this.hep.goods.thread_pic_list);
                }
                if (v.I(advertAppInfo.ama.amr) && (dN = advertAppInfo.ama.dN(this.hep.goods.lego_card)) != null && advertAppInfo.ama.amr != null) {
                    advertAppInfo.ama.amr.addAll(dN);
                }
                advertAppInfo.ama.ams = this.hep.goods.video_info;
                advertAppInfo.ama.tagName = this.hep.goods.tag_name;
                advertAppInfo.ama.adSource = this.hep.goods.ad_source;
                advertAppInfo.ama.amt = this.hep.goods.tag_name_url;
                advertAppInfo.ama.tagRatio = this.hep.goods.tagRatio;
                advertAppInfo.ama.lego_card = this.hep.goods.lego_card;
                advertAppInfo.ama.adCloseInfo = this.hep.goods.adCloseInfo;
            }
            advertAppInfo.page = bBo();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.wA().wE() && this.hep != null && this.hep.legoCard != null && !this.hep.legoCard.isNoPicAd()) {
            return AdvertAppInfo.alD;
        }
        if (bBn() == 1001 || bBn() == -1001) {
            return AdvertAppInfo.alD;
        }
        if (bBm() != null) {
            return AdvertAppInfo.alH;
        }
        return null;
    }
}
