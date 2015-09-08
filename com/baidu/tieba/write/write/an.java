package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cb cbVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.ddQ.dbd;
        textView.setVisibility(0);
        view2 = this.ddQ.dbg;
        view2.setSelected(true);
        cbVar = this.ddQ.dbe;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cbVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.ddQ.getPageContext().getPageActivity(), 1.0f));
        jVar = this.ddQ.ddl;
        jVar.zr();
        WriteActivity writeActivity = this.ddQ;
        inputMethodManager = this.ddQ.mInputManager;
        editText = this.ddQ.daX;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.ddQ;
        inputMethodManager2 = this.ddQ.mInputManager;
        editText2 = this.ddQ.dbb;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
