package com.baidu.tieba.tbadkCore.b;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    public final int Dw;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int bYm;
    public final int bYn;
    public final int bYo;
    public final b[] bYp;
    public b bYq;
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
        this.bYm = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Dw = 0;
        this.abtest = null;
        this.bYn = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.bYo = 0;
        this.bYp = null;
        this.bYq = null;
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.bYm = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Dw = 0;
            this.price = null;
            this.abtest = null;
            this.bYn = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.bYo = 0;
            this.bYp = null;
            this.bYq = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.bYm = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Dw = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.bYn = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.bYo = app.app_time.intValue();
        this.bYp = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.bYq = new b(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean mu() {
        if (this.bYm == 2) {
            return false;
        }
        return mv() || mw();
    }

    public boolean mv() {
        return (this.bYm != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean mw() {
        return this.bYm == 1 && !StringUtils.isNull(this.url);
    }
}
