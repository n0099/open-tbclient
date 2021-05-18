package com.baidu.webkit.sdk.performance;

import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class UMALogger {
    public static final String TAG = "UMALogger";
    public static UMALogger sDummyUMALogger;

    public static UMALogger getInstance() {
        if (!WebViewFactory.hasProvider() || WebViewFactory.getProvider().getUMALogger() == null) {
            if (sDummyUMALogger == null) {
                sDummyUMALogger = new UMALogger() { // from class: com.baidu.webkit.sdk.performance.UMALogger.1
                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCount1000HistogramSample(String str, int i2) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCount100HistogramSample(String str, int i2) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCount1MHistogramSample(String str, int i2) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCustomCountHistogramSample(String str, int i2, int i3, int i4, int i5) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addSpareHistogramSample(String str, int i2) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addTimesHistogramSample(String str, long j) {
                    }
                };
            }
            Log.i(TAG, "UMALogger.getInstance(), dummy UMALogger used");
            return sDummyUMALogger;
        }
        return WebViewFactory.getProvider().getUMALogger();
    }

    public abstract void addCount1000HistogramSample(String str, int i2);

    public abstract void addCount100HistogramSample(String str, int i2);

    public abstract void addCount1MHistogramSample(String str, int i2);

    public abstract void addCustomCountHistogramSample(String str, int i2, int i3, int i4, int i5);

    public abstract void addSpareHistogramSample(String str, int i2);

    public abstract void addTimesHistogramSample(String str, long j);

    public void record(JSONObject jSONObject, List<String> list, String str) {
        if (jSONObject == null) {
            return;
        }
        Log.i(TAG, BundleOpProvider.METHOD_BUNDLE_RECORD);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (list == null || !list.contains(next)) {
                String str2 = str + next;
                try {
                    long j = jSONObject.getLong(next);
                    Log.i(TAG, "adding " + str2 + "=" + j);
                    addTimesHistogramSample(str2, j);
                } catch (JSONException e2) {
                    Log.e(TAG, "failed to get long for ".concat(String.valueOf(next)), e2);
                }
            } else {
                Log.i(TAG, "skipping ".concat(String.valueOf(next)));
            }
        }
    }
}
