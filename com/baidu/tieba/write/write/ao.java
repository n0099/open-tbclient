package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText bpW;
        InputMethodManager inputMethodManager2;
        EditText bpV;
        textView = this.gaR.fsu;
        textView.setSelected(true);
        bVar = this.gaR.fsv;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.gaR.getPageContext().getPageActivity(), 1.0f));
        jVar = this.gaR.ayP;
        jVar.AG();
        WriteActivity writeActivity = this.gaR;
        inputMethodManager = this.gaR.mInputManager;
        bpW = this.gaR.bpW();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bpW);
        WriteActivity writeActivity2 = this.gaR;
        inputMethodManager2 = this.gaR.mInputManager;
        bpV = this.gaR.bpV();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpV);
    }
}
