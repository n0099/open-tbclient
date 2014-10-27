package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.bTX = writeActivity;
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
        boolean Ch;
        if (i == 38) {
            this.bTX.hG(38);
        } else if (i == 39) {
            this.bTX.afA();
        } else if (i == 2) {
            this.bTX.hG(2);
        } else if (i == 3) {
            this.bTX.afA();
        } else if (i == 0) {
            Ch = this.bTX.Ch();
            if (Ch) {
                this.bTX.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.bTX, 12004, true)));
            }
        } else if (i == 8) {
            this.bTX.hG(8);
        } else if (i == 9) {
            this.bTX.afA();
        } else if (i == 4) {
            str2 = this.bTX.buF;
            if (str2 != null) {
                str3 = this.bTX.buF;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.bTX;
                    str4 = this.bTX.buF;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.bTX.hG(5);
        } else if (i == 6) {
            this.bTX.afA();
        } else if (i == 22) {
            writeImagesInfo = this.bTX.writeImagesInfo;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.bTX.writeImagesInfo;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.bTX.ayx = String.valueOf(System.currentTimeMillis());
                WriteActivity writeActivity2 = this.bTX;
                str = this.bTX.ayx;
                com.baidu.tbadk.core.util.av.a(writeActivity2, str);
                return;
            }
            this.bTX.showToast(String.format(this.bTX.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.bTX.hG(i);
            } else if (i == 45) {
                this.bTX.afA();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer = this.bTX.are;
                    if (editorToolComponetContainer.BM()) {
                        this.bTX.hG(i);
                    }
                } else if (i == 49) {
                    this.bTX.afA();
                }
            } else {
                this.bTX.hI(i);
            }
        }
    }
}
