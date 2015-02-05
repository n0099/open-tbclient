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
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        WriteImagesInfo writeImagesInfo2;
        EditorToolComponetContainer editorToolComponetContainer3;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        String str;
        String str2;
        String str3;
        String str4;
        boolean FD;
        if (i == 38) {
            this.cgR.it(38);
        } else if (i == 39) {
            this.cgR.akA();
        } else if (i == 2) {
            this.cgR.it(2);
        } else if (i == 3) {
            this.cgR.akA();
        } else if (i == 56) {
            this.cgR.akA();
        } else if (i == 59) {
            this.cgR.akA();
        } else if (i == 0) {
            FD = this.cgR.FD();
            if (FD) {
                this.cgR.showToast(com.baidu.tieba.z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cgR.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cgR.it(8);
        } else if (i == 9) {
            this.cgR.akA();
        } else if (i == 4) {
            str2 = this.cgR.bAq;
            if (str2 != null) {
                str3 = this.cgR.bAq;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cgR;
                    str4 = this.cgR.bAq;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cgR.it(5);
        } else if (i == 6) {
            this.cgR.akA();
        } else if (i == 22) {
            writeImagesInfo3 = this.cgR.writeImagesInfo;
            int size = writeImagesInfo3.size();
            writeImagesInfo4 = this.cgR.writeImagesInfo;
            if (size < writeImagesInfo4.getMaxImagesAllowed()) {
                this.cgR.aBH = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cgR.getPageContext();
                str = this.cgR.aBH;
                com.baidu.tbadk.core.util.bb.a(pageContext, str);
                return;
            }
            this.cgR.showToast(String.format(this.cgR.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cgR.it(i);
            } else if (i == 45) {
                this.cgR.akA();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer3 = this.cgR.bWj;
                    if (editorToolComponetContainer3.afS()) {
                        this.cgR.it(i);
                    }
                } else if (i == 49) {
                    this.cgR.akA();
                } else if (i != 55 && i != 58) {
                    if (i == 59) {
                        this.cgR.it(i);
                    } else if (i == 60) {
                        this.cgR.it(60);
                    } else if (i == 57) {
                        writeImagesInfo = this.cgR.writeImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.cgR.writeImagesInfo;
                            if (writeImagesInfo2.size() > 0) {
                                this.cgR.it(57);
                                return;
                            }
                        }
                        editorToolComponetContainer = this.cgR.bWj;
                        if (editorToolComponetContainer.afI()) {
                            editorToolComponetContainer2 = this.cgR.bWj;
                            editorToolComponetContainer2.hideAll();
                        }
                        this.cgR.akG();
                    }
                }
            } else {
                this.cgR.iv(i);
            }
        }
    }
}
