package com.baidu.tieba.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class v implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        Toast toast;
        Toast toast2;
        toast = u.a;
        if (toast != null) {
            toast2 = u.a;
            toast2.cancel();
        }
    }
}
