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
public class y implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        cj cjVar;
        cj cjVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        br brVar;
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
        cj cjVar3;
        VoiceData.VoiceModel voiceModel2;
        String str2;
        cj cjVar4;
        cj cjVar5;
        String str3;
        cj cjVar6;
        cj cjVar7;
        String str4;
        boolean hj;
        cj cjVar8;
        br brVar2;
        boolean hj2;
        cj cjVar9;
        boolean hj3;
        cj cjVar10;
        boolean hj4;
        int i2 = 0;
        if (i == 0) {
            cjVar10 = this.bIJ.bIl;
            if (cjVar10.Ji()) {
                this.bIJ.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            hj4 = this.bIJ.hj(11025);
            if (hj4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bIJ.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 26) {
            cjVar9 = this.bIJ.bIl;
            if (cjVar9.abJ()) {
                this.bIJ.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            hj3 = this.bIJ.hj(11026);
            if (hj3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bIJ.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 10) {
            brVar2 = this.bIJ.bIg;
            if (brVar2.getPbData() == null) {
                return;
            }
            hj2 = this.bIJ.hj(11001);
            if (!hj2) {
                return;
            }
            this.bIJ.fG(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bIJ.bIf;
                if (str2 != null) {
                    str3 = this.bIJ.bIf;
                    if (str3.length() > 0) {
                        cjVar6 = this.bIJ.bIl;
                        cjVar6.setAudioFocusable(false);
                        cjVar7 = this.bIJ.bIl;
                        cjVar7.dT(false);
                        PbActivity pbActivity = this.bIJ;
                        str4 = this.bIJ.bIf;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                cjVar4 = this.bIJ.bIl;
                cjVar4.setAudioFocusable(true);
                cjVar5 = this.bIJ.bIl;
                cjVar5.dT(true);
            } else if (i == 54) {
                voiceModel = this.bIJ.bIb;
                if (voiceModel != null) {
                    cjVar3 = this.bIJ.bIl;
                    voiceModel2 = this.bIJ.bIb;
                    cjVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo13 = this.bIJ.writeImagesInfo;
                int size = writeImagesInfo13.size();
                writeImagesInfo14 = this.bIJ.writeImagesInfo;
                if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                    this.bIJ.aHI = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bIJ.getPageContext();
                    str = this.bIJ.aHI;
                    com.baidu.tbadk.core.util.az.a(pageContext, str);
                    return;
                }
                this.bIJ.showToast(String.format(this.bIJ.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo10 = this.bIJ.writeImagesInfo;
                if (writeImagesInfo10 != null) {
                    writeImagesInfo11 = this.bIJ.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.bIJ.getPageContext().getPageActivity();
                        writeImagesInfo12 = this.bIJ.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i == 7) {
                writeImagesInfo7 = this.bIJ.writeImagesInfo;
                if (writeImagesInfo7 != null) {
                    writeImagesInfo8 = this.bIJ.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                        String valueOf2 = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity2 = this.bIJ.getPageContext().getPageActivity();
                        writeImagesInfo9 = this.bIJ.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo9.toJsonString(), valueOf2);
                        albumActivityConfig2.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                    }
                }
            } else if (i == 42) {
                int intValue = ((Integer) obj).intValue();
                writeImagesInfo3 = this.bIJ.writeImagesInfo;
                if (writeImagesInfo3 != null) {
                    writeImagesInfo4 = this.bIJ.writeImagesInfo;
                    if (writeImagesInfo4.getChosedFiles() != null) {
                        writeImagesInfo5 = this.bIJ.writeImagesInfo;
                        int size2 = writeImagesInfo5.getChosedFiles().size();
                        if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                            MessageManager messageManager = MessageManager.getInstance();
                            Activity pageActivity3 = this.bIJ.getPageContext().getPageActivity();
                            writeImagesInfo6 = this.bIJ.writeImagesInfo;
                            messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity3, 12012, writeImagesInfo6, intValue)));
                        }
                    }
                }
            } else if (i == 48) {
                com.baidu.tieba.tbadkCore.PbEditor.a.alm();
                if (!com.baidu.tieba.tbadkCore.PbEditor.a.alk()) {
                    brVar = this.bIJ.bIg;
                    if (brVar.getIsMem() == 0) {
                        this.bIJ.showToast(com.baidu.tieba.y.baobao_over_limit);
                        return;
                    }
                }
                com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bIJ.getPageContext().getPageActivity());
                aVar.getIntent().putExtra("title", this.bIJ.getResources().getString(com.baidu.tieba.y.send_reply));
                aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                this.bIJ.sendMessage(new CustomMessage(2802001, aVar));
            } else if (i == 51) {
                writeImagesInfo = this.bIJ.baobaoImagesInfo;
                if (writeImagesInfo != null) {
                    writeImagesInfo2 = this.bIJ.baobaoImagesInfo;
                    if (writeImagesInfo2.size() > 0) {
                        writeData2 = this.bIJ.bIc;
                        writeData2.setIsBaobao(true);
                        return;
                    }
                }
                writeData = this.bIJ.bIc;
                writeData.setIsBaobao(false);
            } else if (i == 52) {
                cjVar = this.bIJ.bIl;
                if (cjVar.Je() != null) {
                    cjVar2 = this.bIJ.bIl;
                    i2 = cjVar2.Je().getLocationInfoViewState();
                }
                switch (i2) {
                    case 0:
                        this.bIJ.IP();
                        return;
                    case 1:
                    default:
                        return;
                    case 2:
                        this.bIJ.IO();
                        return;
                }
            } else if (i == 53) {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            }
        } else {
            hj = this.bIJ.hj(11027);
            if (hj) {
                cjVar8 = this.bIJ.bIl;
                this.bIJ.fG(cjVar8.abr());
            }
        }
    }
}
