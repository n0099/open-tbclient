package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonImageActivity personImageActivity) {
        this.bCW = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        DialogInterface.OnClickListener onClickListener;
        context = this.bCW.mContext;
        String[] strArr = {context.getString(com.baidu.tieba.y.save)};
        PersonImageActivity personImageActivity = this.bCW;
        onClickListener = this.bCW.aNG;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.bCW.showListMenu();
        return false;
    }
}
