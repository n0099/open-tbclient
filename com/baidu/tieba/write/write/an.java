package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText btz;
        InputMethodManager inputMethodManager2;
        EditText bty;
        textView = this.gfs.fjd;
        textView.setSelected(true);
        bVar = this.gfs.fje;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.gfs.getPageContext().getPageActivity(), 1.0f));
        lVar = this.gfs.auk;
        lVar.AS();
        WriteActivity writeActivity = this.gfs;
        inputMethodManager = this.gfs.mInputManager;
        btz = this.gfs.btz();
        writeActivity.HidenSoftKeyPad(inputMethodManager, btz);
        WriteActivity writeActivity2 = this.gfs;
        inputMethodManager2 = this.gfs.mInputManager;
        bty = this.gfs.bty();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bty);
    }
}
