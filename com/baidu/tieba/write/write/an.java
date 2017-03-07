package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        InputMethodManager inputMethodManager;
        EditText boJ;
        InputMethodManager inputMethodManager2;
        EditText boI;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        writeData = this.fQG.mData;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.fQG.mData;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            writeData3 = this.fQG.mData;
            if (writeData3.getType() == 7) {
                TiebaStatic.log("c12015");
            }
            WriteActivity writeActivity = this.fQG;
            inputMethodManager = this.fQG.mInputManager;
            boJ = this.fQG.boJ();
            writeActivity.HidenSoftKeyPad(inputMethodManager, boJ);
            WriteActivity writeActivity2 = this.fQG;
            inputMethodManager2 = this.fQG.mInputManager;
            boI = this.fQG.boI();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, boI);
            jVar = this.fQG.ayN;
            jVar.Bd();
            this.fQG.bnR();
            z = this.fQG.fPt;
            if (z) {
                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
            }
        }
    }
}
