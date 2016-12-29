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
public class ad implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        EditText bnx;
        EditText bnw;
        WriteData writeData;
        WriteData writeData2;
        com.baidu.tbadk.editortools.j jVar2;
        com.baidu.tbadk.editortools.j jVar3;
        WriteData writeData3;
        EditText editText;
        com.baidu.tbadk.editortools.j jVar4;
        com.baidu.tbadk.editortools.j jVar5;
        InputMethodManager inputMethodManager;
        EditText editText2;
        EditText editText3;
        WriteData writeData4;
        String str;
        WriteData writeData5;
        com.baidu.tbadk.editortools.j jVar6;
        com.baidu.tbadk.editortools.j jVar7;
        com.baidu.tbadk.editortools.j jVar8;
        com.baidu.tbadk.editortools.j jVar9;
        WriteData writeData6;
        com.baidu.tbadk.editortools.j jVar10;
        com.baidu.tbadk.editortools.j jVar11;
        WriteData writeData7;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean bnv;
        boolean bnv2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14) {
                    this.fDQ.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.fDQ.bny();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.fDQ.avW = (VoiceData.VoiceModel) aVar.data;
                            this.fDQ.bbU();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.fDQ.avW = null;
                        this.fDQ.bbU();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13) {
                        if (aVar.code == 15) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.fDQ.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.fDQ.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.fDQ.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.fDQ;
                                            Activity pageActivity = this.fDQ.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.fDQ.writeImagesInfo;
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
                                additionData = this.fDQ.fCT;
                                if (additionData == null) {
                                    this.fDQ.Dh();
                                    return;
                                }
                            }
                            i = this.fDQ.awh;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.fDQ.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.X(pageActivity2)) {
                                        this.fDQ.Df();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.fDQ.De();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.fDQ.dzm = null;
                            } else {
                                this.fDQ.dzm = (String) aVar.data;
                            }
                            this.fDQ.lF(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10645");
                            writeData4 = this.fDQ.eWm;
                            if (writeData4 != null) {
                                writeData7 = this.fDQ.eWm;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            atVar.ab("fid", str);
                            TiebaStatic.log(atVar);
                            writeData5 = this.fDQ.eWm;
                            if (writeData5 != null) {
                                writeData6 = this.fDQ.eWm;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.fDQ.aun;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.fDQ.aun;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.fDQ.aun;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.fDQ.aun;
                                    if (jVar7.CE()) {
                                        jVar8 = this.fDQ.aun;
                                        jVar8.AP();
                                        jVar9 = this.fDQ.aun;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.fDQ.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.fDQ.getPageContext(), this.fDQ.getResources().getString(r.j.plugin_video_not_active), this.fDQ.getResources().getString(r.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.fDQ.getPageContext(), this.fDQ.getResources().getString(r.j.plugin_video_install_tips), this.fDQ.getResources().getString(r.j.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.fDQ.aun;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.fDQ.aun;
                            jVar3.b(aVar4);
                            writeData3 = this.fDQ.eWm;
                            writeData3.setVideoInfo(null);
                            this.fDQ.bbU();
                            editText = this.fDQ.eWJ;
                            if (editText != null) {
                                editText3 = this.fDQ.eWJ;
                                editText3.requestFocus();
                            }
                            jVar4 = this.fDQ.aun;
                            jVar4.AP();
                            jVar5 = this.fDQ.aun;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.fDQ;
                            inputMethodManager = this.fDQ.mInputManager;
                            editText2 = this.fDQ.eWJ;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.fDQ.eWm;
                                if (writeData != null) {
                                    writeData2 = this.fDQ.eWm;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.fDQ.bbU();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("hot_topic_has_click", true);
                            jVar = this.fDQ.aun;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.fDQ.fCE = true;
                            this.fDQ.lG(true);
                            bnx = this.fDQ.bnx();
                            if (bnx.isFocused()) {
                                this.fDQ.fCD = "from_title";
                                return;
                            }
                            bnw = this.fDQ.bnw();
                            if (bnw.isFocused()) {
                                this.fDQ.fCD = "from_content";
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.fDQ.bnH();
                        this.fDQ.bbU();
                        return;
                    }
                } else {
                    bnv = this.fDQ.bnv();
                    if (bnv) {
                        this.fDQ.showToast(r.j.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.fDQ.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bnv2 = this.fDQ.bnv();
            if (bnv2) {
                this.fDQ.showToast(r.j.over_limit_tip);
            } else {
                this.fDQ.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fDQ.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
