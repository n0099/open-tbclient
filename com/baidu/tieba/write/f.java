package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class f {
    public static void a(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null) {
            if (bLw()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0)));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!j.oI()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.rn().ro().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.oK()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.cZ(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.f.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, f.y(TbPageContext.this));
                        if (PluginPackageManager.qR().bz(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.qR().a(aVar3);
                        } else {
                            PluginPackageManager.qR().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.f.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).AI();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext dMB;
        private ForumWriteData hMO;
        private com.baidu.tbadk.core.dialog.c hMP;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.dMB = null;
            this.dMB = tbPageContext;
            this.hMO = forumWriteData;
            this.hMP = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.hMP != null) {
                this.hMP.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.hMP != null) {
                g.b(this.hMP, this.dMB);
            }
            this.dMB.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.hMP != null) {
                g.b(this.hMP, this.dMB);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dMB != null) {
                this.dMB.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.hMP != null) {
                g.b(this.hMP, this.dMB);
            }
            if (i == 0) {
                f.a(this.dMB, "", this.hMO);
            } else {
                this.dMB.showToast(this.dMB.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c y(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.f.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.qR().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        g.a(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean bLw() {
        return com.baidu.adp.lib.b.d.mz().an("add_video_thread_switch") != 1;
    }
}
