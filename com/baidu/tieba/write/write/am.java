package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r0.size() <= 0) goto L17;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        InputMethodManager inputMethodManager;
        EditText bps;
        InputMethodManager inputMethodManager2;
        EditText bpr;
        com.baidu.tbadk.editortools.j jVar;
        boolean z;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        writeData = this.fSq.mData;
        if (writeData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        if (!com.baidu.tieba.write.d.a.isFastDoubleClick()) {
            writeData2 = this.fSq.mData;
            if (writeData2.getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            writeData3 = this.fSq.mData;
            if (writeData3.getType() == 7) {
                TiebaStatic.log("c12015");
                writeImagesInfo = this.fSq.writeImagesInfo;
                if (writeImagesInfo != null) {
                    writeImagesInfo2 = this.fSq.writeImagesInfo;
                }
                this.fSq.showToast(w.l.bottle_tip_before_post);
                return;
            }
            WriteActivity writeActivity = this.fSq;
            inputMethodManager = this.fSq.mInputManager;
            bps = this.fSq.bps();
            writeActivity.HidenSoftKeyPad(inputMethodManager, bps);
            WriteActivity writeActivity2 = this.fSq;
            inputMethodManager2 = this.fSq.mInputManager;
            bpr = this.fSq.bpr();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bpr);
            jVar = this.fSq.azd;
            jVar.BC();
            this.fSq.boA();
            z = this.fSq.fRd;
            if (z) {
                BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
            }
        }
    }
}
