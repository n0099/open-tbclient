package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.c;

import android.content.Context;
import android.os.Build;
/* loaded from: classes10.dex */
public abstract class d {
    public abstract void AT(boolean z);

    public abstract boolean computeScrollOffset();

    public abstract void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    public abstract int getCurrX();

    public abstract int getCurrY();

    public abstract boolean isFinished();

    public static d hD(Context context) {
        if (Build.VERSION.SDK_INT < 9) {
            return new c(context);
        }
        if (Build.VERSION.SDK_INT < 14) {
            return new a(context);
        }
        return new b(context);
    }
}
