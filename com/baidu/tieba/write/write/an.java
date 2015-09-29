package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        cd cdVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.dpI.dmf;
        textView.setVisibility(0);
        view2 = this.dpI.dmi;
        view2.setSelected(true);
        cdVar = this.dpI.dmg;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(cdVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.dpI.getPageContext().getPageActivity(), 1.0f));
        jVar = this.dpI.dpc;
        jVar.za();
        WriteActivity writeActivity = this.dpI;
        inputMethodManager = this.dpI.mInputManager;
        editText = this.dpI.dlZ;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.dpI;
        inputMethodManager2 = this.dpI.mInputManager;
        editText2 = this.dpI.dmd;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
