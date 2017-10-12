package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Uo;
    public String Up;
    public String cAN;
    public String forumId;
    private AppData ggF;
    public boolean ggG = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.ggF = new AppData(jSONObject);
    }

    public void c(App app) {
        this.ggF = new AppData(app);
    }

    public AppData brl() {
        return this.ggF;
    }

    public AdvertAppInfo.ILegoAdvert brm() {
        if (this.ggF == null) {
            return null;
        }
        return this.ggF.legoCard;
    }

    public String brn() {
        return this.ggF == null ? "" : this.ggF.id;
    }

    public boolean isApp() {
        if (this.ggF == null) {
            return false;
        }
        return this.ggF.pu();
    }

    public int bro() {
        if (this.ggF == null || this.ggF.goods == null) {
            return -1;
        }
        return this.ggF.goods.goods_style;
    }

    public int getPosition() {
        if (this.ggF == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.ggF.pos_name, 0);
    }

    public AdvertAppInfo brp() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.ggF != null) {
            advertAppInfo.Us = this.ggF;
            advertAppInfo.Ua = this.ggF.id;
            advertAppInfo.Ub = this.ggF.name;
            advertAppInfo.Uc = this.ggF.url_type;
            advertAppInfo.Ud = this.ggF.url;
            advertAppInfo.deepUrl = this.ggF.deepUrl;
            advertAppInfo.Ue = this.ggF.apk_url;
            advertAppInfo.Uf = this.ggF.apk_name;
            advertAppInfo.adPosition = this.ggF.pos_name.trim();
            advertAppInfo.Uh = this.ggF.first_name;
            advertAppInfo.Ui = this.ggF.second_name;
            advertAppInfo.cpid = this.ggF.cpid;
            advertAppInfo.abtest = this.ggF.abtest;
            advertAppInfo.Uj = this.ggF.plan_id;
            advertAppInfo.userId = this.ggF.user_id;
            advertAppInfo.Uk = this.ggF.verify;
            advertAppInfo.price = this.ggF.price;
            advertAppInfo.extensionInfo = this.ggF.ext_info;
            advertAppInfo.Ul = this.ggF.app_time * 1000;
            advertAppInfo.legoCard = this.ggF.legoCard;
            if (this.ggF.goods != null) {
                advertAppInfo.Um.Ux = this.ggF.goods.pop_window_text;
                advertAppInfo.Um.Ut = this.ggF.goods.id;
                advertAppInfo.Um.Uw = this.ggF.goods.thread_pic;
                advertAppInfo.Um.Uy = this.ggF.goods.goods_style;
                advertAppInfo.Um.Uu = this.ggF.goods.thread_title;
                advertAppInfo.Um.Uv = this.ggF.goods.thread_content;
                advertAppInfo.Um.userName = this.ggF.goods.user_name;
                advertAppInfo.Um.userPortrait = this.ggF.goods.user_portrait;
                advertAppInfo.Um.buttonText = this.ggF.goods.button_text;
                advertAppInfo.Um.UC = this.ggF.goods.button_url;
                if (this.ggF.goods.thread_pic_list != null) {
                    advertAppInfo.Um.UD = new ArrayList();
                    advertAppInfo.Um.UD.addAll(this.ggF.goods.thread_pic_list);
                }
                advertAppInfo.Um.UE = this.ggF.goods.video_info;
                advertAppInfo.Um.tagName = this.ggF.goods.tag_name;
                advertAppInfo.Um.adSource = this.ggF.goods.ad_source;
                advertAppInfo.Um.UF = this.ggF.goods.tag_name_url;
                advertAppInfo.Um.tagRatio = this.ggF.goods.tagRatio;
                advertAppInfo.Um.lego_card = this.ggF.goods.lego_card;
            }
            advertAppInfo.TF = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oT().oZ() && this.ggF != null && this.ggF.legoCard != null && !this.ggF.legoCard.isNoPicAd()) {
            return AdvertAppInfo.TR;
        }
        if (bro() == 1001 || bro() == -1001) {
            return AdvertAppInfo.TR;
        }
        if (brm() != null) {
            return AdvertAppInfo.TY;
        }
        return null;
    }
}
