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
    public static Display f22671a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22672b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22673c;

    public static String a(Context context) {
        if (f22672b == 0) {
            if (f22671a == null) {
                f22671a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22671a.getWidth(), f22671a.getHeight());
            } else {
                f22671a.getSize(point);
            }
            f22672b = point.x;
            f22673c = point.y;
        }
        int[] iArr = {f22672b, f22673c};
        return iArr[0] + "x" + iArr[1];
    }
}
