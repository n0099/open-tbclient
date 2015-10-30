package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dqM = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean aDF;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.dqM.dqw;
        qVar.aCV();
        writeImagesInfo = this.dqM.dqv;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.dqM.dqv;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.dqM.dqv;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.dqM.dqv;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.dqM.dqK;
                        if (i > 0) {
                            aDF = this.dqM.aDF();
                            if (aDF) {
                                aVar = this.dqM.dqI;
                                if (aVar == null) {
                                    this.dqM.dqI = new com.baidu.tbadk.core.dialog.a(this.dqM.getActivity());
                                    aVar3 = this.dqM.dqI;
                                    aVar3.bF(i.h.orginal_conflict_tip);
                                    aVar4 = this.dqM.dqI;
                                    aVar4.a(i.h.alert_yes_button, new cb(this));
                                    aVar5 = this.dqM.dqI;
                                    aVar5.b(i.h.alert_no_button, new cc(this));
                                    aVar6 = this.dqM.dqI;
                                    aVar6.b(this.dqM.getPageContext());
                                }
                                aVar2 = this.dqM.dqI;
                                aVar2.sO();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.dqM.aDI();
    }
}
