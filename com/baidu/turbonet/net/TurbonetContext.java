package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class TurbonetContext {
    private String mAppName;
    private String mBU;
    private TurbonetEngine mBt;
    private Context mContext;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.mBU = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dvN() {
        return this.mBt;
    }

    public long dvO() {
        return this.mBt.duX();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.mBt = builder.PG(this.mAppName).PF(this.mBU).dvX();
        } else {
            if (turbonetConfig.dvM()) {
                builder.PE(turbonetConfig.dvL());
            }
            try {
                if (turbonetConfig.dvK().has("nq") && turbonetConfig.dvK().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.F(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.mBt = builder.PG(this.mAppName).PF(this.mBU).PH(turbonetConfig.dvK().toString()).dvX();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
