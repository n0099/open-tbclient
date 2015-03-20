package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.a(this.bzG.getPageContext().getPageActivity()).bZ(this.bzG.getPageContext().getString(com.baidu.tieba.y.alert_title)).ca(this.bzG.getPageContext().getString(com.baidu.tieba.y.alert_clean_history)).a(this.bzG.getPageContext().getString(com.baidu.tieba.y.alert_yes_button), new ad(this)).b(this.bzG.getPageContext().getString(com.baidu.tieba.y.alert_no_button), new af(this)).b(this.bzG.getPageContext()).re();
    }
}
