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
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(WriteActivity writeActivity) {
        this.cyx = writeActivity;
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
        boolean Ji;
        if (i == 38) {
            this.cyx.jh(38);
        } else if (i == 39) {
            this.cyx.arz();
        } else if (i == 2) {
            this.cyx.jh(2);
        } else if (i == 3) {
            this.cyx.arz();
        } else if (i == 56) {
            this.cyx.arz();
        } else if (i == 59) {
            this.cyx.arz();
        } else if (i == 0) {
            Ji = this.cyx.Ji();
            if (Ji) {
                this.cyx.showToast(com.baidu.tieba.y.over_limit_tip);
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtListActivityConfig(this.cyx.getPageContext().getPageActivity(), 12004, true)));
            }
        } else if (i == 8) {
            this.cyx.jh(8);
        } else if (i == 9) {
            this.cyx.arz();
        } else if (i == 4) {
            str2 = this.cyx.bIf;
            if (str2 != null) {
                str3 = this.cyx.bIf;
                if (str3.length() > 0) {
                    WriteActivity writeActivity = this.cyx;
                    str4 = this.cyx.bIf;
                    writeActivity.showToast(str4);
                }
            }
        } else if (i == 5) {
            this.cyx.jh(5);
        } else if (i == 6) {
            this.cyx.arz();
        } else if (i == 22) {
            writeImagesInfo4 = this.cyx.writeImagesInfo;
            int size = writeImagesInfo4.size();
            writeImagesInfo5 = this.cyx.writeImagesInfo;
            if (size < writeImagesInfo5.getMaxImagesAllowed()) {
                this.cyx.aHI = String.valueOf(System.currentTimeMillis());
                TbPageContext pageContext = this.cyx.getPageContext();
                str = this.cyx.aHI;
                com.baidu.tbadk.core.util.az.a(pageContext, str);
                return;
            }
            this.cyx.showToast(String.format(this.cyx.getPageContext().getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
        } else if (i != 23) {
            if (i == 44) {
                this.cyx.jh(i);
            } else if (i == 45) {
                this.cyx.arz();
            } else if (i != 48) {
                if (i == 50) {
                    editorToolComponetContainer3 = this.cyx.cmP;
                    if (editorToolComponetContainer3.alU()) {
                        this.cyx.jh(i);
                    }
                } else if (i == 49) {
                    this.cyx.arz();
                } else if (i != 55 && i != 58) {
                    if (i == 59) {
                        this.cyx.jh(i);
                    } else if (i == 60) {
                        this.cyx.jh(60);
                    } else if (i == 57) {
                        writeImagesInfo = this.cyx.writeImagesInfo;
                        if (writeImagesInfo != null) {
                            writeImagesInfo3 = this.cyx.writeImagesInfo;
                            if (writeImagesInfo3.size() > 0) {
                                this.cyx.jh(57);
                                return;
                            }
                        }
                        editorToolComponetContainer = this.cyx.cmP;
                        if (editorToolComponetContainer.alK()) {
                            editorToolComponetContainer2 = this.cyx.cmP;
                            editorToolComponetContainer2.hideAll();
                        }
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        Activity pageActivity = this.cyx.getPageContext().getPageActivity();
                        writeImagesInfo2 = this.cyx.writeImagesInfo;
                        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(pageActivity, writeImagesInfo2.toJsonString(), valueOf);
                        albumActivityConfig.setRequestCode(12002);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                    }
                }
            } else {
                this.cyx.jj(i);
            }
        }
    }
}
