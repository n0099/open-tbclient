package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.feb = writeActivity;
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
        textView = this.feb.fak;
        textView.setVisibility(0);
        view2 = this.feb.fan;
        view2.setSelected(true);
        bVar = this.feb.fal;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.feb.getPageContext().getPageActivity(), 1.0f));
        lVar = this.feb.apy;
        lVar.zx();
        WriteActivity writeActivity = this.feb;
        inputMethodManager = this.feb.mInputManager;
        editText = this.feb.fae;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.feb;
        inputMethodManager2 = this.feb.mInputManager;
        editText2 = this.feb.fai;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
