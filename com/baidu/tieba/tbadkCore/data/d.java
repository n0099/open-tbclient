package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ax;
import java.util.ArrayList;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.a.b.a.a.i {
    public final int UW;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int dGt;
    public final int dGu;
    public final int dGv;
    public final a[] dGw;
    public a dGx;
    public final String ext_info;
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

    public d() {
        this.id = null;
        this.name = null;
        this.dGt = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.UW = 0;
        this.abtest = null;
        this.dGu = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.dGv = 0;
        this.dGw = null;
        this.dGx = null;
    }

    public d(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.dGt = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.UW = 0;
            this.price = null;
            this.abtest = null;
            this.dGu = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.dGv = 0;
            this.dGw = null;
            this.dGx = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.dGt = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.UW = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.dGu = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.dGv = app.app_time.intValue();
        this.dGw = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.dGx = new a(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean rk() {
        if (this.dGt == 2) {
            return false;
        }
        return rl() || rm();
    }

    public boolean rl() {
        return (this.dGt != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean rm() {
        return this.dGt == 1 && !StringUtils.isNull(this.url);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.lib.a.b.a.a.i {
        public final boolean Vn;
        public final ArrayList<String> dGA;
        public final String dGy;
        public final int dGz;
        public final int height;
        public final int id;
        public final String pop_window_text;
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
            this.dGy = null;
            this.dGz = 0;
            this.dGA = null;
            this.Vn = false;
            this.width = 0;
            this.height = 0;
        }

        public a(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.dGz = 0;
                this.dGA = null;
                this.dGy = null;
                this.Vn = false;
                this.width = 0;
                this.height = 0;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = ax.d(goodsInfo.thread_title, 29, "...");
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.dGz = goodsInfo.goods_style.intValue();
            this.dGy = goodsInfo.thread_content;
            this.Vn = goodsInfo.label_measure.intValue() == 2;
            this.width = goodsInfo.width.intValue();
            this.height = goodsInfo.height.intValue();
            this.dGA = new ArrayList<>();
            if (goodsInfo.thread_pic_list != null) {
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.dGA.add(threadPicList.pic);
                    }
                }
            }
        }
    }
}
