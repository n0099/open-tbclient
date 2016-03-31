package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity eNN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.eNN = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bbL;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.eNN.eNx;
        rVar.bbc();
        writeImagesInfo = this.eNN.eNv;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.eNN.eNv;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.eNN.eNv;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.eNN.eNv;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.eNN.eNL;
                        if (i > 0) {
                            bbL = this.eNN.bbL();
                            if (bbL) {
                                aVar = this.eNN.eNJ;
                                if (aVar == null) {
                                    this.eNN.eNJ = new com.baidu.tbadk.core.dialog.a(this.eNN.getActivity());
                                    aVar3 = this.eNN.eNJ;
                                    aVar3.ca(t.j.orginal_conflict_tip);
                                    aVar4 = this.eNN.eNJ;
                                    aVar4.a(t.j.alert_yes_button, new ce(this));
                                    aVar5 = this.eNN.eNJ;
                                    aVar5.b(t.j.alert_no_button, new cf(this));
                                    aVar6 = this.eNN.eNJ;
                                    aVar6.b(this.eNN.getPageContext());
                                }
                                aVar2 = this.eNN.eNJ;
                                aVar2.up();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.eNN.bbO();
    }
}
