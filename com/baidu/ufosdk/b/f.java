package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ufosdk.f.j;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Display f5645a;

    /* renamed from: b  reason: collision with root package name */
    private static int f5646b;
    private static int c;

    public static String a(Context context) {
        if (f5646b == 0) {
            if (f5645a == null) {
                f5645a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f5645a.getWidth(), f5645a.getHeight());
            } else {
                f5645a.getSize(point);
            }
            f5646b = point.x;
            c = point.y;
        }
        int[] iArr = {f5646b, c};
        return iArr[0] + "x" + iArr[1];
    }
}
