package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.a.b.a.a.i {
    public final String Pf;
    public final int Pj;
    public ICardInfo Pp;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final String ext_info;
    public final String first_name;
    public a fuA;
    public final int fuw;
    public final int fux;
    public final int fuy;
    public final a[] fuz;
    public final String id;
    public final String ios_url;
    public final String name;
    public final String pos_name;
    public final String price;
    public final String second_name;
    public final String url;
    public final String user_id;
    public final String verify;

    public e() {
        this.Pp = null;
        this.id = null;
        this.name = null;
        this.fuw = 0;
        this.Pf = null;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Pj = 0;
        this.abtest = null;
        this.fux = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.fuy = 0;
        this.fuz = null;
        this.fuA = null;
        this.Pp = null;
    }

    public e(App app) {
        ICardInfo mY;
        this.Pp = null;
        if (app == null) {
            this.id = null;
            this.name = null;
            this.fuw = 0;
            this.Pf = null;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Pj = 0;
            this.price = null;
            this.abtest = null;
            this.fux = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.fuy = 0;
            this.fuz = null;
            this.fuA = null;
            this.Pp = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.fuw = app.url_type.intValue();
        this.Pf = app.deep_url;
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Pj = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.fux = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.fuy = app.app_time.intValue();
        this.fuz = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.fuA = new a(goodsInfo);
                    if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.fuA.lego_card) && (mY = com.baidu.tieba.lego.card.b.mY(this.fuA.lego_card)) != null) {
                        this.Pp = mY.getViewItem(0, 1);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public boolean ph() {
        if (this.fuA == null || !this.fuA.isValid() || this.fuw == 2) {
            return false;
        }
        return pi() || pj();
    }

    public boolean pi() {
        return (this.fuw != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean pj() {
        return this.fuw == 1 && !StringUtils.isNull(this.url);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.lib.a.b.a.a.i {
        public final String PC;
        public String PD;
        public float PE;
        public String Py;
        public final String adSource;
        public String buttonText;
        public final int fuB;
        public final ArrayList<String> fuC;
        public final VideoInfo fuD;
        public final int height;
        public final int id;
        public String lego_card;
        public final boolean needResize;
        public final String pop_window_text;
        public final String threadContent;
        public final String thread_pic;
        public final String thread_title;
        public final String user_name;
        public final String user_portrait;
        public final int width;

        public a() {
            this.id = 0;
            this.user_name = null;
            this.user_portrait = null;
            this.thread_title = null;
            this.thread_pic = null;
            this.pop_window_text = null;
            this.threadContent = null;
            this.fuB = 0;
            this.fuC = null;
            this.needResize = false;
            this.width = 0;
            this.height = 0;
            this.lego_card = null;
            this.fuD = null;
            this.PC = null;
            this.adSource = null;
            this.PD = null;
            this.PE = 1.0f;
        }

        public a(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.fuB = 0;
                this.fuC = null;
                this.threadContent = null;
                this.needResize = false;
                this.width = 0;
                this.height = 0;
                this.lego_card = null;
                this.fuD = null;
                this.PC = null;
                this.adSource = null;
                this.PD = null;
                this.PE = 1.0f;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = az.c(goodsInfo.thread_title, 29, "...");
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.fuB = goodsInfo.goods_style.intValue();
            this.threadContent = goodsInfo.thread_content;
            this.needResize = goodsInfo.label_measure.intValue() == 2;
            this.width = goodsInfo.width.intValue();
            this.height = goodsInfo.height.intValue();
            this.buttonText = goodsInfo.button_text;
            this.Py = goodsInfo.button_url;
            this.fuC = new ArrayList<>();
            if (goodsInfo.thread_pic_list != null) {
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.fuC.add(threadPicList.pic);
                    }
                }
            }
            this.lego_card = goodsInfo.lego_card;
            this.fuD = goodsInfo.video_info;
            this.PC = goodsInfo.tag_name;
            this.adSource = goodsInfo.ad_source;
            this.PD = goodsInfo.tag_name_url;
            String str = goodsInfo.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.PE = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        public boolean isValid() {
            if (TextUtils.isEmpty(this.lego_card)) {
                if (this.fuB == 7) {
                    if (this.fuD != null && !StringUtils.isNull(this.fuD.video_url)) {
                        if (this.fuD.video_height.intValue() <= 0 || this.fuD.video_width.intValue() <= 0) {
                            return false;
                        }
                        return this.fuD.video_duration.intValue() > 0;
                    }
                    return false;
                } else if (this.fuB == 2) {
                    return !StringUtils.isNull(this.thread_pic);
                } else if (this.fuB == 6) {
                    return this.fuC != null && this.fuC.size() > 0;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
