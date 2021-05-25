package com.baidu.tieba.wallet;

import d.a.c.e.p.k;
import d.a.m0.r.d0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class YYLiveConfig {
    public int yyPayOpen = 0;
    public int yyIsConvert = 0;

    private void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.yyPayOpen = jSONObject.optInt("yy_pay_open");
            this.yyIsConvert = jSONObject.optInt("yy_is_convert");
        }
    }

    public boolean isYYPayNeedConfirm() {
        return this.yyPayOpen == 1 && this.yyIsConvert == 0;
    }

    public boolean isYyIsConvert() {
        return this.yyPayOpen == 1 && this.yyIsConvert == 1;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            parse(jSONObject);
            b.j().x("key_extra_yy_config", jSONObject.toString());
            return;
        }
        String p = b.j().p("key_extra_yy_config", "");
        if (!k.isEmpty(p)) {
            try {
                parse(new JSONObject(p));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        b.j().x("key_extra_yy_config", "");
    }

    public void updateStatusAndCache(int i2) {
        this.yyIsConvert = i2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("yy_pay_open", this.yyPayOpen);
            jSONObject.put("yy_is_convert", this.yyIsConvert);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b.j().x("key_extra_yy_config", jSONObject.toString());
    }
}
