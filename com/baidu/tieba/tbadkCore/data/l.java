package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String UZ;
    public String Va;
    public String cSf;
    public String forumId;
    private AppData gBL;
    public boolean gBM = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.gBL = new AppData(app);
    }

    public void td(String str) {
        this.gBL = new AppData(str);
    }

    public AppData bwK() {
        return this.gBL;
    }

    public AdvertAppInfo.ILegoAdvert bwL() {
        if (this.gBL == null) {
            return null;
        }
        return this.gBL.legoCard;
    }

    public String getAdId() {
        return this.gBL == null ? "" : this.gBL.id;
    }

    public boolean isApp() {
        if (this.gBL == null) {
            return false;
        }
        return this.gBL.px();
    }

    public int bwM() {
        if (this.gBL == null || this.gBL.goods == null) {
            return -1;
        }
        return this.gBL.goods.goods_style;
    }

    public int getPosition() {
        if (this.gBL == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gBL.pos_name, 0);
    }

    public AdvertAppInfo bwN() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gBL != null) {
            advertAppInfo.Vd = this.gBL;
            advertAppInfo.UK = this.gBL.id;
            advertAppInfo.UL = this.gBL.name;
            advertAppInfo.UM = this.gBL.url_type;
            advertAppInfo.UN = this.gBL.url;
            advertAppInfo.deepUrl = this.gBL.deepUrl;
            advertAppInfo.UO = this.gBL.apk_url;
            advertAppInfo.UQ = this.gBL.apk_name;
            advertAppInfo.adPosition = this.gBL.pos_name.trim();
            advertAppInfo.US = this.gBL.first_name;
            advertAppInfo.UT = this.gBL.second_name;
            advertAppInfo.cpid = this.gBL.cpid;
            advertAppInfo.abtest = this.gBL.abtest;
            advertAppInfo.UU = this.gBL.plan_id;
            advertAppInfo.userId = this.gBL.user_id;
            advertAppInfo.UV = this.gBL.verify;
            advertAppInfo.price = this.gBL.price;
            advertAppInfo.extensionInfo = this.gBL.ext_info;
            advertAppInfo.UW = this.gBL.app_time * 1000;
            advertAppInfo.legoCard = this.gBL.legoCard;
            if (this.gBL.goods != null) {
                advertAppInfo.UX.Vi = this.gBL.goods.pop_window_text;
                advertAppInfo.UX.Ve = this.gBL.goods.id;
                advertAppInfo.UX.Vh = this.gBL.goods.thread_pic;
                advertAppInfo.UX.Vj = this.gBL.goods.goods_style;
                advertAppInfo.UX.Vf = this.gBL.goods.thread_title;
                advertAppInfo.UX.Vg = this.gBL.goods.thread_content;
                advertAppInfo.UX.userName = this.gBL.goods.user_name;
                advertAppInfo.UX.userPortrait = this.gBL.goods.user_portrait;
                advertAppInfo.UX.buttonText = this.gBL.goods.button_text;
                advertAppInfo.UX.Vm = this.gBL.goods.button_url;
                if (this.gBL.goods.thread_pic_list != null) {
                    advertAppInfo.UX.Vn = new ArrayList();
                    advertAppInfo.UX.Vn.addAll(this.gBL.goods.thread_pic_list);
                }
                advertAppInfo.UX.Vo = this.gBL.goods.video_info;
                advertAppInfo.UX.tagName = this.gBL.goods.tag_name;
                advertAppInfo.UX.adSource = this.gBL.goods.ad_source;
                advertAppInfo.UX.Vp = this.gBL.goods.tag_name_url;
                advertAppInfo.UX.tagRatio = this.gBL.goods.tagRatio;
                advertAppInfo.UX.lego_card = this.gBL.goods.lego_card;
            }
            advertAppInfo.Un = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oY().pe() && this.gBL != null && this.gBL.legoCard != null && !this.gBL.legoCard.isNoPicAd()) {
            return AdvertAppInfo.Uy;
        }
        if (bwM() == 1001 || bwM() == -1001) {
            return AdvertAppInfo.Uy;
        }
        if (bwL() != null) {
            return AdvertAppInfo.UD;
        }
        return null;
    }
}
