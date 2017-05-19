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
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.fSV = writeActivity;
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
        EditText box;
        EditText bow;
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
        boolean bov;
        boolean bov2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14 || aVar.code == 48) {
                    this.fSV.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.fSV.boy();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.fSV.aAM = (VoiceData.VoiceModel) aVar.data;
                            this.fSV.bcJ();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.fSV.aAM = null;
                        this.fSV.bcJ();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13 && aVar.code != 46 && aVar.code != 49) {
                        if (aVar.code == 15 || aVar.code == 47) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.fSV.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.fSV.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.fSV.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.fSV;
                                            Activity pageActivity = this.fSV.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.fSV.writeImagesInfo;
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
                                additionData = this.fSV.fRR;
                                if (additionData == null) {
                                    this.fSV.CX();
                                    return;
                                }
                            }
                            i = this.fSV.aAW;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.fSV.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.aC(pageActivity2)) {
                                        this.fSV.CV();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.fSV.CU();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.fSV.dEo = null;
                            } else {
                                this.fSV.dEo = (String) aVar.data;
                            }
                            this.fSV.lJ(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10645");
                            writeData4 = this.fSV.mData;
                            if (writeData4 != null) {
                                writeData7 = this.fSV.mData;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            asVar.aa("fid", str);
                            TiebaStatic.log(asVar);
                            writeData5 = this.fSV.mData;
                            if (writeData5 != null) {
                                writeData6 = this.fSV.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.fSV.azd;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.fSV.azd;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.fSV.azd;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.fSV.azd;
                                    if (jVar7.Cv()) {
                                        jVar8 = this.fSV.azd;
                                        jVar8.AN();
                                        jVar9 = this.fSV.azd;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.fSV.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.fSV.getPageContext(), this.fSV.getResources().getString(w.l.plugin_video_not_active), this.fSV.getResources().getString(w.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.fSV.getPageContext(), this.fSV.getResources().getString(w.l.plugin_video_install_tips), this.fSV.getResources().getString(w.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.fSV.azd;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.fSV.azd;
                            jVar3.b(aVar4);
                            writeData3 = this.fSV.mData;
                            writeData3.setVideoInfo(null);
                            this.fSV.bcJ();
                            editText = this.fSV.fkB;
                            if (editText != null) {
                                editText3 = this.fSV.fkB;
                                editText3.requestFocus();
                            }
                            jVar4 = this.fSV.azd;
                            jVar4.AN();
                            jVar5 = this.fSV.azd;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.fSV;
                            inputMethodManager = this.fSV.mInputManager;
                            editText2 = this.fSV.fkB;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.fSV.mData;
                                if (writeData != null) {
                                    writeData2 = this.fSV.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.fSV.bcJ();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("hot_topic_has_click", true);
                            jVar = this.fSV.azd;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.fSV.fRC = true;
                            this.fSV.lK(true);
                            box = this.fSV.box();
                            if (box.isFocused()) {
                                this.fSV.fRB = "from_title";
                                return;
                            }
                            bow = this.fSV.bow();
                            if (bow.isFocused()) {
                                this.fSV.fRB = "from_content";
                                return;
                            }
                            return;
                        } else if (aVar.code == 45) {
                            linearLayout = this.fSV.dUp;
                            linearLayout.setVisibility(0);
                            linearLayout2 = this.fSV.dUp;
                            linearLayout2.requestFocus();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.fSV.boG();
                        this.fSV.bcJ();
                        return;
                    }
                } else {
                    bov = this.fSV.bov();
                    if (bov) {
                        this.fSV.showToast(w.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.fSV.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bov2 = this.fSV.bov();
            if (bov2) {
                this.fSV.showToast(w.l.over_limit_tip);
            } else {
                this.fSV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fSV.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
