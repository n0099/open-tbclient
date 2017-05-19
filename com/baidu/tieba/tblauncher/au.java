package com.baidu.tieba.tblauncher;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class au {
    private static String mForumId;
    private static String mForumName;
    private static a fzh = null;
    private static com.baidu.tbadk.core.dialog.e cat = null;

    public static void c(TbPageContext tbPageContext, String str, String str2) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String str3;
        String str4;
        mForumId = str;
        mForumName = str2;
        if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(w.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(w.l.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, mForumId, mForumName);
            }
        } else if (!com.baidu.adp.lib.util.i.hk()) {
            tbPageContext.showToast(w.l.neterror);
        } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jU().jV().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
            float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(w.l.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_wifi);
            if (com.baidu.adp.lib.util.i.hm()) {
                String string3 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_mobile);
                str3 = f > 0.0f ? String.valueOf(string3) + "（" + f + "MB）" : string3;
                str4 = tbPageContext.getPageActivity().getString(w.l.install_app);
            } else {
                str3 = string2;
                str4 = string;
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cC(str3);
            aVar.a(str4, new av(tbPageContext, pluginConfig));
            aVar.b(w.l.cancel, new aw());
            aVar.b(tbPageContext).td();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private TbPageContext cay;
        private String mForumId;
        private String mForumName;

        private a() {
            this.cay = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void d(TbPageContext tbPageContext, String str, String str2) {
            this.cay = tbPageContext;
            this.mForumId = str;
            this.mForumName = str2;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || au.cat == null) {
                return;
            }
            au.cat.cf((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (au.cat != null) {
                com.baidu.adp.lib.g.j.b(au.cat, this.cay);
            }
            this.cay.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (au.cat != null) {
                com.baidu.adp.lib.g.j.b(au.cat, this.cay);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cay != null) {
                this.cay.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (au.cat != null) {
                com.baidu.adp.lib.g.j.b(au.cat, this.cay);
            }
            if (i == 0) {
                au.c(this.cay, this.mForumId, this.mForumName);
            } else {
                this.cay.showToast(String.valueOf(this.cay.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TbPageContext tbPageContext) {
        if (cat == null) {
            cat = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            cat.setOnCancelListener(new ax());
            cat.setCancelable(true);
            cat.setCanceledOnTouchOutside(false);
            cat.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(cat, tbPageContext.getPageActivity());
    }
}
