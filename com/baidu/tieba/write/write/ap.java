package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cf cfVar;
        com.baidu.tbadk.editortools.k kVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.dYD.dUS;
        textView.setVisibility(0);
        view2 = this.dYD.dUV;
        view2.setSelected(true);
        cfVar = this.dYD.dUT;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cfVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dYD.getPageContext().getPageActivity(), 1.0f));
        kVar = this.dYD.aso;
        kVar.zK();
        WriteActivity writeActivity = this.dYD;
        inputMethodManager = this.dYD.mInputManager;
        editText = this.dYD.dUM;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.dYD;
        inputMethodManager2 = this.dYD.mInputManager;
        editText2 = this.dYD.dUQ;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
