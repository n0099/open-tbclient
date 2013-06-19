package com.baidu.tieba.nearby;

import com.baidu.mapapi.MapView;
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
        com.baidu.tieba.c.aj ajVar;
        com.baidu.tieba.c.aj ajVar2;
        com.baidu.tieba.c.aj ajVar3;
        com.baidu.tieba.d.a aVar;
        PostItemizedOverlay postItemizedOverlay;
        MapView mapView;
        ajVar = this.a.h;
        if (ajVar != null) {
            ajVar2 = this.a.h;
            if (ajVar2.a() != null) {
                ajVar3 = this.a.h;
                ArrayList a = ajVar3.a();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.size()) {
                        String e = ((com.baidu.tieba.a.ae) a.get(i2)).a().e();
                        aVar = this.a.g;
                        com.baidu.adp.widget.a.b d = aVar.d(e, new h(this));
                        if (d != null) {
                            postItemizedOverlay = this.a.f;
                            postItemizedOverlay.a(e, d);
                            mapView = this.a.b;
                            mapView.invalidate();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
