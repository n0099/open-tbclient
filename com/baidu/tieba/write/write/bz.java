package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity etW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.etW = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean aVl;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.etW.etG;
        qVar.aUA();
        writeImagesInfo = this.etW.etE;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.etW.etE;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.etW.etE;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.etW.etE;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.etW.etU;
                        if (i > 0) {
                            aVl = this.etW.aVl();
                            if (aVl) {
                                aVar = this.etW.etS;
                                if (aVar == null) {
                                    this.etW.etS = new com.baidu.tbadk.core.dialog.a(this.etW.getActivity());
                                    aVar3 = this.etW.etS;
                                    aVar3.bY(t.j.orginal_conflict_tip);
                                    aVar4 = this.etW.etS;
                                    aVar4.a(t.j.alert_yes_button, new ca(this));
                                    aVar5 = this.etW.etS;
                                    aVar5.b(t.j.alert_no_button, new cb(this));
                                    aVar6 = this.etW.etS;
                                    aVar6.b(this.etW.getPageContext());
                                }
                                aVar2 = this.etW.etS;
                                aVar2.uj();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.etW.aVo();
    }
}
