package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText bnx;
        InputMethodManager inputMethodManager2;
        EditText bnw;
        textView = this.fDQ.eWL;
        textView.setSelected(true);
        bVar = this.fDQ.eWM;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fDQ.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fDQ.aun;
        jVar.AP();
        WriteActivity writeActivity = this.fDQ;
        inputMethodManager = this.fDQ.mInputManager;
        bnx = this.fDQ.bnx();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bnx);
        WriteActivity writeActivity2 = this.fDQ;
        inputMethodManager2 = this.fDQ.mInputManager;
        bnw = this.fDQ.bnw();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bnw);
    }
}
