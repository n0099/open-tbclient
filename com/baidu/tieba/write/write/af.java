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
public class af implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.eNd = writeActivity;
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
        com.baidu.tbadk.editortools.l lVar9;
        com.baidu.tbadk.editortools.l lVar10;
        WriteData writeData6;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean bbw;
        boolean bbw2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.eNd.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.eNd.bbA();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.eNd.avr = (VoiceData.VoiceModel) aVar.data;
                                this.eNd.aZX();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.eNd.avr = null;
                            this.eNd.aZX();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.eNd.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.eNd.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.eNd.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity = this.eNd.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.eNd.writeImagesInfo;
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
                                        additionData = this.eNd.eMy;
                                        if (additionData == null) {
                                            this.eNd.DS();
                                            return;
                                        }
                                    }
                                    i = this.eNd.avD;
                                    switch (i) {
                                        case 0:
                                            Activity pageActivity2 = this.eNd.getPageContext().getPageActivity();
                                            if (com.baidu.tbadk.core.util.ag.R(pageActivity2)) {
                                                this.eNd.DQ();
                                                return;
                                            } else {
                                                com.baidu.tbadk.core.util.ag.a(pageActivity2, 0);
                                                return;
                                            }
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.eNd.DO();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.eNd.cRp = null;
                                    } else {
                                        this.eNd.cRp = (String) aVar.data;
                                    }
                                    this.eNd.jw(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("xiaoying_has_click", true);
                                    com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10645");
                                    writeData4 = this.eNd.esv;
                                    if (writeData4 != null) {
                                        writeData6 = this.eNd.esv;
                                        str = writeData6.getForumId();
                                    } else {
                                        str = "";
                                    }
                                    awVar.ac("fid", str);
                                    TiebaStatic.log(awVar);
                                    writeData5 = this.eNd.esv;
                                    VideoInfo videoInfo = writeData5.getVideoInfo();
                                    if (videoInfo == null || !videoInfo.isAvaliable()) {
                                        lVar5 = this.eNd.atG;
                                        lVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                        if (XiaoyingUtil.isXiaoyingInstalled()) {
                                            if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                lVar6 = this.eNd.atG;
                                                if (lVar6.Dk()) {
                                                    lVar7 = this.eNd.atG;
                                                    lVar7.BD();
                                                    lVar8 = this.eNd.atG;
                                                    lVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                }
                                                XiaoyingUtil.startXiaoying(this.eNd.getActivity());
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.eNd.getPageContext(), this.eNd.getResources().getString(t.j.plugin_video_not_active), this.eNd.getResources().getString(t.j.setup));
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.eNd.getPageContext(), this.eNd.getResources().getString(t.j.plugin_video_install_tips), this.eNd.getResources().getString(t.j.plugin_go_install));
                                        return;
                                    }
                                    lVar9 = this.eNd.atG;
                                    lVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    lVar10 = this.eNd.atG;
                                    lVar10.b(aVar2);
                                    return;
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    lVar = this.eNd.atG;
                                    lVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    lVar2 = this.eNd.atG;
                                    lVar2.b(aVar4);
                                    writeData3 = this.eNd.esv;
                                    writeData3.setVideoInfo(null);
                                    this.eNd.aZX();
                                    editText = this.eNd.eJr;
                                    if (editText != null) {
                                        editText3 = this.eNd.eJr;
                                        editText3.requestFocus();
                                    }
                                    lVar3 = this.eNd.atG;
                                    lVar3.BD();
                                    lVar4 = this.eNd.atG;
                                    lVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity = this.eNd;
                                    inputMethodManager = this.eNd.mInputManager;
                                    editText2 = this.eNd.eJr;
                                    writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else if (aVar.code == 40) {
                                    if ((aVar.data instanceof String) || aVar.data == null) {
                                        writeData = this.eNd.esv;
                                        if (writeData != null) {
                                            writeData2 = this.eNd.esv;
                                            writeData2.setGraffitiFileName((String) aVar.data);
                                            this.eNd.aZX();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.eNd.aZX();
                            return;
                        } else {
                            this.eNd.bbI();
                            this.eNd.aZX();
                            return;
                        }
                    } else {
                        bbw = this.eNd.bbw();
                        if (bbw) {
                            this.eNd.showToast(t.j.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.h)) {
                            this.eNd.b((com.baidu.tbadk.coreExtra.data.h) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.eNd.bbx();
                return;
            }
            bbw2 = this.eNd.bbw();
            if (bbw2) {
                this.eNd.showToast(t.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.eNd.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
