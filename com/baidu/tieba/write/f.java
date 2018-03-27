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
public class f {
    private static boolean F(Activity activity) {
        com.baidu.tbadk.core.util.b.a aVar = new com.baidu.tbadk.core.util.b.a();
        aVar.DI();
        aVar.c(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        aVar.c(activity, "android.permission.CAMERA");
        aVar.c(activity, "android.permission.RECORD_AUDIO");
        return aVar.v(activity);
    }

    public static void a(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null && !F(tbPageContext.getPageActivity())) {
            if (bFQ()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0)));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!j.oJ()) {
                tbPageContext.showToast(d.j.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
                if (j.oL()) {
                    String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(d.j.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.dk(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.f.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, f.x(TbPageContext.this));
                        if (PluginPackageManager.qS().bz(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.qS().a(aVar3);
                        } else {
                            PluginPackageManager.qS().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.f.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).AV();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext dUD;
        private ForumWriteData hEx;
        private com.baidu.tbadk.core.dialog.c hEy;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.dUD = null;
            this.dUD = tbPageContext;
            this.hEx = forumWriteData;
            this.hEy = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.hEy != null) {
                this.hEy.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.hEy != null) {
                g.b(this.hEy, this.dUD);
            }
            this.dUD.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.hEy != null) {
                g.b(this.hEy, this.dUD);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.dUD != null) {
                this.dUD.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.hEy != null) {
                g.b(this.hEy, this.dUD);
            }
            if (i == 0) {
                f.a(this.dUD, "", this.hEx);
            } else {
                this.dUD.showToast(this.dUD.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c x(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.f.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        g.a(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean bFQ() {
        return com.baidu.adp.lib.b.d.mA().an("add_video_thread_switch") != 1;
    }
}
