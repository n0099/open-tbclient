package com.baidu.tieba.write;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class ap implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        WriteImagesInfo writeImagesInfo5;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer3;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer4;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer5;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer6;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        if (i == 23) {
            writeImagesInfo6 = this.a.C;
            if (writeImagesInfo6 != null) {
                writeImagesInfo7 = this.a.C;
                if (!TextUtils.isEmpty(writeImagesInfo7.toJsonString())) {
                    WriteActivity writeActivity = this.a;
                    writeImagesInfo8 = this.a.C;
                    com.baidu.tbadk.core.b.a aVar = new com.baidu.tbadk.core.b.a(writeActivity, writeImagesInfo8.toJsonString());
                    aVar.a(12002);
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, aVar));
                }
            }
        } else if (i == 20) {
            if (WriteActivity.t(this.a)) {
                this.a.showToast(com.baidu.tieba.a.k.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.d) {
                this.a.a((com.baidu.tbadk.coreExtra.data.d) obj);
            }
        } else if (i == 21) {
            this.a.b();
        } else if (i == 14) {
            writeEditorToolButtonContainer6 = this.a.z;
            writeEditorToolButtonContainer6.h();
            this.a.j();
        } else if (i == 15) {
            writeEditorToolButtonContainer5 = this.a.z;
            writeEditorToolButtonContainer5.i();
            this.a.j();
        } else if (i == 13) {
            writeImagesInfo5 = this.a.C;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo5.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                writeEditorToolButtonContainer3 = this.a.z;
                writeEditorToolButtonContainer3.g();
            } else {
                writeEditorToolButtonContainer4 = this.a.z;
                writeEditorToolButtonContainer4.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.a.j();
        } else if (i == 7) {
            alertDialog = this.a.i;
            if (alertDialog != null) {
                alertDialog2 = this.a.i;
                alertDialog2.show();
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.a.C;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.C;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.a.C;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size > 0 && intValue >= 0 && intValue < size) {
                        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
                        WriteActivity writeActivity2 = this.a;
                        writeImagesInfo4 = this.a.C;
                        a.a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ax(writeActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            writeEditorToolButtonContainer2 = this.a.z;
            writeEditorToolButtonContainer2.j();
            if (obj instanceof String) {
                this.a.l = (String) obj;
                this.a.h();
            }
        } else if (i == 47) {
            writeEditorToolButtonContainer = this.a.z;
            writeEditorToolButtonContainer.k();
            this.a.l = null;
            this.a.h();
        }
    }
}
