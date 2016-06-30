package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bmq;
        InputMethodManager inputMethodManager2;
        EditText bmp;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.fJw.fau;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.fJw.fau;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.fJw;
            inputMethodManager = this.fJw.mInputManager;
            bmq = this.fJw.bmq();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bmq);
            WriteActivity writeActivity2 = this.fJw;
            inputMethodManager2 = this.fJw.mInputManager;
            bmp = this.fJw.bmp();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bmp);
            lVar = this.fJw.aqo;
            lVar.zD();
            this.fJw.blx();
            z = this.fJw.fIr;
            if (z) {
                com.baidu.adp.lib.stats.a.dO().dX();
            }
        }
    }
}
