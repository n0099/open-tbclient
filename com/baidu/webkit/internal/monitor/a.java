package com.baidu.webkit.internal.monitor;

import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.webkit.sdk.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {
    long a = -1;
    long b = -1;
    long c = -1;

    private void b() {
        this.a = -1L;
        this.b = -1L;
        this.c = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JSONObject a() {
        if (this.a == -1 && this.b == -1 && this.c == -1) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.a != -1) {
                jSONObject.put(AiAppsUBCStatistic.TYPE_CLICK, this.a);
            }
            if (this.b != -1) {
                jSONObject.put("evajs", this.b);
            }
            if (this.c != -1) {
                jSONObject.put("loadurl", this.c);
            }
            b();
            return jSONObject;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            b();
            return null;
        }
    }
}
