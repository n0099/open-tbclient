package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity eTD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.eTD = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.eTD.pF(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper pF;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && pF != null) {
            pF.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            pF.setDownLoadStatus(3);
            bVar = this.eTD.eTB;
            bVar.D(pF);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.eTD.pF(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper pF;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && pF != null) {
            this.eTD.showToast(r.l.download_fail_tip);
            pF.setDownLoadStatus(0);
            bVar = this.eTD.eTB;
            bVar.D(pF);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.eTD.pF(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper pF;
        com.baidu.tbadk.mvc.f.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && pF != null) {
            if (i == 0) {
                this.eTD.showToast(r.l.plugin_installation_finished);
                viewEventCenter = this.eTD.bxK;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, pF, null, null));
                return;
            }
            this.eTD.showToast(String.valueOf(this.eTD.getPageContext().getString(r.l.plugin_installation_failed)) + str);
            pF.setDownLoadStatus(0);
            bVar = this.eTD.eTB;
            bVar.D(pF);
        }
    }
}
