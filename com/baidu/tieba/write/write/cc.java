package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dsE = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean aEz;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.dsE.dso;
        qVar.aDN();
        writeImagesInfo = this.dsE.dsn;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.dsE.dsn;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.dsE.dsn;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.dsE.dsn;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.dsE.dsC;
                        if (i > 0) {
                            aEz = this.dsE.aEz();
                            if (aEz) {
                                aVar = this.dsE.dsA;
                                if (aVar == null) {
                                    this.dsE.dsA = new com.baidu.tbadk.core.dialog.a(this.dsE.getActivity());
                                    aVar3 = this.dsE.dsA;
                                    aVar3.bF(i.h.orginal_conflict_tip);
                                    aVar4 = this.dsE.dsA;
                                    aVar4.a(i.h.alert_yes_button, new cd(this));
                                    aVar5 = this.dsE.dsA;
                                    aVar5.b(i.h.alert_no_button, new ce(this));
                                    aVar6 = this.dsE.dsA;
                                    aVar6.b(this.dsE.getPageContext());
                                }
                                aVar2 = this.dsE.dsA;
                                aVar2.sR();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.dsE.aEC();
    }
}
