package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AboutActivity f1431a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AboutActivity aboutActivity) {
        this.f1431a = aboutActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1431a.finish();
    }
}
