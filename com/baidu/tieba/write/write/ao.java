package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bnx;
        InputMethodManager inputMethodManager2;
        EditText bnw;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.fDQ.eWm;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.fDQ.eWm;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.fDQ;
            inputMethodManager = this.fDQ.mInputManager;
            bnx = this.fDQ.bnx();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bnx);
            WriteActivity writeActivity2 = this.fDQ;
            inputMethodManager2 = this.fDQ.mInputManager;
            bnw = this.fDQ.bnw();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bnw);
            jVar = this.fDQ.aun;
            jVar.AP();
            this.fDQ.bmG();
            z = this.fDQ.fCF;
            if (z) {
                com.baidu.adp.lib.stats.a.eI().eR();
            }
        }
    }
}
