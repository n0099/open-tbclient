package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String oTK;
    private TurbonetEngine oTo;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oTK = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine egV() {
        return this.oTo;
    }

    public long egW() {
        return this.oTo.egq();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oTo = builder.Xo(this.mAppName).Xn(this.oTK).ehd();
        } else {
            if (turbonetConfig.egU()) {
                builder.Xm(turbonetConfig.egT());
            }
            try {
                if (turbonetConfig.egS().has("nq") && turbonetConfig.egS().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.S(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oTo = builder.Xo(this.mAppName).Xn(this.oTK).Xp(turbonetConfig.egS().toString()).ehd();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
