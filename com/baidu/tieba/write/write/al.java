package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.gpp = writeActivity;
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
        textView = this.gpp.fsS;
        textView.setVisibility(0);
        view2 = this.gpp.fsV;
        view2.setSelected(true);
        bVar = this.gpp.fsT;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.gpp.getPageContext().getPageActivity(), 1.0f));
        lVar = this.gpp.auI;
        lVar.Bc();
        WriteActivity writeActivity = this.gpp;
        inputMethodManager = this.gpp.mInputManager;
        editText = this.gpp.fsM;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.gpp;
        inputMethodManager2 = this.gpp.mInputManager;
        editText2 = this.gpp.fsQ;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
