package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String Tl;
    public String Tm;
    public String ccu;
    private AppData fBZ;
    public boolean fCa = false;
    public String forumId;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.fBZ = new AppData(jSONObject);
    }

    public void c(App app) {
        this.fBZ = new AppData(app);
    }

    public AppData bhV() {
        return this.fBZ;
    }

    public AdvertAppInfo.ILegoAdvert bhW() {
        if (this.fBZ == null) {
            return null;
        }
        return this.fBZ.legoCard;
    }

    public String bhX() {
        return this.fBZ == null ? "" : this.fBZ.id;
    }

    public boolean isApp() {
        if (this.fBZ == null) {
            return false;
        }
        return this.fBZ.po();
    }

    public int bhY() {
        if (this.fBZ == null || this.fBZ.goods == null) {
            return -1;
        }
        return this.fBZ.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fBZ != null ? com.baidu.adp.lib.g.b.g(this.fBZ.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bhZ() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.fBZ != null) {
            advertAppInfo.Tp = this.fBZ;
            advertAppInfo.SY = this.fBZ.id;
            advertAppInfo.SZ = this.fBZ.name;
            advertAppInfo.Ta = this.fBZ.url_type;
            advertAppInfo.Tb = this.fBZ.url;
            advertAppInfo.deepUrl = this.fBZ.deepUrl;
            advertAppInfo.Tc = this.fBZ.apk_url;
            advertAppInfo.Td = this.fBZ.apk_name;
            advertAppInfo.adPosition = this.fBZ.pos_name.trim();
            advertAppInfo.Te = this.fBZ.first_name;
            advertAppInfo.Tf = this.fBZ.second_name;
            advertAppInfo.cpid = this.fBZ.cpid;
            advertAppInfo.abtest = this.fBZ.abtest;
            advertAppInfo.Tg = this.fBZ.plan_id;
            advertAppInfo.userId = this.fBZ.user_id;
            advertAppInfo.Th = this.fBZ.verify;
            advertAppInfo.price = this.fBZ.price;
            advertAppInfo.extensionInfo = this.fBZ.ext_info;
            advertAppInfo.Ti = this.fBZ.app_time * 1000;
            advertAppInfo.legoCard = this.fBZ.legoCard;
            if (this.fBZ.goods != null) {
                advertAppInfo.Tj.Tu = this.fBZ.goods.pop_window_text;
                advertAppInfo.Tj.Tq = this.fBZ.goods.id;
                advertAppInfo.Tj.Tt = this.fBZ.goods.thread_pic;
                advertAppInfo.Tj.Tv = this.fBZ.goods.goods_style;
                advertAppInfo.Tj.Tr = this.fBZ.goods.thread_title;
                advertAppInfo.Tj.Ts = this.fBZ.goods.thread_content;
                advertAppInfo.Tj.userName = this.fBZ.goods.user_name;
                advertAppInfo.Tj.userPortrait = this.fBZ.goods.user_portrait;
                advertAppInfo.Tj.buttonText = this.fBZ.goods.button_text;
                advertAppInfo.Tj.Ty = this.fBZ.goods.button_url;
                if (this.fBZ.goods.thread_pic_list != null) {
                    advertAppInfo.Tj.Tz = new ArrayList();
                    advertAppInfo.Tj.Tz.addAll(this.fBZ.goods.thread_pic_list);
                }
                advertAppInfo.Tj.TA = this.fBZ.goods.video_info;
                advertAppInfo.Tj.TB = this.fBZ.goods.tag_name;
                advertAppInfo.Tj.adSource = this.fBZ.goods.ad_source;
                advertAppInfo.Tj.TC = this.fBZ.goods.tag_name_url;
                advertAppInfo.Tj.tagRatio = this.fBZ.goods.tagRatio;
                advertAppInfo.Tj.lego_card = this.fBZ.goods.lego_card;
            }
            advertAppInfo.SE = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bhW() != null) {
            return AdvertAppInfo.SW;
        }
        if (bhY() == 1001) {
            return AdvertAppInfo.SP;
        }
        return null;
    }
}
