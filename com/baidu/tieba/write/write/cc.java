package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity ggd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.ggd = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean btO;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.ggd.gfM;
        rVar.btc();
        writeImagesInfo = this.ggd.gfL;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.ggd.gfL;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.ggd.gfL;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.ggd.gfL;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.ggd.gga;
                        if (i > 0) {
                            btO = this.ggd.btO();
                            if (btO) {
                                aVar = this.ggd.gfY;
                                if (aVar == null) {
                                    this.ggd.gfY = new com.baidu.tbadk.core.dialog.a(this.ggd.getActivity());
                                    aVar3 = this.ggd.gfY;
                                    aVar3.bZ(t.j.orginal_conflict_tip);
                                    aVar4 = this.ggd.gfY;
                                    aVar4.a(t.j.alert_yes_button, new cd(this));
                                    aVar5 = this.ggd.gfY;
                                    aVar5.b(t.j.alert_no_button, new ce(this));
                                    aVar6 = this.ggd.gfY;
                                    aVar6.b(this.ggd.getPageContext());
                                }
                                aVar2 = this.ggd.gfY;
                                aVar2.sX();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.ggd.btR();
    }
}
