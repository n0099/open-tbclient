package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes2.dex */
class m implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a fcM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginDownloadActivity.a aVar) {
        this.fcM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.fcM.aRP;
        linearLayout.setVisibility(8);
        linearLayout2 = this.fcM.fcE;
        linearLayout2.setVisibility(0);
    }
}
