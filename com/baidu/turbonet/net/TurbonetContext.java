package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes15.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine nmS;
    private String nnt;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.nnt = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dOZ() {
        return this.nmS;
    }

    public long dPa() {
        return this.nmS.dOj();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.nmS = builder.TQ(this.mAppName).TP(this.nnt).dPj();
        } else {
            if (turbonetConfig.dOY()) {
                builder.TO(turbonetConfig.dOX());
            }
            try {
                if (turbonetConfig.dOW().has("nq") && turbonetConfig.dOW().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.G(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.nmS = builder.TQ(this.mAppName).TP(this.nnt).TR(turbonetConfig.dOW().toString()).dPj();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
