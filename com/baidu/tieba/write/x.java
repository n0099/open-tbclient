package com.baidu.tieba.write;

import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2723a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(WriteActivity writeActivity) {
        this.f2723a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        WriteData writeData;
        WriteData writeData2;
        if (i == 22) {
            bc.a(this.f2723a);
            writeData2 = this.f2723a.b;
            writeData2.setPicType(2);
        } else if (i == 23) {
            bc.c(this.f2723a);
            writeData = this.f2723a.b;
            writeData.setPicType(1);
        } else if (i == 20) {
            if (obj instanceof com.baidu.tieba.editortool.g) {
                this.f2723a.a((com.baidu.tieba.editortool.g) obj);
            }
        } else if (i == 21) {
            this.f2723a.l();
        } else if (i == 14) {
            writeEditorToolButtonContainer2 = this.f2723a.A;
            writeEditorToolButtonContainer2.j();
            this.f2723a.t();
        } else if (i == 15) {
            writeEditorToolButtonContainer = this.f2723a.A;
            writeEditorToolButtonContainer.k();
            this.f2723a.t();
        }
    }
}
