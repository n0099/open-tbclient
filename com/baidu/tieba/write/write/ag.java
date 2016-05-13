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
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.fea = writeActivity;
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
        boolean bdQ;
        boolean bdQ2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code != 43) {
                        if (aVar.code != 45) {
                            if (aVar.code == 14) {
                                this.fea.d(aVar);
                                return;
                            } else if (aVar.code != 24) {
                                if (aVar.code == 3) {
                                    this.fea.bdW();
                                    return;
                                } else if (aVar.code == 10) {
                                    if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                        this.fea.arq = (VoiceData.VoiceModel) aVar.data;
                                        this.fea.bcq();
                                        return;
                                    }
                                    return;
                                } else if (aVar.code == 11) {
                                    this.fea.arq = null;
                                    this.fea.bcq();
                                    return;
                                } else if (aVar.code != 12 && aVar.code != 13) {
                                    if (aVar.code != 22 && aVar.code != 23) {
                                        if (aVar.code == 15) {
                                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                                int intValue = ((Integer) aVar.data).intValue();
                                                writeImagesInfo = this.fea.writeImagesInfo;
                                                if (writeImagesInfo != null) {
                                                    writeImagesInfo2 = this.fea.writeImagesInfo;
                                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                                        writeImagesInfo3 = this.fea.writeImagesInfo;
                                                        int size = writeImagesInfo3.getChosedFiles().size();
                                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                                            MessageManager messageManager = MessageManager.getInstance();
                                                            Activity pageActivity = this.fea.getPageContext().getPageActivity();
                                                            writeImagesInfo4 = this.fea.writeImagesInfo;
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
                                                additionData = this.fea.fdn;
                                                if (additionData == null) {
                                                    this.fea.BM();
                                                    return;
                                                }
                                            }
                                            i = this.fea.arC;
                                            switch (i) {
                                                case 0:
                                                    Activity pageActivity2 = this.fea.getPageContext().getPageActivity();
                                                    if (com.baidu.tbadk.core.util.ag.Q(pageActivity2)) {
                                                        this.fea.BK();
                                                        return;
                                                    } else {
                                                        com.baidu.tbadk.core.util.ag.a(pageActivity2, 0);
                                                        return;
                                                    }
                                                case 1:
                                                default:
                                                    return;
                                                case 2:
                                                    this.fea.BJ();
                                                    return;
                                            }
                                        } else if (aVar.code == 25) {
                                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                                this.fea.cSm = null;
                                            } else {
                                                this.fea.cSm = (String) aVar.data;
                                            }
                                            this.fea.kB(false);
                                            return;
                                        } else if (aVar.code == 27) {
                                            com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("xiaoying_has_click", true);
                                            com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10645");
                                            writeData4 = this.fea.evE;
                                            if (writeData4 != null) {
                                                writeData7 = this.fea.evE;
                                                str = writeData7.getForumId();
                                            } else {
                                                str = "";
                                            }
                                            awVar.ac("fid", str);
                                            TiebaStatic.log(awVar);
                                            writeData5 = this.fea.evE;
                                            if (writeData5 != null) {
                                                writeData6 = this.fea.evE;
                                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                                    lVar9 = this.fea.apy;
                                                    lVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                                    lVar10 = this.fea.apy;
                                                    lVar10.b(aVar2);
                                                    return;
                                                }
                                            }
                                            lVar5 = this.fea.apy;
                                            lVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                    lVar6 = this.fea.apy;
                                                    if (lVar6.Bf()) {
                                                        lVar7 = this.fea.apy;
                                                        lVar7.zy();
                                                        lVar8 = this.fea.apy;
                                                        lVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                    }
                                                    XiaoyingUtil.startXiaoying(this.fea.getActivity());
                                                    return;
                                                }
                                                XiaoyingUtil.showGoPluginDetailDialog(this.fea.getPageContext(), this.fea.getResources().getString(t.j.plugin_video_not_active), this.fea.getResources().getString(t.j.setup));
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.fea.getPageContext(), this.fea.getResources().getString(t.j.plugin_video_install_tips), this.fea.getResources().getString(t.j.plugin_go_install));
                                            return;
                                        } else if (aVar.code == 29) {
                                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                            lVar = this.fea.apy;
                                            lVar.b(aVar3);
                                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                            lVar2 = this.fea.apy;
                                            lVar2.b(aVar4);
                                            writeData3 = this.fea.evE;
                                            writeData3.setVideoInfo(null);
                                            this.fea.bcq();
                                            editText = this.fea.fah;
                                            if (editText != null) {
                                                editText3 = this.fea.fah;
                                                editText3.requestFocus();
                                            }
                                            lVar3 = this.fea.apy;
                                            lVar3.zy();
                                            lVar4 = this.fea.apy;
                                            lVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            WriteActivity writeActivity = this.fea;
                                            inputMethodManager = this.fea.mInputManager;
                                            editText2 = this.fea.fah;
                                            writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                            return;
                                        } else if (aVar.code == 40) {
                                            if ((aVar.data instanceof String) || aVar.data == null) {
                                                writeData = this.fea.evE;
                                                if (writeData != null) {
                                                    writeData2 = this.fea.evE;
                                                    writeData2.setGraffitiFileName((String) aVar.data);
                                                    this.fea.bcq();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    this.fea.bcq();
                                    return;
                                } else {
                                    this.fea.bee();
                                    this.fea.bcq();
                                    return;
                                }
                            } else {
                                bdQ = this.fea.bdQ();
                                if (bdQ) {
                                    this.fea.showToast(t.j.over_limit_tip);
                                    return;
                                } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                                    this.fea.b((com.baidu.tbadk.coreExtra.data.h) aVar.data);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        this.fea.bdS();
                        return;
                    }
                    this.fea.bdT();
                    return;
                }
                this.fea.bdR();
                return;
            }
            bdQ2 = this.fea.bdQ();
            if (bdQ2) {
                this.fea.showToast(t.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fea.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
