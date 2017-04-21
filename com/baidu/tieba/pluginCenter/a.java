package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity eXz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.eXz = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.eXz.oW(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper oW;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && oW != null) {
            oW.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            oW.setDownLoadStatus(3);
            bVar = this.eXz.eXx;
            bVar.D(oW);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.eXz.oW(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper oW;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && oW != null) {
            this.eXz.showToast(w.l.download_fail_tip);
            oW.setDownLoadStatus(0);
            bVar = this.eXz.eXx;
            bVar.D(oW);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.eXz.oW(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper oW;
        com.baidu.tbadk.mvc.f.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && oW != null) {
            if (i == 0) {
                this.eXz.showToast(w.l.plugin_installation_finished);
                viewEventCenter = this.eXz.bHa;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, oW, null, null));
                return;
            }
            this.eXz.showToast(String.valueOf(this.eXz.getPageContext().getString(w.l.plugin_installation_failed)) + str);
            oW.setDownLoadStatus(0);
            bVar = this.eXz.eXx;
            bVar.D(oW);
        }
    }
}
