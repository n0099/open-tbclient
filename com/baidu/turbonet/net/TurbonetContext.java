package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private TurbonetEngine mfD;
    private String mgd;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.mgd = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dri() {
        return this.mfD;
    }

    public long drj() {
        return this.mfD.dqs();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.mfD = builder.OU(this.mAppName).OT(this.mgd).drs();
        } else {
            if (turbonetConfig.drh()) {
                builder.OS(turbonetConfig.drg());
            }
            try {
                if (turbonetConfig.drf().has("nq") && turbonetConfig.drf().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.D(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.mfD = builder.OU(this.mAppName).OT(this.mgd).OV(turbonetConfig.drf().toString()).drs();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
