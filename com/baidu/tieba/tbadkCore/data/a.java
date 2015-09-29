package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    public final int Ud;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int cYi;
    public final int cYj;
    public final int cYk;
    public final C0076a[] cYl;
    public C0076a cYm;
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
        this.cYi = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Ud = 0;
        this.abtest = null;
        this.cYj = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.cYk = 0;
        this.cYl = null;
        this.cYm = null;
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.cYi = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Ud = 0;
            this.price = null;
            this.abtest = null;
            this.cYj = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.cYk = 0;
            this.cYl = null;
            this.cYm = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.cYi = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Ud = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.cYj = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.cYk = app.app_time.intValue();
        this.cYl = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.cYm = new C0076a(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean rp() {
        if (this.cYi == 2) {
            return false;
        }
        return rq() || rr();
    }

    public boolean rq() {
        return (this.cYi != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean rr() {
        return this.cYi == 1 && !StringUtils.isNull(this.url);
    }

    /* renamed from: com.baidu.tieba.tbadkCore.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0076a extends com.baidu.adp.lib.a.b.a.a.i {
        public final boolean Uu;
        public final String cYn;
        public final int cYo;
        public final ArrayList<String> cYp;
        public final int height;
        public final int id;
        public final String pop_window_text;
        public final String thread_pic;
        public final String thread_title;
        public final String user_name;
        public final String user_portrait;
        public final int width;

        public C0076a() {
            this.id = 0;
            this.user_name = null;
            this.user_portrait = null;
            this.thread_title = null;
            this.thread_pic = null;
            this.pop_window_text = null;
            this.cYn = null;
            this.cYo = 0;
            this.cYp = null;
            this.Uu = false;
            this.width = 0;
            this.height = 0;
        }

        public C0076a(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.cYo = 0;
                this.cYp = null;
                this.cYn = null;
                this.Uu = false;
                this.width = 0;
                this.height = 0;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = goodsInfo.thread_title;
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.cYo = goodsInfo.goods_style.intValue();
            this.cYn = goodsInfo.thread_content;
            this.Uu = goodsInfo.label_measure.intValue() == 2;
            this.width = goodsInfo.width.intValue();
            this.height = goodsInfo.height.intValue();
            this.cYp = new ArrayList<>();
            if (goodsInfo.thread_pic_list != null) {
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.cYp.add(threadPicList.pic);
                    }
                }
            }
        }
    }
}
