package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Vf;
    public String Vg;
    public String cRU;
    public String forumId;
    private AppData gzc;
    public boolean gzd = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.gzc = new AppData(app);
    }

    public void sY(String str) {
        this.gzc = new AppData(str);
    }

    public AppData bwd() {
        return this.gzc;
    }

    public AdvertAppInfo.ILegoAdvert bwe() {
        if (this.gzc == null) {
            return null;
        }
        return this.gzc.legoCard;
    }

    public String getAdId() {
        return this.gzc == null ? "" : this.gzc.id;
    }

    public boolean isApp() {
        if (this.gzc == null) {
            return false;
        }
        return this.gzc.pz();
    }

    public int bwf() {
        if (this.gzc == null || this.gzc.goods == null) {
            return -1;
        }
        return this.gzc.goods.goods_style;
    }

    public int getPosition() {
        if (this.gzc == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gzc.pos_name, 0);
    }

    public AdvertAppInfo bwg() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gzc != null) {
            advertAppInfo.Vj = this.gzc;
            advertAppInfo.UR = this.gzc.id;
            advertAppInfo.US = this.gzc.name;
            advertAppInfo.UT = this.gzc.url_type;
            advertAppInfo.UU = this.gzc.url;
            advertAppInfo.deepUrl = this.gzc.deepUrl;
            advertAppInfo.UV = this.gzc.apk_url;
            advertAppInfo.UW = this.gzc.apk_name;
            advertAppInfo.adPosition = this.gzc.pos_name.trim();
            advertAppInfo.UY = this.gzc.first_name;
            advertAppInfo.UZ = this.gzc.second_name;
            advertAppInfo.cpid = this.gzc.cpid;
            advertAppInfo.abtest = this.gzc.abtest;
            advertAppInfo.Va = this.gzc.plan_id;
            advertAppInfo.userId = this.gzc.user_id;
            advertAppInfo.Vb = this.gzc.verify;
            advertAppInfo.price = this.gzc.price;
            advertAppInfo.extensionInfo = this.gzc.ext_info;
            advertAppInfo.Vc = this.gzc.app_time * 1000;
            advertAppInfo.legoCard = this.gzc.legoCard;
            if (this.gzc.goods != null) {
                advertAppInfo.Vd.Vo = this.gzc.goods.pop_window_text;
                advertAppInfo.Vd.Vk = this.gzc.goods.id;
                advertAppInfo.Vd.Vn = this.gzc.goods.thread_pic;
                advertAppInfo.Vd.Vp = this.gzc.goods.goods_style;
                advertAppInfo.Vd.Vl = this.gzc.goods.thread_title;
                advertAppInfo.Vd.Vm = this.gzc.goods.thread_content;
                advertAppInfo.Vd.userName = this.gzc.goods.user_name;
                advertAppInfo.Vd.userPortrait = this.gzc.goods.user_portrait;
                advertAppInfo.Vd.buttonText = this.gzc.goods.button_text;
                advertAppInfo.Vd.Vs = this.gzc.goods.button_url;
                if (this.gzc.goods.thread_pic_list != null) {
                    advertAppInfo.Vd.Vt = new ArrayList();
                    advertAppInfo.Vd.Vt.addAll(this.gzc.goods.thread_pic_list);
                }
                advertAppInfo.Vd.Vu = this.gzc.goods.video_info;
                advertAppInfo.Vd.tagName = this.gzc.goods.tag_name;
                advertAppInfo.Vd.adSource = this.gzc.goods.ad_source;
                advertAppInfo.Vd.Vv = this.gzc.goods.tag_name_url;
                advertAppInfo.Vd.tagRatio = this.gzc.goods.tagRatio;
                advertAppInfo.Vd.lego_card = this.gzc.goods.lego_card;
            }
            advertAppInfo.Ut = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.pa().pg() && this.gzc != null && this.gzc.legoCard != null && !this.gzc.legoCard.isNoPicAd()) {
            return AdvertAppInfo.UF;
        }
        if (bwf() == 1001 || bwf() == -1001) {
            return AdvertAppInfo.UF;
        }
        if (bwe() != null) {
            return AdvertAppInfo.UJ;
        }
        return null;
    }
}
