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
public class v implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        ch chVar;
        ch chVar2;
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        bo boVar;
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
        ch chVar3;
        VoiceData.VoiceModel voiceModel2;
        String str2;
        String str3;
        String str4;
        bo boVar2;
        boolean hx;
        ch chVar4;
        boolean hx2;
        int i2 = 0;
        if (i == 0) {
            chVar4 = this.bKT.bKz;
            if (chVar4.Km()) {
                this.bKT.showToast(com.baidu.tieba.t.over_limit_tip);
                return;
            }
            hx2 = this.bKT.hx(11025);
            if (hx2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bKT.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 10) {
            boVar2 = this.bKT.bKv;
            if (boVar2.getPbData() == null) {
                return;
            }
            hx = this.bKT.hx(11001);
            if (!hx) {
                return;
            }
            this.bKT.gg(null);
        } else if (i == 4) {
            str2 = this.bKT.bKu;
            if (str2 != null) {
                str3 = this.bKT.bKu;
                if (str3.length() > 0) {
                    PbActivity pbActivity = this.bKT;
                    str4 = this.bKT.bKu;
                    pbActivity.showToast(str4);
                }
            }
        } else if (i == 54) {
            voiceModel = this.bKT.bKq;
            if (voiceModel != null) {
                chVar3 = this.bKT.bKz;
                voiceModel2 = this.bKT.bKq;
                chVar3.setAudioData(voiceModel2);
            }
        } else if (i == 22) {
            writeImagesInfo13 = this.bKT.writeImagesInfo;
            int size = writeImagesInfo13.size();
            writeImagesInfo14 = this.bKT.writeImagesInfo;
            if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                this.bKT.aJR = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.bKT.getPageContext();
                str = this.bKT.aJR;
                com.baidu.tbadk.core.util.ax.a(pageContext, str);
                return;
            }
            this.bKT.showToast(String.format(this.bKT.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
        } else if (i == 23) {
            writeImagesInfo10 = this.bKT.writeImagesInfo;
            if (writeImagesInfo10 != null) {
                writeImagesInfo11 = this.bKT.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity = this.bKT.getPageContext().getPageActivity();
                    writeImagesInfo12 = this.bKT.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        } else if (i == 7) {
            writeImagesInfo7 = this.bKT.writeImagesInfo;
            if (writeImagesInfo7 != null) {
                writeImagesInfo8 = this.bKT.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity2 = this.bKT.getPageContext().getPageActivity();
                    writeImagesInfo9 = this.bKT.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo9.toJsonString(), valueOf2);
                    albumActivityConfig2.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                }
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo3 = this.bKT.writeImagesInfo;
            if (writeImagesInfo3 != null) {
                writeImagesInfo4 = this.bKT.writeImagesInfo;
                if (writeImagesInfo4.getChosedFiles() != null) {
                    writeImagesInfo5 = this.bKT.writeImagesInfo;
                    int size2 = writeImagesInfo5.getChosedFiles().size();
                    if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity3 = this.bKT.getPageContext().getPageActivity();
                        writeImagesInfo6 = this.bKT.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity3, 12012, writeImagesInfo6, intValue)));
                    }
                }
            }
        } else if (i == 48) {
            com.baidu.tieba.tbadkCore.PbEditor.a.amX();
            if (!com.baidu.tieba.tbadkCore.PbEditor.a.amV()) {
                boVar = this.bKT.bKv;
                if (boVar.getIsMem() == 0) {
                    this.bKT.showToast(com.baidu.tieba.t.baobao_over_limit);
                    return;
                }
            }
            com.baidu.tbadk.core.frameworkData.c cVar = new com.baidu.tbadk.core.frameworkData.c(this.bKT.getPageContext().getPageActivity());
            cVar.getIntent().putExtra("title", this.bKT.getResources().getString(com.baidu.tieba.t.send_reply));
            cVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            this.bKT.sendMessage(new CustomMessage(2802001, cVar));
        } else if (i == 51) {
            writeImagesInfo = this.bKT.baobaoImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bKT.baobaoImagesInfo;
                if (writeImagesInfo2.size() > 0) {
                    writeData2 = this.bKT.bKr;
                    writeData2.setIsBaobao(true);
                    return;
                }
            }
            writeData = this.bKT.bKr;
            writeData.setIsBaobao(false);
        } else if (i == 52) {
            chVar = this.bKT.bKz;
            if (chVar.Ki() != null) {
                chVar2 = this.bKT.bKz;
                i2 = chVar2.Ki().getLocationInfoViewState();
            }
            switch (i2) {
                case 0:
                    this.bKT.JP();
                    return;
                case 1:
                default:
                    return;
                case 2:
                    this.bKT.JO();
                    return;
            }
        } else if (i == 53) {
            MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
        }
    }
}
