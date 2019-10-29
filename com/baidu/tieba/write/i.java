package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.c.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class i {
    public static void b(final TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (forumWriteData != null && tbPageContext != null) {
            com.baidu.tbadk.core.util.c.a aVar = new com.baidu.tbadk.core.util.c.a();
            aVar.clearRequestPermissionList();
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0284a() { // from class: com.baidu.tieba.write.i.1
                @Override // com.baidu.tbadk.core.util.c.a.InterfaceC0284a
                public void onPermissionsGranted() {
                    i.c(TbPageContext.this, str, forumWriteData);
                }
            });
            aVar.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public static void c(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null && tbPageContext != null) {
            if (cxW()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0)));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(R.string.plugin_video_not_active), tbPageContext.getPageActivity().getString(R.string.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!j.isNetWorkAvailable()) {
                tbPageContext.showToast(R.string.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jj().jk() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jj().jk().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(R.string.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_wifi);
                if (j.isMobileNet()) {
                    String string3 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(R.string.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.nn(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, i.F(TbPageContext.this));
                        if (PluginPackageManager.iL().aV(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.iL().a(aVar3);
                        } else {
                            PluginPackageManager.iL().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).akO();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext fSE;
        private ForumWriteData jOf;
        private com.baidu.tbadk.core.dialog.c jOg;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.fSE = null;
            this.fSE = tbPageContext;
            this.jOf = forumWriteData;
            this.jOg = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.jOg != null) {
                this.jOg.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.jOg != null) {
                com.baidu.adp.lib.g.g.b(this.jOg, this.fSE);
            }
            this.fSE.showToast(R.string.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.jOg != null) {
                com.baidu.adp.lib.g.g.b(this.jOg, this.fSE);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.fSE != null) {
                this.fSE.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.iL().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.jOg != null) {
                com.baidu.adp.lib.g.g.b(this.jOg, this.fSE);
            }
            if (i == 0) {
                i.b(this.fSE, "", this.jOf);
            } else {
                this.fSE.showToast(this.fSE.getString(R.string.install_failed) + str);
            }
            PluginPackageManager.iL().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c F(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.i.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.iL().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(R.string.on_downloading));
        com.baidu.adp.lib.g.g.showDialog(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean cxW() {
        return com.baidu.adp.lib.b.d.ft().af("add_video_thread_switch") != 1;
    }
}
