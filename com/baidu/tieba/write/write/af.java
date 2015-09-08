package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        WriteData writeData;
        EditText editText;
        com.baidu.tbadk.editortools.j jVar3;
        com.baidu.tbadk.editortools.j jVar4;
        InputMethodManager inputMethodManager;
        EditText editText2;
        EditText editText3;
        WriteData writeData2;
        com.baidu.tbadk.editortools.j jVar5;
        com.baidu.tbadk.editortools.j jVar6;
        com.baidu.tbadk.editortools.j jVar7;
        com.baidu.tbadk.editortools.j jVar8;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean azI;
        boolean azI2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.ddQ.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.ddQ.azM();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.ddQ.atu = (VoiceData.VoiceModel) aVar.data;
                                this.ddQ.ayQ();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.ddQ.atu = null;
                            this.ddQ.ayQ();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.ddQ.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.ddQ.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.ddQ.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.ddQ.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.ddQ.writeImagesInfo;
                                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(pageActivity, 12012, writeImagesInfo4, intValue)));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (aVar.code == 18) {
                                    if (aVar.data != null) {
                                        additionData = this.ddQ.ddm;
                                        if (additionData == null) {
                                            this.ddQ.BD();
                                            return;
                                        }
                                    }
                                    i = this.ddQ.atG;
                                    switch (i) {
                                        case 0:
                                            this.ddQ.BB();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.ddQ.BA();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.ddQ.bSz = null;
                                    } else {
                                        this.ddQ.bSz = (String) aVar.data;
                                    }
                                    this.ddQ.gK(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    TiebaStatic.log("c10057");
                                    writeData2 = this.ddQ.cTs;
                                    VideoInfo videoInfo = writeData2.getVideoInfo();
                                    if (videoInfo != null && videoInfo.isAvaliable()) {
                                        com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                        jVar8 = this.ddQ.ddl;
                                        jVar8.b(aVar2);
                                        return;
                                    } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                            jVar5 = this.ddQ.ddl;
                                            if (jVar5.AO()) {
                                                jVar6 = this.ddQ.ddl;
                                                jVar6.zr();
                                                jVar7 = this.ddQ.ddl;
                                                jVar7.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            }
                                            XiaoyingUtil.startXiaoying(this.ddQ.getActivity());
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.ddQ.getPageContext(), this.ddQ.getResources().getString(i.h.plugin_video_not_active), this.ddQ.getResources().getString(i.h.setup));
                                        return;
                                    } else {
                                        XiaoyingUtil.showGoPluginDetailDialog(this.ddQ.getPageContext(), this.ddQ.getResources().getString(i.h.plugin_video_install_tips), this.ddQ.getResources().getString(i.h.plugin_go_install));
                                        return;
                                    }
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    jVar = this.ddQ.ddl;
                                    jVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    jVar2 = this.ddQ.ddl;
                                    jVar2.b(aVar4);
                                    writeData = this.ddQ.cTs;
                                    writeData.setVideoInfo(null);
                                    this.ddQ.ayQ();
                                    editText = this.ddQ.dbb;
                                    if (editText != null) {
                                        editText3 = this.ddQ.dbb;
                                        editText3.requestFocus();
                                    }
                                    jVar3 = this.ddQ.ddl;
                                    jVar3.zr();
                                    jVar4 = this.ddQ.ddl;
                                    jVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.ddQ;
                                    inputMethodManager = this.ddQ.mInputManager;
                                    editText2 = this.ddQ.dbb;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.ddQ.ayQ();
                            return;
                        } else {
                            this.ddQ.azV();
                            this.ddQ.ayQ();
                            return;
                        }
                    } else {
                        azI = this.ddQ.azI();
                        if (azI) {
                            this.ddQ.showToast(i.h.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                            this.ddQ.a((com.baidu.tbadk.coreExtra.data.f) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.ddQ.azJ();
                return;
            }
            azI2 = this.ddQ.azI();
            if (azI2) {
                this.ddQ.showToast(i.h.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ddQ.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
