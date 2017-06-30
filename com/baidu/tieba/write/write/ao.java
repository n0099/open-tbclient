package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText but;
        InputMethodManager inputMethodManager2;
        EditText bus;
        com.baidu.tbadk.editortools.j jVar;
        WriteData writeData;
        boolean z;
        WriteData writeData2;
        com.baidu.tieba.write.a aVar;
        com.baidu.tieba.write.a aVar2;
        String threadTitle;
        String buA;
        String str;
        if (!com.baidu.adp.lib.util.i.hj()) {
            this.glP.showToast(w.l.neterror);
        }
        if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
            WriteActivity writeActivity = this.glP;
            inputMethodManager = this.glP.mInputManager;
            but = this.glP.but();
            writeActivity.HidenSoftKeyPad(inputMethodManager, but);
            WriteActivity writeActivity2 = this.glP;
            inputMethodManager2 = this.glP.mInputManager;
            bus = this.glP.bus();
            writeActivity2.HidenSoftKeyPad(inputMethodManager2, bus);
            jVar = this.glP.azR;
            jVar.Bb();
            writeData = this.glP.mData;
            if (writeData.getType() != 7) {
                z = this.glP.gky;
                if (!z) {
                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c12102");
                    writeData2 = this.glP.mData;
                    auVar.r("obj_type", StringUtils.isNull(writeData2.getForumName()) ? 1 : 2);
                    TiebaStatic.log(auVar);
                    aVar = this.glP.glw;
                    if (!aVar.brv()) {
                        this.glP.glx = true;
                        aVar2 = this.glP.glw;
                        threadTitle = this.glP.getThreadTitle();
                        buA = this.glP.buA();
                        aVar2.ck(threadTitle, buA);
                    } else {
                        this.glP.buB();
                    }
                } else {
                    this.glP.btA();
                    BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                }
            } else {
                TiebaStatic.log("c12015");
                this.glP.btA();
            }
            com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c12262");
            str = this.glP.ggZ;
            TiebaStatic.log(auVar2.Z("obj_locate", str));
        }
    }
}
