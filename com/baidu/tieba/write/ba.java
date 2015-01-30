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
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.cgS = writeActivity;
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
        boolean akM;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo6;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        boolean akM2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer4;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        boolean akM3;
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
        boolean FJ;
        TbEditorToolButtonContainer tbEditorToolButtonContainer15;
        if (i == 23) {
            tbEditorToolButtonContainer15 = this.cgS.cgA;
            tbEditorToolButtonContainer15.agK();
            this.cgS.it(8);
        } else if (i == 20) {
            FJ = this.cgS.FJ();
            if (FJ) {
                this.cgS.showToast(com.baidu.tieba.z.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cgS.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cgS.akH();
        } else if (i == 4) {
            str = this.cgS.bAr;
            if (str != null) {
                str2 = this.cgS.bAr;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cgS;
                    str3 = this.cgS.bAr;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer14 = this.cgS.cgA;
            tbEditorToolButtonContainer14.agK();
            this.cgS.it(5);
        } else if (i == 14) {
            editorToolComponetContainer11 = this.cgS.bWk;
            editorToolComponetContainer11.vF();
            tbEditorToolButtonContainer13 = this.cgS.cgA;
            tbEditorToolButtonContainer13.agt();
            this.cgS.adk();
        } else if (i == 15) {
            editorToolComponetContainer6 = this.cgS.bWk;
            editorToolComponetContainer6.vG();
            akM3 = this.cgS.akM();
            if (akM3) {
                tbEditorToolButtonContainer12 = this.cgS.cgA;
                tbEditorToolButtonContainer12.agu();
            }
            writeImagesInfo7 = this.cgS.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo7.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cgS.cgA;
                tbEditorToolButtonContainer9.vx();
                editorToolComponetContainer7 = this.cgS.bWk;
                editorToolComponetContainer7.vx();
                editorToolComponetContainer8 = this.cgS.bWk;
                if (editorToolComponetContainer8.afY()) {
                    editorToolComponetContainer9 = this.cgS.bWk;
                    editorToolComponetContainer9.vF();
                    tbEditorToolButtonContainer10 = this.cgS.cgA;
                    tbEditorToolButtonContainer10.agt();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cgS.cgA;
                tbEditorToolButtonContainer11.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                editorToolComponetContainer10 = this.cgS.bWk;
                editorToolComponetContainer10.ee(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cgS.adk();
        } else if (i == 13) {
            writeImagesInfo6 = this.cgS.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo6.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cgS.cgA;
                tbEditorToolButtonContainer5.vx();
                editorToolComponetContainer2 = this.cgS.bWk;
                editorToolComponetContainer2.vG();
                editorToolComponetContainer3 = this.cgS.bWk;
                if (editorToolComponetContainer3.afY()) {
                    editorToolComponetContainer4 = this.cgS.bWk;
                    editorToolComponetContainer4.vF();
                    tbEditorToolButtonContainer7 = this.cgS.cgA;
                    tbEditorToolButtonContainer7.agt();
                } else {
                    akM2 = this.cgS.akM();
                    if (akM2) {
                        tbEditorToolButtonContainer6 = this.cgS.cgA;
                        tbEditorToolButtonContainer6.agu();
                    }
                }
            } else {
                tbEditorToolButtonContainer8 = this.cgS.cgA;
                tbEditorToolButtonContainer8.ee(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                editorToolComponetContainer5 = this.cgS.bWk;
                editorToolComponetContainer5.ee(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cgS.adk();
        } else if (i == 51) {
            writeImagesInfo5 = this.cgS.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo5.getChosedFiles();
            if (chosedFiles3 != null && chosedFiles3.size() > 0) {
                tbEditorToolButtonContainer4 = this.cgS.cgA;
                tbEditorToolButtonContainer4.agt();
            } else {
                akM = this.cgS.akM();
                if (akM) {
                    tbEditorToolButtonContainer3 = this.cgS.cgA;
                    tbEditorToolButtonContainer3.agu();
                }
            }
            this.cgS.adk();
        } else if (i != 7) {
            if (i == 42) {
                int intValue = ((Integer) obj).intValue();
                writeImagesInfo = this.cgS.writeImagesInfo;
                if (writeImagesInfo != null) {
                    writeImagesInfo2 = this.cgS.writeImagesInfo;
                    if (writeImagesInfo2.getChosedFiles() != null) {
                        writeImagesInfo3 = this.cgS.writeImagesInfo;
                        int size = writeImagesInfo3.getChosedFiles().size();
                        if (size >= 1 && intValue >= 0 && intValue < size) {
                            MessageManager messageManager = MessageManager.getInstance();
                            Activity pageActivity = this.cgS.getPageContext().getPageActivity();
                            writeImagesInfo4 = this.cgS.writeImagesInfo;
                            messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity, 12012, writeImagesInfo4, intValue)));
                        }
                    }
                }
            } else if (i == 46) {
                if (obj instanceof String) {
                    this.cgS.bVb = (String) obj;
                    this.cgS.eQ(true);
                }
                tbEditorToolButtonContainer2 = this.cgS.cgA;
                tbEditorToolButtonContainer2.vz();
            } else if (i == 47) {
                this.cgS.bVb = null;
                this.cgS.eQ(true);
            } else if (i != 48) {
                if (i != 55) {
                    if (i == 44 || i == 43) {
                        editorToolComponetContainer = this.cgS.bWk;
                        editorToolComponetContainer.afU();
                        tbEditorToolButtonContainer = this.cgS.cgA;
                        tbEditorToolButtonContainer.agG();
                    } else if (i == 57) {
                        this.cgS.it(57);
                    }
                }
            } else {
                this.cgS.iv(i);
            }
        } else {
            this.cgS.akL();
        }
    }
}
