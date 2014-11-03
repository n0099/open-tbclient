package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ PersonImageActivity bCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonImageActivity personImageActivity) {
        this.bCW = personImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        view2 = this.bCW.bav;
        view2.setVisibility(8);
    }
}
