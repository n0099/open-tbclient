package com.baidu.tieba.pb.main;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.selectpoi.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        bv bvVar;
        bv bvVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        bn bnVar;
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
        bv bvVar3;
        VoiceData.VoiceModel voiceModel2;
        String str2;
        bv bvVar4;
        bv bvVar5;
        String str3;
        bv bvVar6;
        bv bvVar7;
        String str4;
        boolean gJ;
        bv bvVar8;
        bn bnVar2;
        boolean gJ2;
        bv bvVar9;
        boolean gJ3;
        bv bvVar10;
        boolean gJ4;
        int i2 = 0;
        if (i == 0) {
            bvVar10 = this.bvu.buZ;
            if (bvVar10.Cj()) {
                this.bvu.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            gJ4 = this.bvu.gJ(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025);
            if (gJ4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bvu, 12004, true)));
            }
        } else if (i == 26) {
            bvVar9 = this.bvu.buZ;
            if (bvVar9.Ym()) {
                this.bvu.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            gJ3 = this.bvu.gJ(11026);
            if (gJ3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bvu, 12005, true)));
            }
        } else if (i == 10) {
            bnVar2 = this.bvu.buU;
            if (bnVar2.getPbData() == null) {
                return;
            }
            gJ2 = this.bvu.gJ(11001);
            if (!gJ2) {
                return;
            }
            this.bvu.eX(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bvu.buT;
                if (str2 != null) {
                    str3 = this.bvu.buT;
                    if (str3.length() > 0) {
                        bvVar6 = this.bvu.buZ;
                        bvVar6.setAudioFocusable(false);
                        bvVar7 = this.bvu.buZ;
                        bvVar7.eh(false);
                        PbActivity pbActivity = this.bvu;
                        str4 = this.bvu.buT;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                bvVar4 = this.bvu.buZ;
                bvVar4.setAudioFocusable(true);
                bvVar5 = this.bvu.buZ;
                bvVar5.eh(true);
            } else if (i == 54) {
                voiceModel = this.bvu.buP;
                if (voiceModel != null) {
                    bvVar3 = this.bvu.buZ;
                    voiceModel2 = this.bvu.buP;
                    bvVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo10 = this.bvu.writeImagesInfo;
                int size = writeImagesInfo10.size();
                writeImagesInfo11 = this.bvu.writeImagesInfo;
                if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                    this.bvu.ayG = String.valueOf(System.currentTimeMillis());
                    PbActivity pbActivity2 = this.bvu;
                    str = this.bvu.ayG;
                    com.baidu.tbadk.core.util.av.a(pbActivity2, str);
                    return;
                }
                this.bvu.showToast(String.format(this.bvu.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo7 = this.bvu.writeImagesInfo;
                if (writeImagesInfo7 != null) {
                    writeImagesInfo8 = this.bvu.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                        PbActivity pbActivity3 = this.bvu;
                        writeImagesInfo9 = this.bvu.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pbActivity3, writeImagesInfo9.toJsonString());
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i != 13) {
                if (i != 7) {
                    if (i == 42) {
                        int intValue = ((Integer) obj).intValue();
                        writeImagesInfo3 = this.bvu.writeImagesInfo;
                        if (writeImagesInfo3 != null) {
                            writeImagesInfo4 = this.bvu.writeImagesInfo;
                            if (writeImagesInfo4.getChosedFiles() != null) {
                                writeImagesInfo5 = this.bvu.writeImagesInfo;
                                int size2 = writeImagesInfo5.getChosedFiles().size();
                                if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    PbActivity pbActivity4 = this.bvu;
                                    writeImagesInfo6 = this.bvu.writeImagesInfo;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pbActivity4, 12012, writeImagesInfo6, intValue)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i == 48) {
                        if (PluginHelper.isBaoBaoCanUse(this.bvu)) {
                            com.baidu.tieba.e.a.adK();
                            if (!com.baidu.tieba.e.a.adI()) {
                                bnVar = this.bvu.buU;
                                if (bnVar.getIsMem() == 0) {
                                    this.bvu.showToast(com.baidu.tieba.y.baobao_over_limit);
                                    return;
                                }
                            }
                            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                            if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                                baobaoSdkDelegate.startMatchImage(this.bvu, this.bvu.getResources().getString(com.baidu.tieba.y.send_reply), 12013);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i == 51) {
                        writeImagesInfo = this.bvu.baobaoImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.bvu.baobaoImagesInfo;
                            if (writeImagesInfo2.size() > 0) {
                                writeData2 = this.bvu.aAW;
                                writeData2.setIsBaobao(true);
                                return;
                            }
                        }
                        writeData = this.bvu.aAW;
                        writeData.setIsBaobao(false);
                        return;
                    } else if (i == 52) {
                        bvVar = this.bvu.buZ;
                        if (bvVar.EQ() != null) {
                            bvVar2 = this.bvu.buZ;
                            i2 = bvVar2.EQ().getLocationInfoViewState();
                        }
                        switch (i2) {
                            case 0:
                                this.bvu.Ez();
                                return;
                            case 1:
                            default:
                                return;
                            case 2:
                                this.bvu.Ey();
                                return;
                        }
                    } else if (i == 53) {
                        MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null));
                        return;
                    } else {
                        return;
                    }
                }
                alertDialog = this.bvu.ayP;
                if (alertDialog == null) {
                    this.bvu.ED();
                }
                alertDialog2 = this.bvu.ayP;
                if (alertDialog2 == null) {
                    return;
                }
                alertDialog3 = this.bvu.ayP;
                com.baidu.adp.lib.g.j.a(alertDialog3, this.bvu);
            }
        } else {
            gJ = this.bvu.gJ(11027);
            if (gJ) {
                bvVar8 = this.bvu.buZ;
                this.bvu.eX(bvVar8.XU());
            }
        }
    }
}
