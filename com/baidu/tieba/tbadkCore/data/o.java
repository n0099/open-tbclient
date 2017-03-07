package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String TL;
    public String TM;
    public String bWq;
    public String forumId;
    private AppData fue;
    public boolean fuf = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fue = new AppData(app);
    }

    public AppData bhr() {
        return this.fue;
    }

    public AdvertAppInfo.ILegoAdvert bhs() {
        if (this.fue == null) {
            return null;
        }
        return this.fue.legoCard;
    }

    public String bht() {
        return this.fue == null ? "" : this.fue.id;
    }

    public boolean isApp() {
        if (this.fue == null) {
            return false;
        }
        return this.fue.pr();
    }

    public int bhu() {
        if (this.fue == null || this.fue.goods == null) {
            return -1;
        }
        return this.fue.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fue != null ? com.baidu.adp.lib.g.b.g(this.fue.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bhv() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.fue != null) {
            advertAppInfo.TQ = this.fue;
            advertAppInfo.Ty = this.fue.id;
            advertAppInfo.Tz = this.fue.name;
            advertAppInfo.TA = this.fue.url_type;
            advertAppInfo.TB = this.fue.url;
            advertAppInfo.deepUrl = this.fue.deepUrl;
            advertAppInfo.TC = this.fue.apk_url;
            advertAppInfo.TD = this.fue.apk_name;
            advertAppInfo.adPosition = this.fue.pos_name.trim();
            advertAppInfo.TE = this.fue.first_name;
            advertAppInfo.TF = this.fue.second_name;
            advertAppInfo.cpid = this.fue.cpid;
            advertAppInfo.abtest = this.fue.abtest;
            advertAppInfo.TG = this.fue.plan_id;
            advertAppInfo.userId = this.fue.user_id;
            advertAppInfo.TH = this.fue.verify;
            advertAppInfo.price = this.fue.price;
            advertAppInfo.extensionInfo = this.fue.ext_info;
            advertAppInfo.TI = this.fue.app_time * 1000;
            advertAppInfo.legoCard = this.fue.legoCard;
            if (this.fue.goods != null) {
                advertAppInfo.TJ.TV = this.fue.goods.pop_window_text;
                advertAppInfo.TJ.TR = this.fue.goods.id;
                advertAppInfo.TJ.TU = this.fue.goods.thread_pic;
                advertAppInfo.TJ.TW = this.fue.goods.goods_style;
                advertAppInfo.TJ.TS = this.fue.goods.thread_title;
                advertAppInfo.TJ.TT = this.fue.goods.thread_content;
                advertAppInfo.TJ.userName = this.fue.goods.user_name;
                advertAppInfo.TJ.userPortrait = this.fue.goods.user_portrait;
                advertAppInfo.TJ.buttonText = this.fue.goods.button_text;
                advertAppInfo.TJ.TZ = this.fue.goods.button_url;
                if (this.fue.goods.thread_pic_list != null) {
                    advertAppInfo.TJ.Ua = new ArrayList();
                    advertAppInfo.TJ.Ua.addAll(this.fue.goods.thread_pic_list);
                }
                advertAppInfo.TJ.Ub = this.fue.goods.video_info;
                advertAppInfo.TJ.Uc = this.fue.goods.tag_name;
                advertAppInfo.TJ.adSource = this.fue.goods.ad_source;
                advertAppInfo.TJ.Ud = this.fue.goods.tag_name_url;
                advertAppInfo.TJ.tagRatio = this.fue.goods.tagRatio;
            }
            advertAppInfo.Te = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bhs() != null) {
            return AdvertAppInfo.Tw;
        }
        if (bhu() == 1001) {
            return AdvertAppInfo.Tp;
        }
        if (bhu() == 2) {
            return AdvertAppInfo.Tq;
        }
        if (bhu() == 6) {
            return AdvertAppInfo.Tr;
        }
        if (bhu() == 7) {
            return AdvertAppInfo.Ts;
        }
        return null;
    }
}
