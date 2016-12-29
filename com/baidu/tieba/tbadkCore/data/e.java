package com.baidu.tieba.tbadkCore.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.a.b.a.a.i {
    public final String Po;
    public final int Ps;
    public ICardInfo Py;
    public com.baidu.tbadk.core.data.b Pz;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final String ext_info;
    public final int ffO;
    public final int ffP;
    public final int ffQ;
    public final a[] ffR;
    public a ffS;
    public final String first_name;
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
        this.Py = null;
        this.id = null;
        this.name = null;
        this.ffO = 0;
        this.Po = null;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Ps = 0;
        this.abtest = null;
        this.ffP = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.ffQ = 0;
        this.ffR = null;
        this.ffS = null;
        this.Py = null;
    }

    public e(App app) {
        ICardInfo ly;
        this.Py = null;
        if (app == null) {
            this.id = null;
            this.name = null;
            this.ffO = 0;
            this.Po = null;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Ps = 0;
            this.price = null;
            this.abtest = null;
            this.ffP = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.ffQ = 0;
            this.ffR = null;
            this.ffS = null;
            this.Py = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.ffO = app.url_type.intValue();
        this.Po = app.deep_url;
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Ps = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.ffP = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.ffQ = app.app_time.intValue();
        this.ffR = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.ffS = new a(goodsInfo);
                    if (com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style") == 1 && !TextUtils.isEmpty(this.ffS.lego_card) && (ly = com.baidu.tieba.lego.card.b.ly(this.ffS.lego_card)) != null) {
                        this.Py = ly.getViewItem(0, 1);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public boolean pj() {
        if (this.ffS == null || !this.ffS.c(this.Py)) {
            return false;
        }
        if (this.ffS.ffT != 1001) {
            if (this.ffO == 2) {
                return false;
            }
            return pk() || pl();
        }
        return true;
    }

    public boolean pk() {
        return (this.ffO != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean pl() {
        if (this.ffO == 1) {
            if (!StringUtils.isNull(this.url)) {
                return true;
            }
            if (this.ffS != null && !TextUtils.isEmpty(this.ffS.lego_card)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.lib.a.b.a.a.i {
        public float PT;
        public final String ad_source;
        public String button_text;
        public String button_url;
        public final int ffT;
        public final ArrayList<String> ffU;
        public final int height;
        public final int id;
        public String lego_card;
        public final boolean needResize;
        public final String pop_window_text;
        public final String tag_name;
        public String tag_name_url;
        public final String thread_content;
        public final String thread_pic;
        public final String thread_title;
        public final String user_name;
        public final String user_portrait;
        public final VideoInfo video_info;
        public final int width;

        public a() {
            this.id = 0;
            this.user_name = null;
            this.user_portrait = null;
            this.thread_title = null;
            this.thread_pic = null;
            this.pop_window_text = null;
            this.thread_content = null;
            this.ffT = 0;
            this.ffU = null;
            this.needResize = false;
            this.width = 0;
            this.height = 0;
            this.lego_card = null;
            this.video_info = null;
            this.tag_name = null;
            this.ad_source = null;
            this.tag_name_url = null;
            this.PT = 1.0f;
        }

        public a(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.ffT = 0;
                this.ffU = null;
                this.thread_content = null;
                this.needResize = false;
                this.width = 0;
                this.height = 0;
                this.lego_card = null;
                this.video_info = null;
                this.tag_name = null;
                this.ad_source = null;
                this.tag_name_url = null;
                this.PT = 1.0f;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = av.c(goodsInfo.thread_title, 29, "...");
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.ffT = goodsInfo.goods_style.intValue();
            this.thread_content = goodsInfo.thread_content;
            this.needResize = goodsInfo.label_measure.intValue() == 2;
            this.width = goodsInfo.width.intValue();
            this.height = goodsInfo.height.intValue();
            this.button_text = goodsInfo.button_text;
            this.button_url = goodsInfo.button_url;
            this.ffU = new ArrayList<>();
            if (goodsInfo.thread_pic_list != null) {
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.ffU.add(threadPicList.pic);
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
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.PT = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        public boolean c(ICardInfo iCardInfo) {
            int ac = com.baidu.adp.lib.c.e.dN().ac("is_support_lego_ad_style");
            if (!TextUtils.isEmpty(this.lego_card)) {
                return (ac == 0 || iCardInfo == null) ? false : true;
            } else if (this.ffT == 1001) {
                return true;
            } else {
                return this.ffT == 7 ? this.video_info != null && !StringUtils.isNull(this.video_info.video_url) && this.video_info.video_height.intValue() > 0 && this.video_info.video_width.intValue() > 0 && this.video_info.video_duration.intValue() > 0 : this.ffT == 2 ? !StringUtils.isNull(this.thread_pic) : this.ffT == 6 && this.ffU != null && this.ffU.size() > 0;
            }
        }
    }
}
