package com.baidu.webkit.internal.monitor;

import com.baidu.webkit.sdk.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public C0277a f26794a;

    /* renamed from: com.baidu.webkit.internal.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0277a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f26795a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26796b;

        /* renamed from: c  reason: collision with root package name */
        public long f26797c;

        /* renamed from: d  reason: collision with root package name */
        public long f26798d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f26799e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f26800f;

        /* renamed from: g  reason: collision with root package name */
        public Map<String, Long> f26801g;

        public C0277a() {
            this.f26796b = true;
            this.f26797c = -1L;
            this.f26798d = -1L;
            this.f26801g = new HashMap();
        }

        public /* synthetic */ C0277a(a aVar, byte b2) {
            this();
        }

        public final void a() {
            this.f26795a = false;
            this.f26796b = true;
            this.f26797c = -1L;
            this.f26798d = -1L;
            this.f26799e = false;
            this.f26800f = false;
            this.f26801g.clear();
        }
    }

    public final JSONObject a() {
        try {
            if (this.f26794a != null && this.f26794a.f26800f) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("coldbootfirst", this.f26794a.f26795a);
                jSONObject.put("loadasycsearch", this.f26794a.f26796b);
                jSONObject.put("starttosearch", this.f26794a.f26797c);
                jSONObject.put("starttofragment", this.f26794a.f26798d);
                jSONObject.put("state50", this.f26794a.f26799e);
                for (String str : this.f26794a.f26801g.keySet()) {
                    jSONObject.put(str, this.f26794a.f26801g.get(str));
                }
                this.f26794a.a();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            Log.printStackTrace(th);
            this.f26794a.a();
            return null;
        }
    }
}
