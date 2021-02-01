package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes6.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine oQJ;
    private String oRf;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oRf = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine egF() {
        return this.oQJ;
    }

    public long egG() {
        return this.oQJ.ega();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oQJ = builder.WV(this.mAppName).WU(this.oRf).egN();
        } else {
            if (turbonetConfig.egE()) {
                builder.WT(turbonetConfig.egD());
            }
            try {
                if (turbonetConfig.egC().has("nq") && turbonetConfig.egC().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.S(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oQJ = builder.WV(this.mAppName).WU(this.oRf).WW(turbonetConfig.egC().toString()).egN();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
