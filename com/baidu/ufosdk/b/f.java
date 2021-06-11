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
    public static Display f22589a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22590b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22591c;

    public static String a(Context context) {
        if (f22590b == 0) {
            if (f22589a == null) {
                f22589a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22589a.getWidth(), f22589a.getHeight());
            } else {
                f22589a.getSize(point);
            }
            f22590b = point.x;
            f22591c = point.y;
        }
        int[] iArr = {f22590b, f22591c};
        return iArr[0] + "x" + iArr[1];
    }
}
