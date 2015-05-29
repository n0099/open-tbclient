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
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.cCP = writeActivity;
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
        boolean Km;
        if (i == 38) {
            this.cCP.jD(38);
        } else if (i == 39) {
            this.cCP.atp();
        } else if (i == 2) {
            this.cCP.jD(2);
        } else if (i == 3) {
            this.cCP.atp();
        } else if (i == 56) {
            this.cCP.atp();
        } else if (i == 59) {
            this.cCP.atp();
        } else if (i == 0) {
            Km = this.cCP.Km();
            if (Km) {
                this.cCP.showToast(com.baidu.tieba.t.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cCP.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cCP.jD(8);
        } else if (i == 9) {
            this.cCP.atp();
        } else if (i == 4) {
            str2 = this.cCP.bKu;
            if (str2 != null) {
                str3 = this.cCP.bKu;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cCP;
                    str4 = this.cCP.bKu;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cCP.jD(5);
        } else if (i == 6) {
            this.cCP.atp();
        } else if (i == 22) {
            writeImagesInfo4 = this.cCP.writeImagesInfo;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.cCP.writeImagesInfo;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.cCP.aJR = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cCP.getPageContext();
                str = this.cCP.aJR;
                com.baidu.tbadk.core.util.ax.a(pageContext, str);
                return;
            }
            this.cCP.showToast(String.format(this.cCP.getPageContext().getString(com.baidu.tieba.t.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cCP.jD(i);
            } else if (i == 45) {
                this.cCP.atp();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer3 = this.cCP.cqO;
                    if (editorToolComponetContainer3.anG()) {
                        this.cCP.jD(i);
                    }
                } else if (i == 49) {
                    this.cCP.atp();
                } else if (i != 55 && i != 58) {
                    if (i == 59) {
                        this.cCP.jD(i);
                    } else if (i == 60) {
                        this.cCP.jD(60);
                    } else if (i == 57) {
                        writeImagesInfo = this.cCP.writeImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo3 = this.cCP.writeImagesInfo;
                            if (writeImagesInfo3.size() > 0) {
                                this.cCP.jD(57);
                                return;
                            }
                        }
                        editorToolComponetContainer = this.cCP.cqO;
                        if (editorToolComponetContainer.anw()) {
                            editorToolComponetContainer2 = this.cCP.cqO;
                            editorToolComponetContainer2.hideAll();
                        }
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.cCP.getPageContext().getPageActivity();
                        writeImagesInfo2 = this.cCP.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo2.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else {
                this.cCP.jF(i);
            }
        }
    }
}
