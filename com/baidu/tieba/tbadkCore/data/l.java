package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String aJA;
    public String aJz;
    public String dKg;
    public String forumId;
    private AppData hiD;
    public boolean hiE = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hiD = new AppData(app);
    }

    public void tc(String str) {
        this.hiD = new AppData(str);
    }

    public AppData bBZ() {
        return this.hiD;
    }

    public AdvertAppInfo.ILegoAdvert bCa() {
        if (this.hiD == null) {
            return null;
        }
        return this.hiD.legoCard;
    }

    public String getAdId() {
        return this.hiD == null ? "" : this.hiD.id;
    }

    public boolean isApp() {
        if (this.hiD == null) {
            return false;
        }
        return this.hiD.xa();
    }

    public int bCb() {
        if (this.hiD == null || this.hiD.goods == null) {
            return -1;
        }
        return this.hiD.goods.goods_style;
    }

    public int getPosition() {
        if (this.hiD == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.h(this.hiD.pos_name, 0);
    }

    public AdvertAppInfo bCc() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hiD != null) {
            advertAppInfo.aJD = this.hiD;
            advertAppInfo.aJl = this.hiD.id;
            advertAppInfo.aJm = this.hiD.name;
            advertAppInfo.aJn = this.hiD.url_type;
            advertAppInfo.aJo = this.hiD.url;
            advertAppInfo.deepUrl = this.hiD.deepUrl;
            advertAppInfo.aJp = this.hiD.apk_url;
            advertAppInfo.aJq = this.hiD.apk_name;
            advertAppInfo.adPosition = this.hiD.pos_name.trim();
            advertAppInfo.aJs = this.hiD.first_name;
            advertAppInfo.aJt = this.hiD.second_name;
            advertAppInfo.cpid = this.hiD.cpid;
            advertAppInfo.abtest = this.hiD.abtest;
            advertAppInfo.aJu = this.hiD.plan_id;
            advertAppInfo.userId = this.hiD.user_id;
            advertAppInfo.aJv = this.hiD.verify;
            advertAppInfo.price = this.hiD.price;
            advertAppInfo.extensionInfo = this.hiD.ext_info;
            advertAppInfo.aJw = this.hiD.app_time * 1000;
            advertAppInfo.legoCard = this.hiD.legoCard;
            if (this.hiD.goods != null) {
                advertAppInfo.aJx.aJI = this.hiD.goods.pop_window_text;
                advertAppInfo.aJx.aJE = this.hiD.goods.id;
                advertAppInfo.aJx.aJH = this.hiD.goods.thread_pic;
                advertAppInfo.aJx.aJJ = this.hiD.goods.goods_style;
                advertAppInfo.aJx.aJF = this.hiD.goods.thread_title;
                advertAppInfo.aJx.aJG = this.hiD.goods.thread_content;
                advertAppInfo.aJx.userName = this.hiD.goods.user_name;
                advertAppInfo.aJx.userPortrait = this.hiD.goods.user_portrait;
                advertAppInfo.aJx.buttonText = this.hiD.goods.button_text;
                advertAppInfo.aJx.aJM = this.hiD.goods.button_url;
                if (this.hiD.goods.thread_pic_list != null) {
                    advertAppInfo.aJx.aJN = new ArrayList();
                    advertAppInfo.aJx.aJN.addAll(this.hiD.goods.thread_pic_list);
                }
                advertAppInfo.aJx.aJO = this.hiD.goods.video_info;
                advertAppInfo.aJx.tagName = this.hiD.goods.tag_name;
                advertAppInfo.aJx.adSource = this.hiD.goods.ad_source;
                advertAppInfo.aJx.aJP = this.hiD.goods.tag_name_url;
                advertAppInfo.aJx.tagRatio = this.hiD.goods.tagRatio;
                advertAppInfo.aJx.lego_card = this.hiD.goods.lego_card;
            }
            advertAppInfo.aIO = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.wB().wH() && this.hiD != null && this.hiD.legoCard != null && !this.hiD.legoCard.isNoPicAd()) {
            return AdvertAppInfo.aIZ;
        }
        if (bCb() == 1001 || bCb() == -1001) {
            return AdvertAppInfo.aIZ;
        }
        if (bCa() != null) {
            return AdvertAppInfo.aJd;
        }
        return null;
    }
}
