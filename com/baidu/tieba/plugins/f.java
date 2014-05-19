package com.baidu.tieba.plugins;

import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ PluginDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PluginDetailActivity pluginDetailActivity) {
        this.a = pluginDetailActivity;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        PluginsConfig.PluginConfig pluginConfig;
        HeadImageView headImageView;
        HeadImageView headImageView2;
        if (aVar != null) {
            pluginConfig = this.a.l;
            if (str.equals(pluginConfig.icon)) {
                headImageView = this.a.a;
                headImageView.setTag(str);
                headImageView2 = this.a.a;
                headImageView2.invalidate();
            }
        }
    }
}
