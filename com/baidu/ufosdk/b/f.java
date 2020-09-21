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
    private static Display a;
    private static int b;
    private static int c;

    public static String a(Context context) {
        if (b == 0) {
            if (a == null) {
                a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(a.getWidth(), a.getHeight());
            } else {
                a.getSize(point);
            }
            b = point.x;
            c = point.y;
        }
        int[] iArr = {b, c};
        return iArr[0] + "x" + iArr[1];
    }
}
