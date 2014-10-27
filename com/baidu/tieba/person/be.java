package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonImageActivity personImageActivity) {
        this.bCI = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bCI.finish();
    }
}
