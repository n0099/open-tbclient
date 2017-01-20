package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText boV;
        InputMethodManager inputMethodManager2;
        EditText boU;
        textView = this.fMl.fge;
        textView.setSelected(true);
        bVar = this.fMl.fgf;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fMl.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fMl.ats;
        jVar.AK();
        WriteActivity writeActivity = this.fMl;
        inputMethodManager = this.fMl.mInputManager;
        boV = this.fMl.boV();
        writeActivity.HidenSoftKeyPad(inputMethodManager, boV);
        WriteActivity writeActivity2 = this.fMl;
        inputMethodManager2 = this.fMl.mInputManager;
        boU = this.fMl.boU();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, boU);
    }
}
