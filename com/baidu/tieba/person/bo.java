package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonImageActivity personImageActivity) {
        this.bTk = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.core.dialog.h hVar;
        String[] strArr = {this.bTk.getPageContext().getString(com.baidu.tieba.t.save)};
        PersonImageActivity personImageActivity = this.bTk;
        hVar = this.bTk.bxI;
        personImageActivity.createListMenu(strArr, hVar);
        this.bTk.showListMenu();
        return false;
    }
}
