package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText bmq;
        InputMethodManager inputMethodManager2;
        EditText bmp;
        textView = this.fJw.fFn;
        textView.setSelected(true);
        bVar = this.fJw.fFo;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fJw.getPageContext().getPageActivity(), 1.0f));
        lVar = this.fJw.aqo;
        lVar.zD();
        WriteActivity writeActivity = this.fJw;
        inputMethodManager = this.fJw.mInputManager;
        bmq = this.fJw.bmq();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bmq);
        WriteActivity writeActivity2 = this.fJw;
        inputMethodManager2 = this.fJw.mInputManager;
        bmp = this.fJw.bmp();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bmp);
    }
}
