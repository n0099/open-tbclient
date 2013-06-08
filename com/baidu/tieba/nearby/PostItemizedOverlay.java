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
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class PostItemizedOverlay extends ItemizedOverlay {
    private ArrayList a;
    private com.baidu.tieba.d.a b;
    private NearbyMapActivity c;
    private int d;
    private int e;

    public PostItemizedOverlay(Context context, Drawable drawable) {
        super(drawable);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = -1;
        this.b = new com.baidu.tieba.d.a(context);
        this.c = (NearbyMapActivity) context;
        populate();
        this.d = com.baidu.tieba.d.ag.a(TiebaApplication.d(), 6.0f);
    }

    public com.baidu.tieba.d.a a() {
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
            if (this.a == null) {
                this.a = new ArrayList();
            } else {
                this.a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.a.add(((com.baidu.tieba.a.ae) it.next()).g());
            }
            populate();
        }
    }

    public void a(MapOverlayItem mapOverlayItem) {
        if (mapOverlayItem != null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(mapOverlayItem);
            populate();
        }
    }

    public void a(String str, com.baidu.adp.widget.a.b bVar) {
        MapOverlayItem mapOverlayItem;
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.c.getResources().getDrawable(R.drawable.nearby_head_bg), bVar.h()});
        layerDrawable.setLayerInset(1, this.d, this.d, this.d, this.d * 2);
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i) != null && (mapOverlayItem = (MapOverlayItem) this.a.get(i)) != null && mapOverlayItem.a() != null && mapOverlayItem.a().a().e().equals(str)) {
                mapOverlayItem.setMarker(layerDrawable);
            }
        }
        populate();
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    protected OverlayItem createItem(int i) {
        if (this.a == null || this.a.size() <= i) {
            return null;
        }
        return (OverlayItem) this.a.get(i);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 int)] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.ItemizedOverlay
    public boolean onTap(int i) {
        com.baidu.tieba.d.ae.a(getClass().getName(), "onTap", new StringBuilder().append(i).toString());
        setFocus((OverlayItem) this.a.get(i));
        if (i == this.e && this.c.b() == 0) {
            this.c.a();
        } else {
            this.c.a(((MapOverlayItem) this.a.get(i)).a());
        }
        this.e = i;
        return true;
    }

    @Override // com.baidu.mapapi.ItemizedOverlay, com.baidu.mapapi.Overlay
    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        super.onTap(geoPoint, mapView);
        com.baidu.tieba.d.ae.a(getClass().getName(), "onTap", "========");
        return false;
    }

    @Override // com.baidu.mapapi.ItemizedOverlay
    public int size() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }
}
