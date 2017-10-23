package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Uc;
    public String Ud;
    public String cAB;
    public String forumId;
    private AppData ggr;
    public boolean ggs = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.ggr = new AppData(jSONObject);
    }

    public void c(App app) {
        this.ggr = new AppData(app);
    }

    public AppData bre() {
        return this.ggr;
    }

    public AdvertAppInfo.ILegoAdvert brf() {
        if (this.ggr == null) {
            return null;
        }
        return this.ggr.legoCard;
    }

    public String brg() {
        return this.ggr == null ? "" : this.ggr.id;
    }

    public boolean isApp() {
        if (this.ggr == null) {
            return false;
        }
        return this.ggr.pn();
    }

    public int brh() {
        if (this.ggr == null || this.ggr.goods == null) {
            return -1;
        }
        return this.ggr.goods.goods_style;
    }

    public int getPosition() {
        if (this.ggr == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.ggr.pos_name, 0);
    }

    public AdvertAppInfo bri() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.ggr != null) {
            advertAppInfo.Ug = this.ggr;
            advertAppInfo.TO = this.ggr.id;
            advertAppInfo.TP = this.ggr.name;
            advertAppInfo.TQ = this.ggr.url_type;
            advertAppInfo.TR = this.ggr.url;
            advertAppInfo.deepUrl = this.ggr.deepUrl;
            advertAppInfo.TS = this.ggr.apk_url;
            advertAppInfo.TT = this.ggr.apk_name;
            advertAppInfo.adPosition = this.ggr.pos_name.trim();
            advertAppInfo.TV = this.ggr.first_name;
            advertAppInfo.TW = this.ggr.second_name;
            advertAppInfo.cpid = this.ggr.cpid;
            advertAppInfo.abtest = this.ggr.abtest;
            advertAppInfo.TX = this.ggr.plan_id;
            advertAppInfo.userId = this.ggr.user_id;
            advertAppInfo.TY = this.ggr.verify;
            advertAppInfo.price = this.ggr.price;
            advertAppInfo.extensionInfo = this.ggr.ext_info;
            advertAppInfo.TZ = this.ggr.app_time * 1000;
            advertAppInfo.legoCard = this.ggr.legoCard;
            if (this.ggr.goods != null) {
                advertAppInfo.Ua.Ul = this.ggr.goods.pop_window_text;
                advertAppInfo.Ua.Uh = this.ggr.goods.id;
                advertAppInfo.Ua.Uk = this.ggr.goods.thread_pic;
                advertAppInfo.Ua.Um = this.ggr.goods.goods_style;
                advertAppInfo.Ua.Ui = this.ggr.goods.thread_title;
                advertAppInfo.Ua.Uj = this.ggr.goods.thread_content;
                advertAppInfo.Ua.userName = this.ggr.goods.user_name;
                advertAppInfo.Ua.userPortrait = this.ggr.goods.user_portrait;
                advertAppInfo.Ua.buttonText = this.ggr.goods.button_text;
                advertAppInfo.Ua.Up = this.ggr.goods.button_url;
                if (this.ggr.goods.thread_pic_list != null) {
                    advertAppInfo.Ua.Uq = new ArrayList();
                    advertAppInfo.Ua.Uq.addAll(this.ggr.goods.thread_pic_list);
                }
                advertAppInfo.Ua.Ur = this.ggr.goods.video_info;
                advertAppInfo.Ua.tagName = this.ggr.goods.tag_name;
                advertAppInfo.Ua.adSource = this.ggr.goods.ad_source;
                advertAppInfo.Ua.Us = this.ggr.goods.tag_name_url;
                advertAppInfo.Ua.tagRatio = this.ggr.goods.tagRatio;
                advertAppInfo.Ua.lego_card = this.ggr.goods.lego_card;
            }
            advertAppInfo.Tt = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oM().oS() && this.ggr != null && this.ggr.legoCard != null && !this.ggr.legoCard.isNoPicAd()) {
            return AdvertAppInfo.TE;
        }
        if (brh() == 1001 || brh() == -1001) {
            return AdvertAppInfo.TE;
        }
        if (brf() != null) {
            return AdvertAppInfo.TL;
        }
        return null;
    }
}
