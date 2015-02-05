package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bIg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PersonImageActivity personImageActivity) {
        this.bIg = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.bIg.getPageContext().getString(com.baidu.tieba.z.save)};
        PersonImageActivity personImageActivity = this.bIg;
        onClickListener = this.bIg.brX;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.bIg.showListMenu();
        return false;
    }
}
