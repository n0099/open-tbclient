package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ MyPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MyPostActivity myPostActivity) {
        this.a = myPostActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
