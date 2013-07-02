package com.baidu.tieba.more;

import android.view.View;
/* loaded from: classes.dex */
class ah implements View.OnClickListener {
    final /* synthetic */ SignRemindActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SignRemindActivity signRemindActivity) {
        this.a = signRemindActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
