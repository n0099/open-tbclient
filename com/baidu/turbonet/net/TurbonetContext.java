package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class TurbonetContext {
    private String lLE;
    private TurbonetEngine lLe;
    private String mAppName;
    private Context mContext;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.lLE = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine djE() {
        return this.lLe;
    }

    public long djF() {
        return this.lLe.diO();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.lLe = builder.Ng(this.mAppName).Nf(this.lLE).djO();
        } else {
            if (turbonetConfig.djD()) {
                builder.Ne(turbonetConfig.djC());
            }
            try {
                if (turbonetConfig.djB().has("nq") && turbonetConfig.djB().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.D(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.lLe = builder.Ng(this.mAppName).Nf(this.lLE).Nh(turbonetConfig.djB().toString()).djO();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
