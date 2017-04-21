package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String Ug;
    public String Uh;
    public String bYv;
    public String forumId;
    private AppData fye;
    public boolean fyf = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fye = new AppData(app);
    }

    public AppData bjd() {
        return this.fye;
    }

    public AdvertAppInfo.ILegoAdvert bje() {
        if (this.fye == null) {
            return null;
        }
        return this.fye.legoCard;
    }

    public String bjf() {
        return this.fye == null ? "" : this.fye.id;
    }

    public boolean isApp() {
        if (this.fye == null) {
            return false;
        }
        return this.fye.pP();
    }

    public int bjg() {
        if (this.fye == null || this.fye.goods == null) {
            return -1;
        }
        return this.fye.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fye != null ? com.baidu.adp.lib.g.b.g(this.fye.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bjh() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.fye != null) {
            advertAppInfo.Uk = this.fye;
            advertAppInfo.TT = this.fye.id;
            advertAppInfo.TU = this.fye.name;
            advertAppInfo.TV = this.fye.url_type;
            advertAppInfo.TW = this.fye.url;
            advertAppInfo.deepUrl = this.fye.deepUrl;
            advertAppInfo.TX = this.fye.apk_url;
            advertAppInfo.TY = this.fye.apk_name;
            advertAppInfo.adPosition = this.fye.pos_name.trim();
            advertAppInfo.TZ = this.fye.first_name;
            advertAppInfo.Ua = this.fye.second_name;
            advertAppInfo.cpid = this.fye.cpid;
            advertAppInfo.abtest = this.fye.abtest;
            advertAppInfo.Ub = this.fye.plan_id;
            advertAppInfo.userId = this.fye.user_id;
            advertAppInfo.Uc = this.fye.verify;
            advertAppInfo.price = this.fye.price;
            advertAppInfo.extensionInfo = this.fye.ext_info;
            advertAppInfo.Ud = this.fye.app_time * 1000;
            advertAppInfo.legoCard = this.fye.legoCard;
            if (this.fye.goods != null) {
                advertAppInfo.Ue.Up = this.fye.goods.pop_window_text;
                advertAppInfo.Ue.Ul = this.fye.goods.id;
                advertAppInfo.Ue.Uo = this.fye.goods.thread_pic;
                advertAppInfo.Ue.Uq = this.fye.goods.goods_style;
                advertAppInfo.Ue.Um = this.fye.goods.thread_title;
                advertAppInfo.Ue.Un = this.fye.goods.thread_content;
                advertAppInfo.Ue.userName = this.fye.goods.user_name;
                advertAppInfo.Ue.userPortrait = this.fye.goods.user_portrait;
                advertAppInfo.Ue.buttonText = this.fye.goods.button_text;
                advertAppInfo.Ue.Ut = this.fye.goods.button_url;
                if (this.fye.goods.thread_pic_list != null) {
                    advertAppInfo.Ue.Uu = new ArrayList();
                    advertAppInfo.Ue.Uu.addAll(this.fye.goods.thread_pic_list);
                }
                advertAppInfo.Ue.Uv = this.fye.goods.video_info;
                advertAppInfo.Ue.Uw = this.fye.goods.tag_name;
                advertAppInfo.Ue.adSource = this.fye.goods.ad_source;
                advertAppInfo.Ue.Ux = this.fye.goods.tag_name_url;
                advertAppInfo.Ue.tagRatio = this.fye.goods.tagRatio;
            }
            advertAppInfo.Ty = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bje() != null) {
            return AdvertAppInfo.TR;
        }
        if (bjg() == 1001) {
            return AdvertAppInfo.TJ;
        }
        if (bjg() == 2) {
            return AdvertAppInfo.TK;
        }
        if (bjg() == 6) {
            return AdvertAppInfo.TL;
        }
        if (bjg() == 7) {
            return AdvertAppInfo.TM;
        }
        return null;
    }
}
