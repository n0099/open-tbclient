package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes12.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String opZ;
    private TurbonetEngine opz;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.opZ = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine ecj() {
        return this.opz;
    }

    public long eck() {
        return this.opz.ebu();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.opz = builder.Wg(this.mAppName).Wf(this.opZ).ect();
        } else {
            if (turbonetConfig.eci()) {
                builder.We(turbonetConfig.ech());
            }
            try {
                if (turbonetConfig.ecg().has("nq") && turbonetConfig.ecg().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.J(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.opz = builder.Wg(this.mAppName).Wf(this.opZ).Wh(turbonetConfig.ecg().toString()).ect();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
