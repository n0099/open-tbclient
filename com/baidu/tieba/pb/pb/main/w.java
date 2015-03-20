package com.baidu.tieba.pb.pb.main;

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
public class w implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        ci ciVar;
        ci ciVar2;
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
        ci ciVar3;
        VoiceData.VoiceModel voiceModel2;
        String str2;
        ci ciVar4;
        ci ciVar5;
        String str3;
        ci ciVar6;
        ci ciVar7;
        String str4;
        boolean hh;
        ci ciVar8;
        bq bqVar2;
        boolean hh2;
        ci ciVar9;
        boolean hh3;
        ci ciVar10;
        boolean hh4;
        int i2 = 0;
        if (i == 0) {
            ciVar10 = this.bIv.bHY;
            if (ciVar10.Jc()) {
                this.bIv.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            hh4 = this.bIv.hh(11025);
            if (hh4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bIv.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 26) {
            ciVar9 = this.bIv.bHY;
            if (ciVar9.abu()) {
                this.bIv.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            hh3 = this.bIv.hh(11026);
            if (hh3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bIv.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 10) {
            bqVar2 = this.bIv.bHT;
            if (bqVar2.getPbData() == null) {
                return;
            }
            hh2 = this.bIv.hh(11001);
            if (!hh2) {
                return;
            }
            this.bIv.fD(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bIv.bHS;
                if (str2 != null) {
                    str3 = this.bIv.bHS;
                    if (str3.length() > 0) {
                        ciVar6 = this.bIv.bHY;
                        ciVar6.setAudioFocusable(false);
                        ciVar7 = this.bIv.bHY;
                        ciVar7.dV(false);
                        PbActivity pbActivity = this.bIv;
                        str4 = this.bIv.bHS;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                ciVar4 = this.bIv.bHY;
                ciVar4.setAudioFocusable(true);
                ciVar5 = this.bIv.bHY;
                ciVar5.dV(true);
            } else if (i == 54) {
                voiceModel = this.bIv.bHO;
                if (voiceModel != null) {
                    ciVar3 = this.bIv.bHY;
                    voiceModel2 = this.bIv.bHO;
                    ciVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo13 = this.bIv.writeImagesInfo;
                int size = writeImagesInfo13.size();
                writeImagesInfo14 = this.bIv.writeImagesInfo;
                if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                    this.bIv.aHA = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bIv.getPageContext();
                    str = this.bIv.aHA;
                    com.baidu.tbadk.core.util.az.a(pageContext, str);
                    return;
                }
                this.bIv.showToast(String.format(this.bIv.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo10 = this.bIv.writeImagesInfo;
                if (writeImagesInfo10 != null) {
                    writeImagesInfo11 = this.bIv.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.bIv.getPageContext().getPageActivity();
                        writeImagesInfo12 = this.bIv.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i == 7) {
                writeImagesInfo7 = this.bIv.writeImagesInfo;
                if (writeImagesInfo7 != null) {
                    writeImagesInfo8 = this.bIv.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                        String valueOf2 = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity2 = this.bIv.getPageContext().getPageActivity();
                        writeImagesInfo9 = this.bIv.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo9.toJsonString(), valueOf2);
                        albumActivityConfig2.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                    }
                }
            } else if (i == 42) {
                int intValue = ((Integer) obj).intValue();
                writeImagesInfo3 = this.bIv.writeImagesInfo;
                if (writeImagesInfo3 != null) {
                    writeImagesInfo4 = this.bIv.writeImagesInfo;
                    if (writeImagesInfo4.getChosedFiles() != null) {
                        writeImagesInfo5 = this.bIv.writeImagesInfo;
                        int size2 = writeImagesInfo5.getChosedFiles().size();
                        if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                            MessageManager messageManager = MessageManager.getInstance();
                            Activity pageActivity3 = this.bIv.getPageContext().getPageActivity();
                            writeImagesInfo6 = this.bIv.writeImagesInfo;
                            messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity3, 12012, writeImagesInfo6, intValue)));
                        }
                    }
                }
            } else if (i == 48) {
                com.baidu.tieba.tbadkCore.PbEditor.a.akX();
                if (!com.baidu.tieba.tbadkCore.PbEditor.a.akV()) {
                    bqVar = this.bIv.bHT;
                    if (bqVar.getIsMem() == 0) {
                        this.bIv.showToast(com.baidu.tieba.y.baobao_over_limit);
                        return;
                    }
                }
                com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bIv.getPageContext().getPageActivity());
                aVar.getIntent().putExtra("title", this.bIv.getResources().getString(com.baidu.tieba.y.send_reply));
                aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                this.bIv.sendMessage(new CustomMessage(2802001, aVar));
            } else if (i == 51) {
                writeImagesInfo = this.bIv.baobaoImagesInfo;
                if (writeImagesInfo != null) {
                    writeImagesInfo2 = this.bIv.baobaoImagesInfo;
                    if (writeImagesInfo2.size() > 0) {
                        writeData2 = this.bIv.bHP;
                        writeData2.setIsBaobao(true);
                        return;
                    }
                }
                writeData = this.bIv.bHP;
                writeData.setIsBaobao(false);
            } else if (i == 52) {
                ciVar = this.bIv.bHY;
                if (ciVar.IY() != null) {
                    ciVar2 = this.bIv.bHY;
                    i2 = ciVar2.IY().getLocationInfoViewState();
                }
                switch (i2) {
                    case 0:
                        this.bIv.IJ();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        this.bIv.II();
                        return;
                }
            } else if (i == 53) {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            }
        } else {
            hh = this.bIv.hh(11027);
            if (hh) {
                ciVar8 = this.bIv.bHY;
                this.bIv.fD(ciVar8.abd());
            }
        }
    }
}
