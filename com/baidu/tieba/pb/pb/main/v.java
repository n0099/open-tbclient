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
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.bKU = pbActivity;
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
            chVar4 = this.bKU.bKA;
            if (chVar4.Kn()) {
                this.bKU.showToast(com.baidu.tieba.t.over_limit_tip);
                return;
            }
            hx2 = this.bKU.hx(11025);
            if (hx2) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bKU.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 10) {
            boVar2 = this.bKU.bKw;
            if (boVar2.getPbData() == null) {
                return;
            }
            hx = this.bKU.hx(11001);
            if (!hx) {
                return;
            }
            this.bKU.gg(null);
        } else if (i == 4) {
            str2 = this.bKU.bKv;
            if (str2 != null) {
                str3 = this.bKU.bKv;
                if (str3.length() > 0) {
                    PbActivity pbActivity = this.bKU;
                    str4 = this.bKU.bKv;
                    pbActivity.showToast(str4);
                }
            }
        } else if (i == 54) {
            voiceModel = this.bKU.bKr;
            if (voiceModel != null) {
                chVar3 = this.bKU.bKA;
                voiceModel2 = this.bKU.bKr;
                chVar3.setAudioData(voiceModel2);
            }
        } else if (i == 22) {
            writeImagesInfo13 = this.bKU.writeImagesInfo;
            int size = writeImagesInfo13.size();
            writeImagesInfo14 = this.bKU.writeImagesInfo;
            if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                this.bKU.aJS = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.bKU.getPageContext();
                str = this.bKU.aJS;
                com.baidu.tbadk.core.util.ax.a(pageContext, str);
                return;
            }
            this.bKU.showToast(String.format(this.bKU.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
        } else if (i == 23) {
            writeImagesInfo10 = this.bKU.writeImagesInfo;
            if (writeImagesInfo10 != null) {
                writeImagesInfo11 = this.bKU.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                    String valueOf = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity = this.bKU.getPageContext().getPageActivity();
                    writeImagesInfo12 = this.bKU.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString(), valueOf);
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        } else if (i == 7) {
            writeImagesInfo7 = this.bKU.writeImagesInfo;
            if (writeImagesInfo7 != null) {
                writeImagesInfo8 = this.bKU.writeImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                    String valueOf2 = String.valueOf(System.currentTimeMillis());
                    Activity pageActivity2 = this.bKU.getPageContext().getPageActivity();
                    writeImagesInfo9 = this.bKU.writeImagesInfo;
                    AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo9.toJsonString(), valueOf2);
                    albumActivityConfig2.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                }
            }
        } else if (i == 42) {
            int intValue = ((Integer) obj).intValue();
            writeImagesInfo3 = this.bKU.writeImagesInfo;
            if (writeImagesInfo3 != null) {
                writeImagesInfo4 = this.bKU.writeImagesInfo;
                if (writeImagesInfo4.getChosedFiles() != null) {
                    writeImagesInfo5 = this.bKU.writeImagesInfo;
                    int size2 = writeImagesInfo5.getChosedFiles().size();
                    if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                        MessageManager messageManager = MessageManager.getInstance();
                        Activity pageActivity3 = this.bKU.getPageContext().getPageActivity();
                        writeImagesInfo6 = this.bKU.writeImagesInfo;
                        messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity3, 12012, writeImagesInfo6, intValue)));
                    }
                }
            }
        } else if (i == 48) {
            com.baidu.tieba.tbadkCore.PbEditor.a.amY();
            if (!com.baidu.tieba.tbadkCore.PbEditor.a.amW()) {
                boVar = this.bKU.bKw;
                if (boVar.getIsMem() == 0) {
                    this.bKU.showToast(com.baidu.tieba.t.baobao_over_limit);
                    return;
                }
            }
            com.baidu.tbadk.core.frameworkData.c cVar = new com.baidu.tbadk.core.frameworkData.c(this.bKU.getPageContext().getPageActivity());
            cVar.getIntent().putExtra("title", this.bKU.getResources().getString(com.baidu.tieba.t.send_reply));
            cVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
            this.bKU.sendMessage(new CustomMessage(2802001, cVar));
        } else if (i == 51) {
            writeImagesInfo = this.bKU.baobaoImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bKU.baobaoImagesInfo;
                if (writeImagesInfo2.size() > 0) {
                    writeData2 = this.bKU.bKs;
                    writeData2.setIsBaobao(true);
                    return;
                }
            }
            writeData = this.bKU.bKs;
            writeData.setIsBaobao(false);
        } else if (i == 52) {
            chVar = this.bKU.bKA;
            if (chVar.Kj() != null) {
                chVar2 = this.bKU.bKA;
                i2 = chVar2.Kj().getLocationInfoViewState();
            }
            switch (i2) {
                case 0:
                    this.bKU.JQ();
                    return;
                case 1:
                default:
                    return;
                case 2:
                    this.bKU.JP();
                    return;
            }
        } else if (i == 53) {
            MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
        }
    }
}
