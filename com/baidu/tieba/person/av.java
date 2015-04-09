package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bQE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonImageActivity personImageActivity) {
        this.bQE = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.core.dialog.h hVar;
        String[] strArr = {this.bQE.getPageContext().getString(com.baidu.tieba.y.save)};
        PersonImageActivity personImageActivity = this.bQE;
        hVar = this.bQE.buZ;
        personImageActivity.createListMenu(strArr, hVar);
        this.bQE.showListMenu();
        return false;
    }
}
