package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes17.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine onV;
    private String oov;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oov = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine eck() {
        return this.onV;
    }

    public long ecl() {
        return this.onV.ebv();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.onV = builder.Wv(this.mAppName).Wu(this.oov).ecu();
        } else {
            if (turbonetConfig.ecj()) {
                builder.Wt(turbonetConfig.eci());
            }
            try {
                if (turbonetConfig.ech().has("nq") && turbonetConfig.ech().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.I(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.onV = builder.Wv(this.mAppName).Wu(this.oov).Ww(turbonetConfig.ech().toString()).ecu();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
