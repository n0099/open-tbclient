package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.dRf = writeActivity;
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
        textView = this.dRf.dNt;
        textView.setVisibility(0);
        view2 = this.dRf.dNw;
        view2.setSelected(true);
        cfVar = this.dRf.dNu;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cfVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dRf.getPageContext().getPageActivity(), 1.0f));
        kVar = this.dRf.aqK;
        kVar.zY();
        WriteActivity writeActivity = this.dRf;
        inputMethodManager = this.dRf.mInputManager;
        editText = this.dRf.dNn;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.dRf;
        inputMethodManager2 = this.dRf.mInputManager;
        editText2 = this.dRf.dNr;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
