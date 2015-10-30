package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText aDt;
        InputMethodManager inputMethodManager2;
        EditText aDs;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.dqi.dbx;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.dqi.dbx;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.dqi;
            inputMethodManager = this.dqi.mInputManager;
            aDt = this.dqi.aDt();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aDt);
            WriteActivity writeActivity2 = this.dqi;
            inputMethodManager2 = this.dqi.mInputManager;
            aDs = this.dqi.aDs();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDs);
            jVar = this.dqi.dpD;
            jVar.yX();
            this.dqi.aCC();
            z = this.dqi.dpq;
            if (z) {
                com.baidu.adp.lib.stats.a.hi().hr();
            }
        }
    }
}
