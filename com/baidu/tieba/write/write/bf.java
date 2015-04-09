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
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cyx = writeActivity;
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
        boolean arF;
        TbEditorToolButtonContainer tbEditorToolButtonContainer3;
        TbEditorToolButtonContainer tbEditorToolButtonContainer4;
        WriteImagesInfo writeImagesInfo9;
        TbEditorToolButtonContainer tbEditorToolButtonContainer5;
        EditorToolComponetContainer editorToolComponetContainer2;
        EditorToolComponetContainer editorToolComponetContainer3;
        boolean arF2;
        TbEditorToolButtonContainer tbEditorToolButtonContainer6;
        EditorToolComponetContainer editorToolComponetContainer4;
        TbEditorToolButtonContainer tbEditorToolButtonContainer7;
        TbEditorToolButtonContainer tbEditorToolButtonContainer8;
        EditorToolComponetContainer editorToolComponetContainer5;
        EditorToolComponetContainer editorToolComponetContainer6;
        boolean arF3;
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
        boolean Ji;
        TbEditorToolButtonContainer tbEditorToolButtonContainer15;
        if (i == 23) {
            tbEditorToolButtonContainer15 = this.cyx.cyf;
            tbEditorToolButtonContainer15.aqu();
            this.cyx.jh(8);
        } else if (i == 20) {
            Ji = this.cyx.Ji();
            if (Ji) {
                this.cyx.showToast(com.baidu.tieba.y.over_limit_tip);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.data.f) {
                this.cyx.a((com.baidu.tbadk.coreExtra.data.f) obj);
            }
        } else if (i == 21) {
            this.cyx.arB();
        } else if (i == 4) {
            str = this.cyx.bIf;
            if (str != null) {
                str2 = this.cyx.bIf;
                if (str2.length() > 0) {
                    WriteActivity writeActivity = this.cyx;
                    str3 = this.cyx.bIf;
                    writeActivity.showToast(str3);
                    return;
                }
            }
            tbEditorToolButtonContainer14 = this.cyx.cyf;
            tbEditorToolButtonContainer14.aqu();
            this.cyx.jh(5);
        } else if (i == 14) {
            editorToolComponetContainer11 = this.cyx.cmP;
            editorToolComponetContainer11.zd();
            tbEditorToolButtonContainer13 = this.cyx.cyf;
            tbEditorToolButtonContainer13.amr();
            this.cyx.aqP();
        } else if (i == 15) {
            editorToolComponetContainer6 = this.cyx.cmP;
            editorToolComponetContainer6.ze();
            arF3 = this.cyx.arF();
            if (arF3) {
                tbEditorToolButtonContainer12 = this.cyx.cyf;
                tbEditorToolButtonContainer12.ams();
            }
            writeImagesInfo10 = this.cyx.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo10.getChosedFiles();
            if (chosedFiles == null || chosedFiles.size() <= 0) {
                tbEditorToolButtonContainer9 = this.cyx.cyf;
                tbEditorToolButtonContainer9.yV();
                this.cyx.cyg = false;
                editorToolComponetContainer7 = this.cyx.cmP;
                editorToolComponetContainer7.yV();
                editorToolComponetContainer8 = this.cyx.cmP;
                if (editorToolComponetContainer8.alV()) {
                    editorToolComponetContainer9 = this.cyx.cmP;
                    editorToolComponetContainer9.zd();
                    tbEditorToolButtonContainer10 = this.cyx.cyf;
                    tbEditorToolButtonContainer10.amr();
                }
            } else {
                tbEditorToolButtonContainer11 = this.cyx.cyf;
                tbEditorToolButtonContainer11.el(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
                this.cyx.cyg = true;
                editorToolComponetContainer10 = this.cyx.cmP;
                editorToolComponetContainer10.el(new StringBuilder(String.valueOf(chosedFiles.size())).toString());
            }
            this.cyx.aqP();
        } else if (i == 13) {
            writeImagesInfo9 = this.cyx.writeImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles2 = writeImagesInfo9.getChosedFiles();
            if (chosedFiles2 == null || chosedFiles2.size() <= 0) {
                tbEditorToolButtonContainer5 = this.cyx.cyf;
                tbEditorToolButtonContainer5.yV();
                this.cyx.cyg = false;
                editorToolComponetContainer2 = this.cyx.cmP;
                editorToolComponetContainer2.ze();
                editorToolComponetContainer3 = this.cyx.cmP;
                if (editorToolComponetContainer3.alV()) {
                    editorToolComponetContainer4 = this.cyx.cmP;
                    editorToolComponetContainer4.zd();
                    tbEditorToolButtonContainer7 = this.cyx.cyf;
                    tbEditorToolButtonContainer7.amr();
                } else {
                    arF2 = this.cyx.arF();
                    if (arF2) {
                        tbEditorToolButtonContainer6 = this.cyx.cyf;
                        tbEditorToolButtonContainer6.ams();
                    }
                }
            } else {
                tbEditorToolButtonContainer8 = this.cyx.cyf;
                tbEditorToolButtonContainer8.el(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
                this.cyx.cyg = true;
                editorToolComponetContainer5 = this.cyx.cmP;
                editorToolComponetContainer5.el(new StringBuilder(String.valueOf(chosedFiles2.size())).toString());
            }
            this.cyx.aqP();
        } else if (i == 51) {
            writeImagesInfo8 = this.cyx.baobaoImagesInfo;
            LinkedList<ImageFileInfo> chosedFiles3 = writeImagesInfo8.getChosedFiles();
            if (chosedFiles3 != null && chosedFiles3.size() > 0) {
                tbEditorToolButtonContainer4 = this.cyx.cyf;
                tbEditorToolButtonContainer4.amr();
            } else {
                arF = this.cyx.arF();
                if (arF) {
                    tbEditorToolButtonContainer3 = this.cyx.cyf;
                    tbEditorToolButtonContainer3.ams();
                }
            }
            this.cyx.aqP();
        } else if (i == 7) {
            writeImagesInfo5 = this.cyx.writeImagesInfo;
            if (writeImagesInfo5 != null) {
                writeImagesInfo6 = this.cyx.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity = this.cyx.getPageContext().getPageActivity();
                    writeImagesInfo7 = this.cyx.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo7.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo = this.cyx.writeImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.cyx.writeImagesInfo;
                if (writeImagesInfo2.getChosedFiles() != null) {
                    writeImagesInfo3 = this.cyx.writeImagesInfo;
                    int size = writeImagesInfo3.getChosedFiles().size();
                    if (size >= 1 && intValue >= 0 && intValue < size) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity2 = this.cyx.getPageContext().getPageActivity();
                        writeImagesInfo4 = this.cyx.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo4, intValue)));
                    }
                }
            }
        } else if (i == 46) {
            if (obj instanceof String) {
                this.cyx.bAb = (String) obj;
                this.cyx.fj(true);
            }
            tbEditorToolButtonContainer2 = this.cyx.cyf;
            tbEditorToolButtonContainer2.yX();
        } else if (i == 47) {
            this.cyx.bAb = null;
            this.cyx.fj(true);
        } else if (i != 48) {
            if (i != 55) {
                if (i == 44 || i == 43) {
                    editorToolComponetContainer = this.cyx.cmP;
                    editorToolComponetContainer.alR();
                    tbEditorToolButtonContainer = this.cyx.cyf;
                    tbEditorToolButtonContainer.aqq();
                } else if (i == 57) {
                    this.cyx.jh(57);
                }
            }
        } else {
            this.cyx.jj(i);
        }
    }
}
