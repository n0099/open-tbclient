package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.lib.util.StringUtils;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.a.b.a.a.i {
    public final int PC;
    public final String abtest;
    public final String apk_name;
    public final String apk_url;
    public final int crR;
    public final int crS;
    public final int crT;
    public final b[] crU;
    public b crV;
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
        this.crR = 0;
        this.url = null;
        this.ios_url = null;
        this.apk_url = null;
        this.apk_name = null;
        this.pos_name = null;
        this.first_name = null;
        this.second_name = null;
        this.price = null;
        this.PC = 0;
        this.abtest = null;
        this.crS = 0;
        this.user_id = null;
        this.verify = null;
        this.ext_info = null;
        this.crT = 0;
        this.crU = null;
        this.crV = null;
    }

    public a(App app) {
        if (app == null) {
            this.id = null;
            this.name = null;
            this.crR = 0;
            this.url = null;
            this.ios_url = null;
            this.apk_url = null;
            this.apk_name = null;
            this.pos_name = null;
            this.first_name = null;
            this.second_name = null;
            this.PC = 0;
            this.price = null;
            this.abtest = null;
            this.crS = 0;
            this.user_id = null;
            this.verify = null;
            this.ext_info = null;
            this.crT = 0;
            this.crU = null;
            this.crV = null;
            return;
        }
        this.id = app.id;
        this.name = app.name;
        this.crR = app.url_type.intValue();
        this.url = app.url;
        this.apk_url = app.apk_url;
        this.apk_name = app.apk_name;
        this.ios_url = app.ios_url;
        this.pos_name = app.pos_name;
        this.first_name = app.first_name;
        this.second_name = app.second_name;
        this.PC = app.cpid.intValue();
        this.price = app.price;
        this.abtest = app.abtest;
        this.crS = app.plan_id.intValue();
        this.user_id = app.user_id;
        this.verify = app.verify;
        this.ext_info = app.ext_info;
        this.crT = app.app_time.intValue();
        this.crU = null;
        if (app.goods_info != null) {
            for (GoodsInfo goodsInfo : app.goods_info) {
                if (goodsInfo != null) {
                    this.crV = new b(goodsInfo);
                    return;
                }
            }
        }
    }

    public boolean qu() {
        if (this.crR == 2) {
            return false;
        }
        return qv() || qw();
    }

    public boolean qv() {
        return (this.crR != 3 || StringUtils.isNull(this.apk_name) || StringUtils.isNull(this.apk_url)) ? false : true;
    }

    public boolean qw() {
        return this.crR == 1 && !StringUtils.isNull(this.url);
    }
}
