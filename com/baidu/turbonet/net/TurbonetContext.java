package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes6.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String oRF;
    private TurbonetEngine oRj;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oRF = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine egN() {
        return this.oRj;
    }

    public long egO() {
        return this.oRj.egi();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oRj = builder.Xh(this.mAppName).Xg(this.oRF).egV();
        } else {
            if (turbonetConfig.egM()) {
                builder.Xf(turbonetConfig.egL());
            }
            try {
                if (turbonetConfig.egK().has("nq") && turbonetConfig.egK().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.S(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oRj = builder.Xh(this.mAppName).Xg(this.oRF).Xi(turbonetConfig.egK().toString()).egV();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
