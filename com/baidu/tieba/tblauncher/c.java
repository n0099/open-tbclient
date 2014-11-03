package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ GuideActivity bOC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.bOC = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Hao123Plugin hao123Plugin;
        boolean z;
        Hao123Plugin hao123Plugin2;
        imageView = this.bOC.bOt;
        imageView2 = this.bOC.bOt;
        imageView.setSelected(!imageView2.isSelected());
        imageView3 = this.bOC.bOt;
        if (imageView3.isSelected()) {
            TbadkApplication.m251getInst().setTiebaHelperOpen(true);
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
            if (pluginByName != null && (hao123Plugin2 = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                hao123Plugin2.openFloating(this.bOC);
            }
            z = this.bOC.bsW;
            if (!z) {
                this.bOC.bsW = true;
                this.bOC.aeb();
            }
            com.baidu.tbadk.core.j.l(this.bOC, "tb_zs_loading");
            return;
        }
        TbadkApplication.m251getInst().setTiebaHelperOpen(false);
        Plugin pluginByName2 = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
        if (pluginByName2 != null && (hao123Plugin = (Hao123Plugin) pluginByName2.getClassInstance(Hao123Plugin.class)) != null) {
            hao123Plugin.closeFloating(this.bOC);
        }
    }
}
