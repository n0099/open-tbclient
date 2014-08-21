package com.baidu.tieba.mention;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(al alVar) {
        this.a = alVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        Activity activity;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        Activity activity2;
        String str;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        if (i == 0) {
            writeImagesInfo4 = this.a.q;
            if (writeImagesInfo4.getChosedFiles() != null) {
                writeImagesInfo5 = this.a.q;
                int size = writeImagesInfo5.getChosedFiles().size();
                writeImagesInfo6 = this.a.q;
                if (size >= writeImagesInfo6.getMaxImagesAllowed()) {
                    this.a.b(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
                    return;
                }
            }
            this.a.r = String.valueOf(System.currentTimeMillis());
            activity2 = this.a.e;
            str = this.a.r;
            com.baidu.tbadk.core.util.ax.a(activity2, str);
        } else if (i == 1) {
            writeImagesInfo = this.a.q;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.q;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    activity = this.a.e;
                    writeImagesInfo3 = this.a.q;
                    com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(activity, writeImagesInfo3.toJsonString());
                    bVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                }
            }
        }
    }
}
