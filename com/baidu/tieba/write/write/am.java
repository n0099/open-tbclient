package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.p pVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText but;
        InputMethodManager inputMethodManager2;
        EditText bus;
        textView = this.glP.fCE;
        textView.setSelected(true);
        pVar = this.glP.fCF;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(pVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.glP.getPageContext().getPageActivity(), 1.0f));
        jVar = this.glP.azR;
        jVar.Bb();
        WriteActivity writeActivity = this.glP;
        inputMethodManager = this.glP.mInputManager;
        but = this.glP.but();
        writeActivity.HidenSoftKeyPad(inputMethodManager, but);
        WriteActivity writeActivity2 = this.glP;
        inputMethodManager2 = this.glP.mInputManager;
        bus = this.glP.bus();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bus);
    }
}
