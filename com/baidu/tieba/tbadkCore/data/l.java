package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Ua;
    public String Ub;
    public String czc;
    public String forumId;
    private AppData gig;
    public boolean gih = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.gig = new AppData(jSONObject);
    }

    public void c(App app) {
        this.gig = new AppData(app);
    }

    public AppData bsd() {
        return this.gig;
    }

    public AdvertAppInfo.ILegoAdvert bse() {
        if (this.gig == null) {
            return null;
        }
        return this.gig.legoCard;
    }

    public String bsf() {
        return this.gig == null ? "" : this.gig.id;
    }

    public boolean isApp() {
        if (this.gig == null) {
            return false;
        }
        return this.gig.pt();
    }

    public int bsg() {
        if (this.gig == null || this.gig.goods == null) {
            return -1;
        }
        return this.gig.goods.goods_style;
    }

    public int getPosition() {
        int g = this.gig != null ? com.baidu.adp.lib.g.b.g(this.gig.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bsh() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gig != null) {
            advertAppInfo.Ue = this.gig;
            advertAppInfo.TL = this.gig.id;
            advertAppInfo.TM = this.gig.name;
            advertAppInfo.TO = this.gig.url_type;
            advertAppInfo.TP = this.gig.url;
            advertAppInfo.deepUrl = this.gig.deepUrl;
            advertAppInfo.TQ = this.gig.apk_url;
            advertAppInfo.TR = this.gig.apk_name;
            advertAppInfo.adPosition = this.gig.pos_name.trim();
            advertAppInfo.TT = this.gig.first_name;
            advertAppInfo.TU = this.gig.second_name;
            advertAppInfo.cpid = this.gig.cpid;
            advertAppInfo.abtest = this.gig.abtest;
            advertAppInfo.TV = this.gig.plan_id;
            advertAppInfo.userId = this.gig.user_id;
            advertAppInfo.TW = this.gig.verify;
            advertAppInfo.price = this.gig.price;
            advertAppInfo.extensionInfo = this.gig.ext_info;
            advertAppInfo.TX = this.gig.app_time * 1000;
            advertAppInfo.legoCard = this.gig.legoCard;
            if (this.gig.goods != null) {
                advertAppInfo.TY.Uj = this.gig.goods.pop_window_text;
                advertAppInfo.TY.Uf = this.gig.goods.id;
                advertAppInfo.TY.Ui = this.gig.goods.thread_pic;
                advertAppInfo.TY.Uk = this.gig.goods.goods_style;
                advertAppInfo.TY.Ug = this.gig.goods.thread_title;
                advertAppInfo.TY.Uh = this.gig.goods.thread_content;
                advertAppInfo.TY.userName = this.gig.goods.user_name;
                advertAppInfo.TY.userPortrait = this.gig.goods.user_portrait;
                advertAppInfo.TY.buttonText = this.gig.goods.button_text;
                advertAppInfo.TY.Un = this.gig.goods.button_url;
                if (this.gig.goods.thread_pic_list != null) {
                    advertAppInfo.TY.Uo = new ArrayList();
                    advertAppInfo.TY.Uo.addAll(this.gig.goods.thread_pic_list);
                }
                advertAppInfo.TY.Up = this.gig.goods.video_info;
                advertAppInfo.TY.tagName = this.gig.goods.tag_name;
                advertAppInfo.TY.adSource = this.gig.goods.ad_source;
                advertAppInfo.TY.Uq = this.gig.goods.tag_name_url;
                advertAppInfo.TY.tagRatio = this.gig.goods.tagRatio;
                advertAppInfo.TY.lego_card = this.gig.goods.lego_card;
            }
            advertAppInfo.Tr = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (bsg() == 1001 || bsg() == -1001) {
            return AdvertAppInfo.TC;
        }
        if (bse() != null) {
            return AdvertAppInfo.TJ;
        }
        return null;
    }
}
