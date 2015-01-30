package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.tabHost.d {
    final /* synthetic */ SquareSearchActivity btb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.btb = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.d
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.btb.gN(0);
            fragmentTabWidget3 = this.btb.bsY;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.btb.gN(1);
            fragmentTabWidget2 = this.btb.bsY;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.btb.gN(3);
            fragmentTabWidget = this.btb.bsY;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.btb.bsw;
            UtilHelper.startBaiDuBar(this.btb.getPageContext().getPageActivity(), editText.getText().toString().trim());
        }
    }
}
