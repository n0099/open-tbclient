package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes10.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine ncT;
    private String ndu;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.ndu = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dLb() {
        return this.ncT;
    }

    public long dLc() {
        return this.ncT.dKl();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.ncT = builder.Tr(this.mAppName).Tq(this.ndu).dLl();
        } else {
            if (turbonetConfig.dLa()) {
                builder.Tp(turbonetConfig.dKZ());
            }
            try {
                if (turbonetConfig.dKY().has("nq") && turbonetConfig.dKY().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.G(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.ncT = builder.Tr(this.mAppName).Tq(this.ndu).Ts(turbonetConfig.dKY().toString()).dLl();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
