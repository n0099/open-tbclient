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
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        EditText bqt;
        EditText bqs;
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
        boolean bqr;
        boolean bqr2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14) {
                    this.fUM.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.fUM.bqu();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.fUM.aAO = (VoiceData.VoiceModel) aVar.data;
                            this.fUM.bfg();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.fUM.aAO = null;
                        this.fUM.bfg();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13) {
                        if (aVar.code == 15) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.fUM.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.fUM.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.fUM.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.fUM;
                                            Activity pageActivity = this.fUM.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.fUM.writeImagesInfo;
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
                                additionData = this.fUM.fTN;
                                if (additionData == null) {
                                    this.fUM.DT();
                                    return;
                                }
                            }
                            i = this.fUM.aAY;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.fUM.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.az(pageActivity2)) {
                                        this.fUM.DR();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.fUM.DQ();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.fUM.dJR = null;
                            } else {
                                this.fUM.dJR = (String) aVar.data;
                            }
                            this.fUM.ma(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10645");
                            writeData4 = this.fUM.mData;
                            if (writeData4 != null) {
                                writeData7 = this.fUM.mData;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            asVar.aa("fid", str);
                            TiebaStatic.log(asVar);
                            writeData5 = this.fUM.mData;
                            if (writeData5 != null) {
                                writeData6 = this.fUM.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.fUM.azf;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.fUM.azf;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.fUM.azf;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.fUM.azf;
                                    if (jVar7.Dq()) {
                                        jVar8 = this.fUM.azf;
                                        jVar8.BC();
                                        jVar9 = this.fUM.azf;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.fUM.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.fUM.getPageContext(), this.fUM.getResources().getString(w.l.plugin_video_not_active), this.fUM.getResources().getString(w.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.fUM.getPageContext(), this.fUM.getResources().getString(w.l.plugin_video_install_tips), this.fUM.getResources().getString(w.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.fUM.azf;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.fUM.azf;
                            jVar3.b(aVar4);
                            writeData3 = this.fUM.mData;
                            writeData3.setVideoInfo(null);
                            this.fUM.bfg();
                            editText = this.fUM.foA;
                            if (editText != null) {
                                editText3 = this.fUM.foA;
                                editText3.requestFocus();
                            }
                            jVar4 = this.fUM.azf;
                            jVar4.BC();
                            jVar5 = this.fUM.azf;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.fUM;
                            inputMethodManager = this.fUM.mInputManager;
                            editText2 = this.fUM.foA;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.fUM.mData;
                                if (writeData != null) {
                                    writeData2 = this.fUM.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.fUM.bfg();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("hot_topic_has_click", true);
                            jVar = this.fUM.azf;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.fUM.fTy = true;
                            this.fUM.mb(true);
                            bqt = this.fUM.bqt();
                            if (bqt.isFocused()) {
                                this.fUM.fTx = "from_title";
                                return;
                            }
                            bqs = this.fUM.bqs();
                            if (bqs.isFocused()) {
                                this.fUM.fTx = "from_content";
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.fUM.bqC();
                        this.fUM.bfg();
                        return;
                    }
                } else {
                    bqr = this.fUM.bqr();
                    if (bqr) {
                        this.fUM.showToast(w.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.fUM.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bqr2 = this.fUM.bqr();
            if (bqr2) {
                this.fUM.showToast(w.l.over_limit_tip);
            } else {
                this.fUM.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fUM.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
