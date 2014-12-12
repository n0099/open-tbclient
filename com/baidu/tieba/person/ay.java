package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PersonImageActivity personImageActivity) {
        this.bGv = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        String[] strArr = {this.bGv.getPageContext().getString(com.baidu.tieba.z.save)};
        PersonImageActivity personImageActivity = this.bGv;
        onClickListener = this.bGv.bqA;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.bGv.showListMenu();
        return false;
    }
}
