package com.baidu.tieba.model;

import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class cc {
    private int f = 0;

    /* renamed from: a  reason: collision with root package name */
    private VersionData f1401a = new VersionData();
    private com.baidu.tieba.data.f b = new com.baidu.tieba.data.f();
    private com.baidu.tieba.data.h c = new com.baidu.tieba.data.h();
    private CombineDownload d = new CombineDownload();
    private at e = new at();

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1401a.parserJson(jSONObject.optJSONObject("version"));
                this.b.a(jSONObject.optJSONObject("client"));
                this.c.a(jSONObject.optJSONObject("config"));
                this.d.parserJson(jSONObject.optJSONObject("combine_download"));
                this.e.a(jSONObject.optJSONObject("mainbar"));
                this.f = jSONObject.optInt("sync_active", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }

    public com.baidu.tieba.data.h a() {
        return this.c;
    }

    public CombineDownload b() {
        return this.d;
    }

    public VersionData c() {
        return this.f1401a;
    }

    public com.baidu.tieba.data.f d() {
        return this.b;
    }
}
