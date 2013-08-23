package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgRemindActivity f1438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(MsgRemindActivity msgRemindActivity) {
        this.f1438a = msgRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1438a.finish();
    }
}
