package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.fea = writeActivity;
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
        textView = this.fea.faj;
        textView.setVisibility(0);
        view2 = this.fea.fam;
        view2.setSelected(true);
        bVar = this.fea.fak;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.fea.getPageContext().getPageActivity(), 1.0f));
        lVar = this.fea.apy;
        lVar.zy();
        WriteActivity writeActivity = this.fea;
        inputMethodManager = this.fea.mInputManager;
        editText = this.fea.fad;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.fea;
        inputMethodManager2 = this.fea.mInputManager;
        editText2 = this.fea.fah;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
