package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText aUZ;
        InputMethodManager inputMethodManager2;
        EditText aUY;
        com.baidu.tbadk.editortools.k kVar;
        boolean z;
        writeData = this.ets.dZC;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.ets.dZC;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.ets;
            inputMethodManager = this.ets.mInputManager;
            aUZ = this.ets.aUZ();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aUZ);
            WriteActivity writeActivity2 = this.ets;
            inputMethodManager2 = this.ets.mInputManager;
            aUY = this.ets.aUY();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aUY);
            kVar = this.ets.ath;
            kVar.Ba();
            this.ets.aUh();
            z = this.ets.esA;
            if (z) {
                com.baidu.adp.lib.stats.a.ht().hC();
            }
        }
    }
}
