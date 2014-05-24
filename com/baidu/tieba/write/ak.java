package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
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
            writeImagesInfo4 = this.a.C;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.a.C;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.a.D = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity = this.a;
                str = this.a.D;
                com.baidu.tbadk.core.util.bb.a(writeActivity, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i == 1) {
            writeImagesInfo = this.a.C;
            if (writeImagesInfo != null) {
                writeImagesInfo2 = this.a.C;
                if (!TextUtils.isEmpty(writeImagesInfo2.toJsonString())) {
                    WriteActivity writeActivity2 = this.a;
                    writeImagesInfo3 = this.a.C;
                    com.baidu.tbadk.core.atomData.a aVar = new com.baidu.tbadk.core.atomData.a(writeActivity2, writeImagesInfo3.toJsonString());
                    aVar.setRequestCode(12002);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, aVar));
                }
            }
        }
    }
}
