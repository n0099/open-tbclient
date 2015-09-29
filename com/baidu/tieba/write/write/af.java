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
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.dpI = writeActivity;
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
        com.baidu.tbadk.editortools.j jVar5;
        WriteData writeData2;
        com.baidu.tbadk.editortools.j jVar6;
        com.baidu.tbadk.editortools.j jVar7;
        com.baidu.tbadk.editortools.j jVar8;
        com.baidu.tbadk.editortools.j jVar9;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean aDk;
        boolean aDk2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.dpI.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.dpI.aDo();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.dpI.arR = (VoiceData.VoiceModel) aVar.data;
                                this.dpI.aBZ();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.dpI.arR = null;
                            this.dpI.aBZ();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.dpI.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.dpI.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.dpI.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.dpI.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.dpI.writeImagesInfo;
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
                                        additionData = this.dpI.dpd;
                                        if (additionData == null) {
                                            this.dpI.Bq();
                                            return;
                                        }
                                    }
                                    i = this.dpI.asd;
                                    switch (i) {
                                        case 0:
                                            this.dpI.Bo();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.dpI.Bn();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.dpI.bWl = null;
                                    } else {
                                        this.dpI.bWl = (String) aVar.data;
                                    }
                                    this.dpI.hb(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("xiaoying_has_click", true);
                                    jVar5 = this.dpI.dpc;
                                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                    TiebaStatic.log("c10057");
                                    writeData2 = this.dpI.daX;
                                    VideoInfo videoInfo = writeData2.getVideoInfo();
                                    if (videoInfo != null && videoInfo.isAvaliable()) {
                                        com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                        jVar9 = this.dpI.dpc;
                                        jVar9.b(aVar2);
                                        return;
                                    } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                            jVar6 = this.dpI.dpc;
                                            if (jVar6.AA()) {
                                                jVar7 = this.dpI.dpc;
                                                jVar7.za();
                                                jVar8 = this.dpI.dpc;
                                                jVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            }
                                            XiaoyingUtil.startXiaoying(this.dpI.getActivity());
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dpI.getPageContext(), this.dpI.getResources().getString(i.h.plugin_video_not_active), this.dpI.getResources().getString(i.h.setup));
                                        return;
                                    } else {
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dpI.getPageContext(), this.dpI.getResources().getString(i.h.plugin_video_install_tips), this.dpI.getResources().getString(i.h.plugin_go_install));
                                        return;
                                    }
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    jVar = this.dpI.dpc;
                                    jVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    jVar2 = this.dpI.dpc;
                                    jVar2.b(aVar4);
                                    writeData = this.dpI.daX;
                                    writeData.setVideoInfo(null);
                                    this.dpI.aBZ();
                                    editText = this.dpI.dmd;
                                    if (editText != null) {
                                        editText3 = this.dpI.dmd;
                                        editText3.requestFocus();
                                    }
                                    jVar3 = this.dpI.dpc;
                                    jVar3.za();
                                    jVar4 = this.dpI.dpc;
                                    jVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.dpI;
                                    inputMethodManager = this.dpI.mInputManager;
                                    editText2 = this.dpI.dmd;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.dpI.aBZ();
                            return;
                        } else {
                            this.dpI.aDw();
                            this.dpI.aBZ();
                            return;
                        }
                    } else {
                        aDk = this.dpI.aDk();
                        if (aDk) {
                            this.dpI.showToast(i.h.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                            this.dpI.a((com.baidu.tbadk.coreExtra.data.f) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.dpI.aDl();
                return;
            }
            aDk2 = this.dpI.aDk();
            if (aDk2) {
                this.dpI.showToast(i.h.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dpI.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
