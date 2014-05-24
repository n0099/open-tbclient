package com.baidu.tieba.write;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
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
        boolean v;
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
                    com.baidu.tbadk.core.atomData.a aVar = new com.baidu.tbadk.core.atomData.a(writeActivity, writeImagesInfo8.toJsonString());
                    aVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, aVar));
                }
            }
        } else if (i == 20) {
            v = this.a.v();
            if (v) {
                this.a.showToast(com.baidu.tieba.y.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.d) {
                this.a.a((com.baidu.tbadk.coreExtra.data.d) obj);
            }
        } else if (i == 21) {
            this.a.k();
        } else if (i == 14) {
            writeEditorToolButtonContainer6 = this.a.z;
            writeEditorToolButtonContainer6.i();
            this.a.z();
        } else if (i == 15) {
            writeEditorToolButtonContainer5 = this.a.z;
            writeEditorToolButtonContainer5.j();
            this.a.z();
        } else if (i == 13) {
            writeImagesInfo5 = this.a.C;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo5.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                writeEditorToolButtonContainer3 = this.a.z;
                writeEditorToolButtonContainer3.h();
            } else {
                writeEditorToolButtonContainer4 = this.a.z;
                writeEditorToolButtonContainer4.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.a.z();
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
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        WriteActivity writeActivity2 = this.a;
                        writeImagesInfo4 = this.a.C;
                        messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bk(writeActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            writeEditorToolButtonContainer2 = this.a.z;
            writeEditorToolButtonContainer2.k();
            if (obj instanceof String) {
                this.a.l = (String) obj;
                this.a.u();
            }
        } else if (i == 47) {
            writeEditorToolButtonContainer = this.a.z;
            writeEditorToolButtonContainer.l();
            this.a.l = null;
            this.a.u();
        }
    }
}
