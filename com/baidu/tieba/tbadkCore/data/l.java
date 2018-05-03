package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Wd;
    public String We;
    public String dmd;
    public String forumId;
    private AppData gwp;
    public boolean gwq = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.gwp = new AppData(app);
    }

    public void sS(String str) {
        this.gwp = new AppData(str);
    }

    public AppData brP() {
        return this.gwp;
    }

    public AdvertAppInfo.ILegoAdvert brQ() {
        if (this.gwp == null) {
            return null;
        }
        return this.gwp.legoCard;
    }

    public String getAdId() {
        return this.gwp == null ? "" : this.gwp.id;
    }

    public boolean isApp() {
        if (this.gwp == null) {
            return false;
        }
        return this.gwp.qt();
    }

    public int brR() {
        if (this.gwp == null || this.gwp.goods == null) {
            return -1;
        }
        return this.gwp.goods.goods_style;
    }

    public int getPosition() {
        if (this.gwp == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gwp.pos_name, 0);
    }

    public AdvertAppInfo lv() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gwp != null) {
            advertAppInfo.Wh = this.gwp;
            advertAppInfo.VP = this.gwp.id;
            advertAppInfo.VQ = this.gwp.name;
            advertAppInfo.VR = this.gwp.url_type;
            advertAppInfo.VS = this.gwp.url;
            advertAppInfo.deepUrl = this.gwp.deepUrl;
            advertAppInfo.VT = this.gwp.apk_url;
            advertAppInfo.VU = this.gwp.apk_name;
            advertAppInfo.adPosition = this.gwp.pos_name.trim();
            advertAppInfo.VW = this.gwp.first_name;
            advertAppInfo.VX = this.gwp.second_name;
            advertAppInfo.cpid = this.gwp.cpid;
            advertAppInfo.abtest = this.gwp.abtest;
            advertAppInfo.VY = this.gwp.plan_id;
            advertAppInfo.userId = this.gwp.user_id;
            advertAppInfo.VZ = this.gwp.verify;
            advertAppInfo.price = this.gwp.price;
            advertAppInfo.extensionInfo = this.gwp.ext_info;
            advertAppInfo.Wa = this.gwp.app_time * 1000;
            advertAppInfo.legoCard = this.gwp.legoCard;
            if (this.gwp.goods != null) {
                advertAppInfo.Wb.Wm = this.gwp.goods.pop_window_text;
                advertAppInfo.Wb.Wi = this.gwp.goods.id;
                advertAppInfo.Wb.Wl = this.gwp.goods.thread_pic;
                advertAppInfo.Wb.Wn = this.gwp.goods.goods_style;
                advertAppInfo.Wb.Wj = this.gwp.goods.thread_title;
                advertAppInfo.Wb.Wk = this.gwp.goods.thread_content;
                advertAppInfo.Wb.userName = this.gwp.goods.user_name;
                advertAppInfo.Wb.userPortrait = this.gwp.goods.user_portrait;
                advertAppInfo.Wb.buttonText = this.gwp.goods.button_text;
                advertAppInfo.Wb.Wq = this.gwp.goods.button_url;
                if (this.gwp.goods.thread_pic_list != null) {
                    advertAppInfo.Wb.Wr = new ArrayList();
                    advertAppInfo.Wb.Wr.addAll(this.gwp.goods.thread_pic_list);
                }
                advertAppInfo.Wb.Ws = this.gwp.goods.video_info;
                advertAppInfo.Wb.tagName = this.gwp.goods.tag_name;
                advertAppInfo.Wb.adSource = this.gwp.goods.ad_source;
                advertAppInfo.Wb.Wt = this.gwp.goods.tag_name_url;
                advertAppInfo.Wb.tagRatio = this.gwp.goods.tagRatio;
                advertAppInfo.Wb.lego_card = this.gwp.goods.lego_card;
            }
            advertAppInfo.Vt = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.pY().qe() && this.gwp != null && this.gwp.legoCard != null && !this.gwp.legoCard.isNoPicAd()) {
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
