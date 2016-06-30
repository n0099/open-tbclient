package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fJw = writeActivity;
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
        textView = this.fJw.fFn;
        textView.setVisibility(0);
        view2 = this.fJw.fFq;
        view2.setSelected(true);
        bVar = this.fJw.fFo;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fJw.getPageContext().getPageActivity(), 1.0f));
        lVar = this.fJw.aqo;
        lVar.zD();
        WriteActivity writeActivity = this.fJw;
        inputMethodManager = this.fJw.mInputManager;
        editText = this.fJw.fFh;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fJw;
        inputMethodManager2 = this.fJw.mInputManager;
        editText2 = this.fJw.fFl;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
