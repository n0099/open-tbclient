package com;

import com.baidu.cloudsdk.common.util.CoordinateManager;
/* loaded from: classes.dex */
public class bi implements Runnable {
    final /* synthetic */ CoordinateManager a;

    public bi(CoordinateManager coordinateManager) {
        this.a = coordinateManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        CoordinateManager.a aVar;
        CoordinateManager.a aVar2;
        aVar = this.a.d;
        if (aVar.isCancelled()) {
            return;
        }
        aVar2 = this.a.d;
        aVar2.cancel(true);
    }
}
