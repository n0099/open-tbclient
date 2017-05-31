package com.baidu.tieba.write.write;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        com.baidu.tbadk.editortools.j jVar;
        EditText bpW;
        EditText bpV;
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
        boolean bpU;
        boolean bpU2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14 || aVar.code == 48) {
                    this.gaR.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.gaR.bpX();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.gaR.aAy = (VoiceData.VoiceModel) aVar.data;
                            this.gaR.bed();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.gaR.aAy = null;
                        this.gaR.bed();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13 && aVar.code != 46 && aVar.code != 49) {
                        if (aVar.code == 15 || aVar.code == 47) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.gaR.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.gaR.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.gaR.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.gaR;
                                            Activity pageActivity = this.gaR.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.gaR.writeImagesInfo;
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
                                additionData = this.gaR.fZN;
                                if (additionData == null) {
                                    this.gaR.CR();
                                    return;
                                }
                            }
                            i = this.gaR.aAI;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.gaR.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.aC(pageActivity2)) {
                                        this.gaR.CP();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.gaR.CO();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.gaR.dJM = null;
                            } else {
                                this.gaR.dJM = (String) aVar.data;
                            }
                            this.gaR.mc(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10645");
                            writeData4 = this.gaR.mData;
                            if (writeData4 != null) {
                                writeData7 = this.gaR.mData;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            asVar.Z("fid", str);
                            TiebaStatic.log(asVar);
                            writeData5 = this.gaR.mData;
                            if (writeData5 != null) {
                                writeData6 = this.gaR.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.gaR.ayP;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.gaR.ayP;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.gaR.ayP;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.gaR.ayP;
                                    if (jVar7.Cp()) {
                                        jVar8 = this.gaR.ayP;
                                        jVar8.AG();
                                        jVar9 = this.gaR.ayP;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.gaR.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.gaR.getPageContext(), this.gaR.getResources().getString(w.l.plugin_video_not_active), this.gaR.getResources().getString(w.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.gaR.getPageContext(), this.gaR.getResources().getString(w.l.plugin_video_install_tips), this.gaR.getResources().getString(w.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.gaR.ayP;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.gaR.ayP;
                            jVar3.b(aVar4);
                            writeData3 = this.gaR.mData;
                            writeData3.setVideoInfo(null);
                            this.gaR.bed();
                            editText = this.gaR.fst;
                            if (editText != null) {
                                editText3 = this.gaR.fst;
                                editText3.requestFocus();
                            }
                            jVar4 = this.gaR.ayP;
                            jVar4.AG();
                            jVar5 = this.gaR.ayP;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.gaR;
                            inputMethodManager = this.gaR.mInputManager;
                            editText2 = this.gaR.fst;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.gaR.mData;
                                if (writeData != null) {
                                    writeData2 = this.gaR.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.gaR.bed();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                            jVar = this.gaR.ayP;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.gaR.fZy = true;
                            this.gaR.md(true);
                            bpW = this.gaR.bpW();
                            if (bpW.isFocused()) {
                                this.gaR.fZx = "from_title";
                                return;
                            }
                            bpV = this.gaR.bpV();
                            if (bpV.isFocused()) {
                                this.gaR.fZx = "from_content";
                                return;
                            }
                            return;
                        } else if (aVar.code == 45) {
                            linearLayout = this.gaR.dZL;
                            linearLayout.setVisibility(0);
                            linearLayout2 = this.gaR.dZL;
                            linearLayout2.requestFocus();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.gaR.bqf();
                        this.gaR.bed();
                        return;
                    }
                } else {
                    bpU = this.gaR.bpU();
                    if (bpU) {
                        this.gaR.showToast(w.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.gaR.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bpU2 = this.gaR.bpU();
            if (bpU2) {
                this.gaR.showToast(w.l.over_limit_tip);
            } else {
                this.gaR.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.gaR.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
