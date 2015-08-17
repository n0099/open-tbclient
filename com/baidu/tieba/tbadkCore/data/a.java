package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    public final int Uq;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int cIr;
    public final int cIs;
    public final int cIt;
    public final C0071a[] cIu;
    public C0071a cIv;
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

    public a() {
        this.id = null;
        this.name = null;
        this.cIr = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Uq = 0;
        this.abtest = null;
        this.cIs = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.cIt = 0;
        this.cIu = null;
        this.cIv = null;
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.cIr = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Uq = 0;
            this.price = null;
            this.abtest = null;
            this.cIs = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.cIt = 0;
            this.cIu = null;
            this.cIv = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.cIr = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Uq = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.cIs = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.cIt = app.app_time.intValue();
        this.cIu = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.cIv = new C0071a(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean rv() {
        if (this.cIr == 2) {
            return false;
        }
        return rw() || rx();
    }

    public boolean rw() {
        return (this.cIr != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean rx() {
        return this.cIr == 1 && !StringUtils.isNull(this.url);
    }

    /* renamed from: com.baidu.tieba.tbadkCore.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071a extends com.baidu.adp.lib.a.b.a.a.i {
        public final int cIw;
        public final int id;
        public final String pop_window_text;
        public final String thread_pic;
        public final String thread_title;
        public final String user_name;
        public final String user_portrait;

        public C0071a() {
            this.id = 0;
            this.user_name = null;
            this.user_portrait = null;
            this.thread_title = null;
            this.thread_pic = null;
            this.pop_window_text = null;
            this.cIw = 0;
        }

        public C0071a(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.cIw = 0;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = goodsInfo.thread_title;
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.cIw = goodsInfo.goods_style.intValue();
        }
    }
}
