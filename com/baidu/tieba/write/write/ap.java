package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText bug;
        InputMethodManager inputMethodManager2;
        EditText buf;
        com.baidu.tbadk.editortools.l lVar;
        boolean z;
        writeData = this.ghD.flk;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.ghD.flk;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.ghD;
            inputMethodManager = this.ghD.mInputManager;
            bug = this.ghD.bug();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bug);
            WriteActivity writeActivity2 = this.ghD;
            inputMethodManager2 = this.ghD.mInputManager;
            buf = this.ghD.buf();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, buf);
            lVar = this.ghD.atO;
            lVar.AV();
            this.ghD.btn();
            z = this.ghD.ggy;
            if (z) {
                com.baidu.adp.lib.stats.a.eI().eR();
            }
        }
    }
}
