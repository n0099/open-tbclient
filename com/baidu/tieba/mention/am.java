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
    final /* synthetic */ ai bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ai aiVar) {
        this.bGF = aiVar;
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
                                writeImagesInfo = this.bGF.mWriteImagesInfo;
                                if (writeImagesInfo == null) {
                                    return;
                                }
                                writeImagesInfo2 = this.bGF.mWriteImagesInfo;
                                if (writeImagesInfo2.getChosedFiles() == null) {
                                    return;
                                }
                                writeImagesInfo3 = this.bGF.mWriteImagesInfo;
                                int size = writeImagesInfo3.getChosedFiles().size();
                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity activity = this.bGF.getActivity();
                                    writeImagesInfo4 = this.bGF.mWriteImagesInfo;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo4, intValue)));
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i == 48) {
                                    com.baidu.tieba.tbadkCore.PbEditor.a.amY();
                                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.amW()) {
                                        this.bGF.getPageContext().showToast(com.baidu.tieba.t.baobao_over_limit);
                                        return;
                                    }
                                    com.baidu.tbadk.core.frameworkData.c cVar = new com.baidu.tbadk.core.frameworkData.c(this.bGF.getActivity());
                                    cVar.getIntent().putExtra("title", this.bGF.getResources().getString(com.baidu.tieba.t.send_reply));
                                    cVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                                    this.bGF.getPageContext().sendMessage(new CustomMessage(2802001, cVar));
                                    return;
                                }
                                return;
                            } else {
                                eVar = this.bGF.aNH;
                                if (eVar == null) {
                                    this.bGF.Zs();
                                }
                                eVar2 = this.bGF.aNH;
                                if (eVar2 == null) {
                                    return;
                                }
                                eVar3 = this.bGF.aNH;
                                eVar3.rN();
                                return;
                            }
                        }
                        writeImagesInfo5 = this.bGF.mWriteImagesInfo;
                        if (writeImagesInfo5 == null) {
                            return;
                        }
                        writeImagesInfo6 = this.bGF.mWriteImagesInfo;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity activity2 = this.bGF.getActivity();
                            writeImagesInfo7 = this.bGF.mWriteImagesInfo;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        }
                        return;
                    }
                    writeImagesInfo8 = this.bGF.mWriteImagesInfo;
                    int size2 = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bGF.mWriteImagesInfo;
                    if (size2 >= writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bGF.getPageContext().showToast(String.format(this.bGF.getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
                        return;
                    }
                    this.bGF.aJS = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bGF.getPageContext();
                    str = this.bGF.aJS;
                    ax.a(pageContext, str);
                    return;
                }
                return;
            }
            this.bGF.Zt();
            return;
        }
        pbEditor = this.bGF.aKP;
        if (pbEditor.Kn()) {
            this.bGF.getPageContext().showToast(com.baidu.tieba.t.over_limit_tip);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bGF.getActivity(), 12004, true)));
        }
    }
}
