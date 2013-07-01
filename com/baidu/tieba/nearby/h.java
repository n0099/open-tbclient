package com.baidu.tieba.nearby;

import com.baidu.mapapi.MapView;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1165a = gVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        NearbyMapActivity nearbyMapActivity;
        PostItemizedOverlay postItemizedOverlay;
        NearbyMapActivity nearbyMapActivity2;
        MapView mapView;
        if (bVar != null) {
            nearbyMapActivity = this.f1165a.f1164a;
            postItemizedOverlay = nearbyMapActivity.f;
            postItemizedOverlay.a(str, bVar);
            nearbyMapActivity2 = this.f1165a.f1164a;
            mapView = nearbyMapActivity2.b;
            mapView.invalidate();
        }
    }
}
