package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity feM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.feM = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bek;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.feM.fev;
        rVar.bdw();
        writeImagesInfo = this.feM.feu;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.feM.feu;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.feM.feu;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.feM.feu;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.feM.feJ;
                        if (i > 0) {
                            bek = this.feM.bek();
                            if (bek) {
                                aVar = this.feM.feH;
                                if (aVar == null) {
                                    this.feM.feH = new com.baidu.tbadk.core.dialog.a(this.feM.getActivity());
                                    aVar3 = this.feM.feH;
                                    aVar3.bL(t.j.orginal_conflict_tip);
                                    aVar4 = this.feM.feH;
                                    aVar4.a(t.j.alert_yes_button, new ch(this));
                                    aVar5 = this.feM.feH;
                                    aVar5.b(t.j.alert_no_button, new ci(this));
                                    aVar6 = this.feM.feH;
                                    aVar6.b(this.feM.getPageContext());
                                }
                                aVar2 = this.feM.feH;
                                aVar2.rV();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.feM.ben();
    }
}
