package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.ufosdk.f.j;
@SuppressLint({"NewApi"})
/* loaded from: classes21.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Display f3704a;
    private static int b;
    private static int c;

    public static String a(Context context) {
        if (b == 0) {
            if (f3704a == null) {
                f3704a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f3704a.getWidth(), f3704a.getHeight());
            } else {
                f3704a.getSize(point);
            }
            b = point.x;
            c = point.y;
        }
        int[] iArr = {b, c};
        return iArr[0] + "x" + iArr[1];
    }
}
