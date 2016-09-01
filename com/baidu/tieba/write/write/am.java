package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.gfs = writeActivity;
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
        textView = this.gfs.fjd;
        textView.setVisibility(0);
        view2 = this.gfs.fjg;
        view2.setSelected(true);
        bVar = this.gfs.fje;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.gfs.getPageContext().getPageActivity(), 1.0f));
        lVar = this.gfs.auk;
        lVar.AS();
        WriteActivity writeActivity = this.gfs;
        inputMethodManager = this.gfs.mInputManager;
        editText = this.gfs.fiX;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.gfs;
        inputMethodManager2 = this.gfs.mInputManager;
        editText2 = this.gfs.fjb;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
