package com.baidu.webkit.sdk.performance;

import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class UMALogger {
    public static final String TAG = "UMALogger";
    public static UMALogger sDummyUMALogger;

    public static UMALogger getInstance() {
        if (!WebViewFactory.hasProvider() || WebViewFactory.getProvider().getUMALogger() == null) {
            if (sDummyUMALogger == null) {
                sDummyUMALogger = new UMALogger() { // from class: com.baidu.webkit.sdk.performance.UMALogger.1
                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCount1000HistogramSample(String str, int i) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCount100HistogramSample(String str, int i) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCount1MHistogramSample(String str, int i) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addCustomCountHistogramSample(String str, int i, int i2, int i3, int i4) {
                    }

                    @Override // com.baidu.webkit.sdk.performance.UMALogger
                    public void addSpareHistogramSample(String str, int i) {
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

    public abstract void addCount1000HistogramSample(String str, int i);

    public abstract void addCount100HistogramSample(String str, int i);

    public abstract void addCount1MHistogramSample(String str, int i);

    public abstract void addCustomCountHistogramSample(String str, int i, int i2, int i3, int i4);

    public abstract void addSpareHistogramSample(String str, int i);

    public abstract void addTimesHistogramSample(String str, long j);

    public void record(JSONObject jSONObject, List<String> list, String str) {
        if (jSONObject == null) {
            return;
        }
        Log.i(TAG, "record");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (list == null || !list.contains(next)) {
                String str2 = str + next;
                try {
                    long j = jSONObject.getLong(next);
                    Log.i(TAG, "adding " + str2 + "=" + j);
                    addTimesHistogramSample(str2, j);
                } catch (JSONException e) {
                    Log.e(TAG, "failed to get long for ".concat(String.valueOf(next)), e);
                }
            } else {
                Log.i(TAG, "skipping ".concat(String.valueOf(next)));
            }
        }
    }
}
