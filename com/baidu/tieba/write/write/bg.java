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
public class bg implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
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
        boolean atw;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo9;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        boolean atw2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer4;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        boolean atw3;
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
        boolean Kn;
        TbEditorToolButtonContainer tbEditorToolButtonContainer15;
        if (i == 23) {
            tbEditorToolButtonContainer15 = this.cCQ.cCy;
            tbEditorToolButtonContainer15.asl();
            this.cCQ.jD(8);
        } else if (i == 20) {
            Kn = this.cCQ.Kn();
            if (Kn) {
                this.cCQ.showToast(com.baidu.tieba.t.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cCQ.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cCQ.ats();
        } else if (i == 4) {
            str = this.cCQ.bKv;
            if (str != null) {
                str2 = this.cCQ.bKv;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cCQ;
                    str3 = this.cCQ.bKv;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer14 = this.cCQ.cCy;
            tbEditorToolButtonContainer14.asl();
            this.cCQ.jD(5);
        } else if (i == 14) {
            editorToolComponetContainer11 = this.cCQ.cqP;
            editorToolComponetContainer11.zR();
            tbEditorToolButtonContainer13 = this.cCQ.cCy;
            tbEditorToolButtonContainer13.aoe();
            this.cCQ.asG();
        } else if (i == 15) {
            editorToolComponetContainer6 = this.cCQ.cqP;
            editorToolComponetContainer6.zS();
            atw3 = this.cCQ.atw();
            if (atw3) {
                tbEditorToolButtonContainer12 = this.cCQ.cCy;
                tbEditorToolButtonContainer12.aof();
            }
            writeImagesInfo10 = this.cCQ.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo10.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cCQ.cCy;
                tbEditorToolButtonContainer9.zJ();
                this.cCQ.cCz = false;
                editorToolComponetContainer7 = this.cCQ.cqP;
                editorToolComponetContainer7.zJ();
                editorToolComponetContainer8 = this.cCQ.cqP;
                if (editorToolComponetContainer8.anI()) {
                    editorToolComponetContainer9 = this.cCQ.cqP;
                    editorToolComponetContainer9.zR();
                    tbEditorToolButtonContainer10 = this.cCQ.cCy;
                    tbEditorToolButtonContainer10.aoe();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cCQ.cCy;
                tbEditorToolButtonContainer11.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.cCQ.cCz = true;
                editorToolComponetContainer10 = this.cCQ.cqP;
                editorToolComponetContainer10.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cCQ.asG();
        } else if (i == 13) {
            writeImagesInfo9 = this.cCQ.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo9.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cCQ.cCy;
                tbEditorToolButtonContainer5.zJ();
                this.cCQ.cCz = false;
                editorToolComponetContainer2 = this.cCQ.cqP;
                editorToolComponetContainer2.zS();
                editorToolComponetContainer3 = this.cCQ.cqP;
                if (editorToolComponetContainer3.anI()) {
                    editorToolComponetContainer4 = this.cCQ.cqP;
                    editorToolComponetContainer4.zR();
                    tbEditorToolButtonContainer7 = this.cCQ.cCy;
                    tbEditorToolButtonContainer7.aoe();
                } else {
                    atw2 = this.cCQ.atw();
                    if (atw2) {
                        tbEditorToolButtonContainer6 = this.cCQ.cCy;
                        tbEditorToolButtonContainer6.aof();
                    }
                }
            } else {
                tbEditorToolButtonContainer8 = this.cCQ.cCy;
                tbEditorToolButtonContainer8.eC(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.cCQ.cCz = true;
                editorToolComponetContainer5 = this.cCQ.cqP;
                editorToolComponetContainer5.eC(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cCQ.asG();
        } else if (i == 51) {
            writeImagesInfo8 = this.cCQ.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo8.getChosedFiles();
            if (chosedFiles3 != null && chosedFiles3.size() > 0) {
                tbEditorToolButtonContainer4 = this.cCQ.cCy;
                tbEditorToolButtonContainer4.aoe();
            } else {
                atw = this.cCQ.atw();
                if (atw) {
                    tbEditorToolButtonContainer3 = this.cCQ.cCy;
                    tbEditorToolButtonContainer3.aof();
                }
            }
            this.cCQ.asG();
        } else if (i == 7) {
            writeImagesInfo5 = this.cCQ.writeImagesInfo;
            if (writeImagesInfo5 != null) {
                writeImagesInfo6 = this.cCQ.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity = this.cCQ.getPageContext().getPageActivity();
                    writeImagesInfo7 = this.cCQ.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo7.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.cCQ.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.cCQ.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.cCQ.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity2 = this.cCQ.getPageContext().getPageActivity();
                        writeImagesInfo4 = this.cCQ.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            if (obj instanceof String) {
                this.cCQ.bCQ = (String) obj;
                this.cCQ.fF(true);
            }
            tbEditorToolButtonContainer2 = this.cCQ.cCy;
            tbEditorToolButtonContainer2.zL();
        } else if (i == 47) {
            this.cCQ.bCQ = null;
            this.cCQ.fF(true);
        } else if (i != 48) {
            if (i != 55) {
                if (i == 44 || i == 43) {
                    editorToolComponetContainer = this.cCQ.cqP;
                    editorToolComponetContainer.anE();
                    tbEditorToolButtonContainer = this.cCQ.cCy;
                    tbEditorToolButtonContainer.ash();
                } else if (i == 57) {
                    this.cCQ.jD(57);
                }
            }
        } else {
            this.cCQ.jF(i);
        }
    }
}
