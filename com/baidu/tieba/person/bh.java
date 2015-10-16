package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity cqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonImageActivity personImageActivity) {
        this.cqz = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.cqz.getPageContext().getString(i.h.save)};
        PersonImageActivity personImageActivity = this.cqz;
        bVar = this.cqz.bPS;
        personImageActivity.createListMenu(strArr, bVar);
        this.cqz.showListMenu();
        return false;
    }
}
