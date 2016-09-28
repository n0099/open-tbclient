package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.l lVar;
        EditText bug;
        EditText buf;
        WriteData writeData;
        WriteData writeData2;
        com.baidu.tbadk.editortools.l lVar2;
        com.baidu.tbadk.editortools.l lVar3;
        WriteData writeData3;
        EditText editText;
        com.baidu.tbadk.editortools.l lVar4;
        com.baidu.tbadk.editortools.l lVar5;
        InputMethodManager inputMethodManager;
        EditText editText2;
        EditText editText3;
        WriteData writeData4;
        String str;
        WriteData writeData5;
        com.baidu.tbadk.editortools.l lVar6;
        com.baidu.tbadk.editortools.l lVar7;
        com.baidu.tbadk.editortools.l lVar8;
        com.baidu.tbadk.editortools.l lVar9;
        WriteData writeData6;
        com.baidu.tbadk.editortools.l lVar10;
        com.baidu.tbadk.editortools.l lVar11;
        WriteData writeData7;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean buc;
        boolean buc2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        this.ghD.d(aVar);
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.ghD.buh();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.ghD.avF = (VoiceData.VoiceModel) aVar.data;
                                this.ghD.bfL();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.ghD.avF = null;
                            this.ghD.bfL();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.ghD.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.ghD.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.ghD.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    WriteActivity writeActivity = this.ghD;
                                                    Activity pageActivity = this.ghD.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.ghD.writeImagesInfo;
                                                    writeActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(pageActivity, 12012, writeImagesInfo4, intValue)));
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
                                        additionData = this.ghD.ggM;
                                        if (additionData == null) {
                                            this.ghD.Dq();
                                            return;
                                        }
                                    }
                                    i = this.ghD.avR;
                                    switch (i) {
                                        case 0:
                                            Activity pageActivity2 = this.ghD.getPageContext().getPageActivity();
                                            if (com.baidu.tbadk.core.util.ag.Z(pageActivity2)) {
                                                this.ghD.Do();
                                                return;
                                            } else {
                                                com.baidu.tbadk.core.util.ag.c(pageActivity2, 0);
                                                return;
                                            }
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.ghD.Dn();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.ghD.dPf = null;
                                    } else {
                                        this.ghD.dPf = (String) aVar.data;
                                    }
                                    this.ghD.lR(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("xiaoying_has_click", true);
                                    com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c10645");
                                    writeData4 = this.ghD.flk;
                                    if (writeData4 != null) {
                                        writeData7 = this.ghD.flk;
                                        str = writeData7.getForumId();
                                    } else {
                                        str = "";
                                    }
                                    axVar.ab("fid", str);
                                    TiebaStatic.log(axVar);
                                    writeData5 = this.ghD.flk;
                                    if (writeData5 != null) {
                                        writeData6 = this.ghD.flk;
                                        VideoInfo videoInfo = writeData6.getVideoInfo();
                                        if (videoInfo != null && videoInfo.isAvaliable()) {
                                            lVar10 = this.ghD.atO;
                                            lVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                            com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                            lVar11 = this.ghD.atO;
                                            lVar11.b(aVar2);
                                            return;
                                        }
                                    }
                                    lVar6 = this.ghD.atO;
                                    lVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                    if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                            lVar7 = this.ghD.atO;
                                            if (lVar7.CJ()) {
                                                lVar8 = this.ghD.atO;
                                                lVar8.AV();
                                                lVar9 = this.ghD.atO;
                                                lVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            }
                                            XiaoyingUtil.startXiaoying(this.ghD.getActivity());
                                            return;
                                        }
                                        XiaoyingUtil.showGoPluginDetailDialog(this.ghD.getPageContext(), this.ghD.getResources().getString(r.j.plugin_video_not_active), this.ghD.getResources().getString(r.j.setup));
                                        return;
                                    }
                                    XiaoyingUtil.showGoPluginDetailDialog(this.ghD.getPageContext(), this.ghD.getResources().getString(r.j.plugin_video_install_tips), this.ghD.getResources().getString(r.j.plugin_go_install));
                                    return;
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    lVar2 = this.ghD.atO;
                                    lVar2.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    lVar3 = this.ghD.atO;
                                    lVar3.b(aVar4);
                                    writeData3 = this.ghD.flk;
                                    writeData3.setVideoInfo(null);
                                    this.ghD.bfL();
                                    editText = this.ghD.flH;
                                    if (editText != null) {
                                        editText3 = this.ghD.flH;
                                        editText3.requestFocus();
                                    }
                                    lVar4 = this.ghD.atO;
                                    lVar4.AV();
                                    lVar5 = this.ghD.atO;
                                    lVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    WriteActivity writeActivity2 = this.ghD;
                                    inputMethodManager = this.ghD.mInputManager;
                                    editText2 = this.ghD.flH;
                                    writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                                    return;
                                } else if (aVar.code == 40) {
                                    if ((aVar.data instanceof String) || aVar.data == null) {
                                        writeData = this.ghD.flk;
                                        if (writeData != null) {
                                            writeData2 = this.ghD.flk;
                                            writeData2.setGraffitiFileName((String) aVar.data);
                                            this.ghD.bfL();
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                } else if (aVar.code == 43) {
                                    com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("hot_topic_has_click", true);
                                    lVar = this.ghD.atO;
                                    lVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                                    this.ghD.ggx = true;
                                    this.ghD.bud();
                                    bug = this.ghD.bug();
                                    if (bug.isFocused()) {
                                        this.ghD.ggw = "from_title";
                                        return;
                                    }
                                    buf = this.ghD.buf();
                                    if (buf.isFocused()) {
                                        this.ghD.ggw = "from_content";
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.ghD.bfL();
                            return;
                        } else {
                            this.ghD.bup();
                            this.ghD.bfL();
                            return;
                        }
                    } else {
                        buc = this.ghD.buc();
                        if (buc) {
                            this.ghD.showToast(r.j.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                            this.ghD.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.ghD.bue();
                return;
            }
            buc2 = this.ghD.buc();
            if (buc2) {
                this.ghD.showToast(r.j.over_limit_tip);
            } else {
                this.ghD.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.ghD.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
