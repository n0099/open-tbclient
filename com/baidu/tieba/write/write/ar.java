package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bdV;
        InputMethodManager inputMethodManager2;
        EditText bdU;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.fea.evE;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.fea.evE;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.fea;
            inputMethodManager = this.fea.mInputManager;
            bdV = this.fea.bdV();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bdV);
            WriteActivity writeActivity2 = this.fea;
            inputMethodManager2 = this.fea.mInputManager;
            bdU = this.fea.bdU();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bdU);
            lVar = this.fea.apy;
            lVar.zy();
            this.fea.bdb();
            z = this.fea.fcX;
            if (z) {
                com.baidu.adp.lib.stats.a.dN().dW();
            }
        }
    }
}
