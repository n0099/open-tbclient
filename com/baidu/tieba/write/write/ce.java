package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    final /* synthetic */ WriteMultiImgsActivity gbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(WriteMultiImgsActivity writeMultiImgsActivity) {
        this.gbx = writeMultiImgsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        int i;
        boolean bqk;
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        com.baidu.tbadk.core.dialog.a aVar4;
        com.baidu.tbadk.core.dialog.a aVar5;
        com.baidu.tbadk.core.dialog.a aVar6;
        qVar = this.gbx.gbg;
        qVar.bpx();
        writeImagesInfo = this.gbx.gbf;
        if (writeImagesInfo != null) {
            writeImagesInfo2 = this.gbx.gbf;
            if (writeImagesInfo2.getChosedFiles() != null) {
                writeImagesInfo3 = this.gbx.gbf;
                if (writeImagesInfo3.getChosedFiles().size() > 0) {
                    writeImagesInfo4 = this.gbx.gbf;
                    if (writeImagesInfo4.isOriginalImg()) {
                        i = this.gbx.gbu;
                        if (i > 0) {
                            bqk = this.gbx.bqk();
                            if (bqk) {
                                aVar = this.gbx.gbs;
                                if (aVar == null) {
                                    this.gbx.gbs = new com.baidu.tbadk.core.dialog.a(this.gbx.getActivity());
                                    aVar3 = this.gbx.gbs;
                                    aVar3.bY(w.l.orginal_conflict_tip);
                                    aVar4 = this.gbx.gbs;
                                    aVar4.a(w.l.alert_yes_button, new cf(this));
                                    aVar5 = this.gbx.gbs;
                                    aVar5.b(w.l.alert_no_button, new cg(this));
                                    aVar6 = this.gbx.gbs;
                                    aVar6.b(this.gbx.getPageContext());
                                }
                                aVar2 = this.gbx.gbs;
                                aVar2.tc();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.gbx.bqn();
    }
}
