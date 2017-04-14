package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.fSq = writeActivity;
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
        textView = this.fSq.fmj;
        textView.setVisibility(0);
        view2 = this.fSq.fmm;
        view2.setSelected(true);
        bVar = this.fSq.fmk;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fSq.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fSq.azd;
        jVar.BC();
        WriteActivity writeActivity = this.fSq;
        inputMethodManager = this.fSq.mInputManager;
        editText = this.fSq.fme;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fSq;
        inputMethodManager2 = this.fSq.mInputManager;
        editText2 = this.fSq.fmi;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
