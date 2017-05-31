package com.baidu.tieba.tblauncher;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class az {
    private static String mForumId;
    private static String mForumName;
    private static a fHc = null;
    private static com.baidu.tbadk.core.dialog.e cgF = null;

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
            aVar.cB(str3);
            aVar.a(str4, new ba(tbPageContext, pluginConfig));
            aVar.b(w.l.cancel, new bb());
            aVar.b(tbPageContext).tc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private TbPageContext cgK;
        private String mForumId;
        private String mForumName;

        private a() {
            this.cgK = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void d(TbPageContext tbPageContext, String str, String str2) {
            this.cgK = tbPageContext;
            this.mForumId = str;
            this.mForumName = str2;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || az.cgF == null) {
                return;
            }
            az.cgF.cg((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (az.cgF != null) {
                com.baidu.adp.lib.g.j.b(az.cgF, this.cgK);
            }
            this.cgK.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (az.cgF != null) {
                com.baidu.adp.lib.g.j.b(az.cgF, this.cgK);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cgK != null) {
                this.cgK.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (az.cgF != null) {
                com.baidu.adp.lib.g.j.b(az.cgF, this.cgK);
            }
            if (i == 0) {
                az.c(this.cgK, this.mForumId, this.mForumName);
            } else {
                this.cgK.showToast(String.valueOf(this.cgK.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jx().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(TbPageContext tbPageContext) {
        if (cgF == null) {
            cgF = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            cgF.setOnCancelListener(new bc());
            cgF.setCancelable(true);
            cgF.setCanceledOnTouchOutside(false);
            cgF.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(cgF, tbPageContext.getPageActivity());
    }
}
