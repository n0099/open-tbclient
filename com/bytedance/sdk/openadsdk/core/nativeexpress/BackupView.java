package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public abstract class BackupView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected Context f6617a;

    /* renamed from: b  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.d.l f6618b;
    protected com.bytedance.sdk.openadsdk.dislike.b c;
    protected TTDislikeDialogAbstract d;
    protected String e;
    protected int f;
    protected int g;

    protected abstract void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar);

    public BackupView(@NonNull Context context) {
        super(context);
        this.e = "embeded_ad";
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
        if (tTDislikeDialogAbstract != null && this.f6618b != null) {
            tTDislikeDialogAbstract.setMaterialMeta(this.f6618b);
        }
        this.d = tTDislikeDialogAbstract;
    }

    public void a() {
        if (this.d != null) {
            this.d.show();
        } else if (this.c != null) {
            this.c.showDislikeDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNameOrSource() {
        if (this.f6618b == null) {
            return "";
        }
        if (this.f6618b.U() != null && !TextUtils.isEmpty(this.f6618b.U().c())) {
            return this.f6618b.U().c();
        }
        if (!TextUtils.isEmpty(this.f6618b.G())) {
            return this.f6618b.G();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTitle() {
        if (this.f6618b.U() != null && !TextUtils.isEmpty(this.f6618b.U().c())) {
            return this.f6618b.U().c();
        }
        if (!TextUtils.isEmpty(this.f6618b.G())) {
            return this.f6618b.G();
        }
        if (!TextUtils.isEmpty(this.f6618b.Q())) {
            return this.f6618b.Q();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDescription() {
        if (!TextUtils.isEmpty(this.f6618b.Q())) {
            return this.f6618b.Q();
        }
        if (!TextUtils.isEmpty(this.f6618b.R())) {
            return this.f6618b.R();
        }
        return "";
    }

    public float getRealWidth() {
        return ak.b(this.f6617a, this.f);
    }

    public float getRealHeight() {
        return ak.b(this.f6617a, this.g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.a.b bVar;
        if (view != null) {
            if (z) {
                bVar = new com.bytedance.sdk.openadsdk.core.a.a(this.f6617a, this.f6618b, this.e, aj.a(this.e));
            } else {
                bVar = new com.bytedance.sdk.openadsdk.core.a.b(this.f6617a, this.f6618b, this.e, aj.a(this.e));
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
}
