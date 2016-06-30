package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity eDR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.eDR = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.eDR.oP(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper oP;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && oP != null) {
            oP.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            oP.setDownLoadStatus(3);
            bVar = this.eDR.eDP;
            bVar.A((com.baidu.tbadk.mvc.g.b) oP);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.eDR.oP(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper oP;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && oP != null) {
            this.eDR.showToast(u.j.download_fail_tip);
            oP.setDownLoadStatus(0);
            bVar = this.eDR.eDP;
            bVar.A((com.baidu.tbadk.mvc.g.b) oP);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.eDR.oP(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper oP;
        com.baidu.tbadk.mvc.g.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && oP != null) {
            if (i == 0) {
                this.eDR.showToast(u.j.plugin_installation_finished);
                viewEventCenter = this.eDR.bfx;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, oP, null, null));
                return;
            }
            this.eDR.showToast(String.valueOf(this.eDR.getPageContext().getString(u.j.plugin_installation_failed)) + str);
            oP.setDownLoadStatus(0);
            bVar = this.eDR.eDP;
            bVar.A((com.baidu.tbadk.mvc.g.b) oP);
        }
    }
}
