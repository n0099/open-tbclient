package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        InputMethodManager inputMethodManager2;
        EditText editText2;
        WriteData writeData;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        WriteActivity writeActivity = this.cUM;
        inputMethodManager = this.cUM.mInputManager;
        editText = this.cUM.cSk;
        writeActivity.HidenSoftKeyPad(inputMethodManager, editText);
        WriteActivity writeActivity2 = this.cUM;
        inputMethodManager2 = this.cUM.mInputManager;
        editText2 = this.cUM.cSo;
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        writeData = this.cUM.cKS;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        jVar = this.cUM.cUo;
        jVar.zk();
        this.cUM.aur();
        z = this.cUM.cUa;
        if (z) {
            com.baidu.adp.lib.stats.a.hk().ht();
        }
    }
}
