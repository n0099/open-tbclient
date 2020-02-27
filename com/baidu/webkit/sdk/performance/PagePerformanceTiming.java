package com.baidu.webkit.sdk.performance;
/* loaded from: classes11.dex */
public interface PagePerformanceTiming {
    PagePerformanceTimingData getTimingData(String str);

    String getTimingString(String str, boolean z);

    void markLoadUrlFinish(String str);

    void markLoadUrlStart(String str);

    PageLongTaskData takeLongTaskData(String str);
}
