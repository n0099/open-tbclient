package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cf cfVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.dsa.don;
        textView.setVisibility(0);
        view2 = this.dsa.doq;
        view2.setSelected(true);
        cfVar = this.dsa.doo;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cfVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dsa.getPageContext().getPageActivity(), 1.0f));
        jVar = this.dsa.drr;
        jVar.zc();
        WriteActivity writeActivity = this.dsa;
        inputMethodManager = this.dsa.mInputManager;
        editText = this.dsa.doh;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.dsa;
        inputMethodManager2 = this.dsa.mInputManager;
        editText2 = this.dsa.dol;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
