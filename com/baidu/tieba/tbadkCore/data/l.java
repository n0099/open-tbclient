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
    private AppData ggG;
    public boolean ggH = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.ggG = new AppData(jSONObject);
    }

    public void c(App app) {
        this.ggG = new AppData(app);
    }

    public AppData brm() {
        return this.ggG;
    }

    public AdvertAppInfo.ILegoAdvert brn() {
        if (this.ggG == null) {
            return null;
        }
        return this.ggG.legoCard;
    }

    public String bro() {
        return this.ggG == null ? "" : this.ggG.id;
    }

    public boolean isApp() {
        if (this.ggG == null) {
            return false;
        }
        return this.ggG.pu();
    }

    public int brp() {
        if (this.ggG == null || this.ggG.goods == null) {
            return -1;
        }
        return this.ggG.goods.goods_style;
    }

    public int getPosition() {
        if (this.ggG == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.ggG.pos_name, 0);
    }

    public AdvertAppInfo brq() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.ggG != null) {
            advertAppInfo.Us = this.ggG;
            advertAppInfo.Ua = this.ggG.id;
            advertAppInfo.Ub = this.ggG.name;
            advertAppInfo.Uc = this.ggG.url_type;
            advertAppInfo.Ud = this.ggG.url;
            advertAppInfo.deepUrl = this.ggG.deepUrl;
            advertAppInfo.Ue = this.ggG.apk_url;
            advertAppInfo.Uf = this.ggG.apk_name;
            advertAppInfo.adPosition = this.ggG.pos_name.trim();
            advertAppInfo.Uh = this.ggG.first_name;
            advertAppInfo.Ui = this.ggG.second_name;
            advertAppInfo.cpid = this.ggG.cpid;
            advertAppInfo.abtest = this.ggG.abtest;
            advertAppInfo.Uj = this.ggG.plan_id;
            advertAppInfo.userId = this.ggG.user_id;
            advertAppInfo.Uk = this.ggG.verify;
            advertAppInfo.price = this.ggG.price;
            advertAppInfo.extensionInfo = this.ggG.ext_info;
            advertAppInfo.Ul = this.ggG.app_time * 1000;
            advertAppInfo.legoCard = this.ggG.legoCard;
            if (this.ggG.goods != null) {
                advertAppInfo.Um.Ux = this.ggG.goods.pop_window_text;
                advertAppInfo.Um.Ut = this.ggG.goods.id;
                advertAppInfo.Um.Uw = this.ggG.goods.thread_pic;
                advertAppInfo.Um.Uy = this.ggG.goods.goods_style;
                advertAppInfo.Um.Uu = this.ggG.goods.thread_title;
                advertAppInfo.Um.Uv = this.ggG.goods.thread_content;
                advertAppInfo.Um.userName = this.ggG.goods.user_name;
                advertAppInfo.Um.userPortrait = this.ggG.goods.user_portrait;
                advertAppInfo.Um.buttonText = this.ggG.goods.button_text;
                advertAppInfo.Um.UC = this.ggG.goods.button_url;
                if (this.ggG.goods.thread_pic_list != null) {
                    advertAppInfo.Um.UD = new ArrayList();
                    advertAppInfo.Um.UD.addAll(this.ggG.goods.thread_pic_list);
                }
                advertAppInfo.Um.UE = this.ggG.goods.video_info;
                advertAppInfo.Um.tagName = this.ggG.goods.tag_name;
                advertAppInfo.Um.adSource = this.ggG.goods.ad_source;
                advertAppInfo.Um.UF = this.ggG.goods.tag_name_url;
                advertAppInfo.Um.tagRatio = this.ggG.goods.tagRatio;
                advertAppInfo.Um.lego_card = this.ggG.goods.lego_card;
            }
            advertAppInfo.TF = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oT().oZ() && this.ggG != null && this.ggG.legoCard != null && !this.ggG.legoCard.isNoPicAd()) {
            return AdvertAppInfo.TR;
        }
        if (brp() == 1001 || brp() == -1001) {
            return AdvertAppInfo.TR;
        }
        if (brn() != null) {
            return AdvertAppInfo.TY;
        }
        return null;
    }
}
