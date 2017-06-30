package com.baidu.tieba.write;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class q {
    private static String mForumId;
    private static String mForumName;
    private static a gdY = null;
    private static com.baidu.tbadk.core.dialog.e coV = null;

    public static void c(TbPageContext tbPageContext, String str, String str2) {
        b(tbPageContext, str, str2, "");
    }

    public static void b(TbPageContext tbPageContext, String str, String str2, String str3) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        String str4;
        String str5;
        mForumId = str;
        mForumName = str2;
        if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(w.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(w.l.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, mForumId, mForumName, str3);
            }
        } else if (!com.baidu.adp.lib.util.i.hj()) {
            tbPageContext.showToast(w.l.neterror);
        } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
            float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(w.l.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_wifi);
            if (com.baidu.adp.lib.util.i.hl()) {
                String string3 = tbPageContext.getPageActivity().getString(w.l.plugin_video_install_tips_mobile);
                str4 = f > 0.0f ? String.valueOf(string3) + "（" + f + "MB）" : string3;
                str5 = tbPageContext.getPageActivity().getString(w.l.install_app);
            } else {
                str4 = string2;
                str5 = string;
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cI(str4);
            aVar.a(str5, new r(tbPageContext, pluginConfig));
            aVar.b(w.l.cancel, new s());
            aVar.b(tbPageContext).ta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.e {
        private TbPageContext cpa;
        private String mForumId;
        private String mForumName;

        private a() {
            this.cpa = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(a aVar) {
            this();
        }

        public void d(TbPageContext tbPageContext, String str, String str2) {
            this.cpa = tbPageContext;
            this.mForumId = str;
            this.mForumName = str2;
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || q.coV == null) {
                return;
            }
            q.coV.cg((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (q.coV != null) {
                com.baidu.adp.lib.g.j.b(q.coV, this.cpa);
            }
            this.cpa.showToast(w.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (q.coV != null) {
                com.baidu.adp.lib.g.j.b(q.coV, this.cpa);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cpa != null) {
                this.cpa.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.e
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (q.coV != null) {
                com.baidu.adp.lib.g.j.b(q.coV, this.cpa);
            }
            if (i == 0) {
                q.c(this.cpa, this.mForumId, this.mForumName);
            } else {
                this.cpa.showToast(String.valueOf(this.cpa.getString(w.l.install_failed)) + str);
            }
            PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(TbPageContext tbPageContext) {
        if (coV == null) {
            coV = new com.baidu.tbadk.core.dialog.e(tbPageContext.getPageActivity());
            coV.setOnCancelListener(new t());
            coV.setCancelable(true);
            coV.setCanceledOnTouchOutside(false);
            coV.setMessage(tbPageContext.getPageActivity().getString(w.l.plugin_video_downloading));
        }
        com.baidu.adp.lib.g.j.a(coV, tbPageContext.getPageActivity());
    }
}
