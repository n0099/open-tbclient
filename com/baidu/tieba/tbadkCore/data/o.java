package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String Ty;
    public String Tz;
    public String bWv;
    public String forumId;
    private AppData fui;
    public boolean fuj = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.fui = new AppData(jSONObject);
    }

    public void c(App app) {
        this.fui = new AppData(app);
    }

    public AppData bgA() {
        return this.fui;
    }

    public AdvertAppInfo.ILegoAdvert bgB() {
        if (this.fui == null) {
            return null;
        }
        return this.fui.legoCard;
    }

    public String bgC() {
        return this.fui == null ? "" : this.fui.id;
    }

    public boolean isApp() {
        if (this.fui == null) {
            return false;
        }
        return this.fui.pw();
    }

    public int bgD() {
        if (this.fui == null || this.fui.goods == null) {
            return -1;
        }
        return this.fui.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fui != null ? com.baidu.adp.lib.g.b.g(this.fui.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bgE() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.fui != null) {
            advertAppInfo.TC = this.fui;
            advertAppInfo.Tl = this.fui.id;
            advertAppInfo.Tm = this.fui.name;
            advertAppInfo.Tn = this.fui.url_type;
            advertAppInfo.To = this.fui.url;
            advertAppInfo.deepUrl = this.fui.deepUrl;
            advertAppInfo.Tp = this.fui.apk_url;
            advertAppInfo.Tq = this.fui.apk_name;
            advertAppInfo.adPosition = this.fui.pos_name.trim();
            advertAppInfo.Tr = this.fui.first_name;
            advertAppInfo.Ts = this.fui.second_name;
            advertAppInfo.cpid = this.fui.cpid;
            advertAppInfo.abtest = this.fui.abtest;
            advertAppInfo.Tt = this.fui.plan_id;
            advertAppInfo.userId = this.fui.user_id;
            advertAppInfo.Tu = this.fui.verify;
            advertAppInfo.price = this.fui.price;
            advertAppInfo.extensionInfo = this.fui.ext_info;
            advertAppInfo.Tv = this.fui.app_time * 1000;
            advertAppInfo.legoCard = this.fui.legoCard;
            if (this.fui.goods != null) {
                advertAppInfo.Tw.TH = this.fui.goods.pop_window_text;
                advertAppInfo.Tw.TD = this.fui.goods.id;
                advertAppInfo.Tw.TG = this.fui.goods.thread_pic;
                advertAppInfo.Tw.TI = this.fui.goods.goods_style;
                advertAppInfo.Tw.TE = this.fui.goods.thread_title;
                advertAppInfo.Tw.TF = this.fui.goods.thread_content;
                advertAppInfo.Tw.userName = this.fui.goods.user_name;
                advertAppInfo.Tw.userPortrait = this.fui.goods.user_portrait;
                advertAppInfo.Tw.buttonText = this.fui.goods.button_text;
                advertAppInfo.Tw.TL = this.fui.goods.button_url;
                if (this.fui.goods.thread_pic_list != null) {
                    advertAppInfo.Tw.TM = new ArrayList();
                    advertAppInfo.Tw.TM.addAll(this.fui.goods.thread_pic_list);
                }
                advertAppInfo.Tw.TO = this.fui.goods.video_info;
                advertAppInfo.Tw.TP = this.fui.goods.tag_name;
                advertAppInfo.Tw.adSource = this.fui.goods.ad_source;
                advertAppInfo.Tw.TQ = this.fui.goods.tag_name_url;
                advertAppInfo.Tw.tagRatio = this.fui.goods.tagRatio;
            }
            advertAppInfo.SR = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bgB() != null) {
            return AdvertAppInfo.Tj;
        }
        if (bgD() == 1001) {
            return AdvertAppInfo.Tc;
        }
        if (bgD() == 2) {
            return AdvertAppInfo.Td;
        }
        if (bgD() == 6) {
            return AdvertAppInfo.Te;
        }
        if (bgD() == 7) {
            return AdvertAppInfo.Tf;
        }
        return null;
    }
}
