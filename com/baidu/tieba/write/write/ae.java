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
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.fJw = writeActivity;
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
        WriteData writeData6;
        com.baidu.tbadk.editortools.l lVar9;
        com.baidu.tbadk.editortools.l lVar10;
        WriteData writeData7;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean bml;
        boolean bml2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code != 43) {
                        if (aVar.code != 45) {
                            if (aVar.code == 14) {
                                this.fJw.d(aVar);
                                return;
                            } else if (aVar.code != 24) {
                                if (aVar.code == 3) {
                                    this.fJw.bmr();
                                    return;
                                } else if (aVar.code == 10) {
                                    if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                        this.fJw.asg = (VoiceData.VoiceModel) aVar.data;
                                        this.fJw.bkL();
                                        return;
                                    }
                                    return;
                                } else if (aVar.code == 11) {
                                    this.fJw.asg = null;
                                    this.fJw.bkL();
                                    return;
                                } else if (aVar.code != 12 && aVar.code != 13) {
                                    if (aVar.code != 22 && aVar.code != 23) {
                                        if (aVar.code == 15) {
                                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                                int intValue = ((Integer) aVar.data).intValue();
                                                writeImagesInfo = this.fJw.writeImagesInfo;
                                                if (writeImagesInfo != null) {
                                                    writeImagesInfo2 = this.fJw.writeImagesInfo;
                                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                                        writeImagesInfo3 = this.fJw.writeImagesInfo;
                                                        int size = writeImagesInfo3.getChosedFiles().size();
                                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                                            MessageManager messageManager = MessageManager.getInstance();
                                                            Activity pageActivity = this.fJw.getPageContext().getPageActivity();
                                                            writeImagesInfo4 = this.fJw.writeImagesInfo;
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
                                                additionData = this.fJw.fIH;
                                                if (additionData == null) {
                                                    this.fJw.BV();
                                                    return;
                                                }
                                            }
                                            i = this.fJw.ass;
                                            switch (i) {
                                                case 0:
                                                    Activity pageActivity2 = this.fJw.getPageContext().getPageActivity();
                                                    if (com.baidu.tbadk.core.util.ag.P(pageActivity2)) {
                                                        this.fJw.BT();
                                                        return;
                                                    } else {
                                                        com.baidu.tbadk.core.util.ag.b(pageActivity2, 0);
                                                        return;
                                                    }
                                                case 1:
                                                default:
                                                    return;
                                                case 2:
                                                    this.fJw.BS();
                                                    return;
                                            }
                                        } else if (aVar.code == 25) {
                                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                                this.fJw.dxW = null;
                                            } else {
                                                this.fJw.dxW = (String) aVar.data;
                                            }
                                            this.fJw.ln(false);
                                            return;
                                        } else if (aVar.code == 27) {
                                            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("xiaoying_has_click", true);
                                            com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10645");
                                            writeData4 = this.fJw.fau;
                                            if (writeData4 != null) {
                                                writeData7 = this.fJw.fau;
                                                str = writeData7.getForumId();
                                            } else {
                                                str = "";
                                            }
                                            ayVar.ab("fid", str);
                                            TiebaStatic.log(ayVar);
                                            writeData5 = this.fJw.fau;
                                            if (writeData5 != null) {
                                                writeData6 = this.fJw.fau;
                                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                                    lVar9 = this.fJw.aqo;
                                                    lVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                                    lVar10 = this.fJw.aqo;
                                                    lVar10.b(aVar2);
                                                    return;
                                                }
                                            }
                                            lVar5 = this.fJw.aqo;
                                            lVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                    lVar6 = this.fJw.aqo;
                                                    if (lVar6.Bo()) {
                                                        lVar7 = this.fJw.aqo;
                                                        lVar7.zD();
                                                        lVar8 = this.fJw.aqo;
                                                        lVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                    }
                                                    XiaoyingUtil.startXiaoying(this.fJw.getActivity());
                                                    return;
                                                }
                                                XiaoyingUtil.showGoPluginDetailDialog(this.fJw.getPageContext(), this.fJw.getResources().getString(u.j.plugin_video_not_active), this.fJw.getResources().getString(u.j.setup));
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.fJw.getPageContext(), this.fJw.getResources().getString(u.j.plugin_video_install_tips), this.fJw.getResources().getString(u.j.plugin_go_install));
                                            return;
                                        } else if (aVar.code == 29) {
                                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                            lVar = this.fJw.aqo;
                                            lVar.b(aVar3);
                                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                            lVar2 = this.fJw.aqo;
                                            lVar2.b(aVar4);
                                            writeData3 = this.fJw.fau;
                                            writeData3.setVideoInfo(null);
                                            this.fJw.bkL();
                                            editText = this.fJw.fFl;
                                            if (editText != null) {
                                                editText3 = this.fJw.fFl;
                                                editText3.requestFocus();
                                            }
                                            lVar3 = this.fJw.aqo;
                                            lVar3.zD();
                                            lVar4 = this.fJw.aqo;
                                            lVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            WriteActivity writeActivity = this.fJw;
                                            inputMethodManager = this.fJw.mInputManager;
                                            editText2 = this.fJw.fFl;
                                            writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                            return;
                                        } else if (aVar.code == 40) {
                                            if ((aVar.data instanceof String) || aVar.data == null) {
                                                writeData = this.fJw.fau;
                                                if (writeData != null) {
                                                    writeData2 = this.fJw.fau;
                                                    writeData2.setGraffitiFileName((String) aVar.data);
                                                    this.fJw.bkL();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    this.fJw.bkL();
                                    return;
                                } else {
                                    this.fJw.bmz();
                                    this.fJw.bkL();
                                    return;
                                }
                            } else {
                                bml = this.fJw.bml();
                                if (bml) {
                                    this.fJw.showToast(u.j.over_limit_tip);
                                    return;
                                } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.i)) {
                                    this.fJw.b((com.baidu.tbadk.coreExtra.data.i) aVar.data);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        this.fJw.bmn();
                        return;
                    }
                    this.fJw.bmo();
                    return;
                }
                this.fJw.bmm();
                return;
            }
            bml2 = this.fJw.bml();
            if (bml2) {
                this.fJw.showToast(u.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.fJw.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
