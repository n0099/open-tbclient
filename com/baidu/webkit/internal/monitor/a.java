package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0271a f26680a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0271a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26681a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26682b;

        /* renamed from: c  reason: collision with root package name */
        public long f26683c;

        /* renamed from: d  reason: collision with root package name */
        public long f26684d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26685e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26686f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26687g;

        public C0271a() {
            this.f26682b = true;
            this.f26683c = -1L;
            this.f26684d = -1L;
            this.f26687g = new HashMap();
        }

        public /* synthetic */ C0271a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26681a = false;
            this.f26682b = true;
            this.f26683c = -1L;
            this.f26684d = -1L;
            this.f26685e = false;
            this.f26686f = false;
            this.f26687g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26680a != null && this.f26680a.f26686f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26680a.f26681a);
                jSONObject.put("loadasycsearch", this.f26680a.f26682b);
                jSONObject.put("starttosearch", this.f26680a.f26683c);
                jSONObject.put("starttofragment", this.f26680a.f26684d);
                jSONObject.put("state50", this.f26680a.f26685e);
                for (String str : this.f26680a.f26687g.keySet()) {
                    jSONObject.put(str, this.f26680a.f26687g.get(str));
                }
                this.f26680a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26680a.a();
            return null;
        }
    }
}
