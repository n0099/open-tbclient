package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class TurbonetContext {

    /* renamed from: a  reason: collision with root package name */
    public TurbonetEngine f23233a;

    /* renamed from: b  reason: collision with root package name */
    public Context f23234b;

    /* renamed from: c  reason: collision with root package name */
    public String f23235c;

    /* renamed from: d  reason: collision with root package name */
    public String f23236d;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.f23234b = context;
        this.f23235c = str;
        this.f23236d = str2;
        a(turbonetConfig);
    }

    public final void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.f23234b);
        if (turbonetConfig == null) {
            builder.r(this.f23235c);
            builder.q(this.f23236d);
            this.f23233a = builder.b();
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
            builder.r(this.f23235c);
            builder.q(this.f23236d);
            builder.a(turbonetConfig.g().toString());
            this.f23233a = builder.b();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }

    public TurbonetEngine b() {
        return this.f23233a;
    }

    public long c() {
        return this.f23233a.d();
    }
}
