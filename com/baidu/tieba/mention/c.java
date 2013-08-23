package com.baidu.tieba.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MentionActivity f1326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MentionActivity mentionActivity) {
        this.f1326a = mentionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1326a.finish();
    }
}
