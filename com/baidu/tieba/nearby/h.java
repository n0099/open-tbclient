package com.baidu.tieba.nearby;

import com.baidu.mapapi.MapView;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.a.d {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        NearbyMapActivity nearbyMapActivity;
        PostItemizedOverlay postItemizedOverlay;
        NearbyMapActivity nearbyMapActivity2;
        MapView mapView;
        if (bVar != null) {
            nearbyMapActivity = this.a.a;
            postItemizedOverlay = nearbyMapActivity.f;
            postItemizedOverlay.a(str, bVar);
            nearbyMapActivity2 = this.a.a;
            mapView = nearbyMapActivity2.b;
            mapView.invalidate();
        }
    }
}
