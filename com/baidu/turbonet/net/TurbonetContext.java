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

    public TurbonetEngine eie() {
        return this.oLf;
    }

    public long eif() {
        return this.oLf.ehz();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oLf = builder.Xe(this.mAppName).Xd(this.oLB).eim();
        } else {
            if (turbonetConfig.eid()) {
                builder.Xc(turbonetConfig.eic());
            }
            try {
                if (turbonetConfig.eib().has("nq") && turbonetConfig.eib().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.K(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oLf = builder.Xe(this.mAppName).Xd(this.oLB).Xf(turbonetConfig.eib().toString()).eim();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
