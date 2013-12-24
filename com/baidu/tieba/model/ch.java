package com.baidu.tieba.model;

import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ch {
    private int f = 0;
    private VersionData a = new VersionData();
    private com.baidu.tieba.data.g b = new com.baidu.tieba.data.g();
    private com.baidu.tieba.data.i c = new com.baidu.tieba.data.i();
    private CombineDownload d = new CombineDownload();
    private bf e = new bf();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a.parserJson(jSONObject.optJSONObject("version"));
                this.b.a(jSONObject.optJSONObject("client"));
                com.baidu.tieba.util.p.a(jSONObject.optString("client_ip", null));
                this.c.a(jSONObject.optJSONObject("config"));
                this.d.parserJson(jSONObject.optJSONObject("combine_download"));
                this.e.a(jSONObject.optJSONObject("mainbar"));
                this.f = jSONObject.optInt("sync_active", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public com.baidu.tieba.data.i a() {
        return this.c;
    }

    public CombineDownload b() {
        return this.d;
    }

    public VersionData c() {
        return this.a;
    }

    public com.baidu.tieba.data.g d() {
        return this.b;
    }
}
