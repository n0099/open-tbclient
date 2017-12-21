package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Vc;
    public String Vd;
    public String cSj;
    public String forumId;
    private AppData gBQ;
    public boolean gBR = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.gBQ = new AppData(app);
    }

    public void td(String str) {
        this.gBQ = new AppData(str);
    }

    public AppData bwK() {
        return this.gBQ;
    }

    public AdvertAppInfo.ILegoAdvert bwL() {
        if (this.gBQ == null) {
            return null;
        }
        return this.gBQ.legoCard;
    }

    public String getAdId() {
        return this.gBQ == null ? "" : this.gBQ.id;
    }

    public boolean isApp() {
        if (this.gBQ == null) {
            return false;
        }
        return this.gBQ.px();
    }

    public int bwM() {
        if (this.gBQ == null || this.gBQ.goods == null) {
            return -1;
        }
        return this.gBQ.goods.goods_style;
    }

    public int getPosition() {
        if (this.gBQ == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gBQ.pos_name, 0);
    }

    public AdvertAppInfo bwN() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gBQ != null) {
            advertAppInfo.Vg = this.gBQ;
            advertAppInfo.UN = this.gBQ.id;
            advertAppInfo.UO = this.gBQ.name;
            advertAppInfo.UQ = this.gBQ.url_type;
            advertAppInfo.UR = this.gBQ.url;
            advertAppInfo.deepUrl = this.gBQ.deepUrl;
            advertAppInfo.US = this.gBQ.apk_url;
            advertAppInfo.UT = this.gBQ.apk_name;
            advertAppInfo.adPosition = this.gBQ.pos_name.trim();
            advertAppInfo.UV = this.gBQ.first_name;
            advertAppInfo.UW = this.gBQ.second_name;
            advertAppInfo.cpid = this.gBQ.cpid;
            advertAppInfo.abtest = this.gBQ.abtest;
            advertAppInfo.UX = this.gBQ.plan_id;
            advertAppInfo.userId = this.gBQ.user_id;
            advertAppInfo.UY = this.gBQ.verify;
            advertAppInfo.price = this.gBQ.price;
            advertAppInfo.extensionInfo = this.gBQ.ext_info;
            advertAppInfo.UZ = this.gBQ.app_time * 1000;
            advertAppInfo.legoCard = this.gBQ.legoCard;
            if (this.gBQ.goods != null) {
                advertAppInfo.Va.Vl = this.gBQ.goods.pop_window_text;
                advertAppInfo.Va.Vh = this.gBQ.goods.id;
                advertAppInfo.Va.Vk = this.gBQ.goods.thread_pic;
                advertAppInfo.Va.Vm = this.gBQ.goods.goods_style;
                advertAppInfo.Va.Vi = this.gBQ.goods.thread_title;
                advertAppInfo.Va.Vj = this.gBQ.goods.thread_content;
                advertAppInfo.Va.userName = this.gBQ.goods.user_name;
                advertAppInfo.Va.userPortrait = this.gBQ.goods.user_portrait;
                advertAppInfo.Va.buttonText = this.gBQ.goods.button_text;
                advertAppInfo.Va.Vp = this.gBQ.goods.button_url;
                if (this.gBQ.goods.thread_pic_list != null) {
                    advertAppInfo.Va.Vq = new ArrayList();
                    advertAppInfo.Va.Vq.addAll(this.gBQ.goods.thread_pic_list);
                }
                advertAppInfo.Va.Vr = this.gBQ.goods.video_info;
                advertAppInfo.Va.tagName = this.gBQ.goods.tag_name;
                advertAppInfo.Va.adSource = this.gBQ.goods.ad_source;
                advertAppInfo.Va.Vs = this.gBQ.goods.tag_name_url;
                advertAppInfo.Va.tagRatio = this.gBQ.goods.tagRatio;
                advertAppInfo.Va.lego_card = this.gBQ.goods.lego_card;
            }
            advertAppInfo.Uq = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oY().pe() && this.gBQ != null && this.gBQ.legoCard != null && !this.gBQ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.UC;
        }
        if (bwM() == 1001 || bwM() == -1001) {
            return AdvertAppInfo.UC;
        }
        if (bwL() != null) {
            return AdvertAppInfo.UG;
        }
        return null;
    }
}
