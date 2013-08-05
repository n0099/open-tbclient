package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PostActivity f1308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PostActivity postActivity) {
        this.f1308a = postActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1308a.finish();
    }
}
