package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bXx;
    public String bXy;
    public String fNb;
    public String forumId;
    private AppData jik;
    public boolean jil = false;
    public boolean jim = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.jik = new AppData(app);
    }

    public void DN(String str) {
        this.jik = new AppData(str);
    }

    public AppData cod() {
        return this.jik;
    }

    public AdvertAppInfo.ILegoAdvert coe() {
        if (this.jik == null) {
            return null;
        }
        return this.jik.legoCard;
    }

    public String getAdId() {
        return this.jik == null ? "" : this.jik.id;
    }

    public boolean aEG() {
        return this.jik != null && this.jik.agR() == 0;
    }

    public boolean isApp() {
        if (this.jik == null) {
            return false;
        }
        return this.jik.agS();
    }

    public int cof() {
        if (this.jik == null || this.jik.goods == null) {
            return -1;
        }
        return this.jik.goods.goods_style;
    }

    public int getPosition() {
        if (this.jik == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.toInt(this.jik.pos_name, 0);
    }

    public String cog() {
        return this.jil ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo kd() {
        List<String> mN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.jik != null) {
            advertAppInfo.bXB = this.jik;
            advertAppInfo.bXk = this.jik.id;
            advertAppInfo.bXl = this.jik.name;
            advertAppInfo.BV = this.jik.url_type;
            advertAppInfo.bXm = this.jik.url;
            advertAppInfo.deepUrl = this.jik.deepUrl;
            advertAppInfo.bXn = this.jik.apk_url;
            advertAppInfo.bXo = this.jik.apk_name;
            advertAppInfo.adPosition = this.jik.pos_name.trim();
            advertAppInfo.aIl = this.jik.first_name;
            advertAppInfo.bXq = this.jik.second_name;
            advertAppInfo.cpid = this.jik.cpid;
            advertAppInfo.abtest = this.jik.abtest;
            advertAppInfo.bXr = this.jik.plan_id;
            advertAppInfo.userId = this.jik.user_id;
            advertAppInfo.bXs = this.jik.verify;
            advertAppInfo.price = this.jik.price;
            advertAppInfo.extensionInfo = this.jik.ext_info;
            advertAppInfo.bXt = this.jik.app_time * 1000;
            advertAppInfo.legoCard = this.jik.legoCard;
            if (this.jik.goods != null) {
                advertAppInfo.bXu.bXG = this.jik.goods.pop_window_text;
                advertAppInfo.bXu.bXC = this.jik.goods.id;
                advertAppInfo.bXu.bXF = this.jik.goods.thread_pic;
                advertAppInfo.bXu.bXH = this.jik.goods.goods_style;
                advertAppInfo.bXu.bXD = this.jik.goods.thread_title;
                advertAppInfo.bXu.bXE = this.jik.goods.thread_content;
                advertAppInfo.bXu.userName = this.jik.goods.user_name;
                advertAppInfo.bXu.userPortrait = this.jik.goods.user_portrait;
                advertAppInfo.bXu.buttonText = this.jik.goods.button_text;
                advertAppInfo.bXu.bXK = this.jik.goods.button_url;
                if (this.jik.goods.thread_pic_list != null && advertAppInfo.bXu.bXL != null) {
                    advertAppInfo.bXu.bXL.addAll(this.jik.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.bXu.bXL) && (mN = AdvertAppInfo.a.mN(this.jik.goods.lego_card)) != null && advertAppInfo.bXu.bXL != null) {
                    advertAppInfo.bXu.bXL.addAll(mN);
                }
                advertAppInfo.bXu.bXM = this.jik.goods.video_info;
                advertAppInfo.bXu.tagName = this.jik.goods.tag_name;
                advertAppInfo.bXu.adSource = this.jik.goods.ad_source;
                advertAppInfo.bXu.bXN = this.jik.goods.tag_name_url;
                advertAppInfo.bXu.tagRatio = this.jik.goods.tagRatio;
                advertAppInfo.bXu.lego_card = this.jik.goods.lego_card;
                advertAppInfo.bXu.adCloseInfo = this.jik.goods.adCloseInfo;
            }
            advertAppInfo.page = cog();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.agq().isShowImages() && this.jik != null && this.jik.legoCard != null && !this.jik.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bWY;
        }
        if (cof() == 1001 || cof() == -1001) {
            return AdvertAppInfo.bWY;
        }
        if (coe() != null) {
            return AdvertAppInfo.bXc;
        }
        return null;
    }
}
