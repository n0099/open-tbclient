package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonImageActivity f2325a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonImageActivity personImageActivity) {
        this.f2325a = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2325a.finish();
    }
}
