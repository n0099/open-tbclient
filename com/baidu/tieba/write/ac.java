package com.baidu.tieba.write;

import android.app.AlertDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.editortool.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.f2676a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.h
    public void a(int i, Object obj) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        AlertDialog alertDialog;
        String str;
        String str2;
        String str3;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        if (i == 2) {
            this.f2676a.a(2);
        } else if (i == 3) {
            this.f2676a.j();
        } else if (i == 0) {
            this.f2676a.i();
            AtListActivity.a(this.f2676a, 12004);
        } else if (i == 8) {
            this.f2676a.a(8);
        } else if (i == 9) {
            this.f2676a.j();
        } else if (i == 4) {
            str = this.f2676a.z;
            if (str != null) {
                str2 = this.f2676a.z;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.f2676a;
                    str3 = this.f2676a.z;
                    writeActivity.showToast(str3);
                    writeEditorToolButtonContainer2 = this.f2676a.A;
                    writeEditorToolButtonContainer2.setAudioFocusable(false);
                }
            }
        } else if (i == 5) {
            this.f2676a.a(5);
        } else if (i == 6) {
            this.f2676a.j();
        } else if (i == 7) {
            writeEditorToolButtonContainer = this.f2676a.A;
            writeEditorToolButtonContainer.setImageFocusable(false);
            alertDialog = this.f2676a.i;
            alertDialog.show();
        }
    }
}
