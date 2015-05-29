package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonImageActivity personImageActivity) {
        this.bTj = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.core.dialog.h hVar;
        String[] strArr = {this.bTj.getPageContext().getString(com.baidu.tieba.t.save)};
        PersonImageActivity personImageActivity = this.bTj;
        hVar = this.bTj.bxH;
        personImageActivity.createListMenu(strArr, hVar);
        this.bTj.showListMenu();
        return false;
    }
}
