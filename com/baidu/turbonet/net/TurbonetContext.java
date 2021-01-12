package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes4.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine oGA;
    private String oGW;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oGW = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine een() {
        return this.oGA;
    }

    public long eeo() {
        return this.oGA.edI();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oGA = builder.VV(this.mAppName).VU(this.oGW).eev();
        } else {
            if (turbonetConfig.eem()) {
                builder.VT(turbonetConfig.eel());
            }
            try {
                if (turbonetConfig.eek().has("nq") && turbonetConfig.eek().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.K(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oGA = builder.VV(this.mAppName).VU(this.oGW).VW(turbonetConfig.eek().toString()).eev();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
