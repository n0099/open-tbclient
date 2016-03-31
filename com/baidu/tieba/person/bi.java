package com.baidu.tieba.person;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity dtF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(PersonImageActivity personImageActivity) {
        this.dtF = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        c.b bVar;
        String[] strArr = {this.dtF.getPageContext().getString(t.j.save)};
        PersonImageActivity personImageActivity = this.dtF;
        bVar = this.dtF.czJ;
        personImageActivity.createListMenu(strArr, bVar);
        this.dtF.showListMenu();
        return false;
    }
}
