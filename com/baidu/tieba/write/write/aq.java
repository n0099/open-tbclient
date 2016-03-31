package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bbz;
        InputMethodManager inputMethodManager2;
        EditText bby;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.eNd.esv;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.eNd.esv;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.eNd;
            inputMethodManager = this.eNd.mInputManager;
            bbz = this.eNd.bbz();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bbz);
            WriteActivity writeActivity2 = this.eNd;
            inputMethodManager2 = this.eNd.mInputManager;
            bby = this.eNd.bby();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bby);
            lVar = this.eNd.atG;
            lVar.BD();
            this.eNd.baH();
            z = this.eNd.eMk;
            if (z) {
                com.baidu.adp.lib.stats.a.hz().hI();
            }
        }
    }
}
