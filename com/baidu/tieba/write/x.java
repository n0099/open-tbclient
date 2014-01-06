package com.baidu.tieba.write;

import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.editortool.t {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.t
    public void a(int i, Object obj) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        WriteData writeData;
        WriteData writeData2;
        if (i == 22) {
            bb.a(this.a);
            writeData2 = this.a.b;
            writeData2.setPicType(2);
        } else if (i == 23) {
            bb.c(this.a);
            writeData = this.a.b;
            writeData.setPicType(1);
        } else if (i == 20) {
            if (obj instanceof com.baidu.tieba.editortool.q) {
                this.a.a((com.baidu.tieba.editortool.q) obj);
            }
        } else if (i == 21) {
            this.a.l();
        } else if (i == 14) {
            writeEditorToolButtonContainer2 = this.a.A;
            writeEditorToolButtonContainer2.f();
            this.a.t();
        } else if (i == 15) {
            writeEditorToolButtonContainer = this.a.A;
            writeEditorToolButtonContainer.g();
            this.a.t();
        }
    }
}
