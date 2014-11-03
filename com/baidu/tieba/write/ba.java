package com.baidu.tieba.write;

import android.app.AlertDialog;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.editortool.TbEditorToolButtonContainer;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        WriteImagesInfo writeImagesInfo5;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo6;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        EditorToolComponetContainer editorToolComponetContainer4;
        EditorToolComponetContainer editorToolComponetContainer5;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        WriteImagesInfo writeImagesInfo7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer9;
        EditorToolComponetContainer editorToolComponetContainer6;
        EditorToolComponetContainer editorToolComponetContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer10;
        EditorToolComponetContainer editorToolComponetContainer8;
        TbEditorToolButtonContainer tbEditorToolButtonContainer11;
        EditorToolComponetContainer editorToolComponetContainer9;
        EditorToolComponetContainer editorToolComponetContainer10;
        boolean z;
        TbEditorToolButtonContainer tbEditorToolButtonContainer12;
        TbEditorToolButtonContainer tbEditorToolButtonContainer13;
        boolean Cj;
        TbEditorToolButtonContainer tbEditorToolButtonContainer14;
        if (i == 23) {
            tbEditorToolButtonContainer14 = this.bUm.bTU;
            tbEditorToolButtonContainer14.CG();
            this.bUm.hG(8);
        } else if (i == 20) {
            Cj = this.bUm.Cj();
            if (Cj) {
                this.bUm.showToast(com.baidu.tieba.y.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.d) {
                this.bUm.b((com.baidu.tbadk.coreExtra.data.d) obj);
            }
        } else if (i == 21) {
            this.bUm.afF();
        } else if (i == 4) {
            tbEditorToolButtonContainer13 = this.bUm.bTU;
            tbEditorToolButtonContainer13.CG();
            this.bUm.hG(5);
        } else if (i == 14) {
            editorToolComponetContainer10 = this.bUm.arn;
            editorToolComponetContainer10.rN();
            z = this.bUm.bTV;
            if (!z) {
                tbEditorToolButtonContainer12 = this.bUm.bTU;
                tbEditorToolButtonContainer12.Cn();
            }
            this.bUm.acl();
        } else if (i == 15) {
            editorToolComponetContainer5 = this.bUm.arn;
            editorToolComponetContainer5.rO();
            tbEditorToolButtonContainer8 = this.bUm.bTU;
            tbEditorToolButtonContainer8.Co();
            writeImagesInfo7 = this.bUm.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo7.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.bUm.bTU;
                tbEditorToolButtonContainer9.rF();
                this.bUm.bTV = false;
                editorToolComponetContainer6 = this.bUm.arn;
                editorToolComponetContainer6.rF();
                editorToolComponetContainer7 = this.bUm.arn;
                if (editorToolComponetContainer7.BP()) {
                    tbEditorToolButtonContainer10 = this.bUm.bTU;
                    tbEditorToolButtonContainer10.Cn();
                    editorToolComponetContainer8 = this.bUm.arn;
                    editorToolComponetContainer8.rN();
                }
            } else {
                tbEditorToolButtonContainer11 = this.bUm.bTU;
                tbEditorToolButtonContainer11.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.bUm.bTV = true;
                editorToolComponetContainer9 = this.bUm.arn;
                editorToolComponetContainer9.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.bUm.acl();
        } else if (i == 13) {
            writeImagesInfo6 = this.bUm.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo6.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.bUm.bTU;
                tbEditorToolButtonContainer5.rF();
                this.bUm.bTV = false;
                editorToolComponetContainer = this.bUm.arn;
                editorToolComponetContainer.rO();
                editorToolComponetContainer2 = this.bUm.arn;
                if (editorToolComponetContainer2.BP()) {
                    tbEditorToolButtonContainer6 = this.bUm.bTU;
                    tbEditorToolButtonContainer6.Cn();
                    editorToolComponetContainer3 = this.bUm.arn;
                    editorToolComponetContainer3.rN();
                }
            } else {
                tbEditorToolButtonContainer7 = this.bUm.bTU;
                tbEditorToolButtonContainer7.di(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.bUm.bTV = true;
                editorToolComponetContainer4 = this.bUm.arn;
                editorToolComponetContainer4.di(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.bUm.acl();
        } else if (i == 51) {
            writeImagesInfo5 = this.bUm.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo5.getChosedFiles();
            if (chosedFiles3 == null || chosedFiles3.size() <= 0) {
                tbEditorToolButtonContainer3 = this.bUm.bTU;
                tbEditorToolButtonContainer3.rM();
            } else {
                tbEditorToolButtonContainer4 = this.bUm.bTU;
                tbEditorToolButtonContainer4.dk("1");
            }
            this.bUm.acl();
        } else if (i == 7) {
            alertDialog = this.bUm.ayP;
            if (alertDialog == null) {
                this.bUm.ED();
            }
            alertDialog2 = this.bUm.ayP;
            if (alertDialog2 != null) {
                alertDialog3 = this.bUm.ayP;
                com.baidu.adp.lib.g.j.a(alertDialog3, this.bUm);
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.bUm.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bUm.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.bUm.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        WriteActivity writeActivity = this.bUm;
                        writeImagesInfo4 = this.bUm.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(writeActivity, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            tbEditorToolButtonContainer2 = this.bUm.bTU;
            tbEditorToolButtonContainer2.rH();
            if (obj instanceof String) {
                this.bUm.aqi = (String) obj;
                this.bUm.eM(true);
            }
        } else if (i == 47) {
            tbEditorToolButtonContainer = this.bUm.bTU;
            tbEditorToolButtonContainer.rI();
            this.bUm.aqi = null;
            this.bUm.eM(true);
        } else if (i != 48) {
        } else {
            this.bUm.hI(i);
        }
    }
}
