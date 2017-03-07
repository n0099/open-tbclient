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
public class ac implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        EditText boJ;
        EditText boI;
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
        boolean boH;
        boolean boH2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14) {
                    this.fQG.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.fQG.boK();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.fQG.aAw = (VoiceData.VoiceModel) aVar.data;
                            this.fQG.bds();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.fQG.aAw = null;
                        this.fQG.bds();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13) {
                        if (aVar.code == 15) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.fQG.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.fQG.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.fQG.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.fQG;
                                            Activity pageActivity = this.fQG.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.fQG.writeImagesInfo;
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
                                additionData = this.fQG.fPH;
                                if (additionData == null) {
                                    this.fQG.Dv();
                                    return;
                                }
                            }
                            i = this.fQG.aAG;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.fQG.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.ax(pageActivity2)) {
                                        this.fQG.Dt();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.fQG.Ds();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.fQG.dLc = null;
                            } else {
                                this.fQG.dLc = (String) aVar.data;
                            }
                            this.fQG.lN(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10645");
                            writeData4 = this.fQG.mData;
                            if (writeData4 != null) {
                                writeData7 = this.fQG.mData;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            asVar.Z("fid", str);
                            TiebaStatic.log(asVar);
                            writeData5 = this.fQG.mData;
                            if (writeData5 != null) {
                                writeData6 = this.fQG.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.fQG.ayN;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.fQG.ayN;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.fQG.ayN;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.fQG.ayN;
                                    if (jVar7.CS()) {
                                        jVar8 = this.fQG.ayN;
                                        jVar8.Bd();
                                        jVar9 = this.fQG.ayN;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.fQG.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.fQG.getPageContext(), this.fQG.getResources().getString(w.l.plugin_video_not_active), this.fQG.getResources().getString(w.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.fQG.getPageContext(), this.fQG.getResources().getString(w.l.plugin_video_install_tips), this.fQG.getResources().getString(w.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.fQG.ayN;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.fQG.ayN;
                            jVar3.b(aVar4);
                            writeData3 = this.fQG.mData;
                            writeData3.setVideoInfo(null);
                            this.fQG.bds();
                            editText = this.fQG.fkA;
                            if (editText != null) {
                                editText3 = this.fQG.fkA;
                                editText3.requestFocus();
                            }
                            jVar4 = this.fQG.ayN;
                            jVar4.Bd();
                            jVar5 = this.fQG.ayN;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.fQG;
                            inputMethodManager = this.fQG.mInputManager;
                            editText2 = this.fQG.fkA;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.fQG.mData;
                                if (writeData != null) {
                                    writeData2 = this.fQG.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.fQG.bds();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("hot_topic_has_click", true);
                            jVar = this.fQG.ayN;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.fQG.fPs = true;
                            this.fQG.lO(true);
                            boJ = this.fQG.boJ();
                            if (boJ.isFocused()) {
                                this.fQG.fPr = "from_title";
                                return;
                            }
                            boI = this.fQG.boI();
                            if (boI.isFocused()) {
                                this.fQG.fPr = "from_content";
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.fQG.boT();
                        this.fQG.bds();
                        return;
                    }
                } else {
                    boH = this.fQG.boH();
                    if (boH) {
                        this.fQG.showToast(w.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.fQG.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            boH2 = this.fQG.boH();
            if (boH2) {
                this.fQG.showToast(w.l.over_limit_tip);
            } else {
                this.fQG.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fQG.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
