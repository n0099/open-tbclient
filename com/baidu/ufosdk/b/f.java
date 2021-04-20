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
    public static Display f22601a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22602b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22603c;

    public static String a(Context context) {
        if (f22602b == 0) {
            if (f22601a == null) {
                f22601a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22601a.getWidth(), f22601a.getHeight());
            } else {
                f22601a.getSize(point);
            }
            f22602b = point.x;
            f22603c = point.y;
        }
        int[] iArr = {f22602b, f22603c};
        return iArr[0] + "x" + iArr[1];
    }
}
