package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity dwW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.dwW = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.dwW.lT(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper lT;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && lT != null) {
            lT.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            lT.setDownLoadStatus(3);
            bVar = this.dwW.dwU;
            bVar.A(lT);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.dwW.lT(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper lT;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && lT != null) {
            this.dwW.showToast(t.j.download_fail_tip);
            lT.setDownLoadStatus(0);
            bVar = this.dwW.dwU;
            bVar.A(lT);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.dwW.lT(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper lT;
        com.baidu.tbadk.mvc.g.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && lT != null) {
            if (i == 0) {
                this.dwW.showToast(t.j.plugin_installation_finished);
                viewEventCenter = this.dwW.aWA;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, lT, null, null));
                return;
            }
            this.dwW.showToast(String.valueOf(this.dwW.getPageContext().getString(t.j.plugin_installation_failed)) + str);
            lT.setDownLoadStatus(0);
            bVar = this.dwW.dwU;
            bVar.A(lT);
        }
    }
}
