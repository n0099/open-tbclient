package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cb cbVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText azL;
        InputMethodManager inputMethodManager2;
        EditText azK;
        textView = this.ddQ.dbd;
        textView.setSelected(true);
        cbVar = this.ddQ.dbe;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cbVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.ddQ.getPageContext().getPageActivity(), 1.0f));
        jVar = this.ddQ.ddl;
        jVar.zr();
        WriteActivity writeActivity = this.ddQ;
        inputMethodManager = this.ddQ.mInputManager;
        azL = this.ddQ.azL();
        writeActivity.HidenSoftKeyPad(inputMethodManager, azL);
        WriteActivity writeActivity2 = this.ddQ;
        inputMethodManager2 = this.ddQ.mInputManager;
        azK = this.ddQ.azK();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, azK);
    }
}
