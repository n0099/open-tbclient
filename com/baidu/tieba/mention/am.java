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
    final /* synthetic */ ai bDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.bDw = aiVar;
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
                                writeImagesInfo = this.bDw.aHD;
                                if (writeImagesInfo == null) {
                                    return;
                                }
                                writeImagesInfo2 = this.bDw.aHD;
                                if (writeImagesInfo2.getChosedFiles() == null) {
                                    return;
                                }
                                writeImagesInfo3 = this.bDw.aHD;
                                int size = writeImagesInfo3.getChosedFiles().size();
                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity activity = this.bDw.getActivity();
                                    writeImagesInfo4 = this.bDw.aHD;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo4, intValue)));
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i == 48) {
                                    com.baidu.tieba.tbadkCore.PbEditor.a.akX();
                                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.akV()) {
                                        this.bDw.getPageContext().showToast(com.baidu.tieba.y.baobao_over_limit);
                                        return;
                                    }
                                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bDw.getActivity());
                                    aVar.getIntent().putExtra("title", this.bDw.getResources().getString(com.baidu.tieba.y.send_reply));
                                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                                    this.bDw.getPageContext().sendMessage(new CustomMessage(2802001, aVar));
                                    return;
                                }
                                return;
                            } else {
                                eVar = this.bDw.aLn;
                                if (eVar == null) {
                                    this.bDw.XG();
                                }
                                eVar2 = this.bDw.aLn;
                                if (eVar2 == null) {
                                    return;
                                }
                                eVar3 = this.bDw.aLn;
                                eVar3.rg();
                                return;
                            }
                        }
                        writeImagesInfo5 = this.bDw.aHD;
                        if (writeImagesInfo5 == null) {
                            return;
                        }
                        writeImagesInfo6 = this.bDw.aHD;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity activity2 = this.bDw.getActivity();
                            writeImagesInfo7 = this.bDw.aHD;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        }
                        return;
                    }
                    writeImagesInfo8 = this.bDw.aHD;
                    int size2 = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bDw.aHD;
                    if (size2 >= writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bDw.getPageContext().showToast(String.format(this.bDw.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                        return;
                    }
                    this.bDw.aHA = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bDw.getPageContext();
                    str = this.bDw.aHA;
                    az.a(pageContext, str);
                    return;
                }
                return;
            }
            this.bDw.XH();
            return;
        }
        pbEditor = this.bDw.aIy;
        if (pbEditor.Jc()) {
            this.bDw.getPageContext().showToast(com.baidu.tieba.y.over_limit_tip);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bDw.getActivity(), 12004, true)));
        }
    }
}
