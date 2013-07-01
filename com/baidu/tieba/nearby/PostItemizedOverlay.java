package com.baidu.tieba.nearby;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.ItemizedOverlay;
import com.baidu.mapapi.MapView;
import com.baidu.mapapi.OverlayItem;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.MapPostItem;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PostItemizedOverlay extends ItemizedOverlay {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1121a;
    private com.baidu.tieba.util.a b;
    private NearbyMapActivity c;
    private int d;
    private int e;

    public PostItemizedOverlay(Context context, Drawable drawable) {
        super(drawable);
        this.f1121a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.b = new com.baidu.tieba.util.a(context);
        this.c = (NearbyMapActivity) context;
        populate();
        this.d = com.baidu.tieba.util.ab.a(TiebaApplication.f(), 6.0f);
    }

    public com.baidu.tieba.util.a a() {
        return this.b;
    }

    @Override // com.baidu.mapapi.ItemizedOverlay, com.baidu.mapapi.Overlay
    public void draw(Canvas canvas, MapView mapView, boolean z) {
        for (int size = size() - 1; size >= 0; size--) {
            boundCenterBottom(getItem(size).getMarker(0));
        }
        super.draw(canvas, mapView, z);
    }

    public void a(ArrayList arrayList) {
        if (arrayList != null) {
            if (this.f1121a == null) {
                this.f1121a = new ArrayList();
            } else {
                this.f1121a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f1121a.add(((MapPostItem) it.next()).getOverlayItem());
            }
            populate();
        }
    }

    public void a(MapOverlayItem mapOverlayItem) {
        if (mapOverlayItem != null) {
            if (this.f1121a == null) {
                this.f1121a = new ArrayList();
            }
            this.f1121a.add(mapOverlayItem);
            populate();
        }
    }

    public void a(String str, com.baidu.adp.widget.a.b bVar) {
        MapOverlayItem mapOverlayItem;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.c.getResources().getDrawable(R.drawable.nearby_head_bg), bVar.h()});
        layerDrawable.setLayerInset(1, this.d, this.d, this.d, this.d * 2);
        for (int i = 0; i < this.f1121a.size(); i++) {
            if (this.f1121a.get(i) != null && (mapOverlayItem = (MapOverlayItem) this.f1121a.get(i)) != null && mapOverlayItem.a() != null && mapOverlayItem.a().getAutor().getPortrait().equals(str)) {
                mapOverlayItem.setMarker(layerDrawable);
            }
        }
        populate();
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    protected OverlayItem createItem(int i) {
        if (this.f1121a == null || this.f1121a.size() <= i) {
            return null;
        }
        return (OverlayItem) this.f1121a.get(i);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.ItemizedOverlay
    public boolean onTap(int i) {
        com.baidu.tieba.util.z.a(getClass().getName(), "onTap", new StringBuilder().append(i).toString());
        setFocus((OverlayItem) this.f1121a.get(i));
        if (i == this.e && this.c.b() == 0) {
            this.c.a();
        } else {
            this.c.a(((MapOverlayItem) this.f1121a.get(i)).a());
        }
        this.e = i;
        return true;
    }

    @Override // com.baidu.mapapi.ItemizedOverlay, com.baidu.mapapi.Overlay
    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        super.onTap(geoPoint, mapView);
        com.baidu.tieba.util.z.a(getClass().getName(), "onTap", "========");
        return false;
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    public int size() {
        if (this.f1121a == null) {
            return 0;
        }
        return this.f1121a.size();
    }
}
