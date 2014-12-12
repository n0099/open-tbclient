package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity brF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SquareSearchActivity squareSearchActivity) {
        this.brF = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.brF.gE(0);
            fragmentTabWidget3 = this.brF.brC;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.brF.gE(1);
            fragmentTabWidget2 = this.brF.brC;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.brF.gE(3);
            fragmentTabWidget = this.brF.brC;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.brF.bqY;
            UtilHelper.startBaiDuBar(this.brF.getPageContext().getPageActivity(), editText.getText().toString().trim());
        }
    }
}
