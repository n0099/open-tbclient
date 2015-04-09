package com.baidu.tieba.mention;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ ai bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ai aiVar) {
        this.bDJ = aiVar;
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
            writeImagesInfo4 = this.bDJ.aHL;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.bDJ.aHL;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.bDJ.aHL;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.bDJ.getPageContext().showToast(String.format(this.bDJ.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.bDJ.aHI = String.valueOf(System.currentTimeMillis());
            TbPageContext pageContext = this.bDJ.getPageContext();
            str = this.bDJ.aHI;
            az.a(pageContext, str);
        } else if (i == 1) {
            writeImagesInfo = this.bDJ.aHL;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.bDJ.aHL;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    Activity activity = this.bDJ.getActivity();
                    writeImagesInfo3 = this.bDJ.aHL;
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity, writeImagesInfo3.toJsonString());
                    albumActivityConfig.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                }
            }
        }
    }
}
