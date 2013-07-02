package com.baidu.tieba.nearby;

import com.baidu.mapapi.MapView;
import com.baidu.tieba.data.MapPostItem;
import com.baidu.tieba.model.MapOverlayModel;
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
        MapOverlayModel mapOverlayModel;
        MapOverlayModel mapOverlayModel2;
        MapOverlayModel mapOverlayModel3;
        com.baidu.tieba.util.a aVar;
        PostItemizedOverlay postItemizedOverlay;
        MapView mapView;
        mapOverlayModel = this.a.h;
        if (mapOverlayModel != null) {
            mapOverlayModel2 = this.a.h;
            if (mapOverlayModel2.getPosts() != null) {
                mapOverlayModel3 = this.a.h;
                ArrayList posts = mapOverlayModel3.getPosts();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < posts.size()) {
                        String portrait = ((MapPostItem) posts.get(i2)).getAutor().getPortrait();
                        aVar = this.a.g;
                        com.baidu.adp.widget.a.b d = aVar.d(portrait, new h(this));
                        if (d != null) {
                            postItemizedOverlay = this.a.f;
                            postItemizedOverlay.a(portrait, d);
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
