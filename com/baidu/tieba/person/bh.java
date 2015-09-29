package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity cqo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonImageActivity personImageActivity) {
        this.cqo = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.cqo.getPageContext().getString(i.h.save)};
        PersonImageActivity personImageActivity = this.cqo;
        bVar = this.cqo.bPH;
        personImageActivity.createListMenu(strArr, bVar);
        this.cqo.showListMenu();
        return false;
    }
}
