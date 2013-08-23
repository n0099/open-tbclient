package com.baidu.tieba.write;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.f1929a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1929a.finish();
    }
}
