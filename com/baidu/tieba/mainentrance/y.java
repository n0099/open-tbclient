package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SquareSearchActivity squareSearchActivity) {
        this.bzT = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.bzT.gP(0);
            fragmentTabWidget3 = this.bzT.bzQ;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.bzT.gP(1);
            fragmentTabWidget2 = this.bzT.bzQ;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bzT.gP(3);
            fragmentTabWidget = this.bzT.bzQ;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.bzT.bze;
            UtilHelper.startBaiDuBar(this.bzT.getPageContext().getPageActivity(), editText.getText().toString().trim());
        }
    }
}
