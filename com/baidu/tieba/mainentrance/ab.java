package com.baidu.tieba.mainentrance;

import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity bnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SquareSearchActivity squareSearchActivity) {
        this.bnc = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.bnc.gt(0);
            fragmentTabWidget3 = this.bnc.bmZ;
            fragmentTabWidget3.d(i, true);
        }
        if (i == 1) {
            this.bnc.gt(1);
            fragmentTabWidget2 = this.bnc.bmZ;
            fragmentTabWidget2.d(i, true);
        }
        if (i == 2) {
            this.bnc.gt(3);
            fragmentTabWidget = this.bnc.bmZ;
            fragmentTabWidget.d(i, true);
        }
        if (i == 3) {
            editText = this.bnc.bmv;
            com.baidu.tieba.util.q.H(this.bnc, editText.getText().toString().trim());
        }
    }
}
