package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes17.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine oeQ;
    private String ofr;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.ofr = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dYC() {
        return this.oeQ;
    }

    public long dYD() {
        return this.oeQ.dXN();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oeQ = builder.VS(this.mAppName).VR(this.ofr).dYM();
        } else {
            if (turbonetConfig.dYB()) {
                builder.VQ(turbonetConfig.dYA());
            }
            try {
                if (turbonetConfig.dYz().has("nq") && turbonetConfig.dYz().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.I(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oeQ = builder.VS(this.mAppName).VR(this.ofr).VT(turbonetConfig.dYz().toString()).dYM();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
