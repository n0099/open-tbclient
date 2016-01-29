package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cc ccVar;
        com.baidu.tbadk.editortools.k kVar;
        InputMethodManager inputMethodManager;
        EditText aUZ;
        InputMethodManager inputMethodManager2;
        EditText aUY;
        textView = this.ets.epx;
        textView.setSelected(true);
        ccVar = this.ets.epy;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(ccVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.ets.getPageContext().getPageActivity(), 1.0f));
        kVar = this.ets.ath;
        kVar.Ba();
        WriteActivity writeActivity = this.ets;
        inputMethodManager = this.ets.mInputManager;
        aUZ = this.ets.aUZ();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aUZ);
        WriteActivity writeActivity2 = this.ets;
        inputMethodManager2 = this.ets.mInputManager;
        aUY = this.ets.aUY();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aUY);
    }
}
