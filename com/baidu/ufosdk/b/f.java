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
    public static Display f22486a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22487b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22488c;

    public static String a(Context context) {
        if (f22487b == 0) {
            if (f22486a == null) {
                f22486a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22486a.getWidth(), f22486a.getHeight());
            } else {
                f22486a.getSize(point);
            }
            f22487b = point.x;
            f22488c = point.y;
        }
        int[] iArr = {f22487b, f22488c};
        return iArr[0] + "x" + iArr[1];
    }
}
