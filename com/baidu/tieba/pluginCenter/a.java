package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.packageManager.d {
    final /* synthetic */ PluginCenterActivity cob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.cob = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.cob.jC(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper jC;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && jC != null) {
            jC.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            jC.setDownLoadStatus(3);
            bVar = this.cob.cnZ;
            bVar.z(jC);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.d
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.cob.jC(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper jC;
        com.baidu.tbadk.mvc.g.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && jC != null) {
            this.cob.showToast(i.C0057i.download_fail_tip);
            jC.setDownLoadStatus(0);
            bVar = this.cob.cnZ;
            bVar.z(jC);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.cob.jC(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper jC;
        com.baidu.tbadk.mvc.g.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && jC != null) {
            if (i == 0) {
                this.cob.showToast(i.C0057i.plugin_installation_finished);
                viewEventCenter = this.cob.aMt;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, jC, null, null));
                return;
            }
            this.cob.showToast(String.valueOf(this.cob.getPageContext().getString(i.C0057i.plugin_installation_failed)) + str);
            jC.setDownLoadStatus(0);
            bVar = this.cob.cnZ;
            bVar.z(jC);
        }
    }
}
