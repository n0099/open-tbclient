package com.baidu.tieba.write.write;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
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
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tbadk.editortools.b {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        WriteData writeData;
        WriteData writeData2;
        com.baidu.tbadk.editortools.j jVar3;
        int i;
        AdditionData additionData;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        boolean avi;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        com.baidu.tbadk.editortools.j jVar4;
        com.baidu.tbadk.editortools.j jVar5;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        boolean avi2;
        if (aVar != null) {
            if (aVar.code != 16) {
                if (aVar.code != 21) {
                    if (aVar.code == 14) {
                        if (aVar.data == null || ((aVar.data instanceof Boolean) && !((Boolean) aVar.data).booleanValue())) {
                            writeImagesInfo5 = this.cUM.writeImagesInfo;
                            if (writeImagesInfo5 != null) {
                                writeImagesInfo6 = this.cUM.writeImagesInfo;
                                if (writeImagesInfo6.size() > 0) {
                                    jVar4 = this.cUM.cUo;
                                    if (jVar4 != null) {
                                        jVar5 = this.cUM.cUo;
                                        writeImagesInfo7 = this.cUM.writeImagesInfo;
                                        jVar5.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(writeImagesInfo7, true)));
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.cUM.getPageContext().getPageActivity();
                        writeImagesInfo8 = this.cUM.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo8.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                        return;
                    } else if (aVar.code != 24) {
                        if (aVar.code == 3) {
                            this.cUM.avk();
                            return;
                        } else if (aVar.code == 10) {
                            if (aVar.data != null && (aVar.data instanceof VoiceData.VoiceModel)) {
                                this.cUM.arK = (VoiceData.VoiceModel) aVar.data;
                                this.cUM.auw();
                                return;
                            }
                            return;
                        } else if (aVar.code == 11) {
                            this.cUM.arK = null;
                            this.cUM.auw();
                            return;
                        } else if (aVar.code != 12 && aVar.code != 13) {
                            if (aVar.code != 22 && aVar.code != 23) {
                                if (aVar.code == 15) {
                                    if (aVar.data != null && (aVar.data instanceof Integer)) {
                                        int intValue = ((Integer) aVar.data).intValue();
                                        writeImagesInfo = this.cUM.writeImagesInfo;
                                        if (writeImagesInfo != null) {
                                            writeImagesInfo2 = this.cUM.writeImagesInfo;
                                            if (writeImagesInfo2.getChosedFiles() != null) {
                                                writeImagesInfo3 = this.cUM.writeImagesInfo;
                                                int size = writeImagesInfo3.getChosedFiles().size();
                                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager messageManager = MessageManager.getInstance();
                                                    Activity pageActivity2 = this.cUM.getPageContext().getPageActivity();
                                                    writeImagesInfo4 = this.cUM.writeImagesInfo;
                                                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo4, intValue)));
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
                                        additionData = this.cUM.cUp;
                                        if (additionData == null) {
                                            this.cUM.Bq();
                                            return;
                                        }
                                    }
                                    i = this.cUM.arW;
                                    switch (i) {
                                        case 0:
                                            this.cUM.Bo();
                                            return;
                                        case 1:
                                        default:
                                            return;
                                        case 2:
                                            this.cUM.Bn();
                                            return;
                                    }
                                } else if (aVar.code == 25) {
                                    if (aVar.data == null || !(aVar.data instanceof String)) {
                                        this.cUM.bRT = null;
                                    } else {
                                        this.cUM.bRT = (String) aVar.data;
                                    }
                                    this.cUM.fZ(false);
                                    return;
                                } else if (aVar.code == 27) {
                                    TiebaStatic.log("c10057");
                                    writeData2 = this.cUM.cKS;
                                    VideoInfo videoInfo = writeData2.getVideoInfo();
                                    if (videoInfo != null && videoInfo.isAvaliable()) {
                                        com.baidu.tbadk.editortools.a aVar2 = new com.baidu.tbadk.editortools.a(28, 20, videoInfo);
                                        jVar3 = this.cUM.cUo;
                                        jVar3.b(aVar2);
                                        return;
                                    } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                                        if (XiaoyingUtil.isXiaoyingForbidden()) {
                                            XiaoyingUtil.showGoPluginDetailDialog(this.cUM.getPageContext(), this.cUM.getResources().getString(i.C0057i.plugin_video_not_active), this.cUM.getResources().getString(i.C0057i.setup));
                                            return;
                                        }
                                        XiaoyingUtil.startXiaoying(this.cUM.getActivity());
                                        return;
                                    } else {
                                        XiaoyingUtil.showGoPluginDetailDialog(this.cUM.getPageContext(), this.cUM.getResources().getString(i.C0057i.plugin_video_install_tips), this.cUM.getResources().getString(i.C0057i.plugin_go_install));
                                        return;
                                    }
                                } else if (aVar.code == 29) {
                                    com.baidu.tbadk.editortools.a aVar3 = new com.baidu.tbadk.editortools.a(2, 19, null);
                                    jVar = this.cUM.cUo;
                                    jVar.b(aVar3);
                                    com.baidu.tbadk.editortools.a aVar4 = new com.baidu.tbadk.editortools.a(1, 2, null);
                                    jVar2 = this.cUM.cUo;
                                    jVar2.b(aVar4);
                                    writeData = this.cUM.cKS;
                                    writeData.setVideoInfo(null);
                                    this.cUM.auw();
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.cUM.auw();
                            return;
                        } else {
                            this.cUM.avp();
                            this.cUM.auw();
                            return;
                        }
                    } else {
                        avi = this.cUM.avi();
                        if (avi) {
                            this.cUM.showToast(i.C0057i.over_limit_tip);
                            return;
                        } else if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.f)) {
                            this.cUM.a((com.baidu.tbadk.coreExtra.data.f) aVar.data);
                            return;
                        } else {
                            return;
                        }
                    }
                }
                this.cUM.avj();
                return;
            }
            avi2 = this.cUM.avi();
            if (avi2) {
                this.cUM.showToast(i.C0057i.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(this.cUM.getPageContext().getPageActivity(), 12004, true)));
            }
        }
    }
}
