package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText boV;
        InputMethodManager inputMethodManager2;
        EditText boU;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.fMl.mData;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.fMl.mData;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.fMl;
            inputMethodManager = this.fMl.mInputManager;
            boV = this.fMl.boV();
            writeActivity.HidenSoftKeyPad(inputMethodManager, boV);
            WriteActivity writeActivity2 = this.fMl;
            inputMethodManager2 = this.fMl.mInputManager;
            boU = this.fMl.boU();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, boU);
            jVar = this.fMl.ats;
            jVar.AK();
            this.fMl.boe();
            z = this.fMl.fLa;
            if (z) {
                com.baidu.adp.lib.stats.a.eG().eP();
            }
        }
    }
}
