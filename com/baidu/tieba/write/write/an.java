package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText bpk;
        InputMethodManager inputMethodManager2;
        EditText bpj;
        textView = this.fVn.faP;
        textView.setSelected(true);
        bVar = this.fVn.faQ;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fVn.getPageContext().getPageActivity(), 1.0f));
        lVar = this.fVn.ard;
        lVar.zD();
        WriteActivity writeActivity = this.fVn;
        inputMethodManager = this.fVn.mInputManager;
        bpk = this.fVn.bpk();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bpk);
        WriteActivity writeActivity2 = this.fVn;
        inputMethodManager2 = this.fVn.mInputManager;
        bpj = this.fVn.bpj();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpj);
    }
}
