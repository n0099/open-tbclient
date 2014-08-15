package com.baidu.tieba.write;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.cg;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        WriteImagesInfo writeImagesInfo5;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer3;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo6;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer5;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer6;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer7;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer8;
        boolean v;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        if (i == 23) {
            writeImagesInfo7 = this.a.D;
            if (writeImagesInfo7 != null) {
                writeImagesInfo8 = this.a.D;
                if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                    WriteActivity writeActivity = this.a;
                    writeImagesInfo9 = this.a.D;
                    com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(writeActivity, writeImagesInfo9.toJsonString());
                    bVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                }
            }
        } else if (i == 20) {
            v = this.a.v();
            if (v) {
                this.a.showToast(com.baidu.tieba.x.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.d) {
                this.a.a((com.baidu.tbadk.coreExtra.data.d) obj);
            }
        } else if (i == 21) {
            this.a.l();
        } else if (i == 14) {
            writeEditorToolButtonContainer8 = this.a.B;
            writeEditorToolButtonContainer8.o();
            this.a.z();
        } else if (i == 15) {
            writeEditorToolButtonContainer7 = this.a.B;
            writeEditorToolButtonContainer7.p();
            this.a.z();
        } else if (i == 13) {
            writeImagesInfo6 = this.a.D;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo6.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                writeEditorToolButtonContainer5 = this.a.B;
                writeEditorToolButtonContainer5.n();
            } else {
                writeEditorToolButtonContainer6 = this.a.B;
                writeEditorToolButtonContainer6.a(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.a.z();
        } else if (i == 51) {
            writeImagesInfo5 = this.a.E;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo5.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                writeEditorToolButtonContainer3 = this.a.B;
                writeEditorToolButtonContainer3.s();
            } else {
                writeEditorToolButtonContainer4 = this.a.B;
                writeEditorToolButtonContainer4.b(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            }
            this.a.z();
        } else if (i == 7) {
            alertDialog = this.a.j;
            if (alertDialog == null) {
                this.a.b();
            }
            alertDialog2 = this.a.j;
            if (alertDialog2 != null) {
                alertDialog3 = this.a.j;
                com.baidu.adp.lib.e.d.a(alertDialog3, this.a);
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.a.D;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.D;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.a.D;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        WriteActivity writeActivity2 = this.a;
                        writeImagesInfo4 = this.a.D;
                        messageManager.sendMessage(new CustomMessage(2002001, new cg(writeActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            writeEditorToolButtonContainer2 = this.a.B;
            writeEditorToolButtonContainer2.q();
            if (obj instanceof String) {
                this.a.m = (String) obj;
                this.a.a(true);
            }
        } else if (i == 47) {
            writeEditorToolButtonContainer = this.a.B;
            writeEditorToolButtonContainer.r();
            this.a.m = null;
            this.a.a(true);
        } else if (i != 48) {
        } else {
            this.a.d(i);
        }
    }
}
