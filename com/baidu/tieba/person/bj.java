package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity dwV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(PersonImageActivity personImageActivity) {
        this.dwV = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.dwV.getPageContext().getString(t.j.save)};
        PersonImageActivity personImageActivity = this.dwV;
        bVar = this.dwV.cAI;
        personImageActivity.createListMenu(strArr, bVar);
        this.dwV.showListMenu();
        return false;
    }
}
