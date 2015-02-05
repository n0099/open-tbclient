package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.tabHost.d {
    final /* synthetic */ SquareSearchActivity bta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.bta = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.d
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.bta.gN(0);
            fragmentTabWidget3 = this.bta.bsX;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.bta.gN(1);
            fragmentTabWidget2 = this.bta.bsX;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bta.gN(3);
            fragmentTabWidget = this.bta.bsX;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.bta.bsv;
            UtilHelper.startBaiDuBar(this.bta.getPageContext().getPageActivity(), editText.getText().toString().trim());
        }
    }
}
