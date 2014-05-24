package com.baidu.tieba.write;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        String str;
        String str2;
        String str3;
        String str4;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        boolean v;
        if (i == 2) {
            this.a.a(2);
        } else if (i == 3) {
            this.a.i();
        } else if (i == 0) {
            v = this.a.v();
            if (v) {
                this.a.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this.a, 12004, true)));
            }
        } else if (i == 8) {
            editorToolComponetContainer = this.a.A;
            if (!editorToolComponetContainer.t()) {
                writeImagesInfo3 = this.a.C;
                if (writeImagesInfo3 != null) {
                    writeImagesInfo4 = this.a.C;
                    if (!TextUtils.isEmpty(writeImagesInfo4.toJsonString())) {
                        WriteActivity writeActivity = this.a;
                        writeImagesInfo5 = this.a.C;
                        com.baidu.tbadk.core.atomData.a aVar = new com.baidu.tbadk.core.atomData.a(writeActivity, writeImagesInfo5.toJsonString());
                        aVar.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, aVar));
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.a(8);
        } else if (i == 9) {
            this.a.i();
        } else if (i == 4) {
            str2 = this.a.y;
            if (str2 != null) {
                str3 = this.a.y;
                if (str3.length() > 0) {
                    WriteActivity writeActivity2 = this.a;
                    str4 = this.a.y;
                    writeActivity2.showToast(str4);
                    writeEditorToolButtonContainer = this.a.z;
                    writeEditorToolButtonContainer.setAudioFocusable(false);
                }
            }
        } else if (i == 5) {
            this.a.a(5);
        } else if (i == 6) {
            this.a.i();
        } else if (i == 22) {
            writeImagesInfo = this.a.C;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.a.C;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.a.D = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity3 = this.a;
                str = this.a.D;
                com.baidu.tbadk.core.util.bb.a(writeActivity3, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.a.a(i);
            } else if (i == 45) {
                this.a.i();
            }
        }
    }
}
