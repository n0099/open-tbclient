package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class TurbonetContext {

    /* renamed from: a  reason: collision with root package name */
    public TurbonetEngine f22527a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22528b;

    /* renamed from: c  reason: collision with root package name */
    public String f22529c;

    /* renamed from: d  reason: collision with root package name */
    public String f22530d;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.f22528b = context;
        this.f22529c = str;
        this.f22530d = str2;
        a(turbonetConfig);
    }

    public final void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.f22528b);
        if (turbonetConfig == null) {
            builder.r(this.f22529c);
            builder.q(this.f22530d);
            this.f22527a = builder.b();
        } else {
            if (turbonetConfig.h()) {
                builder.u(turbonetConfig.l());
            }
            try {
                if (turbonetConfig.g().has("nq") && turbonetConfig.g().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.e(true, "");
                }
            } catch (JSONException e2) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e2);
            }
            builder.r(this.f22529c);
            builder.q(this.f22530d);
            builder.a(turbonetConfig.g().toString());
            this.f22527a = builder.b();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }

    public TurbonetEngine b() {
        return this.f22527a;
    }

    public long c() {
        return this.f22527a.d();
    }
}
