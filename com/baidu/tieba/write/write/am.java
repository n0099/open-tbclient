package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cc ccVar;
        com.baidu.tbadk.editortools.k kVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.ets.epx;
        textView.setVisibility(0);
        view2 = this.ets.epA;
        view2.setSelected(true);
        ccVar = this.ets.epy;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(ccVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.ets.getPageContext().getPageActivity(), 1.0f));
        kVar = this.ets.ath;
        kVar.Ba();
        WriteActivity writeActivity = this.ets;
        inputMethodManager = this.ets.mInputManager;
        editText = this.ets.epr;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.ets;
        inputMethodManager2 = this.ets.mInputManager;
        editText2 = this.ets.epv;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
