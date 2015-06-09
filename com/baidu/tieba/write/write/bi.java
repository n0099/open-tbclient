package com.baidu.tieba.write.write;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.tbadkCore.PbEditor.EditorToolComponetContainer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tbadk.editortool.v
    public void handleAction(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        EditorToolComponetContainer editorToolComponetContainer;
        WriteImagesInfo writeImagesInfo2;
        EditorToolComponetContainer editorToolComponetContainer2;
        WriteImagesInfo writeImagesInfo3;
        EditorToolComponetContainer editorToolComponetContainer3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        String str;
        String str2;
        String str3;
        String str4;
        boolean Kn;
        if (i == 38) {
            this.cCQ.jD(38);
        } else if (i == 39) {
            this.cCQ.atq();
        } else if (i == 2) {
            this.cCQ.jD(2);
        } else if (i == 3) {
            this.cCQ.atq();
        } else if (i == 56) {
            this.cCQ.atq();
        } else if (i == 59) {
            this.cCQ.atq();
        } else if (i == 0) {
            Kn = this.cCQ.Kn();
            if (Kn) {
                this.cCQ.showToast(com.baidu.tieba.t.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cCQ.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cCQ.jD(8);
        } else if (i == 9) {
            this.cCQ.atq();
        } else if (i == 4) {
            str2 = this.cCQ.bKv;
            if (str2 != null) {
                str3 = this.cCQ.bKv;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cCQ;
                    str4 = this.cCQ.bKv;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cCQ.jD(5);
        } else if (i == 6) {
            this.cCQ.atq();
        } else if (i == 22) {
            writeImagesInfo4 = this.cCQ.writeImagesInfo;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.cCQ.writeImagesInfo;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.cCQ.aJS = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cCQ.getPageContext();
                str = this.cCQ.aJS;
                com.baidu.tbadk.core.util.ax.a(pageContext, str);
                return;
            }
            this.cCQ.showToast(String.format(this.cCQ.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cCQ.jD(i);
            } else if (i == 45) {
                this.cCQ.atq();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer3 = this.cCQ.cqP;
                    if (editorToolComponetContainer3.anH()) {
                        this.cCQ.jD(i);
                    }
                } else if (i == 49) {
                    this.cCQ.atq();
                } else if (i != 55 && i != 58) {
                    if (i == 59) {
                        this.cCQ.jD(i);
                    } else if (i == 60) {
                        this.cCQ.jD(60);
                    } else if (i == 57) {
                        writeImagesInfo = this.cCQ.writeImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo3 = this.cCQ.writeImagesInfo;
                            if (writeImagesInfo3.size() > 0) {
                                this.cCQ.jD(57);
                                return;
                            }
                        }
                        editorToolComponetContainer = this.cCQ.cqP;
                        if (editorToolComponetContainer.anx()) {
                            editorToolComponetContainer2 = this.cCQ.cqP;
                            editorToolComponetContainer2.hideAll();
                        }
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.cCQ.getPageContext().getPageActivity();
                        writeImagesInfo2 = this.cCQ.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo2.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else {
                this.cCQ.jF(i);
            }
        }
    }
}
