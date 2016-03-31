package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity dRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.dRD = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.dRD.ni(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper ni;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && ni != null) {
            ni.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            ni.setDownLoadStatus(3);
            bVar = this.dRD.dRB;
            bVar.A(ni);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.dRD.ni(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper ni;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && ni != null) {
            this.dRD.showToast(t.j.download_fail_tip);
            ni.setDownLoadStatus(0);
            bVar = this.dRD.dRB;
            bVar.A(ni);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.dRD.ni(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper ni;
        com.baidu.tbadk.mvc.g.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && ni != null) {
            if (i == 0) {
                this.dRD.showToast(t.j.plugin_installation_finished);
                viewEventCenter = this.dRD.bbj;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, ni, null, null));
                return;
            }
            this.dRD.showToast(String.valueOf(this.dRD.getPageContext().getString(t.j.plugin_installation_failed)) + str);
            ni.setDownLoadStatus(0);
            bVar = this.dRD.dRB;
            bVar.A(ni);
        }
    }
}
