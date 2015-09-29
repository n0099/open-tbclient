package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText aDn;
        InputMethodManager inputMethodManager2;
        EditText aDm;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.dpI.daX;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.dpI.daX;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.dpI;
            inputMethodManager = this.dpI.mInputManager;
            aDn = this.dpI.aDn();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aDn);
            WriteActivity writeActivity2 = this.dpI;
            inputMethodManager2 = this.dpI.mInputManager;
            aDm = this.dpI.aDm();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDm);
            jVar = this.dpI.dpc;
            jVar.za();
            this.dpI.aCw();
            z = this.dpI.doP;
            if (z) {
                com.baidu.adp.lib.stats.a.hi().hr();
            }
        }
    }
}
