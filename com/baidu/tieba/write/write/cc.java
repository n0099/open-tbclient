package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gmv = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean buJ;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.gmv.gme;
        qVar.btV();
        writeImagesInfo = this.gmv.gmd;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.gmv.gmd;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.gmv.gmd;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.gmv.gmd;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.gmv.gms;
                        if (i > 0) {
                            buJ = this.gmv.buJ();
                            if (buJ) {
                                aVar = this.gmv.gmq;
                                if (aVar == null) {
                                    this.gmv.gmq = new com.baidu.tbadk.core.dialog.a(this.gmv.getActivity());
                                    aVar3 = this.gmv.gmq;
                                    aVar3.bY(w.l.orginal_conflict_tip);
                                    aVar4 = this.gmv.gmq;
                                    aVar4.a(w.l.alert_yes_button, new cd(this));
                                    aVar5 = this.gmv.gmq;
                                    aVar5.b(w.l.alert_no_button, new ce(this));
                                    aVar6 = this.gmv.gmq;
                                    aVar6.b(this.gmv.getPageContext());
                                }
                                aVar2 = this.gmv.gmq;
                                aVar2.ta();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.gmv.buM();
    }
}
