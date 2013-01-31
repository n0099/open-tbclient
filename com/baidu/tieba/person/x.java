package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(EditMarkActivity editMarkActivity) {
        this.a = editMarkActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
