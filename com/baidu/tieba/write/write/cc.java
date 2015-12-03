package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dRJ = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean aJW;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.dRJ.dRt;
        qVar.aJk();
        writeImagesInfo = this.dRJ.dRr;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.dRJ.dRr;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.dRJ.dRr;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.dRJ.dRr;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.dRJ.dRH;
                        if (i > 0) {
                            aJW = this.dRJ.aJW();
                            if (aJW) {
                                aVar = this.dRJ.dRF;
                                if (aVar == null) {
                                    this.dRJ.dRF = new com.baidu.tbadk.core.dialog.a(this.dRJ.getActivity());
                                    aVar3 = this.dRJ.dRF;
                                    aVar3.bN(n.i.orginal_conflict_tip);
                                    aVar4 = this.dRJ.dRF;
                                    aVar4.a(n.i.alert_yes_button, new cd(this));
                                    aVar5 = this.dRJ.dRF;
                                    aVar5.b(n.i.alert_no_button, new ce(this));
                                    aVar6 = this.dRJ.dRF;
                                    aVar6.b(this.dRJ.getPageContext());
                                }
                                aVar2 = this.dRJ.dRF;
                                aVar2.tv();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.dRJ.aJZ();
    }
}
