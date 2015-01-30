package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* loaded from: classes.dex */
class aj implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ af bub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar) {
        this.bub = afVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
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
                                writeImagesInfo = this.bub.aql;
                                if (writeImagesInfo == null) {
                                    return;
                                }
                                writeImagesInfo2 = this.bub.aql;
                                if (writeImagesInfo2.getChosedFiles() == null) {
                                    return;
                                }
                                writeImagesInfo3 = this.bub.aql;
                                int size = writeImagesInfo3.getChosedFiles().size();
                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity activity = this.bub.getActivity();
                                    writeImagesInfo4 = this.bub.aql;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo4, intValue)));
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i == 48) {
                                    com.baidu.tieba.tbadkCore.PbEditor.a.afn();
                                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.afl()) {
                                        this.bub.getPageContext().showToast(com.baidu.tieba.z.baobao_over_limit);
                                        return;
                                    }
                                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bub.getActivity());
                                    aVar.getIntent().putExtra("title", this.bub.getResources().getString(com.baidu.tieba.z.send_reply));
                                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                                    this.bub.getPageContext().sendMessage(new CustomMessage(2802001, aVar));
                                    return;
                                }
                                return;
                            } else {
                                alertDialog = this.bub.aFr;
                                if (alertDialog == null) {
                                    this.bub.Uq();
                                }
                                alertDialog2 = this.bub.aFr;
                                if (alertDialog2 == null) {
                                    return;
                                }
                                alertDialog3 = this.bub.aFr;
                                com.baidu.adp.lib.g.k.a(alertDialog3, this.bub.getPageContext());
                                return;
                            }
                        }
                        writeImagesInfo5 = this.bub.aql;
                        if (writeImagesInfo5 == null) {
                            return;
                        }
                        writeImagesInfo6 = this.bub.aql;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity activity2 = this.bub.getActivity();
                            writeImagesInfo7 = this.bub.aql;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        }
                        return;
                    }
                    writeImagesInfo8 = this.bub.aql;
                    int size2 = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bub.aql;
                    if (size2 >= writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bub.getPageContext().showToast(String.format(this.bub.getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                        return;
                    }
                    this.bub.aBK = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bub.getPageContext();
                    str = this.bub.aBK;
                    bb.a(pageContext, str);
                    return;
                }
                return;
            }
            this.bub.Ur();
            return;
        }
        pbEditor = this.bub.aCF;
        if (pbEditor.FJ()) {
            this.bub.getPageContext().showToast(com.baidu.tieba.z.over_limit_tip);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bub.getActivity(), 12004, true)));
        }
    }
}
