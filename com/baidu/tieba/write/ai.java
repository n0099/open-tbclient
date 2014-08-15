package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        String str;
        if (i == 0) {
            writeImagesInfo4 = this.a.D;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.a.D;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.a.F = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity = this.a;
                str = this.a.F;
                com.baidu.tbadk.core.util.ax.a(writeActivity, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
        } else if (i == 1) {
            writeImagesInfo = this.a.D;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.D;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    WriteActivity writeActivity2 = this.a;
                    writeImagesInfo3 = this.a.D;
                    com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(writeActivity2, writeImagesInfo3.toJsonString());
                    bVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                }
            }
        }
    }
}
