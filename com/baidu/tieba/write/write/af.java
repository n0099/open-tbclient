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
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.dqi = writeActivity;
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
        boolean aDq;
        boolean aDq2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.dqi.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.dqi.aDu();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.dqi.arS = (VoiceData.VoiceModel) aVar.data;
                                this.dqi.aCf();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.dqi.arS = null;
                            this.dqi.aCf();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.dqi.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.dqi.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.dqi.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.dqi.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.dqi.writeImagesInfo;
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
                                        additionData = this.dqi.dpE;
                                        if (additionData == null) {
                                            this.dqi.Bn();
                                            return;
                                        }
                                    }
                                    i = this.dqi.ase;
                                    switch (i) {
                                        case 0:
                                            this.dqi.Bl();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.dqi.Bk();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.dqi.bWw = null;
                                    } else {
                                        this.dqi.bWw = (String) aVar.data;
                                    }
                                    this.dqi.hb(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("xiaoying_has_click", true);
                                    jVar5 = this.dqi.dpD;
                                    jVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                    TiebaStatic.log("c10057");
                                    writeData2 = this.dqi.dbx;
                                    VideoInfo videoInfo = writeData2.getVideoInfo();
                                    if (videoInfo != null && videoInfo.isAvaliable()) {
                                        com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                        jVar9 = this.dqi.dpD;
                                        jVar9.b(aVar2);
                                        return;
                                    } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                            jVar6 = this.dqi.dpD;
                                            if (jVar6.Ax()) {
                                                jVar7 = this.dqi.dpD;
                                                jVar7.yX();
                                                jVar8 = this.dqi.dpD;
                                                jVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            }
                                            XiaoyingUtil.startXiaoying(this.dqi.getActivity());
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dqi.getPageContext(), this.dqi.getResources().getString(i.h.plugin_video_not_active), this.dqi.getResources().getString(i.h.setup));
                                        return;
                                    } else {
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dqi.getPageContext(), this.dqi.getResources().getString(i.h.plugin_video_install_tips), this.dqi.getResources().getString(i.h.plugin_go_install));
                                        return;
                                    }
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    jVar = this.dqi.dpD;
                                    jVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    jVar2 = this.dqi.dpD;
                                    jVar2.b(aVar4);
                                    writeData = this.dqi.dbx;
                                    writeData.setVideoInfo(null);
                                    this.dqi.aCf();
                                    editText = this.dqi.dmD;
                                    if (editText != null) {
                                        editText3 = this.dqi.dmD;
                                        editText3.requestFocus();
                                    }
                                    jVar3 = this.dqi.dpD;
                                    jVar3.yX();
                                    jVar4 = this.dqi.dpD;
                                    jVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.dqi;
                                    inputMethodManager = this.dqi.mInputManager;
                                    editText2 = this.dqi.dmD;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.dqi.aCf();
                            return;
                        } else {
                            this.dqi.aDC();
                            this.dqi.aCf();
                            return;
                        }
                    } else {
                        aDq = this.dqi.aDq();
                        if (aDq) {
                            this.dqi.showToast(i.h.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                            this.dqi.a((com.baidu.tbadk.coreExtra.data.f) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.dqi.aDr();
                return;
            }
            aDq2 = this.dqi.aDq();
            if (aDq2) {
                this.dqi.showToast(i.h.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dqi.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
