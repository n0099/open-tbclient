package com.baidu.tieba.write;

import android.app.Activity;
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
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        EditorToolComponetContainer editorToolComponetContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        boolean akH;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo6;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        boolean akH2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer4;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        boolean akH3;
        WriteImagesInfo writeImagesInfo7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer9;
        EditorToolComponetContainer editorToolComponetContainer7;
        EditorToolComponetContainer editorToolComponetContainer8;
        EditorToolComponetContainer editorToolComponetContainer9;
        TbEditorToolButtonContainer tbEditorToolButtonContainer10;
        TbEditorToolButtonContainer tbEditorToolButtonContainer11;
        EditorToolComponetContainer editorToolComponetContainer10;
        TbEditorToolButtonContainer tbEditorToolButtonContainer12;
        EditorToolComponetContainer editorToolComponetContainer11;
        TbEditorToolButtonContainer tbEditorToolButtonContainer13;
        String str;
        TbEditorToolButtonContainer tbEditorToolButtonContainer14;
        String str2;
        String str3;
        boolean FD;
        TbEditorToolButtonContainer tbEditorToolButtonContainer15;
        if (i == 23) {
            tbEditorToolButtonContainer15 = this.cgR.cgz;
            tbEditorToolButtonContainer15.agF();
            this.cgR.it(8);
        } else if (i == 20) {
            FD = this.cgR.FD();
            if (FD) {
                this.cgR.showToast(com.baidu.tieba.z.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cgR.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cgR.akC();
        } else if (i == 4) {
            str = this.cgR.bAq;
            if (str != null) {
                str2 = this.cgR.bAq;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cgR;
                    str3 = this.cgR.bAq;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer14 = this.cgR.cgz;
            tbEditorToolButtonContainer14.agF();
            this.cgR.it(5);
        } else if (i == 14) {
            editorToolComponetContainer11 = this.cgR.bWj;
            editorToolComponetContainer11.vz();
            tbEditorToolButtonContainer13 = this.cgR.cgz;
            tbEditorToolButtonContainer13.ago();
            this.cgR.adf();
        } else if (i == 15) {
            editorToolComponetContainer6 = this.cgR.bWj;
            editorToolComponetContainer6.vA();
            akH3 = this.cgR.akH();
            if (akH3) {
                tbEditorToolButtonContainer12 = this.cgR.cgz;
                tbEditorToolButtonContainer12.agp();
            }
            writeImagesInfo7 = this.cgR.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo7.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cgR.cgz;
                tbEditorToolButtonContainer9.vr();
                editorToolComponetContainer7 = this.cgR.bWj;
                editorToolComponetContainer7.vr();
                editorToolComponetContainer8 = this.cgR.bWj;
                if (editorToolComponetContainer8.afT()) {
                    editorToolComponetContainer9 = this.cgR.bWj;
                    editorToolComponetContainer9.vz();
                    tbEditorToolButtonContainer10 = this.cgR.cgz;
                    tbEditorToolButtonContainer10.ago();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cgR.cgz;
                tbEditorToolButtonContainer11.eb(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                editorToolComponetContainer10 = this.cgR.bWj;
                editorToolComponetContainer10.eb(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cgR.adf();
        } else if (i == 13) {
            writeImagesInfo6 = this.cgR.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo6.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cgR.cgz;
                tbEditorToolButtonContainer5.vr();
                editorToolComponetContainer2 = this.cgR.bWj;
                editorToolComponetContainer2.vA();
                editorToolComponetContainer3 = this.cgR.bWj;
                if (editorToolComponetContainer3.afT()) {
                    editorToolComponetContainer4 = this.cgR.bWj;
                    editorToolComponetContainer4.vz();
                    tbEditorToolButtonContainer7 = this.cgR.cgz;
                    tbEditorToolButtonContainer7.ago();
                } else {
                    akH2 = this.cgR.akH();
                    if (akH2) {
                        tbEditorToolButtonContainer6 = this.cgR.cgz;
                        tbEditorToolButtonContainer6.agp();
                    }
                }
            } else {
                tbEditorToolButtonContainer8 = this.cgR.cgz;
                tbEditorToolButtonContainer8.eb(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                editorToolComponetContainer5 = this.cgR.bWj;
                editorToolComponetContainer5.eb(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cgR.adf();
        } else if (i == 51) {
            writeImagesInfo5 = this.cgR.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo5.getChosedFiles();
            if (chosedFiles3 != null && chosedFiles3.size() > 0) {
                tbEditorToolButtonContainer4 = this.cgR.cgz;
                tbEditorToolButtonContainer4.ago();
            } else {
                akH = this.cgR.akH();
                if (akH) {
                    tbEditorToolButtonContainer3 = this.cgR.cgz;
                    tbEditorToolButtonContainer3.agp();
                }
            }
            this.cgR.adf();
        } else if (i != 7) {
            if (i == 42) {
                int intValue = ((Integer) obj).intValue();
                writeImagesInfo = this.cgR.writeImagesInfo;
                if (writeImagesInfo != null) {
                    writeImagesInfo2 = this.cgR.writeImagesInfo;
                    if (writeImagesInfo2.getChosedFiles() != null) {
                        writeImagesInfo3 = this.cgR.writeImagesInfo;
                        int size = writeImagesInfo3.getChosedFiles().size();
                        if (size >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager messageManager = MessageManager.getInstance();
                            Activity pageActivity = this.cgR.getPageContext().getPageActivity();
                            writeImagesInfo4 = this.cgR.writeImagesInfo;
                            messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity, 12012, writeImagesInfo4, intValue)));
                        }
                    }
                }
            } else if (i == 46) {
                if (obj instanceof String) {
                    this.cgR.bVa = (String) obj;
                    this.cgR.eQ(true);
                }
                tbEditorToolButtonContainer2 = this.cgR.cgz;
                tbEditorToolButtonContainer2.vt();
            } else if (i == 47) {
                this.cgR.bVa = null;
                this.cgR.eQ(true);
            } else if (i != 48) {
                if (i != 55) {
                    if (i == 44 || i == 43) {
                        editorToolComponetContainer = this.cgR.bWj;
                        editorToolComponetContainer.afP();
                        tbEditorToolButtonContainer = this.cgR.cgz;
                        tbEditorToolButtonContainer.agB();
                    } else if (i == 57) {
                        this.cgR.it(57);
                    }
                }
            } else {
                this.cgR.iv(i);
            }
        } else {
            this.cgR.akG();
        }
    }
}
