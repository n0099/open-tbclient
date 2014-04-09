package com.baidu.tieba.mainentrance;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* loaded from: classes.dex */
final class t implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ SquareSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(SquareSearchActivity squareSearchActivity) {
        this.a = squareSearchActivity;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public final void a(int i) {
        EditText editText;
        FragmentTabWidget fragmentTabWidget;
        FragmentTabWidget fragmentTabWidget2;
        if (i == 0) {
            this.a.a(0);
            fragmentTabWidget2 = this.a.E;
            fragmentTabWidget2.a(i, true);
        }
        if (i == 1) {
            ((InputMethodManager) this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
            this.a.a(1);
            fragmentTabWidget = this.a.E;
            fragmentTabWidget.a(i, true);
        }
        if (i == 2) {
            editText = this.a.c;
            com.baidu.tieba.util.r.b(this.a, editText.getText().toString().trim());
        }
    }
}
