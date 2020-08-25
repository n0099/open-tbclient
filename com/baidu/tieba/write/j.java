package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes2.dex */
public class j {
    public static void b(final TbPageContext tbPageContext, final String str, final ForumWriteData forumWriteData) {
        if (forumWriteData != null && tbPageContext != null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            permissionJudgePolicy.a(new PermissionJudgePolicy.b() { // from class: com.baidu.tieba.write.j.1
                @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.b
                public void onPermissionsGranted() {
                    j.c(TbPageContext.this, str, forumWriteData);
                }
            });
            permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        }
    }

    public static void c(final TbPageContext tbPageContext, String str, final ForumWriteData forumWriteData) {
        final PluginNetConfigInfos.PluginConfig pluginConfig;
        String str2;
        String str3;
        if (forumWriteData != null && tbPageContext != null) {
            if (dFL()) {
                RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0);
                recordVideoActivityConfig.setShowType(0);
                if (forumWriteData != null) {
                    recordVideoActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, recordVideoActivityConfig));
            } else if (XiaoyingUtil.isXiaoyingInstalled()) {
                if (XiaoyingUtil.isXiaoyingForbidden()) {
                    XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(R.string.plugin_video_not_active), tbPageContext.getPageActivity().getString(R.string.setup));
                } else {
                    XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
                }
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                tbPageContext.showToast(R.string.neterror);
            } else if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qk().ql() != null && (pluginConfig = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.qk().ql().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) != null) {
                float f = (pluginConfig.newest == null || pluginConfig.newest.size <= 0) ? 0.0f : pluginConfig.newest.size / 1048576.0f;
                String string = tbPageContext.getPageActivity().getString(R.string.plugin_imme_install);
                String string2 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_wifi);
                if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    String string3 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_mobile);
                    str2 = f > 0.0f ? string3 + "（" + f + "MB）" : string3;
                    str3 = tbPageContext.getPageActivity().getString(R.string.install_app);
                } else {
                    str2 = string2;
                    str3 = string;
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
                aVar.zz(str2);
                aVar.a(str3, new a.b() { // from class: com.baidu.tieba.write.j.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        a aVar3 = new a(TbPageContext.this, forumWriteData, j.M(TbPageContext.this));
                        if (PluginPackageManager.pO().cD(XiaoyingUtil.PKG_NAME_VIDEO)) {
                            PluginPackageManager.pO().a(aVar3);
                        } else {
                            PluginPackageManager.pO().a(pluginConfig, aVar3);
                        }
                    }
                });
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.j.3
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(tbPageContext).bhg();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements com.baidu.adp.plugin.packageManager.d {
        private TbPageContext itc;
        private ForumWriteData mMJ;
        private com.baidu.tbadk.core.dialog.c mMK;

        public a(TbPageContext tbPageContext, ForumWriteData forumWriteData, com.baidu.tbadk.core.dialog.c cVar) {
            this.itc = null;
            this.itc = tbPageContext;
            this.mMJ = forumWriteData;
            this.mMK = cVar;
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.mMK != null) {
                this.mMK.setPercent((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (this.mMK != null) {
                com.baidu.adp.lib.f.g.b(this.mMK, this.itc);
            }
            this.itc.showToast(R.string.plugin_video_installing);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (this.mMK != null) {
                com.baidu.adp.lib.f.g.b(this.mMK, this.itc);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && this.itc != null) {
                this.itc.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.pO().a((com.baidu.adp.plugin.packageManager.d) null);
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (this.mMK != null) {
                com.baidu.adp.lib.f.g.b(this.mMK, this.itc);
            }
            if (i == 0) {
                j.b(this.itc, "", this.mMJ);
            } else {
                this.itc.showToast(this.itc.getString(R.string.install_failed) + str);
            }
            PluginPackageManager.pO().a((com.baidu.adp.plugin.packageManager.d) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.baidu.tbadk.core.dialog.c M(TbPageContext tbPageContext) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(tbPageContext.getPageActivity());
        cVar.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.j.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PluginPackageManager.pO().a((com.baidu.adp.plugin.packageManager.d) null);
            }
        });
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(false);
        cVar.setMessage(tbPageContext.getPageActivity().getString(R.string.on_downloading));
        com.baidu.adp.lib.f.g.showDialog(cVar, tbPageContext.getPageActivity());
        return cVar;
    }

    public static boolean dFL() {
        return SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1;
    }
}
