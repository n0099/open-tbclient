package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PersonImageActivity personImageActivity) {
        this.bIh = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.bIh.getPageContext().getString(com.baidu.tieba.z.save)};
        PersonImageActivity personImageActivity = this.bIh;
        onClickListener = this.bIh.brY;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.bIh.showListMenu();
        return false;
    }
}
