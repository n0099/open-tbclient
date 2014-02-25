package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(PersonImageActivity personImageActivity) {
        this.a = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        Context context2;
        DialogInterface.OnClickListener onClickListener;
        context = this.a.i;
        context2 = this.a.i;
        String[] strArr = {context.getString(R.string.save), context2.getString(R.string.cancel)};
        PersonImageActivity personImageActivity = this.a;
        onClickListener = this.a.f;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.a.showListMenu();
        return false;
    }
}
