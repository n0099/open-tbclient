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
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes6.dex */
public abstract class BackupView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected Context f4471a;
    protected com.bytedance.sdk.openadsdk.core.d.l b;
    protected com.bytedance.sdk.openadsdk.dislike.b c;
    protected TTDislikeDialogAbstract d;
    protected String e;
    protected int f;
    protected int g;
    protected int h;
    protected boolean i;
    protected boolean j;

    protected abstract void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar);

    public BackupView(@NonNull Context context) {
        super(context);
        this.e = "embeded_ad";
        this.i = true;
        this.j = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.b) {
            this.c = (com.bytedance.sdk.openadsdk.dislike.b) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract != null && this.b != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.b);
        }
        this.d = tTDislikeDialogAbstract;
    }

    public void a() {
        if (this.d != null) {
            this.d.show();
        } else if (this.c != null) {
            this.c.showDislikeDialog();
        } else {
            TTDelegateActivity.a(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNameOrSource() {
        if (this.b == null) {
            return "";
        }
        if (this.b.ah() != null && !TextUtils.isEmpty(this.b.ah().c())) {
            return this.b.ah().c();
        }
        if (!TextUtils.isEmpty(this.b.S())) {
            return this.b.S();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTitle() {
        if (this.b.ah() != null && !TextUtils.isEmpty(this.b.ah().c())) {
            return this.b.ah().c();
        }
        if (!TextUtils.isEmpty(this.b.S())) {
            return this.b.S();
        }
        if (!TextUtils.isEmpty(this.b.ad())) {
            return this.b.ad();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDescription() {
        if (!TextUtils.isEmpty(this.b.ad())) {
            return this.b.ad();
        }
        if (!TextUtils.isEmpty(this.b.ae())) {
            return this.b.ae();
        }
        return "";
    }

    public float getRealWidth() {
        return ak.b(this.f4471a, this.f);
    }

    public float getRealHeight() {
        return ak.b(this.f4471a, this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.a.b bVar;
        if (view != null) {
            if (z) {
                bVar = new com.bytedance.sdk.openadsdk.core.a.a(this.f4471a, this.b, this.e, aj.a(this.e));
            } else {
                bVar = new com.bytedance.sdk.openadsdk.core.a.b(this.f4471a, this.b, this.e, aj.a(this.e));
            }
            view.setOnTouchListener(bVar);
            view.setOnClickListener(bVar);
            bVar.a(new a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
                public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
                    BackupView.this.a(i, jVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getVideoView() {
        NativeVideoTsView nativeVideoTsView;
        if (this.b == null || this.f4471a == null) {
            return null;
        }
        if (b()) {
            try {
                nativeVideoTsView = new NativeVideoTsView(this.f4471a, this.b, this.e, true, false);
                nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                    public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    }
                });
                nativeVideoTsView.setIsAutoPlay(this.i);
                nativeVideoTsView.setIsQuiet(this.j);
            } catch (Throwable th) {
                nativeVideoTsView = null;
            }
        } else {
            nativeVideoTsView = null;
        }
        if (b() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
            return nativeVideoTsView;
        }
        return null;
    }

    private boolean b() {
        return this.b != null && com.bytedance.sdk.openadsdk.core.d.l.c(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
        this.j = p.h().a(this.h);
        int c = p.h().c(i);
        if (3 == c) {
            this.i = false;
        } else if (1 == c && x.d(this.f4471a)) {
            this.i = true;
        } else if (2 == c) {
            if (x.e(this.f4471a) || x.d(this.f4471a)) {
                this.i = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        if (this.b != null && this.b.R() != null && view != null) {
            if (this.b.k() == 1 && this.i) {
                a(view, true);
            } else {
                a(view, false);
            }
        }
    }
}
