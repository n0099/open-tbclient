package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        com.baidu.tieba.write.p pVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.glP.fCE;
        textView.setVisibility(0);
        view2 = this.glP.fCH;
        view2.setSelected(true);
        pVar = this.glP.fCF;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(pVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.glP.getPageContext().getPageActivity(), 1.0f));
        jVar = this.glP.azR;
        jVar.Bb();
        WriteActivity writeActivity = this.glP;
        inputMethodManager = this.glP.mInputManager;
        editText = this.glP.fCz;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.glP;
        inputMethodManager2 = this.glP.mInputManager;
        editText2 = this.glP.fCD;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
