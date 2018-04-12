package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class AppData extends OrmObject {
    public final String abtest;
    public com.baidu.tbadk.core.data.b advertAppContext;
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
        ICardInfo ov = com.baidu.tieba.lego.card.b.ov(str);
        if (ov != null) {
            ICardInfo viewItem = ov.getViewItem(0, 4);
            if (viewItem instanceof AdvertAppInfo.ILegoAdvert) {
                this.legoCard = (AdvertAppInfo.ILegoAdvert) viewItem;
                if (this.legoCard != null) {
                    this.ext_info = this.legoCard.getExtInfo();
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
        ICardInfo ov;
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
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.goods = new AppGoods(goodsInfo);
                    if (com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.goods.lego_card) && (ov = com.baidu.tieba.lego.card.b.ov(this.goods.lego_card)) != null) {
                        ICardInfo viewItem = ov.getViewItem(0, 1);
                        if (viewItem instanceof AdvertAppInfo.ILegoAdvert) {
                            this.legoCard = (AdvertAppInfo.ILegoAdvert) viewItem;
                            return;
                        } else {
                            this.legoCard = null;
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    public int qs() {
        if (this.goods == null) {
            return 25;
        }
        if (this.goods.goods_style != 1001) {
            if (com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 0) {
                return 28;
            }
            if (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.id.trim())) {
                return 24;
            }
            if (TextUtils.isEmpty(this.goods.lego_card)) {
                return 11;
            }
            if (this.legoCard == null || !this.goods.c(this.legoCard)) {
                return 32;
            }
            if ((this.legoCard instanceof AdvertAppInfo.ILegoAdvert) && !com.baidu.tbadk.core.i.pY().qe() && !this.legoCard.isNoPicAd()) {
                return 34;
            }
            if (this.legoCard.getCardType() == 12) {
                return 12;
            }
            if (!bd.ZT.get() || !TbadkCoreApplication.getInst().isRecAppExist()) {
                return 31;
            }
            if (this.url_type == 3) {
                return !qt() ? 26 : 0;
            } else if (this.url_type == 1) {
                return !qu() ? 27 : 0;
            } else {
                return 21;
            }
        }
        return 0;
    }

    public boolean qt() {
        return (this.goods == null || this.goods.goods_style != 1001) && this.url_type == 3 && !StringUtils.isNull(this.apk_name) && !StringUtils.isNull(this.apk_url);
    }

    public boolean qu() {
        if (this.goods == null || this.goods.goods_style != 1001) {
            if (this.goods == null || this.goods.goods_style != -1001) {
                if (this.url_type == 1) {
                    if (!StringUtils.isNull(this.url)) {
                        return true;
                    }
                    if (this.goods != null && !TextUtils.isEmpty(this.goods.lego_card)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static class AppGoods extends OrmObject {
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
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = an.d(goodsInfo.thread_title, 29, "...");
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
            if (goodsInfo.thread_pic_list != null) {
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.thread_pic_list.add(threadPicList.pic);
                    }
                }
            }
            this.lego_card = goodsInfo.lego_card;
            this.video_info = goodsInfo.video_info;
            this.tag_name = goodsInfo.tag_name;
            this.ad_source = goodsInfo.ad_source;
            this.tag_name_url = goodsInfo.tag_name_url;
            String str = goodsInfo.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int g = com.baidu.adp.lib.g.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.g.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.tagRatio = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        public boolean c(ICardInfo iCardInfo) {
            return (TextUtils.isEmpty(this.lego_card) || com.baidu.adp.lib.b.d.eE().ak("is_support_lego_ad_style") == 0 || iCardInfo == null) ? false : true;
        }
    }
}
