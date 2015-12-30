package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        InputMethodManager inputMethodManager;
        EditText aMf;
        InputMethodManager inputMethodManager2;
        EditText aMe;
        com.baidu.tbadk.editortools.k kVar;
        boolean z;
        writeData = this.dYD.dJy;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            writeData2 = this.dYD.dJy;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteActivity writeActivity = this.dYD;
            inputMethodManager = this.dYD.mInputManager;
            aMf = this.dYD.aMf();
            writeActivity.HidenSoftKeyPad(inputMethodManager, aMf);
            WriteActivity writeActivity2 = this.dYD;
            inputMethodManager2 = this.dYD.mInputManager;
            aMe = this.dYD.aMe();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, aMe);
            kVar = this.dYD.aso;
            kVar.zK();
            this.dYD.aLm();
            z = this.dYD.dXH;
            if (z) {
                com.baidu.adp.lib.stats.a.hl().hu();
            }
        }
    }
}
