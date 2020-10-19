package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes17.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String nCP;
    private TurbonetEngine nCp;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.nCP = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dSK() {
        return this.nCp;
    }

    public long dSL() {
        return this.nCp.dRV();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.nCp = builder.UE(this.mAppName).UD(this.nCP).dSU();
        } else {
            if (turbonetConfig.dSJ()) {
                builder.UC(turbonetConfig.dSI());
            }
            try {
                if (turbonetConfig.dSH().has("nq") && turbonetConfig.dSH().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.G(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.nCp = builder.UE(this.mAppName).UD(this.nCP).UF(turbonetConfig.dSH().toString()).dSU();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
