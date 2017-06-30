package com.baidu.tieba.yunpush;

import android.util.Log;
/* loaded from: classes2.dex */
class b implements Runnable {
    final /* synthetic */ a gns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.gns = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.e("BaiduYunPush", "push static init " + System.currentTimeMillis());
        PushStatic.access$0();
    }
}
