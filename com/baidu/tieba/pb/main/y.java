package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        bz bzVar;
        bz bzVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        bq bqVar;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        WriteImagesInfo writeImagesInfo11;
        String str;
        VoiceData.VoiceModel voiceModel;
        bz bzVar3;
        VoiceData.VoiceModel voiceModel2;
        String str2;
        bz bzVar4;
        bz bzVar5;
        String str3;
        bz bzVar6;
        bz bzVar7;
        String str4;
        boolean gP;
        bz bzVar8;
        bq bqVar2;
        boolean gP2;
        bz bzVar9;
        boolean gP3;
        bz bzVar10;
        boolean gP4;
        int i2 = 0;
        if (i == 0) {
            bzVar10 = this.bzj.byO;
            if (bzVar10.Fl()) {
                this.bzj.showToast(com.baidu.tieba.z.over_limit_tip);
                return;
            }
            gP4 = this.bzj.gP(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025);
            if (gP4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bzj.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 26) {
            bzVar9 = this.bzj.byO;
            if (bzVar9.YK()) {
                this.bzj.showToast(com.baidu.tieba.z.over_limit_tip);
                return;
            }
            gP3 = this.bzj.gP(11026);
            if (gP3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bzj.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 10) {
            bqVar2 = this.bzj.byJ;
            if (bqVar2.getPbData() == null) {
                return;
            }
            gP2 = this.bzj.gP(11001);
            if (!gP2) {
                return;
            }
            this.bzj.fs(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bzj.byI;
                if (str2 != null) {
                    str3 = this.bzj.byI;
                    if (str3.length() > 0) {
                        bzVar6 = this.bzj.byO;
                        bzVar6.setAudioFocusable(false);
                        bzVar7 = this.bzj.byO;
                        bzVar7.dS(false);
                        PbActivity pbActivity = this.bzj;
                        str4 = this.bzj.byI;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                bzVar4 = this.bzj.byO;
                bzVar4.setAudioFocusable(true);
                bzVar5 = this.bzj.byO;
                bzVar5.dS(true);
            } else if (i == 54) {
                voiceModel = this.bzj.byF;
                if (voiceModel != null) {
                    bzVar3 = this.bzj.byO;
                    voiceModel2 = this.bzj.byF;
                    bzVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo10 = this.bzj.writeImagesInfo;
                int size = writeImagesInfo10.size();
                writeImagesInfo11 = this.bzj.writeImagesInfo;
                if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                    this.bzj.aAI = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bzj.getPageContext();
                    str = this.bzj.aAI;
                    com.baidu.tbadk.core.util.aw.a(pageContext, str);
                    return;
                }
                this.bzj.showToast(String.format(this.bzj.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo7 = this.bzj.writeImagesInfo;
                if (writeImagesInfo7 != null) {
                    writeImagesInfo8 = this.bzj.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                        Activity pageActivity = this.bzj.getPageContext().getPageActivity();
                        writeImagesInfo9 = this.bzj.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo9.toJsonString());
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i != 13) {
                if (i != 7) {
                    if (i == 42) {
                        int intValue = ((Integer) obj).intValue();
                        writeImagesInfo3 = this.bzj.writeImagesInfo;
                        if (writeImagesInfo3 != null) {
                            writeImagesInfo4 = this.bzj.writeImagesInfo;
                            if (writeImagesInfo4.getChosedFiles() != null) {
                                writeImagesInfo5 = this.bzj.writeImagesInfo;
                                int size2 = writeImagesInfo5.getChosedFiles().size();
                                if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity pageActivity2 = this.bzj.getPageContext().getPageActivity();
                                    writeImagesInfo6 = this.bzj.writeImagesInfo;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity2, 12012, writeImagesInfo6, intValue)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i == 48) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aeJ();
                        if (!com.baidu.tieba.tbadkCore.PbEditor.a.aeH()) {
                            bqVar = this.bzj.byJ;
                            if (bqVar.getIsMem() == 0) {
                                this.bzj.showToast(com.baidu.tieba.z.baobao_over_limit);
                                return;
                            }
                        }
                        com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bzj.getPageContext().getPageActivity());
                        aVar.getIntent().putExtra("title", this.bzj.getResources().getString(com.baidu.tieba.z.send_reply));
                        aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                        this.bzj.sendMessage(new CustomMessage(2802001, aVar));
                        return;
                    } else if (i == 51) {
                        writeImagesInfo = this.bzj.baobaoImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.bzj.baobaoImagesInfo;
                            if (writeImagesInfo2.size() > 0) {
                                writeData2 = this.bzj.aCr;
                                writeData2.setIsBaobao(true);
                                return;
                            }
                        }
                        writeData = this.bzj.aCr;
                        writeData.setIsBaobao(false);
                        return;
                    } else if (i == 52) {
                        bzVar = this.bzj.byO;
                        if (bzVar.Fh() != null) {
                            bzVar2 = this.bzj.byO;
                            i2 = bzVar2.Fh().getLocationInfoViewState();
                        }
                        switch (i2) {
                            case 0:
                                this.bzj.ER();
                                return;
                            case 1:
                            default:
                                return;
                            case 2:
                                this.bzj.EQ();
                                return;
                        }
                    } else if (i == 53) {
                        MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                        return;
                    } else {
                        return;
                    }
                }
                alertDialog = this.bzj.aAR;
                if (alertDialog == null) {
                    this.bzj.EU();
                }
                alertDialog2 = this.bzj.aAR;
                if (alertDialog2 == null) {
                    return;
                }
                alertDialog3 = this.bzj.aAR;
                com.baidu.adp.lib.g.k.a(alertDialog3, this.bzj.getPageContext().getPageActivity());
            }
        } else {
            gP = this.bzj.gP(11027);
            if (gP) {
                bzVar8 = this.bzj.byO;
                this.bzj.fs(bzVar8.Yt());
            }
        }
    }
}
