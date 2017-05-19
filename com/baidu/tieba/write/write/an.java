package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.fSV.fkC;
        textView.setVisibility(0);
        view2 = this.fSV.fkF;
        view2.setSelected(true);
        bVar = this.fSV.fkD;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fSV.getPageContext().getPageActivity(), 1.0f));
        jVar = this.fSV.azd;
        jVar.AN();
        WriteActivity writeActivity = this.fSV;
        inputMethodManager = this.fSV.mInputManager;
        editText = this.fSV.fkx;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fSV;
        inputMethodManager2 = this.fSV.mInputManager;
        editText2 = this.fSV.fkB;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
