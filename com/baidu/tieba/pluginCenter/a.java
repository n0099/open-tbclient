package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.i {
    final /* synthetic */ PluginCenterActivity bXi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.bXi = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.bXi.iI(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper iI;
        com.baidu.tbadk.mvc.j.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && iI != null) {
            iI.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            iI.setDownLoadStatus(3);
            bVar = this.bXi.bXg;
            bVar.y(iI);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.i
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.bXi.iI(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper iI;
        com.baidu.tbadk.mvc.j.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && iI != null) {
            this.bXi.showToast(t.download_fail_tip);
            iI.setDownLoadStatus(0);
            bVar = this.bXi.bXg;
            bVar.y(iI);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.bXi.iI(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper iI;
        com.baidu.tbadk.mvc.j.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && iI != null) {
            if (i == 0) {
                this.bXi.showToast(t.plugin_installation_finished);
                viewEventCenter = this.bXi.aEU;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, iI, null, null));
                return;
            }
            this.bXi.showToast(String.valueOf(this.bXi.getPageContext().getString(t.plugin_installation_failed)) + str);
            iI.setDownLoadStatus(0);
            bVar = this.bXi.bXg;
            bVar.y(iI);
        }
    }
}
