package com.baidu.tieba.nearby;

import com.baidu.mapapi.MapView;
import com.baidu.tieba.data.MapPostItem;
import com.baidu.tieba.model.MapOverlayModel;
import java.util.ArrayList;
/* loaded from: classes.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyMapActivity f1164a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NearbyMapActivity nearbyMapActivity) {
        this.f1164a = nearbyMapActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        MapOverlayModel mapOverlayModel;
        MapOverlayModel mapOverlayModel2;
        MapOverlayModel mapOverlayModel3;
        com.baidu.tieba.util.a aVar;
        PostItemizedOverlay postItemizedOverlay;
        MapView mapView;
        mapOverlayModel = this.f1164a.h;
        if (mapOverlayModel != null) {
            mapOverlayModel2 = this.f1164a.h;
            if (mapOverlayModel2.getPosts() != null) {
                mapOverlayModel3 = this.f1164a.h;
                ArrayList posts = mapOverlayModel3.getPosts();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < posts.size()) {
                        String portrait = ((MapPostItem) posts.get(i2)).getAutor().getPortrait();
                        aVar = this.f1164a.g;
                        com.baidu.adp.widget.a.b d = aVar.d(portrait, new h(this));
                        if (d != null) {
                            postItemizedOverlay = this.f1164a.f;
                            postItemizedOverlay.a(portrait, d);
                            mapView = this.f1164a.b;
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
