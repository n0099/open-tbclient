package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fRm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fRm = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean boY;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.fRm.fQV;
        qVar.bom();
        writeImagesInfo = this.fRm.fQU;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fRm.fQU;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fRm.fQU;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fRm.fQU;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fRm.fRj;
                        if (i > 0) {
                            boY = this.fRm.boY();
                            if (boY) {
                                aVar = this.fRm.fRh;
                                if (aVar == null) {
                                    this.fRm.fRh = new com.baidu.tbadk.core.dialog.a(this.fRm.getActivity());
                                    aVar3 = this.fRm.fRh;
                                    aVar3.bW(w.l.orginal_conflict_tip);
                                    aVar4 = this.fRm.fRh;
                                    aVar4.a(w.l.alert_yes_button, new cb(this));
                                    aVar5 = this.fRm.fRh;
                                    aVar5.b(w.l.alert_no_button, new cc(this));
                                    aVar6 = this.fRm.fRh;
                                    aVar6.b(this.fRm.getPageContext());
                                }
                                aVar2 = this.fRm.fRh;
                                aVar2.ts();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fRm.bpb();
    }
}
