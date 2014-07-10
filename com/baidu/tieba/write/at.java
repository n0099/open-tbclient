package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        String str;
        String str2;
        String str3;
        String str4;
        WriteEditorToolButtonContainer writeEditorToolButtonContainer;
        boolean v;
        if (i == 2) {
            this.a.a(2);
        } else if (i == 3) {
            this.a.j();
        } else if (i == 0) {
            v = this.a.v();
            if (v) {
                this.a.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this.a, 12004, true)));
            }
        } else if (i == 8) {
            this.a.a(8);
        } else if (i == 9) {
            this.a.j();
        } else if (i == 4) {
            str2 = this.a.y;
            if (str2 != null) {
                str3 = this.a.y;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.a;
                    str4 = this.a.y;
                    writeActivity.showToast(str4);
                    writeEditorToolButtonContainer = this.a.z;
                    writeEditorToolButtonContainer.setAudioFocusable(false);
                }
            }
        } else if (i == 5) {
            this.a.a(5);
        } else if (i == 6) {
            this.a.j();
        } else if (i == 22) {
            writeImagesInfo = this.a.C;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.a.C;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.a.E = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity2 = this.a;
                str = this.a.E;
                com.baidu.tbadk.core.util.bj.a(writeActivity2, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.a.a(i);
            } else if (i == 45) {
                this.a.j();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer = this.a.A;
                    if (editorToolComponetContainer.y()) {
                        this.a.a(i);
                    }
                }
            } else {
                this.a.d(i);
            }
        }
    }
}
