package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ ae bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar) {
        this.bog = aeVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        Activity activity;
        BaobaoSdkDelegate baobaoSdkDelegate;
        Activity activity2;
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        AlertDialog alertDialog3;
        Activity activity3;
        WriteImagesInfo writeImagesInfo;
        WriteImagesInfo writeImagesInfo2;
        WriteImagesInfo writeImagesInfo3;
        Activity activity4;
        WriteImagesInfo writeImagesInfo4;
        WriteImagesInfo writeImagesInfo5;
        WriteImagesInfo writeImagesInfo6;
        Activity activity5;
        WriteImagesInfo writeImagesInfo7;
        WriteImagesInfo writeImagesInfo8;
        WriteImagesInfo writeImagesInfo9;
        Activity activity6;
        String str;
        PbEditor pbEditor;
        Activity activity7;
        if (i == 0) {
            pbEditor = this.bog.azJ;
            if (pbEditor.Cj()) {
                this.bog.showToast(com.baidu.tieba.y.over_limit_tip);
                return;
            }
            MessageManager messageManager = MessageManager.getInstance();
            activity7 = this.bog.mActivity;
            messageManager.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(activity7, 12004, true)));
        } else if (i != 10) {
            if (i != 4) {
                if (i == 22) {
                    writeImagesInfo8 = this.bog.aib;
                    int size = writeImagesInfo8.size();
                    writeImagesInfo9 = this.bog.aib;
                    if (size < writeImagesInfo9.getMaxImagesAllowed()) {
                        this.bog.ayG = String.valueOf(System.currentTimeMillis());
                        activity6 = this.bog.mActivity;
                        str = this.bog.ayG;
                        av.a(activity6, str);
                        return;
                    }
                    this.bog.showToast(String.format(this.bog.getString(com.baidu.tieba.y.editor_mutiiamge_max), 10));
                } else if (i == 23) {
                    writeImagesInfo5 = this.bog.aib;
                    if (writeImagesInfo5 != null) {
                        writeImagesInfo6 = this.bog.aib;
                        if (!TextUtils.isEmpty(writeImagesInfo6.toJsonString())) {
                            activity5 = this.bog.mActivity;
                            writeImagesInfo7 = this.bog.aib;
                            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(activity5, writeImagesInfo7.toJsonString());
                            albumActivityConfig.setRequestCode(12002);
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                        }
                    }
                } else if (i == 42) {
                    int intValue = ((Integer) obj).intValue();
                    writeImagesInfo = this.bog.aib;
                    if (writeImagesInfo != null) {
                        writeImagesInfo2 = this.bog.aib;
                        if (writeImagesInfo2.getChosedFiles() != null) {
                            writeImagesInfo3 = this.bog.aib;
                            int size2 = writeImagesInfo3.getChosedFiles().size();
                            if (size2 >= 1 && intValue >= 0 && intValue < size2) {
                                MessageManager messageManager2 = MessageManager.getInstance();
                                activity4 = this.bog.mActivity;
                                writeImagesInfo4 = this.bog.aib;
                                messageManager2.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(activity4, 12012, writeImagesInfo4, intValue)));
                            }
                        }
                    }
                } else if (i != 7) {
                    if (i == 48) {
                        activity = this.bog.mActivity;
                        if (PluginHelper.isBaoBaoCanUse(activity)) {
                            com.baidu.tieba.e.a.adK();
                            if (!com.baidu.tieba.e.a.adI()) {
                                this.bog.showToast(com.baidu.tieba.y.baobao_over_limit);
                                return;
                            }
                            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BAOBAO);
                            if (pluginByName != null && (baobaoSdkDelegate = (BaobaoSdkDelegate) pluginByName.getClassInstance(BaobaoSdkDelegate.class)) != null) {
                                activity2 = this.bog.mActivity;
                                baobaoSdkDelegate.startMatchImage(activity2, this.bog.getResources().getString(com.baidu.tieba.y.send_reply), 12013);
                            }
                        }
                    }
                } else {
                    alertDialog = this.bog.ayP;
                    if (alertDialog == null) {
                        this.bog.ED();
                    }
                    alertDialog2 = this.bog.ayP;
                    if (alertDialog2 == null) {
                        return;
                    }
                    alertDialog3 = this.bog.ayP;
                    activity3 = this.bog.mActivity;
                    com.baidu.adp.lib.g.j.a(alertDialog3, activity3);
                }
            }
        } else {
            this.bog.SZ();
        }
    }
}
