package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class ai implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1439a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SignRemindActivity signRemindActivity) {
        this.f1439a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1439a.finish();
    }
}
