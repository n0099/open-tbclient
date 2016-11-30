package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText bwy;
        InputMethodManager inputMethodManager2;
        EditText bwx;
        textView = this.gpp.fsS;
        textView.setSelected(true);
        bVar = this.gpp.fsT;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.gpp.getPageContext().getPageActivity(), 1.0f));
        lVar = this.gpp.auI;
        lVar.Bc();
        WriteActivity writeActivity = this.gpp;
        inputMethodManager = this.gpp.mInputManager;
        bwy = this.gpp.bwy();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bwy);
        WriteActivity writeActivity2 = this.gpp;
        inputMethodManager2 = this.gpp.mInputManager;
        bwx = this.gpp.bwx();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bwx);
    }
}
