package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.fVn.faP;
        textView.setVisibility(0);
        view2 = this.fVn.faS;
        view2.setSelected(true);
        bVar = this.fVn.faQ;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fVn.getPageContext().getPageActivity(), 1.0f));
        lVar = this.fVn.ard;
        lVar.zD();
        WriteActivity writeActivity = this.fVn;
        inputMethodManager = this.fVn.mInputManager;
        editText = this.fVn.faJ;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fVn;
        inputMethodManager2 = this.fVn.mInputManager;
        editText2 = this.fVn.faN;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
