package com.baidu.tieba.tbadkCore.c;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    public final int Pf;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int cnC;
    public final int cnD;
    public final int cnE;
    public final b[] cnF;
    public b cnG;
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
        this.cnC = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.Pf = 0;
        this.abtest = null;
        this.cnD = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.cnE = 0;
        this.cnF = null;
        this.cnG = null;
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.cnC = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.Pf = 0;
            this.price = null;
            this.abtest = null;
            this.cnD = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.cnE = 0;
            this.cnF = null;
            this.cnG = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.cnC = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.Pf = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.cnD = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.cnE = app.app_time.intValue();
        this.cnF = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.cnG = new b(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean pO() {
        if (this.cnC == 2) {
            return false;
        }
        return pP() || pQ();
    }

    public boolean pP() {
        return (this.cnC != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean pQ() {
        return this.cnC == 1 && !StringUtils.isNull(this.url);
    }
}
