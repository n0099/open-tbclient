package com.baidu.tieba.mention;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ ai bGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ai aiVar) {
        this.bGE = aiVar;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        eVar.dismiss();
        if (i == 0) {
            writeImagesInfo4 = this.bGE.mWriteImagesInfo;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bGE.mWriteImagesInfo;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bGE.mWriteImagesInfo;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bGE.getPageContext().showToast(String.format(this.bGE.getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bGE.aJR = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bGE.getPageContext();
            str = this.bGE.aJR;
            ax.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.bGE.mWriteImagesInfo;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bGE.mWriteImagesInfo;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity activity = this.bGE.getActivity();
                    writeImagesInfo3 = this.bGE.mWriteImagesInfo;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
