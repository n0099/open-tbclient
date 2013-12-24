package com.baidu.tieba.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class s implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = r.a;
        if (toast != null) {
            toast2 = r.a;
            toast2.cancel();
        }
    }
}
