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
    public static Display f22916a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22917b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22918c;

    public static String a(Context context) {
        if (f22917b == 0) {
            if (f22916a == null) {
                f22916a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22916a.getWidth(), f22916a.getHeight());
            } else {
                f22916a.getSize(point);
            }
            f22917b = point.x;
            f22918c = point.y;
        }
        int[] iArr = {f22917b, f22918c};
        return iArr[0] + "x" + iArr[1];
    }
}
