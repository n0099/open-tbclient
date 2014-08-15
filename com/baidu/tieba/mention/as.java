package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.cg;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ an a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void a(int i, Object obj) {
        WriteImagesInfo writeImagesInfo;
        WriteData writeData;
        WriteImagesInfo writeImagesInfo2;
        WriteData writeData2;
        BaobaoSdkDelegate baobaoSdkDelegate;
        Activity activity;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        Activity activity2;
        WriteImagesInfo writeImagesInfo3;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        Activity activity3;
        WriteImagesInfo writeImagesInfo6;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        Activity activity4;
        WriteImagesInfo writeImagesInfo9;
        WriteImagesInfo writeImagesInfo10;
        WriteImagesInfo writeImagesInfo11;
        Activity activity5;
        String str;
        PbEditor pbEditor;
        Activity activity6;
        if (i == 0) {
            pbEditor = this.a.i;
            if (pbEditor.l()) {
                this.a.a(com.baidu.tieba.x.over_limit_tip);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            activity6 = this.a.e;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(activity6, 12004, true)));
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo10 = this.a.q;
                    int size = writeImagesInfo10.size();
                    writeImagesInfo11 = this.a.q;
                    if (size < writeImagesInfo11.getMaxImagesAllowed()) {
                        this.a.t = String.valueOf(System.currentTimeMillis());
                        activity5 = this.a.e;
                        str = this.a.t;
                        com.baidu.tbadk.core.util.ax.a(activity5, str);
                        return;
                    }
                    this.a.b(String.format(this.a.getString(com.baidu.tieba.x.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo7 = this.a.q;
                    if (writeImagesInfo7 != null) {
                        writeImagesInfo8 = this.a.q;
                        if (!TextUtils.isEmpty(writeImagesInfo8.toJsonString())) {
                            activity4 = this.a.e;
                            writeImagesInfo9 = this.a.q;
                            com.baidu.tbadk.core.atomData.b bVar = new com.baidu.tbadk.core.atomData.b(activity4, writeImagesInfo9.toJsonString());
                            bVar.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, bVar));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo3 = this.a.q;
                    if (writeImagesInfo3 != null) {
                        writeImagesInfo4 = this.a.q;
                        if (writeImagesInfo4.getChosedFiles() != null) {
                            writeImagesInfo5 = this.a.q;
                            int size2 = writeImagesInfo5.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager2 = MessageManager.getInstance();
                                activity3 = this.a.e;
                                writeImagesInfo6 = this.a.q;
                                messageManager2.sendMessage(new CustomMessage(2002001, new cg(activity3, 12012, writeImagesInfo6, intValue)));
                            }
                        }
                    }
                } else if (i != 7) {
                    if (i == 48) {
                        com.baidu.tieba.e.a.c();
                        if (!com.baidu.tieba.e.a.a()) {
                            this.a.a(com.baidu.tieba.x.baobao_over_limit);
                            return;
                        }
                        com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("baobao");
                        if (a != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) a.a(BaobaoSdkDelegate.class)) != null) {
                            activity = this.a.e;
                            baobaoSdkDelegate.startMatchImage(activity, this.a.getResources().getString(com.baidu.tieba.x.send_reply), 12013);
                        }
                    } else if (i == 51) {
                        writeImagesInfo = this.a.r;
                        if (writeImagesInfo != null) {
                            writeImagesInfo2 = this.a.r;
                            if (writeImagesInfo2.size() > 0) {
                                writeData2 = this.a.s;
                                writeData2.setIsBaobao(true);
                                return;
                            }
                        }
                        writeData = this.a.s;
                        writeData.setIsBaobao(false);
                    }
                } else {
                    alertDialog = this.a.z;
                    if (alertDialog == null) {
                        this.a.l();
                    }
                    alertDialog2 = this.a.z;
                    if (alertDialog2 == null) {
                        return;
                    }
                    alertDialog3 = this.a.z;
                    activity2 = this.a.e;
                    com.baidu.adp.lib.e.d.a(alertDialog3, activity2);
                }
            }
        } else {
            this.a.m();
        }
    }
}
