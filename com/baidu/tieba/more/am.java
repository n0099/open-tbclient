package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignRemindActivity f1483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SignRemindActivity signRemindActivity) {
        this.f1483a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1483a.finish();
    }
}
