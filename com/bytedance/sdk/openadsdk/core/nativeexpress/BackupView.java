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
/* loaded from: classes6.dex */
public abstract class BackupView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Context f28208a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28209b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f28210c;

    /* renamed from: d  reason: collision with root package name */
    public TTDislikeDialogAbstract f28211d;

    /* renamed from: e  reason: collision with root package name */
    public String f28212e;

    /* renamed from: f  reason: collision with root package name */
    public int f28213f;

    /* renamed from: g  reason: collision with root package name */
    public int f28214g;

    /* renamed from: h  reason: collision with root package name */
    public int f28215h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28216i;
    public boolean j;

    public BackupView(@NonNull Context context) {
        super(context);
        this.f28212e = "embeded_ad";
        this.f28216i = true;
        this.j = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    private boolean b() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28209b;
        return lVar != null && com.bytedance.sdk.openadsdk.core.d.l.c(lVar);
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f28211d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f28210c;
        if (bVar != null) {
            bVar.showDislikeDialog();
        } else {
            TTDelegateActivity.a(getContext(), this.f28209b);
        }
    }

    public abstract void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar);

    public String getDescription() {
        if (TextUtils.isEmpty(this.f28209b.aj())) {
            return !TextUtils.isEmpty(this.f28209b.ak()) ? this.f28209b.ak() : "";
        }
        return this.f28209b.aj();
    }

    public String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28209b;
        if (lVar == null) {
            return "";
        }
        if (lVar.an() == null || TextUtils.isEmpty(this.f28209b.an().c())) {
            return !TextUtils.isEmpty(this.f28209b.Y()) ? this.f28209b.Y() : "";
        }
        return this.f28209b.an().c();
    }

    public float getRealHeight() {
        return al.b(this.f28208a, this.f28214g);
    }

    public float getRealWidth() {
        return al.b(this.f28208a, this.f28213f);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        if (this.f28209b.an() != null && !TextUtils.isEmpty(this.f28209b.an().c())) {
            return this.f28209b.an().c();
        }
        if (TextUtils.isEmpty(this.f28209b.Y())) {
            return !TextUtils.isEmpty(this.f28209b.aj()) ? this.f28209b.aj() : "";
        }
        return this.f28209b.Y();
    }

    public View getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        if (this.f28209b != null && this.f28208a != null) {
            if (b()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.f28208a, this.f28209b, this.f28212e, true, false);
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    nativeVideoTsView.setIsAutoPlay(this.f28216i);
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
            this.f28210c = (com.bytedance.sdk.openadsdk.dislike.b) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.d.l lVar;
        if (tTDislikeDialogAbstract != null && (lVar = this.f28209b) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(lVar);
        }
        this.f28211d = tTDislikeDialogAbstract;
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
            Context context = this.f28208a;
            com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28209b;
            String str = this.f28212e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.a(context, lVar, str, ak.a(str));
        } else {
            Context context2 = this.f28208a;
            com.bytedance.sdk.openadsdk.core.d.l lVar2 = this.f28209b;
            String str2 = this.f28212e;
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
        this.j = p.h().a(this.f28215h);
        int c2 = p.h().c(i2);
        if (3 == c2) {
            this.f28216i = false;
        } else if (1 == c2 && x.d(this.f28208a)) {
            this.f28216i = true;
        } else if (2 == c2) {
            if (x.e(this.f28208a) || x.d(this.f28208a)) {
                this.f28216i = true;
            }
        }
    }

    public void a(View view) {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28209b;
        if (lVar == null || lVar.X() == null || view == null) {
            return;
        }
        if (this.f28209b.k() == 1 && this.f28216i) {
            a(view, true);
        } else {
            a(view, false);
        }
    }
}
