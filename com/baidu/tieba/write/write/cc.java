package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity dZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.dZh = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean aMr;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.dZh.dYR;
        qVar.aLF();
        writeImagesInfo = this.dZh.dYP;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.dZh.dYP;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.dZh.dYP;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.dZh.dYP;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.dZh.dZf;
                        if (i > 0) {
                            aMr = this.dZh.aMr();
                            if (aMr) {
                                aVar = this.dZh.dZd;
                                if (aVar == null) {
                                    this.dZh.dZd = new com.baidu.tbadk.core.dialog.a(this.dZh.getActivity());
                                    aVar3 = this.dZh.dZd;
                                    aVar3.bG(n.j.orginal_conflict_tip);
                                    aVar4 = this.dZh.dZd;
                                    aVar4.a(n.j.alert_yes_button, new cd(this));
                                    aVar5 = this.dZh.dZd;
                                    aVar5.b(n.j.alert_no_button, new ce(this));
                                    aVar6 = this.dZh.dZd;
                                    aVar6.b(this.dZh.getPageContext());
                                }
                                aVar2 = this.dZh.dZd;
                                aVar2.tf();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.dZh.aMu();
    }
}
