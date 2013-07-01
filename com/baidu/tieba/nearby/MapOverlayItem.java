package com.baidu.tieba.nearby;

import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.OverlayItem;
import com.baidu.tieba.data.MapPostItem;
/* loaded from: classes.dex */
public class MapOverlayItem extends OverlayItem {

    /* renamed from: a  reason: collision with root package name */
    private MapPostItem f1115a;

    public MapOverlayItem(GeoPoint geoPoint, String str, String str2) {
        super(geoPoint, str, str2);
        this.f1115a = null;
    }

    public void a(MapPostItem mapPostItem) {
        this.f1115a = mapPostItem;
    }

    public MapPostItem a() {
        return this.f1115a;
    }
}
