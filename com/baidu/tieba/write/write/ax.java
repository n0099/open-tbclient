package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        EditorToolComponetContainer editorToolComponetContainer;
        boolean z;
        WriteActivity writeActivity = this.cCP;
        inputMethodManager = this.cCP.mInputManager;
        editText = this.cCP.cAu;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cCP;
        inputMethodManager2 = this.cCP.mInputManager;
        editText2 = this.cCP.cAy;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        editorToolComponetContainer = this.cCP.cqO;
        editorToolComponetContainer.hideAll();
        this.cCP.asA();
        z = this.cCP.cCk;
        if (z) {
            com.baidu.adp.lib.h.a.iB().iG();
        }
    }
}
