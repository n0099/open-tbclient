package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class a implements com.baidu.adp.plugin.packageManager.e {
    final /* synthetic */ PluginCenterActivity fmK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.fmK = pluginCenterActivity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r0 = r5.fmK.qi(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper qi;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && bdFileDownloadData.getStatus() != 2 && qi != null) {
            qi.setDownLoadPercent((float) (bdFileDownloadData.getLength() / bdFileDownloadData.getSize()));
            qi.setDownLoadStatus(3);
            bVar = this.fmK.fmI;
            bVar.D(qi);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.e
    public void b(BdFileDownloadData bdFileDownloadData) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        r0 = r3.fmK.qi(r4.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(BdFileDownloadData bdFileDownloadData) {
        PluginConfigWrapper qi;
        com.baidu.tbadk.mvc.f.b bVar;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && qi != null) {
            this.fmK.showToast(w.l.download_fail_tip);
            qi.setDownLoadStatus(0);
            bVar = this.fmK.fmI;
            bVar.D(qi);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r5.fmK.qi(r6.getId());
     */
    @Override // com.baidu.adp.plugin.packageManager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
        PluginConfigWrapper qi;
        com.baidu.tbadk.mvc.f.b bVar;
        ViewEventCenter viewEventCenter;
        if (bdFileDownloadData != null && bdFileDownloadData.getId() != null && qi != null) {
            if (i == 0) {
                this.fmK.showToast(w.l.plugin_installation_finished);
                viewEventCenter = this.fmK.bSq;
                viewEventCenter.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, qi, null, null));
                return;
            }
            this.fmK.showToast(String.valueOf(this.fmK.getPageContext().getString(w.l.plugin_installation_failed)) + str);
            qi.setDownLoadStatus(0);
            bVar = this.fmK.fmI;
            bVar.D(qi);
        }
    }
}
