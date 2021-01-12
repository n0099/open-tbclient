package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.mobstat.Config;
import com.baidu.ufosdk.f.j;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static Display f5362a;

    /* renamed from: b  reason: collision with root package name */
    private static int f5363b;
    private static int c;

    public static String a(Context context) {
        if (f5363b == 0) {
            if (f5362a == null) {
                f5362a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f5362a.getWidth(), f5362a.getHeight());
            } else {
                f5362a.getSize(point);
            }
            f5363b = point.x;
            c = point.y;
        }
        int[] iArr = {f5363b, c};
        return iArr[0] + Config.EVENT_HEAT_X + iArr[1];
    }
}
