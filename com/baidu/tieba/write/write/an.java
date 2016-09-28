package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText bug;
        InputMethodManager inputMethodManager2;
        EditText buf;
        textView = this.ghD.flJ;
        textView.setSelected(true);
        bVar = this.ghD.flK;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.ghD.getPageContext().getPageActivity(), 1.0f));
        lVar = this.ghD.atO;
        lVar.AV();
        WriteActivity writeActivity = this.ghD;
        inputMethodManager = this.ghD.mInputManager;
        bug = this.ghD.bug();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bug);
        WriteActivity writeActivity2 = this.ghD;
        inputMethodManager2 = this.ghD.mInputManager;
        buf = this.ghD.buf();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, buf);
    }
}
