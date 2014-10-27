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
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.bvg = pbActivity;
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
            bvVar10 = this.bvg.buL;
            if (bvVar10.Ch()) {
                this.bvg.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            gJ4 = this.bvg.gJ(LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025);
            if (gJ4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bvg, 12004, true)));
            }
        } else if (i == 26) {
            bvVar9 = this.bvg.buL;
            if (bvVar9.Yj()) {
                this.bvg.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            gJ3 = this.bvg.gJ(11026);
            if (gJ3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bvg, 12005, true)));
            }
        } else if (i == 10) {
            bnVar2 = this.bvg.buG;
            if (bnVar2.getPbData() == null) {
                return;
            }
            gJ2 = this.bvg.gJ(11001);
            if (!gJ2) {
                return;
            }
            this.bvg.eX(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bvg.buF;
                if (str2 != null) {
                    str3 = this.bvg.buF;
                    if (str3.length() > 0) {
                        bvVar6 = this.bvg.buL;
                        bvVar6.setAudioFocusable(false);
                        bvVar7 = this.bvg.buL;
                        bvVar7.eh(false);
                        PbActivity pbActivity = this.bvg;
                        str4 = this.bvg.buF;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                bvVar4 = this.bvg.buL;
                bvVar4.setAudioFocusable(true);
                bvVar5 = this.bvg.buL;
                bvVar5.eh(true);
            } else if (i == 54) {
                voiceModel = this.bvg.buB;
                if (voiceModel != null) {
                    bvVar3 = this.bvg.buL;
                    voiceModel2 = this.bvg.buB;
                    bvVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo10 = this.bvg.writeImagesInfo;
                int size = writeImagesInfo10.size();
                writeImagesInfo11 = this.bvg.writeImagesInfo;
                if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                    this.bvg.ayx = String.valueOf(System.currentTimeMillis());
                    PbActivity pbActivity2 = this.bvg;
                    str = this.bvg.ayx;
                    com.baidu.tbadk.core.util.av.a(pbActivity2, str);
                    return;
                }
                this.bvg.showToast(String.format(this.bvg.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo7 = this.bvg.writeImagesInfo;
                if (writeImagesInfo7 != null) {
                    writeImagesInfo8 = this.bvg.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                        PbActivity pbActivity3 = this.bvg;
                        writeImagesInfo9 = this.bvg.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pbActivity3, writeImagesInfo9.toJsonString());
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i != 13) {
                if (i != 7) {
                    if (i == 42) {
                        int intValue = ((Integer) obj).intValue();
                        writeImagesInfo3 = this.bvg.writeImagesInfo;
                        if (writeImagesInfo3 != null) {
                            writeImagesInfo4 = this.bvg.writeImagesInfo;
                            if (writeImagesInfo4.getChosedFiles() != null) {
                                writeImagesInfo5 = this.bvg.writeImagesInfo;
                                int size2 = writeImagesInfo5.getChosedFiles().size();
                                if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    PbActivity pbActivity4 = this.bvg;
                                    writeImagesInfo6 = this.bvg.writeImagesInfo;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pbActivity4, 12012, writeImagesInfo6, intValue)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i == 48) {
                        if (PluginHelper.isBaoBaoCanUse(this.bvg)) {
                            com.baidu.tieba.e.a.adH();
                            if (!com.baidu.tieba.e.a.adF()) {
                                bnVar = this.bvg.buG;
                                if (bnVar.getIsMem() == 0) {
                                    this.bvg.showToast(com.baidu.tieba.y.baobao_over_limit);
                                    return;
                                }
                            }
                            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                            if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                                baobaoSdkDelegate.startMatchImage(this.bvg, this.bvg.getResources().getString(com.baidu.tieba.y.send_reply), 12013);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i == 51) {
                        writeImagesInfo = this.bvg.baobaoImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.bvg.baobaoImagesInfo;
                            if (writeImagesInfo2.size() > 0) {
                                writeData2 = this.bvg.aAM;
                                writeData2.setIsBaobao(true);
                                return;
                            }
                        }
                        writeData = this.bvg.aAM;
                        writeData.setIsBaobao(false);
                        return;
                    } else if (i == 52) {
                        bvVar = this.bvg.buL;
                        if (bvVar.EO() != null) {
                            bvVar2 = this.bvg.buL;
                            i2 = bvVar2.EO().getLocationInfoViewState();
                        }
                        switch (i2) {
                            case 0:
                                this.bvg.Ex();
                                return;
                            case 1:
                            default:
                                return;
                            case 2:
                                this.bvg.Ew();
                                return;
                        }
                    } else if (i == 53) {
                        MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null));
                        return;
                    } else {
                        return;
                    }
                }
                alertDialog = this.bvg.ayG;
                if (alertDialog == null) {
                    this.bvg.EB();
                }
                alertDialog2 = this.bvg.ayG;
                if (alertDialog2 == null) {
                    return;
                }
                alertDialog3 = this.bvg.ayG;
                com.baidu.adp.lib.g.j.a(alertDialog3, this.bvg);
            }
        } else {
            gJ = this.bvg.gJ(11027);
            if (gJ) {
                bvVar8 = this.bvg.buL;
                this.bvg.eX(bvVar8.XR());
            }
        }
    }
}
