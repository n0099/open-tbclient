package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ba;
import java.util.ArrayList;
import tbclient.App;
import tbclient.GoodsInfo;
import tbclient.ThreadPicList;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.a.b.a.a.i {
    public final String Pd;
    public final int Pi;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final String ext_info;
    public final String first_name;
    public final int frP;
    public final int frQ;
    public final int frR;
    public final a[] frS;
    public a frT;
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
        this.id = null;
        this.name = null;
        this.frP = 0;
        this.Pd = null;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Pi = 0;
        this.abtest = null;
        this.frQ = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.frR = 0;
        this.frS = null;
        this.frT = null;
    }

    public e(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.frP = 0;
            this.Pd = null;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Pi = 0;
            this.price = null;
            this.abtest = null;
            this.frQ = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.frR = 0;
            this.frS = null;
            this.frT = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.frP = app.url_type.intValue();
        this.Pd = app.deep_url;
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Pi = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.frQ = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.frR = app.app_time.intValue();
        this.frS = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.frT = new a(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean pg() {
        if (this.frT == null || !this.frT.isValid() || this.frP == 2) {
            return false;
        }
        return ph() || pi();
    }

    public boolean ph() {
        return (this.frP != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean pi() {
        return this.frP == 1 && !StringUtils.isNull(this.url);
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.lib.a.b.a.a.i {
        public String HT;
        public final boolean PC;
        public final String PE;
        public String PF;
        public float PG;
        public String Pz;
        public final String frU;
        public final int frV;
        public final ArrayList<String> frW;
        public final VideoInfo frX;
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
            this.frU = null;
            this.frV = 0;
            this.frW = null;
            this.PC = false;
            this.width = 0;
            this.height = 0;
            this.frX = null;
            this.PE = null;
            this.PF = null;
            this.PG = 1.0f;
        }

        public a(GoodsInfo goodsInfo) {
            if (goodsInfo == null) {
                this.id = 0;
                this.user_name = null;
                this.user_portrait = null;
                this.thread_title = null;
                this.thread_pic = null;
                this.pop_window_text = null;
                this.frV = 0;
                this.frW = null;
                this.frU = null;
                this.PC = false;
                this.width = 0;
                this.height = 0;
                this.frX = null;
                this.PE = null;
                this.PF = null;
                this.PG = 1.0f;
                return;
            }
            this.id = goodsInfo.id.intValue();
            this.user_name = goodsInfo.user_name;
            this.user_portrait = goodsInfo.user_portrait;
            this.thread_title = ba.c(goodsInfo.thread_title, 29, "...");
            this.thread_pic = goodsInfo.thread_pic;
            this.pop_window_text = goodsInfo.pop_window_text;
            this.frV = goodsInfo.goods_style.intValue();
            this.frU = goodsInfo.thread_content;
            this.PC = goodsInfo.label_measure.intValue() == 2;
            this.width = goodsInfo.width.intValue();
            this.height = goodsInfo.height.intValue();
            this.HT = goodsInfo.button_text;
            this.Pz = goodsInfo.button_url;
            this.frW = new ArrayList<>();
            if (goodsInfo.thread_pic_list != null) {
                for (ThreadPicList threadPicList : goodsInfo.thread_pic_list) {
                    if (threadPicList != null && !StringUtils.isNull(threadPicList.pic)) {
                        this.frW.add(threadPicList.pic);
                    }
                }
            }
            this.frX = goodsInfo.video_info;
            this.PE = goodsInfo.tag_name;
            this.PF = goodsInfo.tag_name_url;
            String str = goodsInfo.tag_name_wh;
            if (str != null) {
                try {
                    String[] split = str.split(",");
                    int g = com.baidu.adp.lib.h.b.g(split[0], 1);
                    int g2 = com.baidu.adp.lib.h.b.g(split[1], 1);
                    if (g2 != 0) {
                        this.PG = g / g2;
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        }

        public boolean isValid() {
            return this.frV == 7 ? this.frX != null && !StringUtils.isNull(this.frX.video_url) && this.frX.video_height.intValue() > 0 && this.frX.video_width.intValue() > 0 && this.frX.video_duration.intValue() > 0 : this.frV == 2 ? !StringUtils.isNull(this.thread_pic) : this.frV == 6 && this.frW != null && this.frW.size() > 0;
        }
    }
}
