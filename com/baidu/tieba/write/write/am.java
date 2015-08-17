package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        bx bxVar;
        com.baidu.tbadk.editortools.j jVar;
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        textView = this.cUM.cSq;
        textView.setSelected(true);
        bxVar = this.cUM.cSr;
        com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(bxVar, view, 0, com.baidu.adp.lib.util.k.dip2px(this.cUM.getPageContext().getPageActivity(), 1.0f));
        jVar = this.cUM.cUo;
        jVar.zk();
        WriteActivity writeActivity = this.cUM;
        inputMethodManager = this.cUM.mInputManager;
        editText = this.cUM.cSk;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cUM;
        inputMethodManager2 = this.cUM.mInputManager;
        editText2 = this.cUM.cSo;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
    }
}
