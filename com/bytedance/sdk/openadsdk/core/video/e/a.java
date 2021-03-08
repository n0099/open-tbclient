package com.bytedance.sdk.openadsdk.core.video.e;

import android.os.Build;
import android.view.View;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4545a = Build.VERSION.SDK_INT;

    public static int a(long j, long j2) {
        return Math.min(Math.max(0, j2 > 0 ? (int) (((j * 1.0d) / j2) * 100.0d) : 0), 100);
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / AppStatusRules.DEFAULT_GRANULARITY;
        long j3 = ((j % BdKVCache.MILLS_1Hour) % AppStatusRules.DEFAULT_GRANULARITY) / 1000;
        if (j2 >= 10) {
            sb.append(j2);
        } else if (j2 > 0) {
            sb.append(0);
            sb.append(j2);
        } else {
            sb.append(0);
            sb.append(0);
        }
        sb.append(":");
        if (j3 >= 10) {
            sb.append(j3);
        } else if (j3 > 0) {
            sb.append(0);
            sb.append(j3);
        } else {
            sb.append(0);
            sb.append(0);
        }
        return sb.toString();
    }

    public static void a(View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setSystemUiVisibility(0);
            } else if (f4545a >= 19) {
                view.setSystemUiVisibility(3846);
            } else if (f4545a >= 16) {
                view.setSystemUiVisibility(5);
            } else {
                view.setSystemUiVisibility(1);
            }
        }
    }
}
