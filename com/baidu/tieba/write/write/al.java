package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.fDQ.eWL;
        textView.setVisibility(0);
        view2 = this.fDQ.eWO;
        view2.setSelected(true);
        bVar = this.fDQ.eWM;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fDQ.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fDQ.aun;
        jVar.AP();
        WriteActivity writeActivity = this.fDQ;
        inputMethodManager = this.fDQ.mInputManager;
        editText = this.fDQ.eWF;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fDQ;
        inputMethodManager2 = this.fDQ.mInputManager;
        editText2 = this.fDQ.eWJ;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
