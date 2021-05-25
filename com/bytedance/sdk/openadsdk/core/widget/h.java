package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.v;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public View f28705a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28706b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28707c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.d f28708d;

    /* renamed from: e  reason: collision with root package name */
    public b f28709e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28710f = false;

    /* renamed from: g  reason: collision with root package name */
    public v f28711g;

    /* renamed from: h  reason: collision with root package name */
    public ViewStub f28712h;

    /* renamed from: i  reason: collision with root package name */
    public View f28713i;

    /* loaded from: classes6.dex */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* loaded from: classes6.dex */
    public interface b {
        boolean h();

        void j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f28707c == null) {
            return;
        }
        d();
    }

    private void d() {
        View view = this.f28705a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void b() {
        this.f28711g = null;
    }

    public void a(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.f28713i = view;
        this.f28707c = p.a().getApplicationContext();
        this.f28712h = (ViewStub) LayoutInflater.from(context).inflate(ad.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(ad.e(context, "tt_video_traffic_tip_layout_viewStub"));
    }

    private void a(Context context, View view, boolean z) {
        ViewStub viewStub;
        if (context == null || view == null || (viewStub = this.f28712h) == null || viewStub.getParent() == null || this.f28705a != null) {
            return;
        }
        this.f28712h.inflate();
        this.f28705a = view.findViewById(ad.e(context, "tt_video_traffic_tip_layout"));
        this.f28706b = (TextView) view.findViewById(ad.e(context, "tt_video_traffic_tip_tv"));
        View findViewById = view.findViewById(ad.e(context, "tt_video_traffic_continue_play_btn"));
        if (z) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    h.this.c();
                    if (h.this.f28708d != null) {
                        h.this.f28708d.a(a.START_VIDEO, (String) null);
                    }
                }
            });
            return;
        }
        findViewById.setOnClickListener(null);
        findViewById.setClickable(false);
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, b bVar) {
        this.f28709e = bVar;
        this.f28708d = dVar;
    }

    public boolean a(int i2, v vVar, boolean z) {
        Context context = this.f28707c;
        if (context == null || vVar == null) {
            return true;
        }
        a(context, this.f28713i, z);
        this.f28711g = vVar;
        if (i2 == 1 || i2 == 2) {
            return a(i2);
        }
        return true;
    }

    private boolean a(int i2) {
        b bVar;
        if (a() || this.f28710f) {
            return true;
        }
        if (this.f28708d != null && (bVar = this.f28709e) != null) {
            if (bVar.h()) {
                this.f28708d.e(null, null);
            }
            this.f28708d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.f28711g, true);
        return false;
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.f28705a;
        return view != null && view.getVisibility() == 0;
    }

    private void a(v vVar, boolean z) {
        View view;
        String str;
        View view2;
        if (vVar == null || (view = this.f28705a) == null || this.f28707c == null || view.getVisibility() == 0) {
            return;
        }
        b bVar = this.f28709e;
        if (bVar != null) {
            bVar.j();
        }
        int ceil = (int) Math.ceil((vVar.d() * 1.0d) / 1048576.0d);
        if (z) {
            str = ad.a(this.f28707c, "tt_video_without_wifi_tips") + ceil + ad.a(this.f28707c, "tt_video_bytesize_MB") + ad.a(this.f28707c, "tt_video_bytesize");
        } else {
            str = ad.a(this.f28707c, "tt_video_without_wifi_tips") + ad.a(this.f28707c, "tt_video_bytesize");
        }
        al.a(this.f28705a, 0);
        al.a(this.f28706b, str);
        if (!al.d(this.f28705a) || (view2 = this.f28705a) == null) {
            return;
        }
        view2.bringToFront();
    }
}
