package com.baidu.tieba.nearby;

import java.util.ArrayList;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ NearbyMapActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NearbyMapActivity nearbyMapActivity) {
        this.a = nearbyMapActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.b.h hVar;
        com.baidu.tieba.b.h hVar2;
        com.baidu.tieba.b.h hVar3;
        com.baidu.tieba.c.a aVar;
        hVar = this.a.h;
        if (hVar != null) {
            hVar2 = this.a.h;
            if (hVar2.a() != null) {
                hVar3 = this.a.h;
                ArrayList a = hVar3.a();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.size()) {
                        aVar = this.a.g;
                        aVar.d(((com.baidu.tieba.a.ab) a.get(i2)).a().d(), new h(this));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
