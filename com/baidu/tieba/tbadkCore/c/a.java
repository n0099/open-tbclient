package com.baidu.tieba.tbadkCore.c;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    public final int Ph;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int cnS;
    public final int cnT;
    public final int cnU;
    public final b[] cnV;
    public b cnW;
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
        this.cnS = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Ph = 0;
        this.abtest = null;
        this.cnT = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.cnU = 0;
        this.cnV = null;
        this.cnW = null;
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.cnS = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Ph = 0;
            this.price = null;
            this.abtest = null;
            this.cnT = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.cnU = 0;
            this.cnV = null;
            this.cnW = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.cnS = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Ph = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.cnT = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.cnU = app.app_time.intValue();
        this.cnV = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.cnW = new b(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean pO() {
        if (this.cnS == 2) {
            return false;
        }
        return pP() || pQ();
    }

    public boolean pP() {
        return (this.cnS != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean pQ() {
        return this.cnS == 1 && !StringUtils.isNull(this.url);
    }
}
