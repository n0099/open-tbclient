package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.mobstat.Config;
import com.baidu.ufosdk.f.j;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Display f5364a;

    /* renamed from: b  reason: collision with root package name */
    private static int f5365b;
    private static int c;

    public static String a(Context context) {
        if (f5365b == 0) {
            if (f5364a == null) {
                f5364a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f5364a.getWidth(), f5364a.getHeight());
            } else {
                f5364a.getSize(point);
            }
            f5365b = point.x;
            c = point.y;
        }
        int[] iArr = {f5365b, c};
        return iArr[0] + Config.EVENT_HEAT_X + iArr[1];
    }
}
