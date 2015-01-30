package com.baidu.tieba.pb.main;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
public class z implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bAT = pbActivity;
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
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        WriteImagesInfo writeImagesInfo11;
        WriteImagesInfo writeImagesInfo12;
        WriteImagesInfo writeImagesInfo13;
        WriteImagesInfo writeImagesInfo14;
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
        boolean gY;
        bz bzVar8;
        bq bqVar2;
        boolean gY2;
        bz bzVar9;
        boolean gY3;
        bz bzVar10;
        boolean gY4;
        int i2 = 0;
        if (i == 0) {
            bzVar10 = this.bAT.bAx;
            if (bzVar10.FJ()) {
                this.bAT.showToast(com.baidu.tieba.z.over_limit_tip);
                return;
            }
            gY4 = this.bAT.gY(11025);
            if (gY4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bAT.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 26) {
            bzVar9 = this.bAT.bAx;
            if (bzVar9.Zp()) {
                this.bAT.showToast(com.baidu.tieba.z.over_limit_tip);
                return;
            }
            gY3 = this.bAT.gY(11026);
            if (gY3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bAT.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 10) {
            bqVar2 = this.bAT.bAs;
            if (bqVar2.getPbData() == null) {
                return;
            }
            gY2 = this.bAT.gY(11001);
            if (!gY2) {
                return;
            }
            this.bAT.fx(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bAT.bAr;
                if (str2 != null) {
                    str3 = this.bAT.bAr;
                    if (str3.length() > 0) {
                        bzVar6 = this.bAT.bAx;
                        bzVar6.setAudioFocusable(false);
                        bzVar7 = this.bAT.bAx;
                        bzVar7.dY(false);
                        PbActivity pbActivity = this.bAT;
                        str4 = this.bAT.bAr;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                bzVar4 = this.bAT.bAx;
                bzVar4.setAudioFocusable(true);
                bzVar5 = this.bAT.bAx;
                bzVar5.dY(true);
            } else if (i == 54) {
                voiceModel = this.bAT.bAo;
                if (voiceModel != null) {
                    bzVar3 = this.bAT.bAx;
                    voiceModel2 = this.bAT.bAo;
                    bzVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo13 = this.bAT.writeImagesInfo;
                int size = writeImagesInfo13.size();
                writeImagesInfo14 = this.bAT.writeImagesInfo;
                if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                    this.bAT.aBK = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bAT.getPageContext();
                    str = this.bAT.aBK;
                    com.baidu.tbadk.core.util.bb.a(pageContext, str);
                    return;
                }
                this.bAT.showToast(String.format(this.bAT.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo10 = this.bAT.writeImagesInfo;
                if (writeImagesInfo10 != null) {
                    writeImagesInfo11 = this.bAT.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.bAT.getPageContext().getPageActivity();
                        writeImagesInfo12 = this.bAT.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i != 13) {
                if (i == 7) {
                    writeImagesInfo7 = this.bAT.writeImagesInfo;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.bAT.writeImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            String valueOf2 = String.valueOf(System.currentTimeMillis());
                            Activity pageActivity2 = this.bAT.getPageContext().getPageActivity();
                            writeImagesInfo9 = this.bAT.writeImagesInfo;
                            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo9.toJsonString(), valueOf2);
                            albumActivityConfig2.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.bAT.writeImagesInfo;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.bAT.writeImagesInfo;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.bAT.writeImagesInfo;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity3 = this.bAT.getPageContext().getPageActivity();
                                writeImagesInfo6 = this.bAT.writeImagesInfo;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity3, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i == 48) {
                    com.baidu.tieba.tbadkCore.PbEditor.a.afn();
                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.afl()) {
                        bqVar = this.bAT.bAs;
                        if (bqVar.getIsMem() == 0) {
                            this.bAT.showToast(com.baidu.tieba.z.baobao_over_limit);
                            return;
                        }
                    }
                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bAT.getPageContext().getPageActivity());
                    aVar.getIntent().putExtra("title", this.bAT.getResources().getString(com.baidu.tieba.z.send_reply));
                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                    this.bAT.sendMessage(new CustomMessage(2802001, aVar));
                } else if (i == 51) {
                    writeImagesInfo = this.bAT.baobaoImagesInfo;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.bAT.baobaoImagesInfo;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.bAT.aDs;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.bAT.aDs;
                    writeData.setIsBaobao(false);
                } else if (i == 52) {
                    bzVar = this.bAT.bAx;
                    if (bzVar.FF() != null) {
                        bzVar2 = this.bAT.bAx;
                        i2 = bzVar2.FF().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.bAT.Fq();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.bAT.Fp();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            gY = this.bAT.gY(11027);
            if (gY) {
                bzVar8 = this.bAT.bAx;
                this.bAT.fx(bzVar8.YY());
            }
        }
    }
}
