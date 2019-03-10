package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class i {
    public static void a(final TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (forumWriteData != null && tbPageContext != null && com.baidu.tbadk.plugins.c.b(tbPageContext, "com.baidu.tieba.pluginVideo")) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.adQ();
            aVar.e(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.e(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.write.i.1
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0193a
                public void adR() {
                    i.b(TbPageContext.this, str, forumWriteData);
                }
            });
            aVar.Y(tbPageContext.getPageActivity());
        }
    }

    public static void b(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null && tbPageContext != null) {
            if (cos()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0)));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!j.kY()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nF().nG().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.la()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.ly(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.i.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, i.E(TbPageContext.this));
                        if (PluginPackageManager.ni().cc(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.ni().a(aVar3);
                        } else {
                            PluginPackageManager.ni().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.i.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).aaZ();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext fvd;
        private ForumWriteData jmG;
        private com.baidu.tbadk.core.dialog.c jmH;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.fvd = null;
            this.fvd = tbPageContext;
            this.jmG = forumWriteData;
            this.jmH = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.jmH != null) {
                this.jmH.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.jmH != null) {
                com.baidu.adp.lib.g.g.b(this.jmH, this.fvd);
            }
            this.fvd.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.jmH != null) {
                com.baidu.adp.lib.g.g.b(this.jmH, this.fvd);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.fvd != null) {
                this.fvd.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.ni().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.jmH != null) {
                com.baidu.adp.lib.g.g.b(this.jmH, this.fvd);
            }
            if (i == 0) {
                i.a(this.fvd, "", this.jmG);
            } else {
                this.fvd.showToast(this.fvd.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.ni().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c E(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.i.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.ni().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        com.baidu.adp.lib.g.g.a(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean cos() {
        return com.baidu.adp.lib.b.d.iQ().aO("add_video_thread_switch") != 1;
    }
}
