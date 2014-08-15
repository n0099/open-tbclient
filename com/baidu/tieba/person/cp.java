package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        Context context2;
        DialogInterface.OnClickListener onClickListener;
        context = this.a.i;
        context2 = this.a.i;
        String[] strArr = {context.getString(com.baidu.tieba.x.save), context2.getString(com.baidu.tieba.x.cancel)};
        PersonImageActivity personImageActivity = this.a;
        onClickListener = this.a.f;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.a.showListMenu();
        return false;
    }
}
