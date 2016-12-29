package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fEx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fEx = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bnM;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.fEx.fEg;
        rVar.bnb();
        writeImagesInfo = this.fEx.fEe;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fEx.fEe;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fEx.fEe;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fEx.fEe;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fEx.fEu;
                        if (i > 0) {
                            bnM = this.fEx.bnM();
                            if (bnM) {
                                aVar = this.fEx.fEs;
                                if (aVar == null) {
                                    this.fEx.fEs = new com.baidu.tbadk.core.dialog.a(this.fEx.getActivity());
                                    aVar3 = this.fEx.fEs;
                                    aVar3.cb(r.j.orginal_conflict_tip);
                                    aVar4 = this.fEx.fEs;
                                    aVar4.a(r.j.alert_yes_button, new cc(this));
                                    aVar5 = this.fEx.fEs;
                                    aVar5.b(r.j.alert_no_button, new cd(this));
                                    aVar6 = this.fEx.fEs;
                                    aVar6.b(this.fEx.getPageContext());
                                }
                                aVar2 = this.fEx.fEs;
                                aVar2.tb();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fEx.bnP();
    }
}
