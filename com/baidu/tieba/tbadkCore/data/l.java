package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Wd;
    public String We;
    public String dmg;
    public String forumId;
    private AppData gws;
    public boolean gwt = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gws = new AppData(app);
    }

    public void sS(String str) {
        this.gws = new AppData(str);
    }

    public AppData brP() {
        return this.gws;
    }

    public AdvertAppInfo.ILegoAdvert brQ() {
        if (this.gws == null) {
            return null;
        }
        return this.gws.legoCard;
    }

    public String getAdId() {
        return this.gws == null ? "" : this.gws.id;
    }

    public boolean isApp() {
        if (this.gws == null) {
            return false;
        }
        return this.gws.qt();
    }

    public int brR() {
        if (this.gws == null || this.gws.goods == null) {
            return -1;
        }
        return this.gws.goods.goods_style;
    }

    public int getPosition() {
        if (this.gws == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gws.pos_name, 0);
    }

    public AdvertAppInfo lv() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gws != null) {
            advertAppInfo.Wh = this.gws;
            advertAppInfo.VP = this.gws.id;
            advertAppInfo.VQ = this.gws.name;
            advertAppInfo.VR = this.gws.url_type;
            advertAppInfo.VS = this.gws.url;
            advertAppInfo.deepUrl = this.gws.deepUrl;
            advertAppInfo.VT = this.gws.apk_url;
            advertAppInfo.VU = this.gws.apk_name;
            advertAppInfo.adPosition = this.gws.pos_name.trim();
            advertAppInfo.VW = this.gws.first_name;
            advertAppInfo.VX = this.gws.second_name;
            advertAppInfo.cpid = this.gws.cpid;
            advertAppInfo.abtest = this.gws.abtest;
            advertAppInfo.VY = this.gws.plan_id;
            advertAppInfo.userId = this.gws.user_id;
            advertAppInfo.VZ = this.gws.verify;
            advertAppInfo.price = this.gws.price;
            advertAppInfo.extensionInfo = this.gws.ext_info;
            advertAppInfo.Wa = this.gws.app_time * 1000;
            advertAppInfo.legoCard = this.gws.legoCard;
            if (this.gws.goods != null) {
                advertAppInfo.Wb.Wm = this.gws.goods.pop_window_text;
                advertAppInfo.Wb.Wi = this.gws.goods.id;
                advertAppInfo.Wb.Wl = this.gws.goods.thread_pic;
                advertAppInfo.Wb.Wn = this.gws.goods.goods_style;
                advertAppInfo.Wb.Wj = this.gws.goods.thread_title;
                advertAppInfo.Wb.Wk = this.gws.goods.thread_content;
                advertAppInfo.Wb.userName = this.gws.goods.user_name;
                advertAppInfo.Wb.userPortrait = this.gws.goods.user_portrait;
                advertAppInfo.Wb.buttonText = this.gws.goods.button_text;
                advertAppInfo.Wb.Wq = this.gws.goods.button_url;
                if (this.gws.goods.thread_pic_list != null) {
                    advertAppInfo.Wb.Wr = new ArrayList();
                    advertAppInfo.Wb.Wr.addAll(this.gws.goods.thread_pic_list);
                }
                advertAppInfo.Wb.Ws = this.gws.goods.video_info;
                advertAppInfo.Wb.tagName = this.gws.goods.tag_name;
                advertAppInfo.Wb.adSource = this.gws.goods.ad_source;
                advertAppInfo.Wb.Wt = this.gws.goods.tag_name_url;
                advertAppInfo.Wb.tagRatio = this.gws.goods.tagRatio;
                advertAppInfo.Wb.lego_card = this.gws.goods.lego_card;
            }
            advertAppInfo.Vt = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.pY().qe() && this.gws != null && this.gws.legoCard != null && !this.gws.legoCard.isNoPicAd()) {
            return AdvertAppInfo.VD;
        }
        if (brR() == 1001 || brR() == -1001) {
            return AdvertAppInfo.VD;
        }
        if (brQ() != null) {
            return AdvertAppInfo.VH;
        }
        return null;
    }
}
