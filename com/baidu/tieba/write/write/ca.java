package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dqm = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean aDz;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.dqm.dpW;
        qVar.aCP();
        writeImagesInfo = this.dqm.dpV;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.dqm.dpV;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.dqm.dpV;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.dqm.dpV;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.dqm.dqk;
                        if (i > 0) {
                            aDz = this.dqm.aDz();
                            if (aDz) {
                                aVar = this.dqm.dqi;
                                if (aVar == null) {
                                    this.dqm.dqi = new com.baidu.tbadk.core.dialog.a(this.dqm.getActivity());
                                    aVar3 = this.dqm.dqi;
                                    aVar3.bF(i.h.orginal_conflict_tip);
                                    aVar4 = this.dqm.dqi;
                                    aVar4.a(i.h.alert_yes_button, new cb(this));
                                    aVar5 = this.dqm.dqi;
                                    aVar5.b(i.h.alert_no_button, new cc(this));
                                    aVar6 = this.dqm.dqi;
                                    aVar6.b(this.dqm.getPageContext());
                                }
                                aVar2 = this.dqm.dqi;
                                aVar2.sR();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.dqm.aDC();
    }
}
