package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity djc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.djc = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.djc.lE(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper lE;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && lE != null) {
            lE.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            lE.setDownLoadStatus(3);
            bVar = this.djc.dja;
            bVar.A(lE);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.djc.lE(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper lE;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && lE != null) {
            this.djc.showToast(n.j.download_fail_tip);
            lE.setDownLoadStatus(0);
            bVar = this.djc.dja;
            bVar.A(lE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.djc.lE(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper lE;
        com.baidu.tbadk.mvc.g.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && lE != null) {
            if (i == 0) {
                this.djc.showToast(n.j.plugin_installation_finished);
                viewEventCenter = this.djc.aUs;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, lE, null, null));
                return;
            }
            this.djc.showToast(String.valueOf(this.djc.getPageContext().getString(n.j.plugin_installation_failed)) + str);
            lE.setDownLoadStatus(0);
            bVar = this.djc.dja;
            bVar.A(lE);
        }
    }
}
