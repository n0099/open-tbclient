package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        WriteData writeData;
        EditText editText;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        InputMethodManager inputMethodManager;
        EditText editText2;
        EditText editText3;
        WriteData writeData2;
        String str;
        WriteData writeData3;
        com.baidu.tbadk.editortools.k kVar5;
        com.baidu.tbadk.editortools.k kVar6;
        com.baidu.tbadk.editortools.k kVar7;
        com.baidu.tbadk.editortools.k kVar8;
        com.baidu.tbadk.editortools.k kVar9;
        com.baidu.tbadk.editortools.k kVar10;
        WriteData writeData4;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean aMc;
        boolean aMc2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.dYD.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.dYD.aMg();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.dYD.atZ = (VoiceData.VoiceModel) aVar.data;
                                this.dYD.aKN();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.dYD.atZ = null;
                            this.dYD.aKN();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.dYD.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.dYD.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.dYD.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.dYD.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.dYD.writeImagesInfo;
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
                                        additionData = this.dYD.dXU;
                                        if (additionData == null) {
                                            this.dYD.BT();
                                            return;
                                        }
                                    }
                                    i = this.dYD.aul;
                                    switch (i) {
                                        case 0:
                                            this.dYD.BR();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.dYD.BQ();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.dYD.cro = null;
                                    } else {
                                        this.dYD.cro = (String) aVar.data;
                                    }
                                    this.dYD.hV(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("xiaoying_has_click", true);
                                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10645");
                                    writeData2 = this.dYD.dJy;
                                    if (writeData2 != null) {
                                        writeData4 = this.dYD.dJy;
                                        str = writeData4.getForumId();
                                    } else {
                                        str = "";
                                    }
                                    avVar.aa(ImageViewerConfig.FORUM_ID, str);
                                    TiebaStatic.log(avVar);
                                    writeData3 = this.dYD.dJy;
                                    VideoInfo videoInfo = writeData3.getVideoInfo();
                                    if (videoInfo == null || !videoInfo.isAvaliable()) {
                                        kVar5 = this.dYD.aso;
                                        kVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                                            if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                kVar6 = this.dYD.aso;
                                                if (kVar6.Bm()) {
                                                    kVar7 = this.dYD.aso;
                                                    kVar7.zK();
                                                    kVar8 = this.dYD.aso;
                                                    kVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                }
                                                XiaoyingUtil.startXiaoying(this.dYD.getActivity());
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.dYD.getPageContext(), this.dYD.getResources().getString(n.j.plugin_video_not_active), this.dYD.getResources().getString(n.j.setup));
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dYD.getPageContext(), this.dYD.getResources().getString(n.j.plugin_video_install_tips), this.dYD.getResources().getString(n.j.plugin_go_install));
                                        return;
                                    }
                                    kVar9 = this.dYD.aso;
                                    kVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    kVar10 = this.dYD.aso;
                                    kVar10.b(aVar2);
                                    return;
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    kVar = this.dYD.aso;
                                    kVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    kVar2 = this.dYD.aso;
                                    kVar2.b(aVar4);
                                    writeData = this.dYD.dJy;
                                    writeData.setVideoInfo(null);
                                    this.dYD.aKN();
                                    editText = this.dYD.dUQ;
                                    if (editText != null) {
                                        editText3 = this.dYD.dUQ;
                                        editText3.requestFocus();
                                    }
                                    kVar3 = this.dYD.aso;
                                    kVar3.zK();
                                    kVar4 = this.dYD.aso;
                                    kVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.dYD;
                                    inputMethodManager = this.dYD.mInputManager;
                                    editText2 = this.dYD.dUQ;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.dYD.aKN();
                            return;
                        } else {
                            this.dYD.aMo();
                            this.dYD.aKN();
                            return;
                        }
                    } else {
                        aMc = this.dYD.aMc();
                        if (aMc) {
                            this.dYD.showToast(n.j.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                            this.dYD.a((com.baidu.tbadk.coreExtra.data.h) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.dYD.aMd();
                return;
            }
            aMc2 = this.dYD.aMc();
            if (aMc2) {
                this.dYD.showToast(n.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dYD.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
