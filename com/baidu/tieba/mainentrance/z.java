package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.bzG = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.bzG.gN(0);
            fragmentTabWidget3 = this.bzG.bzD;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.bzG.gN(1);
            fragmentTabWidget2 = this.bzG.bzD;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bzG.gN(3);
            fragmentTabWidget = this.bzG.bzD;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.bzG.byS;
            UtilHelper.startBaiDuBar(this.bzG.getPageContext().getPageActivity(), editText.getText().toString().trim());
        }
    }
}
