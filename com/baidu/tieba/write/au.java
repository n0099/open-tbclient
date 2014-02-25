package com.baidu.tieba.write;

import android.app.AlertDialog;
import com.baidu.tieba.album.AlbumActivity;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.tieba.editortool.z {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.z
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        WriteImagesInfo writeImagesInfo2;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer3;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo3;
        if (i == 23) {
            WriteActivity writeActivity = this.a;
            writeImagesInfo3 = this.a.D;
            AlbumActivity.a(writeActivity, writeImagesInfo3, 12002);
        } else if (i == 20) {
            if (obj instanceof com.baidu.tieba.editortool.w) {
                this.a.a((com.baidu.tieba.editortool.w) obj);
            }
        } else if (i == 21) {
            this.a.k();
        } else if (i == 14) {
            writeEditorToolButtonContainer4 = this.a.A;
            writeEditorToolButtonContainer4.i();
            this.a.t();
        } else if (i == 15) {
            writeEditorToolButtonContainer3 = this.a.A;
            writeEditorToolButtonContainer3.j();
            this.a.t();
        } else if (i == 13) {
            writeImagesInfo2 = this.a.D;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo2.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                writeEditorToolButtonContainer = this.a.A;
                writeEditorToolButtonContainer.h();
            } else {
                writeEditorToolButtonContainer2 = this.a.A;
                writeEditorToolButtonContainer2.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.a.t();
        } else if (i == 7) {
            alertDialog = this.a.k;
            if (alertDialog != null) {
                alertDialog2 = this.a.k;
                alertDialog2.show();
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            WriteActivity writeActivity2 = this.a;
            writeImagesInfo = this.a.D;
            WriteMultiImgsActivity.a(writeActivity2, 12012, writeImagesInfo, intValue);
        }
    }
}
