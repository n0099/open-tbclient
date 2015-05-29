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
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(WriteActivity writeActivity) {
        this.cCP = writeActivity;
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
        boolean atv;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo9;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        boolean atv2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer4;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        boolean atv3;
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
        boolean Km;
        TbEditorToolButtonContainer tbEditorToolButtonContainer15;
        if (i == 23) {
            tbEditorToolButtonContainer15 = this.cCP.cCx;
            tbEditorToolButtonContainer15.ask();
            this.cCP.jD(8);
        } else if (i == 20) {
            Km = this.cCP.Km();
            if (Km) {
                this.cCP.showToast(com.baidu.tieba.t.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cCP.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cCP.atr();
        } else if (i == 4) {
            str = this.cCP.bKu;
            if (str != null) {
                str2 = this.cCP.bKu;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cCP;
                    str3 = this.cCP.bKu;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer14 = this.cCP.cCx;
            tbEditorToolButtonContainer14.ask();
            this.cCP.jD(5);
        } else if (i == 14) {
            editorToolComponetContainer11 = this.cCP.cqO;
            editorToolComponetContainer11.zQ();
            tbEditorToolButtonContainer13 = this.cCP.cCx;
            tbEditorToolButtonContainer13.aod();
            this.cCP.asF();
        } else if (i == 15) {
            editorToolComponetContainer6 = this.cCP.cqO;
            editorToolComponetContainer6.zR();
            atv3 = this.cCP.atv();
            if (atv3) {
                tbEditorToolButtonContainer12 = this.cCP.cCx;
                tbEditorToolButtonContainer12.aoe();
            }
            writeImagesInfo10 = this.cCP.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo10.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cCP.cCx;
                tbEditorToolButtonContainer9.zI();
                this.cCP.cCy = false;
                editorToolComponetContainer7 = this.cCP.cqO;
                editorToolComponetContainer7.zI();
                editorToolComponetContainer8 = this.cCP.cqO;
                if (editorToolComponetContainer8.anH()) {
                    editorToolComponetContainer9 = this.cCP.cqO;
                    editorToolComponetContainer9.zQ();
                    tbEditorToolButtonContainer10 = this.cCP.cCx;
                    tbEditorToolButtonContainer10.aod();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cCP.cCx;
                tbEditorToolButtonContainer11.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.cCP.cCy = true;
                editorToolComponetContainer10 = this.cCP.cqO;
                editorToolComponetContainer10.eC(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cCP.asF();
        } else if (i == 13) {
            writeImagesInfo9 = this.cCP.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo9.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cCP.cCx;
                tbEditorToolButtonContainer5.zI();
                this.cCP.cCy = false;
                editorToolComponetContainer2 = this.cCP.cqO;
                editorToolComponetContainer2.zR();
                editorToolComponetContainer3 = this.cCP.cqO;
                if (editorToolComponetContainer3.anH()) {
                    editorToolComponetContainer4 = this.cCP.cqO;
                    editorToolComponetContainer4.zQ();
                    tbEditorToolButtonContainer7 = this.cCP.cCx;
                    tbEditorToolButtonContainer7.aod();
                } else {
                    atv2 = this.cCP.atv();
                    if (atv2) {
                        tbEditorToolButtonContainer6 = this.cCP.cCx;
                        tbEditorToolButtonContainer6.aoe();
                    }
                }
            } else {
                tbEditorToolButtonContainer8 = this.cCP.cCx;
                tbEditorToolButtonContainer8.eC(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.cCP.cCy = true;
                editorToolComponetContainer5 = this.cCP.cqO;
                editorToolComponetContainer5.eC(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cCP.asF();
        } else if (i == 51) {
            writeImagesInfo8 = this.cCP.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo8.getChosedFiles();
            if (chosedFiles3 != null && chosedFiles3.size() > 0) {
                tbEditorToolButtonContainer4 = this.cCP.cCx;
                tbEditorToolButtonContainer4.aod();
            } else {
                atv = this.cCP.atv();
                if (atv) {
                    tbEditorToolButtonContainer3 = this.cCP.cCx;
                    tbEditorToolButtonContainer3.aoe();
                }
            }
            this.cCP.asF();
        } else if (i == 7) {
            writeImagesInfo5 = this.cCP.writeImagesInfo;
            if (writeImagesInfo5 != null) {
                writeImagesInfo6 = this.cCP.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity = this.cCP.getPageContext().getPageActivity();
                    writeImagesInfo7 = this.cCP.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo7.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.cCP.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.cCP.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.cCP.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity2 = this.cCP.getPageContext().getPageActivity();
                        writeImagesInfo4 = this.cCP.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            if (obj instanceof String) {
                this.cCP.bCP = (String) obj;
                this.cCP.fF(true);
            }
            tbEditorToolButtonContainer2 = this.cCP.cCx;
            tbEditorToolButtonContainer2.zK();
        } else if (i == 47) {
            this.cCP.bCP = null;
            this.cCP.fF(true);
        } else if (i != 48) {
            if (i != 55) {
                if (i == 44 || i == 43) {
                    editorToolComponetContainer = this.cCP.cqO;
                    editorToolComponetContainer.anD();
                    tbEditorToolButtonContainer = this.cCP.cCx;
                    tbEditorToolButtonContainer.asg();
                } else if (i == 57) {
                    this.cCP.jD(57);
                }
            }
        } else {
            this.cCP.jF(i);
        }
    }
}
