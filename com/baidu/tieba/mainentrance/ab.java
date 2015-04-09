package com.baidu.tieba.mainentrance;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        new com.baidu.tbadk.core.dialog.a(this.bzT.getPageContext().getPageActivity()).bZ(this.bzT.getPageContext().getString(com.baidu.tieba.y.alert_title)).ca(this.bzT.getPageContext().getString(com.baidu.tieba.y.alert_clean_history)).a(this.bzT.getPageContext().getString(com.baidu.tieba.y.alert_yes_button), new ac(this)).b(this.bzT.getPageContext().getString(com.baidu.tieba.y.alert_no_button), new ae(this)).b(this.bzT.getPageContext()).re();
    }
}
