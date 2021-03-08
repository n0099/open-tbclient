package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private View f4622a;
    private TextView b;
    private Context c;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.d d;
    private b e;
    private boolean f = false;
    private t g;
    private ViewStub h;
    private View i;

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

    public void a(Context context, View view) {
        if (context != null && (view instanceof ViewGroup)) {
            this.i = view;
            this.c = p.a().getApplicationContext();
            this.h = (ViewStub) LayoutInflater.from(context).inflate(ac.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(ac.e(context, "tt_video_traffic_tip_layout_viewStub"));
        }
    }

    private void a(Context context, View view, boolean z) {
        if (context != null && view != null && this.h != null && this.h.getParent() != null && this.f4622a == null) {
            this.h.inflate();
            this.f4622a = view.findViewById(ac.e(context, "tt_video_traffic_tip_layout"));
            this.b = (TextView) view.findViewById(ac.e(context, "tt_video_traffic_tip_tv"));
            View findViewById = view.findViewById(ac.e(context, "tt_video_traffic_continue_play_btn"));
            if (z) {
                findViewById.setClickable(true);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        h.this.c();
                        if (h.this.d != null) {
                            h.this.d.a(a.START_VIDEO, (String) null);
                        }
                    }
                });
                return;
            }
            findViewById.setOnClickListener(null);
            findViewById.setClickable(false);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, b bVar) {
        this.e = bVar;
        this.d = dVar;
    }

    private void b() {
        this.g = null;
    }

    public boolean a(int i, t tVar, boolean z) {
        if (this.c == null || tVar == null) {
            return true;
        }
        a(this.c, this.i, z);
        this.g = tVar;
        switch (i) {
            case 1:
            case 2:
                return a(i);
            default:
                return true;
        }
    }

    private boolean a(int i) {
        if (a() || this.f) {
            return true;
        }
        if (this.d != null && this.e != null) {
            if (this.e.h()) {
                this.d.e(null, null);
            }
            this.d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.g, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.c != null) {
            d();
        }
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        return this.f4622a != null && this.f4622a.getVisibility() == 0;
    }

    private void d() {
        if (this.f4622a != null) {
            this.f4622a.setVisibility(8);
        }
    }

    private void a(t tVar, boolean z) {
        String str;
        if (tVar != null && this.f4622a != null && this.c != null && this.f4622a.getVisibility() != 0) {
            if (this.e != null) {
                this.e.j();
            }
            int ceil = (int) Math.ceil((tVar.d() * 1.0d) / 1048576.0d);
            if (z) {
                str = ac.a(this.c, "tt_video_without_wifi_tips") + ceil + ac.a(this.c, "tt_video_bytesize_MB") + ac.a(this.c, "tt_video_bytesize");
            } else {
                str = ac.a(this.c, "tt_video_without_wifi_tips") + ac.a(this.c, "tt_video_bytesize");
            }
            ak.a(this.f4622a, 0);
            ak.a(this.b, str);
            if (ak.d(this.f4622a) && this.f4622a != null) {
                this.f4622a.bringToFront();
            }
        }
    }
}
