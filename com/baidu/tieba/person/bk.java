package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity efn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(PersonImageActivity personImageActivity) {
        this.efn = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.efn.getPageContext().getString(u.j.save)};
        PersonImageActivity personImageActivity = this.efn;
        bVar = this.efn.dgf;
        personImageActivity.createListMenu(strArr, bVar);
        this.efn.showListMenu();
        return false;
    }
}
