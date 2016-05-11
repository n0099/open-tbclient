package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bdO;
        InputMethodManager inputMethodManager2;
        EditText bdN;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.feb.evE;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.feb.evE;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.feb;
            inputMethodManager = this.feb.mInputManager;
            bdO = this.feb.bdO();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bdO);
            WriteActivity writeActivity2 = this.feb;
            inputMethodManager2 = this.feb.mInputManager;
            bdN = this.feb.bdN();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bdN);
            lVar = this.feb.apy;
            lVar.zx();
            this.feb.bcU();
            z = this.feb.fcY;
            if (z) {
                com.baidu.adp.lib.stats.a.dN().dW();
            }
        }
    }
}
