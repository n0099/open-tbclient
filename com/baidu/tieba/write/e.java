package com.baidu.tieba.write;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1583a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.f1583a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1583a.finish();
    }
}
