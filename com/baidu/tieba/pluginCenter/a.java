package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity dUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.dUv = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.dUv.nh(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper nh;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && nh != null) {
            nh.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            nh.setDownLoadStatus(3);
            bVar = this.dUv.dUt;
            bVar.A((com.baidu.tbadk.mvc.g.b) nh);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.dUv.nh(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper nh;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && nh != null) {
            this.dUv.showToast(t.j.download_fail_tip);
            nh.setDownLoadStatus(0);
            bVar = this.dUv.dUt;
            bVar.A((com.baidu.tbadk.mvc.g.b) nh);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.dUv.nh(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper nh;
        com.baidu.tbadk.mvc.g.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && nh != null) {
            if (i == 0) {
                this.dUv.showToast(t.j.plugin_installation_finished);
                viewEventCenter = this.dUv.aXs;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, nh, null, null));
                return;
            }
            this.dUv.showToast(String.valueOf(this.dUv.getPageContext().getString(t.j.plugin_installation_failed)) + str);
            nh.setDownLoadStatus(0);
            bVar = this.dUv.dUt;
            bVar.A((com.baidu.tbadk.mvc.g.b) nh);
        }
    }
}
