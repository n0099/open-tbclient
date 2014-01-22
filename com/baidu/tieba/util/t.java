package com.baidu.tieba.util;

import android.widget.Toast;
/* loaded from: classes.dex */
final class t implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Toast toast;
        Toast toast2;
        toast = s.a;
        if (toast != null) {
            toast2 = s.a;
            toast2.cancel();
        }
    }
}
