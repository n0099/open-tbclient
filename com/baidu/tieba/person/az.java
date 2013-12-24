package com.baidu.tieba.person;

import android.view.View;
/* loaded from: classes.dex */
class az implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
