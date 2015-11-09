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
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.dsa = writeActivity;
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
        boolean aEk;
        boolean aEk2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.dsa.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.dsa.aEo();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.dsa.aqr = (VoiceData.VoiceModel) aVar.data;
                                this.dsa.aCV();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.dsa.aqr = null;
                            this.dsa.aCV();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.dsa.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.dsa.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.dsa.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.dsa.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.dsa.writeImagesInfo;
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
                                        additionData = this.dsa.drs;
                                        if (additionData == null) {
                                            this.dsa.Be();
                                            return;
                                        }
                                    }
                                    i = this.dsa.aqD;
                                    switch (i) {
                                        case 0:
                                            this.dsa.Bc();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.dsa.Bb();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.dsa.bWX = null;
                                    } else {
                                        this.dsa.bWX = (String) aVar.data;
                                    }
                                    this.dsa.he(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("xiaoying_has_click", true);
                                    jVar5 = this.dsa.drr;
                                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                    TiebaStatic.log("c10057");
                                    writeData2 = this.dsa.ddI;
                                    VideoInfo videoInfo = writeData2.getVideoInfo();
                                    if (videoInfo != null && videoInfo.isAvaliable()) {
                                        com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                        jVar9 = this.dsa.drr;
                                        jVar9.b(aVar2);
                                        return;
                                    } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                            jVar6 = this.dsa.drr;
                                            if (jVar6.AC()) {
                                                jVar7 = this.dsa.drr;
                                                jVar7.zc();
                                                jVar8 = this.dsa.drr;
                                                jVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            }
                                            XiaoyingUtil.startXiaoying(this.dsa.getActivity());
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dsa.getPageContext(), this.dsa.getResources().getString(i.h.plugin_video_not_active), this.dsa.getResources().getString(i.h.setup));
                                        return;
                                    } else {
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dsa.getPageContext(), this.dsa.getResources().getString(i.h.plugin_video_install_tips), this.dsa.getResources().getString(i.h.plugin_go_install));
                                        return;
                                    }
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    jVar = this.dsa.drr;
                                    jVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    jVar2 = this.dsa.drr;
                                    jVar2.b(aVar4);
                                    writeData = this.dsa.ddI;
                                    writeData.setVideoInfo(null);
                                    this.dsa.aCV();
                                    editText = this.dsa.dol;
                                    if (editText != null) {
                                        editText3 = this.dsa.dol;
                                        editText3.requestFocus();
                                    }
                                    jVar3 = this.dsa.drr;
                                    jVar3.zc();
                                    jVar4 = this.dsa.drr;
                                    jVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.dsa;
                                    inputMethodManager = this.dsa.mInputManager;
                                    editText2 = this.dsa.dol;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.dsa.aCV();
                            return;
                        } else {
                            this.dsa.aEw();
                            this.dsa.aCV();
                            return;
                        }
                    } else {
                        aEk = this.dsa.aEk();
                        if (aEk) {
                            this.dsa.showToast(i.h.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                            this.dsa.a((com.baidu.tbadk.coreExtra.data.f) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.dsa.aEl();
                return;
            }
            aEk2 = this.dsa.aEk();
            if (aEk2) {
                this.dsa.showToast(i.h.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dsa.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
