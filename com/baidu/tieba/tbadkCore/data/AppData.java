package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.switchs.AppLegoSwitch;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.c.e.m.b;
import d.b.h0.r.k;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.c;
import d.b.h0.r.q.d;
import d.b.i0.s2.w;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AdCloseInfo;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class AppData extends OrmObject {
    public final String abtest;
    public d advertAppContext;
    public final String apk_name;
    public final String apk_url;
    public final int app_time;
    public final int cpid;
    public final String deepUrl;
    public final String ext_info;
    public final String first_name;
    public AppGoods goods;
    public final AppGoods[] goods_info;
    public final String id;
    public final String ios_url;
    public AdvertAppInfo.ILegoAdvert legoCard;
    public int mDiscardReason;
    public final String name;
    public final int plan_id;
    public final String pos_name;
    public final String price;
    public App rawApp;
    public final String second_name;
    public final String url;
    public final int url_type;
    public final String user_id;
    public final String verify;

    public AppData() {
        this.legoCard = null;
        this.mDiscardReason = -1;
        this.id = null;
        this.name = null;
        this.url_type = 0;
        this.deepUrl = null;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.cpid = 0;
        this.abtest = null;
        this.plan_id = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.app_time = 0;
        this.goods_info = null;
        this.goods = null;
        this.legoCard = null;
        this.rawApp = null;
    }

    public boolean s() {
        AppGoods appGoods = this.goods;
        return (appGoods == null || appGoods.goods_style != 1001) && this.url_type == 3 && !StringUtils.isNull(this.apk_name) && !StringUtils.isNull(this.apk_url);
    }

    public boolean t() {
        AppGoods appGoods = this.goods;
        if (appGoods == null || appGoods.goods_style != 1001) {
            AppGoods appGoods2 = this.goods;
            if (appGoods2 == null || appGoods2.goods_style != -1001) {
                if (this.url_type == 1) {
                    if (!StringUtils.isNull(this.url)) {
                        return true;
                    }
                    AppGoods appGoods3 = this.goods;
                    if (appGoods3 != null && !TextUtils.isEmpty(appGoods3.lego_card)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public int u() {
        AppGoods appGoods = this.goods;
        if (appGoods == null) {
            return 25;
        }
        if (appGoods.goods_style == 1001) {
            return 0;
        }
        if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0) {
            return 28;
        }
        if (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.id.trim())) {
            return 24;
        }
        if (TextUtils.isEmpty(this.goods.lego_card)) {
            return 11;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = this.legoCard;
        if (iLegoAdvert != null && this.goods.s(iLegoAdvert)) {
            if (!(this.legoCard instanceof AdvertAppInfo.ILegoAdvert) || k.c().g() || this.legoCard.isNoPicAd()) {
                if (this.legoCard.getCardType() == 12) {
                    return 12;
                }
                if (a2.v3.get() && TbadkCoreApplication.getInst().isRecAppExist()) {
                    int i = this.url_type;
                    if (i == 3) {
                        if (!s()) {
                            return 26;
                        }
                    } else if (i != 1) {
                        return 21;
                    } else {
                        if (!t()) {
                            return 27;
                        }
                    }
                    if (this.legoCard.getCardType() == 25 || this.legoCard.getCardType() == 10 || this.legoCard.getCardType() == 9) {
                        return 37;
                    }
                    return (this.legoCard.getAppInfoModel() == null || c.c(this.legoCard.getAppInfoModel())) ? 0 : 42;
                }
                w.A();
                return 31;
            }
            return 34;
        }
        try {
            return new JSONObject(this.goods.lego_card).optInt("card_type") == 99 ? 41 : 32;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return 32;
        }
    }

    /* loaded from: classes5.dex */
    public static class AppGoods extends OrmObject {
        public AdCloseInfo adCloseInfo;
        public final String ad_source;
        public String button_text;
        public String button_url;
        public int goods_style;
        public final int height;
        public final int id;
        public String lego_card;
        public final boolean needResize;
        public final String pop_window_text;
        public float tagRatio;
        public final String tag_name;
        public String tag_name_url;
        public final String thread_content;
        public final String thread_pic;
        public final ArrayList<String> thread_pic_list;
        public final String thread_title;
        public final String user_name;
        public final String user_portrait;
        public final VideoInfo video_info;
        public final int width;

        public AppGoods() {
            this.id = 0;
            this.user_name = null;
            this.user_portrait = null;
            this.thread_title = null;
            this.thread_pic = null;
            this.pop_window_text = null;
            this.thread_content = null;
            this.goods_style = 0;
            this.thread_pic_list = null;
            this.needResize = false;
            this.width = 0;
            this.height = 0;
            this.lego_card = null;
            this.video_info = null;
            this.tag_name = null;
            this.ad_source = null;
            this.tag_name_url = null;
            this.tagRatio = 1.0f;
            this.adCloseInfo = null;
        }

        public boolean s(ICardInfo iCardInfo) {
            return (TextUtils.isEmpty(this.lego_card) || SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) == 0 || iCardInfo == null) ? false : true;
        }

        public AppGoods(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.goods_style = 0;
                this.thread_pic_list = null;
                this.thread_content = null;
                this.needResize = false;
                this.width = 0;
                this.height = 0;
                this.lego_card = null;
                this.video_info = null;
                this.tag_name = null;
                this.ad_source = null;
                this.tag_name_url = null;
                this.tagRatio = 1.0f;
                this.adCloseInfo = null;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = StringHelper.cutStringWithSuffix(goodsInfo.thread_title, 29, StringHelper.STRING_MORE);
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.goods_style = goodsInfo.goods_style.intValue();
            this.thread_content = goodsInfo.thread_content;
            this.needResize = goodsInfo.label_measure.intValue() == 2;
            this.width = goodsInfo.width.intValue();
            this.height = goodsInfo.height.intValue();
            this.button_text = goodsInfo.button_text;
            this.button_url = goodsInfo.button_url;
            this.thread_pic_list = new ArrayList<>();
            List<ThreadPicList> list = goodsInfo.thread_pic_list;
            if (list != null) {
                for (ThreadPicList threadPicList : list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.thread_pic_list.add(threadPicList.pic);
                    }
                }
            }
            this.lego_card = goodsInfo.lego_card;
            this.video_info = goodsInfo.video_info;
            this.tag_name = goodsInfo.tag_name;
            this.ad_source = goodsInfo.ad_source;
            this.adCloseInfo = goodsInfo.close_info;
            this.tag_name_url = goodsInfo.tag_name_url;
            String str = goodsInfo.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int d2 = b.d(split[0], 1);
                    int d3 = b.d(split[1], 1);
                    if (d3 != 0) {
                        this.tagRatio = d2 / d3;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    public AppData(JSONObject jSONObject) {
        this.legoCard = null;
        this.mDiscardReason = -1;
        AppData appData = (AppData) OrmObject.objectWithJsonStr(jSONObject.toString(), AppData.class);
        this.id = appData.id;
        this.name = appData.name;
        this.url_type = appData.url_type;
        this.deepUrl = appData.deepUrl;
        this.url = appData.url;
        this.ios_url = appData.ios_url;
        this.apk_url = appData.apk_url;
        this.apk_name = appData.apk_name;
        this.pos_name = appData.pos_name;
        this.first_name = appData.first_name;
        this.second_name = appData.second_name;
        this.cpid = appData.cpid;
        this.abtest = appData.abtest;
        this.plan_id = appData.plan_id;
        this.user_id = appData.user_id;
        this.verify = appData.verify;
        this.ext_info = appData.ext_info;
        this.price = appData.price;
        this.app_time = appData.app_time;
        AppGoods[] appGoodsArr = appData.goods_info;
        this.goods_info = appGoodsArr;
        if (appGoodsArr != null && appGoodsArr.length > 0) {
            this.goods = appGoodsArr[0];
        } else {
            this.goods = null;
        }
        this.legoCard = appData.legoCard;
    }

    public AppData(String str) {
        this.legoCard = null;
        this.mDiscardReason = -1;
        this.id = null;
        this.name = null;
        this.url_type = 0;
        this.deepUrl = null;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = "";
        this.first_name = null;
        this.second_name = null;
        this.cpid = 0;
        this.price = null;
        this.abtest = null;
        this.plan_id = 0;
        this.user_id = null;
        this.verify = null;
        this.app_time = 0;
        this.goods_info = null;
        this.goods = null;
        ICardInfo i = d.b.i0.j1.o.b.i(str);
        if (i != null) {
            ICardInfo viewItem = i.getViewItem(0, 4);
            if (viewItem instanceof AdvertAppInfo.ILegoAdvert) {
                AdvertAppInfo.ILegoAdvert iLegoAdvert = (AdvertAppInfo.ILegoAdvert) viewItem;
                this.legoCard = iLegoAdvert;
                if (iLegoAdvert != null) {
                    this.ext_info = iLegoAdvert.getExtInfo();
                    return;
                } else {
                    this.ext_info = "";
                    return;
                }
            }
            this.legoCard = null;
            this.ext_info = "";
            return;
        }
        this.ext_info = "";
    }

    public AppData(App app) {
        ICardInfo i;
        this.legoCard = null;
        this.mDiscardReason = -1;
        if (app == null) {
            this.id = null;
            this.name = null;
            this.url_type = 0;
            this.deepUrl = null;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.cpid = 0;
            this.price = null;
            this.abtest = null;
            this.plan_id = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.app_time = 0;
            this.goods_info = null;
            this.goods = null;
            this.legoCard = null;
            this.rawApp = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.url_type = app.url_type.intValue();
        this.deepUrl = app.deep_url;
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.cpid = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.plan_id = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.app_time = app.app_time.intValue();
        this.goods_info = null;
        this.rawApp = app;
        List<GoodsInfo> list = app.goods_info;
        if (list != null) {
            for (GoodsInfo goodsInfo : list) {
                if (goodsInfo != null) {
                    this.goods = new AppGoods(goodsInfo);
                    if (SwitchManager.getInstance().findType(AppLegoSwitch.APP_LEGO_KEY) != 1 || TextUtils.isEmpty(this.goods.lego_card) || (i = d.b.i0.j1.o.b.i(this.goods.lego_card)) == null) {
                        return;
                    }
                    ICardInfo viewItem = i.getViewItem(0, 1);
                    if (viewItem instanceof AdvertAppInfo.ILegoAdvert) {
                        this.legoCard = (AdvertAppInfo.ILegoAdvert) viewItem;
                        return;
                    } else {
                        this.legoCard = null;
                        return;
                    }
                }
            }
        }
    }
}
