package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer;
        boolean z;
        WriteActivity writeActivity = this.cCQ;
        inputMethodManager = this.cCQ.mInputManager;
        editText = this.cCQ.cAv;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cCQ;
        inputMethodManager2 = this.cCQ.mInputManager;
        editText2 = this.cCQ.cAz;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        editorToolComponetContainer = this.cCQ.cqP;
        editorToolComponetContainer.hideAll();
        this.cCQ.asB();
        z = this.cCQ.cCl;
        if (z) {
            com.baidu.adp.lib.h.a.iB().iG();
        }
    }
}
