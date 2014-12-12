package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.cft = writeActivity;
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
        boolean Fl;
        if (i == 38) {
            this.cft.io(38);
        } else if (i == 39) {
            this.cft.akh();
        } else if (i == 2) {
            this.cft.io(2);
        } else if (i == 3) {
            this.cft.akh();
        } else if (i == 0) {
            Fl = this.cft.Fl();
            if (Fl) {
                this.cft.showToast(com.baidu.tieba.z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cft.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cft.io(8);
        } else if (i == 9) {
            this.cft.akh();
        } else if (i == 4) {
            str2 = this.cft.byI;
            if (str2 != null) {
                str3 = this.cft.byI;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cft;
                    str4 = this.cft.byI;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cft.io(5);
        } else if (i == 6) {
            this.cft.akh();
        } else if (i == 22) {
            writeImagesInfo = this.cft.writeImagesInfo;
            int size = writeImagesInfo.size();
            writeImagesInfo2 = this.cft.writeImagesInfo;
            if (size < writeImagesInfo2.getMaxImagesAllowed()) {
                this.cft.aAI = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cft.getPageContext();
                str = this.cft.aAI;
                com.baidu.tbadk.core.util.aw.a(pageContext, str);
                return;
            }
            this.cft.showToast(String.format(this.cft.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cft.io(i);
            } else if (i == 45) {
                this.cft.akh();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer = this.cft.bUs;
                    if (editorToolComponetContainer.aft()) {
                        this.cft.io(i);
                    }
                } else if (i == 49) {
                    this.cft.akh();
                }
            } else {
                this.cft.iq(i);
            }
        }
    }
}
