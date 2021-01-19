package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes4.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine oGB;
    private String oGX;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oGX = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine een() {
        return this.oGB;
    }

    public long eeo() {
        return this.oGB.edI();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oGB = builder.VW(this.mAppName).VV(this.oGX).eev();
        } else {
            if (turbonetConfig.eem()) {
                builder.VU(turbonetConfig.eel());
            }
            try {
                if (turbonetConfig.eek().has("nq") && turbonetConfig.eek().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.K(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oGB = builder.VW(this.mAppName).VV(this.oGX).VX(turbonetConfig.eek().toString()).eev();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
