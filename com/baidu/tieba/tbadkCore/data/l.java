package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Tv;
    public String Tw;
    public String cqG;
    public String forumId;
    private AppData ggA;
    public boolean ggB = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.ggA = new AppData(jSONObject);
    }

    public void c(App app) {
        this.ggA = new AppData(app);
    }

    public AppData bsg() {
        return this.ggA;
    }

    public AdvertAppInfo.ILegoAdvert bsh() {
        if (this.ggA == null) {
            return null;
        }
        return this.ggA.legoCard;
    }

    public String bsi() {
        return this.ggA == null ? "" : this.ggA.id;
    }

    public boolean isApp() {
        if (this.ggA == null) {
            return false;
        }
        return this.ggA.po();
    }

    public int bsj() {
        if (this.ggA == null || this.ggA.goods == null) {
            return -1;
        }
        return this.ggA.goods.goods_style;
    }

    public int getPosition() {
        int g = this.ggA != null ? com.baidu.adp.lib.g.b.g(this.ggA.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bsk() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.ggA != null) {
            advertAppInfo.Tz = this.ggA;
            advertAppInfo.Ti = this.ggA.id;
            advertAppInfo.Tj = this.ggA.name;
            advertAppInfo.Tk = this.ggA.url_type;
            advertAppInfo.Tl = this.ggA.url;
            advertAppInfo.deepUrl = this.ggA.deepUrl;
            advertAppInfo.Tm = this.ggA.apk_url;
            advertAppInfo.Tn = this.ggA.apk_name;
            advertAppInfo.adPosition = this.ggA.pos_name.trim();
            advertAppInfo.To = this.ggA.first_name;
            advertAppInfo.Tp = this.ggA.second_name;
            advertAppInfo.cpid = this.ggA.cpid;
            advertAppInfo.abtest = this.ggA.abtest;
            advertAppInfo.Tq = this.ggA.plan_id;
            advertAppInfo.userId = this.ggA.user_id;
            advertAppInfo.Tr = this.ggA.verify;
            advertAppInfo.price = this.ggA.price;
            advertAppInfo.extensionInfo = this.ggA.ext_info;
            advertAppInfo.Ts = this.ggA.app_time * 1000;
            advertAppInfo.legoCard = this.ggA.legoCard;
            if (this.ggA.goods != null) {
                advertAppInfo.Tt.TE = this.ggA.goods.pop_window_text;
                advertAppInfo.Tt.TA = this.ggA.goods.id;
                advertAppInfo.Tt.TD = this.ggA.goods.thread_pic;
                advertAppInfo.Tt.TF = this.ggA.goods.goods_style;
                advertAppInfo.Tt.TB = this.ggA.goods.thread_title;
                advertAppInfo.Tt.TC = this.ggA.goods.thread_content;
                advertAppInfo.Tt.userName = this.ggA.goods.user_name;
                advertAppInfo.Tt.userPortrait = this.ggA.goods.user_portrait;
                advertAppInfo.Tt.buttonText = this.ggA.goods.button_text;
                advertAppInfo.Tt.TI = this.ggA.goods.button_url;
                if (this.ggA.goods.thread_pic_list != null) {
                    advertAppInfo.Tt.TJ = new ArrayList();
                    advertAppInfo.Tt.TJ.addAll(this.ggA.goods.thread_pic_list);
                }
                advertAppInfo.Tt.TK = this.ggA.goods.video_info;
                advertAppInfo.Tt.TL = this.ggA.goods.tag_name;
                advertAppInfo.Tt.adSource = this.ggA.goods.ad_source;
                advertAppInfo.Tt.TM = this.ggA.goods.tag_name_url;
                advertAppInfo.Tt.tagRatio = this.ggA.goods.tagRatio;
                advertAppInfo.Tt.lego_card = this.ggA.goods.lego_card;
            }
            advertAppInfo.SO = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (bsj() == 1001 || bsj() == -1001) {
            return AdvertAppInfo.SZ;
        }
        if (bsh() != null) {
            return AdvertAppInfo.Tg;
        }
        return null;
    }
}
