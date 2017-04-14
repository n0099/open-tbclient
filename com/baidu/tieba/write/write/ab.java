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
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        EditText bps;
        EditText bpr;
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
        boolean bpq;
        boolean bpq2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14) {
                    this.fSq.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.fSq.bpt();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.fSq.aAM = (VoiceData.VoiceModel) aVar.data;
                            this.fSq.bee();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.fSq.aAM = null;
                        this.fSq.bee();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13) {
                        if (aVar.code == 15) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.fSq.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.fSq.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.fSq.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.fSq;
                                            Activity pageActivity = this.fSq.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.fSq.writeImagesInfo;
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
                                additionData = this.fSq.fRr;
                                if (additionData == null) {
                                    this.fSq.DT();
                                    return;
                                }
                            }
                            i = this.fSq.aAW;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.fSq.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ae.az(pageActivity2)) {
                                        this.fSq.DR();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ae.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.fSq.DQ();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.fSq.dHB = null;
                            } else {
                                this.fSq.dHB = (String) aVar.data;
                            }
                            this.fSq.lQ(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10645");
                            writeData4 = this.fSq.mData;
                            if (writeData4 != null) {
                                writeData7 = this.fSq.mData;
                                str = writeData7.getForumId();
                            } else {
                                str = "";
                            }
                            asVar.aa("fid", str);
                            TiebaStatic.log(asVar);
                            writeData5 = this.fSq.mData;
                            if (writeData5 != null) {
                                writeData6 = this.fSq.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.fSq.azd;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.fSq.azd;
                                    jVar11.b(aVar2);
                                    return;
                                }
                            }
                            jVar6 = this.fSq.azd;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.fSq.azd;
                                    if (jVar7.Dq()) {
                                        jVar8 = this.fSq.azd;
                                        jVar8.BC();
                                        jVar9 = this.fSq.azd;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.fSq.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.fSq.getPageContext(), this.fSq.getResources().getString(w.l.plugin_video_not_active), this.fSq.getResources().getString(w.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.fSq.getPageContext(), this.fSq.getResources().getString(w.l.plugin_video_install_tips), this.fSq.getResources().getString(w.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.fSq.azd;
                            jVar2.b(aVar3);
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.fSq.azd;
                            jVar3.b(aVar4);
                            writeData3 = this.fSq.mData;
                            writeData3.setVideoInfo(null);
                            this.fSq.bee();
                            editText = this.fSq.fmi;
                            if (editText != null) {
                                editText3 = this.fSq.fmi;
                                editText3.requestFocus();
                            }
                            jVar4 = this.fSq.azd;
                            jVar4.BC();
                            jVar5 = this.fSq.azd;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.fSq;
                            inputMethodManager = this.fSq.mInputManager;
                            editText2 = this.fSq.fmi;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.fSq.mData;
                                if (writeData != null) {
                                    writeData2 = this.fSq.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.fSq.bee();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("hot_topic_has_click", true);
                            jVar = this.fSq.azd;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.fSq.fRc = true;
                            this.fSq.lR(true);
                            bps = this.fSq.bps();
                            if (bps.isFocused()) {
                                this.fSq.fRb = "from_title";
                                return;
                            }
                            bpr = this.fSq.bpr();
                            if (bpr.isFocused()) {
                                this.fSq.fRb = "from_content";
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.fSq.bpB();
                        this.fSq.bee();
                        return;
                    }
                } else {
                    bpq = this.fSq.bpq();
                    if (bpq) {
                        this.fSq.showToast(w.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.fSq.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bpq2 = this.fSq.bpq();
            if (bpq2) {
                this.fSq.showToast(w.l.over_limit_tip);
            } else {
                this.fSq.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fSq.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
