package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ap {
    final /* synthetic */ NewSubPbActivity bPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.bPx = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        s sVar;
        s sVar2;
        String str;
        if (writeData != null) {
            this.bPx.bPq = writeData.getContent();
            sVar = this.bPx.bPr;
            if (sVar.adz() != null) {
                sVar2 = this.bPx.bPr;
                PbEditor adz = sVar2.adz();
                str = this.bPx.bPq;
                adz.setContent(str);
            }
        }
    }
}
