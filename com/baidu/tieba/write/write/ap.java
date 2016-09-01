package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText btz;
        InputMethodManager inputMethodManager2;
        EditText bty;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.gfs.fiE;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.gfs.fiE;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.gfs;
            inputMethodManager = this.gfs.mInputManager;
            btz = this.gfs.btz();
            writeActivity.HidenSoftKeyPad(inputMethodManager, btz);
            WriteActivity writeActivity2 = this.gfs;
            inputMethodManager2 = this.gfs.mInputManager;
            bty = this.gfs.bty();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bty);
            lVar = this.gfs.auk;
            lVar.AS();
            this.gfs.bsH();
            z = this.gfs.gem;
            if (z) {
                com.baidu.adp.lib.stats.a.eI().eR();
            }
        }
    }
}
