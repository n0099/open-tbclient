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
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        WriteData writeData;
        WriteData writeData2;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        WriteData writeData3;
        EditText editText;
        com.baidu.tbadk.editortools.l lVar3;
        com.baidu.tbadk.editortools.l lVar4;
        InputMethodManager inputMethodManager;
        EditText editText2;
        EditText editText3;
        WriteData writeData4;
        String str;
        WriteData writeData5;
        com.baidu.tbadk.editortools.l lVar5;
        com.baidu.tbadk.editortools.l lVar6;
        com.baidu.tbadk.editortools.l lVar7;
        com.baidu.tbadk.editortools.l lVar8;
        WriteData writeData6;
        com.baidu.tbadk.editortools.l lVar9;
        com.baidu.tbadk.editortools.l lVar10;
        WriteData writeData7;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean bdJ;
        boolean bdJ2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code != 43) {
                        if (aVar.code != 45) {
                            if (aVar.code == 14) {
                                this.feb.d(aVar);
                                return;
                            } else if (aVar.code != 24) {
                                if (aVar.code == 3) {
                                    this.feb.bdP();
                                    return;
                                } else if (aVar.code == 10) {
                                    if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                        this.feb.arq = (VoiceData.VoiceModel) aVar.data;
                                        this.feb.bcj();
                                        return;
                                    }
                                    return;
                                } else if (aVar.code == 11) {
                                    this.feb.arq = null;
                                    this.feb.bcj();
                                    return;
                                } else if (aVar.code != 12 && aVar.code != 13) {
                                    if (aVar.code != 22 && aVar.code != 23) {
                                        if (aVar.code == 15) {
                                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                                int intValue = ((Integer) aVar.data).intValue();
                                                writeImagesInfo = this.feb.writeImagesInfo;
                                                if (writeImagesInfo != null) {
                                                    writeImagesInfo2 = this.feb.writeImagesInfo;
                                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                                        writeImagesInfo3 = this.feb.writeImagesInfo;
                                                        int size = writeImagesInfo3.getChosedFiles().size();
                                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                                            MessageManager messageManager = MessageManager.getInstance();
                                                            Activity pageActivity = this.feb.getPageContext().getPageActivity();
                                                            writeImagesInfo4 = this.feb.writeImagesInfo;
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
                                                additionData = this.feb.fdo;
                                                if (additionData == null) {
                                                    this.feb.BL();
                                                    return;
                                                }
                                            }
                                            i = this.feb.arC;
                                            switch (i) {
                                                case 0:
                                                    Activity pageActivity2 = this.feb.getPageContext().getPageActivity();
                                                    if (com.baidu.tbadk.core.util.ag.Q(pageActivity2)) {
                                                        this.feb.BJ();
                                                        return;
                                                    } else {
                                                        com.baidu.tbadk.core.util.ag.a(pageActivity2, 0);
                                                        return;
                                                    }
                                                case 1:
                                                default:
                                                    return;
                                                case 2:
                                                    this.feb.BI();
                                                    return;
                                            }
                                        } else if (aVar.code == 25) {
                                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                                this.feb.cSm = null;
                                            } else {
                                                this.feb.cSm = (String) aVar.data;
                                            }
                                            this.feb.kB(false);
                                            return;
                                        } else if (aVar.code == 27) {
                                            com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("xiaoying_has_click", true);
                                            com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10645");
                                            writeData4 = this.feb.evE;
                                            if (writeData4 != null) {
                                                writeData7 = this.feb.evE;
                                                str = writeData7.getForumId();
                                            } else {
                                                str = "";
                                            }
                                            awVar.ac("fid", str);
                                            TiebaStatic.log(awVar);
                                            writeData5 = this.feb.evE;
                                            if (writeData5 != null) {
                                                writeData6 = this.feb.evE;
                                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                                    lVar9 = this.feb.apy;
                                                    lVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                                    lVar10 = this.feb.apy;
                                                    lVar10.b(aVar2);
                                                    return;
                                                }
                                            }
                                            lVar5 = this.feb.apy;
                                            lVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                    lVar6 = this.feb.apy;
                                                    if (lVar6.Be()) {
                                                        lVar7 = this.feb.apy;
                                                        lVar7.zx();
                                                        lVar8 = this.feb.apy;
                                                        lVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                    }
                                                    XiaoyingUtil.startXiaoying(this.feb.getActivity());
                                                    return;
                                                }
                                                XiaoyingUtil.showGoPluginDetailDialog(this.feb.getPageContext(), this.feb.getResources().getString(t.j.plugin_video_not_active), this.feb.getResources().getString(t.j.setup));
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.feb.getPageContext(), this.feb.getResources().getString(t.j.plugin_video_install_tips), this.feb.getResources().getString(t.j.plugin_go_install));
                                            return;
                                        } else if (aVar.code == 29) {
                                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                            lVar = this.feb.apy;
                                            lVar.b(aVar3);
                                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                            lVar2 = this.feb.apy;
                                            lVar2.b(aVar4);
                                            writeData3 = this.feb.evE;
                                            writeData3.setVideoInfo(null);
                                            this.feb.bcj();
                                            editText = this.feb.fai;
                                            if (editText != null) {
                                                editText3 = this.feb.fai;
                                                editText3.requestFocus();
                                            }
                                            lVar3 = this.feb.apy;
                                            lVar3.zx();
                                            lVar4 = this.feb.apy;
                                            lVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            WriteActivity writeActivity = this.feb;
                                            inputMethodManager = this.feb.mInputManager;
                                            editText2 = this.feb.fai;
                                            writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                            return;
                                        } else if (aVar.code == 40) {
                                            if ((aVar.data instanceof String) || aVar.data == null) {
                                                writeData = this.feb.evE;
                                                if (writeData != null) {
                                                    writeData2 = this.feb.evE;
                                                    writeData2.setGraffitiFileName((String) aVar.data);
                                                    this.feb.bcj();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    this.feb.bcj();
                                    return;
                                } else {
                                    this.feb.bdX();
                                    this.feb.bcj();
                                    return;
                                }
                            } else {
                                bdJ = this.feb.bdJ();
                                if (bdJ) {
                                    this.feb.showToast(t.j.over_limit_tip);
                                    return;
                                } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                                    this.feb.b((com.baidu.tbadk.coreExtra.data.h) aVar.data);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        this.feb.bdL();
                        return;
                    }
                    this.feb.bdM();
                    return;
                }
                this.feb.bdK();
                return;
            }
            bdJ2 = this.feb.bdJ();
            if (bdJ2) {
                this.feb.showToast(t.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.feb.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
