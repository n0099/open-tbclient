package com.baidu.tieba.write;

import android.app.AlertDialog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.editortool.h {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.a = writeActivity;
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
            this.a.a(2);
        } else if (i == 3) {
            this.a.j();
        } else if (i == 0) {
            this.a.i();
            AtListActivity.a(this.a, 12004);
        } else if (i == 8) {
            this.a.a(8);
        } else if (i == 9) {
            this.a.j();
        } else if (i == 4) {
            str = this.a.z;
            if (str != null) {
                str2 = this.a.z;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.a;
                    str3 = this.a.z;
                    writeActivity.showToast(str3);
                    writeEditorToolButtonContainer2 = this.a.A;
                    writeEditorToolButtonContainer2.setAudioFocusable(false);
                }
            }
        } else if (i == 5) {
            this.a.a(5);
        } else if (i == 6) {
            this.a.j();
        } else if (i == 7) {
            writeEditorToolButtonContainer = this.a.A;
            writeEditorToolButtonContainer.setImageFocusable(false);
            alertDialog = this.a.i;
            alertDialog.show();
        }
    }
}
