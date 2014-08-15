package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.plugins.Hao123Plugin;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ GuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Hao123Plugin hao123Plugin;
        boolean z;
        Hao123Plugin hao123Plugin2;
        imageView = this.a.i;
        imageView2 = this.a.i;
        imageView.setSelected(!imageView2.isSelected());
        imageView3 = this.a.i;
        if (imageView3.isSelected()) {
            TbadkApplication.m252getInst().setTiebaHelperOpen(true);
            com.baidu.tbadk.pluginArch.c a = com.baidu.tbadk.pluginArch.d.a().a("hao123");
            if (a != null && (hao123Plugin2 = (Hao123Plugin) a.a(Hao123Plugin.class)) != null) {
                hao123Plugin2.openFloating(this.a);
            }
            z = this.a.l;
            if (!z) {
                this.a.l = true;
                this.a.f();
            }
            com.baidu.tbadk.core.f.a(this.a, "tb_zs_loading");
            return;
        }
        TbadkApplication.m252getInst().setTiebaHelperOpen(false);
        com.baidu.tbadk.pluginArch.c a2 = com.baidu.tbadk.pluginArch.d.a().a("hao123");
        if (a2 != null && (hao123Plugin = (Hao123Plugin) a2.a(Hao123Plugin.class)) != null) {
            hao123Plugin.closeFloating(this.a);
        }
    }
}
