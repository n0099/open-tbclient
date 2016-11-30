package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gpZ = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bwN;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        rVar = this.gpZ.gpI;
        rVar.bwd();
        writeImagesInfo = this.gpZ.gpH;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.gpZ.gpH;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.gpZ.gpH;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.gpZ.gpH;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.gpZ.gpW;
                        if (i > 0) {
                            bwN = this.gpZ.bwN();
                            if (bwN) {
                                aVar = this.gpZ.gpU;
                                if (aVar == null) {
                                    this.gpZ.gpU = new com.baidu.tbadk.core.dialog.a(this.gpZ.getActivity());
                                    aVar3 = this.gpZ.gpU;
                                    aVar3.ca(r.j.orginal_conflict_tip);
                                    aVar4 = this.gpZ.gpU;
                                    aVar4.a(r.j.alert_yes_button, new ce(this));
                                    aVar5 = this.gpZ.gpU;
                                    aVar5.b(r.j.alert_no_button, new cf(this));
                                    aVar6 = this.gpZ.gpU;
                                    aVar6.b(this.gpZ.getPageContext());
                                }
                                aVar2 = this.gpZ.gpU;
                                aVar2.tq();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.gpZ.bwQ();
    }
}
