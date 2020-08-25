package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes10.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine ncB;
    private String ndc;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.ndc = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dKS() {
        return this.ncB;
    }

    public long dKT() {
        return this.ncB.dKc();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.ncB = builder.Tr(this.mAppName).Tq(this.ndc).dLc();
        } else {
            if (turbonetConfig.dKR()) {
                builder.Tp(turbonetConfig.dKQ());
            }
            try {
                if (turbonetConfig.dKP().has("nq") && turbonetConfig.dKP().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.G(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.ncB = builder.Tr(this.mAppName).Tq(this.ndc).Ts(turbonetConfig.dKP().toString()).dLc();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
