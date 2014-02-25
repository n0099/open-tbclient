package com.baidu.tieba.img.effects;

import android.graphics.Bitmap;
import com.baidu.tieba.util.n;
/* loaded from: classes.dex */
public abstract class b {
    public abstract Bitmap a(Bitmap bitmap, boolean z);

    public abstract String a();

    public abstract void b(String str);

    public Bitmap c(String str) {
        return a(n.a(str), true);
    }
}
