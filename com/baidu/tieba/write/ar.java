package com.baidu.tieba.write;

import android.text.TextUtils;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* loaded from: classes.dex */
final class ar implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.x
    public final void a(int i, Object obj) {
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
        if (i == 2) {
            this.a.a(2);
        } else if (i == 3) {
            this.a.a();
        } else if (i == 0) {
            if (WriteActivity.t(this.a)) {
                this.a.showToast(com.baidu.tieba.a.k.over_limit_tip);
            } else {
                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(this.a, 12004, true)));
            }
        } else if (i == 8) {
            editorToolComponetContainer = this.a.A;
            if (!editorToolComponetContainer.i()) {
                writeImagesInfo3 = this.a.C;
                if (writeImagesInfo3 != null) {
                    writeImagesInfo4 = this.a.C;
                    if (!TextUtils.isEmpty(writeImagesInfo4.toJsonString())) {
                        WriteActivity writeActivity = this.a;
                        writeImagesInfo5 = this.a.C;
                        com.baidu.tbadk.core.b.a aVar = new com.baidu.tbadk.core.b.a(writeActivity, writeImagesInfo5.toJsonString());
                        aVar.a(12002);
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, aVar));
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.a(8);
        } else if (i == 9) {
            this.a.a();
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
            this.a.a();
        } else if (i == 22) {
            writeImagesInfo = this.a.C;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.a.C;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.a.D = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity3 = this.a;
                str = this.a.D;
                com.baidu.tbadk.core.util.az.a(writeActivity3, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.a.a(i);
            } else if (i == 45) {
                this.a.a();
            }
        }
    }
}
