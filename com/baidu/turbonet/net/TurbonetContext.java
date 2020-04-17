package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class TurbonetContext {
    private String lLA;
    private TurbonetEngine lLa;
    private String mAppName;
    private Context mContext;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.lLA = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine djG() {
        return this.lLa;
    }

    public long djH() {
        return this.lLa.diQ();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.lLa = builder.Nd(this.mAppName).Nc(this.lLA).djQ();
        } else {
            if (turbonetConfig.djF()) {
                builder.Nb(turbonetConfig.djE());
            }
            try {
                if (turbonetConfig.djD().has("nq") && turbonetConfig.djD().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.D(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.lLa = builder.Nd(this.mAppName).Nc(this.lLA).Ne(turbonetConfig.djD().toString()).djQ();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
