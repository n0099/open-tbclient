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
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.cgS = writeActivity;
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
        boolean FJ;
        if (i == 38) {
            this.cgS.it(38);
        } else if (i == 39) {
            this.cgS.akF();
        } else if (i == 2) {
            this.cgS.it(2);
        } else if (i == 3) {
            this.cgS.akF();
        } else if (i == 56) {
            this.cgS.akF();
        } else if (i == 59) {
            this.cgS.akF();
        } else if (i == 0) {
            FJ = this.cgS.FJ();
            if (FJ) {
                this.cgS.showToast(com.baidu.tieba.z.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cgS.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cgS.it(8);
        } else if (i == 9) {
            this.cgS.akF();
        } else if (i == 4) {
            str2 = this.cgS.bAr;
            if (str2 != null) {
                str3 = this.cgS.bAr;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cgS;
                    str4 = this.cgS.bAr;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cgS.it(5);
        } else if (i == 6) {
            this.cgS.akF();
        } else if (i == 22) {
            writeImagesInfo3 = this.cgS.writeImagesInfo;
            int size = writeImagesInfo3.size();
            writeImagesInfo4 = this.cgS.writeImagesInfo;
            if (size < writeImagesInfo4.getMaxImagesAllowed()) {
                this.cgS.aBK = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cgS.getPageContext();
                str = this.cgS.aBK;
                com.baidu.tbadk.core.util.bb.a(pageContext, str);
                return;
            }
            this.cgS.showToast(String.format(this.cgS.getPageContext().getString(com.baidu.tieba.z.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cgS.it(i);
            } else if (i == 45) {
                this.cgS.akF();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer3 = this.cgS.bWk;
                    if (editorToolComponetContainer3.afX()) {
                        this.cgS.it(i);
                    }
                } else if (i == 49) {
                    this.cgS.akF();
                } else if (i != 55 && i != 58) {
                    if (i == 59) {
                        this.cgS.it(i);
                    } else if (i == 60) {
                        this.cgS.it(60);
                    } else if (i == 57) {
                        writeImagesInfo = this.cgS.writeImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.cgS.writeImagesInfo;
                            if (writeImagesInfo2.size() > 0) {
                                this.cgS.it(57);
                                return;
                            }
                        }
                        editorToolComponetContainer = this.cgS.bWk;
                        if (editorToolComponetContainer.afN()) {
                            editorToolComponetContainer2 = this.cgS.bWk;
                            editorToolComponetContainer2.hideAll();
                        }
                        this.cgS.akL();
                    }
                }
            } else {
                this.cgS.iv(i);
            }
        }
    }
}
