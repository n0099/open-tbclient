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
    public static Display f22557a;

    /* renamed from: b  reason: collision with root package name */
    public static int f22558b;

    /* renamed from: c  reason: collision with root package name */
    public static int f22559c;

    public static String a(Context context) {
        if (f22558b == 0) {
            if (f22557a == null) {
                f22557a = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            }
            Point point = new Point();
            if (j.a() < 13) {
                point.set(f22557a.getWidth(), f22557a.getHeight());
            } else {
                f22557a.getSize(point);
            }
            f22558b = point.x;
            f22559c = point.y;
        }
        int[] iArr = {f22558b, f22559c};
        return iArr[0] + "x" + iArr[1];
    }
}
