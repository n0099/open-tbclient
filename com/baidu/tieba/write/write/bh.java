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
public class bh implements com.baidu.tbadk.editortool.v {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.cyc = writeActivity;
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
        boolean Jc;
        if (i == 38) {
            this.cyc.je(38);
        } else if (i == 39) {
            this.cyc.ark();
        } else if (i == 2) {
            this.cyc.je(2);
        } else if (i == 3) {
            this.cyc.ark();
        } else if (i == 56) {
            this.cyc.ark();
        } else if (i == 59) {
            this.cyc.ark();
        } else if (i == 0) {
            Jc = this.cyc.Jc();
            if (Jc) {
                this.cyc.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cyc.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cyc.je(8);
        } else if (i == 9) {
            this.cyc.ark();
        } else if (i == 4) {
            str2 = this.cyc.bHS;
            if (str2 != null) {
                str3 = this.cyc.bHS;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cyc;
                    str4 = this.cyc.bHS;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cyc.je(5);
        } else if (i == 6) {
            this.cyc.ark();
        } else if (i == 22) {
            writeImagesInfo4 = this.cyc.writeImagesInfo;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.cyc.writeImagesInfo;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.cyc.aHA = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cyc.getPageContext();
                str = this.cyc.aHA;
                com.baidu.tbadk.core.util.az.a(pageContext, str);
                return;
            }
            this.cyc.showToast(String.format(this.cyc.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cyc.je(i);
            } else if (i == 45) {
                this.cyc.ark();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer3 = this.cyc.cmz;
                    if (editorToolComponetContainer3.alF()) {
                        this.cyc.je(i);
                    }
                } else if (i == 49) {
                    this.cyc.ark();
                } else if (i != 55 && i != 58) {
                    if (i == 59) {
                        this.cyc.je(i);
                    } else if (i == 60) {
                        this.cyc.je(60);
                    } else if (i == 57) {
                        writeImagesInfo = this.cyc.writeImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo3 = this.cyc.writeImagesInfo;
                            if (writeImagesInfo3.size() > 0) {
                                this.cyc.je(57);
                                return;
                            }
                        }
                        editorToolComponetContainer = this.cyc.cmz;
                        if (editorToolComponetContainer.alv()) {
                            editorToolComponetContainer2 = this.cyc.cmz;
                            editorToolComponetContainer2.hideAll();
                        }
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.cyc.getPageContext().getPageActivity();
                        writeImagesInfo2 = this.cyc.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo2.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else {
                this.cyc.jg(i);
            }
        }
    }
}
