package com.baidu.tieba.write;

import android.app.Activity;
import android.app.AlertDialog;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.tbadkCore.PbEditor.TbEditorToolButtonContainer;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.cft = writeActivity;
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
        String str;
        TbEditorToolButtonContainer tbEditorToolButtonContainer13;
        String str2;
        String str3;
        boolean Fl;
        TbEditorToolButtonContainer tbEditorToolButtonContainer14;
        if (i == 23) {
            tbEditorToolButtonContainer14 = this.cft.cfb;
            tbEditorToolButtonContainer14.agf();
            this.cft.io(8);
        } else if (i == 20) {
            Fl = this.cft.Fl();
            if (Fl) {
                this.cft.showToast(com.baidu.tieba.z.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cft.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cft.akj();
        } else if (i == 4) {
            str = this.cft.byI;
            if (str != null) {
                str2 = this.cft.byI;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cft;
                    str3 = this.cft.byI;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer13 = this.cft.cfb;
            tbEditorToolButtonContainer13.agf();
            this.cft.io(5);
        } else if (i == 14) {
            editorToolComponetContainer10 = this.cft.bUs;
            editorToolComponetContainer10.vo();
            z = this.cft.cfc;
            if (!z) {
                tbEditorToolButtonContainer12 = this.cft.cfb;
                tbEditorToolButtonContainer12.afN();
            }
            this.cft.acG();
        } else if (i == 15) {
            editorToolComponetContainer5 = this.cft.bUs;
            editorToolComponetContainer5.vp();
            tbEditorToolButtonContainer8 = this.cft.cfb;
            tbEditorToolButtonContainer8.afO();
            writeImagesInfo7 = this.cft.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo7.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cft.cfb;
                tbEditorToolButtonContainer9.vg();
                this.cft.cfc = false;
                editorToolComponetContainer6 = this.cft.bUs;
                editorToolComponetContainer6.vg();
                editorToolComponetContainer7 = this.cft.bUs;
                if (editorToolComponetContainer7.afu()) {
                    tbEditorToolButtonContainer10 = this.cft.cfb;
                    tbEditorToolButtonContainer10.afN();
                    editorToolComponetContainer8 = this.cft.bUs;
                    editorToolComponetContainer8.vo();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cft.cfb;
                tbEditorToolButtonContainer11.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.cft.cfc = true;
                editorToolComponetContainer9 = this.cft.bUs;
                editorToolComponetContainer9.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cft.acG();
        } else if (i == 13) {
            writeImagesInfo6 = this.cft.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo6.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cft.cfb;
                tbEditorToolButtonContainer5.vg();
                this.cft.cfc = false;
                editorToolComponetContainer = this.cft.bUs;
                editorToolComponetContainer.vp();
                editorToolComponetContainer2 = this.cft.bUs;
                if (editorToolComponetContainer2.afu()) {
                    tbEditorToolButtonContainer6 = this.cft.cfb;
                    tbEditorToolButtonContainer6.afN();
                    editorToolComponetContainer3 = this.cft.bUs;
                    editorToolComponetContainer3.vo();
                }
            } else {
                tbEditorToolButtonContainer7 = this.cft.cfb;
                tbEditorToolButtonContainer7.ee(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.cft.cfc = true;
                editorToolComponetContainer4 = this.cft.bUs;
                editorToolComponetContainer4.ee(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cft.acG();
        } else if (i == 51) {
            writeImagesInfo5 = this.cft.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo5.getChosedFiles();
            if (chosedFiles3 == null || chosedFiles3.size() <= 0) {
                tbEditorToolButtonContainer3 = this.cft.cfb;
                tbEditorToolButtonContainer3.vn();
            } else {
                tbEditorToolButtonContainer4 = this.cft.cfb;
                tbEditorToolButtonContainer4.eg("1");
            }
            this.cft.acG();
        } else if (i == 7) {
            alertDialog = this.cft.aAR;
            if (alertDialog == null) {
                this.cft.EU();
            }
            alertDialog2 = this.cft.aAR;
            if (alertDialog2 != null) {
                alertDialog3 = this.cft.aAR;
                com.baidu.adp.lib.g.k.a(alertDialog3, this.cft.getPageContext());
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.cft.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.cft.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.cft.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity = this.cft.getPageContext().getPageActivity();
                        writeImagesInfo4 = this.cft.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            tbEditorToolButtonContainer2 = this.cft.cfb;
            tbEditorToolButtonContainer2.vi();
            if (obj instanceof String) {
                this.cft.bTi = (String) obj;
                this.cft.eL(true);
            }
        } else if (i == 47) {
            tbEditorToolButtonContainer = this.cft.cfb;
            tbEditorToolButtonContainer.vj();
            this.cft.bTi = null;
            this.cft.eL(true);
        } else if (i != 48) {
        } else {
            this.cft.iq(i);
        }
    }
}
