package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity cZc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonImageActivity personImageActivity) {
        this.cZc = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.cZc.getPageContext().getString(t.j.save)};
        PersonImageActivity personImageActivity = this.cZc;
        bVar = this.cZc.cph;
        personImageActivity.createListMenu(strArr, bVar);
        this.cZc.showListMenu();
        return false;
    }
}
