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
public class f {
    private static String mForumId;
    private static String mForumName;
    private static a gPV = null;
    private static com.baidu.tbadk.core.dialog.c cQs = null;

    public static void b(TbPageContext tbPageContext, String str, String str2) {
        b(tbPageContext, str, str2, "");
    }

    public static void b(final TbPageContext tbPageContext, String str, String str2, String str3) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str4;
        String str5;
        mForumId = str;
        mForumName = str2;
        if (bCm()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new RecordVideoActivityConfig(tbPageContext.getPageActivity(), false, str, str2, str3)));
        } else if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(d.j.plugin_video_not_active), tbPageContext.getPageActivity().getString(d.j.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, mForumId, mForumName, str3);
            }
        } else if (!j.hh()) {
            tbPageContext.showToast(d.j.neterror);
        } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jO().jP().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
            float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(d.j.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_wifi);
            if (j.hj()) {
                String string3 = tbPageContext.getPageActivity().getString(d.j.plugin_video_install_tips_mobile);
                str4 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                str5 = tbPageContext.getPageActivity().getString(d.j.install_app);
            } else {
                str4 = string2;
                str5 = string;
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            aVar.cS(str4);
            aVar.a(str5, new a.b() { // from class: com.baidu.tieba.write.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    f.n(TbPageContext.this);
                    if (f.gPV == null) {
                        a unused = f.gPV = new a();
                    }
                    f.gPV.c(TbPageContext.this, f.mForumId, f.mForumName);
                    if (PluginPackageManager.js().br(XiaoyingUtil.PKG_NAME_VIDEO)) {
                        PluginPackageManager.js().a(f.gPV);
                    } else {
                        PluginPackageManager.js().a(pluginConfig, f.gPV);
                    }
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.write.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(tbPageContext).th();
        }
    }

    /* loaded from: classes.dex */
    private static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext cQx;
        private String mForumId;
        private String mForumName;

        private a() {
            this.cQx = null;
        }

        public void c(TbPageContext tbPageContext, String str, String str2) {
            this.cQx = tbPageContext;
            this.mForumId = str;
            this.mForumName = str2;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && f.cQs != null) {
                f.cQs.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (f.cQs != null) {
                g.b(f.cQs, this.cQx);
            }
            this.cQx.showToast(d.j.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (f.cQs != null) {
                g.b(f.cQs, this.cQx);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.cQx != null) {
                this.cQx.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (f.cQs != null) {
                g.b(f.cQs, this.cQx);
            }
            if (i == 0) {
                f.b(this.cQx, this.mForumId, this.mForumName);
            } else {
                this.cQx.showToast(this.cQx.getString(d.j.install_failed) + str);
            }
            PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TbPageContext tbPageContext) {
        if (cQs == null) {
            cQs = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
            cQs.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.f.3
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    com.baidu.tbadk.core.dialog.c unused = f.cQs = null;
                    PluginPackageManager.js().a((com.baidu.adp.plugin.packageManager.d) null);
                }
            });
            cQs.setCancelable(true);
            cQs.setCanceledOnTouchOutside(false);
            cQs.setMessage(tbPageContext.getPageActivity().getString(d.j.on_downloading));
        }
        g.a(cQs, tbPageContext.getPageActivity());
    }

    public static boolean bCm() {
        return com.baidu.adp.lib.b.d.eV().af("add_video_thread_switch") != 1;
    }
}
