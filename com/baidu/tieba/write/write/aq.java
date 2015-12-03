package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cf cfVar;
        com.baidu.tbadk.editortools.k kVar;
        InputMethodManager inputMethodManager;
        EditText aJK;
        InputMethodManager inputMethodManager2;
        EditText aJJ;
        textView = this.dRf.dNt;
        textView.setSelected(true);
        cfVar = this.dRf.dNu;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(cfVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dRf.getPageContext().getPageActivity(), 1.0f));
        kVar = this.dRf.aqK;
        kVar.zY();
        WriteActivity writeActivity = this.dRf;
        inputMethodManager = this.dRf.mInputManager;
        aJK = this.dRf.aJK();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aJK);
        WriteActivity writeActivity2 = this.dRf;
        inputMethodManager2 = this.dRf.mInputManager;
        aJJ = this.dRf.aJJ();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aJJ);
    }
}
