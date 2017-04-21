package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fVs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fVs = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bqH;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.fVs.fVb;
        qVar.bpW();
        writeImagesInfo = this.fVs.fVa;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fVs.fVa;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fVs.fVa;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fVs.fVa;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fVs.fVp;
                        if (i > 0) {
                            bqH = this.fVs.bqH();
                            if (bqH) {
                                aVar = this.fVs.fVn;
                                if (aVar == null) {
                                    this.fVs.fVn = new com.baidu.tbadk.core.dialog.a(this.fVs.getActivity());
                                    aVar3 = this.fVs.fVn;
                                    aVar3.bZ(w.l.orginal_conflict_tip);
                                    aVar4 = this.fVs.fVn;
                                    aVar4.a(w.l.alert_yes_button, new cb(this));
                                    aVar5 = this.fVs.fVn;
                                    aVar5.b(w.l.alert_no_button, new cc(this));
                                    aVar6 = this.fVs.fVn;
                                    aVar6.b(this.fVs.getPageContext());
                                }
                                aVar2 = this.fVs.fVn;
                                aVar2.tQ();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fVs.bqK();
    }
}
