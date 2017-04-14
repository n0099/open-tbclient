package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText bps;
        InputMethodManager inputMethodManager2;
        EditText bpr;
        textView = this.fSq.fmj;
        textView.setSelected(true);
        bVar = this.fSq.fmk;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fSq.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fSq.azd;
        jVar.BC();
        WriteActivity writeActivity = this.fSq;
        inputMethodManager = this.fSq.mInputManager;
        bps = this.fSq.bps();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bps);
        WriteActivity writeActivity2 = this.fSq;
        inputMethodManager2 = this.fSq.mInputManager;
        bpr = this.fSq.bpr();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpr);
    }
}
