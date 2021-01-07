package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String oLB;
    private TurbonetEngine oLf;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oLB = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine eif() {
        return this.oLf;
    }

    public long eig() {
        return this.oLf.ehA();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oLf = builder.Xd(this.mAppName).Xc(this.oLB).ein();
        } else {
            if (turbonetConfig.eie()) {
                builder.Xb(turbonetConfig.eid());
            }
            try {
                if (turbonetConfig.eic().has("nq") && turbonetConfig.eic().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.K(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oLf = builder.Xd(this.mAppName).Xc(this.oLB).Xe(turbonetConfig.eic().toString()).ein();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
