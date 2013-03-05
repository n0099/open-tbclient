package com.baidu.tieba.nearby;

import android.graphics.Bitmap;
import com.baidu.mapapi.MapView;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.c.d {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        NearbyMapActivity nearbyMapActivity;
        PostItemizedOverlay postItemizedOverlay;
        NearbyMapActivity nearbyMapActivity2;
        MapView mapView;
        if (bitmap != null) {
            nearbyMapActivity = this.a.a;
            postItemizedOverlay = nearbyMapActivity.f;
            postItemizedOverlay.a(str, bitmap);
            nearbyMapActivity2 = this.a.a;
            mapView = nearbyMapActivity2.b;
            mapView.invalidate();
        }
    }
}
