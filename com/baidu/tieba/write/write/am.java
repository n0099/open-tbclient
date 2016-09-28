package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.ghD = writeActivity;
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
        textView = this.ghD.flJ;
        textView.setVisibility(0);
        view2 = this.ghD.flM;
        view2.setSelected(true);
        bVar = this.ghD.flK;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.ghD.getPageContext().getPageActivity(), 1.0f));
        lVar = this.ghD.atO;
        lVar.AV();
        WriteActivity writeActivity = this.ghD;
        inputMethodManager = this.ghD.mInputManager;
        editText = this.ghD.flD;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.ghD;
        inputMethodManager2 = this.ghD.mInputManager;
        editText2 = this.ghD.flH;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
