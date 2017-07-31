package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String UV;
    public String UW;
    public String crS;
    public String forumId;
    private AppData ghL;
    public boolean ghM = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.ghL = new AppData(jSONObject);
    }

    public void c(App app) {
        this.ghL = new AppData(app);
    }

    public AppData bsn() {
        return this.ghL;
    }

    public AdvertAppInfo.ILegoAdvert bso() {
        if (this.ghL == null) {
            return null;
        }
        return this.ghL.legoCard;
    }

    public String bsp() {
        return this.ghL == null ? "" : this.ghL.id;
    }

    public boolean isApp() {
        if (this.ghL == null) {
            return false;
        }
        return this.ghL.py();
    }

    public int bsq() {
        if (this.ghL == null || this.ghL.goods == null) {
            return -1;
        }
        return this.ghL.goods.goods_style;
    }

    public int getPosition() {
        int g = this.ghL != null ? com.baidu.adp.lib.g.b.g(this.ghL.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bsr() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.ghL != null) {
            advertAppInfo.UZ = this.ghL;
            advertAppInfo.UH = this.ghL.id;
            advertAppInfo.UI = this.ghL.name;
            advertAppInfo.UJ = this.ghL.url_type;
            advertAppInfo.UK = this.ghL.url;
            advertAppInfo.deepUrl = this.ghL.deepUrl;
            advertAppInfo.UL = this.ghL.apk_url;
            advertAppInfo.UM = this.ghL.apk_name;
            advertAppInfo.adPosition = this.ghL.pos_name.trim();
            advertAppInfo.UN = this.ghL.first_name;
            advertAppInfo.UO = this.ghL.second_name;
            advertAppInfo.cpid = this.ghL.cpid;
            advertAppInfo.abtest = this.ghL.abtest;
            advertAppInfo.UQ = this.ghL.plan_id;
            advertAppInfo.userId = this.ghL.user_id;
            advertAppInfo.UR = this.ghL.verify;
            advertAppInfo.price = this.ghL.price;
            advertAppInfo.extensionInfo = this.ghL.ext_info;
            advertAppInfo.US = this.ghL.app_time * 1000;
            advertAppInfo.legoCard = this.ghL.legoCard;
            if (this.ghL.goods != null) {
                advertAppInfo.UT.Ve = this.ghL.goods.pop_window_text;
                advertAppInfo.UT.Va = this.ghL.goods.id;
                advertAppInfo.UT.Vd = this.ghL.goods.thread_pic;
                advertAppInfo.UT.Vf = this.ghL.goods.goods_style;
                advertAppInfo.UT.Vb = this.ghL.goods.thread_title;
                advertAppInfo.UT.Vc = this.ghL.goods.thread_content;
                advertAppInfo.UT.userName = this.ghL.goods.user_name;
                advertAppInfo.UT.userPortrait = this.ghL.goods.user_portrait;
                advertAppInfo.UT.buttonText = this.ghL.goods.button_text;
                advertAppInfo.UT.Vi = this.ghL.goods.button_url;
                if (this.ghL.goods.thread_pic_list != null) {
                    advertAppInfo.UT.Vj = new ArrayList();
                    advertAppInfo.UT.Vj.addAll(this.ghL.goods.thread_pic_list);
                }
                advertAppInfo.UT.Vk = this.ghL.goods.video_info;
                advertAppInfo.UT.Vl = this.ghL.goods.tag_name;
                advertAppInfo.UT.adSource = this.ghL.goods.ad_source;
                advertAppInfo.UT.Vm = this.ghL.goods.tag_name_url;
                advertAppInfo.UT.tagRatio = this.ghL.goods.tagRatio;
                advertAppInfo.UT.lego_card = this.ghL.goods.lego_card;
            }
            advertAppInfo.Um = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (bsq() == 1001 || bsq() == -1001) {
            return AdvertAppInfo.Ux;
        }
        if (bso() != null) {
            return AdvertAppInfo.UF;
        }
        return null;
    }
}
