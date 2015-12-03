package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText aJK;
        InputMethodManager inputMethodManager2;
        EditText aJJ;
        com.baidu.tbadk.editortools.k kVar;
        boolean z;
        writeData = this.dRf.dBW;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.dRf.dBW;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.dRf;
            inputMethodManager = this.dRf.mInputManager;
            aJK = this.dRf.aJK();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aJK);
            WriteActivity writeActivity2 = this.dRf;
            inputMethodManager2 = this.dRf.mInputManager;
            aJJ = this.dRf.aJJ();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aJJ);
            kVar = this.dRf.aqK;
            kVar.zY();
            this.dRf.aIR();
            z = this.dRf.dQj;
            if (z) {
                com.baidu.adp.lib.stats.a.hl().hu();
            }
        }
    }
}
