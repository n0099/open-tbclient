package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fSW = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bpG;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.fSW.fSF;
        qVar.boV();
        writeImagesInfo = this.fSW.fSE;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fSW.fSE;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fSW.fSE;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fSW.fSE;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fSW.fST;
                        if (i > 0) {
                            bpG = this.fSW.bpG();
                            if (bpG) {
                                aVar = this.fSW.fSR;
                                if (aVar == null) {
                                    this.fSW.fSR = new com.baidu.tbadk.core.dialog.a(this.fSW.getActivity());
                                    aVar3 = this.fSW.fSR;
                                    aVar3.bZ(w.l.orginal_conflict_tip);
                                    aVar4 = this.fSW.fSR;
                                    aVar4.a(w.l.alert_yes_button, new cb(this));
                                    aVar5 = this.fSW.fSR;
                                    aVar5.b(w.l.alert_no_button, new cc(this));
                                    aVar6 = this.fSW.fSR;
                                    aVar6.b(this.fSW.getPageContext());
                                }
                                aVar2 = this.fSW.fSR;
                                aVar2.tQ();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fSW.bpJ();
    }
}
