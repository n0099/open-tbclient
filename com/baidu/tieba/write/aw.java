package com.baidu.tieba.write;

import com.baidu.tieba.album.AlbumActivity;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.img.WriteImagesInfo;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tieba.editortool.z {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // com.baidu.tieba.editortool.z
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
        if (i == 2) {
            this.a.a(2);
        } else if (i == 3) {
            this.a.i();
        } else if (i == 0) {
            AtListActivity.a(this.a, 12004, true);
        } else if (i == 8) {
            editorToolComponetContainer = this.a.B;
            if (editorToolComponetContainer.q()) {
                this.a.a(8);
                return;
            }
            WriteActivity writeActivity = this.a;
            writeImagesInfo3 = this.a.D;
            AlbumActivity.a(writeActivity, writeImagesInfo3, 12002);
        } else if (i == 9) {
            this.a.i();
        } else if (i == 4) {
            str2 = this.a.z;
            if (str2 != null) {
                str3 = this.a.z;
                if (str3.length() > 0) {
                    WriteActivity writeActivity2 = this.a;
                    str4 = this.a.z;
                    writeActivity2.showToast(str4);
                    writeEditorToolButtonContainer = this.a.A;
                    writeEditorToolButtonContainer.setAudioFocusable(false);
                }
            }
        } else if (i == 5) {
            this.a.a(5);
        } else if (i == 6) {
            this.a.i();
        } else if (i == 22) {
            writeImagesInfo = this.a.D;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.a.D;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.a.E = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity3 = this.a;
                str = this.a.E;
                bz.a(writeActivity3, str);
                return;
            }
            this.a.showToast(String.format(this.a.getString(R.string.editor_mutiiamge_max), 10));
        }
    }
}
