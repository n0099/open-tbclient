package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1857a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MentionActivity mentionActivity) {
        this.f1857a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1857a.a(view);
    }
}
