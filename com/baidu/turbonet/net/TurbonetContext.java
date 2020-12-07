package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes14.dex */
public final class TurbonetContext {
    private String mAppName;
    private Context mContext;
    private String oEV;
    private TurbonetEngine oEw;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.oEV = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine ehO() {
        return this.oEw;
    }

    public long ehP() {
        return this.oEw.egZ();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.oEw = builder.Xv(this.mAppName).Xu(this.oEV).ehY();
        } else {
            if (turbonetConfig.ehN()) {
                builder.Xt(turbonetConfig.ehM());
            }
            try {
                if (turbonetConfig.ehL().has("nq") && turbonetConfig.ehL().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.J(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.oEw = builder.Xv(this.mAppName).Xu(this.oEV).Xw(turbonetConfig.ehL().toString()).ehY();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
