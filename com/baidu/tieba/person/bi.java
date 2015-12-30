package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity cPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonImageActivity personImageActivity) {
        this.cPF = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.cPF.getPageContext().getString(n.j.save)};
        PersonImageActivity personImageActivity = this.cPF;
        bVar = this.cPF.ckG;
        personImageActivity.createListMenu(strArr, bVar);
        this.cPF.showListMenu();
        return false;
    }
}
