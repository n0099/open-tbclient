package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity eXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.eXj = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.eXj.oO(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper oO;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && oO != null) {
            oO.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            oO.setDownLoadStatus(3);
            bVar = this.eXj.eXh;
            bVar.D(oO);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.eXj.oO(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper oO;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && oO != null) {
            this.eXj.showToast(w.l.download_fail_tip);
            oO.setDownLoadStatus(0);
            bVar = this.eXj.eXh;
            bVar.D(oO);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.eXj.oO(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper oO;
        com.baidu.tbadk.mvc.f.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && oO != null) {
            if (i == 0) {
                this.eXj.showToast(w.l.plugin_installation_finished);
                viewEventCenter = this.eXj.bEQ;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, oO, null, null));
                return;
            }
            this.eXj.showToast(String.valueOf(this.eXj.getPageContext().getString(w.l.plugin_installation_failed)) + str);
            oO.setDownLoadStatus(0);
            bVar = this.eXj.eXh;
            bVar.D(oO);
        }
    }
}
