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
import com.baidu.tbadk.core.util.b.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class e {
    public static void a(final TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (forumWriteData != null && tbPageContext != null) {
            com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
            aVar.zW();
            aVar.c(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            aVar.c(tbPageContext.getPageActivity(), "android.permission.CAMERA");
            aVar.c(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
            aVar.a(new a.InterfaceC0103a() { // from class: com.baidu.tieba.write.e.1
                @Override // com.baidu.tbadk.core.util.b.a.InterfaceC0103a
                public void zX() {
                    e.b(TbPageContext.this, str, forumWriteData);
                }
            });
            aVar.u(tbPageContext.getPageActivity());
        }
    }

    public static void b(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null && tbPageContext != null) {
            if (bFy()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0)));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(f.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(f.j.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!j.jE()) {
                tbPageContext.showToast(f.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mj().mk().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(f.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(f.j.plugin_video_install_tips_wifi);
                if (j.jG()) {
                    String string3 = tbPageContext.getPageActivity().getString(f.j.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(f.j.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dB(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, e.E(TbPageContext.this));
                        if (PluginPackageManager.lN().bL(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.lN().a(aVar3);
                        } else {
                            PluginPackageManager.lN().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.write.e.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).xe();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext dFQ;
        private ForumWriteData htr;
        private com.baidu.tbadk.core.dialog.c hts;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.dFQ = null;
            this.dFQ = tbPageContext;
            this.htr = forumWriteData;
            this.hts = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.hts != null) {
                this.hts.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.hts != null) {
                g.b(this.hts, this.dFQ);
            }
            this.dFQ.showToast(f.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.hts != null) {
                g.b(this.hts, this.dFQ);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dFQ != null) {
                this.dFQ.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.hts != null) {
                g.b(this.hts, this.dFQ);
            }
            if (i == 0) {
                e.a(this.dFQ, "", this.htr);
            } else {
                this.dFQ.showToast(this.dFQ.getString(f.j.install_failed) + str);
            }
            PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c E(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.lN().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(f.j.on_downloading));
        g.a(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean bFy() {
        return com.baidu.adp.lib.b.d.hv().ax("add_video_thread_switch") != 1;
    }
}
