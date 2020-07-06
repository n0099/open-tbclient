package com.baidu.turbonet.net;

import android.content.Context;
import android.util.Log;
import com.baidu.turbonet.net.TurbonetEngine;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class TurbonetContext {
    private String mAppName;
    private String mBX;
    private TurbonetEngine mBw;
    private Context mContext;

    public TurbonetContext(Context context, String str, String str2, TurbonetConfig turbonetConfig) {
        this.mContext = context;
        this.mAppName = str;
        this.mBX = str2;
        a(turbonetConfig);
    }

    public TurbonetEngine dvR() {
        return this.mBw;
    }

    public long dvS() {
        return this.mBw.dvb();
    }

    private void a(TurbonetConfig turbonetConfig) {
        TurbonetEngine.Builder builder = new TurbonetEngine.Builder(this.mContext);
        if (turbonetConfig == null) {
            this.mBw = builder.PH(this.mAppName).PG(this.mBX).dwb();
        } else {
            if (turbonetConfig.dvQ()) {
                builder.PF(turbonetConfig.dvP());
            }
            try {
                if (turbonetConfig.dvO().has("nq") && turbonetConfig.dvO().getJSONObject("nq").getBoolean("network_quality_enabled")) {
                    builder.F(true, "");
                }
            } catch (JSONException e) {
                Log.e("cr_TurbonetContext", "JSON expcetion: " + e);
            }
            this.mBw = builder.PH(this.mAppName).PG(this.mBX).PI(turbonetConfig.dvO().toString()).dwb();
        }
        Log.v("cr_TurbonetContext", "Turbonet init context success.");
    }
}
