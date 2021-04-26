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
    public static Display f23312a;

    /* renamed from: b  reason: collision with root package name */
    public static int f23313b;

    /* renamed from: c  reason: collision with root package name */
    public static int f23314c;

    public static String a(Context context) {
        if (f23313b == 0) {
            if (f23312a == null) {
                f23312a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f23312a.getWidth(), f23312a.getHeight());
            } else {
                f23312a.getSize(point);
            }
            f23313b = point.x;
            f23314c = point.y;
        }
        int[] iArr = {f23313b, f23314c};
        return iArr[0] + "x" + iArr[1];
    }
}
