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
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.l lVar;
        EditText bwy;
        EditText bwx;
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
        boolean bww;
        boolean bww2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14) {
                    this.gpp.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.gpp.bwz();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.gpp.awz = (VoiceData.VoiceModel) aVar.data;
                            this.gpp.bih();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.gpp.awz = null;
                        this.gpp.bih();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13) {
                        if (aVar.code == 15) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.gpp.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.gpp.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.gpp.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.gpp;
                                            Activity pageActivity = this.gpp.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.gpp.writeImagesInfo;
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
                                additionData = this.gpp.gor;
                                if (additionData == null) {
                                    this.gpp.Dy();
                                    return;
                                }
                            }
                            i = this.gpp.awK;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.gpp.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.Z(pageActivity2)) {
                                        this.gpp.Dw();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.gpp.Dv();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.gpp.dUK = null;
                            } else {
                                this.gpp.dUK = (String) aVar.data;
                            }
                            this.gpp.mq(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10645");
                            writeData4 = this.gpp.fst;
                            if (writeData4 != null) {
                                writeData7 = this.gpp.fst;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            avVar.ab("fid", str);
                            TiebaStatic.log(avVar);
                            writeData5 = this.gpp.fst;
                            if (writeData5 != null) {
                                writeData6 = this.gpp.fst;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    lVar10 = this.gpp.auI;
                                    lVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    lVar11 = this.gpp.auI;
                                    lVar11.b(aVar2);
                                    return;
                                }
                            }
                            lVar6 = this.gpp.auI;
                            lVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    lVar7 = this.gpp.auI;
                                    if (lVar7.CR()) {
                                        lVar8 = this.gpp.auI;
                                        lVar8.Bc();
                                        lVar9 = this.gpp.auI;
                                        lVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.gpp.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.gpp.getPageContext(), this.gpp.getResources().getString(r.j.plugin_video_not_active), this.gpp.getResources().getString(r.j.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.gpp.getPageContext(), this.gpp.getResources().getString(r.j.plugin_video_install_tips), this.gpp.getResources().getString(r.j.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            lVar2 = this.gpp.auI;
                            lVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            lVar3 = this.gpp.auI;
                            lVar3.b(aVar4);
                            writeData3 = this.gpp.fst;
                            writeData3.setVideoInfo(null);
                            this.gpp.bih();
                            editText = this.gpp.fsQ;
                            if (editText != null) {
                                editText3 = this.gpp.fsQ;
                                editText3.requestFocus();
                            }
                            lVar4 = this.gpp.auI;
                            lVar4.Bc();
                            lVar5 = this.gpp.auI;
                            lVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.gpp;
                            inputMethodManager = this.gpp.mInputManager;
                            editText2 = this.gpp.fsQ;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.gpp.fst;
                                if (writeData != null) {
                                    writeData2 = this.gpp.fst;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.gpp.bih();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.um().putBoolean("hot_topic_has_click", true);
                            lVar = this.gpp.auI;
                            lVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.gpp.gob = true;
                            this.gpp.mr(true);
                            bwy = this.gpp.bwy();
                            if (bwy.isFocused()) {
                                this.gpp.goa = "from_title";
                                return;
                            }
                            bwx = this.gpp.bwx();
                            if (bwx.isFocused()) {
                                this.gpp.goa = "from_content";
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.gpp.bwI();
                        this.gpp.bih();
                        return;
                    }
                } else {
                    bww = this.gpp.bww();
                    if (bww) {
                        this.gpp.showToast(r.j.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.gpp.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bww2 = this.gpp.bww();
            if (bww2) {
                this.gpp.showToast(r.j.over_limit_tip);
            } else {
                this.gpp.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.gpp.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
