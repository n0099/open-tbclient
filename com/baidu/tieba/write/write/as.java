package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText aEn;
        InputMethodManager inputMethodManager2;
        EditText aEm;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.dsa.ddI;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.dsa.ddI;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.dsa;
            inputMethodManager = this.dsa.mInputManager;
            aEn = this.dsa.aEn();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aEn);
            WriteActivity writeActivity2 = this.dsa;
            inputMethodManager2 = this.dsa.mInputManager;
            aEm = this.dsa.aEm();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aEm);
            jVar = this.dsa.drr;
            jVar.zc();
            this.dsa.aDu();
            z = this.dsa.dre;
            if (z) {
                com.baidu.adp.lib.stats.a.hj().hs();
            }
        }
    }
}
