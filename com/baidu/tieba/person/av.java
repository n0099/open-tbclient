package com.baidu.tieba.person;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnLongClickListener {
    final /* synthetic */ PersonImageActivity bQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonImageActivity personImageActivity) {
        this.bQo = personImageActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.tbadk.core.dialog.h hVar;
        String[] strArr = {this.bQo.getPageContext().getString(com.baidu.tieba.y.save)};
        PersonImageActivity personImageActivity = this.bQo;
        hVar = this.bQo.buJ;
        personImageActivity.createListMenu(strArr, hVar);
        this.bQo.showListMenu();
        return false;
    }
}
