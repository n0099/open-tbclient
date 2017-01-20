package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fMR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fMR = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bpk;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.fMR.fMA;
        qVar.boz();
        writeImagesInfo = this.fMR.fMz;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fMR.fMz;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fMR.fMz;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fMR.fMz;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fMR.fMO;
                        if (i > 0) {
                            bpk = this.fMR.bpk();
                            if (bpk) {
                                aVar = this.fMR.fMM;
                                if (aVar == null) {
                                    this.fMR.fMM = new com.baidu.tbadk.core.dialog.a(this.fMR.getActivity());
                                    aVar3 = this.fMR.fMM;
                                    aVar3.ca(r.l.orginal_conflict_tip);
                                    aVar4 = this.fMR.fMM;
                                    aVar4.a(r.l.alert_yes_button, new cb(this));
                                    aVar5 = this.fMR.fMM;
                                    aVar5.b(r.l.alert_no_button, new cc(this));
                                    aVar6 = this.fMR.fMM;
                                    aVar6.b(this.fMR.getPageContext());
                                }
                                aVar2 = this.fMR.fMM;
                                aVar2.sV();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fMR.bpn();
    }
}
