package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fVY = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bpz;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.fVY.fVH;
        rVar.boN();
        writeImagesInfo = this.fVY.fVG;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fVY.fVG;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fVY.fVG;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fVY.fVG;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fVY.fVV;
                        if (i > 0) {
                            bpz = this.fVY.bpz();
                            if (bpz) {
                                aVar = this.fVY.fVT;
                                if (aVar == null) {
                                    this.fVY.fVT = new com.baidu.tbadk.core.dialog.a(this.fVY.getActivity());
                                    aVar3 = this.fVY.fVT;
                                    aVar3.bM(u.j.orginal_conflict_tip);
                                    aVar4 = this.fVY.fVT;
                                    aVar4.a(u.j.alert_yes_button, new cd(this));
                                    aVar5 = this.fVY.fVT;
                                    aVar5.b(u.j.alert_no_button, new ce(this));
                                    aVar6 = this.fVY.fVT;
                                    aVar6.b(this.fVY.getPageContext());
                                }
                                aVar2 = this.fVY.fVT;
                                aVar2.rS();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fVY.bpC();
    }
}
