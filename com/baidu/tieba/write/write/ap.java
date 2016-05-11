package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        com.baidu.tieba.write.b bVar;
        com.baidu.tbadk.editortools.l lVar;
        InputMethodManager inputMethodManager;
        EditText bdO;
        InputMethodManager inputMethodManager2;
        EditText bdN;
        textView = this.feb.fak;
        textView.setSelected(true);
        bVar = this.feb.fal;
        com.baidu.adp.lib.h.j.showPopupWindowAsDropDown(bVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.feb.getPageContext().getPageActivity(), 1.0f));
        lVar = this.feb.apy;
        lVar.zx();
        WriteActivity writeActivity = this.feb;
        inputMethodManager = this.feb.mInputManager;
        bdO = this.feb.bdO();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bdO);
        WriteActivity writeActivity2 = this.feb;
        inputMethodManager2 = this.feb.mInputManager;
        bdN = this.feb.bdN();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bdN);
    }
}
