package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity cLp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonImageActivity personImageActivity) {
        this.cLp = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.cLp.getPageContext().getString(n.i.save)};
        PersonImageActivity personImageActivity = this.cLp;
        bVar = this.cLp.cgB;
        personImageActivity.createListMenu(strArr, bVar);
        this.cLp.showListMenu();
        return false;
    }
}
