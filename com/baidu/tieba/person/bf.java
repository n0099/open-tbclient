package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bCI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PersonImageActivity personImageActivity) {
        this.bCI = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        DialogInterface.OnClickListener onClickListener;
        context = this.bCI.mContext;
        String[] strArr = {context.getString(com.baidu.tieba.y.save)};
        PersonImageActivity personImageActivity = this.bCI;
        onClickListener = this.bCI.aNs;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.bCI.showListMenu();
        return false;
    }
}
