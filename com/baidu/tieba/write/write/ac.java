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
public class ac implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        EditText boV;
        EditText boU;
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
        boolean boT;
        boolean boT2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14) {
                    this.fMl.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.fMl.boW();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.fMl.avb = (VoiceData.VoiceModel) aVar.data;
                            this.fMl.bdH();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.fMl.avb = null;
                        this.fMl.bdH();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13) {
                        if (aVar.code == 15) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.fMl.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.fMl.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.fMl.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.fMl;
                                            Activity pageActivity = this.fMl.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.fMl.writeImagesInfo;
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
                                additionData = this.fMl.fLo;
                                if (additionData == null) {
                                    this.fMl.Dc();
                                    return;
                                }
                            }
                            i = this.fMl.avl;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.fMl.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ad.Z(pageActivity2)) {
                                        this.fMl.Da();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ad.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.fMl.CZ();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.fMl.dIu = null;
                            } else {
                                this.fMl.dIu = (String) aVar.data;
                            }
                            this.fMl.lO(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10645");
                            writeData4 = this.fMl.mData;
                            if (writeData4 != null) {
                                writeData7 = this.fMl.mData;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            arVar.ab("fid", str);
                            TiebaStatic.log(arVar);
                            writeData5 = this.fMl.mData;
                            if (writeData5 != null) {
                                writeData6 = this.fMl.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.fMl.ats;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.fMl.ats;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.fMl.ats;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.fMl.ats;
                                    if (jVar7.Cz()) {
                                        jVar8 = this.fMl.ats;
                                        jVar8.AK();
                                        jVar9 = this.fMl.ats;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.fMl.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.fMl.getPageContext(), this.fMl.getResources().getString(r.l.plugin_video_not_active), this.fMl.getResources().getString(r.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.fMl.getPageContext(), this.fMl.getResources().getString(r.l.plugin_video_install_tips), this.fMl.getResources().getString(r.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.fMl.ats;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.fMl.ats;
                            jVar3.b(aVar4);
                            writeData3 = this.fMl.mData;
                            writeData3.setVideoInfo(null);
                            this.fMl.bdH();
                            editText = this.fMl.fgd;
                            if (editText != null) {
                                editText3 = this.fMl.fgd;
                                editText3.requestFocus();
                            }
                            jVar4 = this.fMl.ats;
                            jVar4.AK();
                            jVar5 = this.fMl.ats;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.fMl;
                            inputMethodManager = this.fMl.mInputManager;
                            editText2 = this.fMl.fgd;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.fMl.mData;
                                if (writeData != null) {
                                    writeData2 = this.fMl.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.fMl.bdH();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("hot_topic_has_click", true);
                            jVar = this.fMl.ats;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.fMl.fKZ = true;
                            this.fMl.lP(true);
                            boV = this.fMl.boV();
                            if (boV.isFocused()) {
                                this.fMl.fKY = "from_title";
                                return;
                            }
                            boU = this.fMl.boU();
                            if (boU.isFocused()) {
                                this.fMl.fKY = "from_content";
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.fMl.bpf();
                        this.fMl.bdH();
                        return;
                    }
                } else {
                    boT = this.fMl.boT();
                    if (boT) {
                        this.fMl.showToast(r.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.fMl.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            boT2 = this.fMl.boT();
            if (boT2) {
                this.fMl.showToast(r.l.over_limit_tip);
            } else {
                this.fMl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fMl.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
