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
        EditText aDx;
        InputMethodManager inputMethodManager2;
        EditText aDw;
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
            aDx = this.dqi.aDx();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aDx);
            WriteActivity writeActivity2 = this.dqi;
            inputMethodManager2 = this.dqi.mInputManager;
            aDw = this.dqi.aDw();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aDw);
            jVar = this.dqi.dpD;
            jVar.za();
            this.dqi.aCG();
            z = this.dqi.dpq;
            if (z) {
                com.baidu.adp.lib.stats.a.hi().hr();
            }
        }
    }
}
