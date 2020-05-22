package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String meT;
    private TurbonetEngine met;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.meT = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dqU() {
        return this.met;
    }

    public long dqV() {
        return this.met.dqe();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.met = builder.OT(this.mAppName).OS(this.meT).dre();
        } else {
            if (turbonetConfig.dqT()) {
                builder.OR(turbonetConfig.dqS());
            }
            try {
                if (turbonetConfig.dqR().has("nq") && turbonetConfig.dqR().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.D(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.met = builder.OT(this.mAppName).OS(this.meT).OU(turbonetConfig.dqR().toString()).dre();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
