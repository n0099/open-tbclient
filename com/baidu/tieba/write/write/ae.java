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
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.ets = writeActivity;
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
        boolean aUW;
        boolean aUW2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.ets.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.ets.aVa();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.ets.auR = (VoiceData.VoiceModel) aVar.data;
                                this.ets.aTx();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.ets.auR = null;
                            this.ets.aTx();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.ets.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.ets.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.ets.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.ets.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.ets.writeImagesInfo;
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
                                        additionData = this.ets.esN;
                                        if (additionData == null) {
                                            this.ets.Dj();
                                            return;
                                        }
                                    }
                                    i = this.ets.avd;
                                    switch (i) {
                                        case 0:
                                            this.ets.Dh();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.ets.Dg();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.ets.cxU = null;
                                    } else {
                                        this.ets.cxU = (String) aVar.data;
                                    }
                                    this.ets.iG(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("xiaoying_has_click", true);
                                    com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10645");
                                    writeData2 = this.ets.dZC;
                                    if (writeData2 != null) {
                                        writeData4 = this.ets.dZC;
                                        str = writeData4.getForumId();
                                    } else {
                                        str = "";
                                    }
                                    auVar.aa(ImageViewerConfig.FORUM_ID, str);
                                    TiebaStatic.log(auVar);
                                    writeData3 = this.ets.dZC;
                                    VideoInfo videoInfo = writeData3.getVideoInfo();
                                    if (videoInfo == null || !videoInfo.isAvaliable()) {
                                        kVar5 = this.ets.ath;
                                        kVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                                            if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                kVar6 = this.ets.ath;
                                                if (kVar6.CC()) {
                                                    kVar7 = this.ets.ath;
                                                    kVar7.Ba();
                                                    kVar8 = this.ets.ath;
                                                    kVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                }
                                                XiaoyingUtil.startXiaoying(this.ets.getActivity());
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.ets.getPageContext(), this.ets.getResources().getString(t.j.plugin_video_not_active), this.ets.getResources().getString(t.j.setup));
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.ets.getPageContext(), this.ets.getResources().getString(t.j.plugin_video_install_tips), this.ets.getResources().getString(t.j.plugin_go_install));
                                        return;
                                    }
                                    kVar9 = this.ets.ath;
                                    kVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    kVar10 = this.ets.ath;
                                    kVar10.b(aVar2);
                                    return;
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    kVar = this.ets.ath;
                                    kVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    kVar2 = this.ets.ath;
                                    kVar2.b(aVar4);
                                    writeData = this.ets.dZC;
                                    writeData.setVideoInfo(null);
                                    this.ets.aTx();
                                    editText = this.ets.epv;
                                    if (editText != null) {
                                        editText3 = this.ets.epv;
                                        editText3.requestFocus();
                                    }
                                    kVar3 = this.ets.ath;
                                    kVar3.Ba();
                                    kVar4 = this.ets.ath;
                                    kVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.ets;
                                    inputMethodManager = this.ets.mInputManager;
                                    editText2 = this.ets.epv;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.ets.aTx();
                            return;
                        } else {
                            this.ets.aVi();
                            this.ets.aTx();
                            return;
                        }
                    } else {
                        aUW = this.ets.aUW();
                        if (aUW) {
                            this.ets.showToast(t.j.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                            this.ets.b((com.baidu.tbadk.coreExtra.data.h) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.ets.aUX();
                return;
            }
            aUW2 = this.ets.aUW();
            if (aUW2) {
                this.ets.showToast(t.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ets.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
