package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes19.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine mJG;
    private String mKh;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.mKh = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dzf() {
        return this.mJG;
    }

    public long dzg() {
        return this.mJG.dyp();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.mJG = builder.Qs(this.mAppName).Qr(this.mKh).dzp();
        } else {
            if (turbonetConfig.dze()) {
                builder.Qq(turbonetConfig.dzd());
            }
            try {
                if (turbonetConfig.dzc().has("nq") && turbonetConfig.dzc().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.F(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.mJG = builder.Qs(this.mAppName).Qr(this.mKh).Qt(turbonetConfig.dzc().toString()).dzp();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
