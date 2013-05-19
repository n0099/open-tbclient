package com.baidu.tieba.nearby;

import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.OverlayItem;
/* loaded from: classes.dex */
public class MapOverlayItem extends OverlayItem {
    private com.baidu.tieba.a.ae a;

    public MapOverlayItem(GeoPoint geoPoint, String str, String str2) {
        super(geoPoint, str, str2);
        this.a = null;
    }

    public void a(com.baidu.tieba.a.ae aeVar) {
        this.a = aeVar;
    }

    public com.baidu.tieba.a.ae a() {
        return this.a;
    }
}
