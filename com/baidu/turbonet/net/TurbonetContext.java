package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes19.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine mJE;
    private String mKf;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.mKf = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dze() {
        return this.mJE;
    }

    public long dzf() {
        return this.mJE.dyo();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.mJE = builder.Qs(this.mAppName).Qr(this.mKf).dzo();
        } else {
            if (turbonetConfig.dzd()) {
                builder.Qq(turbonetConfig.dzc());
            }
            try {
                if (turbonetConfig.dzb().has("nq") && turbonetConfig.dzb().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.F(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.mJE = builder.Qs(this.mAppName).Qr(this.mKf).Qt(turbonetConfig.dzb().toString()).dzo();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
