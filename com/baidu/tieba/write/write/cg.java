package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity feN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.feN = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bed;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.feN.few;
        rVar.bdp();
        writeImagesInfo = this.feN.fev;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.feN.fev;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.feN.fev;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.feN.fev;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.feN.feK;
                        if (i > 0) {
                            bed = this.feN.bed();
                            if (bed) {
                                aVar = this.feN.feI;
                                if (aVar == null) {
                                    this.feN.feI = new com.baidu.tbadk.core.dialog.a(this.feN.getActivity());
                                    aVar3 = this.feN.feI;
                                    aVar3.bM(t.j.orginal_conflict_tip);
                                    aVar4 = this.feN.feI;
                                    aVar4.a(t.j.alert_yes_button, new ch(this));
                                    aVar5 = this.feN.feI;
                                    aVar5.b(t.j.alert_no_button, new ci(this));
                                    aVar6 = this.feN.feI;
                                    aVar6.b(this.feN.getPageContext());
                                }
                                aVar2 = this.feN.feI;
                                aVar2.rU();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.feN.beg();
    }
}
