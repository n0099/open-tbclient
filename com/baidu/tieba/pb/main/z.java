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
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bAS = pbActivity;
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
            bzVar10 = this.bAS.bAw;
            if (bzVar10.FD()) {
                this.bAS.showToast(com.baidu.tieba.z.over_limit_tip);
                return;
            }
            gY4 = this.bAS.gY(11025);
            if (gY4) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bAS.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 26) {
            bzVar9 = this.bAS.bAw;
            if (bzVar9.Zk()) {
                this.bAS.showToast(com.baidu.tieba.z.over_limit_tip);
                return;
            }
            gY3 = this.bAS.gY(11026);
            if (gY3) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bAS.getPageContext().getPageActivity(), 12005, true)));
            }
        } else if (i == 10) {
            bqVar2 = this.bAS.bAr;
            if (bqVar2.getPbData() == null) {
                return;
            }
            gY2 = this.bAS.gY(11001);
            if (!gY2) {
                return;
            }
            this.bAS.fu(null);
        } else if (i != 27) {
            if (i == 4) {
                str2 = this.bAS.bAq;
                if (str2 != null) {
                    str3 = this.bAS.bAq;
                    if (str3.length() > 0) {
                        bzVar6 = this.bAS.bAw;
                        bzVar6.setAudioFocusable(false);
                        bzVar7 = this.bAS.bAw;
                        bzVar7.dY(false);
                        PbActivity pbActivity = this.bAS;
                        str4 = this.bAS.bAq;
                        pbActivity.showToast(str4);
                        return;
                    }
                }
                bzVar4 = this.bAS.bAw;
                bzVar4.setAudioFocusable(true);
                bzVar5 = this.bAS.bAw;
                bzVar5.dY(true);
            } else if (i == 54) {
                voiceModel = this.bAS.bAn;
                if (voiceModel != null) {
                    bzVar3 = this.bAS.bAw;
                    voiceModel2 = this.bAS.bAn;
                    bzVar3.setAudioData(voiceModel2);
                }
            } else if (i == 22) {
                writeImagesInfo13 = this.bAS.writeImagesInfo;
                int size = writeImagesInfo13.size();
                writeImagesInfo14 = this.bAS.writeImagesInfo;
                if (size < writeImagesInfo14.getMaxImagesAllowed()) {
                    this.bAS.aBH = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bAS.getPageContext();
                    str = this.bAS.aBH;
                    com.baidu.tbadk.core.util.bb.a(pageContext, str);
                    return;
                }
                this.bAS.showToast(String.format(this.bAS.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
            } else if (i == 23) {
                writeImagesInfo10 = this.bAS.writeImagesInfo;
                if (writeImagesInfo10 != null) {
                    writeImagesInfo11 = this.bAS.writeImagesInfo;
                    if (!TextUtils.isEmpty(writeImagesInfo11.toJsonString())) {
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.bAS.getPageContext().getPageActivity();
                        writeImagesInfo12 = this.bAS.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo12.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else if (i != 13) {
                if (i == 7) {
                    writeImagesInfo7 = this.bAS.writeImagesInfo;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.bAS.writeImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            String valueOf2 = String.valueOf(System.currentTimeMillis());
                            Activity pageActivity2 = this.bAS.getPageContext().getPageActivity();
                            writeImagesInfo9 = this.bAS.writeImagesInfo;
                            AlbumActivityConfig albumActivityConfig2 = new AlbumActivityConfig(pageActivity2, writeImagesInfo9.toJsonString(), valueOf2);
                            albumActivityConfig2.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig2));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.bAS.writeImagesInfo;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.bAS.writeImagesInfo;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.bAS.writeImagesInfo;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity3 = this.bAS.getPageContext().getPageActivity();
                                writeImagesInfo6 = this.bAS.writeImagesInfo;
                                messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(pageActivity3, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i == 48) {
                    com.baidu.tieba.tbadkCore.PbEditor.a.afi();
                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.afg()) {
                        bqVar = this.bAS.bAr;
                        if (bqVar.getIsMem() == 0) {
                            this.bAS.showToast(com.baidu.tieba.z.baobao_over_limit);
                            return;
                        }
                    }
                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bAS.getPageContext().getPageActivity());
                    aVar.getIntent().putExtra("title", this.bAS.getResources().getString(com.baidu.tieba.z.send_reply));
                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                    this.bAS.sendMessage(new CustomMessage(2802001, aVar));
                } else if (i == 51) {
                    writeImagesInfo = this.bAS.baobaoImagesInfo;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.bAS.baobaoImagesInfo;
                        if (writeImagesInfo2.size() > 0) {
                            writeData2 = this.bAS.aDp;
                            writeData2.setIsBaobao(true);
                            return;
                        }
                    }
                    writeData = this.bAS.aDp;
                    writeData.setIsBaobao(false);
                } else if (i == 52) {
                    bzVar = this.bAS.bAw;
                    if (bzVar.Fz() != null) {
                        bzVar2 = this.bAS.bAw;
                        i2 = bzVar2.Fz().getLocationInfoViewState();
                    }
                    switch (i2) {
                        case 0:
                            this.bAS.Fk();
                            return;
                        case 1:
                        default:
                            return;
                        case 2:
                            this.bAS.Fj();
                            return;
                    }
                } else if (i == 53) {
                    MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
                }
            }
        } else {
            gY = this.bAS.gY(11027);
            if (gY) {
                bzVar8 = this.bAS.bAw;
                this.bAS.fu(bzVar8.YT());
            }
        }
    }
}
