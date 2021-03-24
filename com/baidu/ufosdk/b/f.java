package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ufosdk.f.j;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static Display f22915a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22916b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22917c;

    public static String a(Context context) {
        if (f22916b == 0) {
            if (f22915a == null) {
                f22915a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22915a.getWidth(), f22915a.getHeight());
            } else {
                f22915a.getSize(point);
            }
            f22916b = point.x;
            f22917c = point.y;
        }
        int[] iArr = {f22916b, f22917c};
        return iArr[0] + "x" + iArr[1];
    }
}
