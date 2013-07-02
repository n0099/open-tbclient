package com.baidu.tieba.nearby;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.MapPostItem;
import com.baidu.tieba.model.MapOverlayModel;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NearbyMapActivity extends MapActivity {
    private BMapManager a = null;
    private MapView b = null;
    private TextView c = null;
    private MapController d = null;
    private Address e = null;
    private PostItemizedOverlay f = null;
    private com.baidu.tieba.util.a g = null;
    private MapOverlayModel h = null;
    private Handler i = null;
    private Button j = null;
    private Button k = null;
    private int l = 0;
    private int m = 0;
    private Runnable n = new g(this);
    private View.OnClickListener o = new i(this);

    public static void a(Context context, Address address, MapOverlayModel mapOverlayModel) {
        if (Build.VERSION.SDK_INT >= 5 && mapOverlayModel != null && address != null) {
            Intent intent = new Intent();
            intent.setClass(context, NearbyMapActivity.class);
            intent.putExtra("model", mapOverlayModel);
            intent.putExtra("address", address);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.MapActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.nearby_map_activity);
        if (TiebaApplication.f().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        boolean z = true;
        if (TiebaApplication.f().aU() == null) {
            z = TiebaApplication.f().c(getApplicationContext());
        }
        this.a = TiebaApplication.f().aU();
        if (!z || this.a == null) {
            finish();
            return;
        }
        this.a.start();
        super.initMapActivity(this.a);
        this.i = new Handler();
        c();
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.b.onRestoreInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.MapActivity, android.app.Activity
    public void onResume() {
        this.a.start();
        super.onResume();
        if (TiebaApplication.f().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mapapi.MapActivity, android.app.Activity
    public void onPause() {
        this.a.stop();
        super.onPause();
        if (TiebaApplication.f().t()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
            CompatibleUtile.setAnim(this, 0, R.anim.up);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void c() {
        this.k = (Button) findViewById(R.id.pack_up);
        this.k.setOnClickListener(new j(this));
        this.b = (MapView) findViewById(R.id.bd_mapview);
        this.d = this.b.getController();
        this.c = (TextView) findViewById(R.id.location_text);
        this.b.setDrawOverlayWhenZooming(true);
        this.b.setDoubleClickZooming(false);
        this.l = com.baidu.tieba.util.ab.a((Context) this) >> 1;
        this.j = (Button) super.getLayoutInflater().inflate(R.layout.nearby_pop, (ViewGroup) null);
        this.b.addView(this.j, new MapView.LayoutParams(-2, -2, null, 80));
        this.j.setVisibility(8);
        this.j.setOnClickListener(this.o);
        this.j.setMaxWidth(this.l);
    }

    private void a(Bundle bundle) {
        this.h = (MapOverlayModel) getIntent().getSerializableExtra("model");
        this.e = (Address) getIntent().getParcelableExtra("address");
        if (this.e.getMaxAddressLineIndex() >= 0) {
            this.c.setText(this.e.getAddressLine(0));
        }
        GeoPoint geoPoint = new GeoPoint((int) (this.e.getLatitude() * 1000000.0d), (int) (this.e.getLongitude() * 1000000.0d));
        MapOverlayItem mapOverlayItem = new MapOverlayItem(geoPoint, "", "");
        this.m = getResources().getDrawable(R.drawable.nearby_head_bg).getIntrinsicHeight();
        this.f = new PostItemizedOverlay(this, getResources().getDrawable(R.drawable.nearby_head_bg));
        mapOverlayItem.setMarker(getResources().getDrawable(R.drawable.nearby_my_pos));
        this.f.a(this.h.getPosts());
        this.f.a(mapOverlayItem);
        this.d.setCenter(geoPoint);
        this.d.setZoom(this.h.getZoomLevel());
        this.d.setMaxZoomLevel(18);
        this.d.setMinZoomLevel(4);
        this.g = this.f.a();
        this.b.getOverlays().add(this.f);
        this.i.post(this.n);
    }

    public void a(MapPostItem mapPostItem) {
        if (mapPostItem != null) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "lbs_header_pic", "lbsclick", 1);
            }
            GeoPoint geoPoint = new GeoPoint(mapPostItem.getLat(), mapPostItem.getLng());
            this.j.setTag(mapPostItem.getPostId());
            this.j.setText(mapPostItem.getTitle());
            this.b.updateViewLayout(this.j, new MapView.LayoutParams(-2, -2, geoPoint, 0, -this.m, 81));
            this.j.setVisibility(0);
            this.d.animateTo(geoPoint);
        }
    }

    public void a() {
        this.j.setVisibility(8);
    }

    public int b() {
        return this.j.getVisibility();
    }

    @Override // com.baidu.mapapi.MapActivity
    protected boolean isRouteDisplayed() {
        return false;
    }
}
