package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        cd cdVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText aDn;
        InputMethodManager inputMethodManager2;
        EditText aDm;
        textView = this.dpI.dmf;
        textView.setSelected(true);
        cdVar = this.dpI.dmg;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cdVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dpI.getPageContext().getPageActivity(), 1.0f));
        jVar = this.dpI.dpc;
        jVar.za();
        WriteActivity writeActivity = this.dpI;
        inputMethodManager = this.dpI.mInputManager;
        aDn = this.dpI.aDn();
        writeActivity.HidenSoftKeyPad(inputMethodManager, aDn);
        WriteActivity writeActivity2 = this.dpI;
        inputMethodManager2 = this.dpI.mInputManager;
        aDm = this.dpI.aDm();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDm);
    }
}
