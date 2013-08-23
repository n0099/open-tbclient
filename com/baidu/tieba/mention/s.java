package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PostActivity postActivity) {
        this.f1341a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1341a.finish();
    }
}
