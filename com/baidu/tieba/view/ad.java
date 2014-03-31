package com.baidu.tieba.view;

import android.view.View;
/* loaded from: classes.dex */
final class ad implements View.OnClickListener {
    final /* synthetic */ UserPhotoLayout a;
    private final int b;

    private ad(UserPhotoLayout userPhotoLayout, int i) {
        this.a = userPhotoLayout;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(UserPhotoLayout userPhotoLayout, int i, byte b) {
        this(userPhotoLayout, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (UserPhotoLayout.a(this.a) != null) {
            UserPhotoLayout.a(this.a).a(this.b);
        }
    }
}
