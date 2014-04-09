package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
/* loaded from: classes.dex */
final class bj implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Context context;
        Context context2;
        DialogInterface.OnClickListener onClickListener;
        context = this.a.i;
        context2 = this.a.i;
        String[] strArr = {context.getString(com.baidu.tieba.a.k.save), context2.getString(com.baidu.tieba.a.k.cancel)};
        PersonImageActivity personImageActivity = this.a;
        onClickListener = this.a.f;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.a.showListMenu();
        return false;
    }
}
