package com.baidu.tieba.write;

import android.app.Activity;
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
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
/* loaded from: classes.dex */
public class e {
    private static boolean I(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.Aj();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.c(activity, "android.permission.CAMERA");
        aVar.c(activity, "android.permission.RECORD_AUDIO");
        return aVar.u(activity);
    }

    public static void a(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null && !I(tbPageContext.getPageActivity())) {
            if (bGJ()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0)));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.k.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.k.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!j.jD()) {
                tbPageContext.showToast(d.k.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.mh().mi().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.k.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.k.plugin_video_install_tips_wifi);
                if (j.jF()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.k.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(d.k.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dE(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.e.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, e.E(TbPageContext.this));
                        if (PluginPackageManager.lL().bK(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.lL().a(aVar3);
                        } else {
                            PluginPackageManager.lL().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.write.e.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).xn();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext dDi;
        private ForumWriteData hsh;
        private com.baidu.tbadk.core.dialog.c hsi;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.dDi = null;
            this.dDi = tbPageContext;
            this.hsh = forumWriteData;
            this.hsi = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.hsi != null) {
                this.hsi.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.hsi != null) {
                g.b(this.hsi, this.dDi);
            }
            this.dDi.showToast(d.k.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.hsi != null) {
                g.b(this.hsi, this.dDi);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dDi != null) {
                this.dDi.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.hsi != null) {
                g.b(this.hsi, this.dDi);
            }
            if (i == 0) {
                e.a(this.dDi, "", this.hsh);
            } else {
                this.dDi.showToast(this.dDi.getString(d.k.install_failed) + str);
            }
            PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c E(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.lL().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(d.k.on_downloading));
        g.a(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean bGJ() {
        return com.baidu.adp.lib.b.d.hv().aw("add_video_thread_switch") != 1;
    }
}
