package com.baidu.tieba.write.write;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
import com.baidu.tieba.write.editor.TbEditorToolButtonContainer;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        EditorToolComponetContainer editorToolComponetContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer;
        TbEditorToolButtonContainer tbEditorToolButtonContainer2;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        boolean arq;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo9;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        boolean arq2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer4;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        boolean arq3;
        WriteImagesInfo writeImagesInfo10;
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
        boolean Jc;
        TbEditorToolButtonContainer tbEditorToolButtonContainer15;
        if (i == 23) {
            tbEditorToolButtonContainer15 = this.cyc.cxK;
            tbEditorToolButtonContainer15.aqf();
            this.cyc.je(8);
        } else if (i == 20) {
            Jc = this.cyc.Jc();
            if (Jc) {
                this.cyc.showToast(com.baidu.tieba.y.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cyc.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cyc.arm();
        } else if (i == 4) {
            str = this.cyc.bHS;
            if (str != null) {
                str2 = this.cyc.bHS;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cyc;
                    str3 = this.cyc.bHS;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer14 = this.cyc.cxK;
            tbEditorToolButtonContainer14.aqf();
            this.cyc.je(5);
        } else if (i == 14) {
            editorToolComponetContainer11 = this.cyc.cmz;
            editorToolComponetContainer11.yX();
            tbEditorToolButtonContainer13 = this.cyc.cxK;
            tbEditorToolButtonContainer13.amc();
            this.cyc.aqA();
        } else if (i == 15) {
            editorToolComponetContainer6 = this.cyc.cmz;
            editorToolComponetContainer6.yY();
            arq3 = this.cyc.arq();
            if (arq3) {
                tbEditorToolButtonContainer12 = this.cyc.cxK;
                tbEditorToolButtonContainer12.amd();
            }
            writeImagesInfo10 = this.cyc.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo10.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cyc.cxK;
                tbEditorToolButtonContainer9.yP();
                this.cyc.cxL = false;
                editorToolComponetContainer7 = this.cyc.cmz;
                editorToolComponetContainer7.yP();
                editorToolComponetContainer8 = this.cyc.cmz;
                if (editorToolComponetContainer8.alG()) {
                    editorToolComponetContainer9 = this.cyc.cmz;
                    editorToolComponetContainer9.yX();
                    tbEditorToolButtonContainer10 = this.cyc.cxK;
                    tbEditorToolButtonContainer10.amc();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cyc.cxK;
                tbEditorToolButtonContainer11.ei(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.cyc.cxL = true;
                editorToolComponetContainer10 = this.cyc.cmz;
                editorToolComponetContainer10.ei(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cyc.aqA();
        } else if (i == 13) {
            writeImagesInfo9 = this.cyc.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo9.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cyc.cxK;
                tbEditorToolButtonContainer5.yP();
                this.cyc.cxL = false;
                editorToolComponetContainer2 = this.cyc.cmz;
                editorToolComponetContainer2.yY();
                editorToolComponetContainer3 = this.cyc.cmz;
                if (editorToolComponetContainer3.alG()) {
                    editorToolComponetContainer4 = this.cyc.cmz;
                    editorToolComponetContainer4.yX();
                    tbEditorToolButtonContainer7 = this.cyc.cxK;
                    tbEditorToolButtonContainer7.amc();
                } else {
                    arq2 = this.cyc.arq();
                    if (arq2) {
                        tbEditorToolButtonContainer6 = this.cyc.cxK;
                        tbEditorToolButtonContainer6.amd();
                    }
                }
            } else {
                tbEditorToolButtonContainer8 = this.cyc.cxK;
                tbEditorToolButtonContainer8.ei(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.cyc.cxL = true;
                editorToolComponetContainer5 = this.cyc.cmz;
                editorToolComponetContainer5.ei(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cyc.aqA();
        } else if (i == 51) {
            writeImagesInfo8 = this.cyc.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo8.getChosedFiles();
            if (chosedFiles3 != null && chosedFiles3.size() > 0) {
                tbEditorToolButtonContainer4 = this.cyc.cxK;
                tbEditorToolButtonContainer4.amc();
            } else {
                arq = this.cyc.arq();
                if (arq) {
                    tbEditorToolButtonContainer3 = this.cyc.cxK;
                    tbEditorToolButtonContainer3.amd();
                }
            }
            this.cyc.aqA();
        } else if (i == 7) {
            writeImagesInfo5 = this.cyc.writeImagesInfo;
            if (writeImagesInfo5 != null) {
                writeImagesInfo6 = this.cyc.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity = this.cyc.getPageContext().getPageActivity();
                    writeImagesInfo7 = this.cyc.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo7.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.cyc.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.cyc.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.cyc.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity2 = this.cyc.getPageContext().getPageActivity();
                        writeImagesInfo4 = this.cyc.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            if (obj instanceof String) {
                this.cyc.bzO = (String) obj;
                this.cyc.fk(true);
            }
            tbEditorToolButtonContainer2 = this.cyc.cxK;
            tbEditorToolButtonContainer2.yR();
        } else if (i == 47) {
            this.cyc.bzO = null;
            this.cyc.fk(true);
        } else if (i != 48) {
            if (i != 55) {
                if (i == 44 || i == 43) {
                    editorToolComponetContainer = this.cyc.cmz;
                    editorToolComponetContainer.alC();
                    tbEditorToolButtonContainer = this.cyc.cxK;
                    tbEditorToolButtonContainer.aqb();
                } else if (i == 57) {
                    this.cyc.je(57);
                }
            }
        } else {
            this.cyc.jg(i);
        }
    }
}
