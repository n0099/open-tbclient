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
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.bTX = writeActivity;
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
        boolean Ch;
        TbEditorToolButtonContainer tbEditorToolButtonContainer14;
        if (i == 23) {
            tbEditorToolButtonContainer14 = this.bTX.bTF;
            tbEditorToolButtonContainer14.CE();
            this.bTX.hG(8);
        } else if (i == 20) {
            Ch = this.bTX.Ch();
            if (Ch) {
                this.bTX.showToast(com.baidu.tieba.y.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.d) {
                this.bTX.b((com.baidu.tbadk.coreExtra.data.d) obj);
            }
        } else if (i == 21) {
            this.bTX.afC();
        } else if (i == 4) {
            tbEditorToolButtonContainer13 = this.bTX.bTF;
            tbEditorToolButtonContainer13.CE();
            this.bTX.hG(5);
        } else if (i == 14) {
            editorToolComponetContainer10 = this.bTX.are;
            editorToolComponetContainer10.rL();
            z = this.bTX.bTG;
            if (!z) {
                tbEditorToolButtonContainer12 = this.bTX.bTF;
                tbEditorToolButtonContainer12.Cl();
            }
            this.bTX.aci();
        } else if (i == 15) {
            editorToolComponetContainer5 = this.bTX.are;
            editorToolComponetContainer5.rM();
            tbEditorToolButtonContainer8 = this.bTX.bTF;
            tbEditorToolButtonContainer8.Cm();
            writeImagesInfo7 = this.bTX.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo7.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.bTX.bTF;
                tbEditorToolButtonContainer9.rD();
                this.bTX.bTG = false;
                editorToolComponetContainer6 = this.bTX.are;
                editorToolComponetContainer6.rD();
                editorToolComponetContainer7 = this.bTX.are;
                if (editorToolComponetContainer7.BN()) {
                    tbEditorToolButtonContainer10 = this.bTX.bTF;
                    tbEditorToolButtonContainer10.Cl();
                    editorToolComponetContainer8 = this.bTX.are;
                    editorToolComponetContainer8.rL();
                }
            } else {
                tbEditorToolButtonContainer11 = this.bTX.bTF;
                tbEditorToolButtonContainer11.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.bTX.bTG = true;
                editorToolComponetContainer9 = this.bTX.are;
                editorToolComponetContainer9.di(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.bTX.aci();
        } else if (i == 13) {
            writeImagesInfo6 = this.bTX.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo6.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.bTX.bTF;
                tbEditorToolButtonContainer5.rD();
                this.bTX.bTG = false;
                editorToolComponetContainer = this.bTX.are;
                editorToolComponetContainer.rM();
                editorToolComponetContainer2 = this.bTX.are;
                if (editorToolComponetContainer2.BN()) {
                    tbEditorToolButtonContainer6 = this.bTX.bTF;
                    tbEditorToolButtonContainer6.Cl();
                    editorToolComponetContainer3 = this.bTX.are;
                    editorToolComponetContainer3.rL();
                }
            } else {
                tbEditorToolButtonContainer7 = this.bTX.bTF;
                tbEditorToolButtonContainer7.di(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.bTX.bTG = true;
                editorToolComponetContainer4 = this.bTX.are;
                editorToolComponetContainer4.di(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.bTX.aci();
        } else if (i == 51) {
            writeImagesInfo5 = this.bTX.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo5.getChosedFiles();
            if (chosedFiles3 == null || chosedFiles3.size() <= 0) {
                tbEditorToolButtonContainer3 = this.bTX.bTF;
                tbEditorToolButtonContainer3.rK();
            } else {
                tbEditorToolButtonContainer4 = this.bTX.bTF;
                tbEditorToolButtonContainer4.dk("1");
            }
            this.bTX.aci();
        } else if (i == 7) {
            alertDialog = this.bTX.ayG;
            if (alertDialog == null) {
                this.bTX.EB();
            }
            alertDialog2 = this.bTX.ayG;
            if (alertDialog2 != null) {
                alertDialog3 = this.bTX.ayG;
                com.baidu.adp.lib.g.j.a(alertDialog3, this.bTX);
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.bTX.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bTX.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.bTX.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        WriteActivity writeActivity = this.bTX;
                        writeImagesInfo4 = this.bTX.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(writeActivity, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            tbEditorToolButtonContainer2 = this.bTX.bTF;
            tbEditorToolButtonContainer2.rF();
            if (obj instanceof String) {
                this.bTX.apZ = (String) obj;
                this.bTX.eM(true);
            }
        } else if (i == 47) {
            tbEditorToolButtonContainer = this.bTX.bTF;
            tbEditorToolButtonContainer.rG();
            this.bTX.apZ = null;
            this.bTX.eM(true);
        } else if (i != 48) {
        } else {
            this.bTX.hI(i);
        }
    }
}
