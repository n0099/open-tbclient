package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes6.dex */
public class l extends n {
    public l(Context context) {
        super(context);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS logstatsbatch (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM + " INTEGER default 0" + SmallTailInfo.EMOTION_SUFFIX;
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f27590a.a("stats_serverbusy_retrycount", i);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f27590a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n
    public String c() {
        return "logstatsbatch";
    }
}
