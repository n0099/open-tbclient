package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes5.dex */
public abstract class BackupView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f29034a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f29035b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f29036c;

    /* renamed from: d  reason: collision with root package name */
    public TTDislikeDialogAbstract f29037d;

    /* renamed from: e  reason: collision with root package name */
    public String f29038e;

    /* renamed from: f  reason: collision with root package name */
    public int f29039f;

    /* renamed from: g  reason: collision with root package name */
    public int f29040g;

    /* renamed from: h  reason: collision with root package name */
    public int f29041h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29042i;
    public boolean j;

    public BackupView(@NonNull Context context) {
        super(context);
        this.f29038e = "embeded_ad";
        this.f29042i = true;
        this.j = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    private boolean b() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f29035b;
        return lVar != null && com.bytedance.sdk.openadsdk.core.d.l.c(lVar);
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f29037d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f29036c;
        if (bVar != null) {
            bVar.showDislikeDialog();
        } else {
            TTDelegateActivity.a(getContext(), this.f29035b);
        }
    }

    public abstract void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar);

    public String getDescription() {
        if (TextUtils.isEmpty(this.f29035b.aj())) {
            return !TextUtils.isEmpty(this.f29035b.ak()) ? this.f29035b.ak() : "";
        }
        return this.f29035b.aj();
    }

    public String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f29035b;
        if (lVar == null) {
            return "";
        }
        if (lVar.an() == null || TextUtils.isEmpty(this.f29035b.an().c())) {
            return !TextUtils.isEmpty(this.f29035b.Y()) ? this.f29035b.Y() : "";
        }
        return this.f29035b.an().c();
    }

    public float getRealHeight() {
        return al.b(this.f29034a, this.f29040g);
    }

    public float getRealWidth() {
        return al.b(this.f29034a, this.f29039f);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        if (this.f29035b.an() != null && !TextUtils.isEmpty(this.f29035b.an().c())) {
            return this.f29035b.an().c();
        }
        if (TextUtils.isEmpty(this.f29035b.Y())) {
            return !TextUtils.isEmpty(this.f29035b.aj()) ? this.f29035b.aj() : "";
        }
        return this.f29035b.Y();
    }

    public View getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        if (this.f29035b != null && this.f29034a != null) {
            if (b()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.f29034a, this.f29035b, this.f29038e, true, false);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.f29042i);
                    nativeVideoTsView.setIsQuiet(this.j);
                } catch (Throwable unused) {
                }
                if (!b() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                    return nativeVideoTsView;
                }
            }
            nativeVideoTsView = null;
            if (!b()) {
            }
        }
        return null;
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.b) {
            this.f29036c = (com.bytedance.sdk.openadsdk.dislike.b) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.d.l lVar;
        if (tTDislikeDialogAbstract != null && (lVar = this.f29035b) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(lVar);
        }
        this.f29037d = tTDislikeDialogAbstract;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.a.b bVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.f29034a;
            com.bytedance.sdk.openadsdk.core.d.l lVar = this.f29035b;
            String str = this.f29038e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.a(context, lVar, str, ak.a(str));
        } else {
            Context context2 = this.f29034a;
            com.bytedance.sdk.openadsdk.core.d.l lVar2 = this.f29035b;
            String str2 = this.f29038e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.b(context2, lVar2, str2, ak.a(str2));
        }
        view.setOnTouchListener(bVar);
        view.setOnClickListener(bVar);
        bVar.a(new a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
            public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
                BackupView.this.a(i2, jVar);
            }
        });
    }

    public void a(int i2) {
        this.j = p.h().a(this.f29041h);
        int c2 = p.h().c(i2);
        if (3 == c2) {
            this.f29042i = false;
        } else if (1 == c2 && x.d(this.f29034a)) {
            this.f29042i = true;
        } else if (2 == c2) {
            if (x.e(this.f29034a) || x.d(this.f29034a)) {
                this.f29042i = true;
            }
        }
    }

    public void a(View view) {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f29035b;
        if (lVar == null || lVar.X() == null || view == null) {
            return;
        }
        if (this.f29035b.k() == 1 && this.f29042i) {
            a(view, true);
        } else {
            a(view, false);
        }
    }
}
