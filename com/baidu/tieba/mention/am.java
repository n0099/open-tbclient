package com.baidu.tieba.mention;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
class am implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ ai bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.bDJ = aiVar;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        com.baidu.tbadk.core.dialog.e eVar;
        com.baidu.tbadk.core.dialog.e eVar2;
        com.baidu.tbadk.core.dialog.e eVar3;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        String str;
        PbEditor pbEditor;
        if (i != 0) {
            if (i != 10) {
                if (i != 4) {
                    if (i != 22) {
                        if (i != 23) {
                            if (i == 42) {
                                int intValue = ((Integer) obj).intValue();
                                writeImagesInfo = this.bDJ.aHL;
                                if (writeImagesInfo == null) {
                                    return;
                                }
                                writeImagesInfo2 = this.bDJ.aHL;
                                if (writeImagesInfo2.getChosedFiles() == null) {
                                    return;
                                }
                                writeImagesInfo3 = this.bDJ.aHL;
                                int size = writeImagesInfo3.getChosedFiles().size();
                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity activity = this.bDJ.getActivity();
                                    writeImagesInfo4 = this.bDJ.aHL;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo4, intValue)));
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i == 48) {
                                    com.baidu.tieba.tbadkCore.PbEditor.a.alm();
                                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.alk()) {
                                        this.bDJ.getPageContext().showToast(com.baidu.tieba.y.baobao_over_limit);
                                        return;
                                    }
                                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bDJ.getActivity());
                                    aVar.getIntent().putExtra("title", this.bDJ.getResources().getString(com.baidu.tieba.y.send_reply));
                                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                                    this.bDJ.getPageContext().sendMessage(new CustomMessage(2802001, aVar));
                                    return;
                                }
                                return;
                            } else {
                                eVar = this.bDJ.aLx;
                                if (eVar == null) {
                                    this.bDJ.XS();
                                }
                                eVar2 = this.bDJ.aLx;
                                if (eVar2 == null) {
                                    return;
                                }
                                eVar3 = this.bDJ.aLx;
                                eVar3.rg();
                                return;
                            }
                        }
                        writeImagesInfo5 = this.bDJ.aHL;
                        if (writeImagesInfo5 == null) {
                            return;
                        }
                        writeImagesInfo6 = this.bDJ.aHL;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity activity2 = this.bDJ.getActivity();
                            writeImagesInfo7 = this.bDJ.aHL;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        }
                        return;
                    }
                    writeImagesInfo8 = this.bDJ.aHL;
                    int size2 = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bDJ.aHL;
                    if (size2 >= writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bDJ.getPageContext().showToast(String.format(this.bDJ.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                        return;
                    }
                    this.bDJ.aHI = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bDJ.getPageContext();
                    str = this.bDJ.aHI;
                    az.a(pageContext, str);
                    return;
                }
                return;
            }
            this.bDJ.XT();
            return;
        }
        pbEditor = this.bDJ.aIG;
        if (pbEditor.Ji()) {
            this.bDJ.getPageContext().showToast(com.baidu.tieba.y.over_limit_tip);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bDJ.getActivity(), 12004, true)));
        }
    }
}
