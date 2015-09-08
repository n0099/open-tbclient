package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity ckK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonImageActivity personImageActivity) {
        this.ckK = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.ckK.getPageContext().getString(i.h.save)};
        PersonImageActivity personImageActivity = this.ckK;
        bVar = this.ckK.bMe;
        personImageActivity.createListMenu(strArr, bVar);
        this.ckK.showListMenu();
        return false;
    }
}
