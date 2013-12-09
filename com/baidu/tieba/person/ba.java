package com.baidu.tieba.person;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonImageActivity f2327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PersonImageActivity personImageActivity) {
        this.f2327a = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Context context;
        Context context2;
        DialogInterface.OnClickListener onClickListener;
        context = this.f2327a.i;
        context2 = this.f2327a.i;
        String[] strArr = {context.getString(R.string.save), context2.getString(R.string.cancel)};
        PersonImageActivity personImageActivity = this.f2327a;
        onClickListener = this.f2327a.f;
        personImageActivity.createListMenu(strArr, onClickListener);
        this.f2327a.showListMenu();
        return false;
    }
}
