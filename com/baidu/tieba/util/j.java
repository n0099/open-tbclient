package com.baidu.tieba.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class j implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = i.f2452a;
        if (toast != null) {
            toast2 = i.f2452a;
            toast2.cancel();
        }
    }
}
