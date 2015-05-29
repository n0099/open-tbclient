package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.tbadkCore.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ap {
    final /* synthetic */ NewSubPbActivity bPw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.bPw = newSubPbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.ap
    public void a(WriteData writeData) {
        s sVar;
        s sVar2;
        String str;
        if (writeData != null) {
            this.bPw.bPp = writeData.getContent();
            sVar = this.bPw.bPq;
            if (sVar.ady() != null) {
                sVar2 = this.bPw.bPq;
                PbEditor ady = sVar2.ady();
                str = this.bPw.bPp;
                ady.setContent(str);
            }
        }
    }
}
