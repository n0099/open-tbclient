package com.bytedance.sdk.openadsdk.core.video.e;

import android.os.Build;
import android.view.View;
import com.baidu.webkit.sdk.VideoCloudSetting;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f28699a = Build.VERSION.SDK_INT;

    public static int a(long j, long j2) {
        int i;
        if (j2 > 0) {
            double d2 = j;
            Double.isNaN(d2);
            double d3 = j2;
            Double.isNaN(d3);
            i = (int) (((d2 * 1.0d) / d3) * 100.0d);
        } else {
            i = 0;
        }
        return Math.min(Math.max(0, i), 100);
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = j / 60000;
        long j3 = ((j % VideoCloudSetting.HOUR_MILLISECOND) % 60000) / 1000;
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
        if (view == null) {
            return;
        }
        if (z) {
            view.setSystemUiVisibility(0);
            return;
        }
        int i = f28699a;
        if (i >= 19) {
            view.setSystemUiVisibility(3846);
        } else if (i >= 16) {
            view.setSystemUiVisibility(5);
        } else {
            view.setSystemUiVisibility(1);
        }
    }
}
