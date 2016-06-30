package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fKh = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bmF;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.fKh.fJQ;
        rVar.blS();
        writeImagesInfo = this.fKh.fJP;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fKh.fJP;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fKh.fJP;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fKh.fJP;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fKh.fKe;
                        if (i > 0) {
                            bmF = this.fKh.bmF();
                            if (bmF) {
                                aVar = this.fKh.fKc;
                                if (aVar == null) {
                                    this.fKh.fKc = new com.baidu.tbadk.core.dialog.a(this.fKh.getActivity());
                                    aVar3 = this.fKh.fKc;
                                    aVar3.bM(u.j.orginal_conflict_tip);
                                    aVar4 = this.fKh.fKc;
                                    aVar4.a(u.j.alert_yes_button, new cd(this));
                                    aVar5 = this.fKh.fKc;
                                    aVar5.b(u.j.alert_no_button, new ce(this));
                                    aVar6 = this.fKh.fKc;
                                    aVar6.b(this.fKh.getPageContext());
                                }
                                aVar2 = this.fKh.fKc;
                                aVar2.rT();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fKh.bmI();
    }
}
