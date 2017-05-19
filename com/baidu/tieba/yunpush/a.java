package com.baidu.tieba.yunpush;

import android.util.Log;
/* loaded from: classes2.dex */
class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Log.e("BaiduYunPush", "push static init " + System.currentTimeMillis());
        PushStatic.boS();
    }
}
