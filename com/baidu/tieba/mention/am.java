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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
class am implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ ai bGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.bGE = aiVar;
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
                                writeImagesInfo = this.bGE.mWriteImagesInfo;
                                if (writeImagesInfo == null) {
                                    return;
                                }
                                writeImagesInfo2 = this.bGE.mWriteImagesInfo;
                                if (writeImagesInfo2.getChosedFiles() == null) {
                                    return;
                                }
                                writeImagesInfo3 = this.bGE.mWriteImagesInfo;
                                int size = writeImagesInfo3.getChosedFiles().size();
                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity activity = this.bGE.getActivity();
                                    writeImagesInfo4 = this.bGE.mWriteImagesInfo;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo4, intValue)));
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i == 48) {
                                    com.baidu.tieba.tbadkCore.PbEditor.a.amX();
                                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.amV()) {
                                        this.bGE.getPageContext().showToast(com.baidu.tieba.t.baobao_over_limit);
                                        return;
                                    }
                                    com.baidu.tbadk.core.frameworkData.c cVar = new com.baidu.tbadk.core.frameworkData.c(this.bGE.getActivity());
                                    cVar.getIntent().putExtra("title", this.bGE.getResources().getString(com.baidu.tieba.t.send_reply));
                                    cVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                                    this.bGE.getPageContext().sendMessage(new CustomMessage(2802001, cVar));
                                    return;
                                }
                                return;
                            } else {
                                eVar = this.bGE.aNG;
                                if (eVar == null) {
                                    this.bGE.Zr();
                                }
                                eVar2 = this.bGE.aNG;
                                if (eVar2 == null) {
                                    return;
                                }
                                eVar3 = this.bGE.aNG;
                                eVar3.rN();
                                return;
                            }
                        }
                        writeImagesInfo5 = this.bGE.mWriteImagesInfo;
                        if (writeImagesInfo5 == null) {
                            return;
                        }
                        writeImagesInfo6 = this.bGE.mWriteImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity activity2 = this.bGE.getActivity();
                            writeImagesInfo7 = this.bGE.mWriteImagesInfo;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        }
                        return;
                    }
                    writeImagesInfo8 = this.bGE.mWriteImagesInfo;
                    int size2 = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bGE.mWriteImagesInfo;
                    if (size2 >= writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bGE.getPageContext().showToast(String.format(this.bGE.getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
                        return;
                    }
                    this.bGE.aJR = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bGE.getPageContext();
                    str = this.bGE.aJR;
                    ax.a(pageContext, str);
                    return;
                }
                return;
            }
            this.bGE.Zs();
            return;
        }
        pbEditor = this.bGE.aKO;
        if (pbEditor.Km()) {
            this.bGE.getPageContext().showToast(com.baidu.tieba.t.over_limit_tip);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bGE.getActivity(), 12004, true)));
        }
    }
}
