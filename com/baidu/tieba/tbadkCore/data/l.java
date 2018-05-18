package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String VZ;
    public String Wa;
    public String dnk;
    public String forumId;
    private AppData gxt;
    public boolean gxu = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gxt = new AppData(app);
    }

    public void sV(String str) {
        this.gxt = new AppData(str);
    }

    public AppData brN() {
        return this.gxt;
    }

    public AdvertAppInfo.ILegoAdvert brO() {
        if (this.gxt == null) {
            return null;
        }
        return this.gxt.legoCard;
    }

    public String getAdId() {
        return this.gxt == null ? "" : this.gxt.id;
    }

    public boolean isApp() {
        if (this.gxt == null) {
            return false;
        }
        return this.gxt.qs();
    }

    public int brP() {
        if (this.gxt == null || this.gxt.goods == null) {
            return -1;
        }
        return this.gxt.goods.goods_style;
    }

    public int getPosition() {
        if (this.gxt == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gxt.pos_name, 0);
    }

    public AdvertAppInfo lu() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gxt != null) {
            advertAppInfo.Wd = this.gxt;
            advertAppInfo.VL = this.gxt.id;
            advertAppInfo.VM = this.gxt.name;
            advertAppInfo.VN = this.gxt.url_type;
            advertAppInfo.VO = this.gxt.url;
            advertAppInfo.deepUrl = this.gxt.deepUrl;
            advertAppInfo.VP = this.gxt.apk_url;
            advertAppInfo.VQ = this.gxt.apk_name;
            advertAppInfo.adPosition = this.gxt.pos_name.trim();
            advertAppInfo.VS = this.gxt.first_name;
            advertAppInfo.VT = this.gxt.second_name;
            advertAppInfo.cpid = this.gxt.cpid;
            advertAppInfo.abtest = this.gxt.abtest;
            advertAppInfo.VU = this.gxt.plan_id;
            advertAppInfo.userId = this.gxt.user_id;
            advertAppInfo.VV = this.gxt.verify;
            advertAppInfo.price = this.gxt.price;
            advertAppInfo.extensionInfo = this.gxt.ext_info;
            advertAppInfo.VW = this.gxt.app_time * 1000;
            advertAppInfo.legoCard = this.gxt.legoCard;
            if (this.gxt.goods != null) {
                advertAppInfo.VX.Wi = this.gxt.goods.pop_window_text;
                advertAppInfo.VX.We = this.gxt.goods.id;
                advertAppInfo.VX.Wh = this.gxt.goods.thread_pic;
                advertAppInfo.VX.Wj = this.gxt.goods.goods_style;
                advertAppInfo.VX.Wf = this.gxt.goods.thread_title;
                advertAppInfo.VX.Wg = this.gxt.goods.thread_content;
                advertAppInfo.VX.userName = this.gxt.goods.user_name;
                advertAppInfo.VX.userPortrait = this.gxt.goods.user_portrait;
                advertAppInfo.VX.buttonText = this.gxt.goods.button_text;
                advertAppInfo.VX.Wm = this.gxt.goods.button_url;
                if (this.gxt.goods.thread_pic_list != null) {
                    advertAppInfo.VX.Wn = new ArrayList();
                    advertAppInfo.VX.Wn.addAll(this.gxt.goods.thread_pic_list);
                }
                advertAppInfo.VX.Wo = this.gxt.goods.video_info;
                advertAppInfo.VX.tagName = this.gxt.goods.tag_name;
                advertAppInfo.VX.adSource = this.gxt.goods.ad_source;
                advertAppInfo.VX.Wp = this.gxt.goods.tag_name_url;
                advertAppInfo.VX.tagRatio = this.gxt.goods.tagRatio;
                advertAppInfo.VX.lego_card = this.gxt.goods.lego_card;
            }
            advertAppInfo.Vp = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.pX().qd() && this.gxt != null && this.gxt.legoCard != null && !this.gxt.legoCard.isNoPicAd()) {
            return AdvertAppInfo.Vz;
        }
        if (brP() == 1001 || brP() == -1001) {
            return AdvertAppInfo.Vz;
        }
        if (brO() != null) {
            return AdvertAppInfo.VD;
        }
        return null;
    }
}
