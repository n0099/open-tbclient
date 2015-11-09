package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity crV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonImageActivity personImageActivity) {
        this.crV = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.crV.getPageContext().getString(i.h.save)};
        PersonImageActivity personImageActivity = this.crV;
        bVar = this.crV.bQn;
        personImageActivity.createListMenu(strArr, bVar);
        this.crV.showListMenu();
        return false;
    }
}
