package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MentionActivity mentionActivity) {
        this.f1327a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1327a.a(view);
    }
}
