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
    final /* synthetic */ af bua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar) {
        this.bua = afVar;
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
                                writeImagesInfo = this.bua.aqi;
                                if (writeImagesInfo == null) {
                                    return;
                                }
                                writeImagesInfo2 = this.bua.aqi;
                                if (writeImagesInfo2.getChosedFiles() == null) {
                                    return;
                                }
                                writeImagesInfo3 = this.bua.aqi;
                                int size = writeImagesInfo3.getChosedFiles().size();
                                if (size >= 1 && intValue >= 0 && intValue < size) {
                                    MessageManager messageManager = MessageManager.getInstance();
                                    Activity activity = this.bua.getActivity();
                                    writeImagesInfo4 = this.bua.aqi;
                                    messageManager.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity, 12012, writeImagesInfo4, intValue)));
                                    return;
                                }
                                return;
                            } else if (i != 7) {
                                if (i == 48) {
                                    com.baidu.tieba.tbadkCore.PbEditor.a.afi();
                                    if (!com.baidu.tieba.tbadkCore.PbEditor.a.afg()) {
                                        this.bua.getPageContext().showToast(com.baidu.tieba.z.baobao_over_limit);
                                        return;
                                    }
                                    com.baidu.tbadk.core.frameworkData.a aVar = new com.baidu.tbadk.core.frameworkData.a(this.bua.getActivity());
                                    aVar.getIntent().putExtra("title", this.bua.getResources().getString(com.baidu.tieba.z.send_reply));
                                    aVar.getIntent().putExtra(GroupInfoActivityConfig.REQUEST_CODE, 12013);
                                    this.bua.getPageContext().sendMessage(new CustomMessage(2802001, aVar));
                                    return;
                                }
                                return;
                            } else {
                                alertDialog = this.bua.aFo;
                                if (alertDialog == null) {
                                    this.bua.Ul();
                                }
                                alertDialog2 = this.bua.aFo;
                                if (alertDialog2 == null) {
                                    return;
                                }
                                alertDialog3 = this.bua.aFo;
                                com.baidu.adp.lib.g.k.a(alertDialog3, this.bua.getPageContext());
                                return;
                            }
                        }
                        writeImagesInfo5 = this.bua.aqi;
                        if (writeImagesInfo5 == null) {
                            return;
                        }
                        writeImagesInfo6 = this.bua.aqi;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            Activity activity2 = this.bua.getActivity();
                            writeImagesInfo7 = this.bua.aqi;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity2, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                            return;
                        }
                        return;
                    }
                    writeImagesInfo8 = this.bua.aqi;
                    int size2 = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bua.aqi;
                    if (size2 >= writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bua.getPageContext().showToast(String.format(this.bua.getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
                        return;
                    }
                    this.bua.aBH = String.valueOf(System.currentTimeMillis());
                    TbPageContext pageContext = this.bua.getPageContext();
                    str = this.bua.aBH;
                    bb.a(pageContext, str);
                    return;
                }
                return;
            }
            this.bua.Um();
            return;
        }
        pbEditor = this.bua.aCC;
        if (pbEditor.FD()) {
            this.bua.getPageContext().showToast(com.baidu.tieba.z.over_limit_tip);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bua.getActivity(), 12004, true)));
        }
    }
}
