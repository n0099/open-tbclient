package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bwy;
        InputMethodManager inputMethodManager2;
        EditText bwx;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.gpp.fst;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.gpp.fst;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.gpp;
            inputMethodManager = this.gpp.mInputManager;
            bwy = this.gpp.bwy();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bwy);
            WriteActivity writeActivity2 = this.gpp;
            inputMethodManager2 = this.gpp.mInputManager;
            bwx = this.gpp.bwx();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bwx);
            lVar = this.gpp.auI;
            lVar.Bc();
            this.gpp.bvI();
            z = this.gpp.goc;
            if (z) {
                com.baidu.adp.lib.stats.a.eI().eR();
            }
        }
    }
}
