package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cf cfVar;
        com.baidu.tbadk.editortools.k kVar;
        InputMethodManager inputMethodManager;
        EditText aMf;
        InputMethodManager inputMethodManager2;
        EditText aMe;
        textView = this.dYD.dUS;
        textView.setSelected(true);
        cfVar = this.dYD.dUT;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cfVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dYD.getPageContext().getPageActivity(), 1.0f));
        kVar = this.dYD.aso;
        kVar.zK();
        WriteActivity writeActivity = this.dYD;
        inputMethodManager = this.dYD.mInputManager;
        aMf = this.dYD.aMf();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aMf);
        WriteActivity writeActivity2 = this.dYD;
        inputMethodManager2 = this.dYD.mInputManager;
        aMe = this.dYD.aMe();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aMe);
    }
}
