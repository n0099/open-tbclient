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
/* loaded from: classes.dex */
public class e {
    private static String mForumId;
    private static String mForumName;
    private static a gGm = null;
    private static com.baidu.tbadk.core.dialog.c cHt = null;

    public static void b(TbPageContext tbPageContext, String str, String str2) {
        b(tbPageContext, str, str2, "");
    }

    public static void b(final TbPageContext tbPageContext, String str, String str2, String str3) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str4;
        String str5;
        mForumId = str;
        mForumName = str2;
        if (byU()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), false, str, str2, str3)));
        } else if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.l.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.l.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, mForumId, mForumName, str3);
            }
        } else if (!j.hh()) {
            tbPageContext.showToast(d.l.neterror);
        } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
            float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(d.l.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(d.l.plugin_video_install_tips_wifi);
            if (j.hj()) {
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
                    e.n(TbPageContext.this);
                    if (e.gGm == null) {
                        a unused = e.gGm = new a();
                    }
                    e.gGm.c(TbPageContext.this, e.mForumId, e.mForumName);
                    if (PluginPackageManager.jv().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                        PluginPackageManager.jv().a(e.gGm);
                    } else {
                        PluginPackageManager.jv().a(pluginConfig, e.gGm);
                    }
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.write.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(tbPageContext).ti();
        }
    }

    /* loaded from: classes.dex */
    private static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext cHy;
        private String mForumId;
        private String mForumName;

        private a() {
            this.cHy = null;
        }

        public void c(TbPageContext tbPageContext, String str, String str2) {
            this.cHy = tbPageContext;
            this.mForumId = str;
            this.mForumName = str2;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && e.cHt != null) {
                e.cHt.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (e.cHt != null) {
                g.b(e.cHt, this.cHy);
            }
            this.cHy.showToast(d.l.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (e.cHt != null) {
                g.b(e.cHt, this.cHy);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cHy != null) {
                this.cHy.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (e.cHt != null) {
                g.b(e.cHt, this.cHy);
            }
            if (i == 0) {
                e.b(this.cHy, this.mForumId, this.mForumName);
            } else {
                this.cHy.showToast(this.cHy.getString(d.l.install_failed) + str);
            }
            PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TbPageContext tbPageContext) {
        if (cHt == null) {
            cHt = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cHt.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.e.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.baidu.tbadk.core.dialog.c unused = e.cHt = null;
                    PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
                }
            });
            cHt.setCancelable(true);
            cHt.setCanceledOnTouchOutside(false);
            cHt.setMessage(tbPageContext.getPageActivity().getString(d.l.on_downloading));
        }
        g.a(cHt, tbPageContext.getPageActivity());
    }

    public static boolean byU() {
        return com.baidu.adp.lib.b.d.eV().af("add_video_thread_switch") != 1;
    }
}
