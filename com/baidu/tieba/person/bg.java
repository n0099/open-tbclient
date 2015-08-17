package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity cjP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(PersonImageActivity personImageActivity) {
        this.cjP = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.cjP.getPageContext().getString(i.C0057i.save)};
        PersonImageActivity personImageActivity = this.cjP;
        bVar = this.cjP.bLx;
        personImageActivity.createListMenu(strArr, bVar);
        this.cjP.showListMenu();
        return false;
    }
}
