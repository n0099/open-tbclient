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
    public static Display f22609a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22610b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22611c;

    public static String a(Context context) {
        if (f22610b == 0) {
            if (f22609a == null) {
                f22609a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22609a.getWidth(), f22609a.getHeight());
            } else {
                f22609a.getSize(point);
            }
            f22610b = point.x;
            f22611c = point.y;
        }
        int[] iArr = {f22610b, f22611c};
        return iArr[0] + "x" + iArr[1];
    }
}
