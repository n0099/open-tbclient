package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1982a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SignRemindActivity signRemindActivity) {
        this.f1982a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1982a.finish();
    }
}
