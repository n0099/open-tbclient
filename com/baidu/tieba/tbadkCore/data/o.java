package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String Ue;
    public String Uf;
    public String bWe;
    public String forumId;
    private AppData fvN;
    public boolean fvO = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fvN = new AppData(app);
    }

    public AppData bic() {
        return this.fvN;
    }

    public AdvertAppInfo.ILegoAdvert bid() {
        if (this.fvN == null) {
            return null;
        }
        return this.fvN.legoCard;
    }

    public String bie() {
        return this.fvN == null ? "" : this.fvN.id;
    }

    public boolean isApp() {
        if (this.fvN == null) {
            return false;
        }
        return this.fvN.pP();
    }

    public int bif() {
        if (this.fvN == null || this.fvN.goods == null) {
            return -1;
        }
        return this.fvN.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fvN != null ? com.baidu.adp.lib.g.b.g(this.fvN.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo big() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.fvN != null) {
            advertAppInfo.Ui = this.fvN;
            advertAppInfo.TR = this.fvN.id;
            advertAppInfo.TS = this.fvN.name;
            advertAppInfo.TT = this.fvN.url_type;
            advertAppInfo.TU = this.fvN.url;
            advertAppInfo.deepUrl = this.fvN.deepUrl;
            advertAppInfo.TV = this.fvN.apk_url;
            advertAppInfo.TW = this.fvN.apk_name;
            advertAppInfo.adPosition = this.fvN.pos_name.trim();
            advertAppInfo.TX = this.fvN.first_name;
            advertAppInfo.TY = this.fvN.second_name;
            advertAppInfo.cpid = this.fvN.cpid;
            advertAppInfo.abtest = this.fvN.abtest;
            advertAppInfo.TZ = this.fvN.plan_id;
            advertAppInfo.userId = this.fvN.user_id;
            advertAppInfo.Ua = this.fvN.verify;
            advertAppInfo.price = this.fvN.price;
            advertAppInfo.extensionInfo = this.fvN.ext_info;
            advertAppInfo.Ub = this.fvN.app_time * 1000;
            advertAppInfo.legoCard = this.fvN.legoCard;
            if (this.fvN.goods != null) {
                advertAppInfo.Uc.Un = this.fvN.goods.pop_window_text;
                advertAppInfo.Uc.Uj = this.fvN.goods.id;
                advertAppInfo.Uc.Um = this.fvN.goods.thread_pic;
                advertAppInfo.Uc.Uo = this.fvN.goods.goods_style;
                advertAppInfo.Uc.Uk = this.fvN.goods.thread_title;
                advertAppInfo.Uc.Ul = this.fvN.goods.thread_content;
                advertAppInfo.Uc.userName = this.fvN.goods.user_name;
                advertAppInfo.Uc.userPortrait = this.fvN.goods.user_portrait;
                advertAppInfo.Uc.buttonText = this.fvN.goods.button_text;
                advertAppInfo.Uc.Ur = this.fvN.goods.button_url;
                if (this.fvN.goods.thread_pic_list != null) {
                    advertAppInfo.Uc.Us = new ArrayList();
                    advertAppInfo.Uc.Us.addAll(this.fvN.goods.thread_pic_list);
                }
                advertAppInfo.Uc.Ut = this.fvN.goods.video_info;
                advertAppInfo.Uc.Uu = this.fvN.goods.tag_name;
                advertAppInfo.Uc.adSource = this.fvN.goods.ad_source;
                advertAppInfo.Uc.Uv = this.fvN.goods.tag_name_url;
                advertAppInfo.Uc.tagRatio = this.fvN.goods.tagRatio;
            }
            advertAppInfo.Tw = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bid() != null) {
            return AdvertAppInfo.TP;
        }
        if (bif() == 1001) {
            return AdvertAppInfo.TH;
        }
        if (bif() == 2) {
            return AdvertAppInfo.TI;
        }
        if (bif() == 6) {
            return AdvertAppInfo.TJ;
        }
        if (bif() == 7) {
            return AdvertAppInfo.TK;
        }
        return null;
    }
}
