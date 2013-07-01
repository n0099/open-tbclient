package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SignRemindActivity signRemindActivity) {
        this.f1086a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1086a.finish();
    }
}
