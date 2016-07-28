package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bpk;
        InputMethodManager inputMethodManager2;
        EditText bpj;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.fVn.faq;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.fVn.faq;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.fVn;
            inputMethodManager = this.fVn.mInputManager;
            bpk = this.fVn.bpk();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bpk);
            WriteActivity writeActivity2 = this.fVn;
            inputMethodManager2 = this.fVn.mInputManager;
            bpj = this.fVn.bpj();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpj);
            lVar = this.fVn.ard;
            lVar.zD();
            this.fVn.bos();
            z = this.fVn.fUi;
            if (z) {
                com.baidu.adp.lib.stats.a.dN().dW();
            }
        }
    }
}
