package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity eKf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.eKf = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.eKf.pn(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper pn;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && pn != null) {
            pn.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            pn.setDownLoadStatus(3);
            bVar = this.eKf.eKd;
            bVar.D(pn);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.eKf.pn(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper pn;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && pn != null) {
            this.eKf.showToast(r.j.download_fail_tip);
            pn.setDownLoadStatus(0);
            bVar = this.eKf.eKd;
            bVar.D(pn);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.eKf.pn(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper pn;
        com.baidu.tbadk.mvc.f.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && pn != null) {
            if (i == 0) {
                this.eKf.showToast(r.j.plugin_installation_finished);
                viewEventCenter = this.eKf.aRj;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, pn, null, null));
                return;
            }
            this.eKf.showToast(String.valueOf(this.eKf.getPageContext().getString(r.j.plugin_installation_failed)) + str);
            pn.setDownLoadStatus(0);
            bVar = this.eKf.eKd;
            bVar.D(pn);
        }
    }
}
