package com.baidu.tieba.mainentrance;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void a(int i, boolean z) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        FragmentTabWidget fragmentTabWidget3;
        if (i == 0) {
            this.a.a(0);
            fragmentTabWidget3 = this.a.I;
            fragmentTabWidget3.a(i, true);
        }
        if (i == 1) {
            if (this.a.getCurrentFocus() != null) {
                ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
            }
            this.a.a(1);
            fragmentTabWidget2 = this.a.I;
            fragmentTabWidget2.a(i, true);
        }
        if (i == 2) {
            this.a.a(3);
            fragmentTabWidget = this.a.I;
            fragmentTabWidget.a(i, true);
        }
        if (i == 3) {
            editText = this.a.c;
            com.baidu.tieba.util.r.c(this.a, editText.getText().toString().trim());
        }
    }
}
