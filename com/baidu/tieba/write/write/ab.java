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
public class ab implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        com.baidu.tieba.write.a aVar2;
        String threadTitle;
        String buA;
        String str;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        com.baidu.tbadk.editortools.j jVar;
        EditText but;
        EditText bus;
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
        String str2;
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
        boolean bur;
        boolean bur2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code == 14 || aVar.code == 48) {
                    this.glP.d(aVar);
                    return;
                } else if (aVar.code != 24) {
                    if (aVar.code == 3) {
                        this.glP.buu();
                        return;
                    } else if (aVar.code == 10) {
                        if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                            this.glP.aBB = (VoiceData.VoiceModel) aVar.data;
                            this.glP.bis();
                            return;
                        }
                        return;
                    } else if (aVar.code == 11) {
                        this.glP.aBB = null;
                        this.glP.bis();
                        return;
                    } else if (aVar.code != 12 && aVar.code != 13 && aVar.code != 46 && aVar.code != 49) {
                        if (aVar.code == 15 || aVar.code == 47) {
                            if (aVar.data != null && (aVar.data instanceof Integer)) {
                                int intValue = ((Integer) aVar.data).intValue();
                                writeImagesInfo = this.glP.writeImagesInfo;
                                if (writeImagesInfo != null) {
                                    writeImagesInfo2 = this.glP.writeImagesInfo;
                                    if (writeImagesInfo2.getChosedFiles() != null) {
                                        writeImagesInfo3 = this.glP.writeImagesInfo;
                                        int size = writeImagesInfo3.getChosedFiles().size();
                                        if (size >= 1 && intValue >= 0 && intValue < size) {
                                            WriteActivity writeActivity = this.glP;
                                            Activity pageActivity = this.glP.getPageContext().getPageActivity();
                                            writeImagesInfo4 = this.glP.writeImagesInfo;
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
                                additionData = this.glP.gkM;
                                if (additionData == null) {
                                    this.glP.Dl();
                                    return;
                                }
                            }
                            i = this.glP.aBL;
                            switch (i) {
                                case 0:
                                    Activity pageActivity2 = this.glP.getPageContext().getPageActivity();
                                    if (com.baidu.tbadk.core.util.ag.aC(pageActivity2)) {
                                        this.glP.Dj();
                                        return;
                                    } else {
                                        com.baidu.tbadk.core.util.ag.c(pageActivity2, 0);
                                        return;
                                    }
                                case 1:
                                default:
                                    return;
                                case 2:
                                    this.glP.Di();
                                    return;
                            }
                        } else if (aVar.code == 25) {
                            if (aVar.data == null || !(aVar.data instanceof String)) {
                                this.glP.dSk = null;
                            } else {
                                this.glP.dSk = (String) aVar.data;
                            }
                            this.glP.mD(false);
                            return;
                        } else if (aVar.code == 27) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                            com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10645");
                            writeData4 = this.glP.mData;
                            if (writeData4 != null) {
                                writeData7 = this.glP.mData;
                                str2 = writeData7.getForumId();
                            } else {
                                str2 = "";
                            }
                            auVar.Z("fid", str2);
                            TiebaStatic.log(auVar);
                            writeData5 = this.glP.mData;
                            if (writeData5 != null) {
                                writeData6 = this.glP.mData;
                                VideoInfo videoInfo = writeData6.getVideoInfo();
                                if (videoInfo != null && videoInfo.isAvaliable()) {
                                    jVar10 = this.glP.azR;
                                    jVar10.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                    jVar11 = this.glP.azR;
                                    jVar11.b(aVar3);
                                    return;
                                }
                            }
                            jVar6 = this.glP.azR;
                            jVar6.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    jVar7 = this.glP.azR;
                                    if (jVar7.CJ()) {
                                        jVar8 = this.glP.azR;
                                        jVar8.Bb();
                                        jVar9 = this.glP.azR;
                                        jVar9.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    }
                                    XiaoyingUtil.startXiaoying(this.glP.getActivity());
                                    return;
                                }
                                XiaoyingUtil.showGoPluginDetailDialog(this.glP.getPageContext(), this.glP.getResources().getString(w.l.plugin_video_not_active), this.glP.getResources().getString(w.l.setup));
                                return;
                            }
                            XiaoyingUtil.showGoPluginDetailDialog(this.glP.getPageContext(), this.glP.getResources().getString(w.l.plugin_video_install_tips), this.glP.getResources().getString(w.l.plugin_go_install));
                            return;
                        } else if (aVar.code == 29) {
                            com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(2, 19, null);
                            jVar2 = this.glP.azR;
                            jVar2.b(aVar4);
                            com.baidu.tbadk.editortools.a aVar5 = new com.baidu.tbadk.editortools.a(1, 2, null);
                            jVar3 = this.glP.azR;
                            jVar3.b(aVar5);
                            writeData3 = this.glP.mData;
                            writeData3.setVideoInfo(null);
                            this.glP.bis();
                            editText = this.glP.fCD;
                            if (editText != null) {
                                editText3 = this.glP.fCD;
                                editText3.requestFocus();
                            }
                            jVar4 = this.glP.azR;
                            jVar4.Bb();
                            jVar5 = this.glP.azR;
                            jVar5.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                            WriteActivity writeActivity2 = this.glP;
                            inputMethodManager = this.glP.mInputManager;
                            editText2 = this.glP.fCD;
                            writeActivity2.ShowSoftKeyPad(inputMethodManager, editText2);
                            return;
                        } else if (aVar.code == 40) {
                            if ((aVar.data instanceof String) || aVar.data == null) {
                                writeData = this.glP.mData;
                                if (writeData != null) {
                                    writeData2 = this.glP.mData;
                                    writeData2.setGraffitiFileName((String) aVar.data);
                                    this.glP.bis();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (aVar.code == 43) {
                            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                            jVar = this.glP.azR;
                            jVar.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                            this.glP.gkx = true;
                            this.glP.mE(true);
                            but = this.glP.but();
                            if (but.isFocused()) {
                                this.glP.gkw = "from_title";
                                return;
                            }
                            bus = this.glP.bus();
                            if (bus.isFocused()) {
                                this.glP.gkw = "from_content";
                                return;
                            }
                            return;
                        } else if (aVar.code == 45) {
                            linearLayout = this.glP.eiG;
                            linearLayout.setVisibility(0);
                            linearLayout2 = this.glP.eiG;
                            linearLayout2.requestFocus();
                            return;
                        } else if (aVar.code == 51) {
                            aVar2 = this.glP.glw;
                            threadTitle = this.glP.getThreadTitle();
                            buA = this.glP.buA();
                            aVar2.ck(threadTitle, buA);
                            com.baidu.tbadk.core.util.au auVar2 = new com.baidu.tbadk.core.util.au("c12258");
                            str = this.glP.ggZ;
                            TiebaStatic.log(auVar2.Z("obj_locate", str));
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.glP.buE();
                        this.glP.bis();
                        return;
                    }
                } else {
                    bur = this.glP.bur();
                    if (bur) {
                        this.glP.showToast(w.l.over_limit_tip);
                        return;
                    } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        this.glP.b((com.baidu.tbadk.coreExtra.data.l) aVar.data);
                        return;
                    } else {
                        return;
                    }
                }
            }
            bur2 = this.glP.bur();
            if (bur2) {
                this.glP.showToast(w.l.over_limit_tip);
            } else {
                this.glP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.glP.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
