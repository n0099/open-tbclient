package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean Cj;
        if (i == 38) {
            this.bUm.hG(38);
        } else if (i == 39) {
            this.bUm.afD();
        } else if (i == 2) {
            this.bUm.hG(2);
        } else if (i == 3) {
            this.bUm.afD();
        } else if (i == 0) {
            Cj = this.bUm.Cj();
            if (Cj) {
                this.bUm.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bUm, 12004, true)));
            }
        } else if (i == 8) {
            this.bUm.hG(8);
        } else if (i == 9) {
            this.bUm.afD();
        } else if (i == 4) {
            str2 = this.bUm.buT;
            if (str2 != null) {
                str3 = this.bUm.buT;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.bUm;
                    str4 = this.bUm.buT;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.bUm.hG(5);
        } else if (i == 6) {
            this.bUm.afD();
        } else if (i == 22) {
            writeImagesInfo = this.bUm.writeImagesInfo;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.bUm.writeImagesInfo;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.bUm.ayG = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity2 = this.bUm;
                str = this.bUm.ayG;
                com.baidu.tbadk.core.util.av.a(writeActivity2, str);
                return;
            }
            this.bUm.showToast(String.format(this.bUm.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.bUm.hG(i);
            } else if (i == 45) {
                this.bUm.afD();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer = this.bUm.arn;
                    if (editorToolComponetContainer.BO()) {
                        this.bUm.hG(i);
                    }
                } else if (i == 49) {
                    this.bUm.afD();
                }
            } else {
                this.bUm.hI(i);
            }
        }
    }
}
