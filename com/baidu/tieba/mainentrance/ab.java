package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity bmO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.bmO = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.bmO.gt(0);
            fragmentTabWidget3 = this.bmO.bmL;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.bmO.gt(1);
            fragmentTabWidget2 = this.bmO.bmL;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bmO.gt(3);
            fragmentTabWidget = this.bmO.bmL;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.bmO.bmh;
            com.baidu.tieba.util.q.H(this.bmO, editText.getText().toString().trim());
        }
    }
}
