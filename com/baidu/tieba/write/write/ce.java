package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity fTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.fTB = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean boL;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.fTB.fTk;
        qVar.bnY();
        writeImagesInfo = this.fTB.fTj;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.fTB.fTj;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.fTB.fTj;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.fTB.fTj;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.fTB.fTy;
                        if (i > 0) {
                            boL = this.fTB.boL();
                            if (boL) {
                                aVar = this.fTB.fTw;
                                if (aVar == null) {
                                    this.fTB.fTw = new com.baidu.tbadk.core.dialog.a(this.fTB.getActivity());
                                    aVar3 = this.fTB.fTw;
                                    aVar3.bX(w.l.orginal_conflict_tip);
                                    aVar4 = this.fTB.fTw;
                                    aVar4.a(w.l.alert_yes_button, new cf(this));
                                    aVar5 = this.fTB.fTw;
                                    aVar5.b(w.l.alert_no_button, new cg(this));
                                    aVar6 = this.fTB.fTw;
                                    aVar6.b(this.fTB.getPageContext());
                                }
                                aVar2 = this.fTB.fTw;
                                aVar2.td();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.fTB.boO();
    }
}
