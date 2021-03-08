package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
/* loaded from: classes6.dex */
public class l extends n {
    public l(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n
    public String c() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f4210a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f4210a.a("stats_serverbusy_retrycount", i);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS logstatsbatch (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }
}
