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
    public View f28808a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28809b;

    /* renamed from: c  reason: collision with root package name */
    public Context f28810c;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.d f28811d;

    /* renamed from: e  reason: collision with root package name */
    public b f28812e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28813f = false;

    /* renamed from: g  reason: collision with root package name */
    public v f28814g;

    /* renamed from: h  reason: collision with root package name */
    public ViewStub f28815h;

    /* renamed from: i  reason: collision with root package name */
    public View f28816i;

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
        if (this.f28810c == null) {
            return;
        }
        d();
    }

    private void d() {
        View view = this.f28808a;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void b() {
        this.f28814g = null;
    }

    public void a(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.f28816i = view;
        this.f28810c = p.a().getApplicationContext();
        this.f28815h = (ViewStub) LayoutInflater.from(context).inflate(ad.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(ad.e(context, "tt_video_traffic_tip_layout_viewStub"));
    }

    private void a(Context context, View view, boolean z) {
        ViewStub viewStub;
        if (context == null || view == null || (viewStub = this.f28815h) == null || viewStub.getParent() == null || this.f28808a != null) {
            return;
        }
        this.f28815h.inflate();
        this.f28808a = view.findViewById(ad.e(context, "tt_video_traffic_tip_layout"));
        this.f28809b = (TextView) view.findViewById(ad.e(context, "tt_video_traffic_tip_tv"));
        View findViewById = view.findViewById(ad.e(context, "tt_video_traffic_continue_play_btn"));
        if (z) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    h.this.c();
                    if (h.this.f28811d != null) {
                        h.this.f28811d.a(a.START_VIDEO, (String) null);
                    }
                }
            });
            return;
        }
        findViewById.setOnClickListener(null);
        findViewById.setClickable(false);
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, b bVar) {
        this.f28812e = bVar;
        this.f28811d = dVar;
    }

    public boolean a(int i2, v vVar, boolean z) {
        Context context = this.f28810c;
        if (context == null || vVar == null) {
            return true;
        }
        a(context, this.f28816i, z);
        this.f28814g = vVar;
        if (i2 == 1 || i2 == 2) {
            return a(i2);
        }
        return true;
    }

    private boolean a(int i2) {
        b bVar;
        if (a() || this.f28813f) {
            return true;
        }
        if (this.f28811d != null && (bVar = this.f28812e) != null) {
            if (bVar.h()) {
                this.f28811d.e(null, null);
            }
            this.f28811d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.f28814g, true);
        return false;
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.f28808a;
        return view != null && view.getVisibility() == 0;
    }

    private void a(v vVar, boolean z) {
        View view;
        String str;
        View view2;
        if (vVar == null || (view = this.f28808a) == null || this.f28810c == null || view.getVisibility() == 0) {
            return;
        }
        b bVar = this.f28812e;
        if (bVar != null) {
            bVar.j();
        }
        int ceil = (int) Math.ceil((vVar.d() * 1.0d) / 1048576.0d);
        if (z) {
            str = ad.a(this.f28810c, "tt_video_without_wifi_tips") + ceil + ad.a(this.f28810c, "tt_video_bytesize_MB") + ad.a(this.f28810c, "tt_video_bytesize");
        } else {
            str = ad.a(this.f28810c, "tt_video_without_wifi_tips") + ad.a(this.f28810c, "tt_video_bytesize");
        }
        al.a(this.f28808a, 0);
        al.a(this.f28809b, str);
        if (!al.d(this.f28808a) || (view2 = this.f28808a) == null) {
            return;
        }
        view2.bringToFront();
    }
}
