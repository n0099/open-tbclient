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
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.dRf = writeActivity;
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
        boolean aJH;
        boolean aJH2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.dRf.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.dRf.aJL();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.dRf.asv = (VoiceData.VoiceModel) aVar.data;
                                this.dRf.aIs();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.dRf.asv = null;
                            this.dRf.aIs();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.dRf.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.dRf.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.dRf.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.dRf.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.dRf.writeImagesInfo;
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
                                        additionData = this.dRf.dQw;
                                        if (additionData == null) {
                                            this.dRf.Ce();
                                            return;
                                        }
                                    }
                                    i = this.dRf.asH;
                                    switch (i) {
                                        case 0:
                                            this.dRf.Cc();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.dRf.Cb();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.dRf.cnl = null;
                                    } else {
                                        this.dRf.cnl = (String) aVar.data;
                                    }
                                    this.dRf.hM(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("xiaoying_has_click", true);
                                    com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10645");
                                    writeData2 = this.dRf.dBW;
                                    if (writeData2 != null) {
                                        writeData4 = this.dRf.dBW;
                                        str = writeData4.getForumId();
                                    } else {
                                        str = "";
                                    }
                                    avVar.ab(ImageViewerConfig.FORUM_ID, str);
                                    TiebaStatic.log(avVar);
                                    writeData3 = this.dRf.dBW;
                                    VideoInfo videoInfo = writeData3.getVideoInfo();
                                    if (videoInfo == null || !videoInfo.isAvaliable()) {
                                        kVar5 = this.dRf.aqK;
                                        kVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                                            if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                kVar6 = this.dRf.aqK;
                                                if (kVar6.Bx()) {
                                                    kVar7 = this.dRf.aqK;
                                                    kVar7.zY();
                                                    kVar8 = this.dRf.aqK;
                                                    kVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                }
                                                XiaoyingUtil.startXiaoying(this.dRf.getActivity());
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.dRf.getPageContext(), this.dRf.getResources().getString(n.i.plugin_video_not_active), this.dRf.getResources().getString(n.i.setup));
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.dRf.getPageContext(), this.dRf.getResources().getString(n.i.plugin_video_install_tips), this.dRf.getResources().getString(n.i.plugin_go_install));
                                        return;
                                    }
                                    kVar9 = this.dRf.aqK;
                                    kVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    kVar10 = this.dRf.aqK;
                                    kVar10.b(aVar2);
                                    return;
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    kVar = this.dRf.aqK;
                                    kVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    kVar2 = this.dRf.aqK;
                                    kVar2.b(aVar4);
                                    writeData = this.dRf.dBW;
                                    writeData.setVideoInfo(null);
                                    this.dRf.aIs();
                                    editText = this.dRf.dNr;
                                    if (editText != null) {
                                        editText3 = this.dRf.dNr;
                                        editText3.requestFocus();
                                    }
                                    kVar3 = this.dRf.aqK;
                                    kVar3.zY();
                                    kVar4 = this.dRf.aqK;
                                    kVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.dRf;
                                    inputMethodManager = this.dRf.mInputManager;
                                    editText2 = this.dRf.dNr;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.dRf.aIs();
                            return;
                        } else {
                            this.dRf.aJT();
                            this.dRf.aIs();
                            return;
                        }
                    } else {
                        aJH = this.dRf.aJH();
                        if (aJH) {
                            this.dRf.showToast(n.i.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                            this.dRf.a((com.baidu.tbadk.coreExtra.data.h) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.dRf.aJI();
                return;
            }
            aJH2 = this.dRf.aJH();
            if (aJH2) {
                this.dRf.showToast(n.i.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.dRf.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
