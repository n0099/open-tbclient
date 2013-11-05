package com.baidu.tieba.model;

import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class co {
    private int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private VersionData f1941a = new VersionData();
    private com.baidu.tieba.data.g b = new com.baidu.tieba.data.g();
    private com.baidu.tieba.data.i c = new com.baidu.tieba.data.i();
    private CombineDownload d = new CombineDownload();
    private be e = new be();

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
                this.f1941a.parserJson(jSONObject.optJSONObject("version"));
                this.b.a(jSONObject.optJSONObject("client"));
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
        return this.f1941a;
    }

    public com.baidu.tieba.data.g d() {
        return this.b;
    }
}
