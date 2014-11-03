package com.baidu.tieba.plugins;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ PluginDetailActivity bHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginDetailActivity pluginDetailActivity) {
        this.bHg = pluginDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bHg.closeActivity();
    }
}
