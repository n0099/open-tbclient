package com.baidu.tieba.pluginCenter;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tieba.pluginCenter.PluginDownloadActivity;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ PluginDownloadActivity.a cow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginDownloadActivity.a aVar) {
        this.cow = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        linearLayout = this.cow.aCW;
        linearLayout.setVisibility(8);
        linearLayout2 = this.cow.con;
        linearLayout2.setVisibility(0);
    }
}
