package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gio = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean buu;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.gio.ghW;
        rVar.btI();
        writeImagesInfo = this.gio.ghV;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.gio.ghV;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.gio.ghV;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.gio.ghV;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.gio.gil;
                        if (i > 0) {
                            buu = this.gio.buu();
                            if (buu) {
                                aVar = this.gio.gij;
                                if (aVar == null) {
                                    this.gio.gij = new com.baidu.tbadk.core.dialog.a(this.gio.getActivity());
                                    aVar3 = this.gio.gij;
                                    aVar3.bZ(r.j.orginal_conflict_tip);
                                    aVar4 = this.gio.gij;
                                    aVar4.a(r.j.alert_yes_button, new cd(this));
                                    aVar5 = this.gio.gij;
                                    aVar5.b(r.j.alert_no_button, new ce(this));
                                    aVar6 = this.gio.gij;
                                    aVar6.b(this.gio.getPageContext());
                                }
                                aVar2 = this.gio.gij;
                                aVar2.tm();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.gio.bux();
    }
}
