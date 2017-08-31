package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private static String mForumId;
    private static String mForumName;
    private static a gAm = null;
    private static com.baidu.tbadk.core.dialog.c cFI = null;

    public static void c(TbPageContext tbPageContext, String str, String str2) {
        b(tbPageContext, str, str2, "");
    }

    public static void b(final TbPageContext tbPageContext, String str, String str2, String str3) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str4;
        String str5;
        mForumId = str;
        mForumName = str2;
        if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.l.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, mForumId, mForumName, str3);
            }
        } else if (!i.hi()) {
            tbPageContext.showToast(d.l.neterror);
        } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
            float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(d.l.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_wifi);
            if (i.hk()) {
                String string3 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_mobile);
                str4 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                str5 = tbPageContext.getPageActivity().getString(d.l.install_app);
            } else {
                str4 = string2;
                str5 = string;
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cM(str4);
            aVar.a(str5, new a.b() { // from class: com.baidu.tieba.write.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    e.q(TbPageContext.this);
                    if (e.gAm == null) {
                        a unused = e.gAm = new a();
                    }
                    e.gAm.d(TbPageContext.this, e.mForumId, e.mForumName);
                    if (PluginPackageManager.jw().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                        PluginPackageManager.jw().a(e.gAm);
                    } else {
                        PluginPackageManager.jw().a(pluginConfig, e.gAm);
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(tbPageContext).to();
        }
    }

    /* loaded from: classes.dex */
    private static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext cFN;
        private String mForumId;
        private String mForumName;

        private a() {
            this.cFN = null;
        }

        public void d(TbPageContext tbPageContext, String str, String str2) {
            this.cFN = tbPageContext;
            this.mForumId = str;
            this.mForumName = str2;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && e.cFI != null) {
                e.cFI.ck((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (e.cFI != null) {
                g.b(e.cFI, this.cFN);
            }
            this.cFN.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (e.cFI != null) {
                g.b(e.cFI, this.cFN);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cFN != null) {
                this.cFN.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (e.cFI != null) {
                g.b(e.cFI, this.cFN);
            }
            if (i == 0) {
                e.c(this.cFN, this.mForumId, this.mForumName);
            } else {
                this.cFN.showToast(this.cFN.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TbPageContext tbPageContext) {
        if (cFI == null) {
            cFI = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cFI.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.e.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.baidu.tbadk.core.dialog.c unused = e.cFI = null;
                    PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
                }
            });
            cFI.setCancelable(true);
            cFI.setCanceledOnTouchOutside(false);
            cFI.setMessage(tbPageContext.getPageActivity().getString(d.l.on_downloading));
        }
        g.a(cFI, tbPageContext.getPageActivity());
    }
}
