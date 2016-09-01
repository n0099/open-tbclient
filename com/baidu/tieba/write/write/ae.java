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
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.gfs = writeActivity;
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
        boolean btu;
        boolean btu2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code != 43) {
                        if (aVar.code != 45) {
                            if (aVar.code == 14) {
                                this.gfs.d(aVar);
                                return;
                            } else if (aVar.code != 24) {
                                if (aVar.code == 3) {
                                    this.gfs.btA();
                                    return;
                                } else if (aVar.code == 10) {
                                    if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                        this.gfs.awc = (VoiceData.VoiceModel) aVar.data;
                                        this.gfs.bfa();
                                        return;
                                    }
                                    return;
                                } else if (aVar.code == 11) {
                                    this.gfs.awc = null;
                                    this.gfs.bfa();
                                    return;
                                } else if (aVar.code != 12 && aVar.code != 13) {
                                    if (aVar.code != 22 && aVar.code != 23) {
                                        if (aVar.code == 15) {
                                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                                int intValue = ((Integer) aVar.data).intValue();
                                                writeImagesInfo = this.gfs.writeImagesInfo;
                                                if (writeImagesInfo != null) {
                                                    writeImagesInfo2 = this.gfs.writeImagesInfo;
                                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                                        writeImagesInfo3 = this.gfs.writeImagesInfo;
                                                        int size = writeImagesInfo3.getChosedFiles().size();
                                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                                            MessageManager messageManager = MessageManager.getInstance();
                                                            Activity pageActivity = this.gfs.getPageContext().getPageActivity();
                                                            writeImagesInfo4 = this.gfs.writeImagesInfo;
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
                                                additionData = this.gfs.geD;
                                                if (additionData == null) {
                                                    this.gfs.Dq();
                                                    return;
                                                }
                                            }
                                            i = this.gfs.awo;
                                            switch (i) {
                                                case 0:
                                                    Activity pageActivity2 = this.gfs.getPageContext().getPageActivity();
                                                    if (com.baidu.tbadk.core.util.ag.Z(pageActivity2)) {
                                                        this.gfs.Do();
                                                        return;
                                                    } else {
                                                        com.baidu.tbadk.core.util.ag.c(pageActivity2, 0);
                                                        return;
                                                    }
                                                case 1:
                                                default:
                                                    return;
                                                case 2:
                                                    this.gfs.Dn();
                                                    return;
                                            }
                                        } else if (aVar.code == 25) {
                                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                                this.gfs.dNj = null;
                                            } else {
                                                this.gfs.dNj = (String) aVar.data;
                                            }
                                            this.gfs.lP(false);
                                            return;
                                        } else if (aVar.code == 27) {
                                            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("xiaoying_has_click", true);
                                            com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10645");
                                            writeData4 = this.gfs.fiE;
                                            if (writeData4 != null) {
                                                writeData7 = this.gfs.fiE;
                                                str = writeData7.getForumId();
                                            } else {
                                                str = "";
                                            }
                                            ayVar.ab("fid", str);
                                            TiebaStatic.log(ayVar);
                                            writeData5 = this.gfs.fiE;
                                            if (writeData5 != null) {
                                                writeData6 = this.gfs.fiE;
                                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                                    lVar9 = this.gfs.auk;
                                                    lVar9.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                                    com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                                    lVar10 = this.gfs.auk;
                                                    lVar10.b(aVar2);
                                                    return;
                                                }
                                            }
                                            lVar5 = this.gfs.auk;
                                            lVar5.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                                    lVar6 = this.gfs.auk;
                                                    if (lVar6.CJ()) {
                                                        lVar7 = this.gfs.auk;
                                                        lVar7.AS();
                                                        lVar8 = this.gfs.auk;
                                                        lVar8.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                                    }
                                                    XiaoyingUtil.startXiaoying(this.gfs.getActivity());
                                                    return;
                                                }
                                                XiaoyingUtil.showGoPluginDetailDialog(this.gfs.getPageContext(), this.gfs.getResources().getString(t.j.plugin_video_not_active), this.gfs.getResources().getString(t.j.setup));
                                                return;
                                            }
                                            XiaoyingUtil.showGoPluginDetailDialog(this.gfs.getPageContext(), this.gfs.getResources().getString(t.j.plugin_video_install_tips), this.gfs.getResources().getString(t.j.plugin_go_install));
                                            return;
                                        } else if (aVar.code == 29) {
                                            com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                            lVar = this.gfs.auk;
                                            lVar.b(aVar3);
                                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                            lVar2 = this.gfs.auk;
                                            lVar2.b(aVar4);
                                            writeData3 = this.gfs.fiE;
                                            writeData3.setVideoInfo(null);
                                            this.gfs.bfa();
                                            editText = this.gfs.fjb;
                                            if (editText != null) {
                                                editText3 = this.gfs.fjb;
                                                editText3.requestFocus();
                                            }
                                            lVar3 = this.gfs.auk;
                                            lVar3.AS();
                                            lVar4 = this.gfs.auk;
                                            lVar4.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            WriteActivity writeActivity = this.gfs;
                                            inputMethodManager = this.gfs.mInputManager;
                                            editText2 = this.gfs.fjb;
                                            writeActivity.ShowSoftKeyPad(inputMethodManager, editText2);
                                            return;
                                        } else if (aVar.code == 40) {
                                            if ((aVar.data instanceof String) || aVar.data == null) {
                                                writeData = this.gfs.fiE;
                                                if (writeData != null) {
                                                    writeData2 = this.gfs.fiE;
                                                    writeData2.setGraffitiFileName((String) aVar.data);
                                                    this.gfs.bfa();
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    this.gfs.bfa();
                                    return;
                                } else {
                                    this.gfs.btI();
                                    this.gfs.bfa();
                                    return;
                                }
                            } else {
                                btu = this.gfs.btu();
                                if (btu) {
                                    this.gfs.showToast(t.j.over_limit_tip);
                                    return;
                                } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                                    this.gfs.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        this.gfs.btw();
                        return;
                    }
                    this.gfs.btx();
                    return;
                }
                this.gfs.btv();
                return;
            }
            btu2 = this.gfs.btu();
            if (btu2) {
                this.gfs.showToast(t.j.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.gfs.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
