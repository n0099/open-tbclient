package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cf cfVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText aEn;
        InputMethodManager inputMethodManager2;
        EditText aEm;
        textView = this.dsa.don;
        textView.setSelected(true);
        cfVar = this.dsa.doo;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cfVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dsa.getPageContext().getPageActivity(), 1.0f));
        jVar = this.dsa.drr;
        jVar.zc();
        WriteActivity writeActivity = this.dsa;
        inputMethodManager = this.dsa.mInputManager;
        aEn = this.dsa.aEn();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aEn);
        WriteActivity writeActivity2 = this.dsa;
        inputMethodManager2 = this.dsa.mInputManager;
        aEm = this.dsa.aEm();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aEm);
    }
}
