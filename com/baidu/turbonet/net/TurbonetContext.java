package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes14.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String oEX;
    private TurbonetEngine oEy;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oEX = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine ehP() {
        return this.oEy;
    }

    public long ehQ() {
        return this.oEy.eha();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oEy = builder.Xv(this.mAppName).Xu(this.oEX).ehZ();
        } else {
            if (turbonetConfig.ehO()) {
                builder.Xt(turbonetConfig.ehN());
            }
            try {
                if (turbonetConfig.ehM().has("nq") && turbonetConfig.ehM().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.J(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oEy = builder.Xv(this.mAppName).Xu(this.oEX).Xw(turbonetConfig.ehM().toString()).ehZ();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
