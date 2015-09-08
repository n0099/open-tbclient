package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText azL;
        InputMethodManager inputMethodManager2;
        EditText azK;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.ddQ.cTs;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.ddQ.cTs;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.ddQ;
            inputMethodManager = this.ddQ.mInputManager;
            azL = this.ddQ.azL();
            writeActivity.HidenSoftKeyPad(inputMethodManager, azL);
            WriteActivity writeActivity2 = this.ddQ;
            inputMethodManager2 = this.ddQ.mInputManager;
            azK = this.ddQ.azK();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, azK);
            jVar = this.ddQ.ddl;
            jVar.zr();
            this.ddQ.azR();
            z = this.ddQ.dcX;
            if (z) {
                com.baidu.adp.lib.stats.a.hh().hq();
            }
        }
    }
}
